package company;

import java.util.*;

public class BuildingSystem implements IBuildingManagementSystem{

    private List<Building> buildings;

    public BuildingSystem(){
        buildings=new ArrayList<>();
    }

    public List<Building> getBuildings() {
        return buildings;
    }


    public UUID addBuilding(String name){
        Building building=new Building(name);
        buildings.add(building);
        return building.getID();
    }
    public UUID addBuilding(Building building){
        buildings.add(building);
        return building.getID();
    }

    public void removeBuilding(UUID id){
        buildings.removeIf(building -> building.getID() == id);
    }

    @Override
    public Map<UUID, String> getBuildingInformation() {
        Map<UUID, String> map = new HashMap<>();
        for ( Building building :
                buildings ) {
            map.put(building.getID(), building.getName());
        }
        return map;
    }

    @Override
    public Map<UUID, String> getSensorInformation(UUID buildingId) {
        Map<UUID, String> sensors = new HashMap<>();

        //List<Sensor> sensorsList = building.getSensors();
        for ( Sensor sensor :
                findBuilding(buildingId).getSensors() ) {

            sensors.put(sensor.getID(), sensor.getName());
        }

        return sensors;
    }

    @Override
    public Map<UUID, String> getActuatorInformation(UUID buildingId) {
        Map<UUID, String> actuators = new HashMap<>();

        //List<Sensor> sensorsList = building.getSensors();
        for ( Actuator actuator :
                findBuilding(buildingId).getActuators() ) {

            actuators.put(actuator.getID(), actuator.getName());
        }

        return actuators;
    }

    @Override
    public UUID addTemperatureSensor(UUID buildingId, String name) {

        return findBuilding(buildingId).addTemperatureSensor(name);
    }

    @Override
    public UUID addCo2Sensor(UUID buildingId, String name) {

    return findBuilding(buildingId).addCo2Sensor(name);

    }

    @Override
    public void removeSensor(UUID buildingId, UUID sensorId) {
        findBuilding(buildingId).removeSensor(sensorId);
    }

    @Override
    public UUID addVentilationActuator(UUID buildingId, String name) {
        return findBuilding(buildingId).addVentActuator(name);
    }

    @Override
    public void removeActuator(UUID buildingId, UUID actuatorId) {
        findBuilding(buildingId).removeActuator(actuatorId);
    }

    public Building findBuilding(UUID buildingId){
        for ( Building building :
                buildings ) {
            if (building.getID() == buildingId) {
                return building;
            }
        }
        return null;
    }

    public double getSensorValue(UUID buildingID, UUID sensorID){
        Building building = findBuilding(buildingID);
        return building.getSensorFromID(sensorID).getValue();
    }

    public void setSensorValue(UUID buildingID, UUID sensorID, double value){
        Building building = findBuilding(buildingID);
        building.getSensorFromID(sensorID).setValue(value);
    }
}
