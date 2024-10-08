package Serviços;

import DAO.EmprestimoDAO;
import DAO.LivroDAO;
import Entidades.Emprestimo;
import Entidades.Livro;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmprestimoService {

    private EmprestimoDAO emprestimoDAO;
    private LivroDAO livroDAO;

    public EmprestimoService() {
        this.emprestimoDAO = new EmprestimoDAO();
        this.livroDAO = new LivroDAO();
    }


    public void emprestarLivro(Livro livro, int membroId) throws SQLException {
        if (livro.getQuantidade() <= 0) {
            System.out.println("Livro não disponível para empréstimo.");
            return;
        }

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucaoPrevista = dataEmprestimo.plusDays(7);


        Emprestimo emprestimo = new Emprestimo(
                0,
                livro,
                membroId,
                dataEmprestimo,
                dataDevolucaoPrevista,
                null,
                "ATIVO",
                BigDecimal.ZERO
        );


        emprestimoDAO.insert(emprestimo);


        livroDAO.atualizarQuantidade(livro.getIsbn(), livro.getQuantidade() - 1);

        System.out.println("Empréstimo realizado com sucesso! Livro: " + livro.getTitulo() + " | Data de devolução prevista: " + dataDevolucaoPrevista);
    }


    public void devolverLivro(int idEmprestimo) throws SQLException {
        Emprestimo emprestimo = emprestimoDAO.buscarPorId(idEmprestimo);

        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado.");
            return;
        }

        LocalDate dataDevolucaoPrevista = emprestimo.getDataDevolucaoPrevista();
        LocalDate dataDevolucaoReal = LocalDate.now();
        long diasAtraso = dataDevolucaoPrevista.isBefore(dataDevolucaoReal) ? java.time.temporal.ChronoUnit.DAYS.between(dataDevolucaoPrevista, dataDevolucaoReal) : 0;


        BigDecimal multa = diasAtraso > 0 ? BigDecimal.valueOf(diasAtraso * 0.50) : BigDecimal.ZERO;


        emprestimo.setDataDevolucaoReal(dataDevolucaoReal);
        emprestimo.setEstado(diasAtraso > 0 ? "ATRASADO" : "CONCLUÍDO");
        emprestimo.setMulta(multa);

        emprestimoDAO.devolverLivro(idEmprestimo);


        Livro livro = emprestimo.getLivro();
        livroDAO.atualizarQuantidade(livro.getIsbn(), livro.getQuantidade() + 1);

        System.out.println("Livro devolvido com sucesso! " + (diasAtraso > 0 ? "Multa: R$ " + multa : "Devolução no prazo."));
    }


    public void listarEmprestimos() throws SQLException {
        emprestimoDAO.listarEmprestimos();
    }
}
