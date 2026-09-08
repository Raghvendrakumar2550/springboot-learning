package in.Stikes;

import com.sun.security.jgss.GSSUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component

@Scope("prototype")
public class OrderService {
    public OrderService(){
        System.out.println("Order service created");
    }

    public void placeorder(){
        System.out.println("Order placed");
    }
}
