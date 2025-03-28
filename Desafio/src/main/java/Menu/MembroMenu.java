package Menu;

import Entidades.Membro;
import Serviços.MembroService;

import java.time.LocalDate;
import java.util.Scanner;

    public class MembroMenu {
        private static MembroService membroService;


        public MembroMenu(MembroService membroService) {
            this.membroService = membroService;
        }

        public static void cadastrarMembro() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Cadastro de Membros:");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Endereço: ");
            String endereco = sc.nextLine();
            System.out.print("Telefone: ");
            String telefone = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Data de Associação (AAAA-MM-DD): ");
            LocalDate dataAssociacao = LocalDate.parse(sc.nextLine());

            Membro membro = new Membro(nome, endereco, email, telefone, 0, dataAssociacao, null);

            membroService.cadastrarMembro(membro);


        }
    }