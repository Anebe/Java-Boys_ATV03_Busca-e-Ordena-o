package questão1;

import comum.Arquivo;
import java.util.StringTokenizer;

public class Ex001 {
        public static void main(String[] args) {
        Arquivo arquivo = new Arquivo("entrada/produtos.txt");
        String[] conteudo = arquivo.lerTudoString();
        StringTokenizer key;
        
        ControleDeEstrutura control = new ControleDeEstrutura();
        Lista_Dupla lista = new Lista_Dupla();
                
        for (String linha : conteudo) {
            key = new StringTokenizer(linha, ";");
            while(key.hasMoreElements()){ 
                Produto produto = new Produto(Integer.parseInt(key.nextToken()),
                        key.nextToken(),
                        Double.parseDouble(key.nextToken()));
                lista.adicionar(produto);
            }
        }
        
        
        System.out.println(lista.imprimir());
        
        System.out.println("---------------- ORDENAÇÕES --------------------");
        
        System.out.println("\nOrdem Alfabetica: ");
        control.ordemAlpha(lista);
        
        System.out.println("-------------------------------------------");
        System.out.println("\nOrdem Crescente valor: ");
        control.ordemCrescente(lista);
        
        System.out.println("-------------------------------------------");
        System.out.println("\nOrdem Decrescente valor: ");
        control.ordemDecrescente(lista);
    }
    
}
