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
@Table(name = "cuentasbancarias", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentasbancarias.findAll", query = "SELECT c FROM Cuentasbancarias c"),
    @NamedQuery(name = "Cuentasbancarias.findByIdcuentasBancarias", query = "SELECT c FROM Cuentasbancarias c WHERE c.idcuentasBancarias = :idcuentasBancarias"),
    @NamedQuery(name = "Cuentasbancarias.findByNombreEntidad", query = "SELECT c FROM Cuentasbancarias c WHERE c.nombreEntidad = :nombreEntidad"),
    @NamedQuery(name = "Cuentasbancarias.findBySucursal", query = "SELECT c FROM Cuentasbancarias c WHERE c.sucursal = :sucursal"),
    @NamedQuery(name = "Cuentasbancarias.findByTipoCuenta", query = "SELECT c FROM Cuentasbancarias c WHERE c.tipoCuenta = :tipoCuenta"),
    @NamedQuery(name = "Cuentasbancarias.findByNumeroCuenta", query = "SELECT c FROM Cuentasbancarias c WHERE c.numeroCuenta = :numeroCuenta"),
    @NamedQuery(name = "Cuentasbancarias.findByNombreTitular", query = "SELECT c FROM Cuentasbancarias c WHERE c.nombreTitular = :nombreTitular"),
    @NamedQuery(name = "Cuentasbancarias.findByTipoDocumentoTitular", query = "SELECT c FROM Cuentasbancarias c WHERE c.tipoDocumentoTitular = :tipoDocumentoTitular"),
    @NamedQuery(name = "Cuentasbancarias.findByNumeroDocumentoTitular", query = "SELECT c FROM Cuentasbancarias c WHERE c.numeroDocumentoTitular = :numeroDocumentoTitular")})
public class Cuentasbancarias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuentasBancarias")
    private Integer idcuentasBancarias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreEntidad")
    private String nombreEntidad;
    @Size(max = 45)
    @Column(name = "sucursal")
    private String sucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoCuenta")
    private int tipoCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numeroCuenta")
    private String numeroCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombreTitular")
    private String nombreTitular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoDocumentoTitular")
    private int tipoDocumentoTitular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numeroDocumentoTitular")
    private String numeroDocumentoTitular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuentabancaria", fetch = FetchType.EAGER)
    private Collection<Cuentaempresa> cuentaempresaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuentabancaria", fetch = FetchType.EAGER)
    private Collection<Cuentacliente> cuentaclienteCollection;

    public Cuentasbancarias() {
    }

    public Cuentasbancarias(Integer idcuentasBancarias) {
        this.idcuentasBancarias = idcuentasBancarias;
    }

    public Cuentasbancarias(Integer idcuentasBancarias, String nombreEntidad, int tipoCuenta, String numeroCuenta, String nombreTitular, int tipoDocumentoTitular, String numeroDocumentoTitular) {
        this.idcuentasBancarias = idcuentasBancarias;
        this.nombreEntidad = nombreEntidad;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.tipoDocumentoTitular = tipoDocumentoTitular;
        this.numeroDocumentoTitular = numeroDocumentoTitular;
    }

    public Integer getIdcuentasBancarias() {
        return idcuentasBancarias;
    }

    public void setIdcuentasBancarias(Integer idcuentasBancarias) {
        this.idcuentasBancarias = idcuentasBancarias;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public int getTipoDocumentoTitular() {
        return tipoDocumentoTitular;
    }

    public void setTipoDocumentoTitular(int tipoDocumentoTitular) {
        this.tipoDocumentoTitular = tipoDocumentoTitular;
    }

    public String getNumeroDocumentoTitular() {
        return numeroDocumentoTitular;
    }

    public void setNumeroDocumentoTitular(String numeroDocumentoTitular) {
        this.numeroDocumentoTitular = numeroDocumentoTitular;
    }

    @XmlTransient
    public Collection<Cuentaempresa> getCuentaempresaCollection() {
        return cuentaempresaCollection;
    }

    public void setCuentaempresaCollection(Collection<Cuentaempresa> cuentaempresaCollection) {
        this.cuentaempresaCollection = cuentaempresaCollection;
    }

    @XmlTransient
    public Collection<Cuentacliente> getCuentaclienteCollection() {
        return cuentaclienteCollection;
    }

    public void setCuentaclienteCollection(Collection<Cuentacliente> cuentaclienteCollection) {
        this.cuentaclienteCollection = cuentaclienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuentasBancarias != null ? idcuentasBancarias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentasbancarias)) {
            return false;
        }
        Cuentasbancarias other = (Cuentasbancarias) object;
        if ((this.idcuentasBancarias == null && other.idcuentasBancarias != null) || (this.idcuentasBancarias != null && !this.idcuentasBancarias.equals(other.idcuentasBancarias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Cuentasbancarias[ idcuentasBancarias=" + idcuentasBancarias + " ]";
    }
    
}
