/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import conta_usuarios.SesionActual;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import utils.Autenticacion;
import utils.Colors;
import utils.Fuentes;
import utils.Toolbox;

/**
 *
 * @author Alejandro
 */
public class Login extends JFrame implements ActionListener{
    private JTextField codigoField;
    private JPasswordField passwordField;

    public Login(){

        
        JLabel backgroundImageLabel = new JLabel(Toolbox.adjustImage("../imgs/backgroundImage.png", 262, 465));
        backgroundImageLabel.setBounds(0, 0, 262, 465);
        this.add(backgroundImageLabel);
        
        JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/Portal.png", 110, 110));
        imageLabel.setBounds(420, 20, 110, 110);
        this.add(imageLabel);
        
        JLabel tituloLabel = new JLabel("Inicio De Sesión");
        tituloLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        tituloLabel.setBounds(420,140,150,30);
        this.add(tituloLabel);
        
        JLabel codigoLabel = new JLabel("Codigo");
        codigoLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        codigoLabel.setBounds(305,175,100,30);
        this.add(codigoLabel);
        
        codigoField = new JTextField();
        codigoField.setFont(Fuentes.getPrincipalFontSize(11, true));
        codigoField.setBounds(360,180,260,25);
        this.add(codigoField);
        
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        passwordLabel.setBounds(280,217,100,30);
        this.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setFont(Fuentes.getPrincipalFontSize(11, true));
        passwordField.setBounds(360,220,260,25);
        this.add(passwordField);
        
        
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        loginButton.setBounds(410, 260, 150, 25);
        loginButton.setBackground(Colors.principalBotones);
        loginButton.setBorder(new LineBorder(Color.BLACK,2));
        loginButton.addActionListener(this);
        this.add(loginButton);
        
                
        JLabel registerLabel = new JLabel("¿No tienes cuenta?");
        registerLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        registerLabel.setBounds(420,295,150,30);
        this.add(registerLabel);
        
        JButton registerButton = new JButton("¡Registrate aqui!");
        registerButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        registerButton.setBounds(410, 330, 150, 25);
        registerButton.setBackground(Colors.principalBotones);
        registerButton.setBorder(new LineBorder(Color.BLACK,2));
        registerButton.addActionListener(this);
        this.add(registerButton);
        
        this.getContentPane().setBackground(Colors.background);
        this.setTitle("Login");
        this.setSize(670,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Iniciar Sesión")){
            String username = codigoField.getText();
            String password = new String(passwordField.getPassword());
            if(!username.equals("")|| !password.equals("")){
                if (Autenticacion.iniciarSesion(Integer.parseInt(username), password)) {
                    System.out.println("Sesion:" + SesionActual.getNombre());

                    switch (SesionActual.getTipo()) {
                        case 0:
                            MainAdministrador mainAdmin = new MainAdministrador();
                            break;
                        case 1:
                            MainMedico mainMedico = new MainMedico();
                            break;
                        case 2:
                            MainPaciente mainPaciente = new MainPaciente();

                            break;
                        default:
                            throw new AssertionError();
                    }

                    this.setVisible(false);
                    this.dispose();
                } else {
                    Mensaje mensaje = new Mensaje("Usuario o contraseña incorrectos", false);
                }
            }else{
                Mensaje mensaje = new Mensaje("Ingrese todos los campos.", false);
            }
            

            
        }
        if(e.getActionCommand().equals("¡Registrate aqui!")){

            Register register = new Register();
            this.setVisible(false);
            this.dispose();
            
        }
        
    }
    
    
}
