package app.modelo;


public class Jogo {

    private String nome;
    private Integer id;

    public Jogo(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
    }
    public Jogo() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
