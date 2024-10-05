package Entidades;

import java.time.LocalDate;

public class Livro {

    private String titulo;
    private String autor;
    private String genero;
    private LocalDate dataPublicacao;
    private int isbn;
    private int quantidade;


    public Livro(int isbn, int quantidade, int dataPublicacao, String genero, String autor, String titulo) {
        this.isbn = isbn;
        this.quantidade = quantidade;
        this.dataPublicacao = LocalDate.ofEpochDay(dataPublicacao);
        this.genero = genero;
        this.autor = autor;
        this.titulo = titulo;

    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public void setDataPublicacao(int dataPublicacao) {
        this.dataPublicacao = LocalDate.ofEpochDay(dataPublicacao);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
