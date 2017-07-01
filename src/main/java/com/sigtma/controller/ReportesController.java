package com.sigtma.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.sigtma.entidades.TbCliente;
import com.sigtma.entidades.TblHistorialClientes;
import com.sigtma.repositorios.TblHistorialClientesDao;

@Controller
@RequestMapping("/reporte")
public class ReportesController {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private TblHistorialClientesDao tblhistoDao;
	
//	@Autowired
//	private
	
	@ExceptionHandler()
	 @RequestMapping(value="/pdf", method=RequestMethod.GET,produces="application/pdf")
	  public ModelAndView reportes(@PathVariable ("fecha1") Date Fecha1,@PathVariable("fecha2") Date Fecha2){
		  Map<String,Date> model=new HashMap<>();
		  model.put("fecha", Fecha1);
		  model.put("fecha", Fecha2);
		  //levantamos el preview
		  JasperReportsPdfView view=new JasperReportsPdfView();
		  view.setJdbcDataSource(dataSource);
		  	
		  //conseguire datos del cliente
			  
		  
		  //aqui ira la validacion mediante un if
	
		  
		  
		  view.setUrl("classpath:/salidas/estrategico/rep_mejoresclientes.jrxml");
		  view.setApplicationContext(appContext);
		  
		  //reporte de prueba
		  
		  Map<String,Object> params =new HashMap<>();
		  return new ModelAndView(view,model);
		
	}
}
