class Drone {

    private String droneId;
    private int batteryPercentage;

    static String companyName = "Sky Logistics";

    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    public void startDelivery() {
        if (batteryPercentage >= 20) {
            System.out.println(droneId + " started delivery.");
            batteryPercentage -= 20;
        } else {
            System.out.println(droneId +
                    " cannot start delivery. Low battery!");
        }
    }
    public void displayStatus() {
        System.out.println("Company Name : " + companyName);
        System.out.println("Drone ID : " + droneId);
        System.out.println("Battery Percentage: " + batteryPercentage + "%");
        System.out.println("---------");
    }
}
public class DroneDelivery {

    public static void main(String[] args) {

        Drone d1 = new Drone("DR101", 80);
        Drone d2 = new Drone("DR102", 50);
        Drone d3 = new Drone("DR103", 15);

        // Display Initial Status
        System.out.println("Initial Status:");
        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        System.out.println("\nStatus After Delivery Attempt:");
        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();

        System.out.println("Company Name from Drone 1: "
                + Drone.companyName);
        System.out.println("Company Name from Drone 2: "
                + Drone.companyName);
        System.out.println("Company Name from Drone 3: "
                + Drone.companyName);
    }
}