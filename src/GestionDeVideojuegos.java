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
    static List<Videojuego> videojuegos = new ArrayList<>();

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
                    statement.setString(1, parametro.toLowerCase()  + "%");

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
                    statement.setString(1, parametro.toLowerCase()  + "%");

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
}
