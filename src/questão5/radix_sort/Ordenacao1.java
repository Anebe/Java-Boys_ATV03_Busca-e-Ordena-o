package questão5.radix_sort;
import java.util.ArrayList;
import java.util.List;

public class Ordenacao1 {
    List<Integer> dados = new ArrayList<>();
    int guardaIndex=0;
    int guardaIndex1=0;

    public void funcaoDeDigito(int qtdNaPosicao, int posicao, int qtdDigitosMaiorChave, int casaNum, int[] vetorNum, int[] vetorNumAux){
        char[] digitosNumero;
        int digito;

            for(int j=0; j<vetorNum.length; j++){
                digitosNumero = String.valueOf(vetorNum[j]).toCharArray();
                if(digitosNumero.length < qtdDigitosMaiorChave){
                    digitosNumero = reformaNumero(vetorNum[j], qtdDigitosMaiorChave);
                }
                
                digito = Character.getNumericValue(digitosNumero[digitosNumero.length-(1+casaNum)]);
                
                //parte nova
                if(digito == posicao){
                    vetorNumAux[guardaIndex]=vetorNum[j];
                    guardaIndex++;
                }
            }
        }

    public void funcaoDeOrdenacao(int vetorContador[], int qtdDigitosMaiorChave, int casaNum, int[] vetorNum, int[] vetorNumAux){ 
        
        for(int i=0; i<10; i++){
            if(vetorContador[i] > 0){
                funcaoDeDigito(vetorContador[i], i, qtdDigitosMaiorChave, casaNum, vetorNum, vetorNumAux);
            }
        }
        for(int i=0; i<dados.size(); i++){
            vetorNum[i] = vetorNumAux[i];
        }
    }
    

    public int verificaOrdem(int vetorNum[]){
        for(int i=0; i<vetorNum.length; i++){
            if(i>0){
                if(vetorNum[i] < vetorNum[i-1]){
                    return 1;
                }
            }
        }
        return 0;
    }

    public int pegaMaiorChave(int num[]){
        int maiorChave=0;

        for(int i=0; i<num.length; i++){
            if(num[i]>maiorChave){
                maiorChave = num[i];
            }
        }
        return maiorChave;
    }

    public char[] reformaNumero(int num, int qtdDigitosMaiorChave){
        char[] digitosNumero = new char[qtdDigitosMaiorChave];
        char[] digitosNumero1 = {};
        digitosNumero1 = String.valueOf(num).toCharArray();
        int contador=1;
        int salvaj=100000000; //usa-se um numero muito grande pois o salva j nunca pode iniciar menor que a qtd de digitos da maior chave
        for(int i=qtdDigitosMaiorChave-1; i>=0; i--){
            if(salvaj!=0){
                for(int j=digitosNumero1.length-contador; j>=0; j--){
                    digitosNumero[i] = digitosNumero1[j];
                    salvaj=j;
                    break;
                }
                contador++;
            }else{
                digitosNumero[i] = '0';
            }    
        }
        return digitosNumero;   
    }

    public void ordenar(){
        
        int n= dados.size();
        int vetorNum[] = new int[n];
        int vetorNumAux[] = new int[n]; 

        for(int i=0; i<dados.size(); i++){
            vetorNum[i] = 0;
            vetorNum[i]=dados.get(i);
        }

        int vetorContador[] = new int[10]; 
        int casaNum=0; 
        int maiorChave=0; 
        int qtdDigitosMaiorChave=0; 
        char[] digitosNumero = {};
        int digito;

        maiorChave = pegaMaiorChave(vetorNum);
        digitosNumero = String.valueOf(maiorChave).toCharArray();
        qtdDigitosMaiorChave = digitosNumero.length;

        for(int i=0; i<dados.size(); i++){
            vetorNumAux[i] = 0;
        }

        while(verificaOrdem(vetorNum) != 0){
            
            for(int i=0; i<10; i++){     
                vetorContador[i] = 0;
            }

            for(int i=0; i<vetorNum.length; i++){
                digitosNumero = String.valueOf(vetorNum[i]).toCharArray();
                if(digitosNumero.length < qtdDigitosMaiorChave){
                    digitosNumero = reformaNumero(vetorNum[i], qtdDigitosMaiorChave);
                }
                digito = Character.getNumericValue(digitosNumero[digitosNumero.length-(1+casaNum)]);
                vetorContador[digito]+=1;
            }

            funcaoDeOrdenacao(vetorContador, qtdDigitosMaiorChave, casaNum, vetorNum, vetorNumAux);

            casaNum++;
            guardaIndex=0;
            guardaIndex1=0;
            System.out.println();
        }
        
        System.out.println("VETOR ORDENADO");

        for(int i=0; i<vetorNum.length; i++){
            System.out.print("t: "+vetorNum[i]+", ");
        }
    }
}
