package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private final String driver = "com.mysql.jdbc.Driver";
    private final String host = "localhost:3306";
    private final String database = "docelandia";
    private final String usuario = "root";
    private final String senha = "";

    public Connection getConnection() throws Exception{
        try {
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/" + database, usuario, senha);
            return conexao;
        } catch (SQLException e) {

            throw new SQLException(e.getLocalizedMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
