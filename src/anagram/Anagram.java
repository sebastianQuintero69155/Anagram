/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import java.util.Scanner;

/**
 *
 * @author Sebastian Quintero
 */
public class Anagram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Solution anagram = new Solution();
        //metodo para solictarle al usuario la palabra que desea saber si anagrama
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese la palabra");
        String palabra = sc.next();
        anagram.solutionProblem(palabra);
        //-------------------------------------------------------------------------
        
    }
    
}
