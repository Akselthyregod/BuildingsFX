package company;

import dataAccess.Save;

import java.io.FileNotFoundException;

public abstract class Actuator extends Unit {
    private double value;

    public Actuator(String name,double value) {
        super(name);
        this.value=value;
    }

    public void setValue(double value){
        this.value=value;
    }

    public double getValue() {
        return value;
    }

    public void saveValue() throws FileNotFoundException {
        Save.save(this.getID(), this.toString());
    }
}
