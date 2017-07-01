package com.sigtma.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sigtma.entidades.Usuarios;

@Transactional
//@Repository("usuariosDao")
public interface UsuariosDao extends CrudRepository<Usuarios,Integer> {
	Usuarios findByNomUsuario(String nombre);
	Usuarios findFirstByNomUsuario(String nombre);
	
}
