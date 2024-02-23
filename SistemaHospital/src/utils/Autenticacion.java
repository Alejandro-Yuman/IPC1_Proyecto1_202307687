/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import objetos.Usuario;
import conta_usuarios.ListaUsuarios;
import conta_usuarios.SesionActual;
import objetos.Paciente;

/**
 *
 * @author Alejandro
 */
public class Autenticacion {
    
    public static boolean iniciarSesion(int codigo, String contra){
        
        return verificarUsuario(codigo,contra);
    }
    
    public static void registro(String nombre, String apellido, int edad, char sexo, String contraseña){
        Paciente paciente = new Paciente(nombre, apellido,edad,sexo,contraseña);
        ListaUsuarios.addUsuarios(paciente);
    }
    
    static boolean verificarUsuario(int codigo, String contra){
        Usuario tempUs = ListaUsuarios.getUsuario(codigo);
        if(tempUs != null){
            if(tempUs.getContraseña().equals(contra)){
                SesionActual.asignarSesion(tempUs);
                return true;
                
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    
}
