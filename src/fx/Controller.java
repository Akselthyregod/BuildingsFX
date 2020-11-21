package fx;

import company.*;
import javafx.scene.control.*;

import java.util.*;

import javafx.scene.input.MouseEvent;

public class Controller {


    public Button addBuilding;
    public Button removeBuilding;
    public TextField buildingName;
    public ChoiceBox buildingDrop;
    public ListView buildingsList;
    public ListView things;
    public Button addSensor;
    public TextField sensorName;
    public ChoiceBox buildingDropSens;
    public Button buttonSens;
    public Button removeSensorButton;
    public Label valueSens;
    public Button getValue;
    public Button setValueSens;
    public TextField sensorValueInput;

    BuildingSystem bs = new BuildingSystem();

    List<Building> buildings = bs.getBuildings();

    Map<String, UUID> buildingsMap = new HashMap<>();
    Map<String, UUID> sensorsMap = new HashMap<>();


    public void mouseClicked(MouseEvent event){


        Button button = (Button) event.getSource();

        if(addBuilding.equals(button)){
            addBuilding();
            buildingName.clear();
        }else if(removeBuilding.equals(button)){
            removeBuilding();
            showSensors();
        }else if(addSensor.equals(button)){
            addSensor();
            sensorName.clear();
            showSensors();
        }else if(buttonSens.equals(button)){
            showSensors();
        }else if(removeSensorButton.equals(button)){
            removeSensor();
            showSensors();
        }else if(getValue.equals(button)){
            getValue();
        }else if(setValueSens.equals(button)){
            setValue();
            sensorValueInput.clear();
            getValue();
        }


    }

    private void getValue() {
        UUID idSens = sensorsMap.get(things.getSelectionModel().getSelectedItem());
        UUID idBuild = buildingsMap.get(buildingsList.getSelectionModel().getSelectedItem());
        valueSens.setText(" " + bs.getSensorValue(idBuild, idSens));
    }

    private void setValue() {
        UUID idSens = sensorsMap.get(things.getSelectionModel().getSelectedItem());
        UUID idBuild = buildingsMap.get(buildingsList.getSelectionModel().getSelectedItem());
        double value = Double.parseDouble(sensorValueInput.getText());
        bs.setSensorValue(idBuild, idSens, value);
    }

    private void addSensor() {

        UUID buildingID = buildingsMap.get(buildingsList.getSelectionModel().getSelectedItem());

        if(!bs.findBuilding(buildingID).getSensors().contains(sensorName.getText())){
            UUID id = bs.addCo2Sensor(buildingID, sensorName.getText());
            sensorsMap.put(sensorName.getText(), id);
        }

    }

    private void removeSensor(){

        bs.removeSensor(buildingsMap.get(buildingsList.getSelectionModel().getSelectedItem()), sensorsMap.get(things.getSelectionModel().getSelectedItem()));

    }

    private void showSensors(){
        things.getItems().clear();
        if(!buildingsList.getSelectionModel().isEmpty()){

            UUID id = buildingsMap.get(buildingsList.getSelectionModel().getSelectedItem());

            List<Sensor> sensors = bs.findBuilding(id).getSensors();
            for ( Sensor sensor:
                    sensors ) {
                things.getItems().add(sensor.getName());
            }
        }
    }


    private void removeBuilding() {
        Object value = buildingsList.getSelectionModel().getSelectedItem();
        bs.removeBuilding(buildingsMap.get(value));
        buildingsMap.remove(value);
        buildingsList.getItems().remove(value);
    }

    private void addBuilding() {
        if(!buildingsMap.containsKey(buildingName.getText())) {
            UUID id = bs.addBuilding(buildingName.getText());
            buildingsMap.put(buildingName.getText(), id);

            //buildingDrop.getItems().add(buildingName.getText());
            //buildingDropSens.getItems().add(buildingName.getText());

            buildingsList.getItems().add(buildingName.getText());
        }
    }




}
