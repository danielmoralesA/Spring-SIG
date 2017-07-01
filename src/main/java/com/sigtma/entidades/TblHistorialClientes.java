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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_historial_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblHistorialClientes.findAll", query = "SELECT t FROM TblHistorialClientes t")
    , @NamedQuery(name = "TblHistorialClientes.findByIdhistorial", query = "SELECT t FROM TblHistorialClientes t WHERE t.idhistorial = :idhistorial")
    
    , @NamedQuery(name = "TblHistorialClientes.findByFechUltimem", query = "SELECT t FROM TblHistorialClientes t WHERE t.fechUltimem = :fechUltimem")
    , @NamedQuery(name = "TblHistorialClientes.findByFechUktimemBetween", query="SELECT t FROM TblHistorialClientes t WHERE t.fechUltimem Between :fechUltimem and :fechUltimem")
    })
public class TblHistorialClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhistorial")
    private Integer idhistorial;
    //
    //@Column(name = "idcliente")
    @JoinColumn(name="idcliente",referencedColumnName="codcliente")
    @ManyToOne
    private TbCliente idcliente;
    @Basic(optional = false)
    @Column(name = "fech_ultimem")
    @Temporal(TemporalType.DATE)
    private Date fechUltimem;

    public TblHistorialClientes() {
    }

    public TblHistorialClientes(Integer idhistorial) {
        this.idhistorial = idhistorial;
    }

    public TblHistorialClientes(Integer idhistorial, Date fechUltimem) {
        this.idhistorial = idhistorial;
        this.fechUltimem = fechUltimem;
    }

    public Integer getIdhistorial() {
        return idhistorial;
    }

    public void setIdhistorial(Integer idhistorial) {
        this.idhistorial = idhistorial;
    }

    public void setIdCliente(TbCliente idcliente){
    	this.idcliente=idcliente;
    }
    
    public TbCliente getIdcliente(){
    	return idcliente;
    }

    public Date getFechUltimem() {
        return fechUltimem;
    }

    public void setFechUltimem(Date fechUltimem) {
        this.fechUltimem = fechUltimem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistorial != null ? idhistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblHistorialClientes)) {
            return false;
        }
        TblHistorialClientes other = (TblHistorialClientes) object;
        if ((this.idhistorial == null && other.idhistorial != null) || (this.idhistorial != null && !this.idhistorial.equals(other.idhistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigtma.entidades.TblHistorialClientes[ idhistorial=" + idhistorial + " ]";
    }
    
}
