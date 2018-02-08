import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Points{
    private ArrayList<Integer> judgePoints;
    private int totalPoints;
    private int length;


    public  Points(){
        //Set up the random generator
        Random rand = new Random();
        //Set up the array to store the 5 judges pointage
        this.judgePoints = new ArrayList();
        this.totalPoints = 0;

        //Fill the array with random judges pointages between 10-20
        for(int i = 0; i < 5; i++){
            this.judgePoints.add(rand.nextInt(10) + 11 );
        }

        //Define the distance jumped at random between 60-120
        this.length = rand.nextInt(60) + 61;

        Collections.sort(this.judgePoints);

        int sum = 0;

        for(int num: this.judgePoints.subList(1,4)){
            sum += num;
        }
        this.totalPoints = sum + this.length;
    }

    //Return the length of the jump
    public int getLength(){
        return this.length;
    }

    //Return an array with all the judges votes
    public ArrayList<Integer> getJudgeVote(){
        return this.judgePoints;
    }

    //Return the total points for this round
    public int getJumpPoints(){
        return this.totalPoints;
    }

}
