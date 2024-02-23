/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Alejandro
 */
public class Toolbox {
    public static ImageIcon adjustImage(String url, int ancho, int alto ){
        ImageIcon imgLogo = new ImageIcon(Toolbox.class.getResource(url));
        Image imageDimension = imgLogo.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return  new ImageIcon(imageDimension);
    }
}
