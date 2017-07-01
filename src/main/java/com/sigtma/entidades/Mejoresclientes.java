package com.sigtma.entidades;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "mejoresclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mejoresclientes.findAll", query = "SELECT r FROM Mejoresclientes r")
    , @NamedQuery(name = "Mejoresclientes.findByNomcliente", query = "SELECT r FROM Mejoresclientes r WHERE r.nomcliente = :nomcliente")
    , @NamedQuery(name = "Mejoresclientes.findByembarques", query = "SELECT r FROM Mejoresclientes r WHERE r.embarques = :embarques")
    , @NamedQuery(name = "Mejoresclientes.findByganacias", query = "SELECT r FROM Mejoresclientes r WHERE r.ganacias = :ganacias")
    , @NamedQuery(name = "Mejoresclientes.findByFechaventa", query = "SELECT r FROM Mejoresclientes r WHERE r.fechaventa = :fechaventa")
	, @NamedQuery(name = "Mejoresclientes.findByFechaventaBetween", query="SELECT r FROM Mejoresclientes r WHERE r.fechaventa between :fechaventa and :fechaventa")})

public class Mejoresclientes implements Serializable{

	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Integer id;
	    
	    @Column(name = "nomcliente")
	    private String nomcliente;
	    @Column(name = "embarques")
	    private Integer embarques;
	    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	    @Column(name = "ganacias")
	    private Double ganacias;
	    @Column(name = "fechaventa")
	    @Temporal(TemporalType.DATE)
	    private Date fechaventa;

	    public Mejoresclientes() {
	    }
	    
	    public Integer getId(){
	    	return id;
	    }

	    public String getNomcliente() {
	        return nomcliente;
	    }

	    public void setNomcliente(String nomcliente) {
	        this.nomcliente = nomcliente;
	    }

	    public Integer getEmbarques() {
	        return embarques;
	    }

	    public void setEmbarques(Integer embarques) {
	        this.embarques = embarques;
	    }

	    public Double getGanacias() {
	        return ganacias;
	    }

	    public void setMontocobrar(Double montocobrar) {
	        this.ganacias = montocobrar;
	    }

	    public Date getFechaventa() {
	        return fechaventa;
	    }

	    public void setFechaventa(Date fechaventa) {
	        this.fechaventa = fechaventa;
	    }
	
}
