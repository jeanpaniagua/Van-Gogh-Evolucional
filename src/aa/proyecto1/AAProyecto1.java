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
    
    public static void firstGeneration(int height,int width, int tamPob) throws IOException{
        image[] images = new image[tamPob];
        for(int i = 1; i <= tamPob; i++){
            randomImage img = new randomImage(); 
            images[i-1] = img.getImage(height, width, "1."+i);
        }
        generation = images;
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
    
    public static image mutate(image img, image goalImage, String name)
    {
        image result = new image(img.getWidth(), img.getHeight(),name);
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
                result.setPixel(x, y, p);
                p = (255<<24) | (p<<16) | (p<<8) | p;
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
    
   
    public static void startProgram()
    {
        Boolean stop = false;

        int generationCount = 2;
        while(!stop)
        {
            System.out.println("Generation: " + generationCount);
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
                    generation[i-1] = newImg[0];
                    generation[i] = newImg[1];
                    System.out.println(Integer.toString(generationCount) + "." + Integer.toString(i) + " Crossover");
                    i=i+2;
                }
            }
            
            if(generationCount == 1000)
            {
                stop = true;
            }
                        
            generationCount++;

        }
    }
    
    public static void main(String[] args) throws IOException{
        menuInicial Ventana = new menuInicial();
        Ventana.setVisible(true);
        
         
    }
    
}

