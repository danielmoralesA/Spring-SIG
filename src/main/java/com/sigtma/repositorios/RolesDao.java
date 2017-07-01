package com.sigtma.repositorios;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sigtma.entidades.Roles;

@Transactional
//@Repository("rolesDao")
public interface RolesDao extends CrudRepository<Roles, Integer> {
	public Roles findFirstByNomRol(String nombre);
	public Roles findByNomRol(String nombre);
	
}
