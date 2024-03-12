package livraria.controller;

import java.util.List;

import livraria.model.Livro;
import livraria.repository.DaoLivro;

public class ControllerLivro {
	DaoLivro dao = new DaoLivro();
	public boolean inserir(Livro livro) {
		return dao.inserir(livro);
	}
	
	public boolean alterar(Livro livro) {
		return dao.alterar(livro);
	}
	
	public boolean excluir(Livro livro) {
		return dao.excluir(livro);
	}
	
	public List<Livro> pesquisar(int id) {
		return dao.pesquisar(id);
	}
	
	public List<Livro> pesquisarTodos() {
		return dao.pesquisarTodos();
	}
}
