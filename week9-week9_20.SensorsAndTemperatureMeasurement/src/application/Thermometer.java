package application;
import java.util.Random;

public class Thermometer implements Sensor{

    private boolean state;

    public Thermometer() {
       off();
    }

    @Override
    public boolean isOn() {
        if(this.state == true){
            return true;
        }
        return false;
    }

    @Override
    public void on() {
        this.state = true;
    }

    @Override
    public void off() {
        this.state = false;
    }

    @Override
    public int measure(){
        if(isOn() == true){
          Random rand = new Random();
          return rand.nextInt(60) - 30;
        } else{
            throw new IllegalStateException();
        }
    }
}
