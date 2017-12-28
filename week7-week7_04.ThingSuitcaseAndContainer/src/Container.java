import java.util.ArrayList;

public class Container {
    private int maxWeight;
    private ArrayList<Suitcase> suitcases;

    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitcases = new ArrayList();
    }

    public void addSuitcase(Suitcase suitcase){
        if((suitcase.totalWeight() + totalWeight() ) <= this.maxWeight){
            this.suitcases.add(suitcase);
        }
    }

    public int totalWeight(){
        int totalWeight = 0;
        for(Suitcase suitcase: this.suitcases){
            totalWeight += suitcase.totalWeight();
        }
        return totalWeight;
    }

    public String toString(){
        return this.suitcases.size() + " suitcases (" + totalWeight() + " kg)";
    }

    public void printThings(){
        for(Suitcase suitcase: this.suitcases){
            suitcase.printThings();
        }
    }
}