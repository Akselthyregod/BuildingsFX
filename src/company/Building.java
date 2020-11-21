package company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Building extends Unit {

    private List<Sensor> sensors;
    private List<Actuator>actuators;

    public Building(String name) {
        super(name);
        sensors = new ArrayList<>();
        actuators = new ArrayList<>();
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public List<Actuator> getActuators() {
        return actuators;
    }

    public UUID addTemperatureSensor(String name){
        TemperatureSensor temperatureSensor= new TemperatureSensor(name,0);
        sensors.add(temperatureSensor);
        return temperatureSensor.getID();
    }
    public UUID addCo2Sensor(String name){
        Co2Sensor co2Sensor= new Co2Sensor(name,0);
        sensors.add(co2Sensor);
        return co2Sensor.getID();
    }

    public void removeSensor(UUID id){
        sensors.removeIf(sensor -> sensor.getID() == id);
    }

    public UUID addVentActuator(String name){
        VentilationActuator ventilationActuator= new VentilationActuator(name,0);
        actuators.add(ventilationActuator);
        return ventilationActuator.getID();
    }
    public void removeActuator(UUID id){
        actuators.removeIf(actuator -> actuator.getID() == id);
    }

    public Sensor getSensorFromID(UUID id){
        for ( Sensor sensor :
                sensors ) {
            if(sensor.getID() == id){
                return sensor;
            }
        }
        return null;
    }
    public Actuator getActuatorFromID(UUID id){
        for ( Actuator actuator :
                actuators ) {
            if(actuator.getID() == id){
                return actuator;
            }
        }
        return null;
    }

}
