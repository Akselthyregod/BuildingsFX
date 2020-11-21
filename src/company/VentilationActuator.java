package company;

import java.util.Date;

public class VentilationActuator extends Actuator {

    public VentilationActuator(String name, double value) {
        super(name, value);
    }

    @Override
    public String toString() {
        return "Time: " + new Date() + " name: "+this.getName()+" id: "+this.getID()+" value: "+getValue();
    }
}
