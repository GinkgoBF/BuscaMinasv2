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
    private  Casilla[][] tablero;
    private  int tam;
    private  int num_minas;
    
    
    


    public Tablero(int tam) {
        this.tam=tam;
        this.num_minas=2;
        this.tablero= new Casilla[tam+1][tam+1];
        for(int i = 0 ; i <= tam ; i++){
            for(int j = 0 ; j <= tam ; j++){
                tablero[i][j]= new Casilla();
            }
    }}


    
    public void marcarcasilla(){
           Scanner entrada = new Scanner(System.in);
           System.out.print("Dime la fila de la casilla a Marcar");
           int fila = entrada.nextInt();
           entrada.nextLine();
           System.out.print("Dime la columna de la casilla a Marcar");
           int col = entrada.nextInt();
           entrada.nextLine();       
           tablero[fila][col].setMarcado(true);
           
    }
    
    
     public  void iniciarTablero(){ 
        //this.tableroJuego= new Casilla[tam+1][tam+1];
        for(int i = 1; i <= num_minas; i++){
            System.out.println("Intento de minaxd");
            boolean puesto = false;
            do{
            int fil = (int)Math.floor(Math.random()*11);
            int col = (int)Math.floor(Math.random()*11);
            if(fil==0){fil=fil+1;}
            if(col==0){col=col+1;}
            if(!tablero[fil][col].isMina()){
                tablero[fil][col].setMina(true);
                puesto = true;
                System.out.println("Mina Puesta quedan " + (num_minas-i));
                }
            else{
            System.out.println("Mina NO Puesta quedan " + (num_minas-i));}
            }while(!puesto);
        }              
    }
    
    public void mostrarTablero(){
        for(int i = 1 ; i < tam ; i++){
            for(int j = 1 ; j < tam ; j++){
                if(tablero[i][j].isAbierto()){
                    System.out.print("  "  + tablero[i][j].getContador_minas() + "  ");
                }else{
                    if(tablero[i][j].isMarcado()){
                        System.out.print("  ?  ");
                    }else{
                        System.out.print("  X  ");
                }}
            }
            System.out.println("");
        }
    }
    
    public void contarMinas(){
        for(int i = 1 ; i < tam ; i++){
            for(int j = 1 ; j < tam ; j++){
                if(tablero[i][j].isMina()){
                    System.out.println("Encontré una mina");
                    for(int x = i-1 ; x <= i+1 ; x++){
                          for(int z = j-1 ; z <= j+1 ; z++){
                                
                              tablero[x][z].setContador_minas(tablero[x][z].getContador_minas()+1);
                }}
            }
    }}}

            
                   
       public boolean explotacasilla(){
           Scanner entrada = new Scanner(System.in);
           System.out.print("Dime la fila de la casilla a destruir");
           int fila = entrada.nextInt();
           entrada.nextLine();
           System.out.print("Dime la columna de la casilla a destruir");
           int col = entrada.nextInt();
           entrada.nextLine();
           if(!tablero[fila][col].isMina()){
               if(tablero[fila][col].getContador_minas()==0){
                    abrirlados(fila,col);
               }else{tablero[fila][col].setAbierto(true);}
               
               return false;
           }else{
                return true;
           }
       }
 
               
   public void abrirlados(int fila, int col){
    for(int x = fila-1 ; x <= fila+1 ; x++){
        for(int z = col-1 ; z <= col+1 ; z++){
            if(x >= 0 && x < 11 && z >= 0 && z < 11){
                if(!tablero[x][z].isAbierto()){
                    tablero[x][z].setAbierto(true);
                    if(tablero[x][z].getContador_minas() == 0){
                        abrirlados(x, z);
                    }
                }
            }
        }
    }
}

   
   
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

    /*   public void despejarvacios(int fila, int col){
    if(tableroJuego[fila][col]==0){}
    int filaascen = fila;
    int filadescen = fila;
    int colascen = col;
    int coldescen = col;
    for(int i = 1; i <= 10 ; i++ ){
    if(filaascen<=10){
    filaascen = fila + i;
    if(tableroJuego[filaascen][col]<=1){
    tableroUsuario[filaascen][col]=String.valueOf(tableroJuego[filaascen][col]);
    if (tableroJuego[filaascen][col]!=0){
    filaascen=99;
    System.out.println("Pongo la fila ascendente en 99");
    }
    }}
    if(filadescen>=1){
    filadescen = fila - i;
    if(tableroJuego[filadescen][col]<=1){
    tableroUsuario[filadescen][col]=String.valueOf(tableroJuego[filadescen][col]);
    if (tableroJuego[filadescen][col]!=0){
    filadescen=-9;
    }
    }}
    if(colascen<=10){
    colascen = col+i;
    if(tableroJuego[fila][colascen]<=1){
    tableroUsuario[fila][colascen]=String.valueOf(tableroJuego[fila][colascen]);
    if (tableroJuego[fila][colascen]!=0){
    colascen=99;
    }
    }}
    //hola
    if(coldescen>=1){
    coldescen = col-i;
    if(tableroJuego[fila][coldescen]<=1){
    tableroUsuario[fila][coldescen]=String.valueOf(tableroJuego[fila][coldescen]);
    if (tableroJuego[fila][coldescen]!=0){
    coldescen=-9;
    }
    }}
    }}
     */
    public void setNum_minas(int num_minas) {
        this.num_minas = num_minas;
    }

    @Override
    public String toString() {
        return "Tablero{" + "tableroJuego=" + tablero + '}';
    }
       
       
       }
    
 

