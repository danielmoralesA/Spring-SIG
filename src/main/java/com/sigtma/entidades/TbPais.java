/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigtma.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "tb_pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPais.findAll", query = "SELECT t FROM TbPais t")
    , @NamedQuery(name = "TbPais.findByIdpais", query = "SELECT t FROM TbPais t WHERE t.idpais = :idpais")
    , @NamedQuery(name = "TbPais.findByNombre", query = "SELECT t FROM TbPais t WHERE t.nombre = :nombre")})
public class TbPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpais")
    private Integer idpais;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idpais")
    private Collection<TbEmbarque> tbEmbarqueCollection;

    public TbPais() {
    }

    public TbPais(Integer idpais) {
        this.idpais = idpais;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idpais != null ? idpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPais)) {
            return false;
        }
        TbPais other = (TbPais) object;
        if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigtma.entidades.TbPais[ idpais=" + idpais + " ]";
    }
    
}
