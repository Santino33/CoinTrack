package Persistance;

import java.io.*;

public class MyFile {
    File f;
    FileWriter fw;
    FileReader fr;
    BufferedWriter bw = null;
    BufferedReader br = null;


    public MyFile(String nameFile) {
        f = new File(nameFile);
    }

    public void openFile(char mode){
        try{
            if(mode == 'w'){
                fw = new FileWriter(f);
                bw = new BufferedWriter(fw);
            }
            else {
                fr = new FileReader(f);
                br = new BufferedReader(fr);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void record(String data){
        if (bw != null){
            try{
                bw.write(data);
                bw.newLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public String read(){
        String cad = "";
        try {
            cad = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return cad;
    }

    public void closeFile(){
        try{
            if (br != null){
                br.close();
            }
            if (bw != null){
                bw.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
