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
@Table(name = "cuentacliente", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentacliente.findAll", query = "SELECT c FROM Cuentacliente c"),
    @NamedQuery(name = "Cuentacliente.findByIdcuentaCliente", query = "SELECT c FROM Cuentacliente c WHERE c.idcuentaCliente = :idcuentaCliente")})
public class Cuentacliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuentaCliente")
    private Integer idcuentaCliente;
    @JoinColumn(name = "idclientes", referencedColumnName = "idclientes")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Clientes idclientes;
    @JoinColumn(name = "idcuentabancaria", referencedColumnName = "idcuentasBancarias")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cuentasbancarias idcuentabancaria;

    public Cuentacliente() {
    }

    public Cuentacliente(Integer idcuentaCliente) {
        this.idcuentaCliente = idcuentaCliente;
    }

    public Integer getIdcuentaCliente() {
        return idcuentaCliente;
    }

    public void setIdcuentaCliente(Integer idcuentaCliente) {
        this.idcuentaCliente = idcuentaCliente;
    }

    public Clientes getIdclientes() {
        return idclientes;
    }

    public void setIdclientes(Clientes idclientes) {
        this.idclientes = idclientes;
    }

    public Cuentasbancarias getIdcuentabancaria() {
        return idcuentabancaria;
    }

    public void setIdcuentabancaria(Cuentasbancarias idcuentabancaria) {
        this.idcuentabancaria = idcuentabancaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuentaCliente != null ? idcuentaCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentacliente)) {
            return false;
        }
        Cuentacliente other = (Cuentacliente) object;
        if ((this.idcuentaCliente == null && other.idcuentaCliente != null) || (this.idcuentaCliente != null && !this.idcuentaCliente.equals(other.idcuentaCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Cuentacliente[ idcuentaCliente=" + idcuentaCliente + " ]";
    }
    
}
