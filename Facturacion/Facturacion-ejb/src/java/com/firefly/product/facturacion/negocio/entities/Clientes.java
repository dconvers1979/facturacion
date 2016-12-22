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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdclientes", query = "SELECT c FROM Clientes c WHERE c.idclientes = :idclientes"),
    @NamedQuery(name = "Clientes.findByTipoCliente", query = "SELECT c FROM Clientes c WHERE c.tipoCliente = :tipoCliente"),
    @NamedQuery(name = "Clientes.findByRazonSocial", query = "SELECT c FROM Clientes c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Clientes.findByTipoDocumento", query = "SELECT c FROM Clientes c WHERE c.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Clientes.findByDocumento", query = "SELECT c FROM Clientes c WHERE c.documento = :documento"),
    @NamedQuery(name = "Clientes.findByFechaNacimiento", query = "SELECT c FROM Clientes c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Clientes.findByTelefono", query = "SELECT c FROM Clientes c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Clientes.findByDireccion", query = "SELECT c FROM Clientes c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Clientes.findByCorreoElectronico", query = "SELECT c FROM Clientes c WHERE c.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Clientes.findByCliente", query = "SELECT c FROM Clientes c WHERE c.cliente = :cliente"),
    @NamedQuery(name = "Clientes.findByProveedor", query = "SELECT c FROM Clientes c WHERE c.proveedor = :proveedor"),
    @NamedQuery(name = "Clientes.findByPaginaWeb", query = "SELECT c FROM Clientes c WHERE c.paginaWeb = :paginaWeb"),
    @NamedQuery(name = "Clientes.findByEstado", query = "SELECT c FROM Clientes c WHERE c.estado = :estado"),
    @NamedQuery(name = "Clientes.findByDigitoVerificacion", query = "SELECT c FROM Clientes c WHERE c.digitoVerificacion = :digitoVerificacion"),
    @NamedQuery(name = "Clientes.findByPrimerNombre", query = "SELECT c FROM Clientes c WHERE c.primerNombre = :primerNombre"),
    @NamedQuery(name = "Clientes.findBySegundoNombre", query = "SELECT c FROM Clientes c WHERE c.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Clientes.findByPrimerApellido", query = "SELECT c FROM Clientes c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "Clientes.findBySegundoApellido", query = "SELECT c FROM Clientes c WHERE c.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Clientes.findByPais", query = "SELECT c FROM Clientes c WHERE c.pais = :pais"),
    @NamedQuery(name = "Clientes.findByDepartamento", query = "SELECT c FROM Clientes c WHERE c.departamento = :departamento"),
    @NamedQuery(name = "Clientes.findByCiudad", query = "SELECT c FROM Clientes c WHERE c.ciudad = :ciudad")})
public class Clientes implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private Collection<Factura> facturaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclientes")
    private Integer idclientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoCliente")
    private int tipoCliente;
    @Size(max = 150)
    @Column(name = "razonSocial")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoDocumento")
    private int tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "documento")
    private String documento;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Column(name = "cliente")
    private Boolean cliente;
    @Column(name = "proveedor")
    private Boolean proveedor;
    @Size(max = 100)
    @Column(name = "paginaWeb")
    private String paginaWeb;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "digitoVerificacion")
    private Integer digitoVerificacion;
    @Size(max = 45)
    @Column(name = "primerNombre")
    private String primerNombre;
    @Size(max = 45)
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Size(max = 45)
    @Column(name = "primerApellido")
    private String primerApellido;
    @Size(max = 45)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Size(max = 45)
    @Column(name = "pais")
    private String pais;
    @Size(max = 45)
    @Column(name = "departamento")
    private String departamento;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(mappedBy = "idrepresentantelegal")
    private Collection<Clientes> clientesCollection;
    @JoinColumn(name = "idrepresentantelegal", referencedColumnName = "idclientes")
    @ManyToOne
    private Clientes idrepresentantelegal;

    public Clientes() {
    }

    public Clientes(Integer idclientes) {
        this.idclientes = idclientes;
    }

    public Clientes(Integer idclientes, int tipoCliente, int tipoDocumento, String documento) {
        this.idclientes = idclientes;
        this.tipoCliente = tipoCliente;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }

    public Integer getIdclientes() {
        return idclientes;
    }

    public void setIdclientes(Integer idclientes) {
        this.idclientes = idclientes;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }

    public Boolean getProveedor() {
        return proveedor;
    }

    public void setProveedor(Boolean proveedor) {
        this.proveedor = proveedor;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(Integer digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    public Clientes getIdrepresentantelegal() {
        return idrepresentantelegal;
    }

    public void setIdrepresentantelegal(Clientes idrepresentantelegal) {
        this.idrepresentantelegal = idrepresentantelegal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclientes != null ? idclientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idclientes == null && other.idclientes != null) || (this.idclientes != null && !this.idclientes.equals(other.idclientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firefly.product.facturacion.negocio.entities.Clientes[ idclientes=" + idclientes + " ]";
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }
    
}
