/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conta_usuarios;

import java.util.ArrayList;
import objetos.Horario;

/**
 *
 * @author reneb
 */
public class ListaHorarios {
    static ArrayList<Horario> horarios = new ArrayList<Horario>();
    
    public static void printHorarios() {
        for (int i = 0; i < horarios.size(); i++) {
            System.out.println("Estado " + horarios.get(i).getEstado()+ " id="+horarios.get(i).getId()+"id_Usuario"+horarios.get(i).getId_Paciente());
        }
    }
    public static Horario getHorario(int id){
        
        for (int i = 0; i < horarios.size(); i++) {
            if(horarios.get(i).getId() == id){
                return horarios.get(i);
            }
        }
        return null;
    }
    public static void eliminarHorario(int id){
        
        for (int i = 0; i < horarios.size(); i++) {
            if(horarios.get(i).getId() == id){
                horarios.remove(i);
                break;
            }
        }
    }
        public static void addHorario(Horario horarioNuevo) {
        horarioNuevo.setId(generarId());
        horarios.add(horarioNuevo);
    }
    
    public static void editHorario(Horario horarioNuevo, int id){
        for (int i = 0; i < horarios.size(); i++) {
            if(horarios.get(i).getId() == id){
                horarios.set(i, horarioNuevo);
                break;
                
            }
        }
    }
    
    public static ArrayList<Horario> getHorarios(){
        return horarios;
    }
    
    
    
    
    static int generarId(){
        for (int i = 0; i < horarios.size(); i++) {
            if(horarios.get(i).getId() != (i+1)){
                System.out.println(i);
                return i;
            }
        }
        if(horarios.isEmpty()){
            return 1;
        }else{

            return horarios.getLast().getId()+1;
            
        }
        
        
    }
    
}
