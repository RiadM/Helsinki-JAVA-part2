package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class MindfulDictionary {

    private Map<String, String> dictionary;
    private String file ;
    private Set<String> confirmSet;

    public MindfulDictionary(String file) {
        this.dictionary = new HashMap();
        this.file = file;
        this.confirmSet = new HashSet();
    }

    public MindfulDictionary(){
        this(null);
    }

    public void add(String word, String translation){
        if(!this.dictionary.containsKey(word) && !this.dictionary.containsKey(translation)){
            this.dictionary.put(word,translation);
        }
    }

    public void remove(String word){

        if(this.dictionary.containsKey(word)){
            this.dictionary.remove(word);
        }

        if(this.dictionary.containsValue(word)){
            for(String value: this.dictionary.keySet()){
                if(this.dictionary.get(value).equals(word)){
                    word = value;
                }
            }
            this.dictionary.remove(word);
        }
    }

    public boolean load(){
        try{
            File file = new File(this.file);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] splitLine = line.split(":");
                this.dictionary.put(splitLine[0], splitLine[1]);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean save(){
        try{
            FileWriter writer = new FileWriter(this.file);

            for(String str: this.dictionary.keySet()){
                writer.write(str + ":" + this.dictionary.get(str) + "\n");
            }

            writer.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String translate(String word){
        String str = this.dictionary.get(word);

        if(str != null){
            return str;
        }
        if(this.dictionary.containsValue(word)){
            for(String value: this.dictionary.keySet()){
                if(this.dictionary.get(value).equals(word)){
                    return value;
                }
            }
        }
        return null;

    }
}
