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

        
        Autenticacion.registro("Eso tilines 1 Paciente","Ap",18,'M',"1");
        Autenticacion.registro("Eso tilines 2 Paciente","Ap",18,'M',"2");
        Medico med = new Medico("Medico 1","Don",18,'M',"3",20202020,"Doctor psiquiatra");
        ListaUsuarios.addUsuarios(med);
        Medico med2 = new Medico("Medico 2","Doña",22,'F',"4","Doctora psiquiatra");
        ListaUsuarios.addUsuarios(med2);
        Medico med3 = new Medico("Medico 3","Donsito",22,'F',"Diosayudame","Doctor psiquiatra");
        ListaUsuarios.addUsuarios(med3);
        Medico med4 = new Medico("Medico 4","Donsito",22,'F',"Diosayudame","Computadora");
        ListaUsuarios.addUsuarios(med4);
        
        
        
        for (int i = 0; i < 10; i++) {
            Producto producto = new Producto("Cerveza Duff de los sinsons que toma homer dou",1000,"Cerveza Duff de los sinsons que toma homer dou",20);
            ListaProductos.addProducto(producto);
        }
        
        for (int i = 0; i < 10; i++) {
            Horario horario = new Horario(4,2024,3,2,20,06);
            ListaHorarios.addHorario(horario);
        }
        Horario horario2 = new Horario(4,2,2024,3,2,20,06);
        ListaHorarios.addHorario(horario2);

        
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
