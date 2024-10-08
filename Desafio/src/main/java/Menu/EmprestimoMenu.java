package Menu;


import DAO.EmprestimoDAO;
import DAO.LivroDAO;
import Entidades.Emprestimo;
import Entidades.Livro;
import Services.EmprestimoService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class EmprestimoMenu {

    public static void emprestarLivro() throws SQLException {

        LivroDAO livroDAO = new LivroDAO();
        EmprestimoService emprestimoService = new EmprestimoService();
        Scanner sc = new Scanner(System.in);


        System.out.print("Digite o ISBN do livro: ");
        int isbn = sc.nextInt();
        sc.nextLine();

        Livro livro = livroDAO.buscarPorISBN(isbn);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }


        System.out.print("Digite o ID do membro: ");
        int membroId = sc.nextInt();
        sc.nextLine();


        if (livro.getQuantidade() <= 0) {
            System.out.println("Livro não disponível para empréstimo.");
            return;
        }


        emprestimoService.emprestarLivro(livro, membroId);

        System.out.println("Empréstimo realizado com sucesso!");
    }


    public static void devolverLivro() throws SQLException {
        LivroDAO livroDAO = new LivroDAO();
        Scanner sc = new Scanner(System.in);
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        EmprestimoService emprestimoService = new EmprestimoService();


        System.out.println("Digite o ID do emprestimo a ser devolvido");
        int idEmprestimo = sc.nextInt();
        sc.nextLine();

        try {
            Emprestimo emprestimo = emprestimoDAO.buscarPorId(idEmprestimo);
            if (emprestimo == null || emprestimo.getEstado().equals("CONCLUÍDO")) {
                System.out.println("Empréstimo não encontrado ou já concluído.");
                return;
            }

            LocalDate dataDevolucaoReal = LocalDate.now();
            emprestimo.setDataDevolucaoReal(dataDevolucaoReal);

            long diasAtraso = emprestimo.getDataDevolucaoPrevista().until(dataDevolucaoReal).getDays();

            if (diasAtraso > 0) {

                BigDecimal multa = BigDecimal.valueOf(diasAtraso).multiply(BigDecimal.valueOf(1.0));
                emprestimo.setMulta(multa);
                System.out.println("Multa gerada: R$ " + multa);
            } else {
                emprestimo.setMulta(BigDecimal.ZERO);
            }


            Livro livro = livroDAO.buscarPorISBN(emprestimo.getId());
            if (livro != null) {
                livroDAO.atualizarQuantidade(livro.getIsbn(), livro.getQuantidade() + 1);
            } else {

                System.out.println("Livro não encontrado para o ISBN informado.");
            }
                emprestimo.setEstado("CONCLUÍDO");
                emprestimoDAO.atualizarEmprestimo(emprestimo);

                System.out.println("Devolução realizada com sucesso. Empréstimo concluído.");
            } catch (SQLException e) {
                System.out.println("Erro ao processar a devolução: " + e.getMessage());
                e.printStackTrace();
            } finally {
                sc.close();
             }
            }


        public static void listarEmprestimos() {
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

            try {
                System.out.println("Lista de Empréstimos:");
                System.out.println("------------------------------");
                emprestimoDAO.listarEmprestimos();
                System.out.println("-------------------------------");
            } catch (SQLException e) {
                System.out.println("Erro ao listar os empréstimos: " + e.getMessage());
                e.printStackTrace();
            }
        }








            }







