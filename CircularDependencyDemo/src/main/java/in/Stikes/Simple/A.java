package in.Stikes.Simple;

public class A {
    private B b;

    public A(){
        System.out.println("A created");
        this.b = new B();
    }
}
