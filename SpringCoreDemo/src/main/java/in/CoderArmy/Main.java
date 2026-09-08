package in.CoderArmy;

import in.Stiker.CartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

//        PaymentService payment = context.getBean(PaymentService.class);
//        payment.pay();
        CartService cs = new CartService();
        cs.addToCart();

        User user = context.getBean(User.class);
        System.out.println(user.getName());

        CartService cartservice = context.getBean(CartService.class);
        cartservice.addToCart();


    }
}