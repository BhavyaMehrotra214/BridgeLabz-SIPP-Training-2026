public class UnitConverter2 {
    static double convertYardsToFeet(double yards) {
        return yards * 3;
    }
    static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }

    static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }

    static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }
    static double convertInchesToCm(double inches) {
        return inches * 2.54;
    }

    public static void main(String[] args) {

        System.out.println(convertYardsToFeet(5));
        System.out.println(convertFeetToYards(12));
        System.out.println(convertMetersToInches(2));
        System.out.println(convertInchesToMeters(20));
        System.out.println(convertInchesToCm(10));
    }
}