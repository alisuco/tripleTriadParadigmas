package models;

// "\n+-----+ +-----+ +-----+ +-----+ +-----+\n" +
// "|     | |     | |     | |     | |     |\n" +
// "|     | |     | |     | |     | |     |\n" +
// "|     | |     | |     | |     | |     |\n" +
// "+-----+ +-----+ +-----+ +-----+ +-----+\n";

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

    public String numCima(int i, int j) {
        if (matriz[i][j] == null) {
            return "     ";
        }
        return this.matriz[i][j].getCima() == 10 ? "  A  " : "  " + Integer.toString(matriz[i][j].getCima())+ "  ";
    }

    public String numMeio(int i, int j) {
        String auxEsq = "";
        String auxDir = "";

        if (matriz[i][j] == null) {
            return "     ";
        }
        if (matriz[i][j].getEsquerda() == 10) {
            auxEsq = "A";
        }else{
            auxEsq = Integer.toString(matriz[i][j].getEsquerda());
        }
        if (matriz[i][j].getDireita() == 10) {
            auxDir = "A";
        }else{
            auxDir = Integer.toString(matriz[i][j].getDireita());
        }
        
        return auxEsq + "   " + auxDir;
    }

    public String numBaixo(int i, int j) {
        if (matriz[i][j] == null) {
            return "     ";
        }
        return this.matriz[i][j].getBaixo() == 10 ? "  A  " : "  " + Integer.toString(matriz[i][j].getBaixo())+ "  ";
    }

    public void mostrarTabuleiro() {
        System.out.println("\n\n----- TABULEIRO -----");

        System.out.println("\n+-----+  +-----+  +-----+\n" +
                            "|"+numCima(0,0)+"|  |"+numCima(0,1)+"|  |"+numCima(0,2)+"|\n" +
                            "|"+numMeio(0, 0)+"|  |"+numMeio(0, 1)+"|  |"+numMeio(0, 2)+"|\n" +
                            "|"+numBaixo(0, 0)+"|  |"+numBaixo(0, 1)+"|  |"+numBaixo(0, 2)+"|\n" +
                            "+-----+  +-----+  +-----+\n" +
                            "+-----+  +-----+  +-----+\n" +
                            "|"+numCima(1,0)+"|  |"+numCima(1,1)+"|  |"+numCima(1,2)+"|\n" +
                            "|"+numMeio(1, 0)+"|  |"+numMeio(1, 1)+"|  |"+numMeio(1, 2)+"|\n" +
                            "|"+numBaixo(1, 0)+"|  |"+numBaixo(1, 1)+"|  |"+numBaixo(1, 2)+"|\n" +
                            "+-----+  +-----+  +-----+\n" +
                            "+-----+  +-----+  +-----+\n" +
                            "|"+numCima(2,0)+"|  |"+numCima(2,1)+"|  |"+numCima(2,2)+"|\n" +
                            "|"+numMeio(2, 0)+"|  |"+numMeio(2, 1)+"|  |"+numMeio(2, 2)+"|\n" +
                            "|"+numBaixo(2, 0)+"|  |"+numBaixo(2, 1)+"|  |"+numBaixo(2, 2)+"|\n" +
                            "+-----+  +-----+  +-----+\n");
    }

    public int getQuantCartasJogadas() {
        return quantCartasJogadas;
    }
}
