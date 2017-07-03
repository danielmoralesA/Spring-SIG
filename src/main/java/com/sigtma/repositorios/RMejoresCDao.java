package com.sigtma.repositorios;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sigtma.entidades.Mejoresclientes;
import com.sigtma.entidades.RMejoresclientes;

@Repository
public interface RMejoresCDao extends CrudRepository<Mejoresclientes,Integer> {
	@Query("SELECT g from Mejoresclientes g WHERE g.fechaventa BETWEEN :fechaEmbarque1 and :fechaEmbarque2")
	public List<Mejoresclientes> FindByFechaventaBetween(@Param("fechaEmbarque1") Date fecha1,@Param("fechaEmbarque2")Date fecha2);
}
