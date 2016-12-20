/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.negocio.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dclav
 */
@Entity
@Table(name = "resolucionfacturacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resolucionfacturacion.findAll", query = "SELECT r FROM Resolucionfacturacion r"),
    @NamedQuery(name = "Resolucionfacturacion.findByIdresolucionFacturacion", query = "SELECT r FROM Resolucionfacturacion r WHERE r.idresolucionFacturacion = :idresolucionFacturacion"),
    @NamedQuery(name = "Resolucionfacturacion.findByTipoResolucion", query = "SELECT r FROM Resolucionfacturacion r WHERE r.tipoResolucion = :tipoResolucion"),
    @NamedQuery(name = "Resolucionfacturacion.findByPrefijo", query = "SELECT r FROM Resolucionfacturacion r WHERE r.prefijo = :prefijo"),
    @NamedQuery(name = "Resolucionfacturacion.findByRangoInicial", query = "SELECT r FROM Resolucionfacturacion r WHERE r.rangoInicial = :rangoInicial"),
    @NamedQuery(name = "Resolucionfacturacion.findByRangoFinal", query = "SELECT r FROM Resolucionfacturacion r WHERE r.rangoFinal = :rangoFinal"),
    @NamedQuery(name = "Resolucionfacturacion.findBySecuencia", query = "SELECT r FROM Resolucionfacturacion r WHERE r.secuencia = :secuencia"),
    @NamedQuery(name = "Resolucionfacturacion.findByEstado", query = "SELECT r FROM Resolucionfacturacion r WHERE r.estado = :estado"),
    @NamedQuery(name = "Resolucionfacturacion.findByNumeroResolucion", query = "SELECT r FROM Resolucionfacturacion r WHERE r.numeroResolucion = :numeroResolucion"),
    @NamedQuery(name = "Resolucionfacturacion.findByFechaExpedicion", query = "SELECT r FROM Resolucionfacturacion r WHERE r.fechaExpedicion = :fechaExpedicion"),
    @NamedQuery(name = "Resolucionfacturacion.findByFechaVigencia", query = "SELECT r FROM Resolucionfacturacion r WHERE r.fechaVigencia = :fechaVigencia")})
public class Resolucionfacturacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresolucionFacturacion")
    private Integer idresolucionFacturacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoResolucion")
    private int tipoResolucion;
    @Size(max = 15)
    @Column(name = "prefijo")
    private String prefijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rangoInicial")
    private int rangoInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rangoFinal")
    private int rangoFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "secuencia")
    private int secuencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numeroResolucion")
    private String numeroResolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaExpedicion")
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVigencia")
    @Temporal(TemporalType.DATE)
    private Date fechaVigencia;
    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false)
    private Empresas idempresa;

    public Resolucionfacturacion() {
    }

    public Resolucionfacturacion(Integer idresolucionFacturacion) {
        this.idresolucionFacturacion = idresolucionFacturacion;
    }

    public Resolucionfacturacion(Integer idresolucionFacturacion, int tipoResolucion, int rangoInicial, int rangoFinal, int secuencia, int estado, String numeroResolucion, Date fechaExpedicion, Date fechaVigencia) {
        this.idresolucionFacturacion = idresolucionFacturacion;
        this.tipoResolucion = tipoResolucion;
        this.rangoInicial = rangoInicial;
        this.rangoFinal = rangoFinal;
        this.secuencia = secuencia;
        this.estado = estado;
        this.numeroResolucion = numeroResolucion;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVigencia = fechaVigencia;
    }

    public Integer getIdresolucionFacturacion() {
        return idresolucionFacturacion;
    }

    public void setIdresolucionFacturacion(Integer idresolucionFacturacion) {
        this.idresolucionFacturacion = idresolucionFacturacion;
    }

    public int getTipoResolucion() {
        return tipoResolucion;
    }

    public void setTipoResolucion(int tipoResolucion) {
        this.tipoResolucion = tipoResolucion;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public int getRangoInicial() {
        return rangoInicial;
    }

    public void setRangoInicial(int rangoInicial) {
        this.rangoInicial = rangoInicial;
    }

    public int getRangoFinal() {
        return rangoFinal;
    }

    public void setRangoFinal(int rangoFinal) {
        this.rangoFinal = rangoFinal;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNumeroResolucion() {
        return numeroResolucion;
    }

    public void setNumeroResolucion(String numeroResolucion) {
        this.numeroResolucion = numeroResolucion;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public Empresas getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresas idempresa) {
        this.idempresa = idempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresolucionFacturacion != null ? idresolucionFacturacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resolucionfacturacion)) {
            return false;
        }
        Resolucionfacturacion other = (Resolucionfacturacion) object;
        if ((this.idresolucionFacturacion == null && other.idresolucionFacturacion != null) || (this.idresolucionFacturacion != null && !this.idresolucionFacturacion.equals(other.idresolucionFacturacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.entities.Resolucionfacturacion[ idresolucionFacturacion=" + idresolucionFacturacion + " ]";
    }
    
}
