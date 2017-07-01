package com.sigtma.controller;

import org.springframework.context.ApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.ibm.icu.util.Calendar;
import com.sigtma.dto.Bitacora;
import com.sigtma.dto.Clientemora;
import com.sigtma.dto.Clientenosevicio;
import com.sigtma.dto.Gananciasmensuales;
import com.sigtma.dto.Historial;
import com.sigtma.entidades.Mejoresclientes;
import com.sigtma.entidades.RMejoresclientes;
import com.sigtma.entidades.TbEmbarque;
import com.sigtma.repositorios.HistorialClientesDao;
import com.sigtma.repositorios.RMejoresCDao;
import com.sigtma.repositorios.TbEmbarqueDao;
import com.sigtma.repositorios.ClientemoraDao;
import com.sigtma.repositorios.ClientenosevicioDao;
import com.sigtma.repositorios.GananciasDao;

import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EstrategicoController {
	
	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private RMejoresCDao rmejor;
	
	@Autowired
	private HistorialClientesDao historepo;
	
	@Autowired
	private GananciasDao ganarepo;
	
	@Autowired
	private TbEmbarqueDao embarrepo;
	
	@Autowired
	private ClientenosevicioDao clientedao;
	
	@Autowired
	private ClientemoraDao clientemoradao;
	
	
	
	private Bitacora histo;
	//para la entrada de parametros
	@RequestMapping(value="/estrategico/cap_parametros", method=RequestMethod.GET)
	public ModelAndView parametros(){
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("estrategico/cap_parametros");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/estrategico/estrategico")
	public String estrategico()
	{
		return "estrategico/estrategico";
	}
	
	
	//para cargar la pagina principal
		@RequestMapping(value="/estrategico/cap_parametros", method = RequestMethod.POST)
		public String validFechas(@ModelAttribute Bitacora histo) throws ParseException{
			ModelAndView modelAndView=new ModelAndView();
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
		    String fechay=histo.getFecha1();
			historepo.save(histo);
				
			return "redirect:/estrategico/rep_mejoresclientes";
			
		}
		
   //aqui ira la parte para generar los reportes de jasperreport
   //con eso solo faltara solo las validaciones
   //falta los demas metodos que se necesita para generar las funciones
		
  //@RequestMapping(value="/estrategico/cap_parametros",method=RequestMethod.GET)
  //public String parametrosCliente()
		
  //para cargar la pagina con los datos con los datos
 /* @RequestMapping(value="/estrategico/rep_mejoresclientes")
  public String reportesalida(){
	  return "estrategico/rep_mejoresclientes/rep_mejores";
	  
  }*/
		@RequestMapping(value="/estrategico/rep_mejoresclientes")
		public ModelAndView ReportesMClientes() throws ParseException{
			SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
		//	Date fechaz=dx.parse(fecha1);
			//Date fecha2=dx.parse(fechaz);
			
			
			//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
			List<Mejoresclientes> list=(List<Mejoresclientes>) rmejor.findAll();
			return new ModelAndView("estrategico/rep_mejoresclientes","listclientes",list);
		}
		
		@RequestMapping(value="/reporte/pdf",method=RequestMethod.GET)
		public ModelAndView getReporte(){
			JasperReportsPdfView view=new JasperReportsPdfView();
			view.setUrl("classpath:/salidas/estrategico/rep_clientesmejores.jrxml");
			view.setApplicationContext(appContext);
			Map<String,Object> parms=new HashMap<>();
			parms.put("datasource",rmejor.findAll());
			return new ModelAndView(view,parms);
			
		}
		
		/*salidad de la segunda pantalla de parametros */
		@RequestMapping(value="/estrategico/cap_paramganancias", method=RequestMethod.GET)
		public ModelAndView parametrosgan(){
			ModelAndView modelAndView =new ModelAndView();
			modelAndView.setViewName("estrategico/cap_paramganancias");
			return modelAndView;
			
		}
		
		/*metodo post para entrada de parametros */
		@RequestMapping(value="/estrategico/cap_paramganancias", method = RequestMethod.POST)
		public String validFechasGanan(@ModelAttribute Bitacora histo) throws ParseException{
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
			 
			 return "redirect:/estrategico/rep_ganancias/"+fechax+"/"+fechay;
			 
		
		}
	
		/*carga pantalla del reporte*/
		@RequestMapping(value="/estrategico/rep_ganancias/{fechax}/{fechay}")
		public ModelAndView ReportesGanancias(@PathVariable String fechax, @PathVariable String fechay) throws ParseException{
			SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
		    Date fecha1=dx.parse(fechax);
			Date fecha2=dx.parse(fechay);
			
			
			//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
		//	List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findAll();
			List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findByFechaEmbarqueBetween(fecha1, fecha2);
			return new ModelAndView("estrategico/rep_ganancias","listclientes",list);
		}
  
		@RequestMapping(value="/reporte/ganancias/pdf",method=RequestMethod.GET)
		public ModelAndView getReporteGanancias() throws ParseException{
			JasperReportsPdfView view=new JasperReportsPdfView();
			view.setUrl("classpath:/salidas/estrategico/rep_gananciasmensuales.jrxml");
			view.setApplicationContext(appContext);
			Bitacora bitacora=new Bitacora();
			int x=Integer.parseInt(historepo.getnumid());
			bitacora=historepo.findOne(x);
			String fecha1=bitacora.getFecha1();
			String fecha2=bitacora.getFecha2();
			
			SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
		    Date fechax=dx.parse(fecha1);
			Date fechay=dx.parse(fecha2);
			
			Map<String,Object> parms=new HashMap<>();
			parms.put("datasource",ganarepo.findByFechaEmbarqueBetween(fechax, fechay));
			return new ModelAndView(view,parms);
			
		}
		
	
		
		
		/*3 reporte estrategico ---------------------------------------------*/
		@RequestMapping(value="/estrategico/cap_paramnoservicio", method=RequestMethod.GET)
		public ModelAndView parametrosemb(){
			ModelAndView modelAndView =new ModelAndView();
			modelAndView.setViewName("estrategico/cap_paramnoservicio");
			return modelAndView;
			
		}
		
		
		@RequestMapping(value="/estrategico/cap_paramnoservicio", method = RequestMethod.POST)
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
			 
			 return "redirect:/estrategico/rep_noservicio/"+fechax+"/"+fechay;
			 
		
		}

		/*carga pantalla del reporte*/
		@RequestMapping(value="/estrategico/rep_noservicio/{fechax}/{fechay}")
		public ModelAndView ReportesEmbFecha(@PathVariable String fechax, @PathVariable String fechay) throws ParseException{
			SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
		    Date fecha1=dx.parse(fechax);
			Date fecha2=dx.parse(fechay);
			
			
			//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
		//	List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findAll();
			List<Clientenosevicio> list=(List<Clientenosevicio>) clientedao.findByFechUltimemBetween(fecha1, fecha2);
			return new ModelAndView("estrategico/rep_noservicio","listclientes",list);
		}

		@RequestMapping(value="/reporte/noservicio/pdf",method=RequestMethod.GET)
		public ModelAndView getReporteEmbarque() throws ParseException{
			JasperReportsPdfView view=new JasperReportsPdfView();
			view.setUrl("classpath:/salidas/estrategico/rep_clientenoservicio.jrxml");
			view.setApplicationContext(appContext);
			Bitacora bitacora=new Bitacora();
			int x=Integer.parseInt(historepo.getnumid());
			bitacora=historepo.findOne(x);
			String fecha1=bitacora.getFecha1();
			String fecha2=bitacora.getFecha2();
			
			SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
		    Date fechax=dx.parse(fecha1);
			Date fechay=dx.parse(fecha2);
			
			Map<String,Object> parms=new HashMap<>();
			parms.put("datasource",clientedao.findByFechUltimemBetween(fechax, fechay));
			return new ModelAndView(view,parms);
			
		}


		/*4 reporte estrategico ---------------------------------------------*/
		@RequestMapping(value="/estrategico/cap_paramclientemora", method=RequestMethod.GET)
		public ModelAndView parametromora(){
			ModelAndView modelAndView =new ModelAndView();
			modelAndView.setViewName("estrategico/cap_paramclientemora");
			return modelAndView;
			
		}
		
		
		@RequestMapping(value="/estrategico/cap_paramclientemora", method = RequestMethod.POST)
		public String validMoraFecha(@ModelAttribute Bitacora histo) throws ParseException{
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
			 
			 return "redirect:/estrategico/rep_clientemora/"+fechax+"/"+fechay;
			 
		
		}

		/*carga pantalla del reporte*/
		@RequestMapping(value="/estrategico/rep_clientemora/{fechax}/{fechay}")
		public ModelAndView ReportesMoraFecha(@PathVariable String fechax, @PathVariable String fechay) throws ParseException{
			SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
		    Date fecha1=dx.parse(fechax);
			Date fecha2=dx.parse(fechay);
			
			
			//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
		//	List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findAll();
			List<Clientemora> list=(List<Clientemora>) clientemoradao.findByFechContratacionBetween(fecha1, fecha2);
			return new ModelAndView("estrategico/rep_clientemora","listclientes",list);
		}

		@RequestMapping(value="/reporte/clientemora/pdf",method=RequestMethod.GET)
		public ModelAndView getReporteMora() throws ParseException{
			JasperReportsPdfView view=new JasperReportsPdfView();
			view.setUrl("classpath:/salidas/estrategico/rep_clientesenmora.jrxml");
			view.setApplicationContext(appContext);
			Bitacora bitacora=new Bitacora();
			int x=Integer.parseInt(historepo.getnumid());
			bitacora=historepo.findOne(x);
			String fecha1=bitacora.getFecha1();
			String fecha2=bitacora.getFecha2();
			
			SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
		    Date fechax=dx.parse(fecha1);
			Date fechay=dx.parse(fecha2);
			
			Map<String,Object> parms=new HashMap<>();
			parms.put("datasource",clientemoradao.findByFechContratacionBetween(fechax, fechay));
			return new ModelAndView(view,parms);
			
		}

		/*5 reporte estrategico ---------------------------------------------*/
		@RequestMapping(value="/estrategico/cap_paramembarque", method=RequestMethod.GET)
		public ModelAndView parametroEmb(){
			ModelAndView modelAndView =new ModelAndView();
			modelAndView.setViewName("estrategico/cap_paramembarque");
			return modelAndView;
			
		}
		
		
		@RequestMapping(value="/estrategico/cap_paramembarque", method = RequestMethod.POST)
		public String validEmp(@ModelAttribute Bitacora histo) throws ParseException{
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
			 
			 return "redirect:/estrategico/rep_embarque/"+fechax+"/"+fechay;
			 
		
		}

		/*carga pantalla del reporte*/
		@RequestMapping(value="/estrategico/rep_embarque/{fechax}/{fechay}")
		public ModelAndView Reportesemnarque(@PathVariable String fechax, @PathVariable String fechay) throws ParseException{
			SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
		    Date fecha1=dx.parse(fechax);
			Date fecha2=dx.parse(fechay);
			
			
			//List<RMejoresclientes> list=(List<RMejoresclientes>) rmejor.findByFechaventaBetween(fecha1, f);
		//	List<Gananciasmensuales> list=(List<Gananciasmensuales>) ganarepo.findAll();
			List<TbEmbarque> list=(List<TbEmbarque>) embarrepo.findByFechasalidaBetween(fecha1, fecha2);
			return new ModelAndView("estrategico/rep_embarque","listclientes",list);
		}

		@RequestMapping(value="/reporte/embarque/pdf",method=RequestMethod.GET)
		public ModelAndView getReporteemb() throws ParseException{
			JasperReportsPdfView view=new JasperReportsPdfView();
			view.setUrl("classpath:/salidas/estrategico/rep_embarque.jrxml");
			view.setApplicationContext(appContext);
			Bitacora bitacora=new Bitacora();
			int x=Integer.parseInt(historepo.getnumid());
			bitacora=historepo.findOne(x);
			String fecha1=bitacora.getFecha1();
			String fecha2=bitacora.getFecha2();
			
			SimpleDateFormat dx=new SimpleDateFormat("yyyy-mm-dd");
		    Date fechax=dx.parse(fecha1);
			Date fechay=dx.parse(fecha2);
			
			Map<String,Object> parms=new HashMap<>();
			parms.put("datasource",embarrepo.findByFechasalidaBetween(fechax, fechay));
			return new ModelAndView(view,parms);
			
		}
		
}
