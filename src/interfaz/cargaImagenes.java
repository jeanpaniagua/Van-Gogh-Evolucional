/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Psicops
 */
public class cargaImagenes {
    
    //private BufferedImage imagenCargada;
    
    public File buscador(){
        
        BufferedImage img = null;
        File imagenSeleccionada = null;
        JFileChooser buscador = new JFileChooser();
        buscador.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter extension = new FileNameExtensionFilter("PNG & JPG & GIF & BMP", "png", "jpg", "gif", "bmp");
        buscador.setFileFilter(extension);
        int flag=buscador.showOpenDialog(null);
        if(flag==JFileChooser.APPROVE_OPTION){
            try{
                imagenSeleccionada = buscador.getSelectedFile();
                //img = ImageIO.read(imagenSeleccionada);
            }
            catch (Exception e){
            }
        }
        //imagenCargada=img;
        return imagenSeleccionada;
    }
    
}
