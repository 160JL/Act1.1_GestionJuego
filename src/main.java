import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        GestionDeVideojuegos base = new GestionDeVideojuegos();
        base.showJuegos();
    }
}
