public class ShapeDemo {
    public static void main(String[] args) {

        Shape[] shapes = {
                new Circle(5),
                new Rectangle(10, 4),
                new Triangle(3, 4, 5)
        };

        System.out.println("===== Shape Report =====");

        for (Shape shape : shapes) {
            System.out.println(
                    shape.getClass().getSimpleName()
                            + " Area = " + shape.area()
                            + " Perimeter = " + shape.perimeter()
            );
        }
    }
}