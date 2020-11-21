package company;

import java.util.Date;
import java.util.UUID;

public abstract class Unit {
    private String name;
    private UUID id;

    public Unit(String name){
        this.name=name;
        id=UUID.randomUUID();
    }
    public UUID getID(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Time: "+ new Date() + " Name: "+getName()+" Id: "+getID();
    }
}
