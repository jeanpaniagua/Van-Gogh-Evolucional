/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import aa.proyecto1.AAProyecto1;
import static aa.proyecto1.AAProyecto1.*;
import static aa.proyecto1.AAProyecto1.goalImage;
import static aa.proyecto1.AAProyecto1.NUMERO_GENERACION;
import static aa.proyecto1.AAProyecto1.generation;
import interfaz.menuInicial;
import java.util.Date;
import manejoImagenes.image;

/**
 *
 * @author curso
 */
public class euclideanDistance {
    
    public static boolean OPTIMO = false;
    
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
        int similar = 0;
        image result = new image(img.getWidth(), img.getHeight(),name);
        
        for(int x = 0; x < img.getHeight(); x++)
        {
            for(int y = 0; y < img.getWidth(); y++)
            {
                int p = 0;
                int pixelDifference = (int)Math.sqrt(Math.pow((goalImage.getPixel(x, y) - img.getPixel(x, y)), 2));
                if(pixelDifference <= 10)
                {
                    p = img.getPixel(x, y);
                    similar++;
                    
                    if(similar >= (int)(img.getHeight()* img.getWidth()* menuInicial.PORCENTAJE_SIMILITUD)){
                        OPTIMO = true;
                    }
                }
                else
                {
                    if(Math.random()*100<=menuInicial.PORCENTAJE_MUTAR)
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
            }
        }
        result.setDifference(difference);
        return result;
    }
    
    public static image[] crossover(image parent1, image parent2, String name1, String name2)
    {        
        image result1 = new image(parent1.getWidth(), parent1.getHeight(), name1);
        image result2 = new image(parent1.getWidth(), parent1.getHeight(), name2);        
        
        image[] result = new image[2];
        
        for(int x = 0; x < parent1.getWidth(); x++)
        {
            int p;
            for(int y = 0; y < parent1.getHeight()/2; y++)
            {
                p = parent1.getPixel(x, y);
                result1.setPixel(x, y, p);
               
                p = parent2.getPixel(x, y);
                result2.setPixel(x, y, p);
            }
            for(int y = parent1.getHeight()/2; y < parent1.getHeight(); y++)
            {
                p = parent2.getPixel(x, y);
                result2.setPixel(x, y, p);
                
                p = parent1.getPixel(x, y);
                result1.setPixel(x, y, p);
            }
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
    
    
    public void run() {
        for(int i = 0; i < generation.length; i++)
        {
            generation[i].setDifference(getDifference(goalImage, generation[i]));
        }
        
        NUMERO_GENERACION = 2;
        while(!OPTIMO)
        {
            System.out.println("Generation: " + NUMERO_GENERACION);
            quickSort(generation, 0, generation.length - 1);         
            
            int i = 1;
            while(i<=generation.length)
            {
                boolean cruzar = Math.random()*100<=menuInicial.PROBABILIDAD_CRUCE;
                if (i == generation.length || cruzar == false){
                    generation[i-1] = mutate(generation[i-1], goalImage, Integer.toString(NUMERO_GENERACION));
                    //System.out.println(Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i) +" Mutate");
                    i++;
                }
                else
                {  
                    int j = i+1;  
                    image[] newImg = crossover(generation[i-1], generation[i], Integer.toString(NUMERO_GENERACION), Integer.toString(NUMERO_GENERACION));
                    newImg[0].setDifference(getDifference(goalImage, newImg[0]));
                    newImg[1].setDifference(getDifference(goalImage, newImg[1]));
                    generation[i-1] = newImg[0];
                    generation[i] = newImg[1];
                    //System.out.println(Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i) + " Crossover");
                    //System.out.println(Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i+1) + " Crossover");

                    i=i+2;
                }
            }
            
            if(NUMERO_GENERACION == 5000)
            {
                OPTIMO = true;
            }
                        
            NUMERO_GENERACION++;
            
            
            quickSort(generation, 0, generation.length-1);            
            
            getPNG(generation[0]);

        }
        Date date = new Date();
        AAProyecto1.endTime = date.getTime();
        long time = AAProyecto1.beginTime - AAProyecto1.endTime;
        System.out.println(time);
        System.out.println("FIN. Terminó con " + NUMERO_GENERACION + " generacciones.");
    }    
 
}
