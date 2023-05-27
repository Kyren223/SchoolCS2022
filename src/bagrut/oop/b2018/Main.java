package bagrut.oop.b2018;

public class Main {
    public static void main(String[] args) {
        // E inherits from A
        // C inherits from E
        // B inherits from C
        // D inherits from C
        // D not inherits from B
        // A doesn't have f()
        // E has f()
        // B has f()
        // D doesn't have f()
        
        // A -> E
        // E -> C
        // C -> D
        // C -> B
        
        // f() -> B &
        
        // a2 = z1 - invalid - cannot cast object Z to object A
        // a3 = z1 - valid
        // ((A)z1).g() - invalid - Cannot cast object z1 of type Z to type A
        // a2.g() - valid
        // ((A)a3).g() - valid
        
        // a2 = y1 - valid - y inherits from c which inherits from e which inherits from a
        // y2 = y1 - valid - y inherits from C
        // ((A)y1).m() - invalid - y1 can be casted to A but A doesn't have the method m()
        // y2.m() - invalid - y2 is of type C and C doesn't have the method m()
        // ((A)y2).m() - invalid - Object casted to A and A doesn't have method m()
    }
}
