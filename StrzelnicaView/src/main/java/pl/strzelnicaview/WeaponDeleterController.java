package pl.strzelnicaview;

import guns.Beretta;
import guns.Colt;
import guns.Weapon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import mainModule.Client;
import managers.WeaponManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

public class WeaponDeleterController {

    private MainScreenController mainScreenController;
    private WeaponManager weaponManager;
    private Weapon currentWeapon;

    @FXML
    private ChoiceBox<String> weaponChooser;
    @FXML
    private Text serialNumber;
    @FXML
    private Text cost;
    @FXML
    private Text description;


    @FXML
    void ExitToMenu() throws IOException {
        mainScreenController.loadMenuScreen();
    }

    @FXML
    void deleteWeapon() {
        if(currentWeapon != null) {
            weaponManager.removeBySerial(currentWeapon.getSerialNumber());
        }
        fillWeaponChooser();
        setTexts("", "", "");
    }

    private void fillWeaponChooser() {
        List<String> identifiers = new ArrayList<>();
        for(Weapon weapon : weaponManager.getAllWeapons()) {
            identifiers.add(String.valueOf(weapon.getSerialNumber()));
        }
        weaponChooser.getItems().clear();
        weaponChooser.getItems().addAll(identifiers);
    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

    public void setWeaponManager(WeaponManager weaponManager) {
        this.weaponManager = weaponManager;
        fillWeaponChooser();
        weaponChooser.setOnAction(this::getWeapon);
    }

    public void getWeapon(ActionEvent event) {
        String weaponSerial = weaponChooser.getValue();
        Weapon weapon = weaponManager.findBySerial(weaponSerial);
        if(weapon != null) {
            currentWeapon = weapon;
            setTexts(weapon.getSerialNumber(), String.valueOf(weapon.getCostPerShot()), String.valueOf(weapon.getInfo()));
        }
    }

    private void setTexts(String serialNumber, String costPerShot, String description) {
        this.serialNumber.setText(serialNumber);
        this.cost.setText(costPerShot);
        this.description.setText(description);
    }

}
