/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import Utils.Punto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rubco
 */
public class HeapsortY {
    
    private final List<Punto> puntos;
    private int size;
    
    public HeapsortY (List<Punto> datos){
        this.puntos = new ArrayList();
        size = datos.size();
        for(Punto p: datos){
            puntos.add(new Punto(p));
        }
    }
    
    public List<Punto> heapsort(){
        monticuloMax();
        for(int i = size - 1; i > 0; i--){
            swap(0, i);
            size--;
            monticulo(0);
        }
        
        
        return puntos;
    }
    
    
    private void monticulo(int i){
       int l = left(i);
       int r = right(i);
       int largest = i;
       
       if (l < size && puntos.get(l).getY() > puntos.get(largest).getY()){
           largest = l;
       }
       
       if (r < size && puntos.get(r).getY() > puntos.get(largest).getY()){
           largest = r;
       }
       
       if (largest != i){
           swap(i, largest);
           monticulo(largest);
       }
        
    }
    
    
    private void monticuloMax(){
        for(int i = lastParent(); i >= 0; i--){
            monticulo(i);
        }
    }
    
    private int lastParent(){
        return (size/2) -1;
    }
    
    private int left(int i){
        return 2*i + 1;
    }
    
    private int right(int i){
        return left(i) + 1;
    }
    
    private int parent(int i){
        return (i -1)/2;
    }
    
    
    private void swap(int i, int j){
        Punto aux = new Punto(puntos.get(j));
        puntos.set(j, new Punto(puntos.get(i)));
        puntos.set(i, aux);
    }
    
}
