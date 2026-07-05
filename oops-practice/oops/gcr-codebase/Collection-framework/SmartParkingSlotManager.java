import java.util.*;

public class SmartParkingSlotManager {

    static ArrayList<String> vehicles = new ArrayList<>();

    public static void addVehicle(String regNo) {
        vehicles.add(regNo);
        System.out.println("Vehicle Entered: " + regNo);
    }

    public static void removeVehicle(String regNo) {
        if (vehicles.remove(regNo))
            System.out.println("Vehicle Exited: " + regNo);
        else
            System.out.println("Vehicle Not Found");
    }

    public static void searchVehicle(String regNo) {
        if (vehicles.contains(regNo))
            System.out.println("Vehicle Present");
        else
            System.out.println("Vehicle Not Present");
    }

    public static void displayVehicles() {
        System.out.println("\nParked Vehicles:");
        for (String v : vehicles)
            System.out.println(v);

        System.out.println("Occupied Slots: " + vehicles.size());
    }

    public static void main(String[] args) {
        addVehicle("UP81AB1234");
        addVehicle("UP81CD5678");

        searchVehicle("UP81AB1234");
        removeVehicle("UP81CD5678");

        displayVehicles();
    }
}