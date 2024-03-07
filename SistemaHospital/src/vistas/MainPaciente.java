/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import conta_usuarios.ListaHorarios;
import conta_usuarios.ListaProductos;
import conta_usuarios.ListaUsuarios;
import conta_usuarios.SesionActual;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import objetos.Horario;
import objetos.Medico;
import objetos.Paciente;
import objetos.Producto;
import objetos.Usuario;
import utils.Autenticacion;
import utils.Fuentes;
import utils.Toolbox;
import utils.Colors;

/**
 *
 * @author Alejandro
 */
public class MainPaciente extends JFrame implements ActionListener{
    JTabbedPane tabbedPane;
    JTextArea motivoTextArea;
    JComboBox especialidadComboBox;
    JComboBox doctorComboBox;
    JComboBox fechaComboBox;
    //JComboBox horaComboBox;
    JButton buscarHorarioButton;
    
    JTextField nombreField;
    JTextField apellidoField;
    JPasswordField passwordField;
    JTextField edadField;
    
    int[] MedicosId;
    int[] HorariosId;
    
    public MainPaciente() {
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
        
        
        JLabel tipoUsuarioLabel = new JLabel("Paciente");
        tipoUsuarioLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        tipoUsuarioLabel.setBounds(150,10,170,30);
        this.add(tipoUsuarioLabel);
        
        JLabel tituloLabel = new JLabel("Nombre: "+SesionActual.getNombre());
        tituloLabel.setFont(Fuentes.getPrincipalFontSize(12, true));
        tituloLabel.setBounds(350,10,400,30);
        this.add(tituloLabel);
        
        tabbedPane = new JTabbedPane();
        
        
        //---------------------------------------Pestaña Solicitar Cita
        JPanel panelSolicitar = new JPanel();
        panelSolicitar.setLayout(null);
        panelSolicitar.setBackground(Colors.background);
        tabbedPane.addTab("Solicitar Cita", panelSolicitar);
        tabbedPane.setFont(Fuentes.getPrincipalFontSize(12, true));
        
        JLabel tituloSolicitarLabel = new JLabel("Solicitar Cita");
        tituloSolicitarLabel.setBounds(10,10,200,30);
        tituloSolicitarLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelSolicitar.add(tituloSolicitarLabel);
        
        JLabel motivoLabel = new JLabel("Motivo de la Cita:");
        motivoLabel.setBounds(10,50,200,30);
        motivoLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelSolicitar.add(motivoLabel);
        
        motivoTextArea = new JTextArea(5, 15);
        motivoTextArea.setBorder(BorderFactory.createLineBorder(Colors.principalBotones));
        motivoTextArea.setBounds(10, 90, 1120, 150);
        motivoTextArea.setLineWrap(true);
        panelSolicitar.add(motivoTextArea);
        
        
        
        JLabel especialidadLabel = new JLabel("Especialidad:");
        especialidadLabel.setBounds(10,250,200,30);
        especialidadLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelSolicitar.add(especialidadLabel);
        
        
        //Logica Combo Box Especialida
        ArrayList<Medico> medicos = ListaUsuarios.getMedicos();
        ArrayList<String> listaEspecialidades = new ArrayList<String>();
        
        
        boolean encontrado = false;

        for (int i = 0; i < medicos.size(); i++) {

            for (int j = 0; j < listaEspecialidades.size(); j++) {
                if(listaEspecialidades.get(j) == medicos.get(i).getEspecialidad() ){
                    encontrado = true;
                    break;
                    
                }
            }
            if(!encontrado){
                listaEspecialidades.add(medicos.get(i).getEspecialidad());
            }
            encontrado = false;
        }
        
        String[] listaEspecialidad = new String[listaEspecialidades.size()];
        for (int i = 0; i < listaEspecialidades.size(); i++) {
            listaEspecialidad[i]= listaEspecialidades.get(i);
        }

        //Fin Logica Combo Box Especialida
        
       
        especialidadComboBox = new JComboBox(listaEspecialidad);
        especialidadComboBox.setBounds(120, 250, 200, 30);
        especialidadComboBox.setFont(Fuentes.getPrincipalFontSize(12, true));
        especialidadComboBox.addActionListener(this);
        panelSolicitar.add(especialidadComboBox);
        
        JButton buscarDoctoresdButton = new JButton("Mostrar Doctores");
        buscarDoctoresdButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        buscarDoctoresdButton.setBounds(350, 250, 170, 30);
        buscarDoctoresdButton.setBackground(Colors.principalBotones);
        buscarDoctoresdButton.setForeground(Colors.white);
        buscarDoctoresdButton.addActionListener(this);
        panelSolicitar.add(buscarDoctoresdButton);

        
        
        JLabel doctorLabel = new JLabel("Doctor:");
        doctorLabel.setBounds(650,250,200,30);
        doctorLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelSolicitar.add(doctorLabel);
        
        String[] listaDoctor = {"Seleccione una opción"};
        doctorComboBox = new JComboBox(listaDoctor);
        doctorComboBox.setBounds(720, 250, 200, 30);
        doctorComboBox.setFont(Fuentes.getPrincipalFontSize(12, true));
        doctorComboBox.setEnabled(false);
        panelSolicitar.add(doctorComboBox);
        
        buscarHorarioButton = new JButton("Mostrar Horarios");
        buscarHorarioButton.setFont(Fuentes.getPrincipalFontSize(12, true));
        buscarHorarioButton.setBounds(960, 250, 170, 30);
        buscarHorarioButton.setBackground(Colors.principalBotones);
        buscarHorarioButton.setForeground(Colors.white);
        buscarHorarioButton.addActionListener(this);
        buscarHorarioButton.setEnabled(false);
        panelSolicitar.add(buscarHorarioButton);
        
        
        
        JLabel horarioLabel = new JLabel("Horario de citas disponibles");
        horarioLabel.setBounds(10,290,300,30);
        horarioLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelSolicitar.add(horarioLabel);
        
        
        JLabel fechaLabel = new JLabel("Fecha:");
        fechaLabel.setBounds(10,330,200,30);
        fechaLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelSolicitar.add(fechaLabel);
        
        String[] listaFecha = {"Seleccione una opción", "Hombre", "Mujer"};
        fechaComboBox = new JComboBox(listaFecha);
        fechaComboBox.setBounds(120, 330, 200, 30);
        fechaComboBox.setEnabled(false);
        fechaComboBox.setFont(Fuentes.getPrincipalFontSize(12, true));
        panelSolicitar.add(fechaComboBox);
        
        /*JLabel horaLabel = new JLabel("Hora:");
        horaLabel.setBounds(650,330,200,30);
        horaLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelSolicitar.add(horaLabel);
        
        String[] listaHora = {"Seleccione una opción", "Hombre", "Mujer"};
        horaComboBox = new JComboBox(listaHora);
        horaComboBox.setBounds(720, 330, 200, 30);
        horaComboBox.setEnabled(false);
        horaComboBox.setFont(Fuentes.getPrincipalFontSize(12, true));
        panelSolicitar.add(horaComboBox);*/
        
        
        JButton reiniciarCita = new JButton("Reiniciar");
        reiniciarCita.setBounds(20,510,150,40);
        reiniciarCita.setBackground(Colors.principalBotones);
        reiniciarCita.setFont(Fuentes.getPrincipalFontSize(12, true));
        reiniciarCita.setForeground(Colors.white);
        reiniciarCita.addActionListener(this);
        panelSolicitar.add(reiniciarCita);
        
        
        ArrayList<Horario> horariosTemp = ListaHorarios.getHorarios();
        boolean encontrada = false;
        for (int i = 0; i < horariosTemp.size(); i++) {
            if(horariosTemp.get(i).getId_Paciente() == SesionActual.getId() && horariosTemp.get(i).getEstado().equals("Pendiente") ){
                encontrada = true;
                break;
            }
        }
        
        JButton botonCrearCita = new JButton("Generar Cita");
        botonCrearCita.setBounds(450,500,250,50);
        botonCrearCita.setBackground(Colors.principalBotones);
        botonCrearCita.setFont(Fuentes.getPrincipalFontSize(12, true));
        botonCrearCita.setForeground(Colors.white);
        botonCrearCita.addActionListener(this);
        if(encontrada){
            botonCrearCita.setEnabled(false);
        }else{
            botonCrearCita.setEnabled(true);
        }
        panelSolicitar.add(botonCrearCita);
        
        //---------------------------------------Fin Pestaña Solicitar Cita
        
        
        
        
        //---------------------------------------Pestaña Ver Estado Cita
        JPanel panelEstado = new JPanel();
        panelEstado.setLayout(null);
        panelEstado.setBackground(Colors.background);
        tabbedPane.addTab("Ver Estado Cita", panelEstado);
        
        JLabel tituloEstadoLabel = new JLabel("Estados de tus Citas");
        tituloEstadoLabel.setBounds(10,10,200,30);
        tituloEstadoLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelEstado.add(tituloEstadoLabel);
        
        
        //Tabla de Horarios
        ArrayList<Horario> listaHorarios = ListaHorarios.getHorarios();
        int contadorHorariosPersonales = 0;
        for (int i = 0; i < listaHorarios.size(); i++) {
            if(listaHorarios.get(i).getId_Paciente() == SesionActual.getId()){
                contadorHorariosPersonales++;
            }
        }
        Object[][] datosHorario = new Object[contadorHorariosPersonales][5];
        

        contadorHorariosPersonales = 0;
        for (int i = 0; i < listaHorarios.size(); i++) {
            if(listaHorarios.get(i).getId_Paciente() == SesionActual.getId()){
            
                
            datosHorario[contadorHorariosPersonales][0]=listaHorarios.get(i).getId();
            

            if(ListaUsuarios.getUsuario(listaHorarios.get(i).getId_Medico()) instanceof Medico){
                datosHorario[contadorHorariosPersonales][1]=ListaUsuarios.getUsuario(listaHorarios.get(i).getId_Medico()).getNombre();
            }else{
                datosHorario[contadorHorariosPersonales][1]="Error, el usuario asignado no es Medico";
            }
            
            datosHorario[contadorHorariosPersonales][2]=listaHorarios.get(i).getEstado();
            datosHorario[contadorHorariosPersonales][3]=listaHorarios.get(i).getDia()+"/"+listaHorarios.get(i).getMes()+"/"+listaHorarios.get(i).getYear();
            
            if(Integer.toString(listaHorarios.get(i).getMinutos()).length() == 1){
                datosHorario[contadorHorariosPersonales][4]=listaHorarios.get(i).getHora()+":0"+listaHorarios.get(i).getMinutos();
            }else{
                datosHorario[contadorHorariosPersonales][4]=listaHorarios.get(i).getHora()+":"+listaHorarios.get(i).getMinutos();
            }
            
            //datosHorario[contadorHorariosPersonales][4]=listaHorarios.get(i).getHora()+":"+listaHorarios.get(i).getMinutos();
            
            contadorHorariosPersonales++;
            }
        }

        String[] columnasHorario = {"Codigo","Medico","Estado","Fecha","Hora"};
        
        JTable tablaHorario = new JTable(datosHorario, columnasHorario);
        tablaHorario.getColumnModel().getColumn(0).setPreferredWidth(1);
        tablaHorario.setFont(Fuentes.getPrincipalFontSize(11,false));
        JScrollPane spHorario = new JScrollPane(tablaHorario);
        spHorario.setBounds(10, 100, 1100, 400);
        panelEstado.add(spHorario);
        //Fin Horarios
        
        
        
        //---------------------------------------Pestaña Ver Estado Cita
                
        
        
        
        //---------------------------------------Pestaña Farmacia
        JPanel panelFarmacia = new JPanel();
        panelFarmacia.setLayout(null);
        panelFarmacia.setBackground(Colors.background);
        tabbedPane.addTab("Farmacia", panelFarmacia);
        
        
        
        
        JLabel tituloFarmaciaLabel = new JLabel("Productos");
        tituloFarmaciaLabel.setBounds(10,10,200,30);
        tituloFarmaciaLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelFarmacia.add(tituloFarmaciaLabel);
        
        JLabel tituloCatalogoLabel = new JLabel("Mira nuestro catalogo de productos y visita la farmacia para comprarlos");
        tituloCatalogoLabel.setBounds(10,50,1000,30);
        tituloCatalogoLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelFarmacia.add(tituloCatalogoLabel);

        JLabel tituloCodigoLabel = new JLabel("Codigo");
        tituloCodigoLabel.setBounds(60,100,200,30);
        tituloCodigoLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelFarmacia.add(tituloCodigoLabel);
        
        JLabel tituloNombreLabel = new JLabel("Nombre");
        tituloNombreLabel.setBounds(190,100,200,30);
        tituloNombreLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelFarmacia.add(tituloNombreLabel);
        
        JLabel tituloCantidadLabel = new JLabel("Cantidad");
        tituloCantidadLabel.setBounds(430,100,200,30);
        tituloCantidadLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelFarmacia.add(tituloCantidadLabel);
        
        JLabel tituloDescripcionLabel = new JLabel("Descripcion");
        tituloDescripcionLabel.setBounds(530,100,200,30);
        tituloDescripcionLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelFarmacia.add(tituloDescripcionLabel);
        
        JLabel tituloPrecioLabel = new JLabel("Precio");
        tituloPrecioLabel.setBounds(890,100,200,30);
        tituloPrecioLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
        panelFarmacia.add(tituloPrecioLabel);
        
        //----------------------------------Inicio Tabla Productos
        JPanel principal = new JPanel();
        principal.setLayout(new GridBagLayout());
        principal.setBackground(Colors.background);
        
        ArrayList<Producto> productos = ListaProductos.getProductos();
       
        for (int i = 0; i < productos.size(); i++) {
            JPanel smallPanel = new JPanel();
            smallPanel.setBackground(Colors.backgroundSecundario);
            smallPanel.setBorder(BorderFactory.createLineBorder(Colors.principalBotones));
            smallPanel.setBounds(10, 10, 200, 200);
            //smallPanel.setLayout(new GridBagLayout());
            smallPanel.setLayout(null);

            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            //gbc.gridy = principal.getComponentCount(); 
            gbc.fill = GridBagConstraints.HORIZONTAL;
            //gbc.anchor = GridBagConstraints.PAGE_START;
            gbc.ipady = 130;
            gbc.insets = new Insets(2, 0, 2, 0);
            gbc.weightx = 1.0;
            

            JLabel codigoProdLabel = new JLabel(Integer.toString(productos.get(i).getId()));
            codigoProdLabel.setBounds(20, 50, 200, 30);
            codigoProdLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            smallPanel.add(codigoProdLabel);

            JLabel nombreProdLabel = new JLabel("<html>"+productos.get(i).getNombre()+"</html>");
            nombreProdLabel.setBounds(100, 50, 270, 30);
            nombreProdLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            smallPanel.add(nombreProdLabel);

            JLabel cantidadProdLabel = new JLabel(Integer.toString(productos.get(i).getCantidad()));
            cantidadProdLabel.setBounds(410, 50, 200, 30);
            cantidadProdLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            smallPanel.add(cantidadProdLabel);

            JLabel descripcionProdLabel = new JLabel("<html>"+productos.get(i).getDescripcion()+"</html>");
            descripcionProdLabel.setBounds(480, 50, 360, 30);
            descripcionProdLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            smallPanel.add(descripcionProdLabel);

            JLabel precioProdLabel = new JLabel(Integer.toString(productos.get(i).getPrecio()));
            precioProdLabel.setBounds(850, 50, 200, 30);
            precioProdLabel.setFont(Fuentes.getPrincipalFontSize(14, true));
            smallPanel.add(precioProdLabel);

            principal.add(smallPanel, gbc);
            
        }
        
        JScrollPane scrollPane = new JScrollPane(principal);
        scrollPane.setBorder(null);
        scrollPane.setBounds(50, 150, 1000, 420);
        panelFarmacia.add(scrollPane);
        //----------------------------------Fin Tabla Productos

        //---------------------------------------Fin Pestaña Farmacia
        
        
        
        
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

        if(e.getActionCommand().equals("Mostrar Doctores")){
            ArrayList<Medico> medicos = ListaUsuarios.getMedicos();
            ArrayList<Medico> medicosFiltrados = new ArrayList();

            
            for (int i = 0; i < medicos.size(); i++) {
                if (medicos.get(i).getEspecialidad() == especialidadComboBox.getSelectedItem()) {
                    medicosFiltrados.add(medicos.get(i));

                }
            }
            MedicosId = new int[medicosFiltrados.size()];
            String[] listaDoctor = new String[medicosFiltrados.size()];
            for (int i = 0; i < medicosFiltrados.size(); i++) {
                listaDoctor[i] =medicosFiltrados.get(i).getNombre();
                MedicosId[i] = medicosFiltrados.get(i).getId();
            }
            
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( listaDoctor );
            doctorComboBox.setModel( model );
            doctorComboBox.setEnabled(true);
            buscarHorarioButton.setEnabled(true);
            especialidadComboBox.setEnabled(false);
            //doctorComboBox = new JComboBox(listaDoctor);
        }
    
        if (e.getActionCommand().equals("Mostrar Horarios")) {
            int idMedicoSeleccionado = MedicosId[doctorComboBox.getSelectedIndex()];
            
            ArrayList<Horario> listaHorarios = ListaHorarios.getHorarios();
            ArrayList<Horario> listaHorariosFiltrados = new ArrayList<Horario>();
            for (int i = 0; i < listaHorarios.size(); i++) {
                if (listaHorarios.get(i).getId_Medico() == idMedicoSeleccionado && listaHorarios.get(i).getId_Paciente() == -1) {
                    
                    listaHorariosFiltrados.add(listaHorarios.get(i));
                }
            }

            String[] listaFechasyHoras =  new String[listaHorariosFiltrados.size()];
            HorariosId = new int[listaHorariosFiltrados.size()];
            for (int i = 0; i < listaHorariosFiltrados.size(); i++) {
                listaFechasyHoras[i] =(i+1)+"-"+listaHorariosFiltrados.get(i).getDia()+"/"+listaHorariosFiltrados.get(i).getMes()+"/"+listaHorariosFiltrados.get(i).getYear()+"-"+listaHorariosFiltrados.get(i).getHora()+":"+listaHorariosFiltrados.get(i).getMinutos();
                HorariosId[i] = listaHorariosFiltrados.get(i).getId();
                //listaHoras[i] = listaHorariosFiltrados.get(i).getHora()+":"+listaHorariosFiltrados.get(i).getMinutos();
            }

            
            DefaultComboBoxModel<String> modelFechas = new DefaultComboBoxModel<>(listaFechasyHoras);
            //DefaultComboBoxModel<String> modelHoras = new DefaultComboBoxModel<>(listaHoras);
            fechaComboBox.setModel(modelFechas);
            //horaComboBox.setModel(modelHoras);
            doctorComboBox.setEnabled(false);
            fechaComboBox.setEnabled(true);
            //horaComboBox.setEnabled(true);
        }

        if(e.getActionCommand().equals("Generar Cita")){
            int index = fechaComboBox.getSelectedIndex();
            String motivo = motivoTextArea.getText();
            if(index != -1){
                Horario horario = ListaHorarios.getHorario(HorariosId[index]);
                if (horario.getId_Paciente() == -1) {
                    
                    
                    ListaHorarios.setPacienteID(horario.getId(), SesionActual.getId());
                    ListaHorarios.setMotivoHorario(horario.getId(), motivo);
                    MainPaciente mainPaciente = new MainPaciente();
                    Mensaje mensaje = new Mensaje("¡Cita Agendada Exitosamente!", true);
                    this.setVisible(false);
                    this.dispose();
                } else {
                    Mensaje mensaje = new Mensaje("El horario esta ocupado", false);
                }
            }else{
                Mensaje mensaje = new Mensaje("No hay horarios disponibles",false);
            }

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

                    Paciente pac = new Paciente(nombre, apellidos,edad,SesionActual.getSexo(),password);
                    pac.setId(SesionActual.getId());
                    ListaUsuarios.editUsuario(pac, SesionActual.getId());
                    Autenticacion.actualizarUsuario(SesionActual.getId());
                    MainPaciente mainAdmin = new MainPaciente();
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
        
        if(e.getActionCommand().equals("Reiniciar")){
            MainPaciente mainPac = new MainPaciente();
            this.setVisible(false);
            this.dispose();
        }
    
    }
    


}
