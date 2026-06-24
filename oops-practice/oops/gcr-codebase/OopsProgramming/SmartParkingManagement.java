class Vehicle {
    private String vehicleNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String vehicleNumber,
                   String ownerName,
                   String vehicleType) {

        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }
    public void displayDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Owner Name     : " + ownerName);
        System.out.println("Vehicle Type   : " + vehicleType);
        System.out.println("----");
    }
}

public class SmartParkingManagement {

    public static void displayCars(Vehicle[] vehicles) {

        System.out.println("\n=== Cars ===");

        for (Vehicle v : vehicles) {
            if (v.getVehicleType().equalsIgnoreCase("Car")) {
                v.displayDetails();
            }
        }
    }

    public static void displayBikes(Vehicle[] vehicles) {

        System.out.println("\nBikes");

        for (Vehicle v : vehicles) {
            if (v.getVehicleType().equalsIgnoreCase("Bike")) {
                v.displayDetails();
            }
        }
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[10];

        vehicles[0] = new Vehicle("UP81AB101", "Rahul", "Car");
        vehicles[1] = new Vehicle("UP81AB102", "Priya", "Bike");
        vehicles[2] = new Vehicle("UP81AB103", "Aman", "Car");
        vehicles[3] = new Vehicle("UP81AB104", "Neha", "Bike");
        vehicles[4] = new Vehicle("UP81AB105", "Rohit", "Car");
        vehicles[5] = new Vehicle("UP81AB106", "Simran", "Bike");
        vehicles[6] = new Vehicle("UP81AB107", "Arjun", "Car");
        vehicles[7] = new Vehicle("UP81AB108", "Karan", "Bike");
        vehicles[8] = new Vehicle("UP81AB109", "Pooja", "Car");
        vehicles[9] = new Vehicle("UP81AB110", "Ankit", "Bike");
        displayCars(vehicles);
        displayBikes(vehicles);
    }
}