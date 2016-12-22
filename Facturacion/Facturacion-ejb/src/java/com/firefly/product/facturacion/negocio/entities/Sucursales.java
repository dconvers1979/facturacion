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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sucursales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursales.findAll", query = "SELECT s FROM Sucursales s"),
    @NamedQuery(name = "Sucursales.findByIdsucursal", query = "SELECT s FROM Sucursales s WHERE s.idsucursal = :idsucursal"),
    @NamedQuery(name = "Sucursales.findByEstado", query = "SELECT s FROM Sucursales s WHERE s.estado = :estado"),
    @NamedQuery(name = "Sucursales.findByNombre", query = "SELECT s FROM Sucursales s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Sucursales.findByDireccion", query = "SELECT s FROM Sucursales s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sucursales.findByTelefono", query = "SELECT s FROM Sucursales s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Sucursales.findByPais", query = "SELECT s FROM Sucursales s WHERE s.pais = :pais"),
    @NamedQuery(name = "Sucursales.findByDepartamento", query = "SELECT s FROM Sucursales s WHERE s.departamento = :departamento"),
    @NamedQuery(name = "Sucursales.findByCiudad", query = "SELECT s FROM Sucursales s WHERE s.ciudad = :ciudad"),
    @NamedQuery(name = "Sucursales.findByManejaInventario", query = "SELECT s FROM Sucursales s WHERE s.manejaInventario = :manejaInventario"),
    @NamedQuery(name = "Sucursales.findByManejaServicios", query = "SELECT s FROM Sucursales s WHERE s.manejaServicios = :manejaServicios"),
    @NamedQuery(name = "Sucursales.findByHabilitadaFacturar", query = "SELECT s FROM Sucursales s WHERE s.habilitadaFacturar = :habilitadaFacturar")})
public class Sucursales implements Serializable {

    @JoinColumn(name = "tipoSucursal", referencedColumnName = "idtipoSucursal")
    @ManyToOne
    private Tiposucursal tipoSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsucursal")
    private Collection<Factura> facturaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsucursal")
    private Integer idsucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "departamento")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "manejaInventario")
    private Boolean manejaInventario;
    @Column(name = "manejaServicios")
    private Boolean manejaServicios;
    @Column(name = "habilitadaFacturar")
    private Boolean habilitadaFacturar;
    @OneToMany(mappedBy = "idSucursalMatriz")
    private Collection<Sucursales> sucursalesCollection;
    @JoinColumn(name = "idSucursalMatriz", referencedColumnName = "idsucursal")
    @ManyToOne
    private Sucursales idSucursalMatriz;

    public Sucursales() {
    }

    public Sucursales(Integer idsucursal) {
        this.idsucursal = idsucursal;
    }

    public Sucursales(Integer idsucursal, int estado, String nombre, String direccion, String telefono, String pais, String departamento, String ciudad) {
        this.idsucursal = idsucursal;
        this.estado = estado;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudad = ciudad;
    }

    public Integer getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Integer idsucursal) {
        this.idsucursal = idsucursal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Boolean getManejaInventario() {
        return manejaInventario;
    }

    public void setManejaInventario(Boolean manejaInventario) {
        this.manejaInventario = manejaInventario;
    }

    public Boolean getManejaServicios() {
        return manejaServicios;
    }

    public void setManejaServicios(Boolean manejaServicios) {
        this.manejaServicios = manejaServicios;
    }

    public Boolean getHabilitadaFacturar() {
        return habilitadaFacturar;
    }

    public void setHabilitadaFacturar(Boolean habilitadaFacturar) {
        this.habilitadaFacturar = habilitadaFacturar;
    }

    @XmlTransient
    public Collection<Sucursales> getSucursalesCollection() {
        return sucursalesCollection;
    }

    public void setSucursalesCollection(Collection<Sucursales> sucursalesCollection) {
        this.sucursalesCollection = sucursalesCollection;
    }

    public Sucursales getIdSucursalMatriz() {
        return idSucursalMatriz;
    }

    public void setIdSucursalMatriz(Sucursales idSucursalMatriz) {
        this.idSucursalMatriz = idSucursalMatriz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsucursal != null ? idsucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursales)) {
            return false;
        }
        Sucursales other = (Sucursales) object;
        if ((this.idsucursal == null && other.idsucursal != null) || (this.idsucursal != null && !this.idsucursal.equals(other.idsucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.entities.Sucursales[ idsucursal=" + idsucursal + " ]";
    }

    public Tiposucursal getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(Tiposucursal tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }
    
}
