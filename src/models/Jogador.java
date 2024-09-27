package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogador {
    private final static String red = "\u001b[31m";
    private final static String blue = "\u001b[34m";
    private final static String reset = "\u001b[0m";
    private List<Carta> cartas;
    private String nome;
    private int pontos;
    private int mapCartaJogada;
    Scanner scann = new Scanner(System.in);

    public Jogador(String nome) {
        this.nome = nome;
        this.pontos = 5;
        this.cartas = new ArrayList<Carta>();
        Carta carta = null;

        for (int i = 0; i < 5; i++) {
            carta = Monte.pegarCarta();
            carta.setDono(this);
            carta.setIndice(i+1);
            cartas.add(carta);
        }
    }
    private String cor() {
        if (this.nome == null) {
            return reset;
        } else {
            if (this.nome.equals("Jogador1") ) {
                return blue;
            } else {
                return red;
            }
        }
    }

    public int getCartaJogada(Carta cartaRemovida) {
        if ( cartaRemovida.getIndice() == 5 || cartaRemovida.getIndice() == 4) {
            return 1;
        }
        return 0;
    }

    public void mostrarCartas() {
        int[] valores = new int[4];
        char[] valoresFormatados = new char[20];
        String controle = "";
        int cont = 0, tam = cartas.size();
        for (Carta c : cartas) {
            valores[0] = c.getCima();
            valores[1] = c.getEsquerda();
            valores[2] = c.getDireita();
            valores[3] = c.getBaixo();

            for (int i = 0; i < valores.length; i++) {
                if (valores[i] == 10) {
                    valoresFormatados[cont] = 'A';
                } else {
                    valoresFormatados[cont] = Integer.toString(valores[i]).charAt(0);
                }
                cont++;
            }
        }
//#region CARTAS ASCII
        switch (tam) {
            case 5:
                
                System.out.println("\n"+cor()+"+-----+ +-----+ +-----+ +-----+ +-----+\n" +
                "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |  " + valoresFormatados[8] + "  | |><><>| |<><><|\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |"+ valoresFormatados[9] + "   " + valoresFormatados[10] + "| |<><><| |><><>|\n" +
                "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |  " + valoresFormatados[11] + "  | |><><>| |<><><|\n" +
                "+-----+ +-----+ +-----+ +-----+ +-----+"+reset+"\n");
                
                System.out.println("\nPressione" +red+ " ENTER " +reset+ "para mostrar suas cartas.");
                controle = scann.nextLine();

                System.out.println("\n"+cor()+"+-----+ +-----+ +-----+ +-----+ +-----+\n" +
                "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |  " + valoresFormatados[8] + "  | |  " + valoresFormatados[12] + "  | |  " + valoresFormatados[16] + "  |\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |"+ valoresFormatados[9] + "   " + valoresFormatados[10] + "| |"+ valoresFormatados[13] + "   " + valoresFormatados[14] + "| |"+ valoresFormatados[17] + "   " + valoresFormatados[18] + "|\n" +
                "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |  " + valoresFormatados[11] + "  | |  " + valoresFormatados[15] + "  | |  " + valoresFormatados[19] + "  |\n" +
                "+-----+ +-----+ +-----+ +-----+ +-----+"+reset+"\n");
                
                break;
        
            case 4:
            
                if (this.mapCartaJogada == 1) {
                    System.out.println("\n"+cor()+"+-----+ +-----+ +-----+ +-----+\n" +
                    "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |  " + valoresFormatados[8] + "  | |><><>|\n" +
                    "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |"+ valoresFormatados[9] + "   " + valoresFormatados[10] + "| |<><><|\n" +
                    "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |  " + valoresFormatados[11] + "  | |><><>|\n" +
                    "+-----+ +-----+ +-----+ +-----+"+reset+"\n");                    
                }
                
                if (this.mapCartaJogada == 0) {
                    System.out.println("\n"+cor()+"+-----+ +-----+ +-----+ +-----+\n" +
                    "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |><><>| |><><>|\n" +
                    "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |><><>| |<><><|\n" +
                    "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |><><>| |><><>|\n" +
                    "+-----+ +-----+ +-----+ +-----+"+reset+"\n");                  
                }                    
                
                System.out.println("\nPressione" +red+ " ENTER " +reset+ "para mostrar suas cartas.");
                controle = scann.nextLine();

                System.out.println("\n"+cor()+"+-----+ +-----+ +-----+ +-----+\n" +
                "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |  " + valoresFormatados[8] + "  | |  " + valoresFormatados[12] + "  |\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |"+ valoresFormatados[9] + "   " + valoresFormatados[10] + "| |"+ valoresFormatados[13] + "   " + valoresFormatados[14] + "|\n" +
                "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |  " + valoresFormatados[11] + "  | |  " + valoresFormatados[15] + "  |\n" +
                "+-----+ +-----+ +-----+ +-----+"+reset+"\n");    
                break;
        
            case 3:
                if (this.mapCartaJogada < 2) { 

                    if (this.mapCartaJogada == 1) {
                        System.out.println("\n"+cor()+"+-----+ +-----+ +-----+\n" +
                        "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |><><>|\n" +
                        "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |><><>|\n" +
                        "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |><><>|\n" +
                        "+-----+ +-----+ +-----+"+reset+"\n");
                    }    

                    if (this.mapCartaJogada == 0) {
                        System.out.println("\n"+cor()+"+-----+ +-----+ +-----+\n" +
                        "|  " + valoresFormatados[0] + "  | |><><>| |><><>|\n" +
                        "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |><><>| |<><><|\n" +
                        "|  " + valoresFormatados[3] + "  | |><><>| |><><>|\n" +
                        "+-----+ +-----+ +-----+"+reset+"\n");
                    }

                    System.out.println("\nPressione" +red+ " ENTER " +reset+ "para mostrar suas cartas.");
                    controle = scann.nextLine();
                }
                
                System.out.println("\n"+cor()+"+-----+ +-----+ +-----+\n" +
                "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |  " + valoresFormatados[8] + "  |\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |"+ valoresFormatados[9] + "   " + valoresFormatados[10] + "|\n" +
                "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |  " + valoresFormatados[11] + "  |\n" +
                "+-----+ +-----+ +-----+"+reset+"\n"); 
                break;
        
            case 2:
                if (this.mapCartaJogada < 2) { 

                    if (this.mapCartaJogada == 1) {
                        System.out.println("\n"+cor()+"+-----+ +-----+\n" +
                        "|  " + valoresFormatados[0] + "  | |><><>|\n" +
                        "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |><><>|\n" +
                        "|  " + valoresFormatados[3] + "  | |><><>|\n" +
                        "+-----+ +-----+"+reset+"\n");
                    }    

                    if (this.mapCartaJogada == 0) {
                        System.out.println("\n"+cor()+"+-----+ +-----+\n" +
                        "|><><>| |><><>|\n" +
                        "|><><>| |<><><|\n" +
                        "|><><>| |><><>|\n" +
                        "+-----+ +-----+"+reset+"\n");
                    }
                    
                    System.out.println("\nPressione" +red+ " ENTER " +reset+ "para mostrar suas cartas.");
                    controle = scann.nextLine();
                }

                System.out.println("\n"+cor()+"+-----+ +-----+\n" +
                "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  |\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "|\n" +
                "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  |\n" +
                "+-----+ +-----+"+reset+"\n");
                break;
        
            case 1:
                if (this.mapCartaJogada < 2) { 

                    System.out.println("\n"+cor()+"+-----+\n" +
                    "|><><>|\n" +
                    "|><><>|\n" +
                    "|><><>|\n" +
                    "+-----+"+reset+"\n");
                    
                    System.out.println("\nPressione" +red+ " ENTER " +reset+ "para mostrar suas cartas.");
                    controle = scann.nextLine();
                }

                System.out.println("\n"+cor()+"+-----+\n" +
                "|  " + valoresFormatados[0] + "  |\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "|\n" +
                "|  " + valoresFormatados[3] + "  |\n" +
                "+-----+"+reset+"\n");
                break;
        
            default:
                break;
        }
//#endregion
    }

    public Carta jogarCarta(int index) throws Exception {
        if (index >= cartas.size() || index < 0) {
            throw new Exception("Indice inválido");
        }

        return cartas.remove(index);
    }

    public int getQuantCartas() {
        return cartas.size();
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos += pontos;
    }

    public String getNome() {
        return nome;
    }
    
    public void setMapCartaJogada(int cartaJogada) {
        this.mapCartaJogada = cartaJogada;
    }
    
}