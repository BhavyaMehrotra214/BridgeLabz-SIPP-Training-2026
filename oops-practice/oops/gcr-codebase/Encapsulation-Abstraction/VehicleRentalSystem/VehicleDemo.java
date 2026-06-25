public class VehicleDemo {
    public static void main(String[] args) {

        Car car = new Car();
        car.setVehicleNumber("CAR101");
        car.setVehicleType("Car");
        car.setDailyRate(1000);

        Bike bike = new Bike();
        bike.setVehicleNumber("BIKE101");
        bike.setVehicleType("Bike");
        bike.setDailyRate(500);

        Truck truck = new Truck();
        truck.setVehicleNumber("TRUCK101");
        truck.setVehicleType("Truck");
        truck.setDailyRate(2000);
        truck.setLoadingCharge(1000);

        int days = 5;

        car.displayVehicleInfo();
        System.out.println("Cost: " + car.calculateRentalCost(days));

        bike.displayVehicleInfo();
        System.out.println("Cost: " + bike.calculateRentalCost(days));

        truck.displayVehicleInfo();
        System.out.println("Cost: " + truck.calculateRentalCost(days));
    }
}