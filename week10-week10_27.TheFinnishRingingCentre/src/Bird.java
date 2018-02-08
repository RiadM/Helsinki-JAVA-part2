
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    public int getRingingYear(){
        return this.ringingYear;
    }

    public String getLatinName(){
        return this.latinName;
    }

    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }

    public boolean equals(Object other){

        Bird compared = (Bird) other;

        if(this.hashCode() == compared.hashCode() && this.getRingingYear() == compared.getRingingYear() ){
            return true;
        }else{
            return false;
        }
    }

    public int hashCode(){
        return this.latinName.hashCode();
    }
}


