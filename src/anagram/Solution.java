/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Quintero
 */
public class Solution {

    ArrayList<String> lstAnagram = new ArrayList<>();
    ArrayList<Character> palabraAnagram = new ArrayList<>();
    ArrayList<Character> palabraCompar = new ArrayList<>();

    public void solutionProblem(String palabra) {
        subirArchivo(palabra);
    }
//Metodo para cargar el archivo con las n palabras y para validar la palabra que ingreso el usuario con el archivo

    public void subirArchivo(String palabra) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        boolean valido = true;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("D:\\anagram.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                if (palabra.length() == linea.length()) {
                    limpiarListas();
                    for (int i = 0; i < palabra.length(); i++) {
                        palabraAnagram.add(palabra.charAt(i));
                        palabraCompar.add(linea.charAt(i));
                    }
                    compararPalabras(linea);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        imprimirAnagrama(palabra);
    }

    //limpiar listas
    public void limpiarListas() {
        for (int i = palabraAnagram.size() - 1; i >= 0; i--) {
            palabraAnagram.remove(i);
            palabraCompar.remove(i);
        }

    }
    //-----------------------------------------------

// metodo para validacion de las palabras
    public void compararPalabras(String palAnagram) {
        boolean ingresar = false;
        int contLetras = 0;
        boolean conto = false;
        int total = palabraAnagram.size();
        int i = 0;
        for (int j = 0; j < palabraCompar.size(); j++) {
            if (palabraAnagram.get(i) == palabraCompar.get(j)) {
                contLetras++;
                palabraAnagram.remove(i);
                palabraCompar.remove(j);
                j = -1;
            }
        }
        i++;

        if (contLetras == total) {
            lstAnagram.add(palAnagram);
        }
    }

//-------------------------------------------------------------
//  metodo para imprimir las palabras del anagram 
    public void imprimirAnagrama(String palabraAnagram) {
        System.out.println("La palabra que usted ingreso es: " + palabraAnagram + "\n");
        System.out.println("La lista de anagramas es la sigiente: " + lstAnagram);
    }
//----------------------------------------------------    
}
