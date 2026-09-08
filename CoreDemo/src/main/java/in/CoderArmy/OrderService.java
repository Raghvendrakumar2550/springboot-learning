package in.CoderArmy;

import in.CoderArmy.notification.EmailService;
import in.CoderArmy.notification.NotificationService;
import in.CoderArmy.notification.PopUpNotificationService;
import in.CoderArmy.notification.SmsService;

public class OrderService {
    NotificationService notification;
    public OrderService(NotificationService notification){
        this.notification=notification;
    }
    public OrderService(){

    }
    public void placeOrder(){

        System.out.println("Order placed");
//        Actual Buisness logic
        notification.sendNotification();
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
}

