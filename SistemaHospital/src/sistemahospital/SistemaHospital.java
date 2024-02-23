/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemahospital;

import conta_usuarios.ListaUsuarios;
import objetos.Administrador;
import utils.Autenticacion;
import vistas.Login;

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

        
        ListaUsuarios.getUsuarios();
        
        
        Login login = new Login();

    }
    
}
