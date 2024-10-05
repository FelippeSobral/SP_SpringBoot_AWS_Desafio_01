package resource;

public class Create_Tables extends DbConnection {

    public static void createTables() {

        String criarTabelaAutor = "CREATE TABLE IF NOT EXISTS Autor ("
                + "id integer PRIMARY KEY AUTOINCREMENT, "
                + "nome varchar(255) NOT NULL, "
                + "dataNascimento DATE, "
                + "nacionalidade VARCHAR(255) NOT NULL, "







    }




}
