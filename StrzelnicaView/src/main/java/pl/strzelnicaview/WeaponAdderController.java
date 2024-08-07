package pl.strzelnicaview;

import guns.*;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import managers.WeaponManager;

import java.io.IOException;

public class WeaponAdderController {

    private MainScreenController mainScreenController;
    private WeaponManager weaponManager;


    @FXML
    private CheckBox AR15Check;
    @FXML
    private CheckBox BarrettCheck;
    @FXML
    private CheckBox ColtCheck;
    @FXML
    private CheckBox BerettaCheck;
    @FXML
    private CheckBox GlockCheck;
    @FXML
    private CheckBox RemingtonCheck;
    @FXML
    private CheckBox KalashnikovCheck;
    @FXML
    private CheckBox SVDCheck;
    @FXML
    private CheckBox SaigaCheck;


    @FXML
    private CheckBox AR15Silencer;
    @FXML
    private CheckBox BerettaSilencer;
    @FXML
    private CheckBox ColtSilencer;
    @FXML
    private CheckBox GlockSilencer;
    @FXML
    private CheckBox KalashnikovSilencer;
    @FXML
    private CheckBox BarrettSupportStand;
    @FXML
    private CheckBox RemingtonAmmoBelt;
    @FXML
    private CheckBox SVDSupportStand;
    @FXML
    private CheckBox SaigaAmmoBelt;
    @FXML
    private CheckBox AR15OpticalSight;
    @FXML
    private CheckBox BarrettMuzzleBreak;
    @FXML
    private CheckBox BerettaLaserSight;
    @FXML
    private CheckBox ColtColimator;
    @FXML
    private CheckBox GlockLongMagazine;
    @FXML
    private CheckBox GlockLaserSight;
    @FXML
    private CheckBox KalashnikovDrumMagazine;
    @FXML
    private CheckBox RemingtonCollimator;
    @FXML
    private CheckBox SaigaBottomHandle;

    @FXML
    private TextField SaigaSN;
    @FXML
    private TextField SVDSN;
    @FXML
    private TextField RemingtonSN;
    @FXML
    private TextField KalashnikovSN;
    @FXML
    private TextField GlockSN;
    @FXML
    private TextField ColtSN;
    @FXML
    private TextField BerettaSN;
    @FXML
    private TextField BarrettSN;
    @FXML
    private TextField AR15SN;

    @FXML
    void ExitToMenu() throws IOException {
        mainScreenController.loadMenuScreen();
    }

    @FXML
    void registerAR15() {
        if(AR15Check.isSelected()) {
            AR15 ar15 = new AR15(AR15SN.getText(), AR15Silencer.isSelected(), AR15OpticalSight.isSelected());
            weaponManager.registerNewWeapon(ar15);
        }
    }

    @FXML
    void registerBarrett() {
        if(BarrettCheck.isSelected()) {
            Barrett barrett = new Barrett(BarrettSN.getText(), BarrettSupportStand.isSelected(), BarrettMuzzleBreak.isSelected());
            weaponManager.registerNewWeapon(barrett);
        }
    }

    @FXML
    void registerBeretta() {
        if(BerettaCheck.isSelected()) {
            Beretta beretta = new Beretta(BerettaSN.getText(), BerettaSilencer.isSelected(), BerettaLaserSight.isSelected());
            weaponManager.registerNewWeapon(beretta);
        }
    }

    @FXML
    void registerColt() {
        if(ColtCheck.isSelected()) {
            Colt colt = new Colt(ColtSN.getText(), ColtSilencer.isSelected(), ColtColimator.isSelected());
            weaponManager.registerNewWeapon(colt);
        }
    }

    @FXML
    void registerGlock() {
        if(GlockCheck.isSelected()) {
            Glock glock = new Glock(GlockSN.getText(), GlockSilencer.isSelected(), GlockLongMagazine.isSelected(),
                    GlockLaserSight.isSelected());
            weaponManager.registerNewWeapon(glock);
        }
    }

    @FXML
    void registerKalashnikov() {
        if(KalashnikovCheck.isSelected()) {
            Kalashnikov kalashnikov = new Kalashnikov(KalashnikovSN.getText(), KalashnikovSilencer.isSelected(),
                    KalashnikovDrumMagazine.isSelected());
            weaponManager.registerNewWeapon(kalashnikov);
        }
    }

    @FXML
    void registerRemington() {
        if(RemingtonCheck.isSelected()) {
            Remington remington = new Remington(RemingtonSN.getText(), RemingtonAmmoBelt.isSelected(),
                    RemingtonCollimator.isSelected());
            weaponManager.registerNewWeapon(remington);
        }
    }

    @FXML
    void registerSVD() {
        if(SVDCheck.isSelected()) {
            SVD svd = new SVD(SVDSN.getText(), SVDSupportStand.isSelected());
            weaponManager.registerNewWeapon(svd);
        }
    }

    @FXML
    void registerSaiga() {
        if(SaigaCheck.isSelected()) {
            Saiga saiga = new Saiga(SaigaSN.getText(), SaigaAmmoBelt.isSelected(), SaigaBottomHandle.isSelected());
            weaponManager.registerNewWeapon(saiga);
        }
    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

    public void setWeaponManager(WeaponManager weaponManager) {
        this.weaponManager = weaponManager;
    }
}
