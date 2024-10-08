package DAO;


import Entidades.Livro;
import resource.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {



    public void insert (Livro livro) throws Exception {
        String sql ="INSERT INTO livros (titulo, autor, data_publicacao, isbn, genero, quantidade) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.recuperarConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setDate(3, java.sql.Date.valueOf(livro.getDataPublicacao()));
            stmt.setInt(4, livro.getIsbn());
            stmt.setString(5, livro.getGenero());
            stmt.setInt(6, livro.getQuantidade());

            stmt.executeUpdate();
        }
    }



    public Livro buscarPorISBN(int isbn) throws SQLException {
        String sql ="SELECT * FROM livros WHERE isbn = ?";
        try (Connection conn = ConnectionFactory.recuperarConexao();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, isbn);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Livro(
                        rs.getInt("isbn"),
                        rs.getInt("quantidade"),
                        rs.getDate("data_publicacao").toLocalDate(),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getString("autor")
                        );
            }
            return null;
        }
    }

    public void atualizarQuantidade(int isbn, int novaQuantidade) throws SQLException {
        String sql = "UPDATE livros SET quantidade = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.recuperarConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, isbn);

            stmt.executeUpdate();
        }
    }








            public List<Livro> buscarTodos() throws SQLException {
                String sql = "SELECT * FROM livros";
                List<Livro> livros = new ArrayList<>();

                try (Connection conn = ConnectionFactory.recuperarConexao();
                     PreparedStatement stmt = conn.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery()) {


                    while (rs.next()) {
                        Livro livro = new Livro(
                                rs.getInt("isbn"),
                                rs.getInt("quantidade"),
                                rs.getDate("data_publicacao").toLocalDate(),
                                rs.getString("titulo"),
                                rs.getString("genero"),
                                rs.getString("autor")
                        );
                        livros.add(livro);
                    }
                }
                return livros;
            }
        }


