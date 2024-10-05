package Application;

import java.util.Scanner;

public class Biblioteca {

    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Buscar Livro por ISBN");
            System.out.println("3. Listar Livros");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                            // Capturar dados do livro e cadastrar
                    break;
                case 2:
                            // Buscar livro por ISBN
                    break;
                case 3:
                             // Listar livros
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    return;
            }
        }
    }

}
