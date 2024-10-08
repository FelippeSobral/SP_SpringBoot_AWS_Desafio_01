package Application;

import Menu.EmprestimoMenu;
import Menu.LivroMenu;
import Services.LivroService;
import resource.Create_Tables;


import java.sql.SQLException;
import java.util.Scanner;

public class Biblioteca {

    public static  void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Create_Tables.createTables();
        LivroService livroService = new LivroService();

        while (true) {

            System.out.println("\n===== Sistema da Biblioteca =====");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Buscar Livro");
            System.out.println("3. Listar Livros");
            System.out.println("4. Emprestar Livro");
            System.out.println("5. Devolver Livro");
            System.out.println("6. Listar Empréstimos");
            System.out.println("7. Sair");
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
                    EmprestimoMenu.emprestarLivro();
                    break;
                case 5:
                    EmprestimoMenu.devolverLivro();
                    break;
                case 6:
                    EmprestimoMenu.listarEmprestimos();
                    break;
                case 7:
                    System.out.println("Saindo");
                    break;

                    default:
                        System.out.println("Opção Invalida");

            }

            System.out.println("---------------------------------");




        }






    }





}
