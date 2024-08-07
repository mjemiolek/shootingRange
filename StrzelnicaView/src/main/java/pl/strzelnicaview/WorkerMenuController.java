package pl.strzelnicaview;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.ChoiceBox;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;

import mainModule.Worker;
import managers.WorkerManager;

public class WorkerMenuController {

    private MainScreenController mainScreenController;
    private WorkerManager workerManager;
    private Worker currentWorker;

    @FXML
    private TextField newName;
    @FXML
    private TextField newSurname;
    @FXML
    private TextField newAddress;
    @FXML
    private ChoiceBox<String> workerChooser;
    @FXML
    private Text IDText;
    @FXML
    private Text nameText;
    @FXML
    private Text surnameText;
    @FXML
    private Text addressText;
    @FXML
    private TextField newPesel;
    @FXML
    private TextField newCost;
    @FXML
    private Text peselText;
    @FXML
    private Text costText;

    @FXML
    void ExitToMenu() throws IOException {
        mainScreenController.loadMenuScreen();
    }

    @FXML
    void addNewWorker() {
        String name, surname, address, pesel, costPerHour;
        name = newName.getText();
        surname = newSurname.getText();
        address = newAddress.getText();
        pesel = newPesel.getText();
        costPerHour = newCost.getText();
        if( (name != null) && (surname != null) && (address != null) && (pesel != null) && (costPerHour != null) ) {
            workerManager.registerWorker(name, surname, address, pesel, Double.parseDouble(costPerHour));
        }
        fillWorkerChooser();
    }

    @FXML
    void deleteWorker() {
        if(currentWorker != null) {
            workerManager.unregisterWorker(currentWorker.getId());
        }
        setTexts("", "", "", "", "", "");
        fillWorkerChooser();
    }

    private void fillWorkerChooser() {
        List<String> identifiers = new ArrayList<>();
        for(Worker worker : workerManager.findAllWorkers()) {
            identifiers.add(String.valueOf(worker.getId()));
        }
        workerChooser.getItems().clear();
        workerChooser.getItems().addAll(identifiers);
    }

    private void setTexts(String ID, String name, String Surname, String Address, String pesel, String costPerHour) {
        IDText.setText(ID);
        nameText.setText(name);
        surnameText.setText(Surname);
        addressText.setText(Address);
        peselText.setText(pesel);
        costText.setText(costPerHour);
    }

    public void setWorkerManager(WorkerManager workerManager) {
        this.workerManager = workerManager;
        fillWorkerChooser();
        workerChooser.setOnAction(this::getWorker);
    }

    public void getWorker(ActionEvent event) {
        String workerID = workerChooser.getValue();
        Worker worker = workerManager.findById(workerID);
        if(worker != null) {
            currentWorker = worker;
            setTexts(worker.getId(), worker.getName(), worker.getSurname(), worker.getAddress(),
                    worker.getPeselNumber(), String.valueOf(worker.getCostPerHour()));
        }
    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

}
