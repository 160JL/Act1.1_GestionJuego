import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionDeVideojuegos {


    static ConexionDB conexionDB  = new ConexionDB();

    static Connection conexion = conexionDB.getConnection();;

    List<Videojuego> videojuegos = new ArrayList<Videojuego>();
    public void showJuegos() throws SQLException {
        System.out.println("Lista de juegos");
        ResultSet rs = conexion.prepareStatement("select * from videojuegos").executeQuery();
        while (rs.next()) {
            Videojuego juego = new Videojuego(rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(1));
            videojuegos.add(juego);
        }
        videojuegos.forEach(System.out::println);
    }
}
