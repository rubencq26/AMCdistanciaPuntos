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
public class DyVMejorado {

    List<Punto> p;
    static int calculadas;

    public DyVMejorado(List<Punto> puntos) {
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
        HeapsortY sorted = new HeapsortY(franja);
        franja = sorted.heapsort();
        Solucion sFranja = new Solucion();
        int contador;
        for(int i = 0; i < franja.size() ; i++){
            contador = 0;
            for(int j = i + 1; j < franja.size(); j++){
                contador++;
                if (contador > 10){
                    break;
                }
                
                if(Math.abs(franja.get(i).getY() - franja.get(j).getY()) >= sMin.getDistancia()){
                    break;
                }
                calculadas++;  
                if(franja.get(i).calcularDistancia(franja.get(j)) < sMin.getDistancia()){
                    sMin = new Solucion(franja.get(i), franja.get(j), franja.get(i).calcularDistancia(franja.get(j)), "DyV Mejorado");
                }
                
            }
        }
        sMin.setNCalculadas(calculadas);
        return sMin;
    }

    public Solucion calcular() {
        calculadas = 0;
        Solucion s;
        double tiempo = System.nanoTime();
        s = divideYveceras(p);
        tiempo = System.nanoTime() - tiempo;
        tiempo = tiempo / 1000000.0;
        s.setNombre("DyV Mejorado");
        s.setTiempo(tiempo);
        s.setDistancia(Math.round(s.getDistancia()* 1e8) /1e8);
        s.setNCalculadas(calculadas);
        return s;
    }

}
