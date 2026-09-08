package in.CoderArmy.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("up")
public class upiPayment implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Payment via UPI");
    }
}
