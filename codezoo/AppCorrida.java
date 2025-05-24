package codezoo;

import java.util.Random;
import java.util.Scanner;

public class AppCorrida {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("╔═══╗╔═══╗╔═══╗╔═══╗    ╔════╗╔═══╗╔═══╗\r\n"
           		+ "║╔═╗║║╔═╗║╚╗╔╗║║╔══╝    ╚══╗ ║║╔═╗║║╔═╗║\r\n"
           		+ "║║ ╚╝║║ ║║ ║║║║║╚══╗      ╔╝╔╝║║ ║║║║ ║║\r\n"
           		+ "║║ ╔╗║║ ║║ ║║║║║╔══╝     ╔╝╔╝ ║║ ║║║║ ║║\r\n"
           		+ "║╚═╝║║╚═╝║╔╝╚╝║║╚══╗    ╔╝ ╚═╗║╚═╝║║╚═╝║\r\n"
           		+ "╚═══╝╚═══╝╚═══╝╚═══╝    ╚════╝╚═══╝╚═══╝\r\n"
           		+ "                                        \r\n"
           		+ "                                        \r\n"
           		+ "");
        System.out.println("Jogador 1, escolha um animal:");
        System.out.println("1. 𓃰 Elefante");
        System.out.println("2. 𓃸 Macaco");
        System.out.println("3. 𓃯 Hipopótamo");
        int escolha1 = scanner.nextInt();
        Animal animal1 = escolherAnimal(escolha1);

        System.out.println("Jogador 2, escolha um animal:");
        System.out.println("1. 𓃰 Elefante");
        System.out.println("2. 𓃸 Macaco");
        System.out.println("3. 𓃯 Hipopótamo");
        int escolha2 = scanner.nextInt();
        Animal animal2 = escolherAnimal(escolha2);

        if (animal1 == null || animal2 == null) {
            System.out.println("Escolha inválida.");
            return;
        }

        System.out.print("Qual é a distância da corrida? ");
        int distanciaMaxima = scanner.nextInt();

        Competidor competidor1 = new Competidor(animal1);
        Competidor competidor2 = new Competidor(animal2);

        while (competidor1.getDistancia() < distanciaMaxima && competidor2.getDistancia() < distanciaMaxima) {
            int v1 = random.nextInt(3) + 1;
            int v2 = random.nextInt(3) + 1;

            competidor1.mover(v1);
            competidor2.mover(v2);

            mostrarCorrida(competidor1, competidor2, distanciaMaxima);
        }

        if (competidor1.getDistancia() >= distanciaMaxima && competidor2.getDistancia() >= distanciaMaxima) {
            if (competidor1.getDistancia() > competidor2.getDistancia()) {
                System.out.println(competidor1.getAnimal().getNome() + " venceu!");
            } else if (competidor2.getDistancia() > competidor1.getDistancia()) {
                System.out.println(competidor2.getAnimal().getNome() + " venceu!");
            } else {
                System.out.println("Foi um empate!");
            }
        } else if (competidor1.getDistancia() >= distanciaMaxima) {
            System.out.println(competidor1.getAnimal().getNome() + " venceu!");
        } else {
            System.out.println(competidor2.getAnimal().getNome() + " venceu!");
        }

        
    }

    private static Animal escolherAnimal(int escolha) {
        switch (escolha) {
            case 1:
                return new Animal("Elefante", "𓃰");
            case 2:
                return new Animal("Macaco", "𓃸");
            case 3:
                return new Animal("Hipopótamo", "𓃯");
            default:
                return null;
        }
    }

    private static void mostrarCorrida(Competidor c1, Competidor c2, int distanciaMaxima) {
        System.out.println("-".repeat(distanciaMaxima + 2));

        System.out.print(" ");
        for (int i = 0; i < c1.getDistancia(); i++) {
            System.out.print(" ");
        }
        System.out.println(c1.getAnimal().getSimbolo());

        System.out.print(" ");
        for (int i = 0; i < c2.getDistancia(); i++) {
            System.out.print(" ");
        }
        System.out.println(c2.getAnimal().getSimbolo());

        for (int i = 0; i < distanciaMaxima + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
