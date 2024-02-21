/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import objetos.Usuario;
import conta_usuarios.ListaUsuarios;
import objetos.Paciente;

/**
 *
 * @author Alejandro
 */
public class Autenticacion {
    
    public static void iniciarSesion(int codigo, String contra){
        verificarUsuario(codigo,contra);
    }
    
    public static void registro(String nombre, String apellido, int edad, char sexo, String contraseña){
        Paciente paciente = new Paciente(nombre, apellido,edad,sexo,contraseña);
        ListaUsuarios.addUsuarios(paciente);
    }
    
    static void verificarUsuario(int codigo, String contra){
        Usuario tempUs = ListaUsuarios.getUsuario(codigo);
        if(tempUs != null){
            if(tempUs.getContraseña().equals(contra)){
                System.out.println("Inicio sesion exitoso");
            }else{
                System.out.println("Credenciales de inicio incorrecta2s");
            }
        }else{
            System.out.println("Credenciales de inicio incorrectas1");
        }
    }
    
    
}
