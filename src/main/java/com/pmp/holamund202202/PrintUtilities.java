/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.holamund202202;
import java.util.Scanner;
/**
 *
 * @author obetancourth
 */
public class PrintUtilities {
    public static void printH1( String headerText ) {
        // esfelizcuandolosgatosnoestanylosratonesfiestahacen = true;
        // esFelizCuandoLosGatosNoEstanYLosRatonesFiestaHacen = true;
        System.out.println("===================================================");
        System.out.println(headerText);
        System.out.println("===================================================");
    }
    public static String readInput( Scanner keyInput, String label, String defaultValue) {
        System.out.println("");
        System.out.println(label + " : ");
        String inputValue = keyInput.nextLine();
        //  || or   && and
        if (inputValue.isEmpty() || inputValue.isBlank()) {
            inputValue = defaultValue;
        }
        return inputValue;
    }
    public static void printMenu(){
        System.out.println("===================================================");
        System.out.println("Opciones");
        System.out.println("===================================================");
        System.out.println("P \t Datos Personales");
        System.out.println("S \t Salir");
    }
}
