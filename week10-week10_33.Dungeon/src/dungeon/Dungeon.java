package dungeon;

import java.util.*;

public class Dungeon {

    private int length ;
    private int height ;
    private int vampires;
    private int moves;
    private boolean vampiresMove;

    private Random random;
    private ArrayList<Being> beings;
    private Map map;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length         = length;
        this.height         = height;
        this.vampires       = vampires;
        this.moves          = moves;
        this.vampiresMove   = vampiresMove;

        this.random = new Random();
        this.beings = new ArrayList();
        this.map = new Map(this.length,this.height);
    }


    public void run() {
        //----------SET UP-------------------
        Scanner scan = new Scanner(System.in);
        this.beings.add(new Player());
        vampireAdd();
        //---------------------------------------
        //-------Print the starting info---------
        printInfos();
        //---------------------------------------

        while (this.moves > 0) {
            this.moves--;
            //-------USER MOVING----------------------
            String[] userInput = scan.nextLine().toLowerCase().split("(?!^)");
            //Will make action till all the user input for this turn are done
            for (String input : userInput) {
                Point movePoint;

                HashSet<Being> kill = new HashSet();

                //Will act upon all beings, till all the user input are done
                for (Being being : this.beings) {
                    if (being.getName() == 'v') {
                        movePoint = being.moving(randomInput());
                    } else {
                        movePoint = being.moving(input);
                    }

                    int x = movePoint.getX() + being.getPoint().getX();
                    int y = movePoint.getY() + being.getPoint().getY();
                    Point testPoint = new Point(x, y);
                    // @TODO Optimize here I think there's a faster way even if it's not really necessary since the program is small
                    if (x < this.length && x >= 0 && y < this.height && y >= 0 && being.getPoint().isMovable()) {

                        //kill the vampire if the player is there
                        if (being.getName().equals('v')) {
                            if (testPoint.equals(this.beings.get(0).getPoint())) {
                                kill.add(being);
                            } else {
                                boolean move = true;
                                for (int i = this.beings.size() - 1; i > 0; i--) {
                                    if (this.beings.get(i).getPoint().equals(testPoint)) {
                                        move = false;
                                        i = 0;
                                    }
                                }

                                if (move) {
                                    being.getPoint().changePoint(movePoint);
                                    this.map.clearSpot(x - movePoint.getX(), y - movePoint.getY());
                                }
                            }
                        }

                        //Kill the being if the player go on it
                        if (this.beings.get(0).equals(being)) {

                            //Iterate to see if the player is on the same point as a vampire
                            for (int i = this.beings.size() - 1; i > 0; i--) {
                                if (this.beings.get(i).getPoint().equals(testPoint)) {
                                    kill.add(this.beings.get(i));
                                    i = 0;
                                }
                            }
                            //Move the player
                            being.getPoint().changePoint(movePoint);
                            this.map.clearSpot(x - movePoint.getX(), y - movePoint.getY());
                        }


                        //being.getPoint().changePoint(movePoint);
                        //map.clearSpot(x - movePoint.getX(), y - movePoint.getY());
                    }
                }
                this.beings.removeAll(kill);
            }
            if(this.beings.size() == 1){
                System.out.println("YOU WIN");
                break;
            }
            printInfos();
        }
        if(this.moves == 0 && this.beings.size() > 1){
            System.out.println("YOU LOSE");
        }
    }
    public String randomInput(){
        int generated = random.nextInt(4);
        String[] movement = {"w","a","s","d"};
        return movement[generated];

    }
    public void printInfos() {
        System.out.println(this.moves);
        System.out.println("");
        for(Being being: this.beings){
            System.out.println(being);
        }
        System.out.println("");
        this.map.drawMap(this.beings);
    }

    //Create Vampire with random position
    public Vampire vampireSet(){
        int x = random.nextInt(this.length - 1) + 1;
        int y = random.nextInt(this.height - 1) + 1;
        return new Vampire(x,y,this.vampiresMove);
    }

    //Add unique vampire to the list
    public void vampireAdd(){
        //Will permit to know if every vampires are different
        Set<Being> swap = new HashSet();

        //Iterate till the set is equal to the number of vampire we need
        while(swap.size()  != this.vampires){
            //Create a new vampire
            Vampire vamp = vampireSet();
            //Test if the vampire is unique
            if(swap.add(vamp)){
                //Add the vampire to the real list if it's unique
                this.beings.add(vamp);
            }
        }
        //Clear the set, I guess it's optional
        swap.clear();
    }


}

