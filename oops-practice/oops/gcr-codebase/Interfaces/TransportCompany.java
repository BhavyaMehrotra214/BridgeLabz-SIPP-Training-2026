class Vehicle {

    String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    double fuelCost(int km) {
        return 0;
    }
}

class Car extends Vehicle {

    Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(int km) {
        return km * 8.0;
    }
}

class Bus extends Vehicle {

    Bus(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(int km) {
        return km * 15.0;
    }
}

class Bike extends Vehicle {

    Bike(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(int km) {
        return km * 3.0;
    }
}

// New class added without changing old classes
class ElectricCar extends Vehicle {

    ElectricCar(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(int km) {
        return km * 2.0;
    }
}

public class TransportCompany {

    public static void main(String[] args) {

        Vehicle[] fleet = {
                new Car("CAR101"),
                new Bus("BUS201"),
                new Bike("BIKE301"),
                new ElectricCar("EV401")
        };

        int km = 50;

        for (Vehicle v : fleet) {

            System.out.println("Cost for " + v.vehicleNumber +
                    " = ₹" + v.fuelCost(km));

            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println("This is a Car");
            } else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println("This is a Bus");
            } else if (v instanceof Bike) {
                Bike b = (Bike) v;
                System.out.println("This is a Bike");
            } else if (v instanceof ElectricCar) {
                ElectricCar e = (ElectricCar) v;
                System.out.println("This is an Electric Car");
            }

            System.out.println();
        }
    }
}