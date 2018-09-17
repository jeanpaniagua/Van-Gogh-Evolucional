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
public class vectorImage {
    private int[] pixeles;
    private int difference;
    private int size;
    private int[] differenceList;
    private String name;

    public vectorImage(int size, String name, int differenceSize) {
        this.size = size;
        this.name = name;
        this.difference = 0;
        this.differenceList = new int[differenceSize];
        this.pixeles = new int[size];
    }

    public int[] getPixeles() {
        return pixeles;
    }

    public void setPixeles(int[] pixeles) {
        this.pixeles = pixeles;
    }
    
    public int getPixel(int i) {
        return pixeles[i];
    }

    public void setPixel(int i, int value) {
        this.pixeles[i] = value;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getDifferenceList() {
        return differenceList;
    }

    public void setDifferenceList(int[] differenceList) {
        this.differenceList = differenceList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    
    
    
}
