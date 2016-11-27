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
@Table(name = "empresas", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e"),
    @NamedQuery(name = "Empresas.findByIdempresa", query = "SELECT e FROM Empresas e WHERE e.idempresa = :idempresa"),
    @NamedQuery(name = "Empresas.findByEstado", query = "SELECT e FROM Empresas e WHERE e.estado = :estado"),
    @NamedQuery(name = "Empresas.findByRazonSocial", query = "SELECT e FROM Empresas e WHERE e.razonSocial = :razonSocial"),
    @NamedQuery(name = "Empresas.findByNit", query = "SELECT e FROM Empresas e WHERE e.nit = :nit"),
    @NamedQuery(name = "Empresas.findByActividadEconomica1", query = "SELECT e FROM Empresas e WHERE e.actividadEconomica1 = :actividadEconomica1"),
    @NamedQuery(name = "Empresas.findByActividadEconomica2", query = "SELECT e FROM Empresas e WHERE e.actividadEconomica2 = :actividadEconomica2"),
    @NamedQuery(name = "Empresas.findByActividadEconomica3", query = "SELECT e FROM Empresas e WHERE e.actividadEconomica3 = :actividadEconomica3"),
    @NamedQuery(name = "Empresas.findByActividadEconomica4", query = "SELECT e FROM Empresas e WHERE e.actividadEconomica4 = :actividadEconomica4"),
    @NamedQuery(name = "Empresas.findByDireccion", query = "SELECT e FROM Empresas e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empresas.findByTelefono", query = "SELECT e FROM Empresas e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empresas.findByPais", query = "SELECT e FROM Empresas e WHERE e.pais = :pais"),
    @NamedQuery(name = "Empresas.findByDepartamento", query = "SELECT e FROM Empresas e WHERE e.departamento = :departamento"),
    @NamedQuery(name = "Empresas.findByCiudad", query = "SELECT e FROM Empresas e WHERE e.ciudad = :ciudad")})
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempresa")
    private Integer idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "razonSocial")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "actividadEconomica1")
    private String actividadEconomica1;
    @Size(max = 100)
    @Column(name = "actividadEconomica2")
    private String actividadEconomica2;
    @Size(max = 100)
    @Column(name = "actividadEconomica3")
    private String actividadEconomica3;
    @Size(max = 100)
    @Column(name = "actividadEconomica4")
    private String actividadEconomica4;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempresa", fetch = FetchType.EAGER)
    private Collection<Resolucionfacturacion> resolucionfacturacionCollection;
    @OneToMany(mappedBy = "idEmpresa", fetch = FetchType.EAGER)
    private Collection<Sucursalesempresas> sucursalesempresasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempresas", fetch = FetchType.EAGER)
    private Collection<Cuentaempresa> cuentaempresaCollection;

    public Empresas() {
    }

    public Empresas(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public Empresas(Integer idempresa, int estado, String razonSocial, String nit, String actividadEconomica1, String direccion, String telefono, String pais, String departamento, String ciudad) {
        this.idempresa = idempresa;
        this.estado = estado;
        this.razonSocial = razonSocial;
        this.nit = nit;
        this.actividadEconomica1 = actividadEconomica1;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudad = ciudad;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getActividadEconomica1() {
        return actividadEconomica1;
    }

    public void setActividadEconomica1(String actividadEconomica1) {
        this.actividadEconomica1 = actividadEconomica1;
    }

    public String getActividadEconomica2() {
        return actividadEconomica2;
    }

    public void setActividadEconomica2(String actividadEconomica2) {
        this.actividadEconomica2 = actividadEconomica2;
    }

    public String getActividadEconomica3() {
        return actividadEconomica3;
    }

    public void setActividadEconomica3(String actividadEconomica3) {
        this.actividadEconomica3 = actividadEconomica3;
    }

    public String getActividadEconomica4() {
        return actividadEconomica4;
    }

    public void setActividadEconomica4(String actividadEconomica4) {
        this.actividadEconomica4 = actividadEconomica4;
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

    @XmlTransient
    public Collection<Resolucionfacturacion> getResolucionfacturacionCollection() {
        return resolucionfacturacionCollection;
    }

    public void setResolucionfacturacionCollection(Collection<Resolucionfacturacion> resolucionfacturacionCollection) {
        this.resolucionfacturacionCollection = resolucionfacturacionCollection;
    }

    @XmlTransient
    public Collection<Sucursalesempresas> getSucursalesempresasCollection() {
        return sucursalesempresasCollection;
    }

    public void setSucursalesempresasCollection(Collection<Sucursalesempresas> sucursalesempresasCollection) {
        this.sucursalesempresasCollection = sucursalesempresasCollection;
    }

    @XmlTransient
    public Collection<Cuentaempresa> getCuentaempresaCollection() {
        return cuentaempresaCollection;
    }

    public void setCuentaempresaCollection(Collection<Cuentaempresa> cuentaempresaCollection) {
        this.cuentaempresaCollection = cuentaempresaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresa != null ? idempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Empresas[ idempresa=" + idempresa + " ]";
    }
    
}
