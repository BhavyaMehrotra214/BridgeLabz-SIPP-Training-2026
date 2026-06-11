public class EarthVolume {
    public static void main(String[] args) {
        double r = 637;
        double v = (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
        double radiusmiles = r / 1.609;
        double volumemiles = (4.0 / 3.0) * Math.PI * Math.pow(radiusmiles, 3);
        System.out.println("The volume of earth in cubic kilometers is " + v +" and cubic miles is " +volumemiles);
    }
}
