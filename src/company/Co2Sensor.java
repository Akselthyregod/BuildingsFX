package company;

import java.util.Date;

public class Co2Sensor extends Sensor {


    public Co2Sensor(String name,double value){
        super(name,value);
    }


    @Override
    public String toString() {
        return "Time: " + new Date() + " name: "+this.getName()+" id: "+this.getID()+" value: "+getValue();
    }


}
