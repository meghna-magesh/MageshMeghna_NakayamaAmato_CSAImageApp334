

public class Vector2by1 {
    private double a;
    private double b;
    
    public Vector2by1() {
        this.a = 0.0;
        this.b = 0.0;
    }

    public Vector2by1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public static double dot(Vector2by1 v1, Vector2by1 v2) {
        return v1.a * v2.a + v1.b * v2.b;
    }

    
}
