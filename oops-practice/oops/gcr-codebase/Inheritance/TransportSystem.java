interface FuelSupport {
    void refuel();
}
class BaseVehicle {

    int maxSpeed;
    String model;

    BaseVehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

class ElectricCar extends BaseVehicle {

    ElectricCar(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() {
        System.out.println(model + " is Charging...");
    }
}

class PetrolCar extends BaseVehicle implements FuelSupport {

    PetrolCar(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is Refueling...");
    }
}

public class TransportSystem {

    public static void main(String[] args) {

        ElectricCar ev = new ElectricCar(180, "Tesla");

        PetrolCar pv = new PetrolCar(220, "Honda City");

        ev.charge();
        pv.refuel();
    }
}