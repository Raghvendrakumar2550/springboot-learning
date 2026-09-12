package in.Strikes;

import in.Strikes.Payment.PaymentService;

//@Component
public class OrderService {

    PaymentService paymentservice;

    public OrderService(PaymentService paymentservice){
        this.paymentservice = paymentservice;
    }

//    public void setPaymentserviceBean(PaymentService paymentservice) {
//        this.paymentservice = paymentservice;
//    }

    public void placeOrder(){
        paymentservice.pay();
        System.out.println("Order placed");
    }
}
