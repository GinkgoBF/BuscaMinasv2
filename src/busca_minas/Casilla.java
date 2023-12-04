/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busca_minas;

import java.awt.Button;
import java.awt.Color;
import java.util.Scanner;
import javax.accessibility.AccessibleContext;

/**
 *
 * @author Ginkgo
 */
public class Casilla extends Button {
    private boolean mina;
    private boolean abierto;
    private boolean marcado;
    private int contador_minas;
    private int fila;
    private int col;

    public Casilla(boolean mina, boolean abierto, int contador_minas) {
        this.mina = mina;
        this.abierto = abierto;
        this.contador_minas = contador_minas;
        this.marcado = false;
    }

    public Casilla(int fila,int col) {
        this.mina = false;
        this.abierto = false;
        this.marcado = false;
        this.contador_minas = 0;
        this.fila=fila;
        this.col=col;
    }

      

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

  

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }
    
    

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    public int getContador_minas() {
        return contador_minas;
    }

    public void setContador_minas(int contador_minas) {
        this.contador_minas = contador_minas;
    }

    @Override
    public String toString() {
        return "Casilla{" + "mina=" + mina + ", abierto=" + abierto + ", marcado=" + marcado + ", contador_minas=" + contador_minas + ", fila=" + fila + ", col=" + col + '}';
    }



    
    
}
