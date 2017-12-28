import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> dictionnary = new HashMap<String, String>();

    public String translate(String word){

        if(dictionnary.containsKey(word)){
            return dictionnary.get(word);
        }
        return null;
    }

    public void add(String word, String translation){
        dictionnary.put(word, translation);
    }

    public int amountOfWords(){
        return dictionnary.size();
    }

    public ArrayList<String> translationList(){
        ArrayList<String> returnList = new ArrayList();
        for(String translation: dictionnary.keySet()){
            returnList.add(translation + " = " + dictionnary.get(translation));
        }
        return  returnList;
    }
}
