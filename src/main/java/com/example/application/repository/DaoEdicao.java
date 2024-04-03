package com.example.application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.application.model.Autor;
import com.example.application.model.Edicao;
import com.example.application.model.Editora;
import com.example.application.model.Livro;

public class DaoEdicao {
	public boolean inserir(Edicao edicao) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String insert = "INSERT INTO edicao (id, ano, novo_conteudo, id_livro) values" + "(?, ?, ?, ?)";
			PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
			preparedStatement1.setInt(1, edicao.getId());
			preparedStatement1.setInt(2, edicao.getAno());
			preparedStatement1.setString(3, edicao.getNovo_conteudo());
			preparedStatement1.setInt(4, edicao.getLivro().getId());
			int resultado = preparedStatement1.executeUpdate();
			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean alterar(Edicao edicao) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String update = "UPDATE edicao set ano = ?, novo_conteudo = ?, id_livro = ? where id = ?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(update);
			preparedStatement1.setInt(1, edicao.getAno());
			preparedStatement1.setString(2, edicao.getNovo_conteudo());
			preparedStatement1.setInt(3, edicao.getLivro().getId());
			preparedStatement1.setInt(4, edicao.getId());
			int resultado = preparedStatement1.executeUpdate();
			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public boolean excluir(Edicao edicao) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String delete = "DELETE from edicao where id = ?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(delete);
			preparedStatement1.setInt(1, edicao.getId());
			int resultado = preparedStatement1.executeUpdate();
			if (resultado > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public Edicao pesquisar(int id) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String consulta = "SELECT * from edicao where id = ?";
			Edicao edicao = new Edicao();
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, edicao.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				edicao.setId(resultSet.getInt("id"));
				edicao.setAno(resultSet.getInt("ano"));
				edicao.setNovo_conteudo(resultSet.getString("novo_conteudo"));
				edicao.getLivro().setId(resultSet.getInt("id"));
				Livro livro = new DaoLivro().pesquisar(resultSet.getInt("id_livro"));
				edicao.setLivro(livro);
				edicao.setLivro(livro);
			}
			return edicao;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Edicao> pesquisarTodos() {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String consulta = "SELECT * from edicao";
			List<Edicao> lista = new ArrayList<Edicao>();
			Edicao edicao;
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				edicao = new Edicao();
				edicao.setId(resultSet.getInt("id"));
				edicao.setAno(resultSet.getInt("ano"));
				edicao.setNovo_conteudo(resultSet.getString("novo_conteudo"));
				Livro livro = new DaoLivro().pesquisar(resultSet.getInt("id_livro"));
				edicao.setLivro(livro);
				lista.add(edicao);
			}
			return lista;
		} catch (Exception e) {
			return null;
		}
	}
}
