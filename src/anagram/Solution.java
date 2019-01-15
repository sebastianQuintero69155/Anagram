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

    ArrayList<String> anagram = new ArrayList<>();
    ArrayList<String> resultado = new ArrayList<>();

    public void solutionProblem(String palabra) {
        subirArchivo(palabra);
    }
//Metodo para cargar el archivo con las n palabras y para validar la palabra que ingreso el usuario con el archivo
    public void subirArchivo(String palabra) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int contLetras = 0;
        boolean valido = true;
        boolean conto = false;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("D:\\anagram.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                valido = true;
//          comprara tamaños de palabras y caracter por caracter
                contLetras = 0;
                if (palabra.length() == linea.length()) {
                    for (int i = 0; i < palabra.length(); i++) {
                        conto = false;
                        valido = true;
                        for (int j = 0; j < palabra.length(); j++) {
                            if (valido == true) {
                                if (palabra.charAt(i) == linea.charAt(j)) {//validacion de caracter  de la palabra con lista 
                                    contLetras++;
                                    conto = true;
                                }
                            }
                            if (conto == true) {
                                valido = false;
                            }

                        }

                    }
                    if (contLetras == palabra.length()) {// añadimos la palabra que coincide con el numero de caracteres a la lista
                        anagram.add(linea);

                    }
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
        validarPalabras(palabra);
    }
// metodo para la segunda validacion con las palabras que tenemos en el primer array list
    public void validarPalabras(String palabra) {
        int contLetras = 0;
        boolean valido = true;
        boolean conto = false;
        for (int s = 0; s < anagram.size(); s++) {
            contLetras = 0;
            if (anagram.get(s).length() == palabra.length()) {
                for (int i = 0; i < palabra.length(); i++) {
                    conto = false;
                    valido = true;
                    for (int j = 0; j < palabra.length(); j++) {
                        if (valido == true) {
                            if (anagram.get(s).charAt(i) == palabra.charAt(j)) { //validacion de caracter de la posible lista con la palabra
                                contLetras++;
                                conto = true;
                            }
                        }
                        if (conto == true) {
                            valido = false;
                        } else {

                        }
                    }

                }
                if (contLetras == palabra.length()) {
                    resultado.add(anagram.get(s));
                }

            }
        }

        imprimirPalabras(palabra);

    }
//-------------------------------------------------------------
    
//  metodo para imprimir las palabras del anagram 
    public void imprimirPalabras(String palabra) {
        System.out.println("La palabra ingresada por el usuario es: " + palabra + "\n");
        System.out.println("Las palabras ANAGRAMAS posibles son " + resultado);
    }
//----------------------------------------------------    
}
