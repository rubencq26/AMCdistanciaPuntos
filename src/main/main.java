/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Algoritmos.DyV;
import Algoritmos.DyVMejorado;
import Algoritmos.Exhaustivo;
import Algoritmos.ExhaustivoPoda;
import TSPFicheros.TSPfichero;

/**
 *
 * @author rubco
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TSPfichero file = new TSPfichero();
        file.generarDataset(100000);
        DyV d = new DyV(file.getNodos());
        DyVMejorado dm = new DyVMejorado(file.getNodos());
        Exhaustivo ex = new Exhaustivo(file.getNodos());
        ExhaustivoPoda exp = new ExhaustivoPoda(file.getNodos());
        
        System.out.println(d.calcular().toString());
        System.out.println(dm.calcular().toString());
        System.out.println(ex.calcularDistanciaMasCorta().toString());
        System.out.println(exp.calcular().toString());
        
        
        
    }
    
}
