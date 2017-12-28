import java.util.ArrayList;
import java.util.Scanner;

public class Airport {


    private ArrayList<Flight> flights;
    private ArrayList<Plane> planes;

    public Airport() {
        this.flights    = new ArrayList();
        this.planes     = new ArrayList();
    }

    public void start(Scanner reader){
        airportPanel(reader);
        flightService(reader);
    }
    public void airportPanel(Scanner reader){
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");

        while(true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");

            System.out.print(">");
            String userChoice = reader.nextLine();

            if(userChoice.equalsIgnoreCase("1")){

                System.out.print("Give plane ID: ");
                String idPlane = reader.nextLine();
                System.out.print("Give plane capacity: ");
                int capacityPlane = Integer.parseInt(reader.nextLine());

                this.planes.add(new Plane(idPlane,capacityPlane));
            }
            else if(userChoice.equalsIgnoreCase("2")){
                System.out.print("Give plane ID: ");
                String idPlane = reader.nextLine();
                System.out.print("Give departure airport code: ");
                String departure = reader.nextLine();
                System.out.print("Give destination airport code: ");
                String destination = reader.nextLine();

                for(Plane plane: this.planes){
                    if(plane.getId().equalsIgnoreCase(idPlane)){
                        this.flights.add(new Flight(plane, departure, destination));
                        break;
                    }
                }
            }
            else if(userChoice.equalsIgnoreCase("x")){
                break;
            }
        }
    }

    public void flightService(Scanner reader){
        System.out.println("Flight service");
        System.out.println("------------");

        while(true){
            System.out.println("");
            System.out.println("Choose operation: ");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");

            System.out.print(">");
            String userChoice = reader.nextLine();

            if(userChoice.equalsIgnoreCase("1")){
                for(Plane plane: this.planes){
                    System.out.println(plane.planeInfo());
                }
            }
            else if(userChoice.equalsIgnoreCase("2")){
                for(Flight flight: this.flights){
                    flight.infoFlight();
                }
            }
            else if(userChoice.equalsIgnoreCase("3")){
                System.out.print("Give plane ID: ");
                String userPlaneId = reader.nextLine();

                for(Plane plane: this.planes){
                    if(plane.getId().equalsIgnoreCase(userPlaneId)){
                        System.out.println(plane.planeInfo());
                        break;
                    }
                }
            }
            else if(userChoice.equalsIgnoreCase("x")){
                break;
            }
        }

    }
}
