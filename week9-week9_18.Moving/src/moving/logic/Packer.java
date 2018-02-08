package moving.logic;

import moving.domain.Thing;
import moving.domain.Box;

import java.util.ArrayList;
import java.util.List;

public class Packer {
    private int boxesVolume;
    private List<Box> usedBox;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
        this.usedBox = new ArrayList();

    }

    public List<Box> packThings(List<Thing> things){
        Box box = new Box(this.boxesVolume);

        for(Thing thing: things){
            if(!box.addThing(thing)){
                this.usedBox.add(box);
                box = new Box(this.boxesVolume);
                box.addThing(thing);
            }
        }
        this.usedBox.add(box);
        return this.usedBox;
    }
}
