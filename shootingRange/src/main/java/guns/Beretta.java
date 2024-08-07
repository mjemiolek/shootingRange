package guns;

public class Beretta extends Pistol {

    private boolean laserSight;

    public Beretta(String serialNumber, boolean silencer, boolean laserSight) {
        super(serialNumber, silencer);
        this.laserSight = laserSight;
    }

    @Override
    public double getCostPerShot() {
        double ret = super.getCostPerShot();
        if(laserSight) {
            return ret + 0.5;
        } else {
            return ret;
        }
    }

    @Override
    public String getInfo() {
        String info = "Beretta ";
        if(silencer) {
            info = info + "silencer, ";
        }
        if(laserSight) {
            info = info + "optical sight";
        }
        return info;
    }

}
