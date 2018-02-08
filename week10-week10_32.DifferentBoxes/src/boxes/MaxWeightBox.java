package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box{

    private int maxWeight;
    private List<Thing> thingsInBox;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.thingsInBox = new ArrayList();
    }

    @Override
    public void add(Thing thing) {

        int totalWeight = 0;
        for(Thing things: this.thingsInBox){
            totalWeight += things.getWeight();
        }

        if(totalWeight + thing.getWeight() <= this.maxWeight){
            this.thingsInBox.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if(this.thingsInBox.contains(thing)){
            return true;
        }
        return false;
    }
}
