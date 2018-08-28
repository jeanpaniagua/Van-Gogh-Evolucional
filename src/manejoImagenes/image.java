/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoImagenes;

/**
 *
 * @author Jean Carlo
 */
public class image {
    private int[][] pixeles;
    private String name;
    

    public image(int height, int width, String name) 
    {
        this.pixeles = new int[height][width];
        this.name = name;
    }

    public int[][] getPixeles() 
    {
        return pixeles;
    }

    public void setPixeles(int[][] pixeles) 
    {
        this.pixeles = pixeles;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    public int getPixel(int height, int width) 
    {
        return pixeles[height][width];
    }

    public void setPixel(int height, int width, int value) 
    {
        this.pixeles[height][width] = value;
    }
    
    public int getHeight()
    {
        return this.pixeles.length;
    }
    
    public int getWidth()
    {
        return this.pixeles[0].length;
    }

}
