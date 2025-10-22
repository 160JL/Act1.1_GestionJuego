import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionDeVideojuegos {
    /**
     * @param parametro el parametro (titulo, genero, plataforma) del juego que se quiero buscar
     * @param opc la opcion a buscar (titulo, plataforma, genero)
     */
    private static List<Videojuego> videojuegos = new ArrayList<Videojuego>();

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
                        System.out.printf("*** %s ***\n- Genero: %s\n- Plataforma: %s\n- Año de Lanzamiento: %s\n- Valoración: %s\n\n",
                                rs.getString("titulo"), rs.getString("genero"), rs.getString("plataforma"),
                                rs.getString("anio"), rs.getString("valoracion"));
                    }
                    return;

                case 2:
                    statement = ConexionDB.getConnection().prepareStatement("select * from videojuegos where lower(plataforma) like ?");
                    statement.setString(1, parametro.toLowerCase()  + "%");

                    rs = statement.executeQuery();

                    while (rs.next()) {
                        System.out.printf("*** %s ***\n- Genero: %s\n- Plataforma: %s\n- Año de Lanzamiento: %s\n- Valoración: %s\n\n",
                                rs.getString("titulo"), rs.getString("genero"), rs.getString("plataforma"),
                                rs.getString("anio"), rs.getString("valoracion"));
                    }
                    return;

                case 3:
                    statement = ConexionDB.getConnection().prepareStatement("select * from videojuegos where lower(genero) like ?");
                    statement.setString(1, parametro.toLowerCase()  + "%");

                    rs = statement.executeQuery();

                    while (rs.next()) {
                        System.out.printf("*** %s ***\n- Genero: %s\n- Plataforma: %s\n- Año de Lanzamiento: %s\n- Valoración: %s\n\n",
                                rs.getString("titulo"), rs.getString("genero"), rs.getString("plataforma"),
                                rs.getString("anio"), rs.getString("valoracion"));
                    }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


    public static void showJuegos(){
        try {
            Connection conexion = ConexionDB.getConnection();
            System.out.println("Lista de juegos");
            ResultSet rs = conexion.prepareStatement("select * from videojuegos").executeQuery();
            while (rs.next()) {
                Videojuego juego = new Videojuego(rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(1));
                videojuegos.add(juego);
            }
            videojuegos.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mejorValorados(){
        try {
            Connection conexion = ConexionDB.getConnection();
            System.out.println("Lista de juegos");
            ResultSet rs = conexion.prepareStatement("select * from videojuegos where valoracion > 9").executeQuery();
            while (rs.next()) {
                Videojuego juego = new Videojuego(rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(1));
                videojuegos.add(juego);
            }
            videojuegos.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
