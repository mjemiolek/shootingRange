package guns;

public class Kalashnikov extends AssaultRifle {

    private boolean drumMagazine;

    public Kalashnikov(String serialNumber, boolean silencer, boolean drumMagazine) {
        super(serialNumber, silencer);
        this.drumMagazine = drumMagazine;
    }

    @Override
    public double getCostPerShot() {
        double cost = super.getCostPerShot();
        if(drumMagazine) {
            return cost + 0.5;
        } else {
            return cost;
        }
    }

    @Override
    public String getInfo() {
        String info = "Kalashnikov ";
        if(silencer) {
            info = info + "silencer, ";
        }
        if(drumMagazine) {
            info = info + "drum magazine";
        }
        return info;
    }

}
