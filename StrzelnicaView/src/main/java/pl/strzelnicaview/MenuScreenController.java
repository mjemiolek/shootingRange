package pl.strzelnicaview;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import managers.ClientManager;
import managers.ReservationManager;
import managers.WeaponManager;
import managers.WorkerManager;

public class MenuScreenController {

    private ClientManager clientManager;
    private WorkerManager workerManager;
    private WeaponManager weaponManager;
    private ReservationManager reservationManager;

    private MainScreenController mainScreenController;

    @FXML
    public void initialize() {

    }

    @FXML
    void Exit() {
        Platform.exit();
    }

    @FXML
    private void GoToAddReservation() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("ReservationAdder.fxml"));
        Pane pane = loader.load();
        ReservationAdderController reservationAdderController = loader.getController();
        reservationAdderController.setClientManager(clientManager);
        reservationAdderController.setWorkerManager(workerManager);
        reservationAdderController.setWeaponManager(weaponManager);
        reservationAdderController.setReservationManager(reservationManager);
        reservationAdderController.setMainScreenController(mainScreenController);
        mainScreenController.loadScene(pane);
    }

    
    @FXML
    private void GoToShowReservation() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("ReservationShow.fxml"));
        Pane pane = loader.load();
        ReservationShowController reservationShowController = loader.getController();
        reservationShowController.setReservationManager(reservationManager);
        reservationShowController.setMainScreenController(mainScreenController);
        mainScreenController.loadScene(pane);
    }

    @FXML
    void GoToWeaponMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("WeaponAdder.fxml"));
        Pane pane = loader.load();
        WeaponAdderController weaponMenuController = loader.getController();
        weaponMenuController.setMainScreenController(mainScreenController);
        weaponMenuController.setWeaponManager(weaponManager);
        mainScreenController.loadScene(pane);
    }

    @FXML
    void GoToWeaponShow() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("WeaponDeleter.fxml"));
        Pane pane = loader.load();
        WeaponDeleterController weaponDeleterController = loader.getController();
        weaponDeleterController.setMainScreenController(mainScreenController);
        weaponDeleterController.setWeaponManager(weaponManager);
        mainScreenController.loadScene(pane);
    }
    
    @FXML
    private void GoToClientMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("ClientMenu.fxml"));
        Pane pane = loader.load();
        ClientMenuController clientMenuController = loader.getController();
        clientMenuController.setMainScreenController(mainScreenController);
        clientMenuController.setClientManager(clientManager);
        mainScreenController.loadScene(pane);
    }
    
    @FXML
    private void GoToWorkerMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("WorkerMenu.fxml"));
        Pane pane = loader.load();
        WorkerMenuController workerMenuController = loader.getController();
        workerMenuController.setMainScreenController(mainScreenController);
        workerMenuController.setWorkerManager(workerManager);
        mainScreenController.loadScene(pane);
    }
    
//    @FXML
//    private void GoToPrimary() throws IOException {
//        App.setRoot("primary");
//    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public void setWorkerManager(WorkerManager workerManager) {
        this.workerManager = workerManager;
    }

    public void setWeaponManager(WeaponManager weaponManager) {
        this.weaponManager = weaponManager;
    }

    public void setReservationManager(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }
}
