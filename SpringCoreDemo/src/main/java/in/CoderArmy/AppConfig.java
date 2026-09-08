package in.CoderArmy;

import in.CoderArmy.Payment.PaymentService;
import in.CoderArmy.Payment.cardPayment;
import in.CoderArmy.Payment.upiPayment;
import in.Stiker.CartService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("in.CoderArmy")
public class AppConfig {
    @Bean
    public User createUser(){
        return new User("Mithila",20);
    }

    @Bean
    public CartService cartService(){
        return new CartService();
    }

    @Bean
    @Qualifier("cp")
    public PaymentService createpaymentService(){
        return new cardPayment();
    }

    @Bean
    @Qualifier("UPI")
    public PaymentService createupipayment(){
        return new upiPayment();
    }


    @Bean
    public OrderService orderService(@Qualifier("cp") PaymentService paymentService){
//        PaymentService paymentservice = createpaymentService();
//        OrderService order = new OrderService();
//        order.setPaymentService(paymentservice);
//        return order;
        return new OrderService(paymentService);
    }
}
