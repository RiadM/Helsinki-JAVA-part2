package farmsimulator;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {


        //MilkRobot test
        BulkTank m = new BulkTank(5782.4);
        m.addToTank(3232.13);
        m.addToTank(50000.99);
        m.addToTank(5000.0);
        m.getFromTank(1.5); m.getFromTank(1432.1232);
        m.getFromTank(50000.0);
        System.out.println(m.getVolume());

    }
}
