package farmsimulator;

public class BulkTank {

    private double capacity;
    private double volume;

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }

    public BulkTank() {
        this(2000.0);
    }

    public double getCapacity(){
        return this.capacity;
    }

    public double getVolume(){
        return this.volume;
    }

    public double howMuchFreeSpace(){
        return this.capacity - this.volume;
    }

    public void addToTank(double amount){
        if(this.volume + amount >= this.capacity){
            this.volume = capacity;
        }else{
            this.volume += amount;
        }
    }

    public double getFromTank(double amount){
        if(this.volume - amount <= 0){
            double swap = this.volume;
            this.volume = 0;
            return swap;
        }else{
            this.volume -= amount;
            return amount;
        }
    }

    public String toString(){
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}
