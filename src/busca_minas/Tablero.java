/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busca_minas;

import java.util.Scanner;

/**
 *
 * @author Ginkgo
 */
public class Tablero {

    private Casilla[][] tablero;
    private int tam;
    private int num_minas;

    
    /**
     * Este es el constructor de la clase, por defecto todo se inicializa en 0 menos el tamaño del tablero
     * @param tam 
     */
    public Tablero(int tam) {
        this.tam = tam;
        this.num_minas = 2;
        this.tablero = new Casilla[tam + 1][tam + 1];
        for (int i = 0; i <= tam; i++) {
            for (int j = 0; j <= tam; j++) {
                tablero[i][j] = new Casilla();
            }
        }
    }

    /**
     * Esta función permite al usuairo indicar una casilla en la que el cree que esta la mina, para ello cambia el atributo marcado de la casilla del tablero
     */

    
    /**
     * Esta función inicializa el tablero, para ello coloca de forma aleatoria bombas por el mapa.
     * Como no se crear una función que genere números aleatorios del 1 al 10 tengo una funcion que genera numeros del 0 al 10
     * en caso de salir 0 le sumo uno.
     */


    
    /**
     * Esta función se encarga de mostrar el tablero, para ello recorre el array de casillas 
     * y si no está abierta y no esta marcada muestra una X, si esta marcada un ? y en caso de 
     * que esté abierto, muestra el numero de minas cerca de dicha casilla.
     */
    public void mostrarTablero() {
        for (int i = 1; i < tam; i++) {
            for (int j = 1; j < tam; j++) {
                if (tablero[i][j].isAbierto()) {
                    System.out.print("  " + tablero[i][j].getContador_minas() + "  ");
                } else {
                    if (tablero[i][j].isMarcado()) {
                        System.out.print("  ?  ");
                    } else {
                        System.out.print("  X  ");
                    }
                }
            }
            System.out.println("");
        }
    }

    
    /**
     * Esta función se encarga de añadir al atributo de las casillas "numero de minas" el num de minas que tiene alredeedor
     * para ello, recorre el array, cuando encuentre una mina, a todas las casillas de alrededor le suma 1 a el contador de
     * numero de minas.
     * 
     */


    
    /**
     * Esta función pregunta al usuario una casilla para abrir, en caso de que en la casilla que quiera abrir 
     * una casilla que contenga una mina, esta funcion pasaría por @return que si explotacasilla
     * 
     * En caso de que no haya una, si el contador de minas es 0 entonces llama a la función abrir lados. Si hubiese
     * Un  numero simplemente cambiaría el valor de abierto de casilla a true. En cualquier caso al no haber explotado
     * la casilla, el @return de explotacasilla es false. 
     */
  
    
    /**
     * Esta función recursiva mira las casillas alrededor de la  casilla que hemos pasado por parametros.
     * @param fila
     * @param col 
     * 
     *Si una de las casillas de alrededor no esta abierta, entonces la abre y si el contador de minas de 
     * esa casilla es 0 entonces llama de nuevo a la función abrir lados.
     */

    
    
    //GETTERS Y SETTERS

    public Casilla[][] getTablero() {
        return tablero;
    }

    public void setTablero(Casilla[][] tablero) {
        this.tablero = tablero;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getNum_minas() {
        return num_minas;
    }

    public void setNum_minas(int num_minas) {
        this.num_minas = num_minas;
    }

    @Override
    public String toString() {
        return "Tablero{" + "tableroJuego=" + tablero + '}';
    }

}
