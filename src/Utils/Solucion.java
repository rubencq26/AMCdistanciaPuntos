package Utils;

public class Solucion{
    private Punto p1;
    private Punto p2;
    private double distancia;
    private int nCalculadas;
    private double tiempo;
    private String nombre;

    public Solucion(Punto p1, Punto p2, double distancia, String nombre){
        this.p1 = p1;
        this.p2 = p2;
        this.distancia = distancia;
        nCalculadas = 0;
        tiempo = 0;
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }

    public Punto getP1() {
        return p1;
    }
    public Punto getP2() {
        return p2;
    }
    public double getDistancia() {
        return distancia;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setNCalculadas(int nCalculadas) {
        this.nCalculadas = nCalculadas;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
    public int getNCalculadas() {
        return nCalculadas;
    }

    public double getTiempo() {
        return tiempo;
    }
    
    public void setNombre(String n){
        nombre = n;
    }
    
    
    @Override
    public String toString(){
        return getNombre() + " | " + getP1().toString() + " | " + getP2().toString() + " | " + getDistancia() + " | " + getTiempo() + " | " + getNCalculadas();
    }

}
