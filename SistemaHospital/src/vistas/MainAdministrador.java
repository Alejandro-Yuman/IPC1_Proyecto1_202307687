/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import conta_usuarios.ListaUsuarios;
import conta_usuarios.SesionActual;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.LineBorder;
import objetos.Medico;
import utils.Colors;
import utils.Toolbox;
import utils.Fuentes;

/**
 *
 * @author Alejandro
 */
public class MainAdministrador extends JFrame implements ActionListener{

    JTextField nombreField;
    JTextField ApellidoField;
    JTextField EspecialidadField;
    JTextField TelefonoField;
    JPasswordField passwordField;
    JTextField edadField;
    JComboBox generoComboBox;
    
    public MainAdministrador() {
        JLabel logoLabel = new JLabel(Toolbox.adjustImage("../imgs/LogoCompleto.png", 110, 30));
        logoLabel.setBounds(10, 10, 110, 30);
        this.add(logoLabel);
        
        JLabel cakeLabel = new JLabel(Toolbox.adjustImage("../imgs/Cake.png", 50, 50));
        cakeLabel.setBounds(1110, 10, 50, 50);
        this.add(cakeLabel);
        
        
        JLabel tipoUsuarioLabel = new JLabel("Administrador");
        tipoUsuarioLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        tipoUsuarioLabel.setBounds(150,10,170,30);
        this.add(tipoUsuarioLabel);
        
        JLabel tituloLabel = new JLabel("Nombre: "+SesionActual.getNombre());
        tituloLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        tituloLabel.setBounds(350,10,200,30);
        this.add(tituloLabel);

        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        //---------------------------------------Pestaña Doctores
        JPanel panelDoctores = new JPanel();
        panelDoctores.setLayout(null);
        panelDoctores.setBackground(Colors.white);
        tabbedPane.addTab("Doctores", panelDoctores);
        tabbedPane.setFont(Fuentes.getPrincipalFontSize(12, true));
        
        JLabel tituloDoctoresLabel = new JLabel("Listado de Doctores");
        tituloDoctoresLabel.setBounds(10,10,200,30);
        tituloDoctoresLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelDoctores.add(tituloDoctoresLabel);
        
        //Tabla de Medicos
        ArrayList<Medico> listaMedicos = ListaUsuarios.getMedicos();

        Object[][] datos = new Object[listaMedicos.size()][7];
        for (int i = 0; i < listaMedicos.size(); i++) {
            datos[i][0]=listaMedicos.get(i).getId();
            datos[i][1]=listaMedicos.get(i).getNombre();
            datos[i][2]=listaMedicos.get(i).getApellido();
            datos[i][3]=listaMedicos.get(i).getSexo();
            datos[i][4]=listaMedicos.get(i).getEdad();
            datos[i][5]=listaMedicos.get(i).getEspecialidad();
            datos[i][6]=listaMedicos.get(i).getTelefono();
            
        }

        String[] columnas = {"Codigo","Nombre","Apellidos","Género","Edad","Especialidad","Telefono"};
        
        JTable tabla = new JTable(datos, columnas);
        tabla.setFont(Fuentes.getPrincipalFontSize(11,false));
        JScrollPane sp = new JScrollPane(tabla);
        sp.setBounds(10, 50, 900, 500);
        panelDoctores.add(sp);
        //Fin tabla
        
        JButton bottonCrearDoctor = new JButton("Crear doctor");
        bottonCrearDoctor.setBounds(950,50,150,50);
        bottonCrearDoctor.setBackground(Colors.principalBotones);
        bottonCrearDoctor.setFont(Fuentes.getPrincipalFontSize(12, true));
        bottonCrearDoctor.addActionListener(this);
        panelDoctores.add(bottonCrearDoctor);
        
        JButton bottonActualizarDoctor = new JButton("Actualizar doctor");
        bottonActualizarDoctor.setBounds(950,120,150,50);
        bottonActualizarDoctor.setBackground(Colors.principalBotones);
        bottonActualizarDoctor.setFont(Fuentes.getPrincipalFontSize(12, true));
        bottonActualizarDoctor.addActionListener(this);
        panelDoctores.add(bottonActualizarDoctor);
        
        JButton bottonEliminarDoctor = new JButton("Eliminar doctor");
        bottonEliminarDoctor.setBounds(950,190,150,50);
        bottonEliminarDoctor.setBackground(Colors.principalBotones);
        bottonEliminarDoctor.setFont(Fuentes.getPrincipalFontSize(12, true));
        bottonEliminarDoctor.addActionListener(this);
        panelDoctores.add(bottonEliminarDoctor);

        //---------------------------------------Fin Pestaña Doctores

        
        
        //---------------------------------------Pestaña Pacientes
        JPanel panelPacientes = new JPanel();
        panelPacientes.setLayout(null);
        panelPacientes.setBackground(Colors.white);
        tabbedPane.addTab("Pacientes", panelPacientes);
        //---------------------------------------Fin Pestaña Pacientes
        
        
        
        
        //---------------------------------------Pestaña Productos
        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(null);
        panelProductos.setBackground(Colors.white);
        tabbedPane.addTab("Productos", panelProductos);
        //---------------------------------------Fin Pestaña Productos
        
        
        
        
        tabbedPane.setBackground(Colors.white);
        tabbedPane.setBounds(10, 50, 1150, 600);
        this.add(tabbedPane);
        
        
        
        this.getContentPane().setBackground(Colors.background);
        this.setTitle("Menu Principal");
        this.setSize(1200,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialogo = new JDialog(this);
        if(e.getActionCommand().equals("Crear doctor")){
            
            
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/Crear.png", 40, 40));
            imageLabel.setBounds(10, 10, 40, 40);
            dialogo.add(imageLabel);


            
            JLabel tituloLabel = new JLabel("Crear Doctor");
            tituloLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            tituloLabel.setBounds(60, 5, 100, 50);
            dialogo.add(tituloLabel);
            
            JLabel nombresLabel = new JLabel("Nombres");
            nombresLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            nombresLabel.setBounds(30, 70, 100, 30);
            dialogo.add(nombresLabel);

            nombreField = new JTextField();
            nombreField.setBounds(110,70,200,30);
            dialogo.add(nombreField);
            
            JLabel apellidosLabel = new JLabel("Apellidos");
            apellidosLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            apellidosLabel.setBounds(415, 70, 100, 30);
            dialogo.add(apellidosLabel);

            ApellidoField = new JTextField();
            ApellidoField.setBounds(500,70,200,30);
            dialogo.add(ApellidoField);
            
            JLabel especialidadLabel = new JLabel("Especialidad");
            especialidadLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            especialidadLabel.setBounds(10, 120, 100, 30);
            dialogo.add(especialidadLabel);

            EspecialidadField = new JTextField();
            EspecialidadField.setBounds(110,120,200,30);
            dialogo.add(EspecialidadField);
            
            JLabel telefonoLabel = new JLabel("Teléfono");
            telefonoLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            telefonoLabel.setBounds(420, 120, 100, 30);
            dialogo.add(telefonoLabel);

            TelefonoField = new JTextField();
            TelefonoField.setBounds(500,120,200,30);
            dialogo.add(TelefonoField);
            
            JLabel passwordLabel = new JLabel("Contraseña");
            passwordLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            passwordLabel.setBounds(15, 170, 100, 30);
            dialogo.add(passwordLabel);
            
            passwordField = new JPasswordField();
            passwordField.setBounds(110, 170, 200, 30);
            dialogo.add(passwordField);
            
            JLabel edadLabel = new JLabel("Edad");
            edadLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            edadLabel.setBounds(440, 170, 100, 30);
            dialogo.add(edadLabel);
            
            edadField = new JPasswordField();
            edadField.setBounds(500, 170, 200, 30);
            dialogo.add(edadField);
            
            JLabel generoLabel = new JLabel("Género");
            generoLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            generoLabel.setBounds(40, 220, 100, 30);
            dialogo.add(generoLabel);
            
            String[] lista = {"Seleccione una opción","Hombre","Mujer"};
            generoComboBox = new JComboBox(lista);
            generoComboBox.setBounds(110, 220, 200, 30);
            dialogo.add(generoComboBox);
            
            JButton loginButton = new JButton("Crear Doctor");
            loginButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            loginButton.setBounds(320, 300, 150, 25);
            loginButton.setBackground(Colors.principalBotones);
            loginButton.setBorder(new LineBorder(Color.BLACK, 2));
            loginButton.addActionListener(this);
            dialogo.add(loginButton);
            
            JLabel logoLabel = new JLabel(Toolbox.adjustImage("../imgs/LogoCompleto.png", 110, 30));
            logoLabel.setBounds(650, 320, 110, 30);
            dialogo.add(logoLabel);
            
            dialogo.setTitle("Crear Doctor");
            dialogo.setSize(800,400);
            dialogo.setLayout(null);
            dialogo.setResizable(false);
            dialogo.setLocationRelativeTo(null);
            dialogo.getContentPane().setBackground(Colors.background);
            dialogo.setVisible(true);
            
            
        }
        
        if(e.getActionCommand().equals("Crear Doctor")){
            String nombre = nombreField.getText();
            String apellidos = ApellidoField.getText();
            String especialidad = EspecialidadField.getText();
            String telefono = TelefonoField.getText();

            String password = new String(passwordField.getPassword());
            int edad;
            if(!"".equals(edadField.getText())){
                try {
                    edad = Integer.parseInt(edadField.getText());
                } catch (NumberFormatException NFE) {
                    edad = 0;
                }
                
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
            boolean falla = false;
            try {
                Integer.parseInt(telefono);
            } catch (NumberFormatException NFE) {
                falla = true;
            }
            
            

            if (!nombre.equals("") && !apellidos.equals("") && !password.equals("")&& !especialidad.equals("")&& !telefono.equals("")) {

                if (genero != 'X') {
                    if (edad >= 1 && edad <= 100) {
                        if(!falla){
                            Medico pac = new Medico(nombre, apellidos, edad, genero, password, Integer.parseInt(telefono), especialidad);
                            ListaUsuarios.addUsuarios(pac);
                            MainAdministrador mainAdmin = new MainAdministrador();
                            this.setVisible(false);
                            this.dispose();
                            System.out.println("XD2");
                        }else{
                            Mensaje mensaje = new Mensaje("Ingrese un numero de teléfono correcto",false);
                        }

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
        
        
        
        
        
        
        
        
        if(e.getActionCommand().equals("Actualizar doctor")){
            
           
        }
        if(e.getActionCommand().equals("Eliminar doctor")){

            
        }
    }
    
    
    
    
}
