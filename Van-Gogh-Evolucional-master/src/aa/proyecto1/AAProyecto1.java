/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aa.proyecto1;


import java.io.IOException;
import manejoImagenes.*;
import interfaz.*;
import java.util.ArrayList;

/**
 *
 * @author Jean Carlo
 */

public class AAProyecto1 {    
    
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
    
    public static void main(String[] args) throws IOException{
        menuInicial Ventana = new menuInicial();
        Ventana.setVisible(true);
        /*rgbToGrayScale img = new rgbToGrayScale();
        image goalImage = img.getGrayImg("images\\test.png");
        
        image[] generation = firstGeneration(goalImage.getHeight(), goalImage.getWidth());
       
        double[] difference = getDifference(goalImage, generation);
        
        for(int i = 0; i < difference.length; i++)
        {
            System.out.println(difference[i]);
        }*/
   
    }
    
}

