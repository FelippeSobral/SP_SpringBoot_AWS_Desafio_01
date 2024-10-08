package DAO;

import Entidades.Membro;
import resource.ConnectionFactory;

import java.sql.*;

public class MembroDAO {

    public void inserirMembro(Membro membro) {
        String sql = "INSERT INTO membros (nome,endereco,telefone,email,data_associacao) VALUES (?,?,?,?,?)";
        try(Connection conn = ConnectionFactory.recuperarConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, membro.getNome());
            stmt.setString(2, membro.getEndereco());
            stmt.setString(3, membro.getTelefone());
            stmt.setString(4, membro.getEmail());
            stmt.setDate(5, Date.valueOf(membro.getDataAssociacao()));
            stmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Erro ao inserir membro: " + e.getMessage());
        }
    }

    public boolean EmailExistente(String email) {
        String sql = "SELECT COUNT(*) FROM membros WHERE email = ?";
        try (Connection connection = ConnectionFactory.recuperarConexao();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}
