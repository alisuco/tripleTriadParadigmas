package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Carta;

public final class CartaAux {
    public List<Carta> gerarCartas() {
        List<Carta> cartas = new ArrayList<Carta>();

        String caminho = "src/cards.csv";
        
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(caminho))) {
            String conteudo;
            int cima, esquerda, baixo, direita;

            bufferReader.readLine();

            while ((conteudo = bufferReader.readLine()) != null) {
                String[] valores = conteudo.split(",");

                if (valores.length == 4) {
                    for (int i = 0; i < valores.length; i++) {
                        
                    }
                    cima = Integer.parseInt(valores[0].replaceAll("[^0-9]", ""));
                    esquerda = Integer.parseInt(valores[1].replaceAll("[^0-9]", ""));
                    baixo = Integer.parseInt(valores[2].replaceAll("[^0-9]", ""));
                    direita = Integer.parseInt(valores[3].replaceAll("[^0-9]", ""));

                    cartas.add(new Carta(cima, esquerda, baixo, direita));
                }
            }

            return cartas;
        } catch (IOException e) {
            System.err.println("Aconteceu um erro ao ler o arquivo cards.csv");
            System.err.println("Erro: " + e.getMessage());
            System.exit(-1);

            return null;
        }
    }
}
