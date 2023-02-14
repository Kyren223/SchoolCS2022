package bagrut.testing;

public class main {
    
    public static void main(String[] args) {
        Antelope a1 = new Antelope(10);
        Object a2 = new Antelope(10);
        Beaver b1 = new Beaver(10);
        Mamal b2 = new Beaver(10);
    
        //System.out.println("1: \n" + a1.weight);
        //System.out.println("2: \n" + ((Beaver)a2).getWeight());
        //System.out.println("3: \n" + a1.isSame(a2));
        //System.out.println("4: \n" + a2.isSame(a1));
        //System.out.println("5: \n" + b1.isSame(b2));
        //System.out.println("6: \n" + b2.isSame(b1));
        //System.out.println("7: \n" + a1.isSame((Beaver)b2));
        //System.out.println("8: \n" + a1.isSame((Antelope) a2));
        System.out.println("9: \n" + b1.isSame((Antelope) a2));
        //System.out.println("10: \n" + a1.isSame((Beaver)a2));
        
    }
}
