package models;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private List<Carta> cartas;

    public Jogador() {
        this.cartas = new ArrayList<Carta>();

        for (int i = 0; i < 5; i++) {
            cartas.add(Monte.pegarCarta());
        }
    }

    public void mostrarCartas() {
        String maoCartas = "";

        for (Carta carta : cartas) {
            maoCartas += carta.toString() + " ";
        }

        System.out.print(maoCartas);
    }
}