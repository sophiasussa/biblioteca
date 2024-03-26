package com.example.application.controller;

import java.util.List;

import com.example.application.model.EmpreLivro;
import com.example.application.repository.DaoEmpreLivro;

public class ControllerEmpreLivro {
	DaoEmpreLivro dao = new DaoEmpreLivro();
	public boolean inserir(EmpreLivro empreLivro) {
		return dao.inserir(empreLivro);
	}
	
	public boolean alterar(EmpreLivro empreLivro) {
		return dao.alterar(empreLivro);
	}
	
	public boolean excluir(EmpreLivro empreLivro) {
		return dao.excluir(empreLivro);
	}
	
	public List<EmpreLivro> pesquisar(int id) {
		return dao.pesquisar(id);
	}
	
	public List<EmpreLivro> pesquisarTodos() {
		return dao.pesquisarTodos();
	}


}
