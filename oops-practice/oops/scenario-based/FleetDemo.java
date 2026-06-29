class FleetUnit {
    protected String name;

    public FleetUnit(String name) {
        this.name = name;
    }

    public double fuelCost(double km) {
        return 0;
    }
}

class Sedan extends FleetUnit {

    public Sedan(String name) {
        super(name);
    }

    @Override
    public double fuelCost(double km) {
        return km * 8;
    }
}

class Coach extends FleetUnit {

    public Coach(String name) {
        super(name);
    }

    @Override
    public double fuelCost(double km) {
        return km * 15;
    }
}

class Scooter extends FleetUnit {

    public Scooter(String name) {
        super(name);
    }

    @Override
    public double fuelCost(double km) {
        return km * 3;
    }
}

class EVSedan extends FleetUnit {

    public EVSedan(String name) {
        super(name);
    }

    @Override
    public double fuelCost(double km) {
        return km * 2;
    }
}

public class FleetDemo {

    public static void main(String[] args) {

        FleetUnit[] fleet = {
                new Sedan("Honda City"),
                new Coach("Volvo Coach"),
                new Scooter("Activa 6G"),
                new EVSedan("BYD Seal")
        };

        double distance = 100;

        for (FleetUnit f : fleet) {

            System.out.println("\nVehicle : " + f.name);
            System.out.println("Fuel Cost = ₹" + f.fuelCost(distance));

            if (f instanceof Sedan) {
                Sedan s = (Sedan) f;
                System.out.println("Type : Sedan");
            } else if (f instanceof Coach) {
                Coach c = (Coach) f;
                System.out.println("Type : Coach");
            } else if (f instanceof Scooter) {
                Scooter sc = (Scooter) f;
                System.out.println("Type : Scooter");
            } else if (f instanceof EVSedan) {
                EVSedan ev = (EVSedan) f;
                System.out.println("Type : EV Sedan");
            }
        }
    }
}