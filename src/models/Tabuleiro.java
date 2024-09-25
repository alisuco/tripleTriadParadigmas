package models;

public final class Tabuleiro {
    private Carta[][] matriz;
    private int quantCartasJogadas;

    public Tabuleiro() {
        matriz = new Carta[3][3];
        quantCartasJogadas = 0;
    }

    public int addCarta(int i, int j, Carta carta) throws Exception {
        if (i > 2 || i < 0 || j > 2 || j < 0) {
            throw new Exception("Célula inválida");
        }

        if (matriz[i][j] != null) {
            throw new Exception("Célula já preenchida");
        }

        matriz[i][j] = carta;
        quantCartasJogadas++;

        int quantPontosFeitos = 0;

        quantPontosFeitos += this.checarEsquerda(i, j, carta);
        quantPontosFeitos += this.checarDireita(i, j, carta);
        quantPontosFeitos += this.checarCima(i, j, carta);
        quantPontosFeitos += this.checarBaixo(i, j, carta);

        return quantPontosFeitos;
    }

    private int checarEsquerda(int i, int j, Carta carta) {
        if (j == 0 || matriz[i][j-1] == null) {
            return 0;
        }

        if (matriz[i][j].getEsquerda() > matriz[i][j-1].getDireita()) {
            matriz[i][j-1].setDono(carta.getDono());

            return 1;
        }

        return 0;
    }

    private int checarDireita(int i, int j, Carta carta) {
        if (j == 2 || matriz[i][j+1] == null) {
            return 0;
        }

        if (matriz[i][j].getDireita() > matriz[i][j+1].getEsquerda()) {
            matriz[i][j+1].setDono(carta.getDono());

            return 1;
        }

        return 0;
    }

    private int checarCima(int i, int j, Carta carta) {
        if (i == 0 || matriz[i-1][j] == null) {
            return 0;
        }

        if (matriz[i][j].getCima() > matriz[i-1][j].getBaixo()) {
            matriz[i-1][j].setDono(carta.getDono());

            return 1;
        }

        return 0;
    }

    private int checarBaixo(int i, int j, Carta carta) {
        if (i == 2 || matriz[i+1][j] == null) {
            return 0;
        }

        if (matriz[i][j].getBaixo() > matriz[i+1][j].getCima()) {
            matriz[i+1][j].setDono(carta.getDono());

            return 1;
        }

        return 0;
    }

    public void mostrarTabuleiro() {
        System.out.println("Mostrando tabuleiro...");
    }

    public int getQuantCartasJogadas() {
        return quantCartasJogadas;
    }
}
