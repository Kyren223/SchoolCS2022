package bagrut.oop.b2016a.ex14;

public class Main {
    public static void main(String[] args) {
        // xA=1 xB=20; xA=1 xB=20; xA=1 xB=20; xA=1 xB=20;
        A a1 = new B(1, 20);
        Object obj = a1;
        B b1 = (B) a1; // MUST be casted
        A a2 = a1;
    
        System.out.println(a1 + " " + obj + " " + a2 + " " + b1);
    }
}
