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
    
    public static image goalImage;
    public static image[] generation;
    public static ArrayList<image> optimos = new ArrayList();
    
    public static image[] firstGeneration(int height,int width, int tamPob) throws IOException{
        image[] images = new image[tamPob];
        for(int i = 0; i < tamPob; i++){
            randomImage img = new randomImage(); 
            images[i] = img.getImage(height, width, "1."+i);
        }
        return images;
    }
    
    public static void getDifference(image goalImage, image[] generation)
    {
        for(int i = 0; i < generation.length; i++)
        {
            int result = 0;
            for(int x = 0; x < goalImage.getHeight(); x++)
            {
                for(int y = 0; y < goalImage.getWidth(); y++)
                {
                    result = result + (int)Math.sqrt(Math.pow((goalImage.getPixel(x, y) - generation[i].getPixel(x, y)), 2));
                }
            }
            generation[i].setDifference(result);
        }
    }
    
    public static void mutate(image img, image goalImage, String name)
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
    }
    
    public static void startProgram()
    {
        Boolean stop = false;
        
        while(!stop)
        {
            getDifference(goalImage, generation); 
            
            image bestGenes = generation[0];

            for(int i = 0; i < generation.length; i++)
            {
                if(generation[i].getDifference() < bestGenes.getDifference())
                {
                    bestGenes = generation[i];
                }
            }
            
            optimos.add(bestGenes);
            
            
            
                        
            
            stop = true;

        }
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

