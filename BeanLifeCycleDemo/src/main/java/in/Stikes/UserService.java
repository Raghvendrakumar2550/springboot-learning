package in.Stikes;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component("UserBean")
public class UserService implements BeanNameAware, ApplicationContextAware {

    public UserService(){
        System.out.println("UserService constructor is called");
    }
    @Override
    public void setBeanName(String name){
        System.out.println("Bean Name is:" + name);
    }

    public String getBean(){
        return "UserBean5";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext name is:" +applicationContext);
    }
}
