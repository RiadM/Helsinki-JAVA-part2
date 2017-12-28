import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Thing> things;
    private int maxWeight;
    private Thing heaviestThing;

    public Suitcase(int maxWeight) {
        this.things = new ArrayList();
        this.maxWeight = maxWeight;
    }

    public void addThing(Thing thing){
        if((totalWeight() + thing.getWeight()) <= this.maxWeight){
            this.things.add(thing);
        }
    }

    public  String toString(){
        if(this.things.isEmpty()){
            return "empty (0 kg)";
        } else if(this.things.size() == 1){
            return this.things.size() + " thing (" + totalWeight() + "kg)";
        }
        return this.things.size() + " things (" + totalWeight() + "kg)";
    }

    public void printThings(){
        for(Thing things: this.things){
            System.out.println(things.toString());
        }
    }

    public int totalWeight(){
        int totalWeight = 0;
        for (Thing things: this.things){
            totalWeight += things.getWeight();
        }
        return totalWeight;
    }

    public Thing heaviestThing(){
        if(this.things.size()==0){
            return null ;
        }
        this.heaviestThing = this.things.get(0);
        for(Thing thing: this.things){
            if(this.heaviestThing.getWeight() < thing.getWeight() ){
                this.heaviestThing = thing;
            }
        }
        return this.heaviestThing;
    }
}
