package com.example.application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.application.model.EmpreLivro;
import com.example.application.model.Emprestimo;
import com.example.application.model.Livro;

public class DaoEmpreLivro {
    public boolean inserir(EmpreLivro empreLivro) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String insert = "INSERT into empre_livro (id, id_emprestimo, id_livro) values (?, ?, ?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
            preparedStatement1.setInt(1, empreLivro.getId());
            preparedStatement1.setInt(2, empreLivro.getEmprestimo().getId());
            preparedStatement1.setInt(3, empreLivro.getLivro().getId());
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

    public boolean alterar(EmpreLivro empreLivro) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String update = "UPDATE empre_livro set id_emprestimo = ?, id_livro = ? where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(update);
            preparedStatement1.setInt(3, empreLivro.getId());
            preparedStatement1.setInt(1, empreLivro.getEmprestimo().getId());
            preparedStatement1.setInt(2, empreLivro.getLivro().getId());
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

    public boolean excluir(EmpreLivro empreLivro) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String delete = "Delete from empre_livro where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(delete);
            preparedStatement1.setInt(1, empreLivro.getId());
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

    public EmpreLivro pesquisar(int id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String consulta = "SELECT * from empre_livro where id = ?";
            EmpreLivro empreLivro = new EmpreLivro();
            PreparedStatement preparedStatement1 = connection.prepareStatement(consulta);
            preparedStatement1.setInt(1, id);
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                empreLivro.setId(resultSet.getInt("id"));
                Livro livro = new DaoLivro().pesquisar(resultSet.getInt("id_livro"));
                empreLivro.setLivro(livro);
                Emprestimo emprestimo = new DaoEmprestimo().pesquisar(resultSet.getInt("id_emprestimo"));
                empreLivro.setEmprestimo(emprestimo);
            }
            return empreLivro;
        } catch (Exception e) {
            return null;
        }
    }

    public List<EmpreLivro> pesquisarTodos() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String consulta = "SELECT * from empre_livro";
            List<EmpreLivro> lista = new ArrayList<EmpreLivro>();
            EmpreLivro empreLivro;
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                empreLivro = new EmpreLivro();
                empreLivro.setId(resultSet.getInt("id"));
                Livro livro = new DaoLivro().pesquisar(resultSet.getInt("id_livro"));
                empreLivro.setLivro(livro);
                Emprestimo emprestimo = new DaoEmprestimo().pesquisar(resultSet.getInt("id_emprestimo"));
                empreLivro.setEmprestimo(emprestimo);
                lista.add(empreLivro);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
   }

   public List<EmpreLivro> pesquisarPorIdEmprestimo(int idEmprestimo) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String consulta = "SELECT * FROM empre_livro WHERE id_emprestimo = ?";
            List<EmpreLivro> lista = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, idEmprestimo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EmpreLivro empreLivro = new EmpreLivro();
                empreLivro.setId(resultSet.getInt("id"));
                Livro livro = new DaoLivro().pesquisar(resultSet.getInt("id_livro"));
                empreLivro.setLivro(livro);
                Emprestimo emprestimo = new DaoEmprestimo().pesquisar(resultSet.getInt("id_emprestimo"));
                empreLivro.setEmprestimo(emprestimo);
                lista.add(empreLivro);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}