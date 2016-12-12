/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.negocio.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dclav
 */
@Entity
@Table(name = "cargos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c"),
    @NamedQuery(name = "Cargos.findByIdcargos", query = "SELECT c FROM Cargos c WHERE c.idcargos = :idcargos"),
    @NamedQuery(name = "Cargos.findByNombre", query = "SELECT c FROM Cargos c WHERE c.nombre = :nombre")})
public class Cargos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcargos")
    private Integer idcargos;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idcargo")
    private Collection<Usuarios> usuariosCollection;

    public Cargos() {
    }

    public Cargos(Integer idcargos) {
        this.idcargos = idcargos;
    }

    public Integer getIdcargos() {
        return idcargos;
    }

    public void setIdcargos(Integer idcargos) {
        this.idcargos = idcargos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcargos != null ? idcargos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.idcargos == null && other.idcargos != null) || (this.idcargos != null && !this.idcargos.equals(other.idcargos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.entities.Cargos[ idcargos=" + idcargos + " ]";
    }
    
}
