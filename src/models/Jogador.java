package models;

import java.util.ArrayList;
import java.util.List;

// "\n+-----+ +-----+ +-----+ +-----+ +-----+\n" +
// "|     | |     | |     | |     | |     |\n" +
// "|     | |     | |     | |     | |     |\n" +
// "|     | |     | |     | |     | |     |\n" +
// "+-----+ +-----+ +-----+ +-----+ +-----+\n";

public class Jogador {
    private List<Carta> cartas;

    public Jogador() {
        this.cartas = new ArrayList<Carta>();

        for (int i = 0; i < 5; i++) {
            cartas.add(Monte.pegarCarta());
        }
    }

    public void mostrarCartas() {
        int[] valores = new int[4];
        char[] valoresFormatados = new char[20];
        int cont = 0, tam = cartas.size();
        for (Carta c : cartas) {
            valores[0] = c.getCima();
            valores[1] = c.getEsquerda();
            valores[2] = c.getDireita();
            valores[0] = c.getBaixo();
            for (int i = 0; i < valores.length; i++) {
                if (valores[i] == 10) {
                    valoresFormatados[cont] = 'A';
                } else {
                    valoresFormatados[cont] = Integer.toString(valores[i]).charAt(0);
                }
                cont++;
            }
        }

        switch (tam) {
            case 5:
                System.out.println("\n+-----+ +-----+ +-----+ +-----+ +-----+\n" +
                "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |  " + valoresFormatados[8] + "  | |  " + valoresFormatados[12] + "  | |  " + valoresFormatados[16] + "  |\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |"+ valoresFormatados[9] + "   " + valoresFormatados[10] + "| |"+ valoresFormatados[13] + "   " + valoresFormatados[14] + "| |"+ valoresFormatados[17] + "   " + valoresFormatados[18] + "|\n" +
                "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |  " + valoresFormatados[11] + "  | |  " + valoresFormatados[15] + "  | |  " + valoresFormatados[19] + "  |\n" +
                "+-----+ +-----+ +-----+ +-----+ +-----+\n");
                break;
        
            case 4:
                System.out.println("\n+-----+ +-----+ +-----+ +-----+\n" +
                "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |  " + valoresFormatados[8] + "  | |  " + valoresFormatados[12] + "  |\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |"+ valoresFormatados[9] + "   " + valoresFormatados[10] + "| |"+ valoresFormatados[13] + "   " + valoresFormatados[14] + "|\n" +
                "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |  " + valoresFormatados[11] + "  | |  " + valoresFormatados[15] + "  |\n" +
                "+-----+ +-----+ +-----+ +-----+\n");    
                break;
        
            case 3:
                System.out.println("\n+-----+ +-----+ +-----+\n" +
                "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  | |  " + valoresFormatados[8] + "  |\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "| |"+ valoresFormatados[9] + "   " + valoresFormatados[10] + "|\n" +
                "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  | |  " + valoresFormatados[11] + "  |\n" +
                "+-----+ +-----+ +-----+\n"); 
                break;
        
            case 2:
                System.out.println("\n+-----+ +-----+\n" +
                "|  " + valoresFormatados[0] + "  | |  " + valoresFormatados[4] + "  |\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "| |"+ valoresFormatados[5] + "   " + valoresFormatados[6] + "|\n" +
                "|  " + valoresFormatados[3] + "  | |  " + valoresFormatados[7] + "  |\n" +
                "+-----+ +-----+\n");
                break;
        
            case 1:
                System.out.println("\n+-----+\n" +
                "|  " + valoresFormatados[0] + "  |\n" +
                "|"+ valoresFormatados[1] + "   " + valoresFormatados[2] + "|\n" +
                "|  " + valoresFormatados[3] + "  |\n" +
                "+-----+\n");
                break;
        
            default:
                break;
        }

    }
}