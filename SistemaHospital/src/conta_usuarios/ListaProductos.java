/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conta_usuarios;

import java.util.ArrayList;
import objetos.Producto;

/**
 *
 * @author reneb
 */
public class ListaProductos {
    static ArrayList<Producto> productos = new ArrayList<Producto>();
    
    
    public static Producto getProducto(int id){
        
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getId() == id){
                return productos.get(i);
            }
        }
        return null;
    }
    public static void eliminarProducto(int id){
        
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getId() == id){
                productos.remove(i);
                break;
            }
        }
    }
        public static void addProducto(Producto usuarioNuevo) {
        usuarioNuevo.setId(generarId(usuarioNuevo));
        productos.add(usuarioNuevo);
    }
    
    public static void editProducto(Producto usuarioNuevo, int id){
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getId() == id){
                productos.set(i, usuarioNuevo);
                break;
                
            }
        }
    }
    
    public static ArrayList<Producto> getProductos(){
        return productos;
    }
    
    
    
    
    static int generarId(Producto usuarioNuevo){
        for (int i = 1; i < productos.size(); i++) {
            if(productos.get(i).getId() != (i)){
                return i;
            }
        }
        if(productos.isEmpty()){
            return 1;
        }else{
            return productos.getLast().getId()+1;
            
        }
        

    }
}
