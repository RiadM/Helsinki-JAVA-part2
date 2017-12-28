public class Plane {

    private String idPlane;
    private int capacity;

    public Plane(String idPlane, int capacity) {
        this.idPlane = idPlane;
        this.capacity = capacity;
    }

    public String getId(){
        return this.idPlane;
    }
    public String planeInfo(){
        return this.idPlane+ " (" + this.capacity + " ppl)";
    }
}
