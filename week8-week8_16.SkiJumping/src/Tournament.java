import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tournament {

    private ArrayList<Jumper> jumpers;
    private Scanner reader;
    private int round;

    //Set up the variable for this tournament
    public Tournament(){
        this.reader = new Scanner(System.in);
        this.jumpers = new ArrayList();
        this.round = 1;
    }

    //Start the tournament
    public void start(){

        System.out.println("Kumpula ski jumping week" + "\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        //Set up a string not empty so we can add participant
        String userInput = "not empty";

        //Add Jumpers to the tournament
        addJumpers(userInput);

        System.out.println("\n" + "The tournament begins!" + "\n");

        //The round will continue till the user say quit
        while(true) {

            if(userVerification() == false){
                break;
            }

            System.out.println("\n" + "Round " + this.round + "\n");

            jumpingOrder();
            jumpingResults();

            this.round++;
        }

        System.out.println("\n"+"Thanks!"+"\n");

        tournamentResults();

    }

    public boolean userVerification(){
        String userInput = "";

        while(true){
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            userInput = this.reader.nextLine();

            if(userInput.equalsIgnoreCase("jump") ){
                return true;
            } else if(userInput.equalsIgnoreCase("quit")){
                return false;
            } else{

            }
        }
    }

    public void addJumpers(String userInput){

        //While loop so the user can add as many competitor as he want
        while(!userInput.isEmpty()){
            System.out.print("  Participant name: ");
            userInput = this.reader.nextLine();
            //If the userInput is not empty the participant is added to the array
            if(!userInput.isEmpty()) {
                this.jumpers.add(new Jumper(userInput));
            }
        }
    }

    public void jumpingOrder(){
        System.out.println("Jumping order:");

        //Sort the jumpers smallest pointage first
        Collections.sort(this.jumpers);

        //Print the jumpers in the order they will pass
        for(Jumper x: this.jumpers){
            System.out.println("  " + (this.jumpers.indexOf(x) + 1) + ". "+ x.getName() + " (" + x.getTotalPoints() + " points)");
        }

        System.out.println("");
    }

    public void jumpingResults(){

        System.out.println("Results of round " + this.round);

        //Give the result for round X of the tournament
        for(Jumper x: this.jumpers){

            //Make all the jumpers do a jump
            x.jump();

            //Print all the result
            System.out.println("  " + x.getName());
            System.out.println("    length: " + x.getLength(this.round - 1));
            System.out.println("    judge votes: " + x.getJudgesVotes(this.round - 1));
        }
        System.out.println("");
    }

    public void tournamentResults(){
        System.out.println("Tournament results:");
        System.out.println("Position    Name");


        //Sort then Reverse the list so the best are at the begining
        Collections.sort(this.jumpers);
        Collections.reverse(this.jumpers);

        //Print the jumpers with their results
        for(Jumper jumper: this.jumpers){
            System.out.println((this.jumpers.indexOf(jumper) + 1) + "           " + jumper.getName() + " (" + jumper.getTotalPoints() + " points)");
            System.out.print("            jump lengths: ");

            //Print the lengths of all the jump
            for(int x = 0; x < this.round - 1; x++){
                System.out.print(jumper.getLength(x) + " m");
                if(x != this.round - 2){
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }

}
