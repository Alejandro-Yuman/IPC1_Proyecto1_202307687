/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import utils.Toolbox;

/**
 *
 * @author Alejandro
 */
public class Register extends JFrame implements ActionListener{

    public Register() {
        
        JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/Aperture.png", 110, 110));
        imageLabel.setBounds(190, 20, 110, 110);
        this.add(imageLabel);
        
        JLabel tituloLabel = new JLabel("Crear cuenta");
        tituloLabel.setBounds(200,140,100,30);
        this.add(tituloLabel);
        
        
        this.setTitle("Registro");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
