package model;

import java.time.LocalDateTime;

/**
 * Clase que representa una tarea de tipo Personal.
 * Hereda de Tarea e incluye atributos especificos como lugar y si requiere compañia.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Tarea
 * @see TareaTrabajo
 * @see TareaEstudio
 */
public class TareaPersonal extends Tarea {
    
    // ==================== ATRIBUTOS ====================
    
    /** Lugar donde se debe realizar la tarea. */
    private String lugar;
    
    /** Indica si la tarea requiere compañia de otras personas. */
    private boolean requiereCompannia;
    
    /**
     * Constructor para crear una tarea personal.
     * 
     * @param titulo Titulo de la tarea
     * @param descripcion Descripcion detallada
     * @param fechaLimite Fecha limite para completar
     * @param prioridad Prioridad de la tarea
     * @param lugar Lugar de realizacion
     * @param requiereCompannia Si requiere compañia
     */
    public TareaPersonal(String titulo, String descripcion, LocalDateTime fechaLimite, 
                         Prioridad prioridad, String lugar, boolean requiereCompannia) {
        super(titulo, descripcion, fechaLimite, prioridad);
        this.lugar = lugar;
        this.requiereCompannia = requiereCompannia;
    }
    
    /**
     * Obtiene el tipo de tarea como texto.
     * 
     * @return "Personal"
     */
    @Override
    public String getTipoTarea() {
        return "Personal";
    }
    
    /**
     * Obtiene los detalles especificos de la tarea personal.
     * 
     * @return Cadena con lugar y estado de compañia
     */
    @Override
    public String getDetallesEspecificos() {
        return "Lugar: " + lugar + ", Requiere compañia: " + (requiereCompannia ? "Si" : "No");
    }
    
    // ==================== GETTERS Y SETTERS ====================
    
    /** @return Lugar de la tarea */
    public String getLugar() { return lugar; }
    
    /** @param lugar Nuevo lugar */
    public void setLugar(String lugar) { this.lugar = lugar; }
    
    /** @return true si requiere compañia */
    public boolean isRequiereCompannia() { return requiereCompannia; }
    
    /** @param requiereCompannia Nueva condicion de compañia */
    public void setRequiereCompannia(boolean requiereCompannia) { this.requiereCompannia = requiereCompannia; }
    
}//fin de la clase