package ui;

import service.TareaService;
import service.NotificacionService;
import model.Prioridad;
import java.util.Scanner;

/**
 * Clase que implementa la interfaz de usuario por consola para el sistema To-Do List.
 * Gestiona la interaccion con el usuario, muestra los menus y procesa las opciones
 * seleccionadas. Coordina los servicios de tareas y notificaciones.
 * 
 * @author ISC Israel de Jesus Mar Parada
 * @version 1.0
 * @see TareaService
 * @see NotificacionService
 */
public class MenuConsola {
    
    // ==================== ATRIBUTOS ====================
    
    /** Scanner para leer la entrada del usuario. */
    private Scanner scanner;
    
    /** Servicio para operaciones de tareas. */
    private TareaService tareaService;
    
    /** Servicio para notificaciones. */
    private NotificacionService notificacionService;
    
    /**
     * Constructor del menu de consola.
     * Inicializa el scanner y crea las instancias de los servicios necesarios.
     */
    public MenuConsola() {
        this.scanner = new Scanner(System.in);
        this.tareaService = new TareaService();
        this.notificacionService = new NotificacionService();
    }
    
    /**
     * Inicia el bucle principal del menu.
     * Muestra el menu principal y procesa las opciones seleccionadas
     * hasta que el usuario decide salir.
     */
    public void iniciar() {
        boolean salir = false;
        
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    menuCrearTarea();
                    break;
                case 2:
                    tareaService.listarTareas();
                    break;
                case 3:
                    tareaService.mostrarPendientes();
                    break;
                case 4:
                    menuOperacionesTarea();
                    break;
                case 5:
                    menuFiltrosBusqueda();
                    break;
                case 6:
                    menuNotificaciones();
                    break;
                case 7:
                    System.out.println("\nGracias por usar el Gestor de Tareas!");
                    System.out.println("¡Hasta pronto!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
            
            if (!salir) {
                pausa();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Muestra el menu principal del sistema.
     */
    private void mostrarMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("     GESTOR DE TAREAS PENDIENTES");
        System.out.println("           TO-DO LIST");
        System.out.println("========================================");
        System.out.println("1. Crear nueva tarea");
        System.out.println("2. Listar todas las tareas");
        System.out.println("3. Ver tareas pendientes");
        System.out.println("4. Operaciones sobre tarea");
        System.out.println("5. Filtros y busquedas");
        System.out.println("6. Notificaciones y recordatorios");
        System.out.println("7. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }
    
    /**
     * Menu para crear diferentes tipos de tarea.
     */
    private void menuCrearTarea() {
        System.out.println("\n=== CREAR NUEVA TAREA ===");
        System.out.println("Seleccione el tipo de tarea:");
        System.out.println("1. Trabajo");
        System.out.println("2. Personal");
        System.out.println("3. Estudio");
        System.out.print("Opcion: ");
        
        int opcion = leerOpcion();
        String tipo = switch(opcion) {
            case 1 -> "Trabajo";
            case 2 -> "Personal";
            case 3 -> "Estudio";
            default -> null;
        };
        
        if (tipo != null) {
            tareaService.crearTareaInteractiva(scanner, tipo);
        } else {
            System.out.println("Opcion no valida");
        }
    }
    
    /**
     * Menu para operaciones sobre tareas especificas.
     */
    private void menuOperacionesTarea() {
        System.out.println("\n=== OPERACIONES SOBRE TAREA ===");
        System.out.println("1. Marcar tarea como completada");
        System.out.println("2. Eliminar tarea");
        System.out.println("3. Ver detalle de tarea");
        System.out.print("Seleccione: ");
        
        int opcion = leerOpcion();
        
        System.out.print("Ingrese el ID de la tarea: ");
        int id = leerOpcion();
        
        switch(opcion) {
            case 1:
                tareaService.completarTarea(id);
                break;
            case 2:
                tareaService.eliminarTarea(id);
                break;
            case 3:
                tareaService.verDetalleTarea(id);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
    
    /**
     * Menu para filtros y busquedas.
     */
    private void menuFiltrosBusqueda() {
        System.out.println("\n=== FILTROS Y BUSQUEDAS ===");
        System.out.println("1. Filtrar por prioridad (ordenar)");
        System.out.println("2. Filtrar por categoria (Trabajo/Personal/Estudio)");
        System.out.println("3. Filtrar por estado (Completadas/Pendientes)");
        System.out.println("4. Buscar por palabra clave");
        System.out.print("Seleccione: ");
        
        int opcion = leerOpcion();
        
        switch(opcion) {
            case 1:
                tareaService.mostrarPorPrioridad();
                break;
            case 2:
                System.out.print("Categoria (Trabajo/Personal/Estudio): ");
                String categoria = scanner.nextLine();
                tareaService.filtrarPorCategoria(categoria);
                break;
            case 3:
                System.out.println("1. Pendientes");
                System.out.println("2. Completadas");
                System.out.print("Seleccione: ");
                int estadoOpcion = leerOpcion();
                tareaService.filtrarPorEstado(estadoOpcion == 2);
                break;
            case 4:
                System.out.print("Palabra clave: ");
                String palabra = scanner.nextLine();
                tareaService.buscarPorPalabraClave(palabra);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
    
    /**
     * Menu para notificaciones y recordatorios.
     */
    private void menuNotificaciones() {
        System.out.println("\n=== NOTIFICACIONES Y RECORDATORIOS ===");
        System.out.println("1. Ver tareas proximas a vencer");
        System.out.println("2. Ver tareas vencidas");
        System.out.println("3. Enviar resumen diario");
        System.out.print("Seleccione: ");
        
        int opcion = leerOpcion();
        
        switch(opcion) {
            case 1:
                notificacionService.notificarTareasProximas(tareaService.getListaTareas());
                break;
            case 2:
                notificacionService.notificarTareasVencidas(tareaService.getListaTareas());
                break;
            case 3:
                notificacionService.enviarResumenDiario(tareaService.getListaTareas());
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
    
    /**
     * Lee y valida la opcion ingresada por el usuario.
     * 
     * @return Numero entero de la opcion seleccionada, o 0 si no es valida
     */
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    /**
     * Pausa la ejecucion hasta que el usuario presione Enter.
     */
    private void pausa() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
}//fin de la clase