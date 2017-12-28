public class Calculator {

    private Reader reader;
    private int statistic;



    public Calculator() {
        reader = new Reader();

    }

    public void start(){
        statistic = 0;

        while(true){
            System.out.print("Command: ");
            String command = reader.readString();

            if(command.equalsIgnoreCase("end")){
                break;
            }

            if(command.equalsIgnoreCase("sum")){
                sum();
            } else if(command.equalsIgnoreCase("difference")){
                difference();
            } else if(command.equalsIgnoreCase("product")){
                product();
            }

        }
        statistics();

    }

    private void sum(){
        statistic++;
        System.out.print("Value1: ");
        int value1 = reader.readInteger();
        System.out.print("Value2: ");
        int value2 = reader.readInteger();
        System.out.println("sum of the values " + (value1 + value2));
    }

    private void difference(){
        statistic++;
        System.out.print("Value1: ");
        int value1 = reader.readInteger();
        System.out.print("Value2: ");
        int value2 = reader.readInteger();
        System.out.println("difference of the values " + (value1 - value2));
    }

    private void product(){
        statistic++;
        System.out.print("Value1: ");
        int value1 = reader.readInteger();
        System.out.print("Value2: ");
        int value2 = reader.readInteger();
        System.out.println("product of the values " + (value1 * value2));
    }

    private void statistics(){
        System.out.println("Calculations done " + statistic);
    }

 }
