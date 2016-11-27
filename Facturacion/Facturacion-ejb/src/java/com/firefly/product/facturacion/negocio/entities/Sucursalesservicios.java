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
@Table(name = "sucursalesservicios", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursalesservicios.findAll", query = "SELECT s FROM Sucursalesservicios s"),
    @NamedQuery(name = "Sucursalesservicios.findByIdsucursalesServicios", query = "SELECT s FROM Sucursalesservicios s WHERE s.idsucursalesServicios = :idsucursalesServicios")})
public class Sucursalesservicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsucursalesServicios")
    private Integer idsucursalesServicios;
    @JoinColumn(name = "idservicios", referencedColumnName = "idServicios")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Servicios idservicios;
    @JoinColumn(name = "idsucursales", referencedColumnName = "idsucursal")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sucursales idsucursales;

    public Sucursalesservicios() {
    }

    public Sucursalesservicios(Integer idsucursalesServicios) {
        this.idsucursalesServicios = idsucursalesServicios;
    }

    public Integer getIdsucursalesServicios() {
        return idsucursalesServicios;
    }

    public void setIdsucursalesServicios(Integer idsucursalesServicios) {
        this.idsucursalesServicios = idsucursalesServicios;
    }

    public Servicios getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(Servicios idservicios) {
        this.idservicios = idservicios;
    }

    public Sucursales getIdsucursales() {
        return idsucursales;
    }

    public void setIdsucursales(Sucursales idsucursales) {
        this.idsucursales = idsucursales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsucursalesServicios != null ? idsucursalesServicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursalesservicios)) {
            return false;
        }
        Sucursalesservicios other = (Sucursalesservicios) object;
        if ((this.idsucursalesServicios == null && other.idsucursalesServicios != null) || (this.idsucursalesServicios != null && !this.idsucursalesServicios.equals(other.idsucursalesServicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Sucursalesservicios[ idsucursalesServicios=" + idsucursalesServicios + " ]";
    }
    
}
