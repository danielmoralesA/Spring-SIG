package com.sigtma.repositorios;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sigtma.dto.Gananciasmensuales;
import com.sigtma.entidades.Mejoresclientes;

@Repository
public interface GananciasDao extends CrudRepository<Gananciasmensuales,Integer> {

	@Query("SELECT g from Gananciasmensuales g WHERE g.fechaEmbarque BETWEEN :fechaEmbarque1 and :fechaEmbarque2")
	public List<Gananciasmensuales> findByFechaEmbarqueBetween(@Param("fechaEmbarque1") Date fecha1,@Param("fechaEmbarque2") Date fecha2);
	
}
