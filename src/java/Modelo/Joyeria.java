/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "joyeria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Joyeria.findAll", query = "SELECT j FROM Joyeria j")
    , @NamedQuery(name = "Joyeria.findByIDJoyeria", query = "SELECT j FROM Joyeria j WHERE j.iDJoyeria = :iDJoyeria")
    , @NamedQuery(name = "Joyeria.findByNombre", query = "SELECT j FROM Joyeria j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Joyeria.findByUbicacion", query = "SELECT j FROM Joyeria j WHERE j.ubicacion = :ubicacion")
    , @NamedQuery(name = "Joyeria.findByDireccion", query = "SELECT j FROM Joyeria j WHERE j.direccion = :direccion")
    , @NamedQuery(name = "Joyeria.findByNombreEncargado", query = "SELECT j FROM Joyeria j WHERE j.nombreEncargado = :nombreEncargado")
    , @NamedQuery(name = "Joyeria.findByDimensionLocal", query = "SELECT j FROM Joyeria j WHERE j.dimensionLocal = :dimensionLocal")
    , @NamedQuery(name = "Joyeria.findByCiudad", query = "SELECT j FROM Joyeria j WHERE j.ciudad = :ciudad")})
public class Joyeria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDJoyeria")
    private Integer iDJoyeria;
    @Size(max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "Ubicacion")
    private String ubicacion;
    @Size(max = 50)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "NombreEncargado")
    private String nombreEncargado;
    @Column(name = "DimensionLocal")
    private Integer dimensionLocal;
    @Size(max = 20)
    @Column(name = "Ciudad")
    private String ciudad;

    public Joyeria() {
    }

    public Joyeria(Integer iDJoyeria) {
        this.iDJoyeria = iDJoyeria;
    }

    public Integer getIDJoyeria() {
        return iDJoyeria;
    }

    public void setIDJoyeria(Integer iDJoyeria) {
        this.iDJoyeria = iDJoyeria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public Integer getDimensionLocal() {
        return dimensionLocal;
    }

    public void setDimensionLocal(Integer dimensionLocal) {
        this.dimensionLocal = dimensionLocal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDJoyeria != null ? iDJoyeria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joyeria)) {
            return false;
        }
        Joyeria other = (Joyeria) object;
        if ((this.iDJoyeria == null && other.iDJoyeria != null) || (this.iDJoyeria != null && !this.iDJoyeria.equals(other.iDJoyeria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Joyeria[ iDJoyeria=" + iDJoyeria + " ]";
    }

    public Joyeria(Integer iDJoyeria, String nombre, String ubicacion, String direccion, String nombreEncargado, Integer dimensionLocal, String ciudad) {
        this.iDJoyeria = iDJoyeria;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.nombreEncargado = nombreEncargado;
        this.dimensionLocal = dimensionLocal;
        this.ciudad = ciudad;
    }
    
}
