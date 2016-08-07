/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Paquetes de mi Clase
package buscaminasgame;//Paquetes de mi clase.
//Importes de mi clase.
import java.util.Random;
import java.util.Scanner;
/**
 * @author genderson porras
 **/
public final class Tablero { //Método llamada Tablero.
    //Variables
    private final int[][] minas;//Matriz de tipo entero llamada minas.
    private final char[][] tablero;//Matriz de tipo char llamada tablero.
    private int fila, columna;// Variables de tipo entero llamas fila y columna.
    Random random = new Random();//Objeto llamado random.
    Scanner leer = new Scanner(System.in);//Objeto llamado leer.
    /**
     * Método Constructor de mi clase Tablero.
     **/
    public Tablero() {
        this.minas = new int[10][10]; //Mi matriz minas va a seguir igual a lo que valga mi constructor.
        this.tablero = new char[10][10];//Mi matriz tablero va a seguir igual a lo que valga mi constructor.
        /**
        *Llamo a mis Métodos:
        *RandomMinas();
        *CantidadMinasVecinas();
        *InicioTablero();
        **/
        RandomMinas();
        CantidadMinasVecinas();
        InicioTablero();
    }
    /**
    *Método de tipo boolean llamado Rellenar.
    *Vuelve a mostrar el tablero actualizado despues de seleccionar una casilla.
    *@return count.
    **/
    public boolean Rellenar() {
        int count = 0;//Variable de tipo entero llamada count.
        for (int f = 1; f < 9; f++) {
            for (int c = 1; c < 9; c++) {
                if (tablero[f][c] == '_') {
                    count++; //count aumenta 1 (count + 1).
                }
            }
        }
        return count == 10; // Retorna la variable count.
    }
    /**Método void llamado RevelarCasillas.
     *Ciclo for el cual revela la casilla seleccionada.
     **/
    public void RevelarCasillas() {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((minas[fila + i][columna + j] != -1) && (fila != 0 && fila != 9 && columna != 0 && columna != 9)) {//-1 es bomba
                    tablero[fila + i][columna + j] = Character.forDigit(minas[fila + i][columna + j], 10);
                }
            }
        }
    }
    /**
     *Método getPosicion.
     *@param Linea.
     *@param Columna.
     *@return minas[Linea][Columna];
     **/
    public int getPosicion(int Linea, int Columna) {//muestra
        return minas[Linea][Columna];
    }
    /**
     *Método setPosicion.
     *Ciclos do while: Imprime en el tablero el mensaje de "linea" y "columna", además dice si una posicion ya fue seleccionada.  
     *@return getPosicion(fila, columna) == -1;
     **/
    public boolean setPosicion() {//carga
        do {
            System.out.print("\nLinea: ");//Impresión en la consola.
            fila = leer.nextInt();//Lee el dato ingresado en la consola.
            System.out.print("Columna: ");//Impresión en la consola.
            columna = leer.nextInt();//Lee el dato ingresado en la consola.
            if ((tablero[fila][columna] != '_') && ((fila < 9 && fila > 0) && (columna < 9 && columna > 0))) {
                System.out.println("Este espacio ya fue seleccionado");//Impresión en la consola.
            }
        } while ((fila < 1 || fila > 8 || columna < 1 || columna > 8) || (tablero[fila][columna] != '_'));
        return getPosicion(fila, columna) == -1;
    }
    /**
     *Método void llamado Mostrar.
     *Imprime en la consola al lado de las filas y de las colunas un numéro para guiar al usuario.
     **/
    public void Mostrar() {
        System.out.println("\n     Lineas");//Impresión en la consola.
        for (int f = 8; f > 0; f--) {
            System.out.print("       " + f + " ");
            for (int c = 1; c < 9; c++) {
                System.out.print("   " + tablero[f][c]);
            }
            System.out.println();
        }
        System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("                      Columnas");
    }
    /**
     *Método void llamado CantidadMinasVecinas.
     *Muestras la cantidad de minas alrededor de una casilla.
     **/
    public void CantidadMinasVecinas() {
        for (int f = 1; f < 9; f++) {
            for (int c = 1; c < 9; c++) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (minas[f][c] != -1) {
                            if (minas[f + i][c + j] == -1) {
                                minas[f][c]++;
                            }
                        }
                    }
                }
            }
        }
    }
    /**Método void llamado MostrarMinas.
    *Muestras un "*" donde hay una mina.
    **/ 
    public void MostrarMinas() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (minas[i][j] == -1) {
                    tablero[i][j] = '*';
                }
            }
        }
        Mostrar();//Llamo a mi Método Mostrar.
    }
    /**Método void llamado InicioTablero.
     *Rellena las casillas del tablero con "_".
     **/ 
    public void InicioTablero() {
        for (int i = 1; i < minas.length; i++) {
            for (int j = 1; j < minas.length; j++) {
                tablero[i][j] = '_';
            }
        }
    }
    /**Método void llamado RandomMinas.
    *Rellena 10 espacios con minas al azar y le asgina el valor (mina = -1).
    **/ 
    public void RandomMinas() {
        boolean sorteo;//Variable de tipo boolean llamada sorteo.
        int linea, columna;//Variables de tipo entero llamadas linea, columnas.
        for (int i = 0; i < 10; i++) {
            do {
                linea = random.nextInt(8) + 1;
                columna = random.nextInt(8) + 1;
                sorteo = minas[linea][columna] == -1;
            } while (sorteo);
            minas[linea][columna] = -1;
        }
    }
}