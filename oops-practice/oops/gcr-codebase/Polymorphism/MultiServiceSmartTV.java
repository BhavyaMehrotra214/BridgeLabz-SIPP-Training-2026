/* 3. Multi-Service Smart TV
A Smart TV can stream movies and play games.
● Create interfaces StreamingService and GamingService.
● Both interfaces should have:
○ one abstract method
○ one default method showSubscriptionDetails()
● Create a class SmartTV implementing both interfaces.
● Store movie names and game names in separate arrays.
Task: Resolve the default method conflict and display all available content.
 */

interface StreamingService {
  void playMovies();

  default void showSubscriptionDetails() {
    System.out.println("Premium");
  }
}

interface GamingService {
  void playGames();

  default void showSubscriptionDetails() {
    System.out.println("Gold");
  }
}

class SmartTV implements StreamingService, GamingService {

  @Override
  public void playMovies() {
    System.out.println("Playing movie...");
  }

  @Override
  public void playGames() {
    System.out.println("Playing game...");
  }

  @Override
  public void showSubscriptionDetails() {
    StreamingService.super.showSubscriptionDetails();
    GamingService.super.showSubscriptionDetails();
  }
}
public class MultiServiceSmartTV{
  public static void main(String[] args) {
      String[] movies = {"Avengers", "Interstellar", "Frozen"};
        String[] games = {"Minecraft", "FIFA", "GTA V"};

        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();


        
         System.out.println("\nMovies:");
        for (String movie : movies) {
            System.out.println(movie);
        }

        System.out.println("\nGames:");
        for (String game : games) {
            System.out.println(game);
        }
    }
}
 