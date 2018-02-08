import java.util.ArrayList;

public class Jumper implements Comparable<Jumper> {

    private String name;
    private ArrayList<Points> jumps;
    private int totalPoints;

    public Jumper(String name) {
        this.name = name;
        this.jumps = new ArrayList();
        this.totalPoints = 0;
    }

    //Add a jump to the jumper
    public void jump(){
        Points jumpPoint = new Points();
        this.jumps.add(jumpPoint);
        this.totalPoints += jumpPoint.getJumpPoints();
    }

    //Return the total points of the Jumper
    public int getTotalPoints(){
        return this.totalPoints;
    }

    //Return the lenght of the jumps at index x
    public int getLength(int index){
        return this.jumps.get(index).getLength();
    }

    public ArrayList<Integer> getJudgesVotes(int index){
        return this.jumps.get(index).getJudgeVote();
    }

    //Return the name of the jumper
    public String getName(){
        return this.name;
    }

    //Return the jump at index x
    public Points jumps(int index){
        return this.jumps.get(index);
    }

    //Method to compare the total points

    public int compareTo(Jumper jumper){
        if(this.getTotalPoints() == jumper.getTotalPoints()){
            return 0;
        } else if(this.getTotalPoints() < jumper.getTotalPoints()){
            return -1;
        } else {
            return 1;
        }
    }

}
