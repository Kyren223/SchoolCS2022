package bagrut.testing;

public class main {
    
    public static void main(String[] args) {
        Antelope a = new Antelope(10);
        Beaver b = new Beaver(10);
        Mamal c = (Mamal) b;
    
        //System.out.println(a.isSame((Antelope) b));
        //System.out.println(a.isSame((Antelope) c));
    }
}
