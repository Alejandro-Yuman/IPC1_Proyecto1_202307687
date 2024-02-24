/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import utils.Toolbox;
import utils.Colors;

/**
 *
 * @author Alejandro
 */
public class Mensaje extends JFrame implements ActionListener{

    public  Mensaje(String mensajeMostrar, boolean success){
        if(!success){
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/AlertaIcon.png", 30, 30));
            imageLabel.setBounds(10, 20, 30, 30);
            this.add(imageLabel);
        }else{
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/CorrectoIcon.png", 30, 30));
            imageLabel.setBounds(10, 20, 30, 30);
            this.add(imageLabel);
        }
        
        if(mensajeMostrar.length() <= 55){
            JLabel mensajeLabel = new JLabel(mensajeMostrar);
            mensajeLabel.setBounds(50, 25, 300, 20);
            this.add(mensajeLabel);
        }else{
            String[] palabras = mensajeMostrar.split("\\s+");
            String temporal = "";
            int pos = 25;
            for (int i = 0; i < palabras.length; i++) {
                if (temporal.length() <= 50) {
                    temporal += " " + palabras[i];
                } else {
                    JLabel mensajeLabel = new JLabel(temporal);
                    mensajeLabel.setBounds(50, pos, 300, 20);
                    this.add(mensajeLabel);
                    temporal = "";
                    temporal += palabras[i];
                    pos +=20;
                }
            }
            JLabel mensajeLabel = new JLabel(temporal);
            mensajeLabel.setBounds(50, pos, 300, 20);
            this.add(mensajeLabel);
        }
        
        
        
        
        
        
        


        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.setBounds(125, 100, 150, 50);
        aceptarButton.setBackground(Colors.principal);
        aceptarButton.addActionListener(this);
        this.add(aceptarButton);
        
        
        
        this.setTitle("Alerta");
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Aceptar")){
            this.setVisible(false);
            this.dispose();
            
        }
    }
    
    
}
