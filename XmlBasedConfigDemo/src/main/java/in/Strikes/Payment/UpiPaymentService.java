package in.Strikes.Payment;

public class UpiPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Payment Done by UPI");
    }
}
