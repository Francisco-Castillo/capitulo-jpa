/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.capitulo.jpa.servicios;

import com.fcastillo.capitulo.jpa.entidades.Facultades;
import com.fcastillo.capitulo.jpa.interf.Operaciones;
import javax.persistence.EntityManager;

/**
 *
 * @author fcastillo
 */
public class FacultadService implements Operaciones<Facultades> {

    protected EntityManager em;

    public FacultadService(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insertar(Facultades entidad) {
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(Facultades entidad) {
        em.getTransaction().begin();
        em.remove(entidad);
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Facultades entidad) {
        em.getTransaction().begin();
        em.merge(entidad);
        em.getTransaction().commit();
    }

    @Override
    public Facultades buscar(Facultades entidad) {
        em.getTransaction().begin();
        Facultades facultad = em.find(Facultades.class, entidad.getIdfacultad());
        em.getTransaction().begin();
        return facultad;
    }

}
