package application;

public class ConstantSensor implements Sensor {

    private int measured;

    public ConstantSensor(int measured) {
        on();
        this.measured = measured;
    }

    @Override
    public boolean isOn() {
            return true;
    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public int measure() {
        return this.measured;
    }
}
