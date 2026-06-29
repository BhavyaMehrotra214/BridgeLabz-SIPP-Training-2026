interface HeartRateMonitor {

  void checkHeartRate(String name);

  default void displayHealthTips() {
    System.out.println("Exercise regularly.");
  }

  static boolean isPatientIdValid(String id) {
    return id.length() == 5;
  }
}

interface TemperatureMonitor {

  void checkTemperature(String name);

  default void displayHealthTips() {
    System.out.println("Drink plenty of water.");
  }
}

class HealthMonitoringSystemImpl
    implements HeartRateMonitor, TemperatureMonitor {

  public void checkHeartRate(String name) {
    System.out.println(name + " Heart Rate: 72 BPM");
  }

  public void checkTemperature(String name) {
    System.out.println(name + " Temperature: 98.6 F");
  }

  // Resolve conflict
  public void displayHealthTips() {
    System.out.println("Eat healthy and stay active.");
  }
}

public class HealthMonitoringSystem {
  public static void main(String[] args) {

    String[] names = { "Aman", "Riya", "Neha" };
    String[] ids = { "P1001", "AB12", "P1003" };

    HealthMonitoringSystemImpl h = new HealthMonitoringSystemImpl();

    h.displayHealthTips();
    System.out.println();

    for (int i = 0; i < names.length; i++) {

      System.out.println("Patient: " + names[i]);

      if (HeartRateMonitor.isPatientIdValid(ids[i])) {

        System.out.println("Valid ID");
        h.checkHeartRate(names[i]);
        h.checkTemperature(names[i]);

      } else {
        System.out.println("Invalid Patient ID");
      }

      System.out.println();
    }

    System.out.println("Final Health Report Generated.");
  }
}