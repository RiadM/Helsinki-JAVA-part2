package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensorList;
    private ArrayList<Integer> readings;

    public AverageSensor() {
        this.sensorList = new ArrayList();
        this.readings = new ArrayList();
    }

    public void addSensor(Sensor additional){
        this.sensorList.add(additional);
    }

    public List<Integer> readings(){
        return this.readings;
    }

    @Override
    public boolean isOn() {
        for(Sensor sensor: this.sensorList){
            if(sensor.isOn() == false){
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor: this.sensorList){
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor: this.sensorList){
            sensor.off();
        }
    }

    @Override
    public int measure() {
        int average = 0;
        if(!this.isOn() || this.sensorList.size() <= 0){
            throw new IllegalStateException();
        } else {
            for (Sensor sensor : this.sensorList) {
                average += sensor.measure();
            }
            int reading = (average / this.sensorList.size());
            this.readings.add(reading);
            return reading;
        }
    }
}
