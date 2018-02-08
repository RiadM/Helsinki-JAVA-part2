package dungeon;

import java.util.ArrayList;

public class Map {

    private int length;
    private int height;
    private ArrayList<ArrayList<Character>> map;

    public Map(int length, int height) {
        this.length = length;
        this.height = height;

        this.map = new ArrayList();

        setMap();
    }


    public void drawMap(ArrayList<Being> beings){

        for(Being being: beings){
            this.map.get(being.getPoint().getY()).set(being.getPoint().getX(),being.getName());
        }

        for(ArrayList<Character> line: this.map){
            for(Character character: line){
                System.out.print(character);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void clearSpot(int x, int y){
        this.map.get(y).set(x,'.');
    }

    //Fill the map with . for the begining
    public void setMap() {
        for (int i = 0; i < this.height; i++) {
            ArrayList<Character> line = new ArrayList();
            for( int j = 0; j < this.length; j++){
                line.add('.');
            }
            this.map.add(line);
        }
    }
}
