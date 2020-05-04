/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.capitulo.jpa.entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fcastillo
 */
@Entity
@Table(name = "Carreras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carreras.findAll", query = "SELECT c FROM Carreras c"),
    @NamedQuery(name = "Carreras.findByIdcarrera", query = "SELECT c FROM Carreras c WHERE c.idcarrera = :idcarrera"),
    @NamedQuery(name = "Carreras.findByNombre", query = "SELECT c FROM Carreras c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Carreras.findByTipo", query = "SELECT c FROM Carreras c WHERE c.tipo = :tipo")})
public class Carreras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcarrera")
    private Integer idcarrera;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "tipo")
    private int tipo;
    @JoinColumn(name = "idfacultad", referencedColumnName = "idfacultad")
    @ManyToOne(optional = false)
    private Facultades idfacultad;

    public Carreras() {
    }

    public Carreras(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    public Carreras(Integer idcarrera, String nombre, int tipo) {
        this.idcarrera = idcarrera;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Facultades getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(Facultades idfacultad) {
        this.idfacultad = idfacultad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarrera != null ? idcarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carreras)) {
            return false;
        }
        Carreras other = (Carreras) object;
        if ((this.idcarrera == null && other.idcarrera != null) || (this.idcarrera != null && !this.idcarrera.equals(other.idcarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fcastillo.capitulo.jpa.entidades.Carreras[ idcarrera=" + idcarrera + " ]";
    }
    
}
