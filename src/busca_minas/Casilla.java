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
    

    public Casilla(boolean mina, boolean abierto, int contador_minas) {
        this.mina = mina;
        this.abierto = abierto;
        this.contador_minas = contador_minas;
    }

    public Casilla() {
        this.mina = false;
        this.abierto = false;
        this.marcado = false;
        this.contador_minas = 0;
        
    }

    
      private void explotacasilla() {
        if (!mina) {
            if (contador_minas == 0) {
                abrirlados(fila, col);
            } else {
                abierto=true;
                this.setEnabled(false);
            }

            return false;
        } else {
            return true;
        }
    }
      
        private void abrirlados(int fila_1, int col_1) {
        for (int x = fila_1 - 1; x <= fila_1 + 1; x++) {
            for (int z = col_1 - 1; z <= col_1 + 1; z++) {
                if (x >= 0 && x < 11 && z >= 0 && z < 11) {
                    if (!tablero[x][z].isAbierto()) {
                        tablero[x][z].setAbierto(true);
                        if (tablero[x][z].getContador_minas() == 0) {
                            abrirlados(x, z);
                        }
                    }
                }
            }
        }
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
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
        return "Casilla{" + "mina=" + mina + ", abierto=" + abierto + ", contador_minas=" + contador_minas + '}';
    }

    
    
}
