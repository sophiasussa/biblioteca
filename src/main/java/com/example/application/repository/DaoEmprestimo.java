package com.example.application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.application.model.Emprestimo;

public class DaoEmprestimo {
	public boolean inserir(Emprestimo emprestimo) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String insert = "INSERT INTO emprestimo (id, data_emprestimo) values" +  "(?, ?)";
			PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
			preparedStatement1.setInt(1, emprestimo.getId());
			preparedStatement1.setInt(2, emprestimo.getData_emprestimo());
			int resultado = preparedStatement1.executeUpdate();
			if(resultado>0) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

    public boolean alterar(Emprestimo emprestimo) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String update = "UPDATE emprestimo set data_emprestimo = ? where id = ?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(update);
			preparedStatement1.setInt(2, emprestimo.getId());
			preparedStatement1.setInt(1, emprestimo.getData_emprestimo());
			int resultado = preparedStatement1.executeUpdate();
			if(resultado>0) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			return false;
		}
	}

    public boolean excluir(Emprestimo emprestimo) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String delete = "DELETE from emprestimo where id = ?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(delete);
			preparedStatement1.setInt(1, emprestimo.getId());
			int resultado = preparedStatement1.executeUpdate();
			if(resultado>0) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			return false;
		}
	}

    public Emprestimo pesquisar(int id) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String consulta = "SELECT * from emprestimo where id = ?";
			Emprestimo emprestimo = new Emprestimo();
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				emprestimo.setId(resultSet.getInt("id"));
				emprestimo.setData_emprestimo(resultSet.getInt("data_emprestimo"));
			}
			return emprestimo;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Emprestimo> pesquisarTodos() {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String consulta = "SELECT * from emprestimo";
			List<Emprestimo> lista = new ArrayList<Emprestimo>();
			Emprestimo emprestimo;
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				emprestimo = new Emprestimo();
				emprestimo.setId(resultSet.getInt("id"));
				emprestimo.setData_emprestimo(resultSet.getInt("data_emprestimo"));
				lista.add(emprestimo);
			}
			return lista;
		}catch (Exception e) {
			return null;
		}
    }
}
