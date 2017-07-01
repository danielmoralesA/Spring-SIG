/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigtma.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "tb_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCliente.findAll", query = "SELECT t FROM TbCliente t")
    , @NamedQuery(name = "TbCliente.findByCodcliente", query = "SELECT t FROM TbCliente t WHERE t.codcliente = :codcliente")
    , @NamedQuery(name = "TbCliente.findByNomCliente", query = "SELECT t FROM TbCliente t WHERE t.nomCliente = :nomCliente")
    , @NamedQuery(name = "TbCliente.findByDireccion", query = "SELECT t FROM TbCliente t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TbCliente.findByTelefono", query = "SELECT t FROM TbCliente t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TbCliente.findByCorreo", query = "SELECT t FROM TbCliente t WHERE t.correo = :correo")
    , @NamedQuery(name = "TbCliente.findByEstado", query = "SELECT t FROM TbCliente t WHERE t.estado = :estado")
    , @NamedQuery(name = "TbCliente.findByFechContratacion", query = "SELECT t FROM TbCliente t WHERE t.fechContratacion = :fechContratacion")})
public class TbCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codcliente")
    private String codcliente;
    @Basic(optional = false)
    @Column(name = "nom_cliente")
    private String nomCliente;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "fech_contratacion")
    @Temporal(TemporalType.DATE)
    private Date fechContratacion;

    public TbCliente() {
    }

    public TbCliente(String codcliente) {
        this.codcliente = codcliente;
    }

    public TbCliente(String codcliente, String nomCliente, String direccion, int telefono, String correo) {
        this.codcliente = codcliente;
        this.nomCliente = nomCliente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechContratacion() {
        return fechContratacion;
    }

    public void setFechContratacion(Date fechContratacion) {
        this.fechContratacion = fechContratacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcliente != null ? codcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCliente)) {
            return false;
        }
        TbCliente other = (TbCliente) object;
        if ((this.codcliente == null && other.codcliente != null) || (this.codcliente != null && !this.codcliente.equals(other.codcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigtma.entidades.TbCliente[ codcliente=" + codcliente + " ]";
    }
    
}
