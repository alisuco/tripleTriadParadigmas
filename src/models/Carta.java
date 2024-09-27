package models;

public class Carta {
    private int cima;
    private int esquerda;
    private int baixo;
    private int direita;
    private int indice;
    private Jogador dono;

    public Carta(int cima, int esquerda, int baixo, int direita, Jogador dono, int indice) {
        this.cima = cima;
        this.esquerda = esquerda;
        this.baixo = baixo;
        this.direita = direita;
        this.dono = dono;
        this.indice = indice;
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

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}