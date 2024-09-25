package models;

public class Carta {
    private int cima;
    private int esquerda;
    private int baixo;
    private int direita;

    public Carta() {}

    public Carta(int cima, int esquerda, int baixo, int direita) {
        this.cima = cima;
        this.esquerda = esquerda;
        this.baixo = baixo;
        this.direita = direita;
    }

    @Override
    public String toString() {
        int[] valores = {cima, esquerda, direita, baixo};
        char[] valoresFormatados = new char[4];

        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == 10) {
                valoresFormatados[i] = 'A';
            } else {
                valoresFormatados[i] = Integer.toString(valores[i]).charAt(0);
            }
        }

        return "+-----+\n" +
               "|  " + valoresFormatados[0] + "  |\n" +
               "|" + valoresFormatados[1] + "   " + valoresFormatados[2] + "|\n" +
               "|  " + valoresFormatados[3] + "  |\n" +
               "+-----+";
    }

    public int getCima() {
        return cima;
    }

    public int getEsquerda() {
        return esquerda;
    }

    public int getBaixo() {
        return baixo;
    }

    public int getDireita() {
        return direita;
    }
    
}