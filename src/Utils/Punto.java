package Utils;

public class Punto{
    private final double x;
    private final double y;
    private final int id;

   
    public Punto(double x, double y, int id){
        this.x = Math.round(x * 10000000000.0) / 10000000000.0;
        this.y = Math.round(y * 10000000000.0) / 10000000000.0;
        this.id = id;
    }
    
    public Punto(Punto p){
        this.x = p.getX();
        this.y = p.getY();
        this.id = p.getId();
    }
    
    public Punto(){
        this.x = 0;
        this.y = 0;
        this.id = -1;
    }
    
    public double calcularDistancia(Punto p){
        double distancia = Math.sqrt(Math.pow(p.getX() - getX(), 2 ) + Math.pow(p.getY() - getY(), 2));
        distancia = Math.round(distancia * 1e8) / 1e8;
        return distancia;
    }
    
    public int getId(){
        return id;
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
        return getId() + " (" + x + ", " + y + ")";
    }
}