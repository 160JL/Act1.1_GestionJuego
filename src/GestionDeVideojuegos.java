import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionDeVideojuegos extends Videojuego {
    /**
     * @param parametro el parametro (titulo, genero, plataforma) del juego que se quiero buscar
     * @param opc la opcion a buscar (titulo, plataforma, genero)
     */
    public void buscarJuego(String parametro, int opc) {
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
}
