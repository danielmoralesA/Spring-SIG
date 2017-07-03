package com.sigtma.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.sigtma.dto.Bitacora;
import com.sigtma.dto.Clienteservicio;
import com.sigtma.dto.Exportacion;
import com.sigtma.dto.Nuevosclientes;
import com.sigtma.entidades.TbEmbarque;
import com.sigtma.entidades.TbEmpleado;
import com.sigtma.repositorios.ClientesservicioDao;
import com.sigtma.repositorios.ExportacioDao;
import com.sigtma.repositorios.HistorialClientesDao;
import com.sigtma.repositorios.NuevoClientesDao;
import com.sigtma.repositorios.TbEmbarqueDao;
import com.sigtma.repositorios.TbEmpleadoDao;

@Controller
public class TacticoController {
	
	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private HistorialClientesDao historepo;
	
	@Autowired
	private TbEmbarqueDao embarrepo;
	
	@Autowired
	private NuevoClientesDao nuevoclientedao;
	
	@Autowired
	private ExportacioDao expodao;
	
	@Autowired
	private ClientesservicioDao servicedao;
	
	@Autowired
	private TbEmpleadoDao empdao;
	
	@Autowired
	private DataSource dbsource;

	private static final String DATASOURCE = "datasource";
	
	//pagina principal para registrar la entrada para los usuarios tactico
	@RequestMapping("/tactico/tactico")
	public String principal(){
		return "tactico/tactico";
	}
	
	//pantalla principal para mostrar pagina con datos
	@RequestMapping("tactico/rep_productomayorexportacion")
	public String productomexpor(){
		return "tactico/rep_productomayorexportacion";
	}
	
	
	/*1 reporte tactico ----------------------------------------------*/
	@RequestMapping(value="/tactico/cap_paramsembarfecha", method=RequestMethod.GET)
	public ModelAndView parametrosemb(){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("tactico/cap_paramsembarfecha");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/tactico/cap_paramsembarfecha", method = RequestMethod.POST)
	public String validEmbFecha(@ModelAttribute Bitacora histo) throws ParseException{
		long acumulador=0;
        if(historepo.count()==0){
        histo.setId(1);
        }
        else
        	acumulador=historepo.count();
            //convertimo ese valor a entero
            int valor=(int) acumulador;
            histo.setId(valor+1);
		
		
		String fechax=histo.getFecha1();
		 String fechay=histo.getFecha2();
		 historepo.save(histo);
		 
		 return "redirect:/tactico/rep_embfecha/"+fechax+"/"+fechay;
		 
	
	}

	/*carga pantalla del reporte*/
	@RequestMapping(value="/tactico/rep_embfecha/{fechax}/{fechay}")
	public ModelAndView ReportesEmbFecha(@PathVariable String fechax, @PathVariable String fechay) throws ParseException{
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		
		//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
	//	List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findAll();
		List<TbEmbarque> list=(List<TbEmbarque>) embarrepo.findByFechasalidaBetween(fecha1, fecha2);
		return new ModelAndView("tactico/rep_embfecha","listclientes",list);
	}

	@RequestMapping(value="/reporte/embarques_fechaesp/pdf",method=RequestMethod.GET)
	public ModelAndView getReporteEmbarque() throws ParseException{
		JasperReportsPdfView view=new JasperReportsPdfView();
		view.setUrl("classpath:/salidas/tactico/rep_embfechaespecifica.jrxml");
		view.setApplicationContext(appContext);
		Bitacora bitacora=new Bitacora();
		int x=Integer.parseInt(historepo.getnumid());
		bitacora=historepo.findOne(x);
		String fechax=bitacora.getFecha1();
		String fechay=bitacora.getFecha2();
		
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		List<TbEmbarque> emb=embarrepo.findByFechasalidaBetween(fecha1, fecha2);
		int zx=emb.size();
		Map<String,Object> parms=new HashMap<>();
		parms.put("registros", zx);
		parms.put("user", user);
		parms.put("fecha1", fecha1);
		parms.put("fecha2", fecha2);
		parms.put("datasource",dbsource);		return new ModelAndView(view,parms);
		
	}
	
	/*3 reporte tactico --------------------------------------------------------*/
	/*---Exportacion--------------------------------------------------------*/
	
	@RequestMapping(value="/tactico/cap_paramexportar", method=RequestMethod.GET)
	public ModelAndView parametrosexportar(){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("tactico/cap_paramexportar");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/tactico/cap_paramexportar", method = RequestMethod.POST)
	public String validExpo(@ModelAttribute Bitacora histo) throws ParseException{
		long acumulador=0;
        if(historepo.count()==0){
        histo.setId(1);
        }
        else
        	acumulador=historepo.count();
            //convertimo ese valor a entero
            int valor=(int) acumulador;
            histo.setId(valor+1);
		
		
		String fechax=histo.getFecha1();
		 String fechay=histo.getFecha2();
		 historepo.save(histo);
		 
		 return "redirect:/tactico/rep_exportar/"+fechax+"/"+fechay;
		 
	
	}

	/*carga pantalla del reporte*/
	@RequestMapping(value="/tactico/rep_exportar/{fechax}/{fechay}")
	public ModelAndView ReportesExpo(@PathVariable String fechax, @PathVariable String fechay) throws ParseException{
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		
		//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
	//	List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findAll();
		List<Exportacion> list=(List<Exportacion>) expodao.findByFechasalidaBetween(fecha1, fecha2);
		return new ModelAndView("tactico/rep_exportar","listclientes",list);
	}

	@RequestMapping(value="/reporte/exportar/reporte",method=RequestMethod.GET)
	public ModelAndView Export() throws ParseException{
		JasperReportsPdfView view=new JasperReportsPdfView();
		view.setUrl("classpath:/salidas/tactico/rep_exportar.jrxml");
		view.setApplicationContext(appContext);
		Bitacora bitacora=new Bitacora();
		int x=Integer.parseInt(historepo.getnumid());
		bitacora=historepo.findOne(x);
		String fechax=bitacora.getFecha1();
		String fechay=bitacora.getFecha2();
		
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
	
		List<Exportacion> expo=expodao.findByFechasalidaBetween(fecha1, fecha2);
		
		int zx=expo.size();
		
		Map<String,Object> parms=new HashMap<>();
		
		parms.put("registros", zx);
		parms.put("user", user);
		parms.put("fecha1", fecha1);
		parms.put("fecha2", fecha2);
		parms.put("datasource",dbsource);
		return new ModelAndView(view,parms);
		
	}
	
	
	/*2 reporte tactico --------------------------------------------------------*/
	/*---Nuevos Clientes--------------------------------------------------------*/
	
	@RequestMapping(value="/tactico/cap_paramnuevosclientes", method=RequestMethod.GET)
	public ModelAndView parametrosnuevos(){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("tactico/cap_paramnuevosclientes");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/tactico/cap_paramnuevosclientes", method = RequestMethod.POST)
	public String validNuevo(@ModelAttribute Bitacora histo) throws ParseException{
		long acumulador=0;
        if(historepo.count()==0){
        histo.setId(1);
        }
        else
        	acumulador=historepo.count();
            //convertimo ese valor a entero
            int valor=(int) acumulador;
            histo.setId(valor+1);
		
		
		String fechax=histo.getFecha1();
		 String fechay=histo.getFecha2();
		 historepo.save(histo);
		 
		 return "redirect:/tactico/rep_nuevoclientes/"+fechax+"/"+fechay;
		 
	
	}

	/*carga pantalla del reporte*/
	@RequestMapping(value="/tactico/rep_nuevoclientes/{fechax}/{fechay}")
	public ModelAndView ReportesNuevos(@PathVariable String fechax, @PathVariable String fechay) throws ParseException{
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		
		//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
	//	List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findAll();
		List<Nuevosclientes> list=(List<Nuevosclientes>) nuevoclientedao.findByFechContratacionBetween(fecha1, fecha2);
		return new ModelAndView("tactico/rep_nuevoclientes","listclientes",list);
	}

	@RequestMapping(value="/reporte/nuevosclientes/reporte",method=RequestMethod.GET)
	public ModelAndView getNuevos() throws ParseException{
		JasperReportsPdfView view=new JasperReportsPdfView();
		view.setUrl("classpath:/salidas/tactico/rep_nuevosclientes.jrxml");
		view.setApplicationContext(appContext);
		Bitacora bitacora=new Bitacora();
		int x=Integer.parseInt(historepo.getnumid());
		bitacora=historepo.findOne(x);
		String fechax=bitacora.getFecha1();
		String fechay=bitacora.getFecha2();
		
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		Map<String,Object> parms=new HashMap<>();
		List<Nuevosclientes> nuevoc=nuevoclientedao.findByFechContratacionBetween(fecha1, fecha2);
		int zx=nuevoc.size();
		parms.put("registros", zx);
		parms.put("user", user);
		parms.put("fecha1", fecha1);
		parms.put("fecha2", fecha2);
		parms.put("datasource",dbsource);
	//	parms.put("datasource",nuevoclientedao.findByFechContratacionBetween(fechax, fechay));
		return new ModelAndView(view,parms);
		
	}
	

	/*4 reporte tactico --------------------------------------------------------*/
	/*---Servicio de tramites--------------------------------------------------------*/
	
	@RequestMapping(value="/tactico/cap_paramservicio", method=RequestMethod.GET)
	public ModelAndView parametrosservicio(){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("tactico/cap_paramservicio");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/tactico/cap_paramservicio", method = RequestMethod.POST)
	public String validNuevoService(@ModelAttribute Bitacora histo) throws ParseException{
		long acumulador=0;
        if(historepo.count()==0){
        histo.setId(1);
        }
        else
        	acumulador=historepo.count();
            //convertimo ese valor a entero
            int valor=(int) acumulador;
            histo.setId(valor+1);
		
		
		String fechax=histo.getFecha1();
		 String fechay=histo.getFecha2();
		 historepo.save(histo);
		 
		 return "redirect:/tactico/rep_servicio/"+fechax+"/"+fechay;
		 
	
	}

	/*carga pantalla del reporte*/
	@RequestMapping(value="/tactico/rep_servicio/{fechax}/{fechay}")
	public ModelAndView ReportesServicio(@PathVariable String fechax, @PathVariable String fechay) throws ParseException{
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		
		//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
	//	List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findAll();
		List<Clienteservicio> list=(List<Clienteservicio>) servicedao.findByFechacontractoBetween(fecha1, fecha2);
		return new ModelAndView("tactico/rep_servicio","listclientes",list);
	}

	@RequestMapping(value="/reporte/servicio/reporte",method=RequestMethod.GET)
	public ModelAndView getService() throws ParseException{
		JasperReportsPdfView view=new JasperReportsPdfView();
		view.setUrl("classpath:/salidas/tactico/rep_servicio.jrxml");
		view.setApplicationContext(appContext);
		Bitacora bitacora=new Bitacora();
		int x=Integer.parseInt(historepo.getnumid());
		bitacora=historepo.findOne(x);
		String fechax=bitacora.getFecha1();
		String fechay=bitacora.getFecha2();
		
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		List<Clienteservicio> service=servicedao.findByFechacontractoBetween(fecha1, fecha2);
		int zx=service.size();
		Map<String,Object> parms=new HashMap<>();
		parms.put("registros", zx);
		parms.put("user", user);
		parms.put("fecha1", fecha1);
		parms.put("fecha2", fecha2);
		parms.put("datasource",dbsource);
		return new ModelAndView(view,parms);
		
	}
	

	/*5 reporte tactico --------------------------------------------------------*/
	/*---Servicio de tramites--------------------------------------------------------*/
	
	@RequestMapping(value="/tactico/cap_paramempleado", method=RequestMethod.GET)
	public ModelAndView parametroempleado(){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("tactico/cap_paramempleado");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/tactico/cap_paramempleado", method = RequestMethod.POST)
	public String validNuevoEmp(@ModelAttribute Bitacora histo) throws ParseException{
		long acumulador=0;
        if(historepo.count()==0){
        histo.setId(1);
        }
        else
        	acumulador=historepo.count();
            //convertimo ese valor a entero
            int valor=(int) acumulador;
            histo.setId(valor+1);
		
		
		String fechax=histo.getFecha1();
		 String fechay=histo.getFecha2();
		 historepo.save(histo);
		 
		 return "redirect:/tactico/rep_emp/"+fechax+"/"+fechay;
		 
	
	}

	/*carga pantalla del reporte*/
	@RequestMapping(value="/tactico/rep_emp/{fechax}/{fechay}")
	public ModelAndView Reportesemp(@PathVariable String fechax, @PathVariable String fechay) throws ParseException{
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		
		//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
	//	List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findAll();
		List<TbEmpleado> list=(List<TbEmpleado>) empdao.findByFechaingresoBetween(fecha1, fecha2);
		return new ModelAndView("tactico/rep_emp","listclientes",list);
	}

	@RequestMapping(value="/reporte/servicio/emp",method=RequestMethod.GET)
	public ModelAndView getemp() throws ParseException{
		JasperReportsPdfView view=new JasperReportsPdfView();
		view.setUrl("classpath:/salidas/tactico/rep_emp.jrxml");
		view.setApplicationContext(appContext);
		Bitacora bitacora=new Bitacora();
		int x=Integer.parseInt(historepo.getnumid());
		bitacora=historepo.findOne(x);
		String fechax=bitacora.getFecha1();
		String fechay=bitacora.getFecha2();
		
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		List<TbEmpleado> emp=empdao.findByFechaingresoBetween(fecha1, fecha2);
		int zx=emp.size();
		Map<String,Object> parms=new HashMap<>();
		parms.put("registros", zx);
		parms.put("user", user);
		parms.put("fecha1", fecha1);
		parms.put("fecha2", fecha2);
		parms.put("datasource",dbsource);
		
		return new ModelAndView(view,parms);
		
	}
	

	/*6 reporte tactico --------------------------------------------------------*/
	/*---Servicio de tramites--------------------------------------------------------*/
	
	@RequestMapping(value="/tactico/cap_producto", method=RequestMethod.GET)
	public ModelAndView parametroproducto(){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("tactico/cap_producto");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/tactico/cap_producto", method = RequestMethod.POST)
	public String validNuevoProducto(@ModelAttribute Bitacora histo) throws ParseException{
		long acumulador=0;
        if(historepo.count()==0){
        histo.setId(1);
        }
        else
        	acumulador=historepo.count();
            //convertimo ese valor a entero
            int valor=(int) acumulador;
            histo.setId(valor+1);
		
		
		String fechax=histo.getFecha1();
		 String fechay=histo.getFecha2();
		 historepo.save(histo);
		 
		 return "redirect:/tactico/rep_producto/"+fechax+"/"+fechay;
		 
	
	}

	/*carga pantalla del reporte*/
	@RequestMapping(value="/tactico/rep_producto/{fechax}/{fechay}")
	public ModelAndView ReportesP(@PathVariable String fechax, @PathVariable String fechay) throws ParseException{
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		
		//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
	//	List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findAll();
		List<TbEmbarque> list=(List<TbEmbarque>) embarrepo.findByFechasalidaBetween(fecha1, fecha2);
		return new ModelAndView("tactico/rep_producto","listclientes",list);
	}

	@RequestMapping(value="/reporte/servicio/producto",method=RequestMethod.GET)
	public ModelAndView getP() throws ParseException{
		JasperReportsPdfView view=new JasperReportsPdfView();
		view.setUrl("classpath:/salidas/tactico/rep_producto.jrxml");
		view.setApplicationContext(appContext);
		Bitacora bitacora=new Bitacora();
		int x=Integer.parseInt(historepo.getnumid());
		bitacora=historepo.findOne(x);
		String fechax=bitacora.getFecha1();
		String fechay=bitacora.getFecha2();
		
		SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
	    Date fecha1=dx.parse(fechax);
		Date fecha2=dx.parse(fechay);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		Map<String,Object> parms=new HashMap<>();
		
		List<TbEmbarque> emb=embarrepo.findByFechasalidaBetween(fecha1, fecha2);
		
		int zx=emb.size();
		parms.put("registros", zx);
		parms.put("user", user);
		parms.put("fecha1", fecha1);
		parms.put("fecha2", fecha2);
		parms.put("datasource",dbsource);
		return new ModelAndView(view,parms);
		
	}
	
	
}
