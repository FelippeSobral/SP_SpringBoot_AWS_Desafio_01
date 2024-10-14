package Aplicação;

import DAO.AutorDAO;
import DAO.MembroDAO;
import Menu.AutorMenu;
import Menu.EmprestimoMenu;
import Menu.LivroMenu;
import Menu.MembroMenu;
import Serviços.AutorServiço;
import Serviços.LivroService;
import Serviços.MembroService;
import resource.ConnectionFactory;
import resource.Create_Tables;


import java.sql.SQLException;
import java.util.Scanner;

import static Menu.AutorMenu.autorService;

public class Biblioteca {

    public static  void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Create_Tables.createTables();

        ConnectionFactory connectionFactory = new ConnectionFactory();

        AutorDAO autorDAO = new AutorDAO();
        AutorServiço autorServiço = new AutorServiço(autorDAO);
        MembroDAO membroDAO = new MembroDAO();
        MembroService membroService = new MembroService(membroDAO);
        LivroService livroService = new LivroService();

        AutorMenu autorMenu = new AutorMenu(autorServiço);
        MembroMenu membroMenu = new MembroMenu(membroService);
        LivroMenu libroMenu = new LivroMenu(livroService);



        while (true) {

            System.out.println("\n===== Sistema da Biblioteca =====");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Buscar Livro");
            System.out.println("3. Listar Livros");
            System.out.println("4. Cadastrp De Autor");
            System.out.println("5. Cadastro de Membro");
            System.out.println("6. emprestar Livro");
            System.out.println("7. devolver Livro");
            System.out.println("8. Listar Emprestimo");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao) {
                case 1:
                    LivroMenu.cadastrarLivro();
                    break;

                case 2:
                    LivroMenu.buscarLivroPorISBN();
                    break;
                case 3:
                    LivroMenu.listarLivros();
                    break;
                case 4:
                    AutorMenu.cadastroDeAutor();
                    break;
                case 5:
                    MembroMenu.cadastrarMembro();
                    break;
                case 6:
                    EmprestimoMenu.emprestarLivro();
                    break;
                case 7:
                    EmprestimoMenu.devolverLivro();
                    break;
                case 8:
                    EmprestimoMenu.listarEmprestimos();
                    break;
                case 9:
                    System.out.println("Saindo");
                    break;

                    default:
                        System.out.println("Opção Invalida");

            }

            System.out.println("---------------------------------");

        }

    }

}
