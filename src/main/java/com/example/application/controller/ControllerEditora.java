package com.example.application.controller;

import java.util.List;

import com.example.application.model.Editora;
import com.example.application.repository.DaoEditora;

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
	
	public Editora pesquisar(int id) {
		return dao.pesquisar(id);
	}
	
	public List<Editora> pesquisarTodos() {
		return dao.pesquisarTodos();
	}  
}
