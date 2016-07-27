/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import javax.swing.JOptionPane;

/**
 *
 * @author gende
 */
public class menu {
    int opcion = Integer.parseInt(JOptionPane.showInputDialog("Presione 1 Para jugar, 2 para salir"));
        //matrices para crear tablero [filax][columnay]
int tablero1[][]= new int[20][20];
//variables para crear las bombas
double b1;
double b2;
//variable de tipo entero llamda numtotalminas
int numtotalminas;
//variable de tipo entero llamada intento
int intento;
//variable de tipo enterollamada total de minas
int totalminas;
        /**
     * Menu de mi clase Menu.
     **/
    public void menu() {
        switch (opcion){//metodo switch paravariable opc
            case 1: //caso 1 
                juego j = new juego();//instancia de mi clase juego
                //metodo adivina por medio de instancia
                j.juega();
                break;//corta la ejecucuion del programa
            case 2://caso 2
                System.exit(0);//saldra del programa
                break;//corta la ejecucion del program
        }
    }
}
        
