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
    int filas = 0;
    int columnas = 0;
//matrices para crear tablero [filax][columnay]
int tablero[][]= new int[filas][columnas];
//variables para crear las bombas
double b1=0;
double b2=0;
//variable de tipo entero llamda numtotalminas
int numtotalminas=20;
//variable de tipo entero llamada intento
int intento=50;
//variable de tipo enterollamada total de minas
int totalminas =0;
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
   //impresion para pedir las filas
        filas = Integer.parseInt(JOptionPane.showInputDialog("Digita las filas de la matriz"));
        //impresion parapedir las columnas
        columnas = Integer.parseInt(JOptionPane.showInputDialog("Digita las columnas de la matriz"));
           int tablero[][]= new int[filas][columnas]; //Pedimos los datos
    System.out.println("usted posee " + intento + " intentos");
    for(int i=0;i<filas;i++){
        for(int j=0;j<columnas;j++){
            tablero[i][j]=0;
            System.out.print(tablero[i][j]+" "); 
        }
        System.out.println(); 
    }                   
    int sum=0; //variable que sumara todos los elementos 
    for(int i=0;i<tablero.length;i++){ //Tamaño de filas
        for(int j=0;j<tablero[0].length;j++){ //Tamaño de columnas
            sum+=tablero[i][j];
        }
    do{
    	    b1=Math.random()*filas;
            b2=Math.random()*columnas;  
            b1=(int)b1;
            b2=(int)b2;
            if  (b2!=0 && b1!=0 && b2!=columnas-1 && b1!=filas-1){
   tablero[(int)b1][(int) b2 ]=1;
   numtotalminas++;
}}
    while(numtotalminas<=filas);   
}
  }}

 





    
