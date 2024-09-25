package models;

public class Carta {
    private int cima;
    private int esquerda;
    private int baixo;
    private int direita;
    private Jogador dono;

    public Carta(int cima, int esquerda, int baixo, int direita, Jogador dono) {
        this.cima = cima;
        this.esquerda = esquerda;
        this.baixo = baixo;
        this.direita = direita;
        this.dono = dono;
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

    public void setDono(Jogador dono) {
        this.dono = dono;
    }
    
    public Jogador getDono() {
        return dono;
    }
}