package guns;

import java.util.Collections;

public class Colt extends Pistol {

    private boolean collimator;

    public Colt(String serialNumber, boolean silencer, boolean collimator) {
        super(serialNumber, silencer);
        this.collimator = collimator;
    }

    @Override
    public double getCostPerShot() {
        double ret = super.getCostPerShot() + 0.2;//Dodatkowa oplata za colta
        if(collimator) {
            return ret + 0.5;
        } else {
            return ret;
        }
    }

    @Override
    public String getInfo() {
        String info = "Colt ";
        if(silencer) {
            info = info + "silencer, ";
        }
        if(collimator) {
            info = info + "collimator";
        }
        return info;
    }

}
