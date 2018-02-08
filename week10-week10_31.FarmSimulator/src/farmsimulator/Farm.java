package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive{

    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList();
    }


    public void installMilkingRobot(MilkingRobot robot){
        this.barn.installMilkingRobot(robot);
    }
    public void manageCows(){
        this.barn.takeCareOf(this.cows);
    }
    public String getOwner(){
        return this.owner;
    }

    public void addCow(Cow cow){
        this.cows.add(cow);
    }

    public String toString(){
        String part1 = "Farm owner: " + this.owner;
        String part2 = "\nBarn bulk tank: " + this.barn;
        String part3 = "";
        if(this.cows.isEmpty()){
            part3 = "\nNo cows.";
        }else{
            part3 = "\nAnimals:";
            for(Cow cow : this.cows){
                part3 += "\n        " + cow;
            }
        }
        return part1 + part2 + part3;

    }

    @Override
    public void liveHour() {
        for(Cow cow: this.cows){
            cow.liveHour();
        }
    }
}
