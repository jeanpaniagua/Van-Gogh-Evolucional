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

//Retrun a matrix with the color of each pixel 

public class randomImage 
{    
    
    /*public File getImage(int width, int height) throws IOException
    {
       image pixels = new image(width,height,"images\\random.png");
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
                pixels.setPixel(x, y, avg);
                img.setRGB(y, x, p); 
            }
        }
       
       //write image
        try{
          //La extención se puede cambiar por png/jpg 
          f = new File("images\\random.png");
          ImageIO.write(img, "png", f);
        }catch(IOException e){
          System.out.println(e);
        }
        return f;
    }*/
    
    public image getImage(int width, int height, String name) throws IOException
    {
       image pixels = new image(width,height,"images\\"+name+".png");
       BufferedImage img = new BufferedImage(width, height,  BufferedImage.TYPE_INT_ARGB);
       File f = null;
       
       for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width; y++)
            {
                int avg = (int)(Math.random()*256);
                //Guarda el pixel en escala de grises
                int p = (255<<24) | (avg<<16) | (avg<<8) | avg;
                pixels.setPixel(x, y, avg);
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
        return(pixels);
    }
}
