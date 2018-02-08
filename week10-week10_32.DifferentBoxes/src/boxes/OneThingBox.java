package boxes;

public class OneThingBox extends Box {

    private Thing[] thing;

    public OneThingBox() {
        this.thing = new Thing[1];
    }

    @Override
    public void add(Thing thing) {
        if(this.thing[0] == null){
            this.thing[0] = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        try{if(this.thing[0].equals(thing)){
            return true;
        } return false;
        } catch (Exception e){
            return false;
        }
    }
}
