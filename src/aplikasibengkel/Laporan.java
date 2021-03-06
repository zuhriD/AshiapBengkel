/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibengkel;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
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
public class Laporan extends javax.swing.JFrame {

    /**
     * Creates new form Laporan
     */
    koneksi obj;
    public Laporan() {
        initComponents();
        obj = new koneksi();
         setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2);
          Tdata.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
          Tdata.getTableHeader().setOpaque(false);
          Tdata.getTableHeader().setBackground(new Color(32,136,203));
          Tdata.setRowHeight(25);
        tabelData();
    }
    
    private void tabelData(){
        DefaultTableModel tbl = new DefaultTableModel();
       tbl.addColumn("No Services");
       tbl.addColumn("Nama Spareparts");
       tbl.addColumn("Jumlah Item");
       tbl.addColumn("Harga");
       tbl.addColumn("Discount");
       tbl.addColumn("Total Bayar");
       Tdata.setModel(tbl);
       
       try{
       Statement statement = (Statement) obj.bukaKoneksi().createStatement();
       ResultSet res = statement.executeQuery("SELECT nm_sp, harga,no_services, jml_item, discount,jml_bayar"
               + " FROM spareparts INNER JOIN isi ON spareparts.kd_sp=isi.kd_sp");
       while(res.next())
       {
           tbl.addRow(new Object[]{
           res.getString("no_services"),
           res.getString("nm_sp"),
           res.getString("jml_item"),
           res.getString("harga"),
           res.getString("discount"),
           res.getString("jml_bayar"),
       });
         Tdata.setModel(tbl);
       }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(rootPane, e);
       }
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
    private void cetak(){
                try {
            HashMap parameter = new HashMap();
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/bengkel";
            String user = "root";
            String pass = "";
            Connection conn = (Connection) DriverManager.getConnection(url,user,pass);
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("report1.jasper"), null, conn);
        JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tExit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tdata = new javax.swing.JTable();
        panel2 = new javax.swing.JPanel();
        btnKembali = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        btnCetak = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 77));
        jPanel1.setPreferredSize(new java.awt.Dimension(468, 563));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasibengkel/MAGE-removebg-preview.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ashiaaap Bengkel");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("v.01");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel7))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel8)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(28, 28, 28))
        );

        jPanel2.setBackground(new java.awt.Color(72, 209, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(468, 563));

        tExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tExit.setForeground(new java.awt.Color(255, 255, 255));
        tExit.setText("X");
        tExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tExitMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LAPORAN");

        jScrollPane1.setBackground(new java.awt.Color(32, 136, 203));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        Tdata.setBorder(new javax.swing.border.MatteBorder(null));
        Tdata.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        Tdata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No Services", "Nama Spareparts", "Jumlah Item", "Harga", "Discount", "Total Bayar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tdata.setFocusable(false);
        Tdata.setIntercellSpacing(new java.awt.Dimension(0, 0));
        Tdata.setRequestFocusEnabled(false);
        Tdata.setRowHeight(25);
        Tdata.setSelectionBackground(new java.awt.Color(232, 57, 95));
        Tdata.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tdata);
        if (Tdata.getColumnModel().getColumnCount() > 0) {
            Tdata.getColumnModel().getColumn(0).setResizable(false);
            Tdata.getColumnModel().getColumn(1).setResizable(false);
            Tdata.getColumnModel().getColumn(2).setResizable(false);
            Tdata.getColumnModel().getColumn(3).setResizable(false);
            Tdata.getColumnModel().getColumn(4).setResizable(false);
            Tdata.getColumnModel().getColumn(5).setResizable(false);
        }

        jScrollPane2.setViewportView(jScrollPane1);

        panel2.setBackground(new java.awt.Color(17, 209, 204));
        panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnKembali.setBackground(new java.awt.Color(186, 79, 84));
        btnKembali.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.setText("            KEMBALI");
        btnKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKembaliMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKembaliMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKembaliMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        panel1.setBackground(new java.awt.Color(17, 209, 204));
        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });

        btnCetak.setBackground(new java.awt.Color(186, 79, 84));
        btnCetak.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCetak.setForeground(new java.awt.Color(255, 255, 255));
        btnCetak.setText("                CETAK");
        btnCetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCetakMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCetakMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCetakMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tExit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(445, 445, 445)
                        .addComponent(jLabel1)))
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1075, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void tExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tExitMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_tExitMouseClicked

    private void btnKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKembaliMouseClicked

    private void btnKembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseEntered
        // TODO add your handling code here:
        exitColor(panel2);
    }//GEN-LAST:event_btnKembaliMouseEntered

    private void btnKembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseExited
        // TODO add your handling code here:
        resetColor(panel2);
    }//GEN-LAST:event_btnKembaliMouseExited

    private void btnCetakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseEntered
        // TODO add your handling code here:
        setColor(panel1);
    }//GEN-LAST:event_btnCetakMouseEntered

    private void btnCetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseExited
        // TODO add your handling code here:
        resetColor(panel1);
    }//GEN-LAST:event_btnCetakMouseExited

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_panel1MouseClicked

    private void btnCetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCetakMouseClicked
        // TODO add your handling code here:
        cetak();
    }//GEN-LAST:event_btnCetakMouseClicked

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
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tdata;
    private javax.swing.JLabel btnCetak;
    private javax.swing.JLabel btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JLabel tExit;
    // End of variables declaration//GEN-END:variables
}
