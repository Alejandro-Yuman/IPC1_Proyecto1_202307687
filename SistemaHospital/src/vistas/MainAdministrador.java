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
import objetos.Usuario;
import utils.Colors;
import utils.Toolbox;
import utils.Fuentes;

/**
 *
 * @author Alejandro
 */
public class MainAdministrador extends JFrame implements ActionListener{

    JTextField codigoField;
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
        
        JButton botonCrearDoctor = new JButton("Crear doctor");
        botonCrearDoctor.setBounds(950,50,150,50);
        botonCrearDoctor.setBackground(Colors.principalBotones);
        botonCrearDoctor.setFont(Fuentes.getPrincipalFontSize(12, true));
        botonCrearDoctor.setForeground(Colors.white);
        botonCrearDoctor.addActionListener(this);
        panelDoctores.add(botonCrearDoctor);
        
        JButton botonActualizarDoctor = new JButton("Actualizar doctor");
        botonActualizarDoctor.setBounds(950,120,150,50);
        botonActualizarDoctor.setBackground(Colors.principalBotones);
        botonActualizarDoctor.setForeground(Colors.white);
        botonActualizarDoctor.setFont(Fuentes.getPrincipalFontSize(12, true));
        botonActualizarDoctor.addActionListener(this);
        panelDoctores.add(botonActualizarDoctor);
        
        JButton botonEliminarDoctor = new JButton("Eliminar doctor");
        botonEliminarDoctor.setBounds(950,190,150,50);
        botonEliminarDoctor.setBackground(Colors.principalBotones);
        botonEliminarDoctor.setForeground(Colors.white);
        botonEliminarDoctor.setFont(Fuentes.getPrincipalFontSize(12, true));
        botonEliminarDoctor.addActionListener(this);
        panelDoctores.add(botonEliminarDoctor);

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
            
            JSeparator separador = new JSeparator();
            separador.setBounds(0, 60, 1000, 1);
            dialogo.add(separador);
            
            JLabel nombresLabel = new JLabel("Nombres");
            nombresLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            nombresLabel.setBounds(30, 90, 100, 30);
            dialogo.add(nombresLabel);

            nombreField = new JTextField();
            nombreField.setBounds(110,90,200,30);
            dialogo.add(nombreField);
            
            JLabel apellidosLabel = new JLabel("Apellidos");
            apellidosLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            apellidosLabel.setBounds(415, 90, 100, 30);
            dialogo.add(apellidosLabel);

            ApellidoField = new JTextField();
            ApellidoField.setBounds(500,90,200,30);
            dialogo.add(ApellidoField);
            
            JLabel especialidadLabel = new JLabel("Especialidad");
            especialidadLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            especialidadLabel.setBounds(10, 140, 100, 30);
            dialogo.add(especialidadLabel);

            EspecialidadField = new JTextField();
            EspecialidadField.setBounds(110,140,200,30);
            dialogo.add(EspecialidadField);
            
            JLabel telefonoLabel = new JLabel("Teléfono");
            telefonoLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            telefonoLabel.setBounds(420, 140, 100, 30);
            dialogo.add(telefonoLabel);

            TelefonoField = new JTextField();
            TelefonoField.setBounds(500,140,200,30);
            dialogo.add(TelefonoField);
            
            JLabel passwordLabel = new JLabel("Contraseña");
            passwordLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            passwordLabel.setBounds(15, 190, 100, 30);
            dialogo.add(passwordLabel);
            
            passwordField = new JPasswordField();
            passwordField.setBounds(110, 190, 200, 30);
            dialogo.add(passwordField);
            
            JLabel edadLabel = new JLabel("Edad");
            edadLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            edadLabel.setBounds(440, 190, 100, 30);
            dialogo.add(edadLabel);
            
            edadField = new JTextField();
            edadField.setBounds(500, 190, 200, 30);
            dialogo.add(edadField);
            
            JLabel generoLabel = new JLabel("Género");
            generoLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            generoLabel.setBounds(40, 240, 100, 30);
            dialogo.add(generoLabel);
            
            String[] lista = {"Seleccione una opción","Hombre","Mujer"};
            generoComboBox = new JComboBox(lista);
            generoComboBox.setBounds(110, 240, 200, 30);
            dialogo.add(generoComboBox);
            
            JButton crearButton = new JButton("Guardar");
            crearButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            crearButton.setBounds(320, 320, 150, 25);
            crearButton.setBackground(Colors.principalBotones);
            crearButton.setForeground(Colors.white);
            crearButton.addActionListener(this);
            dialogo.add(crearButton);
            
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
        
        if(e.getActionCommand().equals("Guardar")){
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
                        
            
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/Crear.png", 40, 40));
            imageLabel.setBounds(10, 10, 40, 40);
            dialogo.add(imageLabel);


            
            JLabel tituloLabel = new JLabel("Actualizar Doctor");
            tituloLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            tituloLabel.setBounds(60, 5, 200, 50);
            dialogo.add(tituloLabel);
            
            JSeparator separador = new JSeparator();
            separador.setBounds(0, 60, 1000, 1);
            dialogo.add(separador);
            
            
            
            JLabel codigosLabel = new JLabel("Codigo");
            codigosLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            codigosLabel.setBounds(30, 90, 100, 30);
            dialogo.add(codigosLabel);

            codigoField = new JTextField();
            codigoField.setBounds(110,90,200,30);
            dialogo.add(codigoField);
            
            JButton buscarButton = new JButton("Buscar");
            buscarButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            buscarButton.setBounds(500, 90, 150, 30);
            buscarButton.setBackground(Colors.principalBotones);
            buscarButton.setForeground(Colors.white);
            buscarButton.addActionListener(this);
            dialogo.add(buscarButton);
            
            
            JSeparator separador2 = new JSeparator();
            separador.setBounds(0, 140, 1000, 1);
            dialogo.add(separador);
            
            
            
            JLabel nombresLabel = new JLabel("Nombres");
            nombresLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            nombresLabel.setBounds(30, 170, 100, 30);
            dialogo.add(nombresLabel);

            nombreField = new JTextField();
            nombreField.setBounds(110,170,200,30);
            nombreField.setEditable(false);
            dialogo.add(nombreField);
            
            JLabel apellidosLabel = new JLabel("Apellidos");
            apellidosLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            apellidosLabel.setBounds(415, 170, 100, 30);
            dialogo.add(apellidosLabel);

            ApellidoField = new JTextField();
            ApellidoField.setBounds(500,170,200,30);
            ApellidoField.setEditable(false);
            dialogo.add(ApellidoField);
            
            JLabel especialidadLabel = new JLabel("Especialidad");
            especialidadLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            especialidadLabel.setBounds(10, 220, 100, 30);
            dialogo.add(especialidadLabel);

            EspecialidadField = new JTextField();
            EspecialidadField.setBounds(110,220,200,30);
            EspecialidadField.setEditable(false);
            dialogo.add(EspecialidadField);
            
            JLabel telefonoLabel = new JLabel("Teléfono");
            telefonoLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            telefonoLabel.setBounds(420, 220, 100, 30);
            dialogo.add(telefonoLabel);

            TelefonoField = new JTextField();
            TelefonoField.setBounds(500,220,200,30);
            TelefonoField.setEditable(false);
            dialogo.add(TelefonoField);
            
            JLabel passwordLabel = new JLabel("Contraseña");
            passwordLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            passwordLabel.setBounds(15, 270, 100, 30);
            dialogo.add(passwordLabel);
            
            passwordField = new JPasswordField();
            passwordField.setBounds(110, 270, 200, 30);
            passwordField.setEditable(false);
            dialogo.add(passwordField);
            
            JLabel edadLabel = new JLabel("Edad");
            edadLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            edadLabel.setBounds(440, 270, 100, 30);
            dialogo.add(edadLabel);
            
            edadField = new JTextField();
            edadField.setBounds(500, 270, 200, 30);
            edadField.setEditable(false);
            dialogo.add(edadField);
            
            JLabel generoLabel = new JLabel("Género");
            generoLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            generoLabel.setBounds(40, 320, 100, 30);
            dialogo.add(generoLabel);
            
            String[] lista = {"Seleccione una opción","Hombre","Mujer"};
            generoComboBox = new JComboBox(lista);
            generoComboBox.setBounds(110, 320, 200, 30);
            generoComboBox.setEnabled(false);
            dialogo.add(generoComboBox);
            
            
            
            JButton actualizarButton = new JButton("Editar");
            actualizarButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            actualizarButton.setBounds(320, 420, 150, 25);
            actualizarButton.setBackground(Colors.principalBotones);
            actualizarButton.setForeground(Colors.white);
            actualizarButton.addActionListener(this);
            dialogo.add(actualizarButton);
            
            JLabel logoLabel = new JLabel(Toolbox.adjustImage("../imgs/LogoCompleto.png", 110, 30));
            logoLabel.setBounds(650, 420, 110, 30);
            dialogo.add(logoLabel);
            
            
            
            
            dialogo.setTitle("Actualizar Doctor");
            dialogo.setSize(800,500);
            dialogo.setLayout(null);
            dialogo.setResizable(false);
            dialogo.setLocationRelativeTo(null);
            dialogo.getContentPane().setBackground(Colors.background);
            dialogo.setVisible(true);
            
           
        }
        
        if(e.getActionCommand().equals("Buscar")){
            int codigo;
            boolean error =false;
            Medico medico;
            Usuario usuarioTemp;
            try {
                codigo = Integer.parseInt(codigoField.getText());
            } catch (NumberFormatException NFE) {
                error = true;
                codigo=0;
            }
            if(!error){
                usuarioTemp =ListaUsuarios.getUsuario(codigo);
                if(usuarioTemp instanceof Medico){
                    medico = (Medico)usuarioTemp;
                    nombreField.setText(medico.getNombre());
                    ApellidoField.setText(medico.getApellido());
                    EspecialidadField.setText(medico.getEspecialidad());
                    TelefonoField.setText(Integer.toString(medico.getTelefono()));
                    passwordField.setText(medico.getContraseña());
                    edadField.setText(Integer.toString(medico.getEdad()));
                    
                    
                    nombreField.setEditable(true);
                    ApellidoField.setEditable(true);
                    EspecialidadField.setEditable(true);
                    TelefonoField.setEditable(true);
                    passwordField.setEditable(true);
                    edadField.setEditable(true);
                    generoComboBox.setEnabled(true);
                    if(medico.getSexo() == 'M'){
                        generoComboBox.setSelectedIndex(1);
                    }else if(medico.getSexo() == 'F'){
                        generoComboBox.setSelectedIndex(2);
                    }
                    
                    
                    
                }else{
                    if(usuarioTemp == null){
                        Mensaje mensaje = new Mensaje("El usuario ingresado no existe",false);
                    }else{
                        Mensaje mensaje = new Mensaje("El usuario ingresado no es un Medico",false);
                    }
                    
                }
            }else{
                Mensaje mensaje = new Mensaje("Ingrese un codigo correcto.",false);
            }
            
        }
        
        if(e.getActionCommand().equals("Editar")){
            
            int codigo;
            boolean error =false;
            try {
                codigo = Integer.parseInt(codigoField.getText());
            } catch (NumberFormatException NFE) {
                error = true;
                codigo=0;
            }
            
            
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
                            if(!error){
                                Medico medicoNuevo = new Medico(nombre, apellidos, edad, genero, password, Integer.parseInt(telefono), especialidad);
                                medicoNuevo.setId(codigo);
                                ListaUsuarios.editUsuario(medicoNuevo, codigo);
                                MainAdministrador mainAdmin = new MainAdministrador();
                                this.setVisible(false);
                                this.dispose();
                            }else{
                                Mensaje mensaje = new Mensaje("Ingrese un codigo correcto.",false);
                            }
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
        
        
        
        
        if(e.getActionCommand().equals("Eliminar doctor")){
            JLabel iconoLabel = new JLabel(Toolbox.adjustImage("../imgs/eliminar.png", 30, 30));
            iconoLabel.setBounds(10, 10, 30, 30);
            dialogo.add(iconoLabel);
            
            JLabel eliminarLabel = new JLabel("<html>Ingrese el codigo del Doctor a eliminar</html>");
            eliminarLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            eliminarLabel.setBounds(50, 10, 300, 30);
            dialogo.add(eliminarLabel);
            
            codigoField = new JTextField();
            codigoField.setBounds(60, 60, 260, 30);
            dialogo.add(codigoField);
            
            JButton eliminarButton = new JButton("Eliminar");
            eliminarButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            eliminarButton.setBounds(115, 125, 150, 25);
            eliminarButton.setBackground(Colors.principalBotones);
            eliminarButton.setForeground(Colors.white);
            eliminarButton.addActionListener(this);
            dialogo.add(eliminarButton);
            
            JLabel logoLabel = new JLabel(Toolbox.adjustImage("../imgs/LogoCompleto.png", 110, 30));
            logoLabel.setBounds(265, 175, 110, 30);
            dialogo.add(logoLabel);
            
            dialogo.setTitle("Eliminar Doctor");
            dialogo.setSize(400,250);
            dialogo.setLayout(null);
            dialogo.setResizable(false);
            dialogo.setLocationRelativeTo(null);
            dialogo.getContentPane().setBackground(Colors.background);
            dialogo.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Eliminar")){
            int codigo;
            boolean error =false;
            try {
                codigo = Integer.parseInt(codigoField.getText());
            } catch (NumberFormatException NFE) {
                error = true;
                codigo=0;
            }
            if(!error){
                if(ListaUsuarios.getUsuario(codigo) != null){
                    if(ListaUsuarios.getUsuario(codigo) instanceof Medico){
                        ListaUsuarios.eliminarUsuario(codigo);
                        MainAdministrador mainAdmin = new MainAdministrador();
                        this.setVisible(false);
                        this.dispose();
                    }else{
                        Mensaje mensaje = new Mensaje("El usuario no es un Medico.",false);
                    }
                }else{
                    Mensaje mensaje = new Mensaje("El usuario no existe.",false);
                }

            }else{
                Mensaje mensaje = new Mensaje("Ingrese un codigo correcto.",false);
            }
        }
        
    }
    
    
    
    
}
