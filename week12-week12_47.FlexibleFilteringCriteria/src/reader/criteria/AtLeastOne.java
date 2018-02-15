package reader.criteria;

public class AtLeastOne implements Criterion {

    private Criterion[] criteria;

    public AtLeastOne(Criterion... criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean complies(String line) {
        for(int i = 0; i < this.criteria.length; i++){
            if(this.criteria[i].complies(line)){
                return true;
            }
        }
        return false;
    }
}
