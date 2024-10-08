package Serviços;

import DAO.AutorDAO;
import Entidades.Autor;

public class AutorServiço {
    private AutorDAO autorDAO;

    public AutorServiço(AutorDAO autorDAO) {
        this.autorDAO = autorDAO;
    }

    public  boolean cadastrarAutor(Autor autor) {
        if (autorDAO.nomeExite(autor.getNome())) {
            System.out.println("Autor já existe.");
            return false;
        }
        autorDAO.Salvamento(autor);
        System.out.println("Autor cadastrado com sucesso!");
        return true;


    }}