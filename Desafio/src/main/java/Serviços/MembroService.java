package Serviços;

import DAO.MembroDAO;
import Entidades.Membro;

public class MembroService {
    private MembroDAO membroDAO;

    public MembroService(MembroDAO membroDAO) {
        this.membroDAO = membroDAO;
    }

    public void cadastrarMembro(Membro membro) {

        if (membroDAO.EmailExistente(membro.getEmail())) {
            System.out.println("Email já existe.");
            return;
        }
        membroDAO.inserirMembro(membro);
        System.out.println("Membro cadastrado com sucesso!");


    }
}