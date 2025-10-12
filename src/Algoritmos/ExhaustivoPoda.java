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
public class ExhaustivoPoda {
    
    private  List<Punto> puntos;
    private final int size;
   
    public ExhaustivoPoda(List<Punto> datos){
        puntos = new ArrayList<>(datos);
        size = puntos.size();
    }
    
    public Solucion calcularSinOrdenar(){
        double tiempo = System.nanoTime();
        double min;
        double distancia;
        Punto p1, p2;
        Solucion sol = new Solucion(new Punto(0, 0 ,0), new Punto(0, 0, 0), Double.POSITIVE_INFINITY, "Exhaustivo con Poda");
        int nCalculadas = 0;
        min = Double.MAX_VALUE;
        
        for(int i = 0; i < size; i++){
            
            p1 = puntos.get(i);
            for(int j = i + 1; j < size; j++){
                p2 = puntos.get(j);
                
                if(min < Math.abs(p1.getX() - p2.getX())){
                    break;
                }
                
                
                
                distancia = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2 ) + Math.pow(p2.getY() - p1.getY(), 2));
                distancia = Math.round(distancia * 1e8) / 1e8;
                nCalculadas++;
                
                if(min > distancia){
                    min = distancia;
                    
                    sol = new Solucion(p1, p2, min, "Exhaustivo con Poda"); 
                }
               
            }
        }
        
        tiempo = System.nanoTime() - tiempo;
        tiempo = tiempo / 1000000.0;
        sol.setTiempo(tiempo);
        sol.setNCalculadas(nCalculadas);
        return sol;
        
    }
    
    public Solucion calcular(){
        double tiempo = System.nanoTime();
        double min;
        double distancia;
        ordenar();
        Punto p1, p2;
        Solucion sol = new Solucion(new Punto(0, 0 ,0), new Punto(0, 0, 0), 0, "Exhaustivo con Poda");
        int nCalculadas = 0;
        min = Double.MAX_VALUE;
        
        for(int i = 0; i < size; i++){
            
            p1 = puntos.get(i);
            for(int j = i + 1; j < size; j++){
                p2 = puntos.get(j);
                
                if(min < Math.abs(p1.getX() - p2.getX())){
                    break;
                }
                
                
                
                distancia = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2 ) + Math.pow(p2.getY() - p1.getY(), 2));
                distancia = Math.round(distancia * 1e8) / 1e8;
                nCalculadas++;
                
                if(min > distancia){
                    min = distancia;
                    
                    sol = new Solucion(p1, p2, min, "Exhaustivo con Poda"); 
                }
               
            }
        }
        
        tiempo = System.nanoTime() - tiempo;
        tiempo = tiempo / 1000000.0;
        sol.setTiempo(tiempo);
        sol.setNCalculadas(nCalculadas);
        return sol;
    }
    
    private void ordenar(){
        Heapsort sorted = new Heapsort(puntos);
        puntos = sorted.heapsort();
    }
    
}
