public class DistributedPen {
    public static void main(String[] args) {
        int pens = 15;
        int students = 5;
        int pensperstudent = pens / students;
        int rem = pens % students;
        System.out.println("The Pen Per Student is " + pensperstudent + " and the remaining pen not distributed is " + rem);
    }
}
