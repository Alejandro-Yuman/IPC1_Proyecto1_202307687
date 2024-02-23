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
import utils.Toolbox;

/**
 *
 * @author Alejandro
 */
public class Login extends JFrame implements ActionListener{
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login(){

        JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/Aperture.png", 110, 110));
        imageLabel.setBounds(190, 20, 110, 110);
        this.add(imageLabel);
        
        JLabel tituloLabel = new JLabel("Inicio De Sesión");
        tituloLabel.setBounds(200,140,100,30);
        this.add(tituloLabel);
        
        JLabel usernameLabel = new JLabel("Codigo");
        usernameLabel.setBounds(75,175,100,30);
        this.add(usernameLabel);
        
        usernameField = new JTextField();
        usernameField.setBounds(130,180,260,25);
        this.add(usernameField);
        
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setBounds(50,217,100,30);
        this.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(130,220,260,25);
        this.add(passwordField);
        
        
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(180, 260, 150, 25);
        loginButton.setBackground(new Color(15, 193, 234));
        loginButton.setBorder(new LineBorder(Color.BLACK,2));
        loginButton.addActionListener(this);
        this.add(loginButton);
        
                
        JLabel registerLabel = new JLabel("¿No tienes cuenta?");
        registerLabel.setBounds(200,290,150,30);
        this.add(registerLabel);
        
        JButton registerButton = new JButton("¡Registrate aqui!");
        registerButton.setBounds(180, 320, 150, 25);
        registerButton.setBackground(new Color(15, 193, 234));
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
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if(Autenticacion.iniciarSesion(Integer.parseInt(username) , password)){
                System.out.println("Si");
                System.out.println("Sesion:"+SesionActual.getNombre());
                
                
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
            }else{
                System.out.println("No");
            }
            
        }
        if(e.getActionCommand().equals("¡Registrate aqui!")){

            Register register = new Register();
            this.setVisible(false);
            this.dispose();
            
        }
        
    }
    
    
}
