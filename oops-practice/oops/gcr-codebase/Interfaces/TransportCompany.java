class Vehicle {
    String vehicleNumber;
    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    double fuelCost(int km) {
        return 0;
    }
}

class Caar extends Vehicle {

    Caar(String vehicleNumber) {
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

class Bikke extends Vehicle {

    Bikke(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(int km) {
        return km * 3.0;
    }
}

// New class added without changing old classes
class ElectricCaar extends Vehicle {

    ElectricCaar(String vehicleNumber) {
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
                new Caar("CAR101"),
                new Bus("BUS201"),
                new Bikke("BIKE301"),
                new ElectricCaar("EV401")
        };

        int km = 50;

        for (Vehicle v : fleet) {

            System.out.println("Cost for " + v.vehicleNumber +
                    " = ₹" + v.fuelCost(km));

            if (v instanceof Caar) {
                Caar c = (Caar) v;
                System.out.println("This is a Car");
            } else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println("This is a Bus");
            } else if (v instanceof Bikke) {
                Bikke b = (Bikke) v;
                System.out.println("This is a Bike");
            } else if (v instanceof ElectricCaar) {
                ElectricCaar e = (ElectricCaar) v;
                System.out.println("This is an Electric Car");
            }

            System.out.println();
        }
    }
}