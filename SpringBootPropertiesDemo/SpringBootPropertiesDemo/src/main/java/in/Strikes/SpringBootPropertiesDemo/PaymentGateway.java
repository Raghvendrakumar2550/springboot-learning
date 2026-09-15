package in.Strikes.SpringBootPropertiesDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class PaymentGateway {
//    @Value("${paymentGateway.type:Razorpay}")
//    private String type;
//    @Value("${paymentGateway.retrycount}")
//    private int Retrycount;
//
//    public String getType() {
//        return type;
//    }

//    public PaymentGateway(@Value("${paymentGateway.type}") String type,
//                          @Value("${paymentGateway.retrycount}")int retrycount) {
//        this.type = type;
//        Retrycount = retrycount;
//    }


    //    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getRetrycount() {
//        return Retrycount;
//    }
//
//    public void setRetrycount(int retrycount) {
//        Retrycount = retrycount;
//    }
//
    private PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }

    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }

    public boolean isEnabled() {
        return paymentProperties.isEnabled();
    }

    public int getTimeout() {
        return paymentProperties.getTimeout();
    }

    public void print() {
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(isEnabled());
        System.out.println(getTimeout());
    }


}
