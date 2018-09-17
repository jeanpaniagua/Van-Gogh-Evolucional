/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import aa.proyecto1.AAProyecto1;
import static aa.proyecto1.AAProyecto1.firstGeneration;
import static aa.proyecto1.AAProyecto1.NUMERO_GENERACION;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import manejoImagenes.rgbToGrayScale;

/**
 *
 * @author Psicops
 */
public class interfaz extends javax.swing.JFrame {
    
    public cargaImagen imagen = new cargaImagen();
    public BufferedImage img = null;
    public File imgSelec = null;
            
    public interfaz() {
        initComponents();
        iniciarPrograma.setEnabled(false);
        resultados.setEnabled(false);
        tamPob.setText("" + menuInicial.TAMAÑO_POBLACION);
        probCruce.setText("" + menuInicial.PROBABILIDAD_CRUCE);
        porcCruce.setText("" + menuInicial.PORCENTAJE_MUTAR);
        menosAptos.setText("" + menuInicial.PORCENTAJE_MENOS_APTOS);
        selectedAlgo.setText("" + AAProyecto1.SELECTED_ALGORITHM);
    }

//    class interfaceThread extends Thread{
//        @Override
//        public void run(){
//            while(true){
//                numGen.setText("" + (euclideanDistance.NUMERO_GENERACION - 1));
//            }
//        }
//    }
    
    public void update()
    {
        try{
           imgSelec = new File(AAProyecto1.optimos.get(AAProyecto1.optimos.size()-1).getName());
           img = ImageIO.read(imgSelec);
        }catch (IOException e){
            System.out.println(e);
        }
        ImageIcon selectedImg = new ImageIcon(img);
        Icon selectedIcon = new ImageIcon(selectedImg.getImage().getScaledInstance(lblSeleccionada.getWidth(), lblSeleccionada.getHeight(), 
                Image.SCALE_DEFAULT));
        imageSelect.setIcon(selectedIcon);
    }

    public interfaz(JButton convertor, JButton imageSelect, JLabel lblMeta, JLabel lblSeleccionada, JButton mutate, JPanel panel1, JPanel panel2, JButton randomCreate) throws HeadlessException {
        this.imageSelect = imageSelect;
        this.lblSeleccionada = lblSeleccionada;
        this.resultados = mutate;
        this.panel1 = panel1;
        this.iniciarPrograma = randomCreate;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        lblSeleccionada = new javax.swing.JLabel();
        imageSelect = new javax.swing.JButton();
        iniciarPrograma = new javax.swing.JButton();
        resultados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tamPob = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        probCruce = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        porcCruce = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        menosAptos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        numGen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        selectedAlgo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(111, 16));
        setMinimumSize(new java.awt.Dimension(111, 16));
        setResizable(false);

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

        iniciarPrograma.setText("Iniciar Programa");
        iniciarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarProgramaActionPerformed(evt);
            }
        });

        resultados.setText("Mostrar Resultados");
        resultados.setMaximumSize(new java.awt.Dimension(125, 32));
        resultados.setMinimumSize(new java.awt.Dimension(125, 32));
        resultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultadosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        jLabel1.setText("Parámetros Ingresados:");

        jLabel2.setText("Tamaño Población:");
        jLabel2.setMaximumSize(new java.awt.Dimension(111, 16));
        jLabel2.setMinimumSize(new java.awt.Dimension(111, 16));

        tamPob.setMaximumSize(new java.awt.Dimension(111, 16));
        tamPob.setMinimumSize(new java.awt.Dimension(111, 16));

        jLabel3.setText("Probabilidad Cruce:");

        probCruce.setMaximumSize(new java.awt.Dimension(111, 16));
        probCruce.setMinimumSize(new java.awt.Dimension(111, 16));

        jLabel5.setText("Porcentaje a Mutar:");

        porcCruce.setMaximumSize(new java.awt.Dimension(111, 16));
        porcCruce.setMinimumSize(new java.awt.Dimension(111, 16));

        jLabel7.setText("% Menos Aptos:");
        jLabel7.setMaximumSize(new java.awt.Dimension(111, 16));
        jLabel7.setMinimumSize(new java.awt.Dimension(111, 16));

        menosAptos.setMaximumSize(new java.awt.Dimension(111, 16));
        menosAptos.setMinimumSize(new java.awt.Dimension(111, 16));

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        jLabel9.setText("Número de Generaciones:");

        numGen.setText("0");
        numGen.setEnabled(false);
        numGen.setMaximumSize(new java.awt.Dimension(131, 37));
        numGen.setMinimumSize(new java.awt.Dimension(131, 37));

        jLabel4.setText("Algoritmo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(probCruce, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(porcCruce, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(menosAptos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tamPob, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(8, 8, 8)
                                                .addComponent(selectedAlgo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(numGen, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iniciarPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultados, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tamPob, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(probCruce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(porcCruce, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menosAptos, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectedAlgo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(imageSelect))
                    .addComponent(numGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iniciarPrograma)
                    .addComponent(resultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imageSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageSelectActionPerformed
        imgSelec = imagen.buscador();
        rgbToGrayScale toGray = new rgbToGrayScale();
        if(imgSelec == null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
               AAProyecto1.goalImage = toGray.getGrayImg(imgSelec);
               imgSelec = new File("images\\finalImage.png");
               img = ImageIO.read(imgSelec);
            }catch (IOException e){
                System.out.println(e);
            }
            ImageIcon selectedImg = new ImageIcon(img);
            Icon selectedIcon = new ImageIcon(selectedImg.getImage().getScaledInstance(lblSeleccionada.getWidth(), 
                    lblSeleccionada.getHeight(), Image.SCALE_DEFAULT));
            lblSeleccionada.setIcon(selectedIcon);
            iniciarPrograma.setEnabled(true);
        }
    }//GEN-LAST:event_imageSelectActionPerformed

    private void iniciarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarProgramaActionPerformed
//        interfaceThread GEN = new interfaceThread();
//        GEN.start();
        imageSelect.setEnabled(false);
        iniciarPrograma.setEnabled(false);
        try{
            firstGeneration(img.getHeight(), img.getWidth(), menuInicial.TAMAÑO_POBLACION);
            menuInicial.PORCENTAJE_MUTAR = menuInicial.PORCENTAJE_MUTAR + 20 - menuInicial.PORCENTAJE_MENOS_APTOS;
            AAProyecto1.startProgram();
        }catch (IOException ex) {
            System.out.println(ex);
        }
        numGen.setText("" + (NUMERO_GENERACION - 1));
        resultados.setEnabled(true);
    }//GEN-LAST:event_iniciarProgramaActionPerformed

    private void resultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultadosActionPerformed
        resultados ventanaResultados = new resultados();
        ventanaResultados.setVisible(true);
    }//GEN-LAST:event_resultadosActionPerformed

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
    private javax.swing.JButton imageSelect;
    private javax.swing.JButton iniciarPrograma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblSeleccionada;
    private javax.swing.JLabel menosAptos;
    private javax.swing.JTextField numGen;
    private javax.swing.JPanel panel1;
    private javax.swing.JLabel porcCruce;
    private javax.swing.JLabel probCruce;
    private javax.swing.JButton resultados;
    private javax.swing.JLabel selectedAlgo;
    private javax.swing.JLabel tamPob;
    // End of variables declaration//GEN-END:variables
}
