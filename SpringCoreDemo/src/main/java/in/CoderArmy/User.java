package in.CoderArmy;

public class User {

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        Name = name;
        this.age = age;
    }

    private String Name;
    private int age;
}
