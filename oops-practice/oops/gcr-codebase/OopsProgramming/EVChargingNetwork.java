class ChargingStation {

    static int totalStations = 0;
    static double electricityRate = 8.5;

    private String stationId;
    private double unitsConsumed;

    public ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    public double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    public void displayStationDetails() {
        System.out.println("Station ID      : " + stationId);
        System.out.println("Units Consumed  : " + unitsConsumed);
        System.out.println("Electricity Rate: ₹" + electricityRate);
        System.out.println("Bill Amount     : ₹" + calculateBill());
        System.out.println("-------------------------------");
    }
}

public class EVChargingNetwork {
    public static void main(String[] args) {

        ChargingStation s1 = new ChargingStation("CS101", 120);
        ChargingStation s2 = new ChargingStation("CS102", 150);
        ChargingStation s3 = new ChargingStation("CS103", 200);
        ChargingStation s4 = new ChargingStation("CS104", 175);
        ChargingStation s5 = new ChargingStation("CS105", 90);

        System.out.println("=== Initial Bills ===");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("Total Stations = "
                + ChargingStation.totalStations);

        ChargingStation.electricityRate = 10.0;

        System.out.println("\n== After Rate Change ==");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();
    }
}