package Algoritmos;

import Utils.Punto;

import java.util.List;
import Utils.Solucion;

public class Exhaustivo {
    private List <Punto> puntos;
    private Solucion solucion = new Solucion(0, 0, 0, "Exhaustivo");
    public Exhaustivo(List<Punto> puntos) {
        this.puntos = puntos;
    }

    public Solucion calcularDistanciaMasCorta(){
        double distancia = Double.MAX_VALUE;
        double distanciaActual;
        int n = 0;
        double tiempo = System.currentTimeMillis();

        for(int i = 0; i < puntos.size(); i++){
            Punto p1 = puntos.get(i);
            for(int j = i +1; i < puntos.size(); j++){
                Punto p2 = puntos.get(j);
                if(p1 == p2){
                    continue;
                }
                distanciaActual = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2 ) + Math.pow(p2.getY() - p1.getY(), 2));
                if(distanciaActual < distancia){
                   distancia = distanciaActual;
                   distancia = Math.round(distancia * 100000000.0) / 100000000000.0;
                   solucion = new Solucion(p1.getId(), p2.getId(), distancia, "Exhaustivo");
                }
                n++;
            }
        }
        tiempo = System.currentTimeMillis() - tiempo;
        solucion.setTiempo(tiempo);
        solucion.setNCalculadas(n);
        return solucion;
    }

}
