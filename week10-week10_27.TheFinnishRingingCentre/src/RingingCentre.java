import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {

    private Map<Bird, List<String>> observationsList;

    public RingingCentre() {
        this.observationsList = new HashMap();
    }

    public void observe(Bird bird, String place){
        boolean birdIn = false;

        if(!this.observationsList.isEmpty()){
            for(Bird base: this.observationsList.keySet()){
                if(base.equals(bird)){
                    this.observationsList.get(base).add(place);
                    birdIn = true;
                }
            }
        }
        if(this.observationsList.isEmpty() || !birdIn){
                this.observationsList.put(bird, new ArrayList());
                this.observationsList.get(bird).add(place);
        }
    }

    //This is not the best implementation but it's working and could be optimize
    public void observations(Bird bird){
        boolean observed = false;
        for(Bird base: this.observationsList.keySet()){
            if(base.equals(bird)){
                observed = true;
                bird = base;
            }
        }
        if(observed){
            System.out.println(bird.getLatinName() + " (" + bird.getRingingYear() + ") " + "observations: " + this.observationsList.get(bird).size());
            for(String observation: this.observationsList.get(bird)){
                System.out.println(observation);
            }
        }
        else{
            System.out.println(bird.getLatinName() + " (" + bird.getRingingYear() + ") " + "observations: 0");
        }
    }
}
