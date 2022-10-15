package comum;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Arquivo {
    File arquivo;

    public Arquivo(){}
    public Arquivo(String path){
        loadPath(path);
    }

    public boolean loadPath(String path){
        try{
            arquivo = new File(path);
            if(!arquivo.exists()){
                arquivo = null;
                throw new Exception("O sistema não conseguiu encontrar o caminho especificado");
            }
        }catch(Exception e){
            System.err.println(e);
            return false;
        }

        return true;
    }
    
    public void write(Object dado){
        try {
            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(dado.toString());
            
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public Object lerEnesima(int line){
        Object result = null;
        try {
            FileReader fr = new FileReader( arquivo );
            BufferedReader br = new BufferedReader(fr);

            for (int i = 1; i < line && br.ready(); i++) {
                br.readLine();
            }
            result = br.readLine();
            
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object[] lerTudo(){
        ArrayList<Object> result = new ArrayList<Object>();

        try {
            FileReader fr = new FileReader( arquivo );
            BufferedReader br = new BufferedReader(fr);

            while(br.ready()){
                result.add(br.readLine());
            }
            
            
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toArray();
    }

    public Integer[] lerTudoInt(){
        ArrayList<Integer> result = new ArrayList<Integer>();

        try {
            FileReader fr = new FileReader( arquivo );
            BufferedReader br = new BufferedReader(fr);

            while(br.ready()){
                result.add(Integer.parseInt(br.readLine()));
            } 
            
            br.close();
            fr.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        return result.toArray(Integer[]::new);
    }

    public String[] lerTudoString(){
        ArrayList<String> result = new ArrayList<String>();

        try {
            FileReader fr = new FileReader( arquivo );
            BufferedReader br = new BufferedReader(fr);

            while(br.ready()){
                result.add(br.readLine());
            }
            
            
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toArray(String[]::new);
    }

}
