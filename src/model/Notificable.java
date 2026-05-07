package model;

/**
 * Interfaz que define el comportamiento notificable para las tareas.
 * Las clases que implementen esta interfaz podran enviar notificaciones.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 */
public interface Notificable {
    
    /**
     * Envia una notificacion con un mensaje especifico.
     * 
     * @param mensaje Contenido de la notificacion a enviar
     */
    void notificar(String mensaje);
    
}//fin de la interface