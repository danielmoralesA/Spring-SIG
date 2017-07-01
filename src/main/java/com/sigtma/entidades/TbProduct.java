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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProduct.findAll", query = "SELECT t FROM TbProduct t")
    , @NamedQuery(name = "TbProduct.findByIdproducto", query = "SELECT t FROM TbProduct t WHERE t.idproducto = :idproducto")
    , @NamedQuery(name = "TbProduct.findByNombre", query = "SELECT t FROM TbProduct t WHERE t.nombre = :nombre")})
public class TbProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne
    private TbProveedor idproveedor;
    @OneToMany(mappedBy = "idproduct")
    private Collection<TbEmbarque> tbEmbarqueCollection;

    public TbProduct() {
    }

    public TbProduct(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public TbProduct(Integer idproducto, String nombre) {
        this.idproducto = idproducto;
        this.nombre = nombre;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TbProveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(TbProveedor idproveedor) {
        this.idproveedor = idproveedor;
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
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProduct)) {
            return false;
        }
        TbProduct other = (TbProduct) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigtma.entidades.TbProduct[ idproducto=" + idproducto + " ]";
    }
    
}
