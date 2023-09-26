package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public static Connection getConnexionSQLite() throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:F:/sqlite/cin_foncier.db");
        return connection;
    }
    public static Connection getConnexionPostgreS­ql() throws Exception{
        String url = "jdbc:postgresql://localhost/cin_sante";
        String user = "postgres";
        String password = "root";

        Class.forName("org.postgresql.Driver");
        
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
