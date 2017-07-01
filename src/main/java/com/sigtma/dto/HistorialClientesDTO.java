package com.sigtma.dto;

import java.util.Date;

public final class HistorialClientesDTO {
	private Integer id;
	private String nomCliente;
	private Date UltimaFecha;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public Date getUltimaFecha() {
		return UltimaFecha;
	}
	public void setUltimaFecha(Date ultimaFecha) {
		UltimaFecha = ultimaFecha;
	}
	
	
	
	
}
