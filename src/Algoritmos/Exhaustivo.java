package Algoritmos;

import Utils.Punto;

import java.util.List;
import Utils.Solucion;

public class Exhaustivo {
    private List <Punto> puntos;
    private Solucion solucion;
    public Exhaustivo(List<Punto> puntos) {
        this.solucion = new Solucion(new Punto(0, 0, 0),new Punto(0, 0, 0), Double.POSITIVE_INFINITY, "Exhaustivo");
        this.puntos = puntos;
    }

    public Solucion calcularDistanciaMasCorta(){
        double distancia = Double.MAX_VALUE;
        double distanciaActual;
        int n = 0;
        double tiempo = System.nanoTime();

        for(int i = 0; i < puntos.size(); i++){
            Punto p1 = new Punto(puntos.get(i));
            for(int j = i +1; j < puntos.size(); j++){
                Punto p2 = new Punto(puntos.get(j));
                distanciaActual = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2 ) + Math.pow(p2.getY() - p1.getY(), 2));
                if(distanciaActual < distancia){
                   distancia = distanciaActual;
                   solucion = new Solucion(p1, p2, distancia, "Exhaustivo");
                }
                n++;
            }
        }
        tiempo = System.nanoTime() - tiempo;
        tiempo = tiempo / 1000000.0;
        solucion.setTiempo(tiempo);
        solucion.setNCalculadas(n);
        solucion.setDistancia(Math.round(solucion.getDistancia()  * 1e8) / 1e8);
        return solucion;
    }

}
