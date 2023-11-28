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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ginkgo
 */
public class Ventana extends JFrame{
    public JPanel panel;
    public JPanel gola;
    public Casilla[][] tablero;
    
    public Ventana(){
        this.setSize(500,500); //Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cierre del proceso cuando se cierra ventana
        setTitle("BUSCA MINAS"); //Titulo
        //setLocation(300,100);
        // setBounds(); es equivalente a set default y set location
        setLocationRelativeTo(null);
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        colocarPanel();
        //colocarEtiquetas();
        colocarBotones();  
    }
  
    
    private void colocarBotones(){
    panel.setLayout(new GridLayout(10, 10)); // Establece el layout del panel a una cuadrícula de 10x10 
    this.tablero=new Casilla[11][11];
    for(int i = 1; i < 11; i++){
        for(int j = 1; j < 11; j++){
            tablero[i][j]= new Casilla();
            tablero[i][j].setEnabled(true);
            tablero[i][j].addActionListener(e -> aayuda());
            panel.add(tablero[i][j]);
            
            
        }
    }}
    
    public static void aayuda(){
        System.out.println("AUXILIO");
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
    private void colocarPanel(){
        panel = new JPanel();
        gola = new JPanel();
        gola.setBounds(50, 50, 50, 50);
        //this.getContentPane().add(gola));
        this.getContentPane().add(panel);
    }
    
    private void colocarEtiquetas(){
        
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
