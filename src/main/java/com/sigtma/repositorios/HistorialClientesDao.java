package com.sigtma.repositorios;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sigtma.dto.Bitacora;
import com.sigtma.dto.Historial;

@Transactional
public interface HistorialClientesDao extends CrudRepository<Bitacora, Integer> {
	
	@Query("SELECT COALESCE(MAX(id),'0') from Bitacora")
	public String getnumid();
	
}
