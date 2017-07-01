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
@Table(name = "exportacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exportacion.findAll", query = "SELECT e FROM Exportacion e")
    , @NamedQuery(name = "Exportacion.findById", query = "SELECT e FROM Exportacion e WHERE e.id = :id")
    , @NamedQuery(name = "Exportacion.findByNombre", query = "SELECT e FROM Exportacion e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Exportacion.findByEmbarque", query = "SELECT e FROM Exportacion e WHERE e.embarque = :embarque")
    , @NamedQuery(name = "Exportacion.findByGanancias", query = "SELECT e FROM Exportacion e WHERE e.ganancias = :ganancias")
    , @NamedQuery(name = "Exportacion.findByFechasalida", query = "SELECT e FROM Exportacion e WHERE e.fechasalida = :fechasalida")})

public class Exportacion implements Serializable{

	  private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id")
	    private Integer id;
	    @Column(name = "nombre")
	    private String nombre;
	    @Column(name = "embarque")
	    private Integer embarque;
	    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	    @Column(name = "ganancias")
	    private Double ganancias;
	    @Column(name = "fechasalida")
	    @Temporal(TemporalType.DATE)
	    private Date fechasalida;

	    public Exportacion() {
	    }

	    public Exportacion(Integer id) {
	        this.id = id;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public Integer getEmbarque() {
	        return embarque;
	    }

	    public void setEmbarque(Integer embarque) {
	        this.embarque = embarque;
	    }

	    public Double getGanancias() {
	        return ganancias;
	    }

	    public void setGanancias(Double ganancias) {
	        this.ganancias = ganancias;
	    }

	    public Date getFechasalida() {
	        return fechasalida;
	    }

	    public void setFechasalida(Date fechasalida) {
	        this.fechasalida = fechasalida;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (id != null ? id.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Exportacion)) {
	            return false;
	        }
	        Exportacion other = (Exportacion) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "prueba.Exportacion[ id=" + id + " ]";
	    }
	  
}
