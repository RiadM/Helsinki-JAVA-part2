package dungeon;

public class Player extends Being{

    public Player() {
        super('@',0,0);
    }

    public Point getPoint(){
        return super.getPoint();
    }

    public Character getName(){
        return super.getName();
    }

    @Override
    public String toString() {
        return "@ " + super.getPoint();
    }
}
