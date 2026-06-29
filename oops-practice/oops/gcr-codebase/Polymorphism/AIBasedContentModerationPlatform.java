/*
4. AI-Based Content Moderation Platform
A social media platform checks user posts for inappropriate content.
● Create interfaces:
○ TextModeration
○ SpamDetection
● Each interface contains:
○ abstract methods
○ default method displayModerationPolicy()
● Add a static method containsRestrictedWords(String
post).
Store multiple posts in a String[].
Task: Implement both interfaces in ContentModerator and identify:
● spam posts
● offensive posts
● valid posts */

interface TextModeration {

  void checkOffensive(String post);

  default void displayModerationPolicy() {
    System.out.println("No offensive language allowed.");
  }

  static boolean containsRestrictedWords(String post) {
    return post.contains("bad");
  }
}

interface SpamDetection {

  void checkSpam(String post);

  default void displayModerationPolicy() {
    System.out.println("No spam messages allowed.");
  }
}

class ContentModerator implements TextModeration, SpamDetection {

  public void checkOffensive(String post) {
    if (TextModeration.containsRestrictedWords(post)) {
      System.out.println(post + " Offensive Post");
    }
  }

  public void checkSpam(String post) {
    if (post.contains("buy now")) {
      System.out.println(post + "  Spam Post");
    }
  }

  public void displayModerationPolicy() {
    System.out.println("Follow community guidelines.");
  }
}

public class AIBasedContentModerationPlatform {
  public static void main(String[] args) {

    String[] posts = {
        "Hello everyone",
        "buy now and get 50% off",
        "You are bad",
        "Have a nice day"
    };

    ContentModerator cm = new ContentModerator();

    cm.displayModerationPolicy();
    System.out.println();

    for (String post : posts) {

      if (post.contains("buy now")) {
        cm.checkSpam(post);
      } else if (TextModeration.containsRestrictedWords(post)) {
        cm.checkOffensive(post);
      } else {
        System.out.println(post + "  Valid Post");
      }
    }
  }
}
