/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import aa.proyecto1.AAProyecto1;

/**
 *
 * @author Jean Carlo
 */
public class divideAndConquer extends Thread{
    int[] genenationTemp = new int[AAProyecto1.generation.length];
    
    int size = AAProyecto1.goalImage.getHeight()*AAProyecto1.goalImage.getHeight();
    int[] goalVector = new int[size];
    
    
    public void start()
    {
        //Convierte la imagen meta en un vector
        for(int x = 0; x < AAProyecto1.goalImage.getHeight(); x++)
            {
                for(int y = 0; y < AAProyecto1.goalImage.getHeight(); y++)
                {
                    goalVector[x+y] = AAProyecto1.goalImage.getPixel(x, y);
                }
            }
        
        //Convierte la generación random en vectores
        for(int i = 0; i < AAProyecto1.generation.length; i++)
        {
            int[] img = new int[size];
            
            for(int x = 0; x < AAProyecto1.goalImage.getHeight(); x++)
            {
                for(int y = 0; y < AAProyecto1.goalImage.getHeight(); y++)
                {
                    img[x+y] = AAProyecto1.generation[i].getPixel(x, y);
                }
            }
        }
        
    }
    
    public void divideAndCoquer()
    {
        
    }
    
    
    @Override
    public void run()
    {
        
    }
}
