package Entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Autor extends Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private String nacionalidade;
    private String biografia;


    public Autor(String nome, LocalDate dataNascimento, String nacionalidade, String biografia) {
        super();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.biografia = biografia;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}



