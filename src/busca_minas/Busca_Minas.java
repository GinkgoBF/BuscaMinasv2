/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package busca_minas;

import java.util.Scanner;

/**
 *
 * @author Ginkgo
 */
public class Busca_Minas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana v1 = new Ventana();
        v1.setVisible(true);
        


        //tablero.mostrarTablero();
        // TODO code application logic here
    }
    
    public static void menu(){
        
                int opc = 1;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("Elige una opción");
            System.out.println("0.Sailr");
            System.out.println("1.Jugar");
            opc = entrada.nextInt();
            entrada.nextLine();
            switch (opc) {
                case 0:
                    System.out.println("Hasta Pronto!");
                    break;
                case 1:
                    jugar(entrada);
                    break;
                default:
                    System.out.println("Elige una opcion válida!");
                    break;
            }
        } while (opc != 0);
    
    }

    public static void jugar(Scanner entrada) {
        int tam = 11;
        Tablero tablero = new Tablero(tam);
        tablero.iniciarTablero();
        tablero.contarMinas();
        tablero.mostrarTablero();
        //    tablero.iniciarTableroUsuario();
        boolean fin = false;
        do {
            tablero.mostrarTablero();
            System.out.println("Elige una opcion:");
            System.out.println("1.Abrir");
            System.out.println("2.Marcar");
            int jugada = entrada.nextInt();
            entrada.nextLine();
            boolean derrota = false;
            switch (jugada) {
                case 1:
                   // derrota = tablero.explotacasilla();
                    break;
                case 2:
                    tablero.marcarcasilla();
                    break;
            }
            if (derrota) {
                fin = true;
                System.out.println("TE HA EXLPOTADO UNA MINA. HAS PERDIDO");
            } else {
                fin = resuelto(tablero, tam);
                if (fin) {
                    System.out.println("ENHORABUENA HAS GANADO!!");
                }
            }

        } while (!fin);
    }

    public static boolean resuelto(Tablero tablero, int tam) {
        boolean result = true;
        for (int i = 1; i < tam; i++) {
            for (int j = 1; j < tam; j++) {
                Casilla casilla = tablero.getTablero()[i][j];
                if (!casilla.isAbierto() && !casilla.isMarcado()) {
                    result = false;
                }
            }
        }
        return result;
    }

}
