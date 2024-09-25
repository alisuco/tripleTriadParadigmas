package models;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private List<Carta> cartas;
    private int pontos;

    public Jogador() {
        this.pontos = 5;
        this.cartas = new ArrayList<Carta>();
        Carta carta = null;

        for (int i = 0; i < 5; i++) {
            carta = Monte.pegarCarta();
            carta.setDono(this);

            cartas.add(carta);
        }
    }

    public void mostrarCartas() {
        char[] valoresFormatados = new char[20];
        int cont = 0;

        for (Carta carta : cartas) {
            int[] valores = {carta.getCima(), carta.getEsquerda(), carta.getDireita(), carta.getBaixo()};
            
            for (int i = 0; i < valores.length; i++) {
                if (valores[i] == 10) {
                    valoresFormatados[cont] = 'A';
                } else {
                    valoresFormatados[cont] = Integer.toString(valores[i]).charAt(0);
                }
                cont++;
            }
        }

        System.out.println("\n+-----+ +-----+ +-----+ +-----+ +-----+\n" +
                            "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |  " + valoresFormatados[8] + "  | |  " + valoresFormatados[12] + "  | |  " + valoresFormatados[16] + "  |\n" +
                            "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |"+ valoresFormatados[9] + "   " + valoresFormatados[10] + "| |"+ valoresFormatados[13] + "   " + valoresFormatados[14] + "| |"+ valoresFormatados[17] + "   " + valoresFormatados[18] + "|\n" +
                            "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |  " + valoresFormatados[11] + "  | |  " + valoresFormatados[15] + "  | |  " + valoresFormatados[19] + "  |\n" +
                            "+-----+ +-----+ +-----+ +-----+ +-----+\n");

    }

    public Carta jogarCarta(int index) throws Exception {
        if (index >= cartas.size() || index < 0) {
            throw new Exception("Indice inválido");
        }

        return cartas.remove(index);
    }

    public int getQuantCartas() {
        return cartas.size();
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos += pontos;
    }
}