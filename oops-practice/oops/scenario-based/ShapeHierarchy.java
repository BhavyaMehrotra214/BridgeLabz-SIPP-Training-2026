abstract class Shapee {
    public abstract double area();
    public abstract double perimeter();
}

class Circlee extends Shapee {
    private final double radius;

    public Circlee(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectanglee extends Shapee {
    private double length;
    private double width;

    public Rectanglee(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

class Trianglee extends Shapee {
    private double side1;
    private double side2;
    private double side3;

    public Trianglee(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        double s = perimeter() / 2.0;
        return Math.sqrt(
                s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }
}

public class ShapeHierarchy {
    public static void main(String[] args) {

        Shapee[] shapes = new Shapee[3];

        shapes[0] = new Circlee(5);
        shapes[1] = new Rectanglee(10, 4);
        shapes[2] = new Trianglee(3, 4, 5);

        System.out.println("====================");
        System.out.println("SHAPE AREA REPORT");
        System.out.println("====================");

        System.out.printf("%-12s %-12s %-12s%n",
                "Shape", "Area", "Perimeter");

        System.out.println("----------");

        for (Shapee shape : shapes) {
            System.out.printf("%-12s %-12.2f %-12.2f%n",
                    shape.getClass().getSimpleName(),
                    shape.area(),
                    shape.perimeter());
        }
    }
}