package com.sigtma.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.sigtma.entidades.TbCliente;

public interface ClientesDao extends CrudRepository<TbCliente,Integer>{

}
