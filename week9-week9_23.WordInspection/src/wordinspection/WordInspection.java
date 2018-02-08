package wordinspection;

import javax.lang.model.type.ArrayType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {

    private File file;
    private ArrayList<String> listWords;

    public WordInspection(File file){
        this.file = file;
        this.listWords = new ArrayList();
        wordList();
    }

    public int wordCount(){
        return this.listWords.size();
    }

    public List<String> wordsEndingInL(){
        List<String> list = new ArrayList();
        for(String word: this.listWords){
            if(word.lastIndexOf("l") == word.length() - 1){
                list.add(word);
            }
        }
        return list;
    }

    public List<String> wordsContainingZ(){
        List<String> list = new ArrayList();

        for(String word: this.listWords){

            if(word.lastIndexOf("z") != -1){
                list.add(word);
            }
        }
        return list;
    }

    //Return a list of word who are palindromes
    public List<String> palindromes(){
        List<String> list = new ArrayList();

        for(String word: this.listWords){
            if(reverse(word).equals(word)){
                list.add(word);
            }
        }
        return list;
    }

    public List<String> wordsWhichContainAllVowels(){

        List<String> list = new ArrayList();
        List<String> returnList = this.listWords;
        String vowels = "aeiouyäö";

        for(String word: this.listWords){
            int i = 0;
            while(i < vowels.length()){
                if(word.contains(vowels.substring(i,i+1)) == false){
                    list.add(word);
                    i = vowels.length();
                }
                i++;
            }
        }

        returnList.removeAll(list);
        return returnList;
    }

    public void wordList(){
        try{
            Scanner reader = new Scanner(this.file);
            while(reader.hasNext()){
                String[] line = reader.nextLine().split("\\s+");
                for(String string: line){
                    this.listWords.add(string);
                }
            }
            reader.close();

        } catch (Exception e){

        }
    }

    //Return a String of the word in reverse
    public String reverse(String word){
        String swap = "";
        for(int i =  word.length() - 1; i >= 0; i--){
            swap += word.charAt(i);
        }
        return swap;
    }
}
