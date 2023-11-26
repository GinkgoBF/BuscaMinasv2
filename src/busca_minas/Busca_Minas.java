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
        int opc=1;
        Scanner entrada = new Scanner(System.in);
        do{
        System.out.println("Elige una opción");
        System.out.println("0.Sailr");
        System.out.println("1.Jugar");
        opc = entrada.nextInt();
        entrada.nextLine();
        switch(opc){
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
        }while(opc!=0);
        
    
        //tablero.mostrarTablero();
        // TODO code application logic here
    }
    
       public static void jugar(Scanner entrada){
        Tablero tablero = new Tablero();
        tablero.iniciarTablero();
        tablero.mostrarTablero();
        //System.out.println();
        tablero.contarMinas();
        tablero.iniciarTableroUsuario();
        boolean fin = false;
        do{
          tablero.mostrarTableroUsuario();
          System.out.println("Elige una opcion:");
          System.out.println("1.Abrir");
          System.out.println("2.Marcar");
          int jugada = entrada.nextInt();
          entrada.nextLine();
          boolean derrota = false;
          switch(jugada){
            case 1:
                derrota=tablero.explotacasilla();
                break;
            case 2:
                tablero.marcarcasilla();
                break;
        }
          if(derrota){
          fin=true;
          System.out.println("TE HA EXLPOTADO UNA MINA. HAS PERDIDO");
          }
          
        }while(!fin);
       }
       



}
