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
 * @author Psicops
 */

//Lee imagen y la guarda en escala de grises
//Read and imagen and create a new one on gray scale

//Return a matrix with the color of each pixel 

public class rgbToGrayScale {
    
    public File convertGray(File f) throws IOException
    {
        image pixels = new image(1,1);
        
        BufferedImage img = null;

        //read image
        try{
          img = ImageIO.read(f);
          
          pixels = new image(img.getWidth(),img.getHeight());
          
          for(int x = 0; x < img.getHeight(); x++)
          {
              for(int y = 0; y < img.getWidth(); y++)
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
                  
                  pixels.setPixel(x, y, avg);
                  
                  p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                  
                  img.setRGB(x, y, p);
              }
          }
        }catch(IOException e){
          System.out.println(e);
        }
        
        //write image
        try{
          f = new File("images\\finalImage.png");
          ImageIO.write(img, "png", f);
        }catch(IOException e){
          System.out.println(e);
        }
        return(f);
    }
    
    /*public image getGrayImg(String name) throws IOException
    {
        image pixels = new image(1,1,name);
        
        BufferedImage img = null;
        File f = null;

        //read image
        try{
          f = new File(name);
          img = ImageIO.read(f);
          
          pixels = new image(img.getWidth(),img.getHeight(),name);
          
          for(int x = 0; x < img.getHeight(); x++)
          {
              for(int y = 0; y < img.getWidth(); y++)
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
                  
                  pixels.setPixel(x, y, avg);
                  
                  p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                  
                  img.setRGB(x, y, p);
              }
          }
        }catch(IOException e){
          System.out.println(e);
        }
        
        //write image
        try{
          f = new File("images\\finalImage.png");
          ImageIO.write(img, "png", f);
        }catch(IOException e){
          System.out.println(e);
        }
        return(pixels);
    } */
    
}
