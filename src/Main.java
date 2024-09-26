import models.Jogador;
import models.Jogo;

public class Main {
    public static void main(String[] args) {
        final String nomeJogador1 = "Jogador1", nomeJogador2 = "Jogador2";

        Jogador jogador1 = new Jogador(nomeJogador1);
        Jogador jogador2 = new Jogador(nomeJogador2);
        Jogo jogo = new Jogo(jogador1, jogador2);

        System.out.println();

        jogo.iniciarJogo();
    }
}
