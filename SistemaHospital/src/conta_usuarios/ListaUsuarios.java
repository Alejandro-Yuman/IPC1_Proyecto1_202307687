
package conta_usuarios;

import objetos.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public  class ListaUsuarios {
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static void getUsuarios() {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("Usuario " + usuarios.get(i).getNombre()+ " id = "+usuarios.get(i).getId());
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
                System.out.println("Eliminado");
                break;
            }
        }
    }
    
    public static void addUsuarios(Usuario usuarioNuevo) {
        usuarioNuevo.setId(generarId(usuarioNuevo));
        usuarios.add(usuarioNuevo);
    }
    
    public static void addAdministrador(Usuario usuarioNuevo){
        usuarios.add(usuarioNuevo);
    }
    
    static int generarId(Usuario usuarioNuevo){
        
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId() != (i+1)){
                return i+1;
            }
        }
        if(usuarios.size() == 0){
            return 1;
        }else{
            return usuarios.getLast().getId()+1;
        }

    }

    

}
