package pl.strzelnicaview;

import guns.Weapon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

import mainModule.Client;
import mainModule.GunReservation;
import mainModule.GunReservationSet;
import mainModule.Worker;
import managers.ClientManager;
import managers.ReservationManager;
import managers.WeaponManager;
import managers.WorkerManager;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReservationAdderController {

    MainScreenController mainScreenController;
    private ClientManager clientManager;
    private WorkerManager workerManager;
    private WeaponManager weaponManager;
    private ReservationManager reservationManager;
    private Client currentClient;
    private Worker currentWorker;
    private Weapon currentNewWeapon;
    private Weapon currentAddedWeapon;
    private GunReservation currentAddedGunReservations;
    private Set<GunReservation> chosenWeapons = new HashSet<>();


    @FXML
    private ChoiceBox<String> clientChoice;
    @FXML
    private ChoiceBox<String> workerChoice;

    @FXML
    private ChoiceBox<String> weaponChoice;
    @FXML
    private ChoiceBox<String> weaponsAdded;

    @FXML
    private Text newWeaponSerial;
    @FXML
    private Text newWeaponCost;
    @FXML
    private Text newWeaponDescription;

    @FXML
    private Text addedWeaponDescription;
    @FXML
    private Text addedWeaponCost;
    @FXML
    private Text addedWeaponShots;
    @FXML
    private Text addedWeaponCostTotal;
    @FXML
    private Text addedWeaponSerial;

    @FXML
    private TextField Year;
    @FXML
    private TextField Month;
    @FXML
    private TextField Day;
    @FXML
    private TextField Hour;
    @FXML
    private TextField Duration;

    @FXML
    private Text clientNameSurname;
    @FXML
    private Text clientAddress;
    @FXML
    private Text clientID;
    @FXML
    private Text workerNameSurname;
    @FXML
    private Text workerAddress;
    @FXML
    private Text workerID;
    @FXML
    private Text workerCostPerHour;

    @FXML
    private TextField shotsAmountChoice;

    @FXML
    private Text totalCostField;

    @FXML
    void ExitToMenu() throws IOException {
        mainScreenController.loadMenuScreen();
    }

    @FXML
    void makeReservation() {
        int year = Integer.parseInt(Year.getText());
        int month = Integer.parseInt(Month.getText());
        int day = Integer.parseInt(Day.getText());
        int hour = Integer.parseInt(Hour.getText());
        int duration = Integer.parseInt(Duration.getText());
        LocalDateTime start = LocalDateTime.of(year, month, day, hour, 0, 0);
        LocalDateTime end = start.plusHours(duration);
        GunReservationSet gunSet = new GunReservationSet();
        for(GunReservation reservation : chosenWeapons) {
            gunSet.addGunReservation(reservation);
        }
        reservationManager.addReservation(start, end, currentClient, currentWorker, gunSet);
    }

    @FXML
    void deleteWeaponChoice() {
        if(currentAddedWeapon != null) {
            GunReservation currentGunReservation = null;
            for(GunReservation gunReservation : chosenWeapons) {
                if(gunReservation.getWeapon().getSerialNumber().equals(currentAddedWeapon.getSerialNumber())) {
                    currentGunReservation = gunReservation;
                }
            }
            chosenWeapons.remove(currentGunReservation);
            addedWeaponSerial.setText("");
            addedWeaponCost.setText("");
            addedWeaponShots.setText("");
            addedWeaponCostTotal.setText("");
            addedWeaponDescription.setText("");
            updateWeaponsAdded();
            updateTotalCost();
        }
    }

    @FXML
    void addWeapon() {
        Weapon weapon = weaponManager.findBySerial(weaponChoice.getValue());
        GunReservation gunReservation = new GunReservation(weapon, Integer.parseInt(shotsAmountChoice.getText()));
        chosenWeapons.add(gunReservation);
        updateWeaponsAdded();
        updateTotalCost();
    }

    private void updateTotalCost() {
        double cost = 0;
        if(currentWorker != null) {
            cost = cost + currentWorker.getCostPerHour() * Integer.parseInt(Duration.getText());
        }
        for(GunReservation gun : chosenWeapons) {
            cost = cost + gun.getCost();
        }
        totalCostField.setText(String.valueOf(cost));
    }

    private void updateWeaponsAdded() {
        List<String> identifiers = new ArrayList<>();
        for(GunReservation gun : chosenWeapons) {
            identifiers.add(gun.getWeapon().getSerialNumber());
        }
        weaponsAdded.getItems().clear();
        weaponsAdded.getItems().addAll(identifiers);
    }

    public void chooseAddedWeapon(ActionEvent event) {
        GunReservation currentGunReservation = null;
        String serial = weaponsAdded.getValue();
        for(GunReservation gunReservation : chosenWeapons) {
            if(gunReservation.getWeapon().getSerialNumber().equals(serial)) {
                currentGunReservation = gunReservation;
            }
        }
        Weapon weapon = currentGunReservation.getWeapon();
        if(currentGunReservation != null) {
            currentAddedWeapon = weapon;
            currentAddedGunReservations = currentGunReservation;
            addedWeaponSerial.setText(weapon.getSerialNumber());
            addedWeaponCost.setText(String.valueOf(weapon.getCostPerShot()));
            addedWeaponShots.setText(String.valueOf(currentGunReservation.getShots()));
            addedWeaponCostTotal.setText(String.valueOf(currentGunReservation.getCost()));
            addedWeaponDescription.setText(String.valueOf(weapon.getInfo()));
        }
    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
        List<String> identifiers = new ArrayList<>();
        for(Client client : clientManager.findAllClients()) {
            identifiers.add(String.valueOf(client.getId()));
        }
        clientChoice.getItems().addAll(identifiers);
        clientChoice.setOnAction(this::getClient);
    }

    public void getClient(ActionEvent event) {
        String ID = clientChoice.getValue();
        Client client = clientManager.findById(ID);
        if(client != null) {
            currentClient = client;
            clientNameSurname.setText(client.getName() + " " + client.getSurname());
            clientAddress.setText(client.getAddress());
            clientID.setText(client.getId());
        }
    }

    public void setWorkerManager(WorkerManager workerManager) {
        this.workerManager = workerManager;
        List<String> identifiers = new ArrayList<>();
        for(Worker worker : workerManager.findAllWorkers()) {
            identifiers.add(String.valueOf(worker.getId()));
        }
        workerChoice.getItems().addAll(identifiers);
        workerChoice.setOnAction(this::getWorker);
    }

    public void getWorker(ActionEvent event) {
        String ID = workerChoice.getValue();
        Worker worker = workerManager.findById(ID);
        if(worker != null) {
            currentWorker = worker;
            workerNameSurname.setText(worker.getName() + " " + worker.getSurname());
            workerAddress.setText(worker.getAddress());
            workerCostPerHour.setText(String.valueOf(worker.getCostPerHour()));
            workerID.setText(worker.getId());
        }
        updateTotalCost();
    }

    public void setWeaponManager(WeaponManager weaponManager) {
        this.weaponManager = weaponManager;
        List<String> identifiers = new ArrayList<>();
        for(Weapon weapon : weaponManager.getAllWeapons()) {
            identifiers.add(String.valueOf(weapon.getSerialNumber()));
        }
        weaponChoice.getItems().addAll(identifiers);
        weaponChoice.setOnAction(this::chooseNewWeapon);
        weaponsAdded.setOnAction(this::chooseAddedWeapon);
    }

    public void chooseNewWeapon(ActionEvent event) {
        String serial = weaponChoice.getValue();
        Weapon weapon = weaponManager.findBySerial(serial);
        if(weapon != null) {
            currentNewWeapon = weapon;
            newWeaponSerial.setText(weapon.getSerialNumber());
            newWeaponCost.setText(String.valueOf(weapon.getCostPerShot()));
            newWeaponDescription.setText(String.valueOf(weapon.getInfo()));
        }
    }

    public void setReservationManager(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }
}
