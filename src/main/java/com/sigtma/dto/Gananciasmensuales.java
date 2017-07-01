package com.sigtma.dto;

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

@Entity
@Table(name = "gananciasmensuales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gananciasmensuales.findAll", query = "SELECT g FROM Gananciasmensuales g")
    , @NamedQuery(name = "Gananciasmensuales.findById", query = "SELECT g FROM Gananciasmensuales g WHERE g.id = :id")
    , @NamedQuery(name = "Gananciasmensuales.findByEmbarque", query = "SELECT g FROM Gananciasmensuales g WHERE g.embarque = :embarque")
    , @NamedQuery(name = "Gananciasmensuales.findByPais", query = "SELECT g FROM Gananciasmensuales g WHERE g.pais = :pais")
    , @NamedQuery(name = "Gananciasmensuales.findByFechaEmbarque", query = "SELECT g FROM Gananciasmensuales g WHERE g.fechaEmbarque = :fechaEmbarque")
    , @NamedQuery(name = "Gananciasmensuales.findByGanancia", query = "SELECT g FROM Gananciasmensuales g WHERE g.ganancia = :ganancia")
    , @NamedQuery(name = "Gananciasmensuales.findByFechaEmbarqueBetween", query = "SELECT g FROM Gananciasmensuales g WHERE g.fechaEmbarque BETWEEN :fechaEmbarque and :fechaEmbarque" )

    })
public class Gananciasmensuales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "embarque")
    private Integer embarque;
    @Column(name = "pais")
    private String pais;
    @Column(name = "fecha_embarque")
    @Temporal(TemporalType.DATE)
    private Date fechaEmbarque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ganancia")
    private Double ganancia;

    public Gananciasmensuales() {
    }

    public Gananciasmensuales(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmbarque() {
        return embarque;
    }

    public void setEmbarque(Integer embarque) {
        this.embarque = embarque;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaEmbarque() {
        return fechaEmbarque;
    }

    public void setFechaEmbarque(Date fechaEmbarque) {
        this.fechaEmbarque = fechaEmbarque;
    }

    public Double getGanancia() {
        return ganancia;
    }

    public void setGanancia(Double ganancia) {
        this.ganancia = ganancia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

   /* @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gananciasmensuales)) {
            return false;
        }
        Gananciasmensuales other = (Gananciasmensuales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "prueba.Gananciasmensuales[ id=" + id + " ]";
    }
    
}