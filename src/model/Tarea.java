package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase abstracta que representa una tarea en el sistema To-Do List.
 * Contiene los atributos y comportamientos comunes a todos los tipos de tareas
 * (Trabajo, Personal, Estudio). Implementa la interfaz Notificable.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see TareaTrabajo
 * @see TareaPersonal
 * @see TareaEstudio
 * @see Notificable
 */
public abstract class Tarea implements Notificable {
    
    // ==================== ATRIBUTOS ====================
    
    /** Identificador unico de la tarea. */
    protected int idTarea;
    
    /** Titulo o nombre de la tarea. */
    protected String titulo;
    
    /** Descripcion detallada de la tarea. */
    protected String descripcion;
    
    /** Fecha limite para completar la tarea. */
    protected LocalDateTime fechaLimite;
    
    /** Prioridad de la tarea (ALTA, MEDIA, BAJA). */
    protected Prioridad prioridad;
    
    /** Indica si la tarea ya fue completada. */
    protected boolean completada;
    
    /** Contador estatico para generar IDs unicos. */
    private static int contadorIds = 1;
    
    /**
     * Constructor para crear una nueva tarea.
     * Asigna un ID unico automaticamente y establece completada como false.
     * 
     * @param titulo Titulo de la tarea
     * @param descripcion Descripcion detallada
     * @param fechaLimite Fecha limite para completar
     * @param prioridad Prioridad de la tarea
     */
    public Tarea(String titulo, String descripcion, LocalDateTime fechaLimite, Prioridad prioridad) {
        this.idTarea = contadorIds++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.prioridad = prioridad;
        this.completada = false;
    }
    
    /**
     * Marca la tarea como completada.
     * Cambia el estado completada a true.
     */
    public void marcarCompletada() {
        this.completada = true;
    }
    
    /**
     * Envia una notificacion sobre la tarea.
     * Implementacion de la interfaz Notificable.
     * 
     * @param mensaje Mensaje a enviar en la notificacion
     */
    @Override
    public void notificar(String mensaje) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("\n[NOTIFICACION] Tarea: " + titulo);
        System.out.println("  Mensaje: " + mensaje);
        System.out.println("  Fecha limite: " + fechaLimite.format(formatter));
    }
    
    /**
     * Obtiene el tipo especifico de tarea.
     * Metodo abstracto implementado por las subclases.
     * 
     * @return Tipo de tarea (Trabajo, Personal, Estudio)
     */
    public abstract String getTipoTarea();
    
    /**
     * Obtiene los detalles especificos de la tarea segun su tipo.
     * Metodo abstracto implementado por las subclases.
     * 
     * @return Cadena con detalles especificos
     */
    public abstract String getDetallesEspecificos();
    
    // ==================== GETTERS Y SETTERS ====================
    
    /** @return Identificador unico de la tarea */
    public int getIdTarea() { return idTarea; }
    
    /** @return Titulo de la tarea */
    public String getTitulo() { return titulo; }
    
    /** @param titulo Nuevo titulo de la tarea */
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    /** @return Descripcion de la tarea */
    public String getDescripcion() { return descripcion; }
    
    /** @param descripcion Nueva descripcion */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    /** @return Fecha limite de la tarea */
    public LocalDateTime getFechaLimite() { return fechaLimite; }
    
    /** @param fechaLimite Nueva fecha limite */
    public void setFechaLimite(LocalDateTime fechaLimite) { this.fechaLimite = fechaLimite; }
    
    /** @return Prioridad de la tarea */
    public Prioridad getPrioridad() { return prioridad; }
    
    /** @param prioridad Nueva prioridad */
    public void setPrioridad(Prioridad prioridad) { this.prioridad = prioridad; }
    
    /** @return true si la tarea esta completada */
    public boolean isCompletada() { return completada; }
    
    /**
     * Devuelve una representacion textual de la tarea.
     * Formato: "[id] titulo (prioridad) - Completada: si/no"
     * 
     * @return Cadena con la informacion principal de la tarea
     */
    @Override
    public String toString() {
        String estado = completada ? "✓ Completada" : "○ Pendiente";
        return "[" + idTarea + "] " + titulo + " (" + prioridad + ") - " + estado;
    }
    
}//fin de la clase