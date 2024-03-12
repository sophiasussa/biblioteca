package livraria.model;

public class Edicao {
    private int id;
    private int ano;
    private String novo_conteudo;
    private Livro livro;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getNovo_conteudo() {
        return novo_conteudo;
    }
    public void setNovo_conteudo(String novo_conteudo) {
        this.novo_conteudo = novo_conteudo;
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
}
