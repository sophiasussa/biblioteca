package livraria.controller;

import java.util.List;

import livraria.model.Emprestimo;
import livraria.repository.DaoEmprestimo;

public class ControllerEmprestimo {
	DaoEmprestimo dao = new DaoEmprestimo();
	public boolean inserir(Emprestimo emprestimo) {
		return dao.inserir(emprestimo);
	}
	
	public boolean alterar(Emprestimo emprestimo) {
		return dao.alterar(emprestimo);
	}
	
	public boolean excluir(Emprestimo emprestimo) {
		return dao.excluir(emprestimo);
	}
	
	public List<Emprestimo> pesquisar(int id) {
		return dao.pesquisar(id);
	}
	
	public List<Emprestimo> pesquisarTodos() {
		return dao.pesquisarTodos();
	}
}
