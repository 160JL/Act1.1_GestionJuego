import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        menu();
    }

    private static void menu() {
        System.out.println("""
                Escoja opción:
                    1. Añadir un nuevo juego: Título, Género, Plataforma, Año y Valoración (1-10)
                    2. Eliminar un juego por su ID
                    3. Buscar juegos
                    4. Mostrar todos los juegos de la colección
                    5. Mostrar los juegos mejor valorados
                """);

        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                System.out.println("Introduce: Título");
                String nombre = sc.nextLine();
                System.out.println("Introduce: Género");
                String genero = sc.nextLine();
                System.out.println("Introduce: Plataforma");
                String plataforma = sc.nextLine();
                System.out.println("Introduce: Año");
                int anno = Integer.parseInt(sc.nextLine());
                System.out.println("Introduce: Valoración");
                int val = Integer.parseInt(sc.nextLine());
                //GestionDeVideojuegos.addJuego(nombre, genero, plataforma, anno, val);
                break;
            case 2:
                //GestionDeVideojuegos.showJuegos();
                System.out.println("Introduce la ID del juego a eliminar:");
                int id = Integer.parseInt(sc.nextLine());
                //GestionDeVideojuegos.delJuego(id);
                break;
            case 3:
                menu2();
                break;
            case 4:
                //GestionDeVideojuegos.showJuegos();
                break;
            case 5:
                //GestionDeVideojuegos.mejorValorados();
                break;
            default:
                System.out.println("Por favor, selecciona una opción válida");
                menu();
                break;
        }
    }

    private static void menu2() {
        System.out.println("""
                Escoja el método de busqueda:
                    1. Titulo
                    2. Plataforma
                    3. Género
                4. Volver al menu anterior
                """);
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                System.out.println("Introduce: Titulo");
                String titulo = sc.nextLine();
                GestionDeVideojuegos.buscarJuego(titulo,1);
                break;
            case 2:
                System.out.println("Introduce: Plataforma");
                String plataforma = sc.nextLine();
                GestionDeVideojuegos.buscarJuego(plataforma,2);
                break;
            case 3:
                System.out.println("Introduce: Género");
                String genero = sc.nextLine();
                GestionDeVideojuegos.buscarJuego(genero,3);
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Por favor, selecciona una opción válida");
                menu2();
                break;
        }
    }
}
