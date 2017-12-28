public class Flight {

    private Plane plane;
    private String departure;
    private String destination;

    public Flight(Plane plane, String departure, String destination) {
        this.plane = plane;
        this.departure = departure;
        this.destination = destination;
    }


    public void infoFlight(){
        System.out.println(this.plane.planeInfo() + " (" + this.departure + "-" + this.destination + ")");
    }
}
