/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoImagenes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jean Carlo
 */
public class randomImage 
{    
    public String getImage(int width, int height, String name) throws IOException
    {
       BufferedImage img = new BufferedImage(width, height,  BufferedImage.TYPE_INT_ARGB);
       File f = null;
       
       for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width; y++)
            {
                int a = (int)(Math.random()*256);              
                int avg = (int)(Math.random()*256);
                
                //Guarda el pixel en escala de grises
                int p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                
                img.setRGB(y, x, p); 
            }
        }
       
       //write image
        try{
          //La extención se puede cambiar por png/jpg 
          f = new File("images\\"+name+".png");
          ImageIO.write(img, "png", f);
        }catch(IOException e){
          System.out.println(e);
        }
        
        return(name+".png");
      
    }
}
