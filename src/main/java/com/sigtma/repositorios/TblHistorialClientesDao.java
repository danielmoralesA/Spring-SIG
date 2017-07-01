package com.sigtma.repositorios;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sigtma.entidades.TblHistorialClientes;

@Transactional
public interface TblHistorialClientesDao extends CrudRepository<TblHistorialClientes, Integer> {
	//la consulta esta en la entidad para obtener la fechas en un rango 
	TblHistorialClientes findByFechUltimemBetween(Date fecha1,Date fecha2);
}
