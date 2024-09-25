package models;

import java.util.ArrayList;
import java.util.List;

// "\n+-----+ +-----+ +-----+ +-----+ +-----+\n" +
// "|     | |     | |     | |     | |     |\n" +
// "|     | |     | |     | |     | |     |\n" +
// "|     | |     | |     | |     | |     |\n" +
// "+-----+ +-----+ +-----+ +-----+ +-----+\n";

public class Jogador {
    private List<Carta> cartas;

    public Jogador() {
        this.cartas = new ArrayList<Carta>();

        for (int i = 0; i < 5; i++) {
            cartas.add(Monte.pegarCarta());
        }
    }

    public void mostrarCartas() {
        
        char[] vf = new char[20];
        int cont = 0, tam = cartas.size();
        for (Carta c : cartas) {
            int[] valores = {c.getCima(), c.getEsquerda(), c.getDireita(), c.getBaixo()};
            for (int i = 0; i < valores.length; i++) {
                if (valores[i] == 10) {
                    vf[cont] = 'A';
                } else {
                    vf[cont] = Integer.toString(valores[i]).charAt(0);
                }
                cont++;
            }
        }

        System.out.println("\n+-----+ +-----+ +-----+ +-----+ +-----+\n" +
                            "|  " + vf[0] + "  | |  " + vf[4] + "  | |  " + vf[8] + "  | |  " + vf[12] + "  | |  " + vf[16] + "  |\n" +
                            "|"+ vf[1] + "   " + vf[2] + "| |"+ vf[5] + "   " + vf[6] + "| |"+ vf[9] + "   " + vf[10] + "| |"+ vf[13] + "   " + vf[14] + "| |"+ vf[17] + "   " + vf[18] + "|\n" +
                            "|  " + vf[3] + "  | |  " + vf[7] + "  | |  " + vf[11] + "  | |  " + vf[15] + "  | |  " + vf[19] + "  |\n" +
                            "+-----+ +-----+ +-----+ +-----+ +-----+\n");

    }
}