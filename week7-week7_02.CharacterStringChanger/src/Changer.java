import java.util.ArrayList;

public class Changer {
    private ArrayList<Change> listOfChange;

    public Changer(){
        this.listOfChange = new ArrayList();
    }

    public void addChange(Change change){
        this.listOfChange.add(change);
    }

    public String change(String characterString){

        for(Change Change: this.listOfChange) {
            characterString = Change.change(characterString);
        }
        return characterString;
    }
}
