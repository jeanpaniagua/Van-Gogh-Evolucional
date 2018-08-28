/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aa.proyecto1;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import manejoImagenes.*;


/**
 *
 * @author Jean Carlo
 */
public class AAProyecto1 {    
    
    public static void firstGeneration(int width, int height) throws IOException
    {
        for(int i = 0; i < 10; i++)
        {
            randomImage img = new randomImage(); 
            img.getImage(width, height, "1."+i);
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        
        rgbToGrayScale img = new rgbToGrayScale();
        int[][] pixels = img.getGrayImg("images\\test.png");
        
        firstGeneration(pixels.length, pixels[0].length);        
        
    }
    
}

