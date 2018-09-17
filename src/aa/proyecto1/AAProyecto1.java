/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aa.proyecto1;

import algorithms.*;
import java.io.IOException;
import manejoImagenes.*;
import interfaz.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Jean Carlo
 * @author Psicops
 */

public class AAProyecto1 {    
    
    public static image goalImage;
    public static image[] generation;
    public static ArrayList<image> optimos = new ArrayList();
    public static int NUMERO_GENERACION = 0;
    public static String SELECTED_ALGORITHM = "";
    public static long beginTime;
    public static long endTime;
    
    
    public static void firstGeneration(int height,int width, int tamPob) throws IOException{
        image[] images = new image[tamPob];
        for(int i = 1; i <= tamPob; i++){
            randomImage img = new randomImage(); 
            images[i-1] = img.getImage(height, width, "1");
        }
        generation = images;
        getPNG(generation[0]);
    }
    
    public static void getPNG(image img)
    {
        BufferedImage newImg = new BufferedImage(goalImage.getHeight(), goalImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
        File f = null;
        
        for(int x = 0; x < goalImage.getHeight(); x++)
        {
            for(int y = 0; y < goalImage.getHeight(); y++)
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
    public static void startProgram(){
        Date date = new Date();
        beginTime = date.getTime();
        //Caso 1: obtener la hora y salida por pantalla con formato:
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Hora inicio: "+hourFormat.format(date));
        
        if(SELECTED_ALGORITHM.equals("Euclidean Distance")){
            euclideanDistance start = new euclideanDistance();
            start.run();
        }else if(SELECTED_ALGORITHM.equals("Euclidean Average")){
            euclideanAverage start = new euclideanAverage();
             start.run();
        }else if(SELECTED_ALGORITHM.equals("Divide & Conquer")){
            divideAndConquer start = new divideAndConquer();
            start.run();
        }else{
            JOptionPane.showMessageDialog(null, "Error","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) throws IOException{
        menuInicial Ventana = new menuInicial();
        Ventana.setVisible(true);
    }
    
}

