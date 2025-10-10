/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

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
        file.generarDataset(10000);
        Exhaustivo ex = new Exhaustivo(file.getNodos());
        ExhaustivoPoda ep = new ExhaustivoPoda(file.getNodos());
        
        System.out.println(ex.calcularDistanciaMasCorta().toString());
        System.out.println(ep.calcular().toString());
        
        
    }
    
}
