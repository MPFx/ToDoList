package model;

import java.time.LocalDateTime;

/**
 * Clase que representa una tarea de tipo Estudio.
 * Hereda de Tarea e incluye atributos especificos como materia y calificacion esperada.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Tarea
 * @see TareaTrabajo
 * @see TareaPersonal
 */
public class TareaEstudio extends Tarea {
    
    // ==================== ATRIBUTOS ====================
    
    /** Materia o asignatura relacionada con la tarea. */
    private String materia;
    
    /** Calificacion esperada al completar la tarea. */
    private double calificacionEsperada;
    
    /**
     * Constructor para crear una tarea de estudio.
     * 
     * @param titulo Titulo de la tarea
     * @param descripcion Descripcion detallada
     * @param fechaLimite Fecha limite para completar
     * @param prioridad Prioridad de la tarea
     * @param materia Materia relacionada
     * @param calificacionEsperada Calificacion esperada
     */
    public TareaEstudio(String titulo, String descripcion, LocalDateTime fechaLimite, 
                        Prioridad prioridad, String materia, double calificacionEsperada) {
        super(titulo, descripcion, fechaLimite, prioridad);
        this.materia = materia;
        this.calificacionEsperada = calificacionEsperada;
    }
    
    /**
     * Obtiene el tipo de tarea como texto.
     * 
     * @return "Estudio"
     */
    @Override
    public String getTipoTarea() {
        return "Estudio";
    }
    
    /**
     * Obtiene los detalles especificos de la tarea de estudio.
     * 
     * @return Cadena con materia y calificacion esperada
     */
    @Override
    public String getDetallesEspecificos() {
        return "Materia: " + materia + ", Calificacion esperada: " + calificacionEsperada;
    }
    
    // ==================== GETTERS Y SETTERS ====================
    
    /** @return Materia de la tarea */
    public String getMateria() { return materia; }
    
    /** @param materia Nueva materia */
    public void setMateria(String materia) { this.materia = materia; }
    
    /** @return Calificacion esperada */
    public double getCalificacionEsperada() { return calificacionEsperada; }
    
    /** @param calificacionEsperada Nueva calificacion esperada */
    public void setCalificacionEsperada(double calificacionEsperada) { this.calificacionEsperada = calificacionEsperada; }
    
}//fin de la clase