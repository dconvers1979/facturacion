/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.negocio.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dclav
 */
@Entity
@Table(name = "impuesto", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impuesto.findAll", query = "SELECT i FROM Impuesto i"),
    @NamedQuery(name = "Impuesto.findByIdimpuesto", query = "SELECT i FROM Impuesto i WHERE i.idimpuesto = :idimpuesto"),
    @NamedQuery(name = "Impuesto.findByNombreImpuesto", query = "SELECT i FROM Impuesto i WHERE i.nombreImpuesto = :nombreImpuesto"),
    @NamedQuery(name = "Impuesto.findByPorcentaje", query = "SELECT i FROM Impuesto i WHERE i.porcentaje = :porcentaje"),
    @NamedQuery(name = "Impuesto.findByDescripcion", query = "SELECT i FROM Impuesto i WHERE i.descripcion = :descripcion")})
public class Impuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idimpuesto")
    private Integer idimpuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreImpuesto")
    private String nombreImpuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje")
    private int porcentaje;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idimpuestos", fetch = FetchType.EAGER)
    private Collection<Serviciosimpuestos> serviciosimpuestosCollection;

    public Impuesto() {
    }

    public Impuesto(Integer idimpuesto) {
        this.idimpuesto = idimpuesto;
    }

    public Impuesto(Integer idimpuesto, String nombreImpuesto, int porcentaje) {
        this.idimpuesto = idimpuesto;
        this.nombreImpuesto = nombreImpuesto;
        this.porcentaje = porcentaje;
    }

    public Integer getIdimpuesto() {
        return idimpuesto;
    }

    public void setIdimpuesto(Integer idimpuesto) {
        this.idimpuesto = idimpuesto;
    }

    public String getNombreImpuesto() {
        return nombreImpuesto;
    }

    public void setNombreImpuesto(String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Serviciosimpuestos> getServiciosimpuestosCollection() {
        return serviciosimpuestosCollection;
    }

    public void setServiciosimpuestosCollection(Collection<Serviciosimpuestos> serviciosimpuestosCollection) {
        this.serviciosimpuestosCollection = serviciosimpuestosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idimpuesto != null ? idimpuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impuesto)) {
            return false;
        }
        Impuesto other = (Impuesto) object;
        if ((this.idimpuesto == null && other.idimpuesto != null) || (this.idimpuesto != null && !this.idimpuesto.equals(other.idimpuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Impuesto[ idimpuesto=" + idimpuesto + " ]";
    }
    
}
