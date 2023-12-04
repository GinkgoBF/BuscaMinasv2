/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busca_minas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ginkgo
 */
public class Ventana extends JFrame {

    public JPanel panel;
    public JPanel gola;
    public Casilla[][] tablero;

    ;

    public Ventana() {
        this.tablero = new Casilla[11][11];
        this.setSize(500, 500); //Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cierre del proceso cuando se cierra ventana
        setTitle("BUSCA MINAS"); //Titulo
        //setLocation(300,100);
        // setBounds(); es equivalente a set default y set location
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPanel();
        //colocarEtiquetas();
        colocarBotones();
        iniciarTablero();
        contarMinas();
    }

    private void colocarBotones() {
        panel.setLayout(new GridLayout(10, 10, 2, 2)); // Establece el layout del panel a una cuadrícula de 10x10 
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                final int jfinal = j;
                final int ifinal = i;
                tablero[i][j] = new Casilla();
                tablero[i][j].setEnabled(true);

                /* tablero[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        explotacasilla(ifinal, jfinal);
                        ganar();
                    }
                });*/
                tablero[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            explotacasilla(ifinal, jfinal);
                            ganar();
                        }
                    }
                });

                tablero[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            marcarcasilla(ifinal, jfinal);
                            ganar();
                        }
                    }
                });
                panel.add(tablero[i][j]);
                System.out.println(tablero[i][j].toString());

            }
        }
    }

    private void ganar() {
        boolean ganador = true;
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (!tablero[i][j].isAbierto() && !tablero[i][j].isMarcado()) {
                    ganador = false;
                }
            }
        }
        if (ganador) {
            JOptionPane.showMessageDialog(null, "EN HORA BUENA, HAS GANADO", "OLE", JOptionPane.WARNING_MESSAGE);
            System.exit(0);

        }
    }

    public void iniciarTablero() {
        int num_minas = 5;
        int fil = 0;
        int col = 0;
        //this.tableroJuego= new Casilla[tam+1][tam+1];
        for (int i = 1; i <= num_minas; i++) {
            System.out.println("Intento de minaxd");
            boolean puesto = false;
            do {
                fil = (int) Math.floor(Math.random() * 10 + 1);
                col = (int) Math.floor(Math.random() * 10 + 1);

                if (!tablero[fil][col].isMina()) {
                    tablero[fil][col].setMina(true);
                    puesto = true;
                    System.out.println("Mina Puesta quedan " + (num_minas - i) + " en fila: " + fil + "col: " + col);
                } else {
                    System.out.println("Mina NO Puesta quedan " + (num_minas - i + 1));
                }
            } while (!puesto);
        }
    }

    public void contarMinas() {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (tablero[i][j].isMina()) {
                    System.out.println("Encontré una mina");
                    if (i > 1 && i < 10 && j > 1 && j < 10) {
                        for (int x = i - 1; x <= i + 1; x++) {
                            for (int z = j - 1; z <= j + 1; z++) {

                                tablero[x][z].setContador_minas(tablero[x][z].getContador_minas() + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void marcarcasilla(int fila, int col) {
        tablero[fila][col].setMarcado(true);
        tablero[fila][col].setBackground(Color.yellow);

    }

    private void explotacasilla(int fila, int col) {

        if (!tablero[fila][col].isMina()) {
            if (tablero[fila][col].getContador_minas() == 0) {
                abrirlados(fila, col, 0);
            } else {
                tablero[fila][col].setAbierto(true);
                tablero[fila][col].setEnabled(false);
                tablero[fila][col].setLabel(String.valueOf(tablero[fila][col].getContador_minas()));
                tablero[fila][col].setBackground(Color.white);
            }
        } else {
            JOptionPane.showMessageDialog(null, "TE HA EXTALLADO UNA MINA", "Alerta", JOptionPane.WARNING_MESSAGE);
            System.exit(0);

        }
    }

    private void abrirlados(int fila_1, int col_1, int cont) {
        cont = cont + 1;
        if (cont < 400) {

            //default
            for (int x = fila_1 - 1; x <= fila_1 + 1; x++) {
                for (int z = col_1 - 1; z <= col_1 + 1; z++) {
                    if (x > 0 && x < 11 && z > 0 && z < 11) {
                        //   System.out.println("Voy a abrir casilla" + x +"  "+z);                           
                        if (!tablero[x][z].isAbierto()) {
                            //   System.out.println("Exploto despues");
                            tablero[x][z].setAbierto(true);
                            tablero[x][z].setEnabled(false);
                            tablero[x][z].setLabel(String.valueOf(tablero[x][z].getContador_minas()));
                            tablero[x][z].setBackground(Color.white);
                            if (tablero[x][z].getContador_minas() == 0) {
                                abrirlados(x, z, cont);
                            }
                        }
                    }
                }
            }
        }
    }

    /* private void colocarBotones(){
        for(int i = 1; i<11;i++){
        JButton boton1 = new JButton();
       // boton1.setBounds(100,100,100,40);
        panel.add(boton1);
        boton1.setEnabled(true);//Habilitar, deshabilitar 
        boton1.setText("HOLA");
        boton1.setMnemonic('a');//Establecemos que se pulse cuando alt+a
        }
        
        
    }
     */
    private void colocarPanel() {
        panel = new JPanel();
        gola = new JPanel();
        gola.setBounds(50, 50, 50, 50);
        //this.getContentPane().add(gola));
        this.getContentPane().add(panel);
    }

    private void colocarEtiquetas() {

        //panel.setBackground(Color.GREEN);
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Hola");
        panel.add(etiqueta);

        ImageIcon imagen = new ImageIcon("C:\\Users\\Ginkgo\\Documents\\NetBeansProjects\\Busca_Minas\\src\\busca_minas\\bm.jpg");
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setBounds(100, 50, 100, 50);
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH)));
        panel.add(etiqueta2);
    }
}
