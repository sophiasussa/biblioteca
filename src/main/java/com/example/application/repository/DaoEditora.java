package com.example.application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.application.model.Editora;

public class DaoEditora {
	public boolean inserir(Editora editora) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String insert = "INSERT INTO editora (id, nome_editora) values" +  "(?, ?)";
			PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
			preparedStatement1.setInt(1, editora.getId());
			preparedStatement1.setString(2, editora.getNome_editora());
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

    public boolean alterar(Editora editora) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String update = "UPDATE editora set nome_editora = ? where id = ?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(update);
			preparedStatement1.setString(1, editora.getNome_editora());
            preparedStatement1.setInt(2, editora.getId());
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

    public boolean excluir(Editora editora) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String delete = "DELETE from editora where id = ?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(delete);
			preparedStatement1.setInt(1, editora.getId());
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

    public List<Editora> pesquisar(int id) {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String consulta = "SELECT * from editora where id = ?";
			Editora editora = new Editora();
			List<Editora> listaEditoras = new ArrayList<Editora>();
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				editora.setId(resultSet.getInt("id"));
				editora.setNome_editora(resultSet.getString("data_editora"));
				listaEditoras.add(editora);
			}
			return listaEditoras;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Editora> pesquisarTodos() {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String consulta = "SELECT * from editora";
			List<Editora> lista = new ArrayList<Editora>();
			Editora editora;
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				editora = new Editora();
				editora.setId(resultSet.getInt("id"));
				editora.setNome_editora(resultSet.getString("nome_editora"));
				lista.add(editora);
			}
			return lista;
		}catch (Exception e) {
			return null;
		}
    }
}

