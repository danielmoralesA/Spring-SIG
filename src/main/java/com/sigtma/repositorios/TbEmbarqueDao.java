package com.sigtma.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sigtma.dto.Gananciasmensuales;
import com.sigtma.entidades.TbEmbarque;

@Transactional
public interface TbEmbarqueDao extends CrudRepository<TbEmbarque,Integer>{
	@Query("SELECT g from TbEmbarque g WHERE g.fechasalida BETWEEN :fechasalida1 and :fechasalida2")
	public List<TbEmbarque> findByFechasalidaBetween(@Param("fechasalida1") Date fecha1,@Param("fechasalida2") Date fecha2);
}
