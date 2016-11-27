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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dclav
 */
@Entity
@Table(name = "clasificacionproductos", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clasificacionproductos.findAll", query = "SELECT c FROM Clasificacionproductos c"),
    @NamedQuery(name = "Clasificacionproductos.findByIdclasificacionProductos", query = "SELECT c FROM Clasificacionproductos c WHERE c.idclasificacionProductos = :idclasificacionProductos"),
    @NamedQuery(name = "Clasificacionproductos.findByNombre", query = "SELECT c FROM Clasificacionproductos c WHERE c.nombre = :nombre")})
public class Clasificacionproductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclasificacionProductos")
    private Integer idclasificacionProductos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;

    public Clasificacionproductos() {
    }

    public Clasificacionproductos(Integer idclasificacionProductos) {
        this.idclasificacionProductos = idclasificacionProductos;
    }

    public Clasificacionproductos(Integer idclasificacionProductos, String nombre) {
        this.idclasificacionProductos = idclasificacionProductos;
        this.nombre = nombre;
    }

    public Integer getIdclasificacionProductos() {
        return idclasificacionProductos;
    }

    public void setIdclasificacionProductos(Integer idclasificacionProductos) {
        this.idclasificacionProductos = idclasificacionProductos;
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
        hash += (idclasificacionProductos != null ? idclasificacionProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificacionproductos)) {
            return false;
        }
        Clasificacionproductos other = (Clasificacionproductos) object;
        if ((this.idclasificacionProductos == null && other.idclasificacionProductos != null) || (this.idclasificacionProductos != null && !this.idclasificacionProductos.equals(other.idclasificacionProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Clasificacionproductos[ idclasificacionProductos=" + idclasificacionProductos + " ]";
    }
    
}
