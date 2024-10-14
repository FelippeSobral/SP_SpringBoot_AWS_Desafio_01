package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {



        public static Connection recuperarConexao() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/gerenciamento_de_biblioteca";
            String usuario = "root";
            String senha = "";


            return DriverManager.getConnection(url, usuario, senha);
        }
}


