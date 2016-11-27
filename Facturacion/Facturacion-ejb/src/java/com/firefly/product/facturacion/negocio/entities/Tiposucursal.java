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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dclav
 */
@Entity
@Table(name = "tiposucursal", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposucursal.findAll", query = "SELECT t FROM Tiposucursal t"),
    @NamedQuery(name = "Tiposucursal.findByIdtipoSucursal", query = "SELECT t FROM Tiposucursal t WHERE t.idtipoSucursal = :idtipoSucursal"),
    @NamedQuery(name = "Tiposucursal.findByNombre", query = "SELECT t FROM Tiposucursal t WHERE t.nombre = :nombre")})
public class Tiposucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoSucursal")
    private Integer idtipoSucursal;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;

    public Tiposucursal() {
    }

    public Tiposucursal(Integer idtipoSucursal) {
        this.idtipoSucursal = idtipoSucursal;
    }

    public Integer getIdtipoSucursal() {
        return idtipoSucursal;
    }

    public void setIdtipoSucursal(Integer idtipoSucursal) {
        this.idtipoSucursal = idtipoSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoSucursal != null ? idtipoSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposucursal)) {
            return false;
        }
        Tiposucursal other = (Tiposucursal) object;
        if ((this.idtipoSucursal == null && other.idtipoSucursal != null) || (this.idtipoSucursal != null && !this.idtipoSucursal.equals(other.idtipoSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Tiposucursal[ idtipoSucursal=" + idtipoSucursal + " ]";
    }
    
}
