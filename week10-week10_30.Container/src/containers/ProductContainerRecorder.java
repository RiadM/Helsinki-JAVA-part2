package containers;

public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory history;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        this.history = new ContainerHistory();
        this.history.add(initialVolume);
    }

    public void addToTheContainer(double amount){
        super.addToTheContainer(amount);
        this.history.add(super.getVolume());
    }

    public double takeFromTheContainer(double amount){
        this.history.add(super.getVolume() - amount);
        return super.takeFromTheContainer(amount);
    }

    public void printAnalysis(){
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + history());
        System.out.println("Greatest product amount: " + this.history.maxValue());
        System.out.println("Smallest product amount: " + this.history.minValue());
        System.out.println("Average: " + history.average());
        System.out.println("Greatest change: " + this.history.greatestFluctuation());
        System.out.println("Variance: " + this.history.variance());
    }

    public String history(){
        return this.history.toString();
    }

}
