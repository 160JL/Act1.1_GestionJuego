import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
                GestionDeVideojuegos.addJuego(nombre,genero,plataforma,anno,val);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:

                break;
        }
    }

    void menu2() {
        System.out.println("""
                Escoja el método de busqueda:
                    1. Titulo
                    2. Plataforma
                    3. Género
                """);
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            default:

                break;
        }
    }
}
