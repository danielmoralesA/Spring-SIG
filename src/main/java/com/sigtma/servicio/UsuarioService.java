package com.sigtma.servicio;
import com.sigtma.entidades.Usuarios;
import com.sigtma.entidades.Roles;


public interface UsuarioService {
	public Usuarios findUsuarioByNombre(String nombre);
	public void save(Usuarios usuario,Roles roles);
}
