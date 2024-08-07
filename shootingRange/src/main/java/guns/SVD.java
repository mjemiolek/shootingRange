package guns;

public class SVD extends SniperRifle {

    public SVD(String serialNumber, boolean supportStand) {
        super(serialNumber, supportStand);
    }

    @Override
    public double getCostPerShot() {
        double cost = super.getCostPerShot();
        cost = cost + 1;
        return cost;
    }

    @Override
    public String getInfo() {
        String info = "SVD ";
        if(supportStand) {
            info = info + "support stand";
        }
        return info;
    }

}
