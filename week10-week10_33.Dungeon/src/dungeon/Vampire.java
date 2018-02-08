package dungeon;

public class Vampire extends Being{


    public Vampire(int x, int y, boolean movable){
        super('v',x,y,movable);
    }

    public Point getPoint(){
        return super.getPoint();
    }

    public Character getName(){
        return super.getName();
    }

    public String toString() {
        return "v " + super.getPoint();
    }
}
