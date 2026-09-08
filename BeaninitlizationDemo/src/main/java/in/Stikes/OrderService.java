package in.Stikes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class OrderService {
    OrderService orderservice;
    public void OrderService(){
        this.orderservice = orderservice;
    }
    public OrderService(){
        System.out.println("Orderservice created");
    }
}
