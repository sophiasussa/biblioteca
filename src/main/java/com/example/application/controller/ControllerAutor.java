package livraria.controller;

import java.util.List;

import livraria.model.Autor;
import livraria.repository.DaoAutor;

public class ControllerAutor {
  	DaoAutor dao = new DaoAutor();
	public boolean inserir(Autor autor) {
		return dao.inserir(autor);
	}
	
	public boolean alterar(Autor autor) {
		return dao.alterar(autor);
	}
	
	public boolean excluir(Autor autor) {
		return dao.excluir(autor);
	}
	
	public List<Autor> pesquisar(int id) {
		return dao.pesquisar(id);
	}
	
	public List<Autor> pesquisarTodos() {
		return dao.pesquisarTodos();
	}  
}
