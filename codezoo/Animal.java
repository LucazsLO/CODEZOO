package codezoo;

public class Animal {
    private String nome;
    private String simbolo;

    public Animal(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
