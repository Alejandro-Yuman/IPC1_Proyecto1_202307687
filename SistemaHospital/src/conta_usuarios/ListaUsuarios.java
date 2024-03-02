
package conta_usuarios;

import objetos.Usuario;
import java.util.ArrayList;
import objetos.Medico;
import objetos.Paciente;

/**
 *
 * @author Alejandro
 */
public  class ListaUsuarios {
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static void printUsuarios() {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("Usuario " + usuarios.get(i).getNombre()+ " id = "+usuarios.get(i).getId() +"Contra ="+ usuarios.get(i).getContraseña());
        }
    }
    
    public static Usuario getUsuario(int id){
        
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId() == id){
                return usuarios.get(i);
            }
        }
        return null;
    }

    public static void eliminarUsuario(int id){
        
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId() == id){
                usuarios.remove(i);
                break;
            }
        }
    }
    
    public static void addUsuarios(Usuario usuarioNuevo) {
        usuarioNuevo.setId(generarId(usuarioNuevo));
        usuarios.add(usuarioNuevo);
    }
    
    public static void editUsuario(Usuario usuarioNuevo, int id){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId() == id){
                usuarios.set(i, usuarioNuevo);
                break;
                
            }
        }
    }
    
    
    
    public static ArrayList<Medico> getMedicos(){
        ArrayList<Medico> listaMedicos = new ArrayList<Medico>();
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i) instanceof Medico){
                listaMedicos.add((Medico)usuarios.get(i));
            }
        }
        return listaMedicos;
    }
    
    public static ArrayList<Paciente> getPacientes(){
        ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i) instanceof Paciente){
                listaPacientes.add((Paciente)usuarios.get(i));
            }
        }
        return listaPacientes;
    }
    
    
    
    public static void addAdministrador(Usuario usuarioNuevo){
        usuarios.add(usuarioNuevo);
    }
    
    /*public static int getNumeroRegistradosMedicos(){
        int total = 0;
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i) instanceof Medico){
                total++;
            }
        }
        return total;
    }*/
    

    
    /*public static int getNumeroRegistradosPacientes(){
        int total = 0;
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i) instanceof Paciente){
                total++;
            }
        }
        return total;
    }*/
    
    static int generarId(Usuario usuarioNuevo){
        for (int i = 1; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId() != (i)){
                return i;
            }
        }
        if(usuarios.size() == 1){
            return 1;
        }else{
            return usuarios.getLast().getId()+1;
            
        }
        

    }

    

}
