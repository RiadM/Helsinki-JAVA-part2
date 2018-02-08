package farmsimulator;

import java.util.Random;

public class Cow implements Alive, Milkable{

    private String name;
    private Random rand = new Random();
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    private double capacity;
    private double availableMilk;

    public Cow(){
        this.capacity = 15 + rand.nextInt(26);
        this.name = NAMES[rand.nextInt(NAMES.length)];
    }
    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + rand.nextInt(26);
    }

    public String getName(){
        return this.name;
    }

    public double getCapacity(){
        return this.capacity;
    }

    public double getAmount(){
        return this.availableMilk;
    }

    public String toString(){
        return this.name + " " + this.availableMilk  + "/" + this.capacity;
    }

    @Override
    public void liveHour() {

        double randomMilk = Math.ceil(0.7 + rand.nextDouble() * (2 - 0.7));

        if(randomMilk + this.availableMilk <= this.capacity){
            this.availableMilk += randomMilk;
        }else{
            this.availableMilk = this.capacity;
        }
    }

    @Override
    public double milk() {
        double milkToReturn = this.availableMilk;
        this.availableMilk = 0;
        return milkToReturn;
    }
}
