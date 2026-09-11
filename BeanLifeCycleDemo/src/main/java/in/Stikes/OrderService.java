package in.Stikes;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentservice;

    public OrderService(PaymentService paymentservice){
        this.paymentservice = paymentservice;
    }

    public void placeOrder(){
        paymentservice.pay();
        System.out.println("Order Placed");
    }
}
