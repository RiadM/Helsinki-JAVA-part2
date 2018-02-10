package reference.comparator;

import reference.domain.Person;

import java.util.Comparator;
import java.util.Map;

public class PersonComparator implements Comparator<Person> {

    private Map<Person, Integer> peopleIdentities;

    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }

    @Override
    public int compare(Person o1, Person o2) {
        int one = this.peopleIdentities.get(o1);
        int two = this.peopleIdentities.get(o2);
        if(one > two){
            return -1;
        }
        if(one < two){
            return 1;
        }else{
            return 0;
        }
    }
}
