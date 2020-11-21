package company;

import java.util.Date;

public class TemperatureSensor extends Sensor {




    public TemperatureSensor(String name, double value) {
        super(name, value);
    }


    @Override
    public String toString() {
        return "Time: " + new Date() + " name: "+this.getName()+" id: "+this.getID()+" value: "+getValue();
    }
}
