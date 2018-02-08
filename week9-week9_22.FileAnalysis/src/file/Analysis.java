package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {

    private File file;

    public Analysis(File file){
       try{
           this.file = file;
       } catch (Exception e){

       }
    }

    public int lines(){
        try{
            Scanner reader = new Scanner(this.file);

        int numLine = 0;
        while(reader.hasNext()){
            numLine++;
            reader.nextLine();
        }
        reader.close();
        return numLine;}
        catch(Exception e){
            return 0;
        }
    }

    public int characters(){
        try{
            Scanner reader = new Scanner(this.file);

        int numChar = 0;
        while(reader.hasNext()){
            String lineRead = reader.nextLine();
            numChar += lineRead.toCharArray().length + 1;
        }
        reader.close();
            return numChar;
        }catch(Exception e){
            return 0;
        }

    }
}
