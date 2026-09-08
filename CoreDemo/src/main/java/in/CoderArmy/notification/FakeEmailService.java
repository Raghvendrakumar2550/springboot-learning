package in.CoderArmy.notification;

public class FakeEmailService implements NotificationService{
    public void sendNotification(){
        System.out.println("Fake EmailNotification Sent");
    }
}
