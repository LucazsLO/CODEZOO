package codezoo;

public class Competidor {
    private int distancia;
    private Animal animal;

    public Competidor(Animal animal) {
        this.animal = animal;
        this.distancia = 0;
    }

    public int getDistancia() {
        return distancia;
    }

    public void mover(int velocidade) {
        this.distancia += velocidade;
    }

    public Animal getAnimal() {
        return animal;
    }
}
