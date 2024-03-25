package com.example.application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.application.model.Autor;

public class DaoAutor {
    public boolean inserir(Autor autor) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String insert = "INSERT INTO autor (id, nome_autor) values" + "(?, ?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
            preparedStatement1.setInt(1, autor.getId());
            preparedStatement1.setString(2, autor.getNome_autor());
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

    public boolean alterar(Autor autor) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String update = "UPDATE autor set nome_autor = ? where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(update);
            preparedStatement1.setInt(2, autor.getId());
            preparedStatement1.setString(1, autor.getNome_autor());
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

    public boolean excluir(Autor autor) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String delete = "DELETE from autor where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(delete);
            preparedStatement1.setInt(1, autor.getId());
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

    public List<Autor> pesquisar(int id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String consulta = "SELECT * from autor where id = ?";
            Autor autor = new Autor();
            List<Autor> listaAutores = new ArrayList<Autor>();
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                autor.setId(resultSet.getInt("id"));
                autor.setNome_autor(resultSet.getString("nome_autor"));
                listaAutores.add(autor);
            }
            return listaAutores;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Autor> pesquisarTodos() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String consulta = "SELECT * from autor";
            List<Autor> lista = new ArrayList<Autor>();
            Autor autor;
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                autor = new Autor();
                autor.setId(resultSet.getInt("id"));
                autor.setNome_autor(resultSet.getString("nome_autor"));
                lista.add(autor);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
