package livraria.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import livraria.model.Empre_livro;

public class DaoEmpre_livro {
    public boolean inserir(Empre_livro empre_livro){
        try{
            Connection connection = DBConnection.getInstance().getConnection();
            String insert = "INSERT into empre_livro (id, emprestimo, livro) = ?, ?, ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
            preparedStatement1.setInt(1, empre_livro.getId());
            preparedStatement1.setInt(2, empre_livro.getEmprestimo().getId(););
            preparedStatement1.setInt(3, empre_livro.getLivro().getId());
            


        }


    }
}
