/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aa.proyecto1;


import java.io.IOException;
import manejoImagenes.*;
import interfaz.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Jean Carlo
 */

public class AAProyecto1 {    
    
    public static image[] generation;
    
    public static ArrayList<String> paths = new ArrayList();
    
    public static image[] firstGeneration(int height,int width, int tamPob) throws IOException{
        image[] images = new image[tamPob];
        for(int i = 0; i < tamPob; i++){
            randomImage img = new randomImage(); 
            images[i] = img.getImage(height, width, "1."+i);
        }
        return images;
    }
    
    public static double[] getDifference(image goalImage, image[] generation)
    {
        double[] results = new double[generation.length];
        for(int i = 0; i < generation.length; i++)
        {
            double result = 0;
            for(int x = 0; x < goalImage.getHeight(); x++)
            {
                for(int y = 0; y < goalImage.getWidth(); y++)
                {
                    result = result + Math.sqrt(Math.pow((goalImage.getPixel(x, y) - generation[i].getPixel(x, y)), 2));
                }
            }
           results[i] = result;
        }
        return results;
    }
    
    public static image mutate(image img, image goalImage, String name)
    {
        image pixels = new image(img.getWidth(), img.getHeight(),name);
        BufferedImage newImg = new BufferedImage(img.getWidth(), img.getHeight(),  BufferedImage.TYPE_INT_ARGB);
        File f = null;
       
        for(int x = 0; x < img.getWidth(); x++)
        {
            for(int y = 0; y < img.getHeight(); y++)
            {
                int p = 0;
                if(Math.sqrt(Math.pow((goalImage.getPixel(x, y) - img.getPixel(x, y)), 2)) == 0)
                {
                    p = img.getPixel(x, y);
                    
                }
                else
                {
                    if(Math.random()*100<=menuInicial.PORCENTAJE_MUTACION)
                    {             
                        p = (int)(Math.random()*256);
                        
                    }
                    else
                    {
                        p = img.getPixel(x, y);
                    }
                }
                pixels.setPixel(x, y, p);
                newImg.setRGB(y, x, p); 
            }
        }
        //write image
        try{
          f = new File("images\\"+name+".png");
          ImageIO.write(newImg, "png", f);
        }catch(IOException e){
          System.out.println(e);
        }  
        
        return (pixels);
    }
    
    public static image[] crossover(image img1, image img2, String name1, String name2)
    {
        image result1 = new image(img1.getWidth(), img1.getHeight(),name1);
        image result2 = new image(img1.getWidth(), img1.getHeight(),name2);
        
        image[] result = new image[2];
        
        BufferedImage newImg1 = new BufferedImage(img1.getWidth(), img1.getHeight(),  BufferedImage.TYPE_INT_ARGB);
        File f1 = null;
        
        BufferedImage newImg2 = new BufferedImage(img1.getWidth(), img1.getHeight(),  BufferedImage.TYPE_INT_ARGB);
        File f2 = null;
        
        for(int x = 0; x < img1.getWidth(); x++)
        {
            for(int y = 0; y < img1.getHeight()/2; y++)
            {
                int p = img1.getPixel(x, y);
                result1.setPixel(x, y, p);
                newImg1.setRGB(x, y, p);
                
                p = img2.getPixel(x, y);
                result2.setPixel(x, y, p);
                newImg2.setRGB(x, y, p);
            }     
            for(int y = img1.getHeight()/2; y < img1.getHeight(); y++)
            {
                int p = img2.getPixel(x, y);
                result1.setPixel(x, y, p);
                newImg1.setRGB(x, y, p);
                
                p = img1.getPixel(x, y);
                result2.setPixel(x, y, p);
                newImg2.setRGB(x, y, p);
            } 
        }
        try{
          f1 = new File("images\\"+name1+".png");
          ImageIO.write(newImg1, "png", f1);
          f2 = new File("images\\"+name2+".png");
          ImageIO.write(newImg1, "png", f2);
        }catch(IOException e){
          System.out.println(e);
        }
        
        result[0]=result1;
        result[1]=result2;
        return(result);
    }
    
    public static void main(String[] args) throws IOException{
        menuInicial Ventana = new menuInicial();
        Ventana.setVisible(true);
        
        /*double[] difference = getDifference(goalImage, generation);
        
        for(int i = 0; i < difference.length; i++)
        {
            System.out.println(difference[i]);
        }*/
        
        
       /* double bestGenes = difference[0];

        for(int i = 0; i < difference.length; i++)
        {
            System.out.println(difference[i] + "    " + bestGenes);
            if(difference[i] < bestGenes)
            {
                bestGenes = difference[i];
            }
        }
        
        System.out.println("Best: " + bestGenes);*/   
    }
    
}

