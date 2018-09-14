/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import static aa.proyecto1.AAProyecto1.generation;
import static aa.proyecto1.AAProyecto1.goalImage;
import interfaz.menuInicial;
import manejoImagenes.image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author curso
 */
public class euclideanDistance extends Thread{
    
    public static int getDifference(image goalImage, image img)
    {
        int result = 0;
        for(int x = 0; x < goalImage.getHeight(); x++)
        {
            for(int y = 0; y < goalImage.getWidth(); y++)
            {
                result = result + (int)Math.sqrt(Math.pow((goalImage.getPixel(x, y) - img.getPixel(x, y)), 2));
            }
        }
        return result;
    }
    
    public static image mutate(image img, image goalImage, String name)
    {
        int difference = 0;
        
        image result = new image(img.getWidth(), img.getHeight(),name);
        BufferedImage newImg = new BufferedImage(img.getWidth(), img.getHeight(),  BufferedImage.TYPE_INT_ARGB);
        File f = null;
        
        for(int x = 0; x < img.getHeight(); x++)
        {
            for(int y = 0; y < img.getWidth(); y++)
            {
                int p = 0;
                int pixelDifference = (int)Math.sqrt(Math.pow((goalImage.getPixel(x, y) - img.getPixel(x, y)), 2));
                if(pixelDifference == 0)
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
                    difference = difference + (int)Math.sqrt(Math.pow((goalImage.getPixel(x, y) - p), 2));
                }
                result.setPixel(x, y, p);
                p = (255<<24) | (p<<16) | (p<<8) | p;
                newImg.setRGB(x, y, p); 
            }
        }
        //write image
        try{
          f = new File("images\\"+name+".png");
          ImageIO.write(newImg, "png", f);
        }catch(IOException e){
          System.out.println(e);
        }  
        result.setDifference(difference);
        return result;
    }
    
    public static image[] crossover(image parent1, image parent2, String name1, String name2)
    {        
        image result1 = new image(parent1.getWidth(), parent1.getHeight(), name1);
        image result2 = new image(parent1.getWidth(), parent1.getHeight(), name2);
        BufferedImage newImg1 = new BufferedImage(parent1.getWidth(), parent1.getHeight(),  BufferedImage.TYPE_INT_ARGB);
        BufferedImage newImg2 = new BufferedImage(parent1.getWidth(), parent1.getHeight(),  BufferedImage.TYPE_INT_ARGB);
        File f = null;
        
        
        image[] result = new image[2];
        
        
        for(int x = 0; x < parent1.getWidth(); x++)
        {
            int p;
            for(int y = 0; y < parent1.getHeight()/2; y++)
            {
                p = parent1.getPixel(x, y);
                result1.setPixel(x, y, p);
                
                p = (255<<24) | (p<<16) | (p<<8) | p;
                newImg1.setRGB(x, y, p);
               
                p = parent2.getPixel(x, y);
                result2.setPixel(x, y, p);
                
                p = (255<<24) | (p<<16) | (p<<8) | p;
                newImg2.setRGB(x, y, p);
            }
            for(int y = parent1.getHeight()/2; y < parent1.getHeight(); y++)
            {
                p = parent2.getPixel(x, y);
                result2.setPixel(x, y, p);
                
                p = (255<<24) | (p<<16) | (p<<8) | p;
                newImg1.setRGB(x, y, p);
                
                p = parent1.getPixel(x, y);
                result1.setPixel(x, y, p);
                
                p = (255<<24) | (p<<16) | (p<<8) | p;
                newImg2.setRGB(x, y, p);
            }
        }
        
        //write image
        try{
          f = new File("images\\"+name1+".png");
          ImageIO.write(newImg1, "png", f);
          f = new File("images\\"+name2+".png");
          ImageIO.write(newImg2, "png", f);
        }catch(IOException e){
          System.out.println(e);
        }    
        result[0] = result1;
        result[1] = result2;
        return (result);
    }
    
    public static void quickSort(image[] vector, int left, int right) {
        image pivote = vector[left];
        int i = left;
        int j = right;
        image auxIntercambio;
        while (i < j) {
            while (vector[i].getDifference() <= pivote.getDifference() && i < j) {
                i++;
            }
            while (vector[j].getDifference() > pivote.getDifference()) {
                j--;
            }
            if (i < j) {
                auxIntercambio = vector[i];
                vector[i] = vector[j];
                vector[j] = auxIntercambio;
            }
        }
        vector[left] = vector[j];
        vector[j] = pivote;
        if (left < j - 1) {
            quickSort(vector, left, j - 1);
        }
        if (j + 1 < right) {
            quickSort(vector, j + 1, right);
        }
    }
    
    
    
    @Override
    public void run() {
        Boolean stop = false;
        for(int i = 0; i < generation.length; i++)
        {
            generation[i].setDifference(getDifference(goalImage, generation[i]));
        }
        
        int generationCount = 2;
        while(!stop)
        {
            System.out.println("Generation: " + generationCount);
            
            quickSort(generation, 0, generation.length - 1);         
            
            int i = 1;
            while(i<=generation.length)
            {
                boolean cruzar = Math.random()*100<=menuInicial.PROBABILIDAD_CRUCE;
                if (i == generation.length || cruzar == false){
                    generation[i-1] = mutate(generation[i-1], goalImage, Integer.toString(generationCount) + "." + Integer.toString(i));
                    System.out.println(Integer.toString(generationCount) + "." + Integer.toString(i) +" Mutate");
                    i++;
                }
                
                else
                {  
                    int j = i+1;  
                    image[] newImg = crossover(generation[i-1], generation[i], Integer.toString(generationCount) + "." + Integer.toString(i), Integer.toString(generationCount) + "." + Integer.toString(j));
                    newImg[0].setDifference(getDifference(goalImage, newImg[0]));
                    newImg[1].setDifference(getDifference(goalImage, newImg[1]));
                    generation[i-1] = newImg[0];
                    generation[i] = newImg[1];
                    System.out.println(Integer.toString(generationCount) + "." + Integer.toString(i) + " Crossover");
                    i=i+2;
                }
            }
            
            if(generationCount == 50000)
            {
                stop = true;
            }
                        
            generationCount++;

        }
    }    
 
}
