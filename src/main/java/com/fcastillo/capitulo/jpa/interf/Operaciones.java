
package com.fcastillo.capitulo.jpa.interf;

/**
 *
 * @author fcastillo
 * @param <T>
 */
public interface Operaciones<T> {

    public void insertar(T entidad);

    public void eliminar(T entidad);

    public void actualizar(T entidad);

    public T buscar(T entidad);

}
