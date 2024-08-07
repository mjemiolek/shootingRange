package pl.strzelnicaview;

import guns.Weapon;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import mainModule.Client;
import mainModule.GunReservation;
import mainModule.Reservation;
import mainModule.Worker;
import managers.ReservationManager;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReservationShowController {

    MainScreenController mainScreenController;
    ReservationManager reservationManager;
    Reservation currentReservation;

    @FXML
    private ChoiceBox<String> reservationChooser;

    @FXML
    private Text cost;
    @FXML
    private Text date;
    @FXML
    private Text startTime;
    @FXML
    private Text clientInfo;
    @FXML
    private Text workerInfo;
    @FXML
    private Text weaponsInfo;
    @FXML
    private Text duration;

    @FXML
    void ExitToMenu() throws IOException {
        mainScreenController.loadMenuScreen();
    }

    @FXML
    void deleteReservations() {
        reservationManager.deleteReservation(currentReservation.getId());
        clearTexts();
        updateReservationChooser();
    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

    private void updateReservationChooser() {
        List<String> identifiers = new ArrayList<>();
        for(Reservation reservation : reservationManager.getAllReservations()) {
            identifiers.add(String.valueOf(reservation.getId()));
        }
        reservationChooser.getItems().clear();
        reservationChooser.getItems().addAll(identifiers);
    }

    public void setReservationManager(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
        updateReservationChooser();
        reservationChooser.setOnAction(this::getReservation);
    }

    private void getReservation(ActionEvent event) {
        String ID = reservationChooser.getValue();
        Reservation reservation = reservationManager.findById(ID);
        if(reservation != null) {
            currentReservation = reservation;

            Client client = reservation.getClient();
            clientInfo.setText(client.getName() + " " + client.getSurname());

            Worker worker = reservation.getWorker();
            workerInfo.setText(worker.getName() + " " + worker.getSurname());

            cost.setText(String.valueOf(reservation.calcPrice()));

            LocalDateTime ldt = reservation.getStart();
            date.setText(ldt.toLocalDate().toString());

            startTime.setText(ldt.toLocalTime().toString());

            duration.setText(String.valueOf(reservation.calcDuration()) + " hours");

            String weaponsInfoString = "";
            Set<GunReservation> gunsRes = reservation.getGunReservationSet().getAllReservations();
            for(GunReservation gun : gunsRes) {
                weaponsInfoString = weaponsInfoString + gun.getWeapon().getInfo() + "\n";
            }
            weaponsInfo.setText(weaponsInfoString);
        }
    }

    private void clearTexts() {
        clientInfo.setText("");
        workerInfo.setText("");
        cost.setText("");
        date.setText("");
        startTime.setText("");
        duration.setText("");
        weaponsInfo.setText("");
    }

}
