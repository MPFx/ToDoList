package model;

/**
 * Clase que representa una categoria de tareas.
 * Permite clasificar las tareas en diferentes grupos como Trabajo, Personal o Estudio.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Tarea
 */
public class Categoria {
    
    /** Nombre de la categoria (ej: Trabajo, Personal, Estudio). */
    private String nombreCategoria;
    
    /** Descripcion detallada de la categoria. */
    private String descripcion;
    
    /**
     * Constructor para crear una nueva categoria.
     * 
     * @param nombreCategoria Nombre de la categoria
     */
    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    /**
     * Obtiene el nombre de la categoria.
     * 
     * @return Nombre de la categoria
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }
    
    /**
     * Establece el nombre de la categoria.
     * 
     * @param nombreCategoria Nuevo nombre de la categoria
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    /**
     * Obtiene la descripcion de la categoria.
     * 
     * @return Descripcion de la categoria
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Establece la descripcion de la categoria.
     * 
     * @param descripcion Nueva descripcion de la categoria
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Devuelve una representacion textual de la categoria.
     * 
     * @return Nombre de la categoria
     */
    @Override
    public String toString() {
        return nombreCategoria;
    }
    
}//fin de la clase