/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.util.Scanner;
import javax.swing.JOptionPane;



/**
 **
 ** @author genderson
 ** @date 
 **/
public class juego { 
    Scanner leer = new Scanner (System.in);
//matrices para crear tablero [filax][columnay]
int tablero[][]= new int[5][5];
//variables para crear las bombas
double b1=0;
double b2=0;
//variable de tipo entero llamda numtotalminas
int numtotalminas=0;
//variable de tipo entero llamada intento
int intento=50;
//variable de tipo enterollamada total de minas
int totalminas =10;
//constructores 
    public juego() {//costructor vacio
    }

    public juego(double b1, double b2, int numtotalminas, int intento, int totalminas) {//constructor lleno
        this.b1 = 0;
        this.b2 = 0;
        this.numtotalminas = numtotalminas;
        this.intento =intento;
        this.totalminas = totalminas;
    }
    //sets

    public void setTablero(int[][] tablero1) {
        this.tablero = tablero1;
    }
    public void setB1(double b1) {
        this.b1 = b1;
    }

    public void setB2(double b2) {
        this.b2 = b2;
    }

    public void setNumtotalminas(int numtotalminas) {
        this.numtotalminas = numtotalminas;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

    public void setTotalminas(int totalminas) {
        this.totalminas = totalminas;
    }
    //gets

    public int[][] getTablero() {
        return tablero;
    }
    public double getB1() {
        return b1;
    }

    public double getB2() {
        return b2;
    }

    public int getNumtotalminas() {
        return numtotalminas;
    }

    public int getIntento() {
        return intento;
    }

    public int getTotalminas() {
        return totalminas;
    }    
    public void juega(){
    System.out.println("usted posee " + intento + " intentos");
for (int x=0; x < getTablero().length; x++) {
  System.out.print("|");
  for (int y=0; y < getTablero()[x].length; y++) {
    System.out.print (getTablero()[x][y]);
    if (y==getTablero()[x].length-1) { 
      } else {
        System.out.print("\t");
   } 
}
    System.out.println("|");}}}





    
