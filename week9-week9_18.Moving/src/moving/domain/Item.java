package moving.domain;

public class Item implements Thing, Comparable<Item> {

    private int volume;
    private String name;

    public Item(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName(){
        return this.name;
    }

    public int getVolume(){
        return this.volume;
    }

    public String toString(){
        return this.name + " (" + this.volume + " dm^3)";
    }

    public int compareTo(Item comparable){
        if(this.getVolume() == comparable.getVolume()){
            return 0;
        } else if(this.getVolume() > comparable.getVolume() ){
            return 1;
        } else{
            return -1;
        }
    }
}
