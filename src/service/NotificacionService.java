package service;

import model.ListaTareas;
import model.Tarea;
import java.time.LocalDateTime;
import java.util.List;
import model.Prioridad;

/**
 * Clase de servicio que gestiona las notificaciones del sistema de tareas.
 * Permite notificar tareas proximas a vencer, tareas vencidas y enviar
 * recordatorios personalizados.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Tarea
 * @see ListaTareas
 */
public class NotificacionService {
    
    /**
     * Notifica todas las tareas proximas a vencer (menos de 24 horas).
     * 
     * @param listaTareas Lista de tareas a verificar
     */
    public void notificarTareasProximas(ListaTareas listaTareas) {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime limite = ahora.plusDays(1);
        
        List<Tarea> todas = listaTareas.getTodasLasTareas();
        boolean hayProximas = false;
        
        System.out.println("\n=== RECORDATORIO: TAREAS PROXIMAS A VENCER ===");
        
        for (Tarea t : todas) {
            if (!t.isCompletada() && t.getFechaLimite().isBefore(limite) && t.getFechaLimite().isAfter(ahora)) {
                t.notificar("Esta tarea vence en menos de 24 horas");
                hayProximas = true;
            }
        }
        
        if (!hayProximas) {
            System.out.println("No hay tareas proximas a vencer.");
        }
    }
    
    /**
     * Notifica todas las tareas que ya vencieron.
     * 
     * @param listaTareas Lista de tareas a verificar
     */
    public void notificarTareasVencidas(ListaTareas listaTareas) {
        LocalDateTime ahora = LocalDateTime.now();
        List<Tarea> todas = listaTareas.getTodasLasTareas();
        boolean hayVencidas = false;
        
        System.out.println("\n=== ALERTA: TAREAS VENCIDAS ===");
        
        for (Tarea t : todas) {
            if (!t.isCompletada() && t.getFechaLimite().isBefore(ahora)) {
                t.notificar("ESTA TAREA HA VENCIDO!");
                hayVencidas = true;
            }
        }
        
        if (!hayVencidas) {
            System.out.println("No hay tareas vencidas. Buen trabajo!");
        }
    }
    
    /**
     * Envia un recordatorio personalizado para una tarea especifica.
     * 
     * @param tarea Tarea a notificar
     * @param mensaje Mensaje personalizado
     */
    public void enviarRecordatorio(Tarea tarea, String mensaje) {
        if (tarea != null) {
            tarea.notificar(mensaje);
        }
    }
    
    /**
     * Envia un resumen diario de tareas pendientes.
     * 
     * @param listaTareas Lista de tareas
     */
    public void enviarResumenDiario(ListaTareas listaTareas) {
        List<Tarea> pendientes = listaTareas.obtenerPendientes();
        
        System.out.println("\n=== RESUMEN DIARIO DE TAREAS ===");
        System.out.println("Fecha: " + LocalDateTime.now().toLocalDate());
        System.out.println("Total tareas pendientes: " + pendientes.size());
        
        if (!pendientes.isEmpty()) {
            System.out.println("\nTareas pendientes por prioridad:");
            
            long altas = pendientes.stream().filter(t -> t.getPrioridad() == Prioridad.ALTA).count();
            long medias = pendientes.stream().filter(t -> t.getPrioridad() == Prioridad.MEDIA).count();
            long bajas = pendientes.stream().filter(t -> t.getPrioridad() == Prioridad.BAJA).count();
            
            System.out.println("  ALTA: " + altas);
            System.out.println("  MEDIA: " + medias);
            System.out.println("  BAJA: " + bajas);
        }
    }
    
}//fin de la clase