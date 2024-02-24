
package utils;

import java.awt.Font;

/**
 *
 * @author Alejandro
 */
public class Fuentes {

    public static Font getPrincipalFontSize(int size, boolean bold){
        if(bold){
            return new Font("Verdana",Font.BOLD,size);
        }else{
            return new Font("Verdana",Font.PLAIN,size);
        }
        
    }
}
