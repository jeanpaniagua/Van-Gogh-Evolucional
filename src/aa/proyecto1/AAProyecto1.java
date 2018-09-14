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
import thread.*;
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
    
    
    
   
    public static void startProgram()
    {
        euclideanDistance start = new euclideanDistance();
        start.run();
    }
    
    public static void main(String[] args) throws IOException{
        menuInicial Ventana = new menuInicial();
        Ventana.setVisible(true);
        
         
    }
    
}

