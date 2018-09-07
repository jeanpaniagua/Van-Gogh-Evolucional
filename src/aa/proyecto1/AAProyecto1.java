/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aa.proyecto1;


import java.io.IOException;
import manejoImagenes.*;
import interfaz.*;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Jean Carlo
 */

public class AAProyecto1 {    
    
    static double mutationProbability = 50;
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
    
    public static void mutate(image img, image goalImage, String name)
    {
        image pixels = new image(img.getHeight(),img.getWidth(),name);
                
        for(int x = 0; x < img.getHeight(); x++)
        {
            for(int y = 0; y < img.getWidth(); y++)
            {
                if(Math.sqrt(Math.pow((goalImage.getPixel(x, y) - img.getPixel(x, y)), 2)) == 0)
                {
                    pixels.setPixel(x, y, img.getPixel(x, y));
                }
                else
                {
                    if(Math.random()*100<=mutationProbability)
                    {             
                        int avg = (int)(Math.random()*256);
                        pixels.setPixel(x, y, avg);
                    }
                }
            }
        }
        
        
        
    }
    
    public static void main(String[] args) throws IOException{
        menuInicial Ventana = new menuInicial();
        Ventana.setVisible(true);
        
        
        rgbToGrayScale img = new rgbToGrayScale();
        File f = new File("images\\finalImage.png");
        image goalImage = img.getGrayImg(f);
        
        image[] generation = firstGeneration(goalImage.getHeight(), goalImage.getWidth(), 10);
       
        double[] difference = getDifference(goalImage, generation);
        
        /*for(int i = 0; i < difference.length; i++)
        {
            System.out.println(difference[i]);
        }*/
        
        
        double bestGenes = difference[0];

        for(int i = 0; i < difference.length; i++)
        {
            System.out.println(difference[i] + "    " + bestGenes);
            if(difference[i] < bestGenes)
            {
                bestGenes = difference[i];
            }
        }
        
        System.out.println("Best: " + bestGenes);
   
    }
    
}

