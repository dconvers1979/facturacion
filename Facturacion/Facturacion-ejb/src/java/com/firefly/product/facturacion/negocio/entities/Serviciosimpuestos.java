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
@Table(name = "serviciosimpuestos", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviciosimpuestos.findAll", query = "SELECT s FROM Serviciosimpuestos s"),
    @NamedQuery(name = "Serviciosimpuestos.findByIdserviciosImpuestos", query = "SELECT s FROM Serviciosimpuestos s WHERE s.idserviciosImpuestos = :idserviciosImpuestos")})
public class Serviciosimpuestos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idserviciosImpuestos")
    private Integer idserviciosImpuestos;
    @JoinColumn(name = "idimpuestos", referencedColumnName = "idimpuesto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Impuesto idimpuestos;
    @JoinColumn(name = "idservicios", referencedColumnName = "idServicios")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Servicios idservicios;

    public Serviciosimpuestos() {
    }

    public Serviciosimpuestos(Integer idserviciosImpuestos) {
        this.idserviciosImpuestos = idserviciosImpuestos;
    }

    public Integer getIdserviciosImpuestos() {
        return idserviciosImpuestos;
    }

    public void setIdserviciosImpuestos(Integer idserviciosImpuestos) {
        this.idserviciosImpuestos = idserviciosImpuestos;
    }

    public Impuesto getIdimpuestos() {
        return idimpuestos;
    }

    public void setIdimpuestos(Impuesto idimpuestos) {
        this.idimpuestos = idimpuestos;
    }

    public Servicios getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(Servicios idservicios) {
        this.idservicios = idservicios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idserviciosImpuestos != null ? idserviciosImpuestos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviciosimpuestos)) {
            return false;
        }
        Serviciosimpuestos other = (Serviciosimpuestos) object;
        if ((this.idserviciosImpuestos == null && other.idserviciosImpuestos != null) || (this.idserviciosImpuestos != null && !this.idserviciosImpuestos.equals(other.idserviciosImpuestos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Serviciosimpuestos[ idserviciosImpuestos=" + idserviciosImpuestos + " ]";
    }
    
}
