/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aa.proyecto1;


import java.io.IOException;
import manejoImagenes.*;


/**
 *
 * @author Jean Carlo
 */

public class AAProyecto1 {    
    
    public static image[] firstGeneration(int height,int width) throws IOException
    { 
        image[] images = new image[10];
                
        for(int i = 0; i < 10; i++)
        {
            randomImage img = new randomImage(); 
            images[i] = img.getImage(height, width, "1."+i);
        }
        return images;
    }
    
    public static void main(String[] args) throws IOException
    {
        rgbToGrayScale img = new rgbToGrayScale();
        image pixels = img.getGrayImg("images\\test.png");
        
        image[] images = firstGeneration(pixels.getHeight(), pixels.getWidth());

        
   
    }
    
}

