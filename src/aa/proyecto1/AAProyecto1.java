/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aa.proyecto1;

import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import manejoImagenes.*;


/**
 *
 * @author Jean Carlo
 */
public class AAProyecto1 {

    /**
     * @param args the command line arguments
     */
    


    public static void main(String[] args) throws IOException{
        // TODO code application logic here
       //rand();
       rgbToGrayScale imagen = new rgbToGrayScale();
       imagen.cargar();
       
       int width = 800;
       int height = 600;
       
       randomImage img = new randomImage(); 
       img.getImage(width, height, "1.1");
    
       

    }
}

