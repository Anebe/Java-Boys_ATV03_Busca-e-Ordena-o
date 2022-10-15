
package questão5.heap_sort;

import comum.Arquivo;

public class HeapSort_Int {
    public static void main(String[] args){
        Arquivo arq = new Arquivo("entrada/numeros.txt");
        Integer[] vetor = arq.lerTudoInt();
        
        
        System.out.println("Desordenado");
        for(int i= 0;i<vetor.length;i++){
            System.out.print(vetor[i]+" ");
        }
        
        int n = vetor.length;
        
        for(int i =n/2-1;i>=0;i--){
            heapsort(vetor,n,i);
        }
        
        for(int i = n-1;i>0;i--){
            int aux= vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = aux;
            
            heapsort(vetor, i, 0);
        }

        System.out.println("\nOrdenado");
        for(int i= 0;i<vetor.length;i++){
            System.out.print(vetor[i]+" ");
        }      
    }
    
    public static void heapsort(Integer[] vetor, int n, int i){
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        
        if(esquerda < n && vetor[esquerda] > vetor[raiz]){
            raiz = esquerda;
        }
        if(direita < n && vetor[direita] > vetor[raiz]){
            raiz = direita;
        }
        
        if(raiz!=i){
            int aux = vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz]= aux;
            
            heapsort(vetor, n, raiz);
        }
    }
}