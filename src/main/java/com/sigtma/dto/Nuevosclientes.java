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
@Table(name = "nuevosclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nuevosclientes.findAll", query = "SELECT n FROM Nuevosclientes n")
    , @NamedQuery(name = "Nuevosclientes.findById", query = "SELECT n FROM Nuevosclientes n WHERE n.id = :id")
    , @NamedQuery(name = "Nuevosclientes.findByNomCliente", query = "SELECT n FROM Nuevosclientes n WHERE n.nomCliente = :nomCliente")
    , @NamedQuery(name = "Nuevosclientes.findByFechContratacion", query = "SELECT n FROM Nuevosclientes n WHERE n.fechContratacion = :fechContratacion")
    , @NamedQuery(name = "Nuevosclientes.findByNombre", query = "SELECT n FROM Nuevosclientes n WHERE n.nombre = :nombre")})

public class Nuevosclientes implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nom_cliente")
    private String nomCliente;
    @Column(name = "fech_contratacion")
    @Temporal(TemporalType.DATE)
    private Date fechContratacion;
    @Column(name = "nombre")
    private String nombre;

    public Nuevosclientes() {
    }

    public Nuevosclientes(Integer id) {
        this.id = id;
    }

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

    public Date getFechContratacion() {
        return fechContratacion;
    }

    public void setFechContratacion(Date fechContratacion) {
        this.fechContratacion = fechContratacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof Nuevosclientes)) {
            return false;
        }
        Nuevosclientes other = (Nuevosclientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.Nuevosclientes[ id=" + id + " ]";
    }
	
}
