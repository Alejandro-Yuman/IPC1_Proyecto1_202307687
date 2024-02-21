/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import objetos.Usuario;

/**
 *
 * @author Alejandro
 */
public class Medico extends Usuario{
    private int telefono;
    private String especialidad;

    
    public Medico(String nombre, String apellido, int edad, char sexo, String contraseña, int telefono, String especialidad) {
        super(nombre, apellido, edad, sexo, contraseña);
        this.telefono = telefono;
        this.especialidad = especialidad;
    }
    public Medico(String nombre, String apellido, int edad, char sexo, String contraseña,String especialidad) {
        super(nombre, apellido, edad, sexo, contraseña);
        this.especialidad = especialidad;
        this.telefono = 00000000;
    }
    
    
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
}
