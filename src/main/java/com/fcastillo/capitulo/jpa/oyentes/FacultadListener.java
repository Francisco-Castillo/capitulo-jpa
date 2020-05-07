package com.fcastillo.capitulo.jpa.oyentes;

import com.fcastillo.capitulo.jpa.entidades.Facultades;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 *
 * @author fcastillo
 */
public class FacultadListener {

    @PostPersist
    public void postPersistencia(Facultades facultad) {
        System.out.println("Se inserto una nueva " + facultad.getNombre());
    }

    @PrePersist
    public void prePersistencia(Facultades facultades) {
        // Convertimos a mayusculas
        facultades.setNombre(facultades.getNombre().toUpperCase());
        
        // Obtenemos los tres primeros caracteres
        String abreviatura = facultades.getNombre().substring(0, 3);
        facultades.setAbreviatura(abreviatura);
    }

}
