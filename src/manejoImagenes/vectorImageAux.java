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
public class vectorImageAux {
    private int[] pixeles;
    private int difference;
    private int similar;

    public int getSimilar() {
        return similar;
    }

    public void setSimilar(int similar) {
        this.similar = similar;
    }
    
    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }
  
    public vectorImageAux(int size) 
    {
        this.pixeles = new int[size];
        this.difference = 0;
    }
    
    public int[] getPixeles() 
    {
        return pixeles;
    }

    public void setPixeles(int[] pixeles) 
    {
        this.pixeles = pixeles;
    }

    public int getPixel(int x) 
    {
        return pixeles[x];
    }

    public void setPixel(int x, int value) 
    {
        this.pixeles[x] = value;
    }
    
    public int getSize()
    {
        return this.pixeles.length;
    }
    
}
