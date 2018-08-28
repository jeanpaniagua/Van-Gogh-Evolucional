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

import manejoImagenes.leerImagen;


/**
 *
 * @author Jean Carlo
 */
public class AAProyecto1 {

    /**
     * @param args the command line arguments
     */
    
    
   
    public static void rand(){
         

        
        for (int i =0; i <= 10; i++)
        {
            for (int j =0; j <= 10; j++)
            {
                int intAletorio = (int)(Math.random()*255+1);
                System.out.print(intAletorio+" ");
            }
            System.out.print("\n");
        }
    }
    

    public static void main(String[] args) throws IOException{
        // TODO code application logic here
       //rand();
       leerImagen imagen = new leerImagen();
       imagen.cargar();
       
       int width = 800;
       int height = 600;
    
    
       BufferedImage img = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
       File f = null;
       
       
       for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width; y++)
            {
                int a = (int)(Math.random()*256);
                int r = (int)(Math.random()*256);
                int g = (int)(Math.random()*256);
                int b = (int)(Math.random()*256);
                
                int avg = (r+g+b)/3;
                
                //Guarda el pixel en escala de grises
                int p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                
                //Guarda el pixel en ARGB
                //int p = (a<<24) | (r<<16) | (g<<8) | b;
                
                
                img.setRGB(y, x, p);
                
            }
            
        }
       
       //write image
        try{
          //La extención se puede cambiar por png/jpg 
          f = new File("random.png");
          ImageIO.write(img, "png", f);
        }catch(IOException e){
          System.out.println(e);
        }

    }
}

