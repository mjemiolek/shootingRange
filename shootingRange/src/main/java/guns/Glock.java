package guns;

public class Glock extends Pistol {

    private boolean longMagazine;
    private boolean laserSight;

    public Glock(String serialNumber, boolean silencer, boolean longMagazine, boolean laserSight) {
        super(serialNumber, silencer);
        this.longMagazine = longMagazine;
        this.laserSight = laserSight;
    }

    @Override
    public double getCostPerShot() {
        double ret = super.getCostPerShot();
        if(longMagazine && laserSight) {
            return ret + 1.0;
        } else if(longMagazine || laserSight) {
            return ret + 0.5;
        } else {
            return ret;
        }
    }

    @Override
    public String getInfo() {
        String info = "Glock ";
        if(silencer) {
            info = info + "silencer, ";
        }
        if(longMagazine) {
            info = info + "long magazine, ";
        }
        if(laserSight) {
            info = info + "laser sight";
        }
        return info;
    }

}
