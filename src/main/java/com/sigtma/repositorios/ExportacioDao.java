package com.sigtma.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sigtma.dto.Clienteservicio;
import com.sigtma.dto.Exportacion;

@Repository
public interface ExportacioDao extends CrudRepository<Exportacion, Integer>{

	
	@Query("SELECT g from Exportacion g WHERE g.fechasalida BETWEEN :fechaEmbarque1 and :fechaEmbarque2")
	public List<Exportacion> findByFechasalidaBetween(@Param("fechaEmbarque1") Date fecha1,@Param("fechaEmbarque2") Date fecha2);
	
}
