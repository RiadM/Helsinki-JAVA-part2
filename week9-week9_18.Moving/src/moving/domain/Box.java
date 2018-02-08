package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing {

    private int maximumCapacity;
    private List<Thing> things;


    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.things = new ArrayList();
    }

    public boolean addThing(Thing thing){
        int usedCapacity = 0;
        for(Thing thingVol: things){
            usedCapacity += thingVol.getVolume();
        }
        if(usedCapacity + thing.getVolume() > this.maximumCapacity){
            return false;
        } else{
            this.things.add(thing);
            return true;
        }
    }

    @Override
    public int getVolume() {
        int usedCapacity = 0;
        for(Thing thingVol: things){
            usedCapacity += thingVol.getVolume();
        }
        return usedCapacity;
    }
}
