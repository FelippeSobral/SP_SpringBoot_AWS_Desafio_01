package Entidades;


import java.time.LocalDate;
import java.util.Set;

public class Membro extends Pessoa {

    private int id;
    private LocalDate dataAssociacao;
    private Set<Emprestimo> emprestimos;


    public Membro(String nome, String endereco, String email, String telefone, int id, LocalDate dataAssociacao, Set<Emprestimo> emprestimos) {
        super(nome, endereco, email, telefone);
        this.id = id;
        this.dataAssociacao = dataAssociacao;
        this.emprestimos = emprestimos;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataAssociacao() {
        return dataAssociacao;
    }

    public void setDataAssociacao(LocalDate dataAssociacao) {
        this.dataAssociacao = dataAssociacao;
    }

    public Set<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(Set<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

}


