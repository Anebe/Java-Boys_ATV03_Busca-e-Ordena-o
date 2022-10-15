package questão3;

import java.util.stream.IntStream;

import comum.Arquivo;

public class Busca {  
    Integer[] vNum;
    int num;

    public void carregarArray(){
        Arquivo arq = new Arquivo("entrada/dadosQ1.txt");
        vNum = arq.lerTudoInt();
    }

    public void buscar(){
        carregarArray();
        int qtd=0;
        int[] arrayAux = new int[vNum.length];

        for(int i=0; i<vNum.length; i++){
            num = vNum[i];
            if((IntStream.of(arrayAux).anyMatch(x -> x == num)) == false){
                arrayAux[i] = num;
                qtd++;
            }
        }

        System.out.println("qtd: " + qtd);
    }

}
