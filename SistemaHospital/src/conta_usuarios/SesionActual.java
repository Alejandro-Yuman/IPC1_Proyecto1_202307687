/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conta_usuarios;

import objetos.Administrador;
import objetos.Medico;
import objetos.Paciente;
import objetos.Usuario;

/**
 *
 * @author Alejandro
 */
public class SesionActual {
    private static Usuario usuarioEnUso;
    private static int tipo;
    
    private static int id;
    private static String nombre;
    private static String apellido;
    private static int edad;
    private static char sexo;
    private static String contraseña;
    
   
    
    private static int telefono;
    private static String especialidad;

    
    public static void asignarSesion(Usuario usuario) {
        if(usuario instanceof Medico){
            SesionActual.tipo = 1;
            SesionActual.telefono= ((Medico)usuario).getTelefono();
            SesionActual.especialidad = ((Medico)usuario).getEspecialidad();
        }
        if(usuario instanceof Paciente){
            SesionActual.tipo = 2;
        }
        if(usuario instanceof Administrador){
            SesionActual.tipo = 0;
            
        }
        
        SesionActual.usuarioEnUso= usuario;
        SesionActual.id = usuario.getId();
        SesionActual.nombre = usuario.getNombre();
        SesionActual.apellido = usuario.getApellido();
        SesionActual.edad = usuario.getEdad();
        SesionActual.sexo= usuario.getSexo();
        SesionActual.contraseña = usuario.getContraseña();
    }

    public static void cerrarSesion(){
        SesionActual.usuarioEnUso = null;
        SesionActual.id = -1;
        SesionActual.nombre = "";
        SesionActual.apellido = "";
        SesionActual.edad = 0;
        SesionActual.sexo= 'X';
        SesionActual.contraseña = "";
        SesionActual.tipo = -1;
    }
    
    public static Usuario getUsuarioEnUso() {
        return usuarioEnUso;
    }

    public static void setUsuarioEnUso(Usuario usuarioEnUso) {
        SesionActual.usuarioEnUso = usuarioEnUso;
    }

    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        SesionActual.tipo = tipo;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        SesionActual.id = id;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        SesionActual.nombre = nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        SesionActual.apellido = apellido;
    }

    public static int getEdad() {
        return edad;
    }

    public static void setEdad(int edad) {
        SesionActual.edad = edad;
    }

    public static char getSexo() {
        return sexo;
    }

    public static void setSexo(char sexo) {
        SesionActual.sexo = sexo;
    }

    public static String getContraseña() {
        return contraseña;
    }

    public static void setContraseña(String contraseña) {
        SesionActual.contraseña = contraseña;
    }

    public static int getTelefono() {
        return telefono;
    }

    public static void setTelefono(int telefono) {
        SesionActual.telefono = telefono;
    }

    public static String getEspecialidad() {
        return especialidad;
    }

    public static void setEspecialidad(String especialidad) {
        SesionActual.especialidad = especialidad;
    }
    
    

    
    
    
    
}
