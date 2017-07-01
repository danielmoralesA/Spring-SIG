package com.sigtma.servicio;

import com.sigtma.entidades.Usuarios;

import com.sigtma.entidades.Roles;
import java.util.List;

import com.sigtma.repositorios.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class UsuarioServiceImp implements UsuarioService{
	@Autowired
	private UsuariosDao userRepository;
	@Autowired
	private RolesDao roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    private Roles rol;
	
    @Override
	public void save(Usuarios usuario,Roles roles) {
    	//usuario.setIdUsuario(1);
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		usuario.setActivo(1);
		//rol=roleRepository.findFirstByNomRol("ADMIN");
		usuario.setRoles(new HashSet<Roles>(Arrays.asList(roles)));
	
		userRepository.save(usuario);
		
	}
    
    
	@Override
	public Usuarios findUsuarioByNombre(String nombre) {
		Usuarios user=userRepository.findFirstByNomUsuario(nombre);
		if(user==null){
			return null;
		}
		return user;
	} 
}
