import java.util.HashMap;

public class PromissoryNote {

    private HashMap<String,Double> person;
    public PromissoryNote() {
        this.person = new HashMap<String,Double>();
    }

    public void setLoan(String toWhom, double value){
            this.person.put(toWhom,value);
    }

    public double howMuchIsTheDebt(String whose){
        if(this.person.containsKey(whose)){
            return this.person.get(whose);
        }
        return 0;
    }
}
