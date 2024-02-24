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
import utils.Fuentes;
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
        
        JLabel backgroundImageLabel = new JLabel(Toolbox.adjustImage("../imgs/backgroundImage_2.png", 301, 535));
        backgroundImageLabel.setBounds(0, 0, 301, 535);
        this.add(backgroundImageLabel);
        
        JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/Portal.png", 110, 110));
        imageLabel.setBounds(465, 20, 110, 110);
        this.add(imageLabel);
        
        JLabel tituloLabel = new JLabel("Crear cuenta");
        tituloLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        tituloLabel.setBounds(480,140,100,30);
        this.add(tituloLabel);
        
        
        //Etiqueta para el nombre del usuario
        JLabel usernameLabel = new JLabel("Nombres");
        usernameLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        usernameLabel.setBounds(340, 180, 80, 20);
        this.add(usernameLabel);
        
        //Campo de texto para el nombre del usuario
        nombreField = new JTextField();
        nombreField.setFont(Fuentes.getPrincipalFontSize(11, true));
        nombreField.setBounds(410, 180, 260, 25);
        this.add(nombreField);
        
        //Etiqueta para el apelldio del usuario
        JLabel apellidoLabel = new JLabel("Apellidos");
        apellidoLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        apellidoLabel.setBounds(340, 220, 80, 20);
        this.add(apellidoLabel);
        
        //Campo de texto para el apellido del usuario
        apellidosField = new JTextField();
        apellidosField.setFont(Fuentes.getPrincipalFontSize(11, true));
        apellidosField.setBounds(410, 220, 260, 25);
        this.add(apellidosField);
        
        
       //Etiqueta para el genero del usuario
        JLabel generoLabel = new JLabel("Género");
        generoLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        generoLabel.setBounds(350, 260, 80, 20);
        this.add(generoLabel);
        
        //Combo Box de genero del usuario
        String[] lista = {"Seleccione una opción","Hombre","Mujer"};
        
        generoComboBox = new JComboBox(lista);
        generoComboBox.setFont(Fuentes.getPrincipalFontSize(12, true));
        generoComboBox.setBounds(410, 260, 260, 25);
        this.add(generoComboBox);
        
        //Etiqueta para el apelldio del usuario
        JLabel edadLabel = new JLabel("Edad");
        edadLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        edadLabel.setBounds(360, 300, 80, 20);
        this.add(edadLabel);
        
        //Campo de texto para el apellido del usuario
        edadField = new JTextField();
        edadField.setFont(Fuentes.getPrincipalFontSize(11, true));
        edadField.setBounds(410, 300, 260, 25);
        this.add(edadField);
        
        //Etiqueta para la contraseña del usuario
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        passwordLabel.setBounds(325, 340, 80, 20);
        this.add(passwordLabel);
        
        //Campo de texto para la contraseña del usuario
        passwordField = new JPasswordField();
        passwordField.setFont(Fuentes.getPrincipalFontSize(11, true));
        passwordField.setBounds(410, 340, 260, 25);
        this.add(passwordField);
        
        //Boton de registro
        JButton crearCuentaButton = new JButton("Crear cuenta");
        crearCuentaButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        crearCuentaButton.setBounds(460,380,150,25);
        crearCuentaButton.setBackground(Colors.principalBotones);
        crearCuentaButton.addActionListener(this);
        this.add(crearCuentaButton);
        
                
        //Etiqueta para volver al login
        JLabel iniciarSesionLabel = new JLabel("¿Ya tienes una cuenta?");
        iniciarSesionLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        iniciarSesionLabel.setBounds(460, 440, 170, 20);
        this.add(iniciarSesionLabel);
        
        //Boton de volver al Login
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        loginButton.setBounds(460,470,150,25);
        loginButton.setBackground(Colors.principalBotones);
        loginButton.addActionListener(this);
        this.add(loginButton);
        
        
        
        this.getContentPane().setBackground(Colors.background);
        this.setTitle("Registro");
        this.setSize(720,570);
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
        
        
        
        if(e.getActionCommand().equals("Iniciar Sesión")){
            Login login = new Login();
            this.setVisible(false);
            this.dispose();
        }
    }
    
}
