/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.capitulo.jpa.principal;

import com.fcastillo.capitulo.jpa.entidades.Carreras;
import com.fcastillo.capitulo.jpa.entidades.Facultades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author fcastillo
 */
public class App {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("capituloJPA");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        try {
            List<Carreras> lista = findCarrerasByIdCB(1);
            // recorremos 
            lista.forEach((x) -> {
                System.out.println(x.getIdcarrera() + "\t" + x.getNombre());
            });
        } catch (Exception e) {
            System.out.println("Ocurrio un error : " + e.getMessage());
        }
    }

    private static void listarCarreras() {

        try {
            String consulta = "FROM Carreras c";
            TypedQuery<Carreras> query = em.createQuery(consulta, Carreras.class);
            List<Carreras> lista = query.getResultList();

            // Recorremos la lista e imprimimos sus elementos sus elementos
            lista.forEach((c) -> {
                System.out.println("Carrera : " + c.getNombre());
            });

        } catch (Exception e) {
            System.out.println("ocurrio un error : " + e.getLocalizedMessage());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="listarCarrerasCB()">
    private static void listarCarrerasCB() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Carreras.class);

        Root<Carreras> raiz = criteriaQuery.from(Carreras.class);

        criteriaQuery.select(raiz);
        TypedQuery<Carreras> query = em.createQuery(criteriaQuery);

        List<Carreras> lista = query.getResultList();

        lista.forEach(x -> {
            System.out.println("Carrera : " + x.getNombre());
        });
    }//</editor-fold>

    // Consultas parametrizadas
    private static Carreras findCarrerasById(int id) {
        String consulta = "";
        Carreras carrera = null;
        try {
            consulta = "FROM Carreras c WHERE c.idcarrera=?1";
            TypedQuery<Carreras> query = em.createQuery(consulta, Carreras.class);
            query.setParameter(1, id);
            if (!query.getResultList().isEmpty()) {
                carrera = query.getSingleResult();
            }
        } catch (Exception e) {

            throw e;
        }
        return carrera;
    }

    private static List<Carreras> findCarrerasByIdCB(int codigoFacultad) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Carreras.class);
        Root<Carreras> raiz = criteriaQuery.from(Carreras.class);

        Join<Carreras, Facultades> joinFacultad = raiz.join("idfacultad", JoinType.INNER);

        criteriaQuery.select(raiz);

        if (codigoFacultad != 0) {
            criteriaQuery.where(criteriaBuilder.equal(joinFacultad.get("idfacultad"), codigoFacultad));
        }

        TypedQuery<Carreras> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
