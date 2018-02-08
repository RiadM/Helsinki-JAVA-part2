package boxes;

import java.util.ArrayList;
import java.util.List;

public class BlackHoleBox extends Box {

    private List thingIn;

    public BlackHoleBox() {
        this.thingIn = new ArrayList();
    }

    @Override
    public void add(Thing thing) {
        this.thingIn.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
}
