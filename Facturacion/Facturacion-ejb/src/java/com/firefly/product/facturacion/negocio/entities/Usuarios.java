/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.negocio.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dclav
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdusuarios", query = "SELECT u FROM Usuarios u WHERE u.idusuarios = :idusuarios"),
    @NamedQuery(name = "Usuarios.findByPrimerNombre", query = "SELECT u FROM Usuarios u WHERE u.primerNombre = :primerNombre"),
    @NamedQuery(name = "Usuarios.findBySegundoNombre", query = "SELECT u FROM Usuarios u WHERE u.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Usuarios.findByPrimerApellido", query = "SELECT u FROM Usuarios u WHERE u.primerApellido = :primerApellido"),
    @NamedQuery(name = "Usuarios.findBySegundoApellido", query = "SELECT u FROM Usuarios u WHERE u.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Usuarios.findByCorreoElectronico", query = "SELECT u FROM Usuarios u WHERE u.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuarios.findByFechaNacimiento", query = "SELECT u FROM Usuarios u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuarios.findByLogin", query = "SELECT u FROM Usuarios u WHERE u.login = :login"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByFechaCreacion", query = "SELECT u FROM Usuarios u WHERE u.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Usuarios.findByEstado", query = "SELECT u FROM Usuarios u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuarios.findByAutoriza", query = "SELECT u FROM Usuarios u WHERE u.autoriza = :autoriza")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuarios")
    private Integer idusuarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "primerNombre")
    private String primerNombre;
    @Size(max = 100)
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "primerApellido")
    private String primerApellido;
    @Size(max = 100)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Column(name = "autoriza")
    private Short autoriza;
    @OneToMany(mappedBy = "idJefe")
    private Collection<Usuarios> usuariosCollection;
    @JoinColumn(name = "idJefe", referencedColumnName = "idusuarios")
    @ManyToOne
    private Usuarios idJefe;
    @JoinColumn(name = "idcargo", referencedColumnName = "idcargos")
    @ManyToOne
    private Cargos idcargo;

    public Usuarios() {
    }

    public Usuarios(Integer idusuarios) {
        this.idusuarios = idusuarios;
    }

    public Usuarios(Integer idusuarios, String primerNombre, String primerApellido, String correoElectronico, String login, String password, Date fechaCreacion, int estado) {
        this.idusuarios = idusuarios;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.correoElectronico = correoElectronico;
        this.login = login;
        this.password = password;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Integer getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(Integer idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Short getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(Short autoriza) {
        this.autoriza = autoriza;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public Usuarios getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(Usuarios idJefe) {
        this.idJefe = idJefe;
    }

    public Cargos getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Cargos idcargo) {
        this.idcargo = idcargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuarios != null ? idusuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idusuarios == null && other.idusuarios != null) || (this.idusuarios != null && !this.idusuarios.equals(other.idusuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.entities.Usuarios[ idusuarios=" + idusuarios + " ]";
    }
    
}
