package com.sigtma.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sigtma.dto.Clientemora;
import com.sigtma.dto.Gananciasmensuales;

@Repository
public interface ClientemoraDao extends CrudRepository<Clientemora,Integer> {
	
	@Query("SELECT g from Clientemora g WHERE g.fechContratacion BETWEEN :fechaEmbarque1 and :fechaEmbarque2")
	public List<Clientemora> findByFechContratacionBetween(@Param("fechaEmbarque1") Date fecha1,@Param("fechaEmbarque2") Date fecha2);
	
	
	
}
