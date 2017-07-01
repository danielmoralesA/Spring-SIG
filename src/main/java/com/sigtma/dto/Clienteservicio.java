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
@Table(name = "clienteservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteservicio.findAll", query = "SELECT c FROM Clienteservicio c")
    , @NamedQuery(name = "Clienteservicio.findById", query = "SELECT c FROM Clienteservicio c WHERE c.id = :id")
    , @NamedQuery(name = "Clienteservicio.findByNomCliente", query = "SELECT c FROM Clienteservicio c WHERE c.nomCliente = :nomCliente")
    , @NamedQuery(name = "Clienteservicio.findByFechacontracto", query = "SELECT c FROM Clienteservicio c WHERE c.fechacontracto = :fechacontracto")
    , @NamedQuery(name = "Clienteservicio.findByDui", query = "SELECT c FROM Clienteservicio c WHERE c.dui = :dui")
    , @NamedQuery(name = "Clienteservicio.findByIdembarque", query = "SELECT c FROM Clienteservicio c WHERE c.idembarque = :idembarque")
    , @NamedQuery(name = "Clienteservicio.findByCodtramite", query = "SELECT c FROM Clienteservicio c WHERE c.codtramite = :codtramite")})

public class Clienteservicio implements Serializable{
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nom_cliente")
    private String nomCliente;
    @Column(name = "fechacontracto")
    @Temporal(TemporalType.DATE)
    private Date fechacontracto;
    @Column(name = "dui")
    private String dui;
    @Column(name = "idembarque")
    private Integer idembarque;
    @Column(name = "codtramite")
    private String codtramite;

    public Clienteservicio() {
    }

    public Clienteservicio(Integer id) {
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

    public Date getFechacontracto() {
        return fechacontracto;
    }

    public void setFechacontracto(Date fechacontracto) {
        this.fechacontracto = fechacontracto;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Integer getIdembarque() {
        return idembarque;
    }

    public void setIdembarque(Integer idembarque) {
        this.idembarque = idembarque;
    }

    public String getCodtramite() {
        return codtramite;
    }

    public void setCodtramite(String codtramite) {
        this.codtramite = codtramite;
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
        if (!(object instanceof Clienteservicio)) {
            return false;
        }
        Clienteservicio other = (Clienteservicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba.Clienteservicio[ id=" + id + " ]";
    }
}
