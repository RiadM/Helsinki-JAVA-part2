package dungeon;

public class Being {
    private Point point;
    private Character name;

    public Being(Character name,int x, int y) {
        this(name,x,y,true);
    }

    public Being(Character name,int x, int y, boolean moovable){
        this.name = name;
        this.point = new Point(x,y,moovable);
    }

    public Point getPoint(){
        return this.point;
    }

    public Character getName(){
        return this.name;
    }

    public Point moving(String userInput){

        //Default value for points
        int x = 0;
        int y = 0;

        //Define the change by the input
        if(userInput.contains("w")){
            y = -1;
        }
        if(userInput.contains("s")){
            y = 1;
        }
        if(userInput.contains("a")){
            x = -1;
        }
        if(userInput.contains("d")){
            x = 1;
        }
        return new Point(x,y);
    }
}
