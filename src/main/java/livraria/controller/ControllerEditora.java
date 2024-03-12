package livraria.controller;

import java.util.List;

import livraria.model.Editora;
import livraria.repository.DaoEditora;

public class ControllerEditora {
  	DaoEditora dao = new DaoEditora();
	public boolean inserir(Editora editora) {
		return dao.inserir(editora);
	}
	
	public boolean alterar(Editora editora) {
		return dao.alterar(editora);
	}
	
	public boolean excluir(Editora editora) {
		return dao.excluir(editora);
	}
	
	public List<Editora> pesquisar(int id) {
		return dao.pesquisar(id);
	}
	
	public List<Editora> pesquisarTodos() {
		return dao.pesquisarTodos();
	}  
}
