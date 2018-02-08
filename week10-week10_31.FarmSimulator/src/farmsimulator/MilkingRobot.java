package farmsimulator;

public class MilkingRobot {

    private BulkTank bulkTank;

    public MilkingRobot(){
        this.bulkTank = null;
    }

    public BulkTank getBulkTank(){
        if(this.bulkTank == null){
            return null;
        }else{
            return this.bulkTank;
        }
    }

    public void setBulkTank(BulkTank tank){
        this.bulkTank = tank;
    }

    public void milk(Milkable milkable){
        try {
            this.bulkTank.addToTank(milkable.milk());
        }catch (Exception e) {
            throw new IllegalStateException();
        }
    }
}
