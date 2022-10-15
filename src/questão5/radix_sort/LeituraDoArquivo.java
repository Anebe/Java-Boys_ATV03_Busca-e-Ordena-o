package questão5.radix_sort;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraDoArquivo {

    static Ordenacao1 od = new Ordenacao1();

    String[] dadosLidos;

    public void leitura() {

        String path = "entrada/dadosQ2.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            
            String[] arrayLine = line.split(" ");

            for (int i=0; i<arrayLine.length; i++) {
                od.dados.add(Integer.parseInt(arrayLine[i]));
            }
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
