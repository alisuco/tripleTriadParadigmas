import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Cartas> cartas = new ArrayList<>();

        String caminho = "src/cards.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String conteudo;

            br.readLine();

            while ((conteudo = br.readLine()) != null) {

                String[] valores = conteudo.split(",");

                if(valores.length==4) {
                    Integer cima = Integer.parseInt(valores[0].replaceAll("[^0-9]", ""));
                    Integer esquerda = Integer.parseInt(valores[1].replaceAll("[^0-9]", ""));
                    Integer baixo = Integer.parseInt(valores[2].replaceAll("[^0-9]", ""));
                    Integer direita = Integer.parseInt(valores[3].replaceAll("[^0-9]", ""));
                    cartas.add(new Cartas(cima, esquerda, baixo, direita));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (Cartas x: cartas) {
            System.out.println(x);
        }

    }
}