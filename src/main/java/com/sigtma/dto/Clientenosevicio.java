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
@Table(name = "clientenosevicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientenosevicio.findAll", query = "SELECT c FROM Clientenosevicio c")
    , @NamedQuery(name = "Clientenosevicio.findById", query = "SELECT c FROM Clientenosevicio c WHERE c.id = :id")
    , @NamedQuery(name = "Clientenosevicio.findByCodcliente", query = "SELECT c FROM Clientenosevicio c WHERE c.codcliente = :codcliente")
    , @NamedQuery(name = "Clientenosevicio.findByNomcliente", query = "SELECT c FROM Clientenosevicio c WHERE c.nomcliente = :nomcliente")
    , @NamedQuery(name = "Clientenosevicio.findByFechUltimem", query = "SELECT c FROM Clientenosevicio c WHERE c.fechUltimem = :fechUltimem")})

public class Clientenosevicio implements Serializable {
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
    @Column(name = "fech_ultimem")
    @Temporal(TemporalType.DATE)
    private Date fechUltimem;

    public Clientenosevicio() {
    }

    public Clientenosevicio(Integer id) {
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

    public Date getFechUltimem() {
        return fechUltimem;
    }

    public void setFechUltimem(Date fechUltimem) {
        this.fechUltimem = fechUltimem;
    }

  /*  @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientenosevicio)) {
            return false;
        }
        Clientenosevicio other = (Clientenosevicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "prueba.Clientenosevicio[ id=" + id + " ]";
    }
    
}
