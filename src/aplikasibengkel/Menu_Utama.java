/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibengkel;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author LENOVO
 */
public class Menu_Utama extends javax.swing.JFrame {
   
/**
     * Creates new form Menu_Utama
     */
    koneksi obj = new koneksi(); 
    public Menu_Utama() {
        initComponents();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2);
        
    }
    public Menu_Utama(String kd_kr){
        initComponents();
        inisialisasi(kd_kr);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2);
      
    }
    public void inisialisasi(String kr){
        try {
            switch(kr){
                case "1":
                    jabatan.setText("PEMILIK");
                     actionPemilik();
             break;
              case "2":
                   jabatan.setText("PEGAWAI");
                   actionPegawai();
             break;
              
                 default:
             break;
            }
        } catch (Exception e) {
        }
    }
     public void actionPegawai(){
         tBarang.setEnabled(true);
         tPegawai.setEnabled(false);
          tTrans.setEnabled(true);
             tTrans.addMouseListener(new MouseInputListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    new TransaksiBengkel().setVisible(true);
                }

                @Override
                public void mousePressed(MouseEvent me) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                  
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                   
                }

                @Override
                public void mouseExited(MouseEvent me) {
                     
                }

                @Override
                public void mouseDragged(MouseEvent me) {
                    
                }

                @Override
                public void mouseMoved(MouseEvent me) {
                  
                }
            });
                     tBarang.addMouseListener(new MouseInputListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    new Barang().setVisible(true);
                }

                @Override
                public void mousePressed(MouseEvent me) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                  
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    
                }

                @Override
                public void mouseDragged(MouseEvent me) {
                    
                }

                @Override
                public void mouseMoved(MouseEvent me) {
                  
                }
            });
           
            
    }
    public void actionPemilik(){
         tLaporan.setEnabled(true);
         tBarang.setEnabled(false);
                     tLaporan.addMouseListener(new MouseInputListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    new Laporan().setVisible(true);
                }

                @Override
                public void mousePressed(MouseEvent me) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                  
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    
                }

                @Override
                public void mouseExited(MouseEvent me) {
                     
                }

                @Override
                public void mouseDragged(MouseEvent me) {
                    
                }

                @Override
                public void mouseMoved(MouseEvent me) {
                  
                }
            });
            tPegawai.addMouseListener(new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent me) {
                 new Pegawai().setVisible(true);
             }

             @Override
             public void mousePressed(MouseEvent me) {
               
             }

             @Override
             public void mouseReleased(MouseEvent me) {
               
             }

             @Override
             public void mouseEntered(MouseEvent me) {
               
             }

             @Override
             public void mouseExited(MouseEvent me) {
                
             }
         });
            
    }
    public void setColor(JPanel p1){
        p1.setBackground(new Color(0,51,77));
    }
    public void resetColor(JPanel p){
        p.setBackground(new Color(72,209,204));
    }
    public void exitColor(JPanel p1){
        p1.setBackground(new Color(199,0,57));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jabatan = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        tTrans = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        tLaporan = new javax.swing.JLabel();
        jExit = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        tKembali = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        tBarang = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        tPegawai = new javax.swing.JLabel();

        jMenu1.setText("File");

        jMenuItem1.setText("Pelanggan");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Keluar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Transaksi");

        jMenuItem3.setText("Bengkel");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Laporan");
        jMenuBar1.add(jMenu3);

        jDialog1.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 77));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel1.setPreferredSize(new java.awt.Dimension(468, 539));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasibengkel/MAGE-removebg-preview.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ashiaaap Bengkel");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("v.01");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel7))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel2)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(72, 209, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(468, 539));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jabatan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jabatan.setForeground(new java.awt.Color(255, 255, 255));
        jabatan.setText("*PEGAWAI");
        jPanel2.add(jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("MAIN MENU");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        panel1.setBackground(new java.awt.Color(72, 209, 204));
        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tTrans.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tTrans.setForeground(new java.awt.Color(255, 255, 255));
        tTrans.setText("        Transaksi");
        tTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tTransMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tTransMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tTransMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tTrans, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tTrans, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );

        jPanel2.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 160, 70));

        panel2.setBackground(new java.awt.Color(72, 209, 204));
        panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tLaporan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tLaporan.setForeground(new java.awt.Color(255, 255, 255));
        tLaporan.setText("         Laporan");
        tLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tLaporanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tLaporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tLaporanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(tLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 160, 70));

        jExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jExit.setForeground(new java.awt.Color(255, 255, 255));
        jExit.setText("X");
        jExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jExitMouseClicked(evt);
            }
        });
        jPanel2.add(jExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 20, 30));

        panel3.setBackground(new java.awt.Color(72, 209, 204));
        panel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tKembali.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tKembali.setForeground(new java.awt.Color(255, 255, 255));
        tKembali.setText("             EXIT");
        tKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tKembaliMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tKembaliMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tKembaliMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel2.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 130, 40));

        panel4.setBackground(new java.awt.Color(72, 209, 204));
        panel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tBarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tBarang.setForeground(new java.awt.Color(255, 255, 255));
        tBarang.setText("          Barang");
        tBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tBarangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tBarangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tBarangMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addComponent(tBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, 70));

        panel5.setBackground(new java.awt.Color(72, 209, 204));
        panel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tPegawai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tPegawai.setForeground(new java.awt.Color(255, 255, 255));
        tPegawai.setText("        Pegawai");
        tPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPegawaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tPegawaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tPegawaiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addComponent(tPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
//        TransaksiBengkel objTrans = new TransaksiBengkel(this, rootPaneCheckingEnabled);
//        objTrans.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void tTransMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTransMouseEntered
        // TODO add your handling code here:
        setColor(panel1);
    }//GEN-LAST:event_tTransMouseEntered

    private void tTransMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTransMouseExited
        // TODO add your handling code here:
        resetColor(panel1);
    }//GEN-LAST:event_tTransMouseExited

    private void tLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLaporanMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tLaporanMouseClicked

    private void tLaporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLaporanMouseExited
        // TODO add your handling code here:
         resetColor(panel2);
    }//GEN-LAST:event_tLaporanMouseExited

    private void tLaporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLaporanMouseEntered
        // TODO add your handling code here:
        setColor(panel2);
    }//GEN-LAST:event_tLaporanMouseEntered

    private void tTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTransMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_tTransMouseClicked

    private void jExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExitMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jExitMouseClicked

    private void tKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKembaliMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_tKembaliMouseClicked

    private void tKembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKembaliMouseEntered
        // TODO add your handling code here:
        exitColor(panel3);
    }//GEN-LAST:event_tKembaliMouseEntered

    private void tKembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKembaliMouseExited
        // TODO add your handling code here:
        resetColor(panel3);
    }//GEN-LAST:event_tKembaliMouseExited

    private void tBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBarangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tBarangMouseClicked

    private void tBarangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBarangMouseEntered
        // TODO add your handling code here:
         setColor(panel4);
    }//GEN-LAST:event_tBarangMouseEntered

    private void tBarangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBarangMouseExited
        // TODO add your handling code here:
        resetColor(panel4);
    }//GEN-LAST:event_tBarangMouseExited

    private void tPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPegawaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tPegawaiMouseClicked

    private void tPegawaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPegawaiMouseEntered
        // TODO add your handling code here:
        setColor(panel5);
    }//GEN-LAST:event_tPegawaiMouseEntered

    private void tPegawaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPegawaiMouseExited
        // TODO add your handling code here:
        resetColor(panel5);
    }//GEN-LAST:event_tPegawaiMouseExited

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
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jExit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jabatan;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JLabel tBarang;
    private javax.swing.JLabel tKembali;
    private javax.swing.JLabel tLaporan;
    private javax.swing.JLabel tPegawai;
    private javax.swing.JLabel tTrans;
    // End of variables declaration//GEN-END:variables
}
