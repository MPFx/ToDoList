package service;

import model.ListaTareas;
import model.Tarea;
import model.Prioridad;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import model.TareaEstudio;
import model.TareaPersonal;
import model.TareaTrabajo;

/**
 * Clase de servicio que gestiona las operaciones logicas del sistema de tareas.
 * Proporciona funcionalidades para crear tareas, listar, completar, filtrar,
 * buscar y ordenar tareas segun diferentes criterios.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see ListaTareas
 * @see Tarea
 */
public class TareaService {
    
    // ==================== ATRIBUTOS ====================
    
    /** Lista de tareas gestionada por el servicio. */
    private ListaTareas listaTareas;
    
    /**
     * Constructor del servicio de tareas.
     * Inicializa la lista de tareas vacia.
     */
    public TareaService() {
        this.listaTareas = new ListaTareas();
    }
    
    /**
     * Obtiene la lista de tareas actual.
     * 
     * @return Lista de tareas
     */
    public ListaTareas getListaTareas() {
        return listaTareas;
    }
    
    /**
     * Agrega una tarea a la lista.
     * 
     * @param tarea Tarea a agregar
     */
    public void agregarTarea(Tarea tarea) {
        listaTareas.agregarTarea(tarea);
        System.out.println("Tarea agregada exitosamente!");
    }
    
    /**
     * Elimina una tarea por su ID.
     * 
     * @param idTarea Identificador de la tarea
     * @return true si se elimino, false si no existe
     */
    public boolean eliminarTarea(int idTarea) {
        boolean eliminado = listaTareas.eliminarTarea(idTarea);
        if (eliminado) {
            System.out.println("Tarea eliminada exitosamente!");
        } else {
            System.out.println("No se encontro tarea con ID: " + idTarea);
        }
        return eliminado;
    }
    
    /**
     * Marca una tarea como completada por su ID.
     * 
     * @param idTarea Identificador de la tarea
     */
    public void completarTarea(int idTarea) {
        Tarea tarea = listaTareas.buscarTarea(idTarea);
        if (tarea != null) {
            tarea.marcarCompletada();
            System.out.println("Tarea completada! Felicidades!");
            tarea.notificar("Tarea \"" + tarea.getTitulo() + "\" ha sido completada");
        } else {
            System.out.println("No se encontro tarea con ID: " + idTarea);
        }
    }
    
    /**
     * Lista todas las tareas registradas.
     */
    public void listarTareas() {
        List<Tarea> tareas = listaTareas.getTodasLasTareas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }
        
        System.out.println("\n=== LISTA DE TAREAS ===");
        for (Tarea t : tareas) {
            System.out.println(t);
            System.out.println("  Tipo: " + t.getTipoTarea());
            System.out.println("  Detalles: " + t.getDetallesEspecificos());
            System.out.println("  Fecha limite: " + t.getFechaLimite());
            System.out.println("-----------------------------------");
        }
    }
    
    /**
     * Muestra las tareas pendientes (no completadas).
     */
    public void mostrarPendientes() {
        List<Tarea> pendientes = listaTareas.obtenerPendientes();
        if (pendientes.isEmpty()) {
            System.out.println("No hay tareas pendientes. Buen trabajo!");
            return;
        }
        
        System.out.println("\n=== TAREAS PENDIENTES ===");
        for (Tarea t : pendientes) {
            System.out.println(t);
            System.out.println("  Fecha limite: " + t.getFechaLimite());
        }
    }
    
    /**
     * Muestra las tareas ordenadas por prioridad (ALTA primero).
     */
    public void mostrarPorPrioridad() {
        List<Tarea> ordenadas = listaTareas.ordenarPorPrioridad();
        if (ordenadas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }
        
        System.out.println("\n=== TAREAS ORDENADAS POR PRIORIDAD ===");
        for (Tarea t : ordenadas) {
            System.out.println(t);
        }
    }
    
    /**
     * Filtra y muestra tareas por categoria (Trabajo, Personal, Estudio).
     * 
     * @param categoria Categoria a filtrar
     */
    public void filtrarPorCategoria(String categoria) {
        List<Tarea> filtradas = listaTareas.filtrarPorCategoria(categoria);
        if (filtradas.isEmpty()) {
            System.out.println("No hay tareas en la categoria: " + categoria);
            return;
        }
        
        System.out.println("\n=== TAREAS DE CATEGORIA: " + categoria.toUpperCase() + " ===");
        for (Tarea t : filtradas) {
            System.out.println(t);
            System.out.println("  " + t.getDetallesEspecificos());
        }
    }
    
    /**
     * Busca y muestra tareas por palabra clave.
     * 
     * @param palabra Palabra clave a buscar
     */
    public void buscarPorPalabraClave(String palabra) {
        List<Tarea> resultados = listaTareas.buscarPorPalabraClave(palabra);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron tareas con: " + palabra);
            return;
        }
        
        System.out.println("\n=== RESULTADOS DE BUSQUEDA: " + palabra + " ===");
        for (Tarea t : resultados) {
            System.out.println(t);
        }
    }
    
    /**
     * Filtra y muestra tareas por su estado (completadas/pendientes).
     * 
     * @param completada true para ver completadas, false para pendientes
     */
    public void filtrarPorEstado(boolean completada) {
        List<Tarea> filtradas = listaTareas.filtrarPorEstado(completada);
        String estado = completada ? "COMPLETADAS" : "PENDIENTES";
        
        if (filtradas.isEmpty()) {
            System.out.println("No hay tareas " + estado.toLowerCase());
            return;
        }
        
        System.out.println("\n=== TAREAS " + estado + " ===");
        for (Tarea t : filtradas) {
            System.out.println(t);
        }
    }
    
    /**
     * Muestra los detalles completos de una tarea especifica.
     * 
     * @param idTarea Identificador de la tarea
     */
    public void verDetalleTarea(int idTarea) {
        Tarea tarea = listaTareas.buscarTarea(idTarea);
        if (tarea == null) {
            System.out.println("No se encontro tarea con ID: " + idTarea);
            return;
        }
        
        System.out.println("\n=== DETALLE DE TAREA ===");
        System.out.println("ID: " + tarea.getIdTarea());
        System.out.println("Titulo: " + tarea.getTitulo());
        System.out.println("Descripcion: " + tarea.getDescripcion());
        System.out.println("Tipo: " + tarea.getTipoTarea());
        System.out.println("Prioridad: " + tarea.getPrioridad());
        System.out.println("Fecha limite: " + tarea.getFechaLimite());
        System.out.println("Estado: " + (tarea.isCompletada() ? "Completada" : "Pendiente"));
        System.out.println("Detalles especificos: " + tarea.getDetallesEspecificos());
    }
    
    /**
     * Crea una nueva tarea interactivamente solicitando datos al usuario.
     * 
     * @param scanner Scanner para entrada de datos
     * @param tipo TareaTrabajo, TareaPersonal o TareaEstudio
     */
    public void crearTareaInteractiva(Scanner scanner, String tipo) {
        System.out.println("\n=== CREAR NUEVA TAREA ===");
        
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Fecha limite (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        System.out.print("Hora limite (HH:MM): ");
        String horaStr = scanner.nextLine();
        LocalDateTime fechaLimite = LocalDateTime.parse(fechaStr + "T" + horaStr + ":00");
        
        System.out.println("Prioridad:");
        System.out.println("1. ALTA");
        System.out.println("2. MEDIA");
        System.out.println("3. BAJA");
        System.out.print("Seleccione: ");
        int prioridadOpcion = Integer.parseInt(scanner.nextLine());
        Prioridad prioridad = switch(prioridadOpcion) {
            case 1 -> Prioridad.ALTA;
            case 2 -> Prioridad.MEDIA;
            default -> Prioridad.BAJA;
        };
        
        Tarea nuevaTarea = null;
        
        switch(tipo) {
            case "Trabajo":
                System.out.print("Proyecto: ");
                String proyecto = scanner.nextLine();
                System.out.print("Cliente: ");
                String cliente = scanner.nextLine();
                System.out.print("Horas estimadas: ");
                int horas = Integer.parseInt(scanner.nextLine());
                nuevaTarea = new TareaTrabajo(titulo, descripcion, fechaLimite, prioridad, proyecto, cliente, horas);
                break;
                
            case "Personal":
                System.out.print("Lugar: ");
                String lugar = scanner.nextLine();
                System.out.print("Requiere compañia? (S/N): ");
                boolean requiere = scanner.nextLine().equalsIgnoreCase("S");
                nuevaTarea = new TareaPersonal(titulo, descripcion, fechaLimite, prioridad, lugar, requiere);
                break;
                
            case "Estudio":
                System.out.print("Materia: ");
                String materia = scanner.nextLine();
                System.out.print("Calificacion esperada: ");
                double calificacion = Double.parseDouble(scanner.nextLine());
                nuevaTarea = new TareaEstudio(titulo, descripcion, fechaLimite, prioridad, materia, calificacion);
                break;
        }
        
        if (nuevaTarea != null) {
            agregarTarea(nuevaTarea);
        }
    }
    
}//fin de la clase