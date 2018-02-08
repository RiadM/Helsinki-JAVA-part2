package dictionary;
import java.util.*;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary{

    private Map<String, Set<String>> dictionnary;

    public PersonalMultipleEntryDictionary(){
        this.dictionnary = new HashMap();
    }


    @Override
    public void add(String word, String entry) {
        if(!this.dictionnary.containsKey(word)){
            this.dictionnary.put(word,new HashSet<String>());
        }
        this.dictionnary.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        if(!this.dictionnary.containsKey(word)){
            return null;
        }else{
            Set<String> entry = this.dictionnary.get(word);
            return entry;
        }
    }

    @Override
    public void remove(String word) {
        this.dictionnary.remove(word);
    }
}
