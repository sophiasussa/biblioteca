package livraria.model;

import java.util.ArrayList;
import java.util.List;

import livraria.model.Livro;

public class Editora {
    private int id;
    private String nome_editora;
    private List<Livro> livros;

    public Editora(String nome_editora){
        this.nome_editora = nome_editora;
        this.livros = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome_editora() {
        return nome_editora;
    }
    public void setNome_editora(String nome_editora) {
        this.nome_editora = nome_editora;
    }
    
}
