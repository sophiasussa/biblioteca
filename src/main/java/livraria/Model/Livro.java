package livraria.Model;

public class Livro {
    private int id;
    private String nome_livro;
    private String descricao;
    private int ano_publicacao;
   
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome_livro() {
        return nome_livro;
    }
    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getAno_publicacao() {
        return ano_publicacao;
    }
    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

}
