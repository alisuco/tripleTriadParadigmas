package models;

import java.util.Random;
import java.util.Scanner;

public final class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;

    private static String reset = "\u001b[0m";
    private static String white = "\u001b[37;1m";

    private Random random = new Random();
    private Scanner scann = new Scanner(System.in);

    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = new Tabuleiro();
    }

    private int sortearJogador() {
        System.out.println("Sorteando jogador que iniciará o jogo...");

        int numSorteado = random.nextInt(1,3);

        System.out.println("O jogador " + numSorteado + " foi sorteado");

        return numSorteado;
    }

    public void iniciarJogo() {
        int jogadorDaVez = this.sortearJogador();
        int index, i, j, quantPontosFeitos, controle;

        while (tabuleiro.getQuantCartasJogadas() < 9) {
            controle = 0;
            System.out.println();
            tabuleiro.mostrarTabuleiro();

            System.out.println();
            System.out.println("                      "+white+"----- Pontução -----"+reset);
            System.out.println("\t\t       Jogador 1: "+white+ jogador1.getPontos() + " pontos"+reset);
            System.out.println("\t\t       Jogador 2: "+white+ jogador2.getPontos() + " pontos\n\n"+reset);
            
            if (jogadorDaVez % 2 != 0) {
                while (controle == 0) { 
                       
                    System.out.println("----- Jogador 1 -----");

                    System.out.println("Suas cartas:");
                    jogador1.mostrarCartas();

                    System.out.print(
                        "\nEscolha a posição da carta que deseja jogar (de 1 a " + jogador1.getQuantCartas() + "): "
                    );
                    index = scann.nextInt();

                    System.out.print(
                        "\nEscolha a linha do tabuleiro que deseja jogar a carta (de 1 a 3): "
                    );
                    i = scann.nextInt();

                    System.out.print(
                    "\nEscolha a coluna do tabuleiro que deseja jogar a carta (de 1 a 3): "
                    );
                    j = scann.nextInt();

                    try {

                        tabuleiro.testeAddCarta(i-1, j-1);
                        quantPontosFeitos = tabuleiro.addCarta(i-1, j-1, jogador1.jogarCarta(index-1));
                        jogador1.setPontos(quantPontosFeitos);
                        jogador2.setPontos(quantPontosFeitos * (-1));
                        controle++;    

                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                        tabuleiro.mostrarTabuleiro();
                    }
                }
            }

            if (jogadorDaVez % 2 == 0) {
                while (controle == 0) { 
                                    
                    System.out.println("----- Jogador 2 -----");

                    System.out.println("Suas cartas:");
                    jogador2.mostrarCartas();

                    System.out.print(
                        "\nEscolha a posição da carta que deseja jogar (de 1 a " + jogador2.getQuantCartas() + "): "
                    );
                    index = scann.nextInt();

                    System.out.print(
                        "\nEscolha a linha do tabuleiro que deseja jogar a carta (de 1 a 3): "
                    );
                    i = scann.nextInt();

                    System.out.print(
                    "\nEscolha a coluna do tabuleiro que deseja jogar a carta (de 1 a 3): "
                    );
                    j = scann.nextInt();

                    try {

                        tabuleiro.testeAddCarta(i-1, j-1);
                        quantPontosFeitos = tabuleiro.addCarta(i-1, j-1, jogador2.jogarCarta(index-1));
                        jogador2.setPontos(quantPontosFeitos);
                        jogador1.setPontos(quantPontosFeitos * (-1));
                        controle++;

                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                        tabuleiro.mostrarTabuleiro();
                    }
                }
            }

            System.out.println();
            System.out.println("Pessione Enter para continuar...");
            scann.nextLine();
            scann.nextLine();

            jogadorDaVez++;
            System.out.println("\n\n\n\n");            
        }

        tabuleiro.mostrarTabuleiro();

        System.out.println("O jogo acabou");
        System.out.println();
        System.out.println("\"\\t\\t      "+white+"----- Pontução -----"+reset);
        System.out.println("\t\t       Jogador 1: "+white+ jogador1.getPontos() + " pontos"+reset);
        System.out.println("\t\t       Jogador 2: "+white+ jogador2.getPontos() + " pontos\n\n"+reset);
        System.out.println();
        System.out.println("Resultado final - " + this.getVencedor());
    }

    private String getVencedor() {
        if (jogador1.getPontos() > jogador2.getPontos()) {
            return "O jogador 1 venceu";
        } else if (jogador1.getPontos() < jogador2.getPontos()) {
            return "O jogador 2 venceu";
        } else {
            return "Empate";
        }
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }
    
}
