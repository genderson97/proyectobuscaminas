/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminasgame;
//Importes de mi Clase Juego
import javax.swing.JOptionPane;
/**
 *@author genderson porras
 **/
public final class Juego {//Método llamado Juego.
    //Variables:
    private Tablero t;//Se crea un Objeto
    boolean fin = false;
    int turno = 0;//variable de tipo entero llamada turno.
    //Método llamado Juego.
    public Juego() {
        /**
         * Ciclo while, con un switch para crea el Menú
         **/
        while (true) {
            char opcion = JOptionPane.showInputDialog("Bienvenido al Juego \n Digite \n 1-Para Empezar a jugar \n 2-Para Salir").charAt(0);
            switch (opcion) {
                case '1':
                    Jugar();
                    break;
                case '2':
                    System.exit(0);
                      break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion Incorrecta Intente de Nuevo","Menu",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    //Método void llamado Juego
    public void Jugar() {
        /**
         * Ciclo do while muestra los turno que se llevan cada vez que se selecciona una casilla.
         * Envia un mensaje si el ganador perdio o gano dependiendo de la situación.
         **/
        t = new Tablero();//Instancion el objeto
        do {
            turno++;
            System.out.println("Turno " + turno);
            t.Mostrar();
            fin = t.setPosicion();
            if (!fin) {
                t.RevelarCasillas();
                fin = t.Rellenar();
            }
        } while (!fin);
        //Muestra una venta con un mensaje de felicitación por haber ganado el juego. 
        if (t.Rellenar()) {
            JOptionPane.showMessageDialog(null,"Felicidades Has ganado en: " + turno + " turnos","Fin del Juego",JOptionPane.WARNING_MESSAGE);
            t.MostrarMinas();//Llamo a mi Método t.MostrarMinas 
        } else {
            //Muestra una ventana con mensaje de que el jugador a perdido el juego.
            JOptionPane.showMessageDialog(null,"Has Perdido!","Fin del Juego",JOptionPane.ERROR_MESSAGE);
            t.MostrarMinas();//Llamo a mi Método t.MostrarMinas 
        }
    }
}