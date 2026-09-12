package in.Strikes.Payment;

public class CardPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Paymnet Done by Card");
    }


}
