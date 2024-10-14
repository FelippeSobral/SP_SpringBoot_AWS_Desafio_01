package Serviços;

import DAO.AutorDAO;
import Entidades.Autor;

public class AutorServiço {
    private AutorDAO autorDAO;

    public AutorServiço(AutorDAO autorDAO) {
        this.autorDAO = autorDAO;
    }

    public AutorServiço() {

    }

    public  void cadastrarAutor(Autor autor) {
        if (autorDAO.nomeExite(autor.getNome())) {
            System.out.println("Autor já existe.");
            return;
        }
        autorDAO.Salvamento(autor);
        System.out.println("Autor cadastrado com sucesso!");

    }}