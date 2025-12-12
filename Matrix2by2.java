

public class Matrix2by2 {
    private double a1;  private double a2;
    private double b1;  private double b2;

    public Matrix2by2() {
        this.a1 = 0.0;  this.a2 = 0.0;
        this.b1 = 0.0;  this.b2 = 0.0;
    }

    public Matrix2by2(double a1, double a2, double b1, double b2) {
        this.a1 = a1;  this.a2 = a2;
        this.b1 = b1;  this.b2 = b2;
    }

    public Vector2by1 multiply(Vector2by1 vector) {
    
        Vector2by1 row1Vector = new Vector2by1(a1, a2);
        double row1 = Vector2by1.dot(row1Vector, vector);
        
        Vector2by1 row2Vector = new Vector2by1(b1, b2);
        double row2 = Vector2by1.dot(row2Vector, vector);
        
        return new Vector2by1(row1, row2);
    }


    public static Vector2by1 rotation90Clockwise(Vector2by1 vector) {
        Matrix2by2 cw90 = new Matrix2by2(0, 1, -1, 0);
        Vector2by1 result = cw90.multiply(vector);
        return result;
    }

    public static Vector2by1 rotation90CounterClockwise(Vector2by1 vector) {
        Matrix2by2 ccw90 = new Matrix2by2(0, -1, 1, 0);
        Vector2by1 result = ccw90.multiply(vector);
        return result;
    }

    public static Vector2by1 rotation180(Vector2by1 vector) {
        Matrix2by2 rot180 = new Matrix2by2(-1, 0, 0, -1);
        Vector2by1 result = rot180.multiply(vector);
        return result;
    }
    
}
