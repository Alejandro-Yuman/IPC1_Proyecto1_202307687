/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemahospital;

import conta_usuarios.ListaUsuarios;
import objetos.Administrador;
import objetos.Medico;
import utils.Autenticacion;
import vistas.Login;
import vistas.MainAdministrador;
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
        
        
        
        ListaUsuarios.getUsuarios();
        
        
        MainAdministrador login = new MainAdministrador();
        //Login login = new Login();
        //Register login = new Register();

    }
    
}
