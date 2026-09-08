package in.Stikes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    PaymentService paymentservice;

//    public OrderService(PaymentService paymentservice){
//        this.paymentservice = paymentservice;
//    }

    public void placeOrder(){
        paymentservice.pay();
        getOrderDetails();
        System.out.println(("Order Place"));
    }

    public void getOrderDetails(){
        System.out.println("Order Details sended");
    }
}
