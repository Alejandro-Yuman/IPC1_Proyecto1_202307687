/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemahospital;

import conta_usuarios.ListaProductos;
import conta_usuarios.ListaUsuarios;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import objetos.Administrador;
import objetos.Medico;
import objetos.Producto;
import utils.Autenticacion;
import vistas.Login;
import vistas.MainAdministrador;
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

        
        Autenticacion.registro("Eso tilines 1 Paciente","Ap",18,'M',"Contraseña");
        Autenticacion.registro("Eso tilines 2 Paciente","Ap",18,'M',"holaTilin");
        Medico med = new Medico("Medico 1","Don",18,'M',"Dios",20202020,"Doctor psiquiatra");
        ListaUsuarios.addUsuarios(med);
        Medico med2 = new Medico("Medico 2","Doña",22,'F',"Diosayudame","Doctora psiquiatra");
        ListaUsuarios.addUsuarios(med2);
        Medico med3 = new Medico("Medico 3","Donsito",22,'F',"Diosayudame","Doctor psiquiatra");
        ListaUsuarios.addUsuarios(med3);
        Medico med4 = new Medico("Medico 4","Donsito",22,'F',"Diosayudame","Computadora");
        ListaUsuarios.addUsuarios(med4);
        
        for (int i = 0; i < 10; i++) {
            Producto producto = new Producto("Cerveza",i,"Hola gru",6);
            ListaProductos.addProducto(producto);
        }
        

        
        
        ListaUsuarios.getUsuarios();

        //MainAdministrador login = new MainAdministrador();
        Login login = new Login();
        //Register login = new Register();
        //MainPaciente login = new MainPaciente();



    }
    
}
