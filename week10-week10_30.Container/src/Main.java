import containers.*;

public class Main {

    public static void main(String[] args) {

        ProductContainerRecorder  mtv =new ProductContainerRecorder("kahvi", 10, 1);
        mtv.addToTheContainer(9);
        mtv.takeFromTheContainer(6);
        mtv.printAnalysis();

    }
}
