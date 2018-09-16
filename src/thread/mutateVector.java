/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;
import interfaz.menuInicial;
/**
 *
 * @author Jean Carlo
 */
public class mutateVector extends Thread{
    
    int[] vector;
    int[] goal;
    int difference;

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public int[] getGoal() {
        return goal;
    }

    public void setGoal(int[] goal) {
        this.goal = goal;
    }

    public int getDiference() {
        return difference;
    }

    public void setDiference(int diference) {
        this.difference = diference;
    }

    public mutateVector(int[] vector, int[] goal) {
        this.vector = vector;
        this.goal = goal;
    }
    
    
     @Override
    public void run() 
    {
        for(int i = 0; i < vector.length; i++)
        {
            int pixelDifference = Math.abs(goal[i]-vector[i]);
            if(goal[i]!=vector[i] && pixelDifference>10)
            {
                if(Math.random()*100<=menuInicial.PORCENTAJE_CRUCE)
                {
                    if(goal[i]<vector[i])
                    {
                        vector[i] = (int)(Math.random()*vector[i]);
                    }
                    else
                    {
                       vector[i] = (int)(Math.random()*pixelDifference) + vector[i];
                    }
                    pixelDifference = Math.abs(goal[i]-vector[i]);                    
                }
            }
            difference = difference + pixelDifference;
        } 
    }
}
