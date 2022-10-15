package questão5.bucket_sort;

import comum.Arquivo;

/**
 *
 * @author JavaBoys
 */
public class Bucket {
    
    public static int[] bucketsort(Integer[] array, int max_value){
        //Criando um array vazio com os baldes
        int[] bucket = new int[max_value+1];
        //Criando um array vazio para apresentar o resultado
        int[] array_ordenado = new int[array.length];
        
        //percorrendo o array de entrada para adicionar cada elemento ao array do bucket
        for(int i=0; i<array.length; i++)
            bucket[array[i]]++;
        
        //ordenando cada elemento no array bucket e adicionando cada elemento ordenado em ordem ao array de entrada original
        int position = 0;
        for(int j=0; j<bucket.length; j++)
            for(int k=0; k<bucket[j]; k++)
                array_ordenado[position++] = j;
        
        return array_ordenado;
    }
    
    public static int max_value(Integer[] array){
        int maxValue = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] > maxValue)
                maxValue = array[i];
        }
        return maxValue;
    }
    
    public static void main(String[] args) {

        Arquivo arq = new Arquivo("entrada/bucketDados.txt");
        Integer[] list = arq.lerTudoInt();
        //int[] list = {60, 80, 50, 90, 30, 70, 20};
        int[] new_list = bucketsort(list, max_value(list));
        
        System.out.println("Vetor Original:");
        for(int num : list){
            System.out.print(num+" ");
        }
        System.out.println("\nVetor Ordenado:");
        for(int item : new_list){
            System.out.print(item+" ");
        }
    }
}
