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
@Table(name = "cuentaempresa", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentaempresa.findAll", query = "SELECT c FROM Cuentaempresa c"),
    @NamedQuery(name = "Cuentaempresa.findByIdcuentaEmpresa", query = "SELECT c FROM Cuentaempresa c WHERE c.idcuentaEmpresa = :idcuentaEmpresa")})
public class Cuentaempresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuentaEmpresa")
    private Integer idcuentaEmpresa;
    @JoinColumn(name = "idcuentabancaria", referencedColumnName = "idcuentasBancarias")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuentasbancarias idcuentabancaria;
    @JoinColumn(name = "idempresas", referencedColumnName = "idempresa")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresas idempresas;

    public Cuentaempresa() {
    }

    public Cuentaempresa(Integer idcuentaEmpresa) {
        this.idcuentaEmpresa = idcuentaEmpresa;
    }

    public Integer getIdcuentaEmpresa() {
        return idcuentaEmpresa;
    }

    public void setIdcuentaEmpresa(Integer idcuentaEmpresa) {
        this.idcuentaEmpresa = idcuentaEmpresa;
    }

    public Cuentasbancarias getIdcuentabancaria() {
        return idcuentabancaria;
    }

    public void setIdcuentabancaria(Cuentasbancarias idcuentabancaria) {
        this.idcuentabancaria = idcuentabancaria;
    }

    public Empresas getIdempresas() {
        return idempresas;
    }

    public void setIdempresas(Empresas idempresas) {
        this.idempresas = idempresas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuentaEmpresa != null ? idcuentaEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentaempresa)) {
            return false;
        }
        Cuentaempresa other = (Cuentaempresa) object;
        if ((this.idcuentaEmpresa == null && other.idcuentaEmpresa != null) || (this.idcuentaEmpresa != null && !this.idcuentaEmpresa.equals(other.idcuentaEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Cuentaempresa[ idcuentaEmpresa=" + idcuentaEmpresa + " ]";
    }
    
}
