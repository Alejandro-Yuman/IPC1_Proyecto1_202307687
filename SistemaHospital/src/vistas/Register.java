/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import conta_usuarios.ListaUsuarios;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import objetos.Paciente;
import utils.Colors;
import utils.Toolbox;

/**
 *
 * @author Alejandro
 */
public class Register extends JFrame implements ActionListener{

    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField edadField;
    private JComboBox generoComboBox;
    private JPasswordField passwordField;
    
    public Register() {
        
        JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/Aperture.png", 110, 110));
        imageLabel.setBounds(190, 20, 110, 110);
        this.add(imageLabel);
        
        JLabel tituloLabel = new JLabel("Crear cuenta");
        tituloLabel.setBounds(200,140,100,30);
        this.add(tituloLabel);
        
        
        //Etiqueta para el nombre del usuario
        JLabel usernameLabel = new JLabel("Nombres");
        usernameLabel.setBounds(70, 180, 80, 20);
        this.add(usernameLabel);
        
        //Campo de texto para el nombre del usuario
        nombreField = new JTextField();
        nombreField.setBounds(130, 180, 260, 25);
        this.add(nombreField);
        
        //Etiqueta para el apelldio del usuario
        JLabel apellidoLabel = new JLabel("Apellidos");
        apellidoLabel.setBounds(70, 220, 80, 20);
        this.add(apellidoLabel);
        
        //Campo de texto para el apellido del usuario
        apellidosField = new JTextField();
        apellidosField.setBounds(130, 220, 260, 25);
        this.add(apellidosField);
        
        
       //Etiqueta para el genero del usuario
        JLabel generoLabel = new JLabel("Género");
        generoLabel.setBounds(80, 260, 80, 20);
        this.add(generoLabel);
        
        //Combo Box de genero del usuario
        String[] lista = {"Seleccione una opción","Hombre","Mujer"};
        generoComboBox = new JComboBox(lista);
        generoComboBox.setBounds(130, 260, 260, 25);
        this.add(generoComboBox);
        
        //Etiqueta para el apelldio del usuario
        JLabel edadLabel = new JLabel("Edad");
        edadLabel.setBounds(90, 300, 80, 20);
        this.add(edadLabel);
        
        //Campo de texto para el apellido del usuario
        edadField = new JTextField();
        edadField.setBounds(130, 300, 260, 25);
        this.add(edadField);
        
        //Etiqueta para la contraseña del usuario
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setBounds(55, 340, 80, 20);
        this.add(passwordLabel);
        
        //Campo de texto para la contraseña del usuario
        passwordField = new JPasswordField();
        passwordField.setBounds(130, 340, 260, 25);
        this.add(passwordField);
        
        //Boton de registro
        JButton loginButton = new JButton("Crear cuenta");
        loginButton.setBounds(180,380,150,25);
        loginButton.setBackground(Colors.principal);
        loginButton.addActionListener(this);
        this.add(loginButton);
        
        
        
        
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
        if(e.getActionCommand().equals("Crear cuenta")){
            String nombre = nombreField.getText();
            String apellidos = apellidosField.getText();
            String password = new String(passwordField.getPassword());
            int edad;
            if(!"".equals(edadField.getText())){
                edad = Integer.parseInt(edadField.getText());
            }else{
                edad = 0;
            }
             
            char genero;
            switch (generoComboBox.getSelectedIndex()) {
                case 0:
                    genero = 'X';
                    break;
                case 1:
                    genero = 'M';
                    break;
                case 2:
                    genero = 'F';
                    break;
                default:
                    throw new AssertionError();
            }
            
            if (!nombre.equals("") && !apellidos.equals("") && !password.equals("")) {
                
                if (genero != 'X') {
                    if (edad >= 1 && edad <= 100) {
                        Paciente pac = new Paciente(nombre, apellidos, edad, genero, password);
                        ListaUsuarios.addUsuarios(pac);
                        Login login = new Login();
                        this.setVisible(false);
                        this.dispose();
                    } else {
                        Mensaje mensaje = new Mensaje("Ingrese una edad correcta.", false);
                    }

                } else {
                    Mensaje mensaje = new Mensaje("Seleccione un genero.", false);
                }
                


            } else {
                Mensaje mensaje = new Mensaje("Ingrese todos los campos  obligatorios.", false);
            }
            

        }
    }
    
}
