package in.Stikes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    @Autowired
    OrderService orderservice;
//    public PaymentService(OrderService orderservice){
//        this.orderservice = orderservice;
//    }
    public void pay(){
        System.out.println("Payment Done");
//        orderservice.getOrderDetails();
    }

}
