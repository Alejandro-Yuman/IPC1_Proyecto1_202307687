/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cruds;

import conta_usuarios.ListaUsuarios;
import objetos.Paciente;

/**
 *
 * @author Alejandro
 */
public class CrudPaciente {
    public static void crear(String nombre, String apellido, int edad, char sexo, String contraseña){
        Paciente paciente = new Paciente(nombre, apellido,edad,sexo,contraseña);
        ListaUsuarios.addUsuarios(paciente);
    } 
    
    public static void editar(){
        
    } 
    
    public static void eliminar(int id){
        ListaUsuarios.eliminarUsuario(id);
        
    } 
    
    public static void getPacientes(){
        
    }
    
    public static void getPaciente(int id){
        ListaUsuarios.getUsuario(id);
    }
        
}
