package Entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livro;
    private int membroId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private String estado;
    private BigDecimal multa;

    public Emprestimo(int id, Livro livro, int membroId, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista, LocalDate dataDevolucaoReal, String estado, BigDecimal multa) {
        this.id = id;
        this.livro = livro;
        this.membroId = membroId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.estado = estado;
        this.multa = multa;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getMembroId() {
        return membroId;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public String getEstado() {
        return estado;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", livro=" + livro +
                ", membroId=" + membroId +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucaoPrevista=" + dataDevolucaoPrevista +
                ", dataDevolucaoReal=" + dataDevolucaoReal +
                ", estado='" + estado + '\'' +
                ", multa=" + multa +
                '}';
    }
}
