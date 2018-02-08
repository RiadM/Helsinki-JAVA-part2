package dungeon;

public class Point {

    private int x;
    private int y;
    private boolean movable;

    public Point(int x, int y, boolean movable){
        this.movable = movable;
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y) {
        this(x,y,true);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changePoint(Point point) {
        if(this.movable == true){
            this.x += point.getX();
            this.y += point.getY();
        }
    }

    public boolean isMovable() {
        return movable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public String toString(){
        return  this.x + " " + this.y;
    }
}
