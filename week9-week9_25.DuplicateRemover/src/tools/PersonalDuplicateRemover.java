package tools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover{

    private Set<String> personal;
    private Integer numberDuplicate;

    public PersonalDuplicateRemover(){
        this.personal = new HashSet();
        this.numberDuplicate = 0;
    }

    @Override
    public void add(String characterString) {
       if(this.personal.contains(characterString)){
           this.numberDuplicate++;
       }else{
           this.personal.add(characterString);
       }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.numberDuplicate;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {

        return this.personal;
    }

    @Override
    public void empty() {
        this.personal.clear();
        this.numberDuplicate = 0;
    }
}
