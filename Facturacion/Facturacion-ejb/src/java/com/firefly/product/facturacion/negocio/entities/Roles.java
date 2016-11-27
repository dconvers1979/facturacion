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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dclav
 */
@Entity
@Table(name = "roles", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByIdroles", query = "SELECT r FROM Roles r WHERE r.idroles = :idroles"),
    @NamedQuery(name = "Roles.findByNombreRol", query = "SELECT r FROM Roles r WHERE r.nombreRol = :nombreRol"),
    @NamedQuery(name = "Roles.findByRolescol", query = "SELECT r FROM Roles r WHERE r.rolescol = :rolescol"),
    @NamedQuery(name = "Roles.findByLimiteDia", query = "SELECT r FROM Roles r WHERE r.limiteDia = :limiteDia"),
    @NamedQuery(name = "Roles.findByLimiteMes", query = "SELECT r FROM Roles r WHERE r.limiteMes = :limiteMes"),
    @NamedQuery(name = "Roles.findByPermisoVenta", query = "SELECT r FROM Roles r WHERE r.permisoVenta = :permisoVenta"),
    @NamedQuery(name = "Roles.findByPermisoInventarios", query = "SELECT r FROM Roles r WHERE r.permisoInventarios = :permisoInventarios"),
    @NamedQuery(name = "Roles.findByPermisosOrdenesCompra", query = "SELECT r FROM Roles r WHERE r.permisosOrdenesCompra = :permisosOrdenesCompra"),
    @NamedQuery(name = "Roles.findByPermisosReportes", query = "SELECT r FROM Roles r WHERE r.permisosReportes = :permisosReportes"),
    @NamedQuery(name = "Roles.findByPermisosAdministracion", query = "SELECT r FROM Roles r WHERE r.permisosAdministracion = :permisosAdministracion")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idroles")
    private Integer idroles;
    @Size(max = 100)
    @Column(name = "nombreRol")
    private String nombreRol;
    @Size(max = 45)
    @Column(name = "rolescol")
    private String rolescol;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "limiteDia")
    private Float limiteDia;
    @Column(name = "limiteMes")
    private Float limiteMes;
    @Column(name = "permisoVenta")
    private Boolean permisoVenta;
    @Column(name = "permisoInventarios")
    private Boolean permisoInventarios;
    @Column(name = "permisosOrdenesCompra")
    private Integer permisosOrdenesCompra;
    @Column(name = "permisosReportes")
    private Integer permisosReportes;
    @Column(name = "permisosAdministracion")
    private Integer permisosAdministracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idroles", fetch = FetchType.EAGER)
    private Collection<Usuariosroles> usuariosrolesCollection;

    public Roles() {
    }

    public Roles(Integer idroles) {
        this.idroles = idroles;
    }

    public Integer getIdroles() {
        return idroles;
    }

    public void setIdroles(Integer idroles) {
        this.idroles = idroles;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getRolescol() {
        return rolescol;
    }

    public void setRolescol(String rolescol) {
        this.rolescol = rolescol;
    }

    public Float getLimiteDia() {
        return limiteDia;
    }

    public void setLimiteDia(Float limiteDia) {
        this.limiteDia = limiteDia;
    }

    public Float getLimiteMes() {
        return limiteMes;
    }

    public void setLimiteMes(Float limiteMes) {
        this.limiteMes = limiteMes;
    }

    public Boolean getPermisoVenta() {
        return permisoVenta;
    }

    public void setPermisoVenta(Boolean permisoVenta) {
        this.permisoVenta = permisoVenta;
    }

    public Boolean getPermisoInventarios() {
        return permisoInventarios;
    }

    public void setPermisoInventarios(Boolean permisoInventarios) {
        this.permisoInventarios = permisoInventarios;
    }

    public Integer getPermisosOrdenesCompra() {
        return permisosOrdenesCompra;
    }

    public void setPermisosOrdenesCompra(Integer permisosOrdenesCompra) {
        this.permisosOrdenesCompra = permisosOrdenesCompra;
    }

    public Integer getPermisosReportes() {
        return permisosReportes;
    }

    public void setPermisosReportes(Integer permisosReportes) {
        this.permisosReportes = permisosReportes;
    }

    public Integer getPermisosAdministracion() {
        return permisosAdministracion;
    }

    public void setPermisosAdministracion(Integer permisosAdministracion) {
        this.permisosAdministracion = permisosAdministracion;
    }

    @XmlTransient
    public Collection<Usuariosroles> getUsuariosrolesCollection() {
        return usuariosrolesCollection;
    }

    public void setUsuariosrolesCollection(Collection<Usuariosroles> usuariosrolesCollection) {
        this.usuariosrolesCollection = usuariosrolesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idroles != null ? idroles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.idroles == null && other.idroles != null) || (this.idroles != null && !this.idroles.equals(other.idroles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Roles[ idroles=" + idroles + " ]";
    }
    
}
