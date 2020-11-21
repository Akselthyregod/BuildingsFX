package company;

import java.io.FileNotFoundException;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        BuildingSystem bs = new BuildingSystem();

        UUID school = bs.addBuilding("school");
        UUID store = bs.addBuilding("Store");


        Building libraryBuilding = new Building("library");

        UUID westDoor = libraryBuilding.addCo2Sensor("West Door");
        UUID actuator = libraryBuilding.addVentActuator("actuator");

        libraryBuilding.getActuatorFromID(actuator).setValue(69);
        libraryBuilding.getSensorFromID(westDoor).setValue(10);

        for ( int i = 0; i < 10; i++ ) {
            libraryBuilding.getActuatorFromID(actuator).saveValue();
            libraryBuilding.getSensorFromID(westDoor).saveValue();
            Thread.sleep(1000);
        }





        UUID bLibrary = bs.addBuilding(libraryBuilding);



    }
}
