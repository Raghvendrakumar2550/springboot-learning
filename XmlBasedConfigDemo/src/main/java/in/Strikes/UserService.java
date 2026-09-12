package in.Strikes;

import java.util.List;

public class UserService {
//    private List<String> usernames;
//
//    public UserService(List<String> usernames){
//        this.usernames=usernames;
//    }
//
//    public List<String>  getUsername(){
//        return usernames;
//    }

    public UserService(){
        System.out.println("UserService constructor created");
    }

    public void init(){
        System.out.println("Post construct phase");
    }

    public void cleanup(){
        System.out.println("pre distroy phase");
    }
}
