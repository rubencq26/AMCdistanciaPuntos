/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import Utils.Punto;
import Utils.Solucion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rubco
 */
public class DyV {

    List<Punto> p;
    static int calculadas;

    public DyV(List<Punto> puntos) {
        Heapsort sorted = new Heapsort(puntos);
        p = sorted.heapsort();
        calculadas = 0;
    }

    private Solucion divideYveceras(List<Punto> puntos) {
        int n = puntos.size();
        
        if(n <= 10){
            ExhaustivoPoda ex = new ExhaustivoPoda(puntos);
            Solucion s = ex.calcularSinOrdenar();
            calculadas += s.getNCalculadas();
            return s;
        }
        
        int mid = n / 2;
        Punto midPoint = puntos.get(mid);
        
        Solucion sLeft = divideYveceras(new ArrayList<>(puntos.subList(0, mid)));
        Solucion sRight = divideYveceras(new ArrayList<>(puntos.subList(mid, n)));
        
        
        Solucion sMin = (sLeft.getDistancia() < sRight.getDistancia()) ? sLeft : sRight;
        double d = sMin.getDistancia();
        
        List<Punto> franja = new ArrayList<>();
        for (Punto p : puntos) {
            if (Math.abs(p.getX() - midPoint.getX()) < d) {
                franja.add(p);
            }
        }
        ExhaustivoPoda exha = new ExhaustivoPoda(franja);
        Solucion sFranja = exha.calcularSinOrdenar();
        calculadas += sFranja.getNCalculadas();
        
        if( d > sFranja.getDistancia()){
            sMin = sFranja;
        }
        
        return sMin;
    }

    public Solucion calcular() {
        calculadas = 0;
        Solucion s;
        double tiempo = System.nanoTime();
        s = divideYveceras(p);
        tiempo = System.nanoTime() - tiempo;
        tiempo = tiempo / 1000000.0;
        s.setNombre("Divide y Venceras");
        s.setTiempo(tiempo);
        s.setDistancia(Math.round(s.getDistancia()* 1e8) /1e8);
        s.setNCalculadas(calculadas);
        return s;
    }

}
