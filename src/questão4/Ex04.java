
package questão4;

import java.util.Arrays;

import comum.Arquivo;

public class Ex04 {
        
    public static void main(String[] args) {
        
        Arquivo arq = new Arquivo("entrada/sequencia.txt");
        Integer vet[] = arq.lerTudoInt();

        
        System.out.println("A sequencia inserida foi: ");
        for(int i=0;i<vet.length;i++){
            System.out.print(vet[i]+" ");
        }
        System.out.println("");
        
        Ex04 t = new Ex04();
        t.mediana(vet);
    }
    
    public Integer[] ordenar(Integer vetor[]){
        Integer[]novo = verificaRepetidos(vetor);
        int aux=0;
        for(int j =0; j<novo.length;j++){
            for(int i=0; i<novo.length;i++){
                if(novo[j]<novo[i]){
                    aux = novo[j];
                    novo[j]= novo[i];
                    novo[i]=aux;
                }
            }
        }
        System.out.println("Sequencia Ordenado: ");
        for(int i=0;i<novo.length;i++){
            System.out.print(novo[i]+" ");
        }
        System.out.println("");
        return novo;
    }
    
    public static Integer[] removerReptidos(Integer vetor[]){
        int n = vetor.length;
        Integer[] novo = Arrays.copyOf(vetor,n);
        
        for(int i =0;i<n;i++){
            int k = i + 1;
            int removidos = 0;
            for(int j = i+1;j<n;j++){
                if(novo[j]==novo[i])
                    removidos++;
                else
                    novo[k++]=novo[j];
            }
            n=n-removidos;
        }
        novo = Arrays.copyOf(novo,n);
        return novo;
    }
    
    public Integer[] verificaRepetidos(Integer vetor[]){
        Integer novo[];
        int n = vetor.length;
        int aux = 0;
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(vetor[i]==vetor[j])
                    aux ++;
            }
        }
        if(aux!=0){
            System.out.println("A sequencia foi modifica pois existiam valores repidos nela(Exigencia de numeros distintos pela questão).\nNova Sequencia:");
            novo = removerReptidos(vetor);
            for(int i=0;i<novo.length;i++){
                System.out.print(novo[i]+" ");
            }
            System.out.println("");
            return novo;
        }
        else
            return vetor;
    }
    
    public void mediana(Integer vet[]){
        Integer[] novovet = ordenar(vet);
        if(novovet.length % 2!=0){
            int posicao = novovet.length / 2;
            System.out.println("A mediana da sequencia é: "+ novovet[posicao]);
        }else{
            int posicao = novovet.length /2;
            int soma = novovet[posicao] + novovet [posicao-1];
            System.out.println("A mediana da sequencia é: "+ soma/2);
        }

    }

}
