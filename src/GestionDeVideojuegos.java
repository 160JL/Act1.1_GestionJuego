import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionDeVideojuegos {
    private static List<Videojuego> videojuegos = new ArrayList<>();

    /**
     * @param parametro el parametro (titulo, genero, plataforma) del juego que se quiero buscar
     * @param opc       la opcion a buscar (titulo, plataforma, genero)
     */

    public static void buscarJuego(String parametro, int opc) {
        PreparedStatement statement;
        ResultSet rs;

        try {
            switch (opc) {
                case 1:
                    statement = ConexionDB.getConnection().prepareStatement("select * from videojuegos where lower(titulo) like ?");
                    statement.setString(1, parametro.toLowerCase() + "%");

                    rs = statement.executeQuery();

                    while (rs.next()) {
                        Videojuego videojuego = new Videojuego(rs.getString("titulo"), rs.getString("genero"), rs.getString("plataforma"),
                                rs.getInt("anio"), rs.getInt("valoracion"), rs.getInt("id"));

                        videojuegos.add(videojuego);
                    }

                    videojuegos.forEach(System.out::println);
                    return;

                case 2:
                    statement = ConexionDB.getConnection().prepareStatement("select * from videojuegos where lower(plataforma) like ?");
                    statement.setString(1, parametro.toLowerCase() + "%");

                    rs = statement.executeQuery();

                    while (rs.next()) {
                        Videojuego videojuego = new Videojuego(rs.getString("titulo"), rs.getString("genero"), rs.getString("plataforma"),
                                rs.getInt("anio"), rs.getInt("valoracion"), rs.getInt("id"));

                        videojuegos.add(videojuego);
                    }

                    videojuegos.forEach(System.out::println);
                    return;

                case 3:
                    statement = ConexionDB.getConnection().prepareStatement("select * from videojuegos where lower(genero) like ?");
                    statement.setString(1, parametro.toLowerCase() + "%");

                    rs = statement.executeQuery();

                    while (rs.next()) {
                        Videojuego videojuego = new Videojuego(rs.getString("titulo"), rs.getString("genero"), rs.getString("plataforma"),
                                rs.getInt("anio"), rs.getInt("valoracion"), rs.getInt("id"));

                        videojuegos.add(videojuego);
                    }

                    videojuegos.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


    public static void showJuegos() {
        try {
            Connection conexion = ConexionDB.getConnection();
            System.out.println("Lista de juegos");
            ResultSet rs = conexion.prepareStatement("select * from videojuegos").executeQuery();
            while (rs.next()) {
                Videojuego juego = new Videojuego(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(1));
                videojuegos.add(juego);
            }
            videojuegos.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mejorValorados() {
        try {
            Connection conexion = ConexionDB.getConnection();
            System.out.println("Lista de juegos");
            ResultSet rs = conexion.prepareStatement("select * from videojuegos where valoracion > 9").executeQuery();
            while (rs.next()) {
                Videojuego juego = new Videojuego(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(1));
                videojuegos.add(juego);
            }
            videojuegos.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void delJuego(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce la ID del juego a eliminar: ");
            int id = Integer.parseInt(sc.nextLine());

            Connection conexion = ConexionDB.getConnection();
            PreparedStatement statement = conexion.prepareStatement("delete from videojuegos where id = ?");
            statement.setInt(1, id);

            int filas = statement.executeUpdate();

            if (filas > 0) {
                System.out.println("Juego eliminado correctamente");
            } else {
                System.out.println("No existe ningún juego con esa ID");
            }

            statement.close();
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
