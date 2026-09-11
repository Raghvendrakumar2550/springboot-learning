package in.Stikes;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
@Scope("prototype")
public class CartService implements BeanNameAware, ApplicationContextAware
        /*implements InitializingBean,DisposableBean */ {

    Map<Integer,String> mp ;


    public CartService(){
        mp=new HashMap<>();
        System.out.println("CartService constructor is called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is:"+ name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext name is:" +applicationContext );
    }

    //@PostConstruct
//    public void Start2(){
//        System.out.println("Intilizating Bean is ready");
//        mp.put(1,"Raghvendra Kumar");
//        mp.put(2,"Mithila Bihari");
//    }

    public void addTTCart(){
        System.out.println("Cart is added");
    }

    public String getValues(int key){
        return mp.get(key);
    }

//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("Bean is getting destroyed");
//    }

    //    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Intilizating Bean is ready");
//        mp.put(1,"Raghvendra Kumar");
//        mp.put(2,"Mithila Bihari");
//    }

//    public void Start(){
//        System.out.println("Intilizating Bean is ready");
//        mp.put(1,"Raghvendra Kumar");
//        mp.put(2,"Mithila Bihari");
//    }
//
    @PreDestroy
    public void Stop(){
        mp.clear();
        System.out.println("Bean is getting destroyed");
    }


}
