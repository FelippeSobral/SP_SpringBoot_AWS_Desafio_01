package Application;

import Menu.LivroMenu;
import Services.LivroService;
import resource.Create_Tables;


import java.util.Scanner;

public class Biblioteca {

    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Create_Tables.createTables();
        LivroService livroService = new LivroService();

        while (true) {

            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Buscar Livro por ISBN");
            System.out.println("3. Listar Livros");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    LivroMenu.cadastrarLivro();
                    break;
                case 2:
                            // Buscar livro
                    break;
                case 3:
                     LivroMenu.listarLivros();
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    return;
            }
        }
    }





}
