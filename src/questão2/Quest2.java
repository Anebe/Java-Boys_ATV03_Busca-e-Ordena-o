package questão2;

import comum.Arquivo;
import java.util.Arrays;

public class Quest2 {
    public static void main(String[] args) {
        Arquivo arqNomes = new Arquivo("entrada/nomes.txt");
        String[] nome =arqNomes.lerTudoString();

        for (String nomeParaAnagrama : nome) {
            System.out.println("Todos anagramas de " + nomeParaAnagrama + ":");
            Quest2.printAnagram(nomeParaAnagrama.toString().toCharArray());
        }
    }

    //função auxiliar porque a verdeira função recursiva precisa do 2° vazio na primeira chamada
    public static void printAnagram(char[] word){
        caminharFila(word, "");
    }

    //Recusivamente pega o primeiro elemento, concatena ele com 2° parâmetro,
    //cria novo char[] com todos elementos exceto 1° e chama função de novo
    //até que todos elementos tenham sido 1° uma vez
    private static void caminharFila(char[] word, String printWord){
        for (int i = 0; i < word.length; i++) {
            if(word.length > 1){
                char[] proxWord = Arrays.copyOfRange(word, 1, word.length);
                caminharFila(proxWord, printWord.concat(String.valueOf(word[0])));
            }else{
                System.out.println("\t" + printWord + String.valueOf(word));
            }
            word = addLast(word); 
        }
    }
    //Adiciona o 1° ao final e traz os outros pra frente
    private static char[] addLast(char[] word){
        char first = word[0];
        for (int i = 0; i < word.length - 1; i++) {
            word[i] = word[i+1];
        }
        word[word.length-1] = first;
        return word;
    }
}
