package livraria.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import livraria.model.EmpreLivro;

public class DaoEmpreLivro {
    public boolean inserir(EmpreLivro empre_livro){
        try{
            Connection connection = DBConnection.getInstance().getConnection();
            String insert = "INSERT into empre_livro (id, emprestimo, livro) values (?, ?, ?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
            preparedStatement1.setInt(1, empre_livro.getId());
            preparedStatement1.setInt(2, empre_livro.getEmprestimo().getId());
            preparedStatement1.setInt(3, empre_livro.getLivro().getId());
            int resultado = preparedStatement1.executeUpdate();
            if(resultado > 0){
                return true;
            }else{
                return false;
            }
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
        
    }
    public boolean alterar(EmpreLivro empre_livro){
        try{
            Connection connection = DBConnection.getInstance().getConnection();
            String update = "UPDATE empre_livro set emprestimo = ?, livro = ? where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(update);
            preparedStatement1.setInt(3, empre_livro.getId());
            preparedStatement1.setInt(1, empre_livro.getEmprestimo().getId());
            preparedStatement1.setInt(2, empre_livro.getLivro().getId());
            int resultado = preparedStatement1.executeUpdate();
            if(resultado > 0){
                return true;
            }else{
                return false;
            }
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
    }
    public boolean excluir(EmpreLivro empre_livro){
        try{
            Connection connection = DBConnection.getInstance().getConnection();
            String delete = "Delete from empre_livro where id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(delete);
            preparedStatement1.setInt(1, empre_livro.getId());
            int resultado = preparedStatement1.executeUpdate();
            if(resultado > 0){
                return true;
            }else{
                return false;
            }
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
    }

    public List<EmpreLivro> pesquisar(int id){
        try{
            Connection connection = DBConnection.getInstance().getConnection();
            String consulta = "SELECT * from empre_livro where id = ?";
            EmpreLivro empre_livro = new EmpreLivro();
            List<EmpreLivro> lista = new ArrayList<EmpreLivro>();
            PreparedStatement preparedStatement1 = connection.prepareStatement(consulta);
            preparedStatement1.setInt(1, empre_livro.getId());
            ResultSet resultSet = preparedStatement1.executeQuery();
            while(resultSet.next()) {
                empre_livro.setId(resultSet.getInt("id"));
          //      empre_livro.setData_empre_livro(resultSet.getInt("data_emprestimo"));
                lista.add(empre_livro);
            }
            return lista;
        }catch (Exception e) {
            return null;
        }
    }

    public List<EmpreLivro> pesquisarTodos() {
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			String consulta = "SELECT * from empre_livro";
			List<EmpreLivro> lista = new ArrayList<EmpreLivro>();
			EmpreLivro empre_livro;
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				empre_livro = new EmpreLivro();
				empre_livro.setId(resultSet.getInt("id"));
			//	empre_livro.setData_empre_livro(resultSet.getInt("data_empre_livro"));
				lista.add(empre_livro);
			}
			return lista;
		}catch (Exception e) {
			return null;
		}
    }
}