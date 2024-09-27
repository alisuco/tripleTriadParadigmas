package models;

// "\n+-----+ +-----+ +-----+ +-----+ +-----+\n" +
// "|     | |     | |     | |     | |     |\n" +
// "|     | |     | |     | |     | |     |\n" +
// "|     | |     | |     | |     | |     |\n" +
// "+-----+ +-----+ +-----+ +-----+ +-----+\n";

public final class Tabuleiro {
    private Carta[][] matriz;
    private int quantCartasJogadas;

    private static String red = "\u001b[31m";
    private static String blue = "\u001b[34m";
    private static String reset = "\u001b[0m";
    private static String white = "\u001b[37;1m";

    public Tabuleiro() {
        matriz = new Carta[3][3];
        quantCartasJogadas = 0;
    }

    public void testeAddCarta(int i, int j) throws Exception {
        if (i > 2 || i < 0 || j > 2 || j < 0) {
            throw new Exception("Célula inválida");
        }

        if (matriz[i][j] != null) {
            throw new Exception("Célula já preenchida");
        }
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

        quantPontosFeitos += this.checarPlus(i, j, carta);

        quantPontosFeitos += this.checarEsquerda(i, j, carta);
        quantPontosFeitos += this.checarDireita(i, j, carta);
        quantPontosFeitos += this.checarCima(i, j, carta);
        quantPontosFeitos += this.checarBaixo(i, j, carta);


        return quantPontosFeitos;
    }

    private int checarEsquerda(int i, int j, Carta carta) {
        if (
            j == 0 ||
            matriz[i][j-1] == null ||
            matriz[i][j-1].getDono().equals(carta.getDono())
        ) {
            return 0;
        }

        if (matriz[i][j].getEsquerda() > matriz[i][j-1].getDireita()) {
            matriz[i][j-1].setDono(carta.getDono());

            return 1;
        }

        return 0;
    }

    private int checarDireita(int i, int j, Carta carta) {
        if (
            j == 2 ||
            matriz[i][j+1] == null ||
            matriz[i][j+1].getDono().equals(carta.getDono())
        ) {
            return 0;
        }

        if (matriz[i][j].getDireita() > matriz[i][j+1].getEsquerda()) {
            matriz[i][j+1].setDono(carta.getDono());

            return 1;
        }

        return 0;
    }

    private int checarCima(int i, int j, Carta carta) {
        if (
            i == 0 ||
            matriz[i-1][j] == null ||
            matriz[i-1][j].getDono().equals(carta.getDono())
        ) {
            return 0;
        }

        if (matriz[i][j].getCima() > matriz[i-1][j].getBaixo()) {
            matriz[i-1][j].setDono(carta.getDono());

            return 1;
        }

        return 0;
    }

    private int checarBaixo(int i, int j, Carta carta) {
        if (
            i == 2 ||
            matriz[i+1][j] == null ||
            matriz[i+1][j].getDono().equals(carta.getDono())
        ) {
            return 0;
        }

        if (matriz[i][j].getBaixo() > matriz[i+1][j].getCima()) {
            matriz[i+1][j].setDono(carta.getDono());

            return 1;
        }

        return 0;
    }

    private int checarPlus(int i, int j, Carta carta) {
        int valorCima, valorBaixo, valorDireita, valorEsquerda, quantPontosFeitos = 0;

        valorCima = this.somaCima(i, j, carta);
        valorEsquerda = this.somaEsquerda(i, j, carta);
        valorBaixo = this.somaBaixo(i, j, carta);
        valorDireita = this.somaDireita(i, j, carta);

        int[] somasDeTodosLados = {valorCima, valorEsquerda, valorBaixo, valorDireita};

        for (int k = 0; k < somasDeTodosLados.length - 1; k++) {
            for (int w = k + 1; w < somasDeTodosLados.length; w++) {
                if (
                    somasDeTodosLados[k] + somasDeTodosLados[w] >= 0 &&
                    somasDeTodosLados[k] == somasDeTodosLados[w]
                ) {
                    System.out.println("PLUS!!!");

                    switch (k) {
                        case 0:
                            matriz[i-1][j].setDono(carta.getDono());
                            quantPontosFeitos++;

                            break;
                    
                        case 1:
                            matriz[i][j-1].setDono(carta.getDono());
                            quantPontosFeitos++;

                            break;

                        case 2:
                            matriz[i+1][j].setDono(carta.getDono());
                            quantPontosFeitos++;

                            break;
                    }

                    switch (w) {
                        case 1:
                            matriz[i][j-1].setDono(carta.getDono());
                            quantPontosFeitos++;

                            break;

                        case 2:
                            matriz[i+1][j].setDono(carta.getDono());
                            quantPontosFeitos++;

                            break;

                        case 3:
                            matriz[i][j+1].setDono(carta.getDono());
                            quantPontosFeitos++;

                            break;
                    }
                }
            }
        }
    
        return quantPontosFeitos;
    }

    private int somaCima(int i, int j, Carta carta) {
        if (i == 0 || matriz[i-1][j] == null) {
            return -1;
        }

        return matriz[i][j].getCima() + matriz[i-1][j].getBaixo();
    }
    
    private int somaBaixo(int i, int j, Carta carta) {
        if (i == 2 || matriz[i+1][j] == null) {
            return -1;
        }

        return matriz[i][j].getBaixo() + matriz[i+1][j].getCima();
    }

    private int somaEsquerda(int i, int j, Carta carta) {
        if (j == 0 || matriz[i][j-1] == null) {
            return -1;
        }

        return matriz[i][j].getEsquerda() + matriz[i][j-1].getDireita();
    }

    private int somaDireita(int i, int j, Carta carta) {
        if (j == 2 || matriz[i][j+1] == null) {
            return -1;
        }

        return matriz[i][j].getDireita() + matriz[i][j+1].getEsquerda();
    }

    private String numCima(int i, int j) {
        if (matriz[i][j] == null) {
            return "     ";
        }
        return this.matriz[i][j].getCima() == 10 ? "  A  " : "  " + Integer.toString(matriz[i][j].getCima())+ "  ";
    }

    private String numMeio(int i, int j) {
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

    private String numBaixo(int i, int j) {
        if (matriz[i][j] == null) {
            return "     ";
        }
        return this.matriz[i][j].getBaixo() == 10 ? "  A  " : "  " + Integer.toString(matriz[i][j].getBaixo())+ "  ";
    }

    private String cor(int i, int j) {
        if (matriz[i][j] == null) {
            return reset;
        } else {
            if (matriz[i][j].getDono().getNome().equals("Jogador1") ) {
                return blue;
            } else {
                return red;
            }
        }
    }

    public void mostrarTabuleiro() {
        System.out.println( white + "  _____     _     ___   _   _   _      ___   ___   ___    ___  \r\n" + //
                        " |_   _|   /_\\   | _ ) | | | | | |    | __| |_ _| | _ \\  / _ \\ \r\n" + //
                        "   | |    / _ \\  | _ \\ | |_| | | |__  | _|   | |  |   / | (_) |\r\n" + //
                        "   |_|   /_/ \\_\\ |___/  \\___/  |____| |___| |___| |_|_\\  \\___/ ");

        System.out.println("\n"+cor(0, 0)+"                    +-----+ "+cor(0, 1)+" +-----+ "+cor(0, 2)+" +-----+\n" +

                            "                    "+cor(0, 0)+"|"+numCima(0,0)+"| "+cor(0, 1)+" |"+numCima(0,1)+"| "+cor(0, 2)+" |"+numCima(0,2)+"|\n" +

                            "                    "+cor(0, 0)+"|"+numMeio(0, 0)+"| "+cor(0, 1)+" |"+numMeio(0, 1)+"| "+cor(0, 2)+" |"+numMeio(0, 2)+"|\n" +

                            "                    "+cor(0, 0)+"|"+numBaixo(0, 0)+"| "+cor(0, 1)+" |"+numBaixo(0, 1)+"| "+cor(0, 2)+" |"+numBaixo(0, 2)+"|\n" +

                            "                    "+cor(0, 0)+"+-----+ "+cor(0, 1)+" +-----+ "+cor(0, 2)+" +-----+\n" +

                            "                    "+cor(1, 0)+"+-----+ "+cor(1, 1)+" +-----+ "+cor(1, 2)+" +-----+\n" +

                            "                    "+cor(1, 0)+"|"+numCima(1,0)+"| "+cor(1, 1)+" |"+numCima(1,1)+"| "+cor(1, 2)+" |"+numCima(1,2)+"|\n" +

                            "                    "+cor(1, 0)+"|"+numMeio(1, 0)+"| "+cor(1, 1)+" |"+numMeio(1, 1)+"| "+cor(1, 2)+" |"+numMeio(1, 2)+"|\n" +

                            "                    "+cor(1, 0)+"|"+numBaixo(1, 0)+"| "+cor(1, 1)+" |"+numBaixo(1, 1)+"| "+cor(1, 2)+" |"+numBaixo(1, 2)+"|\n" +

                            "                    "+cor(1, 0)+"+-----+ "+cor(1, 1)+" +-----+ "+cor(1, 2)+" +-----+\n" +

                            "                    "+cor(2, 0)+"+-----+ "+cor(2, 1)+" +-----+ "+cor(2, 2)+" +-----+\n" +

                            "                    "+cor(2, 0)+"|"+numCima(2,0)+"| "+cor(2, 1)+" |"+numCima(2,1)+"| "+cor(2, 2)+" |"+numCima(2,2)+"|\n" +

                            "                    "+cor(2, 0)+"|"+numMeio(2, 0)+"| "+cor(2, 1)+" |"+numMeio(2, 1)+"| "+cor(2, 2)+" |"+numMeio(2, 2)+"|\n" +

                            "                    "+cor(2, 0)+"|"+numBaixo(2, 0)+"| "+cor(2, 1)+" |"+numBaixo(2, 1)+"| "+cor(2, 2)+" |"+numBaixo(2, 2)+"|\n" +

                            "                    "+cor(2, 0)+"+-----+ "+cor(2, 1)+" +-----+ "+cor(2, 2)+" +-----+\n" + reset);
    }

    public int getQuantCartasJogadas() {
        return quantCartasJogadas;
    }
}
