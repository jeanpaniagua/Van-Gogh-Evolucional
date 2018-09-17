/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import aa.proyecto1.AAProyecto1;
import manejoImagenes.*;
import interfaz.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static aa.proyecto1.AAProyecto1.generation;
import static aa.proyecto1.AAProyecto1.goalImage;
import interfaz.menuInicial;
import manejoImagenes.image;

/**
 *
 * @author Jean Carlo
 */
public class divideAndConquer {
    
    /*vectorImage[] genenationVector = new vectorImage[AAProyecto1.generation.length];
    
    int size = AAProyecto1.goalImage.getHeight()*AAProyecto1.goalImage.getHeight();
    vectorImage goalVector = new vectorImage(size, AAProyecto1.goalImage.getName(), 4);
    
    private static boolean OPTIMO = false;
    public static int NUMERO_GENERACION = 0;
    
    /*public void start()
    {
        //Convierte la imagen meta en un vector
        BufferedImage newImg = new BufferedImage(AAProyecto1.goalImage.getHeight(), AAProyecto1.goalImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
        File f = null;
        for(int x = 1; x <= AAProyecto1.goalImage.getHeight(); x++)
        {
            for(int y = 1; y <= AAProyecto1.goalImage.getWidth(); y++)
            {
               goalVector.setPixel(x*y-1, AAProyecto1.goalImage.getPixel(x-1, y-1));
            }
        } 
        
        
        //Convierte la generación random en vectores
        for(int i = 0; i < AAProyecto1.generation.length; i++)
        {
            vectorImage img = new vectorImage(size, AAProyecto1.generation[i].getName(), 4);
            
            for(int x = 1; x <= AAProyecto1.goalImage.getHeight(); x++)
            {
                for(int y = 1; y <= AAProyecto1.goalImage.getWidth(); y++)
                {
                    img.setPixel(x*y-1, AAProyecto1.generation[i].getPixel(x-1, y-1));
                }
            }
            genenationVector[i] = img;
        }
    }*/
    
    
    /*public static image mutateAux(int[][] vector, int[][] goal)
    {
        int similar = 0;
        image result = new image(vector.);
        int difference = 0;
        for(int i = 0; i < vector.length; i++)
        {
            int pixelDifference = (int)Math.sqrt(Math.pow((goal[i] - vector[i]), 2));
            //int pixelDifference = Math.abs(goal[i]-vector[i]);
            
            if(pixelDifference==0)
            {
                result.setPixel(i, vector[i]);
                similar++;
            }
            else
            {
                if(Math.random()*100<=menuInicial.PORCENTAJE_CRUCE)
                {
                    //result.setPixel(i, (int)(Math.random()*256));
                    if(goal[i]<vector[i])
                    {
                        result.setPixel(i, (int)(Math.random()*vector[i]));
                    }
                    else
                    {
                        result.setPixel(i, (int)(Math.random()*pixelDifference + vector[i]));
                    }
                    pixelDifference = Math.abs(goal[i]-vector[i]);                   
                }
                else
                {
                    result.setPixel(i, vector[i]);
                }
            }
            difference = difference + pixelDifference;
        }
        result.setSimilar(similar);
        result.setDifference(difference);
        return result;
    }
    
    
    
    public static vectorImage mutate(vectorImage img, vectorImage goalImage, String name)
    {
        vectorImage result = new vectorImage(img.getSize(), name, 0);
        vectorImageAux aux1 = mutateAux(img.getPixeles(), goalImage.getPixeles());
        result.setPixeles(aux1.getPixeles());
        result.setDifference(aux1.getDifference());
        if(aux1.getSimilar() >= (int)(img.getSize()*0.99)){
            OPTIMO = true;
        }
        return result;
    }
    
    
    /*public static image mutate(image img, image goalImage, String name)
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
                if(pixelDifference == 0)
                {
                    p = img.getPixel(x, y);
                    similar++;
                    
                    if(similar >= (int)(img.getHeight()* img.getWidth()*0.95)){
                        OPTIMO = true;
                    }
                }
                else
                {
                    if(Math.random()*100<=menuInicial.PORCENTAJE_CRUCE)
                    {             
                        //p = (int)(Math.random()*256);
                        /*if(goalImage.getPixel(x, y)<img.getPixel(x, y))
                        {
                            p = (int)(Math.random()*img.getPixel(x, y));
                        }
                        else
                        {
                            p = (int)(Math.random()*pixelDifference + img.getPixel(x, y));
                        }
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
    
    
    public void getPNG(image img)
    {
        BufferedImage newImg = new BufferedImage(AAProyecto1.goalImage.getHeight(), AAProyecto1.goalImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
        File f = null;
        
        for(int x = 0; x < AAProyecto1.goalImage.getHeight(); x++)
        {
            for(int y = 0; y < AAProyecto1.goalImage.getHeight(); y++)
           {
               int p = img.getPixel(x,y);
               p = (255<<24) | (p<<16) | (p<<8) | p;
               newImg.setRGB(x, y, p);
            }
        } 
        try{
          f = new File("images\\"+img.getName()+".png");
          ImageIO.write(newImg, "png", f);
        }catch(IOException e){
          System.out.println(e);
        }
    }
    
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
    
    public void run()
    {
        
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
                    generation[i-1] = mutate(generation[i-1], goalImage, Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i));
                    System.out.println(Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i) +" Mutate");
                    i++;
                }
                else
                {  
                    int j = i+1;  
                    image[] newImg = crossover(generation[i-1], generation[i], Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i), Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(j));
                    newImg[0].setDifference(getDifference(goalImage, newImg[0]));
                    newImg[1].setDifference(getDifference(goalImage, newImg[1]));
                    generation[i-1] = newImg[0];
                    generation[i] = newImg[1];
                    System.out.println(Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i) + " Crossover");
                    System.out.println(Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i+1) + " Crossover");

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
            System.out.println(genenationVector[0].getDifference());

        }
        System.out.println("FIN. Terminó con " + NUMERO_GENERACION + " generacciones.");
    }  
        
       
        
        /*NUMERO_GENERACION = 2;
        while(!OPTIMO)
        {
            System.out.println("Generation: " + NUMERO_GENERACION);     
            
            int i = 1;
            while(i<=generation.length)
            {
                System.out.println("OK");
                boolean cruzar = Math.random()*100<=menuInicial.PROBABILIDAD_CRUCE;
                if (i == generation.length || cruzar == false){
                    generation[i-1] = mutate(generation[i-1], goalImage, Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i));
                    //System.out.println(Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i) +" Mutate");
                    i++;
                }
                else
                {    
                    image[] newImg = crossover(generation[i-1], generation[i], Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i), Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i+1));
                    newImg[0].setDifference(getDifference(goalImage, newImg[0]));
                    newImg[1].setDifference(getDifference(goalImage, newImg[1]));
                    generation[i-1] = newImg[0];
                    generation[i] = newImg[1];
                    //System.out.println(Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i) + " Crossover");
                    //System.out.println(Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i+1) + " Crossover");
                    i=i+2;
                }
                
            }
            
            
            quickSort(generation, 0, generation.length-1);
            
            
            getPNG(generation[0]);
            System.out.println(genenationVector[0].getDifference());
           
            
            if(NUMERO_GENERACION == 5000)
            {
                OPTIMO = true;
            }
                        
            NUMERO_GENERACION++;
            
            

        }
        System.out.println("FIN. Terminó con " + NUMERO_GENERACION + " generacciones.");

    }*/
    
    
    private static boolean OPTIMO = false;
    public static int NUMERO_GENERACION = 0;
    
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
                    
                    if(similar >= (int)(img.getHeight()* img.getWidth()*0.99)){
                        OPTIMO = true;
                    }
                }
                else
                {
                    if(Math.random()*100<=menuInicial.PORCENTAJE_CRUCE)
                    {             
                        //p = (int)(Math.random()*256);  
                        if(goalImage.getPixel(x, y)<img.getPixel(x, y))
                        {
                            p = (int)(Math.random()*img.getPixel(x, y));
                        }
                        else
                        {
                            p = (int)(Math.random()*pixelDifference + img.getPixel(x, y));
                        }
                    }
                    else
                    {
                        p = img.getPixel(x, y);
                    }
                    difference = difference + (int)Math.sqrt(Math.pow((goalImage.getPixel(x, y) - p), 2));
                }
                result.setPixel(x, y, p);
                p = (255<<24) | (p<<16) | (p<<8) | p;
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
    
    public void getPNG(image img)
    {
        BufferedImage newImg = new BufferedImage(AAProyecto1.goalImage.getHeight(), AAProyecto1.goalImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
        File f = null;
        
        for(int x = 0; x < AAProyecto1.goalImage.getHeight(); x++)
        {
            for(int y = 0; y < AAProyecto1.goalImage.getHeight(); y++)
           {
               int p = img.getPixel(x,y);
               p = (255<<24) | (p<<16) | (p<<8) | p;
               newImg.setRGB(x, y, p);
            }
        } 
        try{
          f = new File("images\\"+img.getName()+".png");
          ImageIO.write(newImg, "png", f);
        }catch(IOException e){
          System.out.println(e);
        }
    }
    
    public void run() {
        
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
                    generation[i-1] = mutate(generation[i-1], goalImage, Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i));
                    //System.out.println(Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i) +" Mutate");
                    i++;
                }
                else
                {  
                    int j = i+1;  
                    image[] newImg = crossover(generation[i-1], generation[i], Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(i), Integer.toString(NUMERO_GENERACION) + "." + Integer.toString(j));
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
            System.out.println(generation[0].getDifference());
            
            
            getPNG(generation[0]);
 

        }
        System.out.println("FIN. Terminó con " + NUMERO_GENERACION + " generacciones.");
    }
}
