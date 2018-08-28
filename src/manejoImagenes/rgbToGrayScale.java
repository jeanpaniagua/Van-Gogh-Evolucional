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

//Lee imagen y la guarda en escala de grises
//Read and imagen and create a new one on gray scale

public class rgbToGrayScale {

    public void cargar() throws IOException
    {
        BufferedImage img = null;
        File f = null;

        //read image
        try{
          f = new File("n.jpg");
          img = ImageIO.read(f);
          
          int matriz[][] = new int[img.getWidth()][img.getHeight()];
                  
          for(int x = 0; x < img.getWidth(); x++)
          {
              for(int y = 0; y < img.getHeight(); y++)
              {
                  //get pixel value
                  int p = img.getRGB(x,y);
                  
                  //get alpha
                  int a = (p>>24)&0xff;
                  
                  //get red
                  int r = (p>>16) & 0xff;

                  //get green
                  int g = (p>>8) & 0xff;

                  //get blue
                  int b = p & 0xff;
                  
                  int avg = (r+g+b)/3;
                  
                  p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                  
                  img.setRGB(x, y, p);
                  
                  System.out.print(p);
              }
              System.out.print("\n");
          }
        }catch(IOException e){
          System.out.println(e);
        }
        
        //write image
        try{
          f = new File("Output.jpg");
          ImageIO.write(img, "jpg", f);
        }catch(IOException e){
          System.out.println(e);
        }
    } 
    
}
