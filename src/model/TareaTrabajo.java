package model;

import java.time.LocalDateTime;

/**
 * Clase que representa una tarea de tipo Trabajo.
 * Hereda de Tarea e incluye atributos especificos como proyecto, cliente y horas estimadas.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Tarea
 * @see TareaPersonal
 * @see TareaEstudio
 */
public class TareaTrabajo extends Tarea {
    
    // ==================== ATRIBUTOS ====================
    
    /** Nombre del proyecto asociado a la tarea. */
    private String proyecto;
    
    /** Nombre del cliente para quien se realiza la tarea. */
    private String cliente;
    
    /** Horas estimadas para completar la tarea. */
    private int horasEstimadas;
    
    /**
     * Constructor para crear una tarea de trabajo.
     * 
     * @param titulo Titulo de la tarea
     * @param descripcion Descripcion detallada
     * @param fechaLimite Fecha limite para completar
     * @param prioridad Prioridad de la tarea
     * @param proyecto Nombre del proyecto
     * @param cliente Nombre del cliente
     * @param horasEstimadas Horas estimadas
     */
    public TareaTrabajo(String titulo, String descripcion, LocalDateTime fechaLimite, 
                        Prioridad prioridad, String proyecto, String cliente, int horasEstimadas) {
        super(titulo, descripcion, fechaLimite, prioridad);
        this.proyecto = proyecto;
        this.cliente = cliente;
        this.horasEstimadas = horasEstimadas;
    }
    
    /**
     * Obtiene el tipo de tarea como texto.
     * 
     * @return "Trabajo"
     */
    @Override
    public String getTipoTarea() {
        return "Trabajo";
    }
    
    /**
     * Obtiene los detalles especificos de la tarea de trabajo.
     * 
     * @return Cadena con proyecto, cliente y horas estimadas
     */
    @Override
    public String getDetallesEspecificos() {
        return "Proyecto: " + proyecto + ", Cliente: " + cliente + ", Horas estimadas: " + horasEstimadas;
    }
    
    // ==================== GETTERS Y SETTERS ====================
    
    /** @return Nombre del proyecto */
    public String getProyecto() { return proyecto; }
    
    /** @param proyecto Nuevo nombre del proyecto */
    public void setProyecto(String proyecto) { this.proyecto = proyecto; }
    
    /** @return Nombre del cliente */
    public String getCliente() { return cliente; }
    
    /** @param cliente Nuevo nombre del cliente */
    public void setCliente(String cliente) { this.cliente = cliente; }
    
    /** @return Horas estimadas */
    public int getHorasEstimadas() { return horasEstimadas; }
    
    /** @param horasEstimadas Nuevas horas estimadas */
    public void setHorasEstimadas(int horasEstimadas) { this.horasEstimadas = horasEstimadas; }
    
}//fin de la clase