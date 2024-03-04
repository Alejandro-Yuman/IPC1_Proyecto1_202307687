/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import conta_usuarios.ListaHorarios;
import conta_usuarios.ListaProductos;
import conta_usuarios.ListaUsuarios;
import conta_usuarios.SesionActual;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import objetos.Horario;
import objetos.Medico;
import objetos.Producto;
import objetos.Usuario;
import utils.Autenticacion;
import utils.Colors;
import utils.Fuentes;
import utils.Toolbox;

/**
 *
 * @author Alejandro
 */
public class MainMedico extends JFrame implements ActionListener{
    JTabbedPane tabbedPane;
        
    JTextField nombreField;
    JTextField apellidoField;
    JPasswordField passwordField;
    JTextField edadField;
    JTextField especialidadField;

    public MainMedico() {
        
        JLabel logoLabel = new JLabel(Toolbox.adjustImage("../imgs/LogoCompleto.png", 110, 30));
        logoLabel.setBounds(10, 10, 110, 30);
        this.add(logoLabel);
        
        JButton cerrarSesionButton = new JButton("Cerrar Sesion");
        cerrarSesionButton.setBounds(950,10,150,50);
        cerrarSesionButton.setBackground(Colors.principalBotones);
        cerrarSesionButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        cerrarSesionButton.setForeground(Colors.white);
        cerrarSesionButton.addActionListener(this);
        this.add(cerrarSesionButton);
        
        JButton editarPerfilButton = new JButton("Editar Perfil");
        editarPerfilButton.setBounds(790,10,150,50);
        editarPerfilButton.setBackground(Colors.principalBotones);
        editarPerfilButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        editarPerfilButton.setForeground(Colors.white);
        editarPerfilButton.addActionListener(this);
        this.add(editarPerfilButton);
        
        JButton pastelButton = new JButton();
        pastelButton.setName("Pastel");
        pastelButton.setIcon(Toolbox.adjustImage("../imgs/Cake.png", 50, 50));
        pastelButton.setBounds(1110, 10, 50, 50);
        pastelButton.setBorder(null);
        this.add(pastelButton);
        
        JLabel tipoUsuarioLabel = new JLabel("Medico");
        tipoUsuarioLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        tipoUsuarioLabel.setBounds(150,10,170,30);
        this.add(tipoUsuarioLabel);
        
        JLabel tituloLabel = new JLabel("Nombre: "+SesionActual.getNombre());
        tituloLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        tituloLabel.setBounds(350,10,400,30);
        this.add(tituloLabel);
        
        tabbedPane = new JTabbedPane();
        
        
        //---------------------------------------Pestaña er Citas
        JPanel panelSolicitar = new JPanel();
        panelSolicitar.setLayout(null);
        panelSolicitar.setBackground(Colors.background);
        tabbedPane.addTab("Citas", panelSolicitar);
        tabbedPane.setFont(Fuentes.getPrincipalFontSize(12, true));
        
        JLabel tituloCitasLabel = new JLabel("Tus Citas");
        tituloCitasLabel.setBounds(10,10,200,30);
        tituloCitasLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelSolicitar.add(tituloCitasLabel);
        
        JButton actualizarCita = new JButton("Actualizar");
        actualizarCita.setBounds(20,510,150,40);
        actualizarCita.setBackground(Colors.principalBotones);
        actualizarCita.setFont(Fuentes.getPrincipalFontSize(12, true));
        actualizarCita.setForeground(Colors.white);
        actualizarCita.addActionListener(this);
        panelSolicitar.add(actualizarCita);
        
        
        
        //----------------------------------Inicio Citas
        JPanel principal = new JPanel();
        principal.setLayout(new GridBagLayout());
        principal.setBackground(Colors.background);
        
        ArrayList<Horario> horarios = ListaHorarios.getHorarios();
        ArrayList<Horario> horariosFiltrados = new ArrayList<Horario>();

        for (int j = 0; j < horarios.size(); j++) {
            if (horarios.get(j).getId_Medico() == SesionActual.getId()) {
                horariosFiltrados.add(horarios.get(j));
            }
        }
        
        int contadorPaneles = 0;
        for (int i = 0; i < horariosFiltrados.size(); i++) {
            int idPac =horariosFiltrados.get(i).getId_Paciente();
            if(idPac != -1 && !horariosFiltrados.get(i).getEstado().equals("Completada")&& !horariosFiltrados.get(i).getEstado().equals("Rechazada")){
                contadorPaneles++;
                final int contadorPanelesInner = contadorPaneles;
                final int iFinal= i;
                
                JPanel smallPanel = new JPanel();
                smallPanel.setBackground(Colors.backgroundSecundario);
                smallPanel.setBorder(BorderFactory.createLineBorder(Colors.principalBotones));
                smallPanel.setBounds(10, 10, 200, 200);
                //smallPanel.setLayout(new GridBagLayout());
                smallPanel.setLayout(null);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                //gbc.gridy = principal.getComponentCount(); //The new JPanel's place in the list
                gbc.fill = GridBagConstraints.HORIZONTAL;
                //gbc.anchor = GridBagConstraints.PAGE_START; //I thought this would do it
                gbc.ipady = 130; //Set the panel's height, the width will get set to that of the container JPanel (which is what I want since I'd like my JFrames to be resizable)
                gbc.insets = new Insets(2, 0, 2, 0); //Separation between JPanels in the list
                gbc.weightx = 1.0;

                /*GridBagConstraints gbc2 = new GridBagConstraints();
                gbc2.insets = new Insets(10, 50, 10, 50);*/

                //Usuario
                JLabel pacienteLabel = new JLabel(ListaUsuarios.getUsuario(horariosFiltrados.get(i).getId_Paciente()).getNombre());
                pacienteLabel.setBounds(20, 50, 200, 30);
                pacienteLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(pacienteLabel);
                
                //Usuario
                JLabel estadoLabel = new JLabel(horariosFiltrados.get(i).getEstado());
                estadoLabel.setBounds(20, 100, 200, 30);
                estadoLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(estadoLabel);

                //Hora
                JLabel horaLabel = new JLabel(Integer.toString(horariosFiltrados.get(i).getHora()) + ":" + Integer.toString(horariosFiltrados.get(i).getMinutos()));
                horaLabel.setBounds(260, 50, 200, 30);
                horaLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(horaLabel);

                //Fecha
                JLabel fechaLabel = new JLabel(Integer.toString(horariosFiltrados.get(i).getDia()) + "/" + Integer.toString(horariosFiltrados.get(i).getMes()) + "/" + Integer.toString(horariosFiltrados.get(i).getYear()));
                fechaLabel.setBounds(340, 50, 200, 30);
                fechaLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
                smallPanel.add(fechaLabel);
                
                JButton verMasButton = new JButton("Ver Mas");
                verMasButton.setBounds(450,40,150,50);
                verMasButton.setBackground(Colors.principalBotones);
                verMasButton.setFont(Fuentes.getPrincipalFontSize(12, true));
                verMasButton.setForeground(Colors.white);
                verMasButton.addActionListener(this);
                verMasButton.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Id ="+contadorPanelesInner);
                    }
                });
                smallPanel.add(verMasButton);
                
                JButton atenderButton = new JButton("Atender");
                atenderButton.setBounds(620,40,150,50);
                atenderButton.setBackground(Colors.principalBotones);
                atenderButton.setFont(Fuentes.getPrincipalFontSize(12, true));
                atenderButton.setForeground(Colors.white);
                atenderButton.addActionListener(this);
                atenderButton.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) {
                        ListaHorarios.terminarCita(horariosFiltrados.get(iFinal).getId());
                        MainMedico login = new MainMedico();
                        Mensaje mensaje = new Mensaje("¡Cita Atentida!", true);
                    }
                });
                smallPanel.add(atenderButton);
                
                JButton rechazarButton = new JButton("Rechazar");
                rechazarButton.setBounds(800,40,150,50);
                rechazarButton.setBackground(Colors.principalBotones);
                rechazarButton.setFont(Fuentes.getPrincipalFontSize(12, true));
                rechazarButton.setForeground(Colors.white);
                rechazarButton.addActionListener(this);
                rechazarButton.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) {
                        ListaHorarios.rechazarCita(horariosFiltrados.get(iFinal).getId());
                        MainMedico login = new MainMedico();
                        Mensaje mensaje = new Mensaje("¡Cita Rechazada!", true);
                    }
                });
                smallPanel.add(rechazarButton);
                

                principal.add(smallPanel, gbc);
            }
        }
        
        JScrollPane scrollPane = new JScrollPane(principal);
        scrollPane.setBorder(null);
        scrollPane.setBounds(50, 50, 1000, 400);
        panelSolicitar.add(scrollPane);
        
        //----------------------------------Fin Citas
        //---------------------------------------Fin Pestaña Ver Citas
        
        
        
        
        //---------------------------------------Pestaña Asignar Citas
        JPanel panelEstado = new JPanel();
        panelEstado.setLayout(null);
        panelEstado.setBackground(Colors.background);
        tabbedPane.addTab("Asignar Horarios", panelEstado);
        
        JLabel tituloAsignarCitasLabel = new JLabel("Asigna Horarios para tus Citas");
        tituloAsignarCitasLabel.setBounds(10,10,300,30);
        tituloAsignarCitasLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelEstado.add(tituloAsignarCitasLabel);

        
        //---------------------------------------Fin Pestaña Asignar citas
                
        
        tabbedPane.setBackground(Colors.white);
        tabbedPane.setBounds(10, 50, 1150, 600);
        this.add(tabbedPane);

        
        this.getContentPane().setBackground(Colors.backgroundSecundario);
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
        
        if(e.getActionCommand().equals("Cerrar Sesion")){
            SesionActual.cerrarSesion();
            Login login = new Login();
            this.setVisible(false);
            this.dispose();
        }
        if(e.getActionCommand().equals("Pastel")){
            
        }
        
                
        if(e.getActionCommand().equals("Editar Perfil")){
                       
            JLabel imageLabel = new JLabel(Toolbox.adjustImage("../imgs/Editar.png", 40, 40));
            imageLabel.setBounds(10, 10, 40, 40);
            dialogo.add(imageLabel);

            Usuario usuarioActual = SesionActual.getUsuarioEnUso();
            
            JLabel tituloLabel = new JLabel("Editar Perfil");
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
            nombreField.setText(usuarioActual.getNombre());
            dialogo.add(nombreField);
            
            JLabel apellidosLabel = new JLabel("Apellidos");
            apellidosLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            apellidosLabel.setBounds(415, 90, 100, 30);
            dialogo.add(apellidosLabel);

            apellidoField = new JTextField();
            apellidoField.setBounds(500,90,200,30);
            apellidoField.setText(usuarioActual.getApellido());
            dialogo.add(apellidoField);


            
            JLabel passwordLabel = new JLabel("Contraseña");
            passwordLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            passwordLabel.setBounds(10, 140, 100, 30);
            dialogo.add(passwordLabel);
            
            passwordField = new JPasswordField();
            passwordField.setBounds(110,140, 200, 30);
            passwordField.setText(usuarioActual.getContraseña());
            dialogo.add(passwordField);
            
            JLabel edadLabel = new JLabel("Edad");
            edadLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            edadLabel.setBounds(420, 140, 100, 30);
            dialogo.add(edadLabel);
            
            edadField = new JTextField();
            edadField.setBounds(500,140, 200, 30);
            edadField.setText(Integer.toString(usuarioActual.getEdad()));
            dialogo.add(edadField);
            
            JLabel especialidadLabel = new JLabel("Especialidad");
            especialidadLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
            especialidadLabel.setBounds(30, 190, 100, 30);
            dialogo.add(especialidadLabel);

            especialidadField = new JTextField();
            especialidadField.setBounds(110,190,200,30);
            especialidadField.setText(usuarioActual.getNombre());
            dialogo.add(especialidadField);
            
            JButton crearButton = new JButton("Actualizar Perfil");
            crearButton.setFont(Fuentes.getPrincipalFontSize(12, true));
            crearButton.setBounds(320, 320, 170, 25);
            crearButton.setBackground(Colors.principalBotones);
            crearButton.setForeground(Colors.white);
            crearButton.addActionListener(this);
            dialogo.add(crearButton);
            
            JLabel logoLabel = new JLabel(Toolbox.adjustImage("../imgs/LogoCompleto.png", 110, 30));
            logoLabel.setBounds(650, 320, 110, 30);
            dialogo.add(logoLabel);
            
            
            
            
            dialogo.setTitle("Editar Perfil");
            dialogo.setSize(800,400);
            dialogo.setLayout(null);
            dialogo.setResizable(false);
            dialogo.setLocationRelativeTo(null);
            dialogo.getContentPane().setBackground(Colors.background);
            dialogo.setVisible(true);
        }
    
        
        if(e.getActionCommand().equals("Actualizar Perfil")){

            String nombre = nombreField.getText();
            String apellidos = apellidoField.getText();
            String password = new String(passwordField.getPassword());
            String especialidad = especialidadField.getText();
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

            if (!nombre.equals("") && !apellidos.equals("")) {
                if (edad >= 1 && edad <= 100) {

                    Medico med = new Medico(nombre, apellidos,edad,SesionActual.getSexo(),password,especialidad);
                    med.setId(SesionActual.getId());
                    ListaUsuarios.editUsuario(med, SesionActual.getId());
                    Autenticacion.actualizarUsuario(SesionActual.getId());
                    MainMedico mainMedico = new MainMedico();
                    Mensaje mensaje = new Mensaje("¡Perfil Actualizado Exitosamente!", true);
                    this.setVisible(false);
                    this.dispose();

                } else {
                    Mensaje mensaje = new Mensaje("Ingrese una edad correcta.", false);
                }
            } else {
                Mensaje mensaje = new Mensaje("Ingrese todos los campos  obligatorios.", false);
            }
            
        }
        

        if(e.getActionCommand().equals("Actualizar")){
            MainMedico mainMec = new MainMedico();
            this.setVisible(false);
            this.dispose();
        }
        
        if(e.getActionCommand().equals("Ver MAs")){}
    }
    
}
