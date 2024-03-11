package livraria.model;

import java.util.ArrayList;
import java.util.List;

import livraria.model.Livro;

public class Autor {
    private int id;
    private String nome_autor;
    private List<Livro> livros;

    public Autor(String nome_autor){
        this.nome_autor = nome_autor;
        this.livros = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome_autor() {
        return nome_autor;
    }
    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }
    
}
