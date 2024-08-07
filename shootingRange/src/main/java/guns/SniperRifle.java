package guns;

public abstract class SniperRifle extends Weapon {

    private final static double shotCost = 8;
    protected boolean supportStand;

    public SniperRifle(String serialNumber, boolean supportStand) {
        super(serialNumber);
        this.supportStand = supportStand;
    }

    @Override
    public double getCostPerShot() {
        if(supportStand) {
            return shotCost + 0.5;
        } else {
            return shotCost;
        }
    }

    @Override
    public abstract String getInfo();

}
