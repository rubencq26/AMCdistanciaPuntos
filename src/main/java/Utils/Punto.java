package Utils;

public class Punto{
    private final double x;
    private final double y;

    /**
     * Constructor de la clase Punto
     * @param x
     * @param y
     */
    public Punto(double x, double y){
        this.x = Math.round(x * 10000000000.0) / 10000000000.0;
        this.y = Math.round(y * 10000000000.0) / 10000000000.0;
    }

    /**
     * Getter x
     * @return
     */
    public double getX(){ return x;}

    /**
     * Getter y
     * @return
     */
    public double getY(){ return y;}


    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}