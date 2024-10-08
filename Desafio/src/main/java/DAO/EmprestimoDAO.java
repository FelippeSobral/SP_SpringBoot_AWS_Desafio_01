package DAO;

import Entidades.Emprestimo;
import Entidades.Livro;
import resource.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmprestimoDAO {


    public void insert(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO Emprestimos (livro_id, membro_id, data_emprestimo, data_devolucao, estado, multa) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.recuperarConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emprestimo.getLivro().getIsbn());
            stmt.setInt(2, emprestimo.getMembroId());
            stmt.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setDate(4, Date.valueOf(emprestimo.getDataDevolucaoPrevista()));
            stmt.setString(5, emprestimo.getEstado());
            stmt.setBigDecimal(6, emprestimo.getMulta());

            stmt.executeUpdate();
        }
    }


    public Emprestimo buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Emprestimos WHERE id = ?";

        try (Connection conn = ConnectionFactory.recuperarConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                LivroDAO livroDAO = new LivroDAO();
                Livro livro = livroDAO.buscarPorISBN(rs.getInt("livro_id"));
                return new Emprestimo(
                        rs.getInt("id"),
                        livro,
                        rs.getInt("membro_id"),
                        rs.getDate("data_emprestimo").toLocalDate(),
                        rs.getDate("data_devolucao").toLocalDate(),
                        rs.getDate("data_devolucao_real") != null ? rs.getDate("data_devolucao_real").toLocalDate() : null,
                        rs.getString("estado"),
                        rs.getBigDecimal("multa")
                );
            }
        }
        return null;
    }


    public void listarEmprestimos() throws SQLException {
        String sql = "SELECT * FROM Emprestimos";

        try (Connection conn = ConnectionFactory.recuperarConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                LivroDAO livroDAO = new LivroDAO();
                Livro livro = livroDAO.buscarPorISBN(rs.getInt("livro_id"));
                System.out.println(new Emprestimo(
                        rs.getInt("id"),
                        livro,
                        rs.getInt("membro_id"),
                        rs.getDate("data_emprestimo").toLocalDate(),
                        rs.getDate("data_devolucao").toLocalDate(),
                        rs.getDate("data_devolucao_real") != null ? rs.getDate("data_devolucao_real").toLocalDate() : null,
                        rs.getString("estado"),
                        rs.getBigDecimal("multa")
                ));
            }
        }
    }

    public void atualizarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String sql = "UPDATE Emprestimos SET livro_id = ?, membro_id = ?, data_emprestimo = ?, " +
                "data_devolucao = ?, data_devolucao_real = ?, estado = ?, multa = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.recuperarConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emprestimo.getLivro().getIsbn());
            stmt.setInt(2, emprestimo.getMembroId());
            stmt.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setDate(4, Date.valueOf(emprestimo.getDataDevolucaoPrevista()));


            if (emprestimo.getDataDevolucaoReal() != null) {
                stmt.setDate(5, Date.valueOf(emprestimo.getDataDevolucaoReal()));
            } else {
                stmt.setNull(5, Types.DATE);
            }

            stmt.setString(6, emprestimo.getEstado());
            stmt.setBigDecimal(7, emprestimo.getMulta());
            stmt.setInt(8, emprestimo.getId());

            stmt.executeUpdate();
        }
    }






    public void devolverLivro(int id) throws SQLException {
        String sql = "SELECT * FROM Emprestimos WHERE id = ?";

        try (Connection conn = ConnectionFactory.recuperarConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                LocalDate dataDevolucaoPrevista = rs.getDate("data_devolucao").toLocalDate();
                LocalDate dataDevolucaoReal = LocalDate.now();
                long diasAtraso = ChronoUnit.DAYS.between(dataDevolucaoPrevista, dataDevolucaoReal);
                BigDecimal multa = BigDecimal.ZERO;

                if (diasAtraso > 0) {
                    multa = BigDecimal.valueOf(diasAtraso * 0.50);
                }

                String updateSql = "UPDATE Emprestimos SET data_devolucao_real = ?, estado = ?, multa = ? WHERE id = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setDate(1, Date.valueOf(dataDevolucaoReal));
                    updateStmt.setString(2, diasAtraso > 0 ? "ATRASADO" : "CONCLUÍDO");
                    updateStmt.setBigDecimal(3, multa);
                    updateStmt.setInt(4, id);

                    updateStmt.executeUpdate();
                }
            }
        }
    }
}
