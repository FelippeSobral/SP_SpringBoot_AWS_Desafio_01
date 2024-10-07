package Menu;

import Entidades.Livro;
import Services.LivroService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LivroMenu {

    private static Scanner sc = new Scanner(System.in);

    public static void cadastrarLivro() {
       LivroService livroService = new LivroService();

        System.out.println("Digite o ISBN do livro: ");
        int isbn = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o titulo do livro: ");
        String titulo = sc.nextLine();
        sc.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autor = sc.nextLine();
        sc.nextLine();

        System.out.println("Digite o genero do Livro: ");
        String genero = sc.nextLine();
        sc.nextLine();

        System.out.println("Digite a quantidade de livros: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite a data de publicação (yyyy-MM-dd): ");
        String data = sc.nextLine();
        LocalDate dataPublicacao = LocalDate.parse(data);


        Livro livro = new Livro(isbn,quantidade,dataPublicacao,genero,autor,titulo);


        try{
            livroService.cadastrarLivro(livro);
            System.out.println("Livro cadastrado com sucesso!");
        }catch (Exception e) {
            System.out.println("Erro ao cadastrar livro!" + e.getMessage());
        }
    }


    public static void listarLivros() {
        LivroService livroService = new LivroService();

        try {
            List<Livro> livros = livroService.buscarLivros();
            if (livros.isEmpty()) {
                System.out.println("Nenhum livro cadastrado.");
            } else {
                System.out.println("Livros cadastrados:");
                for (Livro livro : livros) {
                    System.out.println("ISBN: " + livro.getIsbn());
                    System.out.println("Título: " + livro.getTitulo());
                    System.out.println("Autor: " + livro.getAutor());
                    System.out.println("Gênero: " + livro.getGenero());
                    System.out.println("Data de Publicação: " + livro.getDataPublicacao());
                    System.out.println("Quantidade: " + livro.getQuantidade());
                    System.out.println("-----");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar livros: " + e.getMessage());
        }
    }
}











