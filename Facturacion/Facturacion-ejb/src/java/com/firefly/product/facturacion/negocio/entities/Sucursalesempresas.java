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
@Table(name = "sucursalesempresas", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursalesempresas.findAll", query = "SELECT s FROM Sucursalesempresas s"),
    @NamedQuery(name = "Sucursalesempresas.findByIdsucursalesEmpresas", query = "SELECT s FROM Sucursalesempresas s WHERE s.idsucursalesEmpresas = :idsucursalesEmpresas")})
public class Sucursalesempresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsucursalesEmpresas")
    private Integer idsucursalesEmpresas;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idempresa")
    @ManyToOne(fetch = FetchType.EAGER)
    private Empresas idEmpresa;
    @JoinColumn(name = "idSucursal", referencedColumnName = "idsucursal")
    @ManyToOne(fetch = FetchType.EAGER)
    private Sucursales idSucursal;

    public Sucursalesempresas() {
    }

    public Sucursalesempresas(Integer idsucursalesEmpresas) {
        this.idsucursalesEmpresas = idsucursalesEmpresas;
    }

    public Integer getIdsucursalesEmpresas() {
        return idsucursalesEmpresas;
    }

    public void setIdsucursalesEmpresas(Integer idsucursalesEmpresas) {
        this.idsucursalesEmpresas = idsucursalesEmpresas;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Sucursales getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursales idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsucursalesEmpresas != null ? idsucursalesEmpresas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursalesempresas)) {
            return false;
        }
        Sucursalesempresas other = (Sucursalesempresas) object;
        if ((this.idsucursalesEmpresas == null && other.idsucursalesEmpresas != null) || (this.idsucursalesEmpresas != null && !this.idsucursalesEmpresas.equals(other.idsucursalesEmpresas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Sucursalesempresas[ idsucursalesEmpresas=" + idsucursalesEmpresas + " ]";
    }
    
}
