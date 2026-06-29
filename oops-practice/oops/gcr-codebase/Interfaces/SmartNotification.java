class Notification {

  String recipientName;
  String message;

  Notification(String recipientName, String message) {
    this.recipientName = recipientName;
    this.message = message;
  }

  void sendNotification() {
    System.out.println("Sending notification...");
  }
}

class EmailNotification extends Notification {

  EmailNotification(String recipientName, String message) {
    super(recipientName, message);
  }

  @Override
  void sendNotification() {
    System.out.println(
        "Email sent to " + recipientName +
            ": " + message);
  }
}

class SMSNotification extends Notification {

  SMSNotification(String recipientName, String message) {
    super(recipientName, message);
  }

  @Override
  void sendNotification() {
    System.out.println(
        "SMS sent to " + recipientName +
            ": " + message);
  }
}

class PushNotification extends Notification {

  PushNotification(String recipientName, String message) {
    super(recipientName, message);
  }

  @Override
  void sendNotification() {
    System.out.println(
        "Push Notification sent to " + recipientName +
            ": " + message);
  }
}

class SmartNotificationSystem {

  public static void main(String[] args) {

    Notification[] notifications = {
        new EmailNotification("Mahak", "Welcome to our platform!"),
        new SMSNotification("Aman", "Your OTP is 5678"),
        new PushNotification("Riya", "New offer available!")
    };

    System.out.println("Sent Notifications:\n");

    for (Notification n : notifications) {
      n.sendNotification(); // Dynamic Method Dispatch
    }
  }
}