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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dclav
 */
@Entity
@Table(name = "diaslaborales", catalog = "facturacion", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diaslaborales.findAll", query = "SELECT d FROM Diaslaborales d"),
    @NamedQuery(name = "Diaslaborales.findByIddiasLaborales", query = "SELECT d FROM Diaslaborales d WHERE d.iddiasLaborales = :iddiasLaborales"),
    @NamedQuery(name = "Diaslaborales.findByDiaSemana", query = "SELECT d FROM Diaslaborales d WHERE d.diaSemana = :diaSemana"),
    @NamedQuery(name = "Diaslaborales.findByHoraApertura", query = "SELECT d FROM Diaslaborales d WHERE d.horaApertura = :horaApertura"),
    @NamedQuery(name = "Diaslaborales.findByHoraCierre", query = "SELECT d FROM Diaslaborales d WHERE d.horaCierre = :horaCierre"),
    @NamedQuery(name = "Diaslaborales.findByHoraAlmuerzoApertura", query = "SELECT d FROM Diaslaborales d WHERE d.horaAlmuerzoApertura = :horaAlmuerzoApertura"),
    @NamedQuery(name = "Diaslaborales.findByHoraAlmuerzoCierre", query = "SELECT d FROM Diaslaborales d WHERE d.horaAlmuerzoCierre = :horaAlmuerzoCierre")})
public class Diaslaborales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddiasLaborales")
    private Integer iddiasLaborales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diaSemana")
    private int diaSemana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaApertura")
    @Temporal(TemporalType.TIME)
    private Date horaApertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaCierre")
    @Temporal(TemporalType.TIME)
    private Date horaCierre;
    @Column(name = "horaAlmuerzoApertura")
    @Temporal(TemporalType.TIME)
    private Date horaAlmuerzoApertura;
    @Column(name = "horaAlmuerzoCierre")
    @Temporal(TemporalType.TIME)
    private Date horaAlmuerzoCierre;
    @JoinColumn(name = "idSucursal", referencedColumnName = "idsucursal")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Sucursales idSucursal;

    public Diaslaborales() {
    }

    public Diaslaborales(Integer iddiasLaborales) {
        this.iddiasLaborales = iddiasLaborales;
    }

    public Diaslaborales(Integer iddiasLaborales, int diaSemana, Date horaApertura, Date horaCierre) {
        this.iddiasLaborales = iddiasLaborales;
        this.diaSemana = diaSemana;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public Integer getIddiasLaborales() {
        return iddiasLaborales;
    }

    public void setIddiasLaborales(Integer iddiasLaborales) {
        this.iddiasLaborales = iddiasLaborales;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Date getHoraAlmuerzoApertura() {
        return horaAlmuerzoApertura;
    }

    public void setHoraAlmuerzoApertura(Date horaAlmuerzoApertura) {
        this.horaAlmuerzoApertura = horaAlmuerzoApertura;
    }

    public Date getHoraAlmuerzoCierre() {
        return horaAlmuerzoCierre;
    }

    public void setHoraAlmuerzoCierre(Date horaAlmuerzoCierre) {
        this.horaAlmuerzoCierre = horaAlmuerzoCierre;
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
        hash += (iddiasLaborales != null ? iddiasLaborales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diaslaborales)) {
            return false;
        }
        Diaslaborales other = (Diaslaborales) object;
        if ((this.iddiasLaborales == null && other.iddiasLaborales != null) || (this.iddiasLaborales != null && !this.iddiasLaborales.equals(other.iddiasLaborales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.Diaslaborales[ iddiasLaborales=" + iddiasLaborales + " ]";
    }
    
}
