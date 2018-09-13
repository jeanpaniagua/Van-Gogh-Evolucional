/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Psicops
 */
public class cargaImagen {
    
    //private BufferedImage imagenCargada;
    
    public File buscador(){
        
        File imagenSeleccionada = null;
        JFileChooser buscador = new JFileChooser();
        buscador.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter extension = new FileNameExtensionFilter("PNG & JPG & GIF & BMP", "png", "jpg", "gif", "bmp");
        buscador.setFileFilter(extension);
        int flag=buscador.showOpenDialog(null);
        if(flag==JFileChooser.APPROVE_OPTION){
            try{
                imagenSeleccionada = buscador.getSelectedFile();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        return imagenSeleccionada;
    }
    
}
