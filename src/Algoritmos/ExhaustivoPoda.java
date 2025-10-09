/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import Utils.Punto;
import java.util.List;

/**
 *
 * @author rubco
 */
public class ExhaustivoPoda {
    
    private final List<Punto> puntos;
    private final int size;
    
    public ExhaustivoPoda(List<Punto> datos){
        Heapsort sorted = new Heapsort(datos);
        puntos = sorted.heapsort();
        size = puntos.size();
    }
    
    public Solucion calcular(){
        
        
    }
    
}
