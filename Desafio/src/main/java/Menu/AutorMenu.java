package Menu;

import Entidades.Autor;
import Serviços.AutorServiço;

import java.time.LocalDate;
import java.util.Scanner;






    public class AutorMenu {
        public static AutorServiço autorService;


        public AutorMenu(AutorServiço autorService) {
            this.autorService = autorService;
        }

        public static void cadastroDeAutor() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Cadastro de Autores:");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Data de Nascimento (AAAA-MM-DD): ");
            LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
            System.out.print("Nacionalidade: ");
            String nacionalidade = sc.nextLine();
            System.out.print("Biografia: ");
            String biografia = sc.nextLine();

            Autor autor = new Autor();
            autor.setNome(nome);
            autor.setDataNascimento(dataNascimento);
            autor.setNacionalidade(nacionalidade);
            autor.setBiografia(biografia);

            autorService.cadastrarAutor(autor);
        }
    }







