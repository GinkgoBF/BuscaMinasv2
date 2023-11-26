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
    private  int [][] tableroJuego;
    private  String [][] tableroUsuario;
    public Tablero(int[][] tablero) {
    this.tableroJuego = tablero;
    }

    public Tablero() {
    }

  
    public void iniciarTableroUsuario(){
       int tam=12;
       tableroUsuario= new String[tam][tam];
        for(int i = 0 ; i < tam ; i++){
            for(int j = 0 ; j < tam ; j++){
                tableroUsuario[i][j]="X";
            }
        }
    }
    
    public void marcarcasilla(){
           Scanner entrada = new Scanner(System.in);
           System.out.print("Dime la fila de la casilla a Marcar");
           int fila = entrada.nextInt();
           entrada.nextLine();
           System.out.print("Dime la columna de la casilla a Marcar");
           int col = entrada.nextInt();
           entrada.nextLine();       
           tableroUsuario[fila][col]="?";
           
    }
    
    
     public  void iniciarTablero(){
        int num_minas = 10;
        int tam = 12;
        this.tableroJuego= new int[tam][tam];
        for(int i = 1; i <= num_minas; i++){
            boolean puesto = false;
            do{
            int fil = (int)Math.floor(Math.random()*11);
            int col = (int)Math.floor(Math.random()*11);
            if(fil==0){fil=fil+1;}
            if(col==0){col=col+1;}
            if(tableroJuego[fil][col]==0){
                tableroJuego[fil][col]=9;
                puesto = true;
                System.out.println("Mina Puesta quedan " + (num_minas-i));
                }
            else{
            System.out.println("Mina NO Puesta quedan " + (num_minas-i));}
            }while(!puesto);
        }              
    }
    
    public void mostrarTablero(){
        int tam = 10;
        for(int i = 1 ; i <= tam ; i++){
            for(int j = 1 ; j <= tam ; j++){
                System.out.print(tableroJuego[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void contarMinas(){
        int tam = 10;
        for(int i = 1 ; i <= tam ; i++){
            for(int j = 1 ; j <= tam ; j++){
                if(tableroJuego[i][j]==9){
                    if(tableroJuego[i-1][j-1]!=9){tableroJuego[i-1][j-1]=tableroJuego[i-1][j-1]+1;}
                    if(tableroJuego[i-1][j]!=9){tableroJuego[i-1][j]=tableroJuego[i-1][j]+1;}
                    if(tableroJuego[i-1][j+1]!=9){tableroJuego[i-1][j+1]=tableroJuego[i-1][j+1]+1;}
                    
                    if(tableroJuego[i][j-1]!=9){tableroJuego[i][j-1]=tableroJuego[i][j-1]+1;}
                    if(tableroJuego[i][j+1]!=9){tableroJuego[i][j+1]=tableroJuego[i][j+1]+1;}
                    
                    if(tableroJuego[i+1][j-1]!=9){tableroJuego[i+1][j-1]=tableroJuego[i+1][j-1]+1;}
                    if(tableroJuego[i+1][j]!=9){tableroJuego[i+1][j]=tableroJuego[i+1][j]+1;}
                    if(tableroJuego[i+1][j+1]!=9){tableroJuego[i+1][j+1]=tableroJuego[i+1][j+1]+1;}
                }}
            }
    }
    
       public void mostrarTableroUsuario(){
       int tam = 10;
       for(int i = 1 ; i <= tam ; i++){
            for(int j = 1 ; j <= tam ; j++){
                System.out.print(tableroUsuario[i][j]);
            }
            System.out.println("");
        }
    }
            
                   
       public boolean explotacasilla(){
           Scanner entrada = new Scanner(System.in);
           System.out.print("Dime la fila de la casilla a destruir");
           int fila = entrada.nextInt();
           entrada.nextLine();
           System.out.print("Dime la columna de la casilla a destruir");
           int col = entrada.nextInt();
           entrada.nextLine();
           if(tableroJuego[fila][col]==0){
               mirarlados(fila,col);
               /*despejarvacios(fila,col);
               despejarvacios(fila+1,col+1);
               despejarvacios(fila+1,col);
               despejarvacios(fila,col+1);
               despejarvacios(fila-1,col-1);
               despejarvacios(fila-1,col);
               despejarvacios(fila,col-1);
               despejarvacios(fila+1,col-1);
               despejarvacios(fila-1,col+1);*/
           }
           if(tableroJuego[fila][col]!=9){
              tableroUsuario[fila][col]=String.valueOf(tableroJuego[fila][col]);
              return false;
           }
           else{return true;}
           
       }
       
       public void mirarlados(int fila,int col){
           if(fila<=10 && fila>1 && col<=10 && fila >1){
           if(tableroJuego[fila][col]!=0){
                tableroUsuario[fila][col]=String.valueOf(tableroJuego[fila][col]);
           }else{
               if((fila+1<=10) && (col+1<=10)){mirarlados(fila+1,col+1);}
               if(fila+1<=10){mirarlados(fila+1,col);}
               if((fila+1<=10) && (col-1>=0)){mirarlados(fila+1,col-1);}
               if(col+1<=10){mirarlados(fila,col+1);}
               if((fila-1>=0) && (col-1>=0)){mirarlados(fila-1,col-1);}
               if((fila-1>=0) && (col+1<=10)){mirarlados(fila-1,col+1);}
               if(fila-1>=0){mirarlados(fila-1,col);}
               if(col-11>=0){mirarlados(fila,col-1);}
             
             }}
       }
       
       public void despejarvacios(int fila, int col){
           
           
           
          
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
               
             
               if(coldescen>=1){
               coldescen = col-i;
               if(tableroJuego[fila][coldescen]<=1){
                   tableroUsuario[fila][coldescen]=String.valueOf(tableroJuego[fila][coldescen]);
                   if (tableroJuego[fila][coldescen]!=0){
                       coldescen=-9;
                   }                   
                   
               }}
               
               
           }}
       }
    
 
}
