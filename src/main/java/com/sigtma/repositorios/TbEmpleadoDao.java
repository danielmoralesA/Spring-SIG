package com.sigtma.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sigtma.dto.Clienteservicio;
import com.sigtma.entidades.TbEmpleado;

@Repository
public interface TbEmpleadoDao extends CrudRepository<TbEmpleado,Integer>{


	@Query("SELECT g from TbEmpleado g WHERE g.fechaingreso BETWEEN :fechaEmbarque1 and :fechaEmbarque2")
	public List<TbEmpleado> findByFechaingresoBetween(@Param("fechaEmbarque1") Date fecha1,@Param("fechaEmbarque2") Date fecha2);
	
}
