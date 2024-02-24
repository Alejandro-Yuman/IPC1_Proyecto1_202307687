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
import utils.Toolbox;

/**
 *
 * @author Alejandro
 */
public class Login extends JFrame implements ActionListener{
    private JTextField codigoField;
    private JPasswordField passwordField;

    public Login(){

        JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/Aperture.png", 110, 110));
        imageLabel.setBounds(190, 20, 110, 110);
        this.add(imageLabel);
        
        JLabel tituloLabel = new JLabel("Inicio De Sesión");
        tituloLabel.setBounds(200,140,100,30);
        this.add(tituloLabel);
        
        JLabel codigoLabel = new JLabel("Codigo");
        codigoLabel.setBounds(75,175,100,30);
        this.add(codigoLabel);
        
        codigoField = new JTextField();
        codigoField.setBounds(130,180,260,25);
        this.add(codigoField);
        
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setBounds(50,217,100,30);
        this.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(130,220,260,25);
        this.add(passwordField);
        
        
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(180, 260, 150, 25);
        loginButton.setBackground(Colors.principal);
        loginButton.setBorder(new LineBorder(Color.BLACK,2));
        loginButton.addActionListener(this);
        this.add(loginButton);
        
                
        JLabel registerLabel = new JLabel("¿No tienes cuenta?");
        registerLabel.setBounds(200,295,150,30);
        this.add(registerLabel);
        
        JButton registerButton = new JButton("¡Registrate aqui!");
        registerButton.setBounds(180, 330, 150, 25);
        registerButton.setBackground(Colors.principal);
        registerButton.setBorder(new LineBorder(Color.BLACK,2));
        registerButton.addActionListener(this);
        this.add(registerButton);
        
        this.setTitle("Login");
        this.setSize(500,500);
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

                            break;
                        case 1:
                            MainMedico mainMedico = new MainMedico();
                            break;
                        case 2:
                            MainMedico mainMedico2 = new MainMedico();

                            break;
                        default:
                            throw new AssertionError();
                    }

                    this.setVisible(false);
                    this.dispose();
                } else {
                    Mensaje mensaje = new Mensaje("Usuario o contraseña incorrectos3", false);
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
