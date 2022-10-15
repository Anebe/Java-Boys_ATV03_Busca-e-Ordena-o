package comum;

import questão1.*;
import questão2.Quest2;
import questão3.Teste;
import questão4.Ex04;
import questão5.bucket_sort.Bucket;
import questão5.heap_sort.HeapSort_Int;

public class Main {
    public static void main(String[] args) {

        if(args.length == 1){
            String quest = args[0];

            if(quest.equals("1")){      Ex001.main(null);}
            else if(quest.equals("2")){ Quest2.main(null);}
            else if(quest.equals("3")){ Teste.main(null);}
            else if(quest.equals("4")){ Ex04.main(null);}
            else{
                System.err.println("Parametro Incorreto!");
            }

            if(quest.equals("bucket")){  Bucket.main(null);}
            else if(quest.equals("heap")){  HeapSort_Int.main(null);}
            else if(quest.equals("radix")){  Teste.main(null);}
            else{
                System.err.println("Parametro Incorreto!");
            }
        
        }else{
            System.err.println("Nenhum parametro colocado!");
        }
        
    }
}
