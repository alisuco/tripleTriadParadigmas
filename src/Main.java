import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Cartas> cartas = new ArrayList<>();
 
        String caminho = "C:\\Users\\aliso\\OneDrive\\Área de Trabalho\\Faculdade\\paradigmas\\projeto-unidade-1\\src\\tripletriad\\cards.csv";
        
        List<String[]> dados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String conteudo;
            br.readLine();
            br.readLine();
            while ((conteudo = br.readLine()) != null) {
                String[] valores = conteudo.split(";");
                dados.add(valores); 
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (String[] c : dados) {
            cartas.add(new Cartas("conteudo", Integer.parseInt(c[0]), Integer.parseInt(c[1]), Integer.parseInt(c[2]), Integer.parseInt(c[3])));
        }
      
    }
}