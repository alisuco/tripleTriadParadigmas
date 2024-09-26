import models.Jogador;
import models.Jogo;

public class Main {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Jogador1");
        Jogador jogador2 = new Jogador("Jogador2");
        System.out.println();


        Jogo jogo = new Jogo(jogador1, jogador2);

        jogo.iniciarJogo();
    }
}
