
package questão4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Ler {
    int[] vet;

    public Ler(int[] vet) {
        this.vet = vet;
    }
    public Ler() {
    }
    public int[] getVet() {
        return vet;
    }

    public void setVet(int[] vet) {
        this.vet = vet;
    }
    
    public void lerArq(){
        String path = "C:\\Users\\Matheus\\Documents\\NetBeansProjects\\Ed_Atvs\\src\\exercicio_4\\sequencia.txt";
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            
            String[] arrayLine = line.split(" ");
            vet = new int [arrayLine.length];
            
            for(int i=0;i<arrayLine.length;i++){
                vet[i]= Integer.parseInt(arrayLine[i]);
            }
        } catch(IOException e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
    
}

