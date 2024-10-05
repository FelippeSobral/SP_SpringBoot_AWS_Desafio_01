package Entidades;


import java.time.LocalDate;
import java.util.Set;

public class Membro extends Pessoa {

    private Long id;
    private LocalDate dataAssociacao;
    private Set<Emprestimo> emprestimos;

    public Membro(String joãoSilva, String s, String email, String number, int i, int i1) {

    }

}


