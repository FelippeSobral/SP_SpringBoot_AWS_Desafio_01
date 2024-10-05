package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

        public Connection recuperarConexão() {

             try {
                     return DriverManager
                             .getConnection("jdbc:mysql://localhost:3306/Gerenciamento_De_Biblioteca?user=root1&password=1234567");
             } catch (SQLException e) {
                     throw new RuntimeException(e);
             }


        }
}





