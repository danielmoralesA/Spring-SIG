/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigtma.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "tb_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFactura.findAll", query = "SELECT t FROM TbFactura t")
    , @NamedQuery(name = "TbFactura.findByIdfactura", query = "SELECT t FROM TbFactura t WHERE t.idfactura = :idfactura")
    
    , @NamedQuery(name = "TbFactura.findByMontocancelado", query = "SELECT t FROM TbFactura t WHERE t.montocancelado = :montocancelado")
    , @NamedQuery(name = "TbFactura.findByMontocobrar", query = "SELECT t FROM TbFactura t WHERE t.montocobrar = :montocobrar")
    , @NamedQuery(name = "TbFactura.findByFechaventa", query = "SELECT t FROM TbFactura t WHERE t.fechaventa = :fechaventa")
    , @NamedQuery(name = "TbFactura.findByEnvio", query = "SELECT t FROM TbFactura t WHERE t.envio = :envio")})
public class TbFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @JoinColumn(name="idcliente",referencedColumnName="codcliente")
    @ManyToOne
    private TbCliente idcliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montocancelado")
    private Double montocancelado;
    @Column(name = "montocobrar")
    private Double montocobrar;
    @Basic(optional = false)
    @Column(name = "fechaventa")
    @Temporal(TemporalType.DATE)
    private Date fechaventa;
    @Column(name = "envio")
    private Boolean envio;
    @OneToMany(mappedBy = "idfactura")
    private Collection<TbEmpleado> tbEmpleadoCollection;
    @OneToMany(mappedBy = "idfactura")
    private Collection<TbEmbarque> tbEmbarqueCollection;

    public TbFactura() {
    }

    public TbFactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public TbFactura(Integer idfactura, Date fechaventa) {
        this.idfactura = idfactura;
        this.fechaventa = fechaventa;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public TbCliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(TbCliente idcliente) {
        this.idcliente = idcliente;
    }

    public Double getMontocancelado() {
        return montocancelado;
    }

    public void setMontocancelado(Double montocancelado) {
        this.montocancelado = montocancelado;
    }

    public Double getMontocobrar() {
        return montocobrar;
    }

    public void setMontocobrar(Double montocobrar) {
        this.montocobrar = montocobrar;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public Boolean getEnvio() {
        return envio;
    }

    public void setEnvio(Boolean envio) {
        this.envio = envio;
    }

    @XmlTransient
    public Collection<TbEmpleado> getTbEmpleadoCollection() {
        return tbEmpleadoCollection;
    }

    public void setTbEmpleadoCollection(Collection<TbEmpleado> tbEmpleadoCollection) {
        this.tbEmpleadoCollection = tbEmpleadoCollection;
    }

    @XmlTransient
    public Collection<TbEmbarque> getTbEmbarqueCollection() {
        return tbEmbarqueCollection;
    }

    public void setTbEmbarqueCollection(Collection<TbEmbarque> tbEmbarqueCollection) {
        this.tbEmbarqueCollection = tbEmbarqueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFactura)) {
            return false;
        }
        TbFactura other = (TbFactura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigtma.entidades.TbFactura[ idfactura=" + idfactura + " ]";
    }
    
}
