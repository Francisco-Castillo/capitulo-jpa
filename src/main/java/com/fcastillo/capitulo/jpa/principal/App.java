package com.fcastillo.capitulo.jpa.principal;

import com.fcastillo.capitulo.jpa.entidades.Carreras;
import com.fcastillo.capitulo.jpa.entidades.Facultades;
import com.fcastillo.capitulo.jpa.servicios.FacultadService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fcastillo
 */
public class App {

    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("capituloJPA");
            EntityManager em = emf.createEntityManager();
            FacultadService servicio = new FacultadService(em);

//            Facultades facultad = new Facultades(6, "Facultad de Arquitectura");
//            List<Carreras> listaDeCarreras = new ArrayList<>();
//
//            for (int i = 45; i < 50; i++) {
//                listaDeCarreras.add(new Carreras(i, "Carrera " + i, ThreadLocalRandom.current().nextInt(2, 4), facultad));
//            }
//
//            facultad.setCarrerasList(listaDeCarreras);
//            
//            em.getTransaction().begin();
//            em.persist(facultad);
//            em.getTransaction().commit();
//
            servicio.buscarPorNombre("Facultad de Ciencias Exactas y Tecnologías", "FCEyT");
           
        } catch (Exception e) {
            System.out.println("Ocurrio un error : " + e.getMessage());
        }
    }

}
