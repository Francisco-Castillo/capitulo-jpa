package com.fcastillo.capitulo.jpa.principal;


import com.fcastillo.capitulo.jpa.entidades.Facultades;
import com.fcastillo.capitulo.jpa.servicios.FacultadService;
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

            Facultades facultad = new Facultades(47, "Facultad de Arquitectura");
            
            servicio.insertar(facultad);

        } catch (Exception e) {
            System.out.println("Ocurrio un error : " + e.getMessage());
        }
    }

}
