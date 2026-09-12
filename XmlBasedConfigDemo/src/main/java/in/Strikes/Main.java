package in.Strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppConfig.xml");

//        OrderService orderservice = (OrderService) context.getBean("orderService");
//        orderservice.placeOrder();

        UserService user = (UserService) context.getBean(UserService.class);
//        System.out.println(user.getUsername());
        context.close();
    }
}