package Entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Membro membro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private EstadoEmprestimo estado;
    private BigDecimal multa;

    public Emprestimo(Livro livro, Membro membro, LocalDate dataDevolucao, LocalDate dataEmprestimo, BigDecimal multa, EstadoEmprestimo estado) {
        this.livro = livro;
        this.membro = membro;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
        this.multa = multa;
        this.estado = estado;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public EstadoEmprestimo getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmprestimo estado) {
        this.estado = estado;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }
}
