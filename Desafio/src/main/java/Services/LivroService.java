package Services;

import DAO.LivroDAO;
import Entidades.Livro;

import java.sql.SQLException;
import java.util.List;

public class LivroService {

    private LivroDAO livroDAO;

    public LivroService() {
        this.livroDAO = new LivroDAO();
    }

    public void cadastrarLivro(Livro livro) throws Exception {
        if (livroDAO.buscarPorISBN(livro.getIsbn()) != null) {
            throw new Exception("ISBN já cadastrado");
    }

        livroDAO.insert(livro);
}

    public List<Livro> buscarLivros() throws SQLException {
            return livroDAO.buscarTodos();
        }


    public List<Livro> ordendarPorTitulo() throws SQLException {
        List<Livro> livros = livroDAO.buscarTodos();
        livros.sort((l1,l2) -> l1.getTitulo().compareTo(l2.getTitulo()));
        return livros;
    }}



