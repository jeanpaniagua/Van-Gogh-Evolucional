/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import static aa.proyecto1.AAProyecto1.firstGeneration;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import manejoImagenes.randomImage;
import manejoImagenes.rgbToGrayScale;

/**
 *
 * @author Psicops
 */
public class interfaz extends javax.swing.JFrame {
    
    private cargaImagenes imagen = new cargaImagenes();
    private BufferedImage img = null;
    private File imgSelec = null;
    private BufferedImage randomImg = null;
    private File imgRand = null;
            
    public interfaz() {
        initComponents();
        convertor.setEnabled(false);
        randomCreate.setEnabled(false);
        mutate.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new javax.swing.JPanel();
        lblMeta = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        lblSeleccionada = new javax.swing.JLabel();
        imageSelect = new javax.swing.JButton();
        randomCreate = new javax.swing.JButton();
        convertor = new javax.swing.JButton();
        mutate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        panel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMeta.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMeta, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblSeleccionada.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSeleccionada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSeleccionada, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        imageSelect.setText("Seleccionar Imagen");
        imageSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageSelectActionPerformed(evt);
            }
        });

        randomCreate.setText("Evolucionar");
        randomCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomCreateActionPerformed(evt);
            }
        });

        convertor.setText("Convertir a Grises");
        convertor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertorActionPerformed(evt);
            }
        });

        mutate.setText("Mostrar Resultados");
        mutate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mutateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(7, Short.MAX_VALUE)
                        .addComponent(randomCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(convertor, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(mutate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(convertor)
                    .addComponent(imageSelect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mutate)
                    .addComponent(randomCreate))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imageSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageSelectActionPerformed
        imgSelec = imagen.buscador();
        try {
            img = ImageIO.read(imgSelec);
        } catch (IOException e){
            System.out.println(e);
        }
        ImageIcon selectedImg = new ImageIcon(img);
        Icon selectedIcon = new ImageIcon(selectedImg.getImage().getScaledInstance(lblSeleccionada.getWidth(), 
                lblSeleccionada.getHeight(), Image.SCALE_DEFAULT));
        lblSeleccionada.setIcon(selectedIcon);
        convertor.setEnabled(true);
    }//GEN-LAST:event_imageSelectActionPerformed

    private void convertorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertorActionPerformed
        rgbToGrayScale toGray = new rgbToGrayScale();
        try{
           toGray.getGrayImg(imgSelec);
           imgSelec = new File("images\\finalImage.png");
           img = ImageIO.read(imgSelec);
        }catch (IOException e){
            System.out.println(e);
        }
        ImageIcon selectedImg = new ImageIcon(img);
        Icon selectedIcon = new ImageIcon(selectedImg.getImage().getScaledInstance(lblMeta.getWidth(), lblMeta.getHeight(), 
                Image.SCALE_DEFAULT));
        lblMeta.setIcon(selectedIcon);
        imageSelect.setEnabled(false);
        convertor.setEnabled(false);
        randomCreate.setEnabled(true);
    }//GEN-LAST:event_convertorActionPerformed

    private void randomCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomCreateActionPerformed
        try{
            firstGeneration(img.getHeight(), img.getWidth(), menuInicial.TAMAÑO_POBLACION);
        }catch (IOException ex) {
            System.out.println(ex);
        }
//        randomImage randImg = new randomImage();
//        try {
//           randImg.getImage(32, 32, "1.0");
//           imgRand = new File("images\\random1.0.png");
//           randomImg = ImageIO.read(imgRand);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//        ImageIcon selectedImg = new ImageIcon(randomImg);
//        Icon selectedIcon = new ImageIcon(selectedImg.getImage().getScaledInstance(lblSeleccionada.getWidth(), 
//                lblSeleccionada.getHeight(), Image.SCALE_DEFAULT));
//        lblSeleccionada.setIcon(selectedIcon);
        mutate.setEnabled(true);
    }//GEN-LAST:event_randomCreateActionPerformed

    private void mutateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutateActionPerformed
        randomCreate.setEnabled(false);
    }//GEN-LAST:event_mutateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton convertor;
    private javax.swing.JButton imageSelect;
    private javax.swing.JLabel lblMeta;
    private javax.swing.JLabel lblSeleccionada;
    private javax.swing.JButton mutate;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JButton randomCreate;
    // End of variables declaration//GEN-END:variables
}
