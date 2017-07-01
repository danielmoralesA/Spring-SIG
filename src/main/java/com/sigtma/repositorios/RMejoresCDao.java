package com.sigtma.repositorios;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sigtma.entidades.Mejoresclientes;
import com.sigtma.entidades.RMejoresclientes;

@Transactional
public interface RMejoresCDao extends CrudRepository<Mejoresclientes,Integer> {
	public Mejoresclientes findByFechaventaBetween(Date fecha1,Date fecha2);
}
