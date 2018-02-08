
public class Main {
    public static void main(String[] args) {
        Object b1 = new Bird("Varis", "Corvus corone cornix", 1952);
        Object b2 = new Bird("Varis", "Corvus corone cornix", 1952);
        System.out.println(b1);
        System.out.println(b1.equals(b2));
    }
}
