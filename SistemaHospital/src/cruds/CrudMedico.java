/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cruds;

import conta_usuarios.ListaUsuarios;
import objetos.Medico;

/**
 *
 * @author Alejandro
 */
public class CrudMedico {
    public static void crear(String nombre, String apelldos, String especialidad, String contraseña, char sexo, int edad, int telefono){
        Medico medico = new Medico(nombre, apelldos,edad,sexo,contraseña,telefono,especialidad);
        ListaUsuarios.addUsuarios(medico);
    } 
    
    public static void crear(String nombre, String apelldos, String especialidad, String contraseña, char sexo, int edad){
        Medico medico = new Medico(nombre, apelldos,edad,sexo,contraseña,especialidad);
        ListaUsuarios.addUsuarios(medico);
    } 
    
    public static void editar(){
        
    } 
    
    public static void eliminar(int id){
        ListaUsuarios.eliminarUsuario(id);
    } 
    
    public static void getMedicos(){
        
    }
    
    public static void getMedico(int id){
        ListaUsuarios.getUsuario(id);
    }
}
