package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable{

    private List<Movable> groupList;

    public Group() {
        this.groupList = new ArrayList();
    }

    public void addToGroup(Movable movable){
        this.groupList.add(movable);
    }

    public String toString(){
        String finalString = "";

        for(Movable organism: this.groupList){
            finalString+= organism + "\n";
        }
        return finalString;
    }

    @Override
    public void move(int dx, int dy) {
        for(Movable organism: this.groupList){
            organism.move(dx,dy);
        }
    }
}
