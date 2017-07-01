package com.sigtma.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sigtma.dto.Clientenosevicio;

@Transactional
public interface ClientenosevicioDao extends CrudRepository<Clientenosevicio,Integer> {
	@Query("SELECT g from Clientenosevicio g WHERE g.fechUltimem BETWEEN :fechasalida1 and :fechasalida2")
	public List<Clientenosevicio> findByFechUltimemBetween(@Param("fechasalida1") Date fecha1,@Param("fechasalida2") Date fecha2);
	
}
