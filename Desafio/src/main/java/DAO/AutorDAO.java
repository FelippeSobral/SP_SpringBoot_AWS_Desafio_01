package DAO;

import Entidades.Autor;
import resource.ConnectionFactory;

import java.sql.*;


public class AutorDAO {
    private ConnectionFactory connectionFactory;
    public AutorDAO() {
        this.connectionFactory = new ConnectionFactory();
    }
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

    public boolean nomeExite(String nome) {
        String sql = "SELECT COUNT(*) FROM autores WHERE nome = ?";
        try (Connection connection = connectionFactory.recuperarConexao();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void Salvamento(Autor autor) {
        String sql = "INSERT INTO autores (nome, dataNascimento, nacionalidade, biografia) VALUES (?, ?, ?, ?)";
        try (Connection connection = connectionFactory.recuperarConexao();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(autor.getDataNascimento()));
            stmt.setString(3, autor.getNacionalidade());
            stmt.setString(4, autor.getBiografia());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

