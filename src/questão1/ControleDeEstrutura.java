
package questão1;

public class ControleDeEstrutura {
    //Quicksort Alfabética
    public void quicksortAlpha(Produto[] vetor, int esq, int dir){
        //Condição de parada
        if(esq < dir){
            int pivo = particaoAlpha(vetor, esq, dir);
            quicksortAlpha(vetor, esq, pivo);
            quicksortAlpha(vetor, pivo+1, dir);
        }
    }
    
    public int particaoAlpha(Produto[] vetor, int esq, int dir){
        int meio = (int) (esq + dir)/2;
        Produto pivot = vetor[meio];
        int i = esq - 1;
        int j = dir + 1;
        while(true){
            do{
                i++;
            }while(vetor[i].getDescricao().compareTo(pivot.getDescricao()) < 0);
            
            do{
                j--;
            }while(vetor[j].getDescricao().compareTo(pivot.getDescricao()) > 0);
            
            if(i >= j){
                return j;
            }
            
            Produto aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }
    
    //QuickSort Crescente
    public void quicksortCrescente(Produto[] vetor, int esq, int dir){
        //Condição de parada
        if(esq < dir){
            int pivo = particaoCrescente(vetor, esq, dir);
            quicksortCrescente(vetor, esq, pivo);
            quicksortCrescente(vetor, pivo+1, dir);
        }
    }
    
    public int particaoCrescente(Produto[] vetor, int esq, int dir){
        int meio = (int) (esq + dir)/2;
        Produto pivot = vetor[meio];
        int i = esq - 1;
        int j = dir + 1;
        while(true){
            do{
                i++;
            }while(vetor[i].getValor() < pivot.getValor());
            
            do{
                j--;
            }while(vetor[j].getValor() > pivot.getValor());
            
            if(i >= j){
                return j;
            }
            
            Produto aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }
    
    //QuickSort Decrescente
    public void quicksortDecrescente(Produto[] vetor, int esq, int dir){
        //Condição de parada
        if(esq < dir){
            int pivo = particaoDecrescente(vetor, esq, dir);
            quicksortDecrescente(vetor, esq, pivo);
            quicksortDecrescente(vetor, pivo+1, dir);
        }
    }
    public int particaoDecrescente(Produto[] vetor, int esq, int dir){
        int meio = (int) (esq + dir)/2;
        Produto pivot = vetor[meio];
        int i = esq - 1;
        int j = dir + 1;
        while(true){
            do{
                i++;
            }while(vetor[i].getValor() > pivot.getValor());
            
            do{
                j--;
            }while(vetor[j].getValor() < pivot.getValor());
            
            if(i >= j){
                return j;
            }
            
            Produto aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }
    
    //Ordem Alfabética
    public void ordemAlpha(Lista_Dupla lista){
        Produto[] vetor = new Produto[lista.getTamanho()];
        for(int i=0; i<lista.getTamanho(); i++){
            vetor[i] = (Produto) lista.buscarPos(i);
        }
        quicksortAlpha(vetor, 0, vetor.length-1);
        for(Object item : vetor){
            System.out.println(item+" ");
        }
    }
    
    //Ordem Crescente ao Valor
    public void ordemCrescente(Lista_Dupla lista){
        Produto[] vetor = new Produto[lista.getTamanho()];
        for(int i=0; i<lista.getTamanho(); i++){
            vetor[i] = (Produto) lista.buscarPos(i);
        }
        quicksortCrescente(vetor, 0, vetor.length-1);
        for(Produto item : vetor){
            System.out.println(item+" ");
        }
    }
    
    //Ordem Decrescente ao Valor
    public void ordemDecrescente(Lista_Dupla lista){
        Produto[] vetor = new Produto[lista.getTamanho()];
        for(int i=0; i<lista.getTamanho(); i++){
            vetor[i] = (Produto) lista.buscarPos(i);
        }
        quicksortDecrescente(vetor, 0, vetor.length-1);
        for(Produto item : vetor){
            System.out.println(item+" ");
        }
    }
}
