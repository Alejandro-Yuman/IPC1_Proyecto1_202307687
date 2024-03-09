/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemahospital;

import conta_usuarios.ListaHorarios;
import conta_usuarios.ListaProductos;
import conta_usuarios.ListaUsuarios;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import objetos.Administrador;
import objetos.Horario;
import objetos.Medico;
import objetos.Producto;
import utils.Autenticacion;
import vistas.Login;
import vistas.MainAdministrador;
import vistas.MainMedico;
import vistas.MainPaciente;
import vistas.Mensaje;
import vistas.Register;

/**
 *
 * @author Alejandro
 */
public class SistemaHospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Administrador administrador = new Administrador(); //Creacion del admin
        ListaUsuarios.addAdministrador(administrador);

        


        //ListaProductos.printProductos();
        ListaUsuarios.printUsuarios();
        ListaHorarios.printHorarios();

        //MainAdministrador login = new MainAdministrador();
        Login login = new Login();
        //Register register = new Register();
        //MainPaciente paciente = new MainPaciente();
        //MainMedico medico = new MainMedico();


    }
    
}
