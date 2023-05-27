package bagrut.oop.b2017.ex13;

public class Program {
    public static void main(String[] args) {
        Beta beta = new Beta();
        ITwo x = beta;
        System.out.println(x.second());
        
        // A is of type C
        // B is
        // D is of type B
        // D is of type A
        
        // C -> A -> D
    }
}
