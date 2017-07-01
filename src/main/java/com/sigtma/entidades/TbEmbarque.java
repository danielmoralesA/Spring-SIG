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
@Table(name = "tb_embarque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEmbarque.findAll", query = "SELECT t FROM TbEmbarque t")
    , @NamedQuery(name = "TbEmbarque.findByIdembarq", query = "SELECT t FROM TbEmbarque t WHERE t.idembarq = :idembarq")
    , @NamedQuery(name = "TbEmbarque.findByNcontenedor", query = "SELECT t FROM TbEmbarque t WHERE t.ncontenedor = :ncontenedor")
    , @NamedQuery(name = "TbEmbarque.findByPesokgs", query = "SELECT t FROM TbEmbarque t WHERE t.pesokgs = :pesokgs")
    , @NamedQuery(name = "TbEmbarque.findByVolumenmc", query = "SELECT t FROM TbEmbarque t WHERE t.volumenmc = :volumenmc")
    , @NamedQuery(name = "TbEmbarque.findByDescripcion", query = "SELECT t FROM TbEmbarque t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TbEmbarque.findByTipoembarq", query = "SELECT t FROM TbEmbarque t WHERE t.tipoembarq = :tipoembarq")
    , @NamedQuery(name = "TbEmbarque.findByFechasalida", query = "SELECT t FROM TbEmbarque t WHERE t.fechasalida = :fechasalida")
    , @NamedQuery(name = "TbEmbarque.findByTarifacobro", query = "SELECT t FROM TbEmbarque t WHERE t.tarifacobro = :tarifacobro")})
public class TbEmbarque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idembarq")
    private Integer idembarq;
    @Basic(optional = false)
    @Column(name = "ncontenedor")
    private String ncontenedor;
    @Basic(optional = false)
    @Column(name = "pesokgs")
    private double pesokgs;
    @Basic(optional = false)
    @Column(name = "volumenmc")
    private double volumenmc;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "tipoembarq")
    private String tipoembarq;
    @Basic(optional = false)
    @Column(name = "fechasalida")
    @Temporal(TemporalType.DATE)
    private Date fechasalida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tarifacobro")
    private Double tarifacobro;
    @JoinColumn(name = "idfactura", referencedColumnName = "idfactura")
    @ManyToOne
    private TbFactura idfactura;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne
    private TbPais idpais;
    @JoinColumn(name = "idproduct", referencedColumnName = "idproducto")
    @ManyToOne
    private TbProduct idproduct;

    public TbEmbarque() {
    }

    public TbEmbarque(Integer idembarq) {
        this.idembarq = idembarq;
    }

    public TbEmbarque(Integer idembarq, String ncontenedor, double pesokgs, double volumenmc, String descripcion, String tipoembarq, Date fechasalida) {
        this.idembarq = idembarq;
        this.ncontenedor = ncontenedor;
        this.pesokgs = pesokgs;
        this.volumenmc = volumenmc;
        this.descripcion = descripcion;
        this.tipoembarq = tipoembarq;
        this.fechasalida = fechasalida;
    }

    public Integer getIdembarq() {
        return idembarq;
    }

    public void setIdembarq(Integer idembarq) {
        this.idembarq = idembarq;
    }

    public String getNcontenedor() {
        return ncontenedor;
    }

    public void setNcontenedor(String ncontenedor) {
        this.ncontenedor = ncontenedor;
    }

    public double getPesokgs() {
        return pesokgs;
    }

    public void setPesokgs(double pesokgs) {
        this.pesokgs = pesokgs;
    }

    public double getVolumenmc() {
        return volumenmc;
    }

    public void setVolumenmc(double volumenmc) {
        this.volumenmc = volumenmc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoembarq() {
        return tipoembarq;
    }

    public void setTipoembarq(String tipoembarq) {
        this.tipoembarq = tipoembarq;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Double getTarifacobro() {
        return tarifacobro;
    }

    public void setTarifacobro(Double tarifacobro) {
        this.tarifacobro = tarifacobro;
    }

    public TbFactura getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(TbFactura idfactura) {
        this.idfactura = idfactura;
    }

    public TbPais getIdpais() {
        return idpais;
    }

    public void setIdpais(TbPais idpais) {
        this.idpais = idpais;
    }

    public TbProduct getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(TbProduct idproduct) {
        this.idproduct = idproduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idembarq != null ? idembarq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmbarque)) {
            return false;
        }
        TbEmbarque other = (TbEmbarque) object;
        if ((this.idembarq == null && other.idembarq != null) || (this.idembarq != null && !this.idembarq.equals(other.idembarq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigtma.entidades.TbEmbarque[ idembarq=" + idembarq + " ]";
    }
    
}
