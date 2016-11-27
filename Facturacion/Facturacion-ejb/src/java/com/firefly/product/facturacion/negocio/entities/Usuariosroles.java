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
@Table(name = "usuariosroles", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariosroles.findAll", query = "SELECT u FROM Usuariosroles u"),
    @NamedQuery(name = "Usuariosroles.findByIdusuariosRoles", query = "SELECT u FROM Usuariosroles u WHERE u.idusuariosRoles = :idusuariosRoles")})
public class Usuariosroles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuariosRoles")
    private Integer idusuariosRoles;
    @JoinColumn(name = "idroles", referencedColumnName = "idroles")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Roles idroles;
    @JoinColumn(name = "idusuarios", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idusuarios;

    public Usuariosroles() {
    }

    public Usuariosroles(Integer idusuariosRoles) {
        this.idusuariosRoles = idusuariosRoles;
    }

    public Integer getIdusuariosRoles() {
        return idusuariosRoles;
    }

    public void setIdusuariosRoles(Integer idusuariosRoles) {
        this.idusuariosRoles = idusuariosRoles;
    }

    public Roles getIdroles() {
        return idroles;
    }

    public void setIdroles(Roles idroles) {
        this.idroles = idroles;
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
        hash += (idusuariosRoles != null ? idusuariosRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariosroles)) {
            return false;
        }
        Usuariosroles other = (Usuariosroles) object;
        if ((this.idusuariosRoles == null && other.idusuariosRoles != null) || (this.idusuariosRoles != null && !this.idusuariosRoles.equals(other.idusuariosRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Usuariosroles[ idusuariosRoles=" + idusuariosRoles + " ]";
    }
    
}
