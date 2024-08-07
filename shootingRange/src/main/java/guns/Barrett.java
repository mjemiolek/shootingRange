package guns;

public class Barrett extends SniperRifle {

    private boolean muzzleBreak;

    public Barrett(String serialNumber, boolean supportStand, boolean muzzleBreak) {
        super(serialNumber, supportStand);
        this.muzzleBreak = muzzleBreak;
    }

    @Override
    public double getCostPerShot() {
        double cost = super.getCostPerShot();
        if(muzzleBreak) {
            return cost + 1.5;
        } else {
            return cost;
        }
    }

    @Override
    public String getInfo() {
        String info = "Barrett ";
        if(supportStand) {
            info = info + "support stand, ";
        }
        if(muzzleBreak) {
            info = info + "muzzle break";
        }
        return info;
    }

}
