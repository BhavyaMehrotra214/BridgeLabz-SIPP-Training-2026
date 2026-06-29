/*1.Build a fitness tracker: interfaces Trackable (logActivity()), Reportable
(generateReport()), Notifiable (sendAlert()). Class FitnessDevice
implements all three. Add a default method resetData() to Trackable.
Demonstrate multiple interface implementation Java cannot do with
classes. */


interface Trackable{
  void logActivity();
  default void resetData(){
    System.out.println("data reset");
  }

}
interface Reportable{
  void generateReport();
}

interface Notifiable{
  void sendAlert();
}
class FitnessDevice implements Trackable, Reportable,Notifiable{

  public void logActivity(){
    System.out.println("activity logged");
  }
  public void generateReport(){
    System.out.println("report generated");
  }
  public void sendAlert(){
    System.out.println("sent alert");
  }
}
public class Main {
    public static void main(String[] args) {

        FitnessDevice f = new FitnessDevice();

        f.logActivity();
        f.generateReport();
        f.sendAlert();
        f.resetData();   
    }
}