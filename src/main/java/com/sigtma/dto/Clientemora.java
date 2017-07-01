package com.sigtma.dto;

import java.io.Serializable;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "clientemora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientemora.findAll", query = "SELECT c FROM Clientemora c")
    , @NamedQuery(name = "Clientemora.findById", query = "SELECT c FROM Clientemora c WHERE c.id = :id")
    , @NamedQuery(name = "Clientemora.findByCodcliente", query = "SELECT c FROM Clientemora c WHERE c.codcliente = :codcliente")
    , @NamedQuery(name = "Clientemora.findByNomcliente", query = "SELECT c FROM Clientemora c WHERE c.nomcliente = :nomcliente")
    , @NamedQuery(name = "Clientemora.findByFechContratacion", query = "SELECT c FROM Clientemora c WHERE c.fechContratacion = :fechContratacion")
    , @NamedQuery(name = "Clientemora.findByFechaventa", query = "SELECT c FROM Clientemora c WHERE c.fechaventa = :fechaventa")
    , @NamedQuery(name = "Clientemora.findByMontocancelado", query = "SELECT c FROM Clientemora c WHERE c.montocancelado = :montocancelado")})

public class Clientemora implements Serializable{

	  private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id")
	    private Integer id;
	    @Column(name = "codcliente")
	    private String codcliente;
	    @Column(name = "nomcliente")
	    private String nomcliente;
	    @Column(name = "fech_contratacion")
	    @Temporal(TemporalType.DATE)
	    private Date fechContratacion;
	    @Column(name = "fechaventa")
	    @Temporal(TemporalType.DATE)
	    private Date fechaventa;
	    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	    @Column(name = "montocancelado")
	    private Double montocancelado;

	    public Clientemora() {
	    }

	    public Clientemora(Integer id) {
	        this.id = id;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getCodcliente() {
	        return codcliente;
	    }

	    public void setCodcliente(String codcliente) {
	        this.codcliente = codcliente;
	    }

	    public String getNomcliente() {
	        return nomcliente;
	    }

	    public void setNomcliente(String nomcliente) {
	        this.nomcliente = nomcliente;
	    }

	    public Date getFechContratacion() {
	        return fechContratacion;
	    }

	    public void setFechContratacion(Date fechContratacion) {
	        this.fechContratacion = fechContratacion;
	    }

	    public Date getFechaventa() {
	        return fechaventa;
	    }

	    public void setFechaventa(Date fechaventa) {
	        this.fechaventa = fechaventa;
	    }

	    public Double getMontocancelado() {
	        return montocancelado;
	    }

	    public void setMontocancelado(Double montocancelado) {
	        this.montocancelado = montocancelado;
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
	        if (!(object instanceof Clientemora)) {
	            return false;
	        }
	        Clientemora other = (Clientemora) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "prueba.Clientemora[ id=" + id + " ]";
	    }

	
}
