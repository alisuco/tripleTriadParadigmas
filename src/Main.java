import models.Jogador;
import models.Jogo;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();

        Jogo jogo = new Jogo(jogador1, jogador2);

        jogo.iniciarJogo();
    }
}