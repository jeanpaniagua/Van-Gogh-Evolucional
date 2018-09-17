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
    
    public image getImage(int width, int height, String name) throws IOException
    {
       //System.out.println(name);
       image pixels = new image(width,height,name);

       
       for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width; y++)
            {
                int avg = (int)(Math.random()*256);
                pixels.setPixel(x, y, avg);
            }
        }
       
        return(pixels);
    }
}
