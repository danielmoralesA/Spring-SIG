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
@Table(name = "r_mejoresclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RMejoresclientes.findAll", query = "SELECT r FROM RMejoresclientes r")
    , @NamedQuery(name = "RMejoresclientes.findByNomCliente", query = "SELECT r FROM RMejoresclientes r WHERE r.nomCliente = :nomCliente")
    , @NamedQuery(name = "RMejoresclientes.findByIdembarq", query = "SELECT r FROM RMejoresclientes r WHERE r.idembarq = :idembarq")
    , @NamedQuery(name = "RMejoresclientes.findByMontocobrar", query = "SELECT r FROM RMejoresclientes r WHERE r.montocobrar = :montocobrar")
    , @NamedQuery(name = "RMejoresclientes.findByFechaventa", query = "SELECT r FROM RMejoresclientes r WHERE r.fechaventa = :fechaventa")
	, @NamedQuery(name = "RMejoresclientes.findByFechaventaBetween", query="SELECT r FROM RMejoresclientes r WHERE r.fechaventa between :fechaventa and :fechaventa")})
public class RMejoresclientes implements Serializable {

    	 private static final long serialVersionUID = 1L;
    	    @Id
    	    @GeneratedValue(strategy = GenerationType.AUTO)
    	    @Column(name="id")
    	    private Integer id;
    	    
    	    @Column(name = "nom_cliente")
    	    private String nomCliente;
    	    @Column(name = "idembarq")
    	    private Integer idembarq;
    	    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    	    @Column(name = "montocobrar")
    	    private Double montocobrar;
    	    @Column(name = "fechaventa")
    	    @Temporal(TemporalType.DATE)
    	    private Date fechaventa;

    	    public RMejoresclientes() {
    	    }
    	    
    	    public Integer getId(){
    	    	return id;
    	    }

    	    public String getNomCliente() {
    	        return nomCliente;
    	    }

    	    public void setNomCliente(String nomCliente) {
    	        this.nomCliente = nomCliente;
    	    }

    	    public Integer getIdembarq() {
    	        return idembarq;
    	    }

    	    public void setIdembarq(Integer idembarq) {
    	        this.idembarq = idembarq;
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
    	  
}
