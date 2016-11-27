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
@Table(name = "servicios", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s"),
    @NamedQuery(name = "Servicios.findByIdServicios", query = "SELECT s FROM Servicios s WHERE s.idServicios = :idServicios"),
    @NamedQuery(name = "Servicios.findByNombre", query = "SELECT s FROM Servicios s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Servicios.findByIdTipoServicio", query = "SELECT s FROM Servicios s WHERE s.idTipoServicio = :idTipoServicio"),
    @NamedQuery(name = "Servicios.findByDescripcion", query = "SELECT s FROM Servicios s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Servicios.findByCostoServicio", query = "SELECT s FROM Servicios s WHERE s.costoServicio = :costoServicio"),
    @NamedQuery(name = "Servicios.findByPrecioVenta", query = "SELECT s FROM Servicios s WHERE s.precioVenta = :precioVenta"),
    @NamedQuery(name = "Servicios.findByTipoCobro", query = "SELECT s FROM Servicios s WHERE s.tipoCobro = :tipoCobro")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idServicios")
    private Integer idServicios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipoServicio")
    private int idTipoServicio;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costoServicio")
    private Float costoServicio;
    @Column(name = "precioVenta")
    private Float precioVenta;
    @Column(name = "tipoCobro")
    private Integer tipoCobro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicios", fetch = FetchType.EAGER)
    private Collection<Serviciosimpuestos> serviciosimpuestosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicios", fetch = FetchType.EAGER)
    private Collection<Sucursalesservicios> sucursalesserviciosCollection;

    public Servicios() {
    }

    public Servicios(Integer idServicios) {
        this.idServicios = idServicios;
    }

    public Servicios(Integer idServicios, String nombre, int idTipoServicio) {
        this.idServicios = idServicios;
        this.nombre = nombre;
        this.idTipoServicio = idTipoServicio;
    }

    public Integer getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(Integer idServicios) {
        this.idServicios = idServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(int idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(Float costoServicio) {
        this.costoServicio = costoServicio;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getTipoCobro() {
        return tipoCobro;
    }

    public void setTipoCobro(Integer tipoCobro) {
        this.tipoCobro = tipoCobro;
    }

    @XmlTransient
    public Collection<Serviciosimpuestos> getServiciosimpuestosCollection() {
        return serviciosimpuestosCollection;
    }

    public void setServiciosimpuestosCollection(Collection<Serviciosimpuestos> serviciosimpuestosCollection) {
        this.serviciosimpuestosCollection = serviciosimpuestosCollection;
    }

    @XmlTransient
    public Collection<Sucursalesservicios> getSucursalesserviciosCollection() {
        return sucursalesserviciosCollection;
    }

    public void setSucursalesserviciosCollection(Collection<Sucursalesservicios> sucursalesserviciosCollection) {
        this.sucursalesserviciosCollection = sucursalesserviciosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicios != null ? idServicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.idServicios == null && other.idServicios != null) || (this.idServicios != null && !this.idServicios.equals(other.idServicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Servicios[ idServicios=" + idServicios + " ]";
    }
    
}
