package Entidades;

import java.time.LocalDate;
import java.util.Date;

public class Livro {

    private String titulo;
    private String autor;
    private String genero;
    private LocalDate dataPublicacao;
    private int isbn;
    private int quantidade;


    public Livro(int isbn, int quantidade, LocalDate dataPublicacao, String genero, String autor, String titulo) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
        this.quantidade = quantidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}



