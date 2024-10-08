package DAO;

import Entidades.Autor;
import resource.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutorDAO {

    public void inserirAutor(Autor autor) throws SQLException {
        String sql = "INSERT INTO autores (nome,data_nascimento,nacionalidade,biografia) VALUES (?,?,?,?)";
        try (Connection conn = ConnectionFactory.recuperarConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setDate(2, Date.valueOf(autor.getDataNascimento()));
            stmt.setString(3, autor.getNacionalidade());
            stmt.setString(4, autor.getBiografia());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir autor: " + e.getMessage());
        }
    }



}
