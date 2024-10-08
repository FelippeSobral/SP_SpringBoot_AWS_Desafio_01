package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {



        public static Connection recuperarConexao() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/gerenciamento_de_biblioteca";
            String usuario = "root1";
            String senha = "1234567";


            return DriverManager.getConnection(url, usuario, senha);
        }
}


