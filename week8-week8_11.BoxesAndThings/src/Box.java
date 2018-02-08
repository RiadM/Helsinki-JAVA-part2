import java.util.ArrayList;

public class Box implements ToBeStored{
    private double maxWeight;
    private ArrayList<ToBeStored> storedStuff;

    public Box(double maxWeight) {
        this.storedStuff = new ArrayList();
        this.maxWeight = maxWeight;
    }

    public void add(ToBeStored object){

        if(object.weight() + this.weight() <= this.maxWeight ){
            this.storedStuff.add(object);

        }
    }

    public String toString(){
        return "Box: " + this.storedStuff.size() + " things, total weight " + this.weight() + " kg";
    }

    public double weight(){
        double weight = 0;
        for(ToBeStored stuff: this.storedStuff){
            weight += stuff.weight();
        }
        return weight;
    }


}
