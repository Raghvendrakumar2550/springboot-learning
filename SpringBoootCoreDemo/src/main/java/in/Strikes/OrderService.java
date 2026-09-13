package in.Strikes;

public class OrderService {

    PaymentService paymentService ;

    public OrderService(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public void placeOrder(){
        System.out.println("order placed");
    }
}
