package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que representa una lista de tareas.
 * Gestiona la coleccion de tareas permitiendo agregar, eliminar, buscar,
 * filtrar y ordenar las tareas almacenadas.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see Tarea
 */
public class ListaTareas {
    
    // ==================== ATRIBUTOS ====================
    
    /** Lista de tareas gestionadas. */
    private List<Tarea> listaTareas;
    
    /**
     * Constructor de la lista de tareas.
     * Inicializa la lista como un ArrayList vacio.
     */
    public ListaTareas() {
        this.listaTareas = new ArrayList<>();
    }
    
    /**
     * Agrega una tarea a la lista.
     * 
     * @param tarea Tarea a agregar
     */
    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }
    
    /**
     * Elimina una tarea de la lista por su ID.
     * 
     * @param idTarea Identificador de la tarea a eliminar
     * @return true si la tarea fue eliminada, false si no existia
     */
    public boolean eliminarTarea(int idTarea) {
        return listaTareas.removeIf(t -> t.getIdTarea() == idTarea);
    }
    
    /**
     * Busca una tarea por su ID.
     * 
     * @param idTarea Identificador de la tarea
     * @return Tarea encontrada o null si no existe
     */
    public Tarea buscarTarea(int idTarea) {
        return listaTareas.stream()
                .filter(t -> t.getIdTarea() == idTarea)
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Busca tareas por palabra clave en el titulo o descripcion.
     * 
     * @param palabra Palabra clave a buscar
     * @return Lista de tareas que contienen la palabra
     */
    public List<Tarea> buscarPorPalabraClave(String palabra) {
        return listaTareas.stream()
                .filter(t -> t.getTitulo().toLowerCase().contains(palabra.toLowerCase()) ||
                            t.getDescripcion().toLowerCase().contains(palabra.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Filtra tareas por categoria (tipo de tarea).
     * 
     * @param categoria Tipo de tarea (Trabajo, Personal, Estudio)
     * @return Lista de tareas de la categoria especificada
     */
    public List<Tarea> filtrarPorCategoria(String categoria) {
        return listaTareas.stream()
                .filter(t -> t.getTipoTarea().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }
    
    /**
     * Filtra tareas por estado (completadas o pendientes).
     * 
     * @param completada true para tareas completadas, false para pendientes
     * @return Lista de tareas con el estado especificado
     */
    public List<Tarea> filtrarPorEstado(boolean completada) {
        return listaTareas.stream()
                .filter(t -> t.isCompletada() == completada)
                .collect(Collectors.toList());
    }
    
    /**
     * Ordena las tareas por prioridad (ALTA > MEDIA > BAJA).
     * 
     * @return Lista de tareas ordenadas por prioridad
     */
    public List<Tarea> ordenarPorPrioridad() {
        List<Tarea> ordenadas = new ArrayList<>(listaTareas);
        ordenadas.sort(Comparator.comparing(Tarea::getPrioridad));
        return ordenadas;
    }
    
    /**
     * Obtiene todas las tareas pendientes (no completadas).
     * 
     * @return Lista de tareas pendientes
     */
    public List<Tarea> obtenerPendientes() {
        return filtrarPorEstado(false);
    }
    
    /**
     * Obtiene todas las tareas de la lista.
     * 
     * @return Lista completa de tareas
     */
    public List<Tarea> getTodasLasTareas() {
        return new ArrayList<>(listaTareas);
    }
    
}//fin de la clase