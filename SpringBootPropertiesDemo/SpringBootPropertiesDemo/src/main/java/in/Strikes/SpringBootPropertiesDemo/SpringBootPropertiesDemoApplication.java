package in.Strikes.SpringBootPropertiesDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootPropertiesDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootPropertiesDemoApplication.class, args);

//		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
//		paymentGateway.setType("Paytm");
//		paymentGateway.setRetrycount(5);
//		paymentGateway.print();



	}

}
