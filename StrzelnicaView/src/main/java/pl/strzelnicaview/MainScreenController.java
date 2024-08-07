package pl.strzelnicaview;

import guns.Beretta;
import guns.Weapon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import managers.ClientManager;
import managers.ReservationManager;
import managers.WeaponManager;
import managers.WorkerManager;

import java.io.IOException;

public class MainScreenController {

    private final ClientManager clientManager = new ClientManager();
    private final WorkerManager workerManager = new WorkerManager();
    private WeaponManager weaponManager = new WeaponManager();
    private ReservationManager reservationManager = new ReservationManager();

    @FXML
    private StackPane mainStackPane;

    @FXML
    public void initialize() throws IOException {
        clientManager.registerClient("Testowy", "Klient", "Adres");
        workerManager.registerWorker("Testowy", "Pracownik", "Adres", "PESEL", 50);
        Beretta beretta = new Beretta("Ber90123", true, true);
        weaponManager.registerNewWeapon(beretta);
        loadMenuScreen();
    }

    public void loadMenuScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuScreen.fxml"));
        VBox vBox = loader.load();
        MenuScreenController menuScreenController = loader.getController();
        menuScreenController.setMainScreenController(this);
        menuScreenController.setClientManager(clientManager);
        menuScreenController.setWorkerManager(workerManager);
        menuScreenController.setWeaponManager(weaponManager);
        menuScreenController.setReservationManager(reservationManager);

        //I chuba musi być clear najpierw
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(vBox);
        //Ustaw w sceneBuilderze stackPane
    }

    public void loadScene(Pane pane) {
        //chyba clear trzeba dodać
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }

}
