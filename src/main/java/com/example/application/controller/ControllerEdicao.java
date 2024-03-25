package com.example.application.controller;

import java.util.List;

import com.example.application.model.Edicao;
import com.example.application.repository.DaoEdicao;

public class ControllerEdicao {
  	DaoEdicao dao = new DaoEdicao();
	public boolean inserir(Edicao edicao) {
		return dao.inserir(edicao);
	}
	
	public boolean alterar(Edicao edicao) {
		return dao.alterar(edicao);
	}
	
	public boolean excluir(Edicao edicao) {
		return dao.excluir(edicao);
	}
	
	public List<Edicao> pesquisar(int id) {
		return dao.pesquisar(id);
	}
	
	public List<Edicao> pesquisarTodos() {
		return dao.pesquisarTodos();
	}  
}
