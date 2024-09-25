package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.CartaAux;

public final class Monte {
    private static List<Carta> cartas = new ArrayList<Carta>(
        new CartaAux().gerarCartas()
    );

    public static Carta pegarCarta() {
        int indice = new Random().nextInt(cartas.size());

        return cartas.remove(indice);
    } 
}
