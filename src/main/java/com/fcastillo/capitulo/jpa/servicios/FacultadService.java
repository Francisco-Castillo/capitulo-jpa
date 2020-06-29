/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.capitulo.jpa.servicios;

import com.fcastillo.capitulo.jpa.entidades.Facultades;
import com.fcastillo.capitulo.jpa.interf.Operaciones;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author fcastillo
 */
public class FacultadService implements Operaciones<Facultades> {

    private static final String CONSULTA = "SELECT f " + " FROM  Facultades f " + " WHERE f.nombre = :nombre AND " + " f.abreviatura = :abreviatura";

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
        em.getTransaction().commit();
        return facultad;
    }

    public void buscarPorNombre(String nombre, String abreviatura) {

        try {
            String consulta2 = "SELECT f " + "FROM Facultades f " + " WHERE " + "f.nombre='" + nombre + "'" + " AND f.abreviatura= '" + abreviatura + "'";
            //String consulta = "SELECT f " + " FROM  Facultades f " + " WHERE f.nombre = :nombre AND " + " f.abreviatura = :abreviatura";

            em.getTransaction().begin();
            Query query = em.createQuery(consulta2, Facultades.class);
//                    .setParameter("nombre", nombre)
//                    .setParameter("abreviatura", abreviatura);

            List<Facultades> lista = query.getResultList();

            em.getTransaction().commit();
            System.out.println("-----------------------------------------------------------------------");
            lista.stream().forEach(x -> {
                System.out.println(x.getIdfacultad() + "| " + x.getNombre() + " | " + x.getAbreviatura());
            });
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }

    }
}
