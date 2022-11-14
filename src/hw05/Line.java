package hw05;

public class Line {
    private Point a;
    private Point b;
    
    public Line(Point a, Point b) {
        this.a = new Point(a.getX(), a.getY());
        this.b = new Point(b.getX(), b.getY());
    }
    
    public Line(int x1, int y1, int x2, int y2) {
        this.a = new Point(x1, y1);
        this.b = new Point(x2, y2);
    }
    
    public Point getA() {
        return a;
    }
    
    public void setA(Point a) {
        this.a = a;
    }
    
    public Point getB() {
        return b;
    }
    
    public void setB(Point b) {
        this.b = b;
    }
    
    public double getLineLength() {
        // Distance formula aka Pitagoras theorem
        double firstSide = Math.abs(a.getX() - b.getX());
        double secondSide = Math.abs(a.getY() - b.getY());
        return Math.sqrt(Math.pow(firstSide, 2) + Math.pow(secondSide, 2));
        
    }
    
    @Override
    public String toString() {
        return a.toString() +  " - " + b.toString() + " - [" + getLineLength() + "]";
    }
}
