/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busca_minas;

/**
 *
 * @author Ginkgo
 */
public class Casilla {
    boolean mina;
    boolean abierto;
    boolean marcado;
    int contador_minas;
    

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

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
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
