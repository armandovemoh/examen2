package examenParcial2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ArrayList<String> opcionesTipo;
    private ArrayList<String> opcionesAtaque;

    public Menu() {
        this.scanner = new Scanner(System.in);
        opcionesTipo = new ArrayList<>();
        opcionesAtaque = new ArrayList<>();
    }

    public void inicializarOpciones(List<String> tipos, List<String> ataques) {
        opcionesTipo.addAll(tipos);
        opcionesAtaque.addAll(ataques);
    }

    public void eliminarOpcionTipo(String tipo) {
        opcionesTipo.remove(tipo);
    }

    public void eliminarOpcionAtaque(String ataque) {
        opcionesAtaque.remove(ataque);
    }

    public List<String> getOpcionesTipo() {
        return opcionesTipo;
    }

    public List<String> getOpcionesAtaque() {
        return opcionesAtaque;
    }

    public void setOpcionesTipo(List<String> opcionesTipo) {
        this.opcionesTipo = new ArrayList<>(opcionesTipo);
    }

    public void setOpcionesAtaque(List<String> opcionesAtaque) {
        this.opcionesAtaque = new ArrayList<>(opcionesAtaque);
    }

    public int mostrarMenu() {
        System.out.println("¿Qué desea hacer?");
        System.out.println("1) De qué tipo es el Pokémon");
        System.out.println("2) Qué ataques tiene");
        return scanner.nextInt();
    }

    public String adivinarTipo() {
        scanner.nextLine();
        System.out.println("¿Qué tipo cree que es el Pokémon?");
        String respuestaJugador = scanner.nextLine(); // Convertir a minúsculas
        return respuestaJugador;
    }

    public String adivinarAtaque() {
        scanner.nextLine();
        System.out.println("¿Qué ataque cree que tiene el Pokémon?");
        String respuestaJugador = scanner.nextLine(); // Respuesta del jugador
        return respuestaJugador;
    }

    public void cerrar() {
        scanner.close();
    }

    public String adivinarNombre() {
        System.out.println("¿Cuál pokemon de la lista crees que es el pokemon secreto?");
        return scanner.nextLine();
    }

    public void gestionarPerfiles() {
	    System.out.println("¡Bienvenido al juego Adivina Quién Pokémon!");
	    System.out.println("¿Qué deseas hacer?");
	    System.out.println("1) Crear un nuevo perfil");
	    System.out.println("2) Seleccionar un perfil existente");
	    int opcion = scanner.nextInt();

	    if (opcion == 1) {
	        System.out.print("Ingresa tu nombre de perfil (con extensión .txt): ");
	        String nombrePerfil = scanner.next(); // Agrega la extensión .txt
	        Perfil perfil = new Perfil(nombrePerfil);
	        perfil.cargarPerfil(); // Intenta cargar el perfil desde un archivo existente

	        if (perfil.getNombre() != null) {
	            System.out.println("Perfil cargado exitosamente.");
	        } else {
	            // Si el perfil no existía, se crea uno nuevo
	            perfil.guardarPerfil();
	            System.out.println("Perfil creado exitosamente.");
	        }
	    } else if (opcion == 2) {
	        System.out.print("Ingresa el nombre del perfil a cargar (con extensión .txt): ");
	        String nombrePerfil = scanner.next();
	        Perfil perfil = new Perfil(nombrePerfil);
	        perfil.cargarPerfil(); // No es necesario agregar la extensión .txt al cargar
	        System.out.println("Perfil cargado exitosamente.");
	    } else {
	        System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
	        gestionarPerfiles(); // Vuelve a mostrar el menú de perfiles
	    }
	}
	
}