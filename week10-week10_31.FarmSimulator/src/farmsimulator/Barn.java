package farmsimulator;

import java.util.Collection;

public class Barn {

    private BulkTank tank;
    private MilkingRobot milkingRobot;

    public Barn(BulkTank tank) {
        this.tank = tank;
        this.milkingRobot = null;
    }

    public BulkTank getBulkTank(){
        if(this.tank != null){
            return this.tank;
        }else{
            return null;
        }
    }

    public void installMilkingRobot(MilkingRobot milkingRobot){
        this.milkingRobot = milkingRobot;
        this.milkingRobot.setBulkTank(this.tank);
    }

    public void takeCareOf(Cow cow){
        try{
            this.milkingRobot.milk(cow);
        }catch (Exception e){
            throw new IllegalStateException();
        }
    }

    public void takeCareOf(Collection<Cow> cows){
        if(this.milkingRobot == null){
            throw new IllegalStateException();
        }else{
            for(Cow cow: cows){
                this.milkingRobot.milk(cow);
            }
        }
    }

    public String toString(){
        return "" + this.tank;
    }
}
