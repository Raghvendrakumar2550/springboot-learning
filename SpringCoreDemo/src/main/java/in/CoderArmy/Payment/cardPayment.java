package in.CoderArmy.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("cp")
public class cardPayment implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Payment via Card");
    }
}
