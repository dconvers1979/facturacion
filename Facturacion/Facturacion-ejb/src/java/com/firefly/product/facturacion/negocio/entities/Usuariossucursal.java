/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.negocio.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dclav
 */
@Entity
@Table(name = "usuariossucursal", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariossucursal.findAll", query = "SELECT u FROM Usuariossucursal u"),
    @NamedQuery(name = "Usuariossucursal.findByIdusuariosSucursal", query = "SELECT u FROM Usuariossucursal u WHERE u.idusuariosSucursal = :idusuariosSucursal")})
public class Usuariossucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuariosSucursal")
    private Integer idusuariosSucursal;
    @JoinColumn(name = "idsucursales", referencedColumnName = "idsucursal")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sucursales idsucursales;
    @JoinColumn(name = "idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idusuarios;

    public Usuariossucursal() {
    }

    public Usuariossucursal(Integer idusuariosSucursal) {
        this.idusuariosSucursal = idusuariosSucursal;
    }

    public Integer getIdusuariosSucursal() {
        return idusuariosSucursal;
    }

    public void setIdusuariosSucursal(Integer idusuariosSucursal) {
        this.idusuariosSucursal = idusuariosSucursal;
    }

    public Sucursales getIdsucursales() {
        return idsucursales;
    }

    public void setIdsucursales(Sucursales idsucursales) {
        this.idsucursales = idsucursales;
    }

    public Usuarios getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(Usuarios idusuarios) {
        this.idusuarios = idusuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuariosSucursal != null ? idusuariosSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariossucursal)) {
            return false;
        }
        Usuariossucursal other = (Usuariossucursal) object;
        if ((this.idusuariosSucursal == null && other.idusuariosSucursal != null) || (this.idusuariosSucursal != null && !this.idusuariosSucursal.equals(other.idusuariosSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Usuariossucursal[ idusuariosSucursal=" + idusuariosSucursal + " ]";
    }
    
}
