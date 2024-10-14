package resource;

import java.sql.Connection;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class Create_Tables extends ConnectionFactory {

    public static void createTables() {

        try (Connection conn = recuperarConexao(); Statement stmt = conn.createStatement()) {


            String criarTabelaAutor = "CREATE TABLE IF NOT EXISTS Autores ("
                    + "id integer PRIMARY KEY AUTO_INCREMENT, "
                    + "nome varchar(100) NOT NULL, "
                    + "dataNascimento DATE, "
                    + "nacionalidade VARCHAR(255) NOT NULL, "
                    + "biografia VARCHAR(255) NOT NULL"
                    + ")";
            stmt.execute(criarTabelaAutor);


            String criarTabelaLivro = "CREATE TABLE IF NOT EXISTS Livros ("
                    + "id integer PRIMARY KEY AUTO_INCREMENT, "
                    + "titulo VARCHAR(15) NOT NULL, "
                    + "autor VARCHAR(20), "
                    + "isbn VARCHAR(20), "
                    + "editora VARCHAR(20), "
                    + "ano_publicacao DATE, "
                    + "FOREIGN KEY (autor) REFERENCES Autor(id)"
                    + ")";
            stmt.execute(criarTabelaLivro);


            String criarTabelaMembro = "CREATE TABLE IF NOT EXISTS Membros ("
                    + "id integer PRIMARY KEY AUTO_INCREMENT, "
                    + "nome VARCHAR(100) NOT NULL, "
                    + "endereco VARCHAR(255), "
                    + "telefone VARCHAR(20), "
                    + "email VARCHAR(100), "
                    + "data_associacao DATE "
                    + ")";
            stmt.execute(criarTabelaMembro);


            String criarTabelaEmprestimo = "CREATE TABLE IF NOT EXISTS Emprestimos ("
                    + "id integer PRIMARY KEY AUTO_INCREMENT, "
                    + "livro_id INT, "
                    + "membro_id INT, "
                    + "data_emprestimo DATE NOT NULL, "
                    + "data_devolucao DATE, "
                    + "estado VARCHAR(20), "
                    + "multa DECIMAL(10, 2), "
                    + "FOREIGN KEY (livro_id) REFERENCES Livros(id), "
                    + "FOREIGN KEY (membro_id) REFERENCES Membros(id)"
                    + ")";
            stmt.execute(criarTabelaEmprestimo);

            System.out.println("Tabelas criadas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


