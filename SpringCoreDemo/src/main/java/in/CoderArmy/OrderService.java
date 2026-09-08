package in.CoderArmy;


import in.CoderArmy.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService{

//    @Autowired  --> FiledInjuction Method

    private  PaymentService paymentService;

//    --> Constructor Method
//    @Autowired
    public OrderService(PaymentService paymentService){
        this.paymentService=paymentService;
    }
//    Setters Method
//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
