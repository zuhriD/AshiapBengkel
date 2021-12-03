/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibengkel;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class Pegawai extends javax.swing.JFrame {

    /**
     * Creates new form Pegawai
     */
    koneksi obj;
     
    public Pegawai() {
        initComponents();
          obj = new koneksi();
         setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2);
         tabelData();
    }
   
    
     private void tabelData(){
         DefaultTableModel tbl=new DefaultTableModel();
       tbl.addColumn("Nomor Karyawan");
       tbl.addColumn("Nama Karywan");
       tbl.addColumn("Username");
       tbl.addColumn("Password");
      Tdata.setModel(tbl);
       
       try{
       Statement statement = (Statement) obj.bukaKoneksi().createStatement();
       ResultSet res = statement.executeQuery("SELECT * from karyawan where kd_kr=2");
       while(res.next())
       {
           tbl.addRow(new Object[]{
           res.getString("no_pegawai"),
           res.getString("nm_kr"),
           res.getString("username"),
           res.getString("password")
       });
           Tdata.setModel(tbl);
       }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(rootPane, e);
       }
    }
     public void record(){
         DefaultTableModel tbl= (DefaultTableModel) Tdata.getModel();
            tNama.setText(tbl.getValueAt(Tdata.getSelectedRow(),1).toString() );
            tUser.setText(tbl.getValueAt(Tdata.getSelectedRow(),2).toString() );
            tPass.setText(tbl.getValueAt(Tdata.getSelectedRow(),3).toString() );
     }
     private void tambahData(){
         try {
          String sql ="INSERT INTO `karyawan` values('2',"
                   + "'"+tNama.getText()+"',"
                 
                  + "'"+tUser.getText()+"',"
                
                  +"'"+tPass.getText()+"', null)";
            Connection conn = obj.bukaKoneksi();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil disimpan");
            
            tNama.setText("");
            tUser.setText("");
            tPass.setText("");
             tabelData();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }        
     private void hapusData(){
          try {
            Connection con = obj.bukaKoneksi();
            Statement st = (Statement) con.createStatement();
            String sql = "delete from karyawan where nm_kr='"+tNama.getText()+"'"
                    + "and username='"+tUser.getText()+"'";
            int sukses = st.executeUpdate(sql);
               if (sukses >0 ) {
                   JOptionPane.showMessageDialog(rootPane, "Data Berhasil di Hapus");
                   tNama.setText("");
                     tUser.setText("");
                    tPass.setText("");
                   tabelData();
               } else {
                   JOptionPane.showMessageDialog(rootPane, "Data Tidak Berhasil di Hapus");
               }
            con.close();
            st.close();
        } catch (SQLException e) {
             JOptionPane.showConfirmDialog(this, e);
        }
     }
     private void ubahData(){
          try {
            Connection con = obj.bukaKoneksi();
            java.sql.Statement st = con.createStatement();
            DefaultTableModel tbl= (DefaultTableModel) Tdata.getModel();
            String sql = "update karyawan set kd_kr='2',"
                    + "nm_kr='"+tNama.getText()+"',"
                    + "username='"+tUser.getText()+"',"
                    + "password='"+tPass.getText()+"'"
                    + "where no_pegawai="+tbl.getValueAt(Tdata.getSelectedRow(),0);
            int sukses = st.executeUpdate(sql);
                if (sukses > 0 ) {
                   JOptionPane.showMessageDialog(rootPane, "Data Berhasil di Ubah!!");
                   tabelData();
            } else {
                   JOptionPane.showMessageDialog(rootPane, "Data Tidak Berhasil di Ubah!!"); 
            }
            con.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(this, e);
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tdata = new javax.swing.JTable();
        tNama = new javax.swing.JTextField();
        tUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tPass = new javax.swing.JPasswordField();
        panel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        btnHapus = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        tExit = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        tKembali = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(72, 209, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(468, 539));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(32, 136, 203));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        Tdata.setBorder(new javax.swing.border.MatteBorder(null));
        Tdata.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        Tdata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Karywan", "Nama Karywan", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        Tdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TdataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tdata);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 890, 260));

        tNama.setBackground(new java.awt.Color(72, 209, 204));
        tNama.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tNama.setForeground(new java.awt.Color(255, 255, 255));
        tNama.setText("Nama Lengkap");
        tNama.setBorder(null);
        tNama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tNamaMouseClicked(evt);
            }
        });
        tNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaActionPerformed(evt);
            }
        });
        jPanel2.add(tNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 260, 40));

        tUser.setBackground(new java.awt.Color(72, 209, 204));
        tUser.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tUser.setForeground(new java.awt.Color(255, 255, 255));
        tUser.setText("Username");
        tUser.setBorder(null);
        tUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tUserFocusLost(evt);
            }
        });
        tUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tUserMouseClicked(evt);
            }
        });
        jPanel2.add(tUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 260, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/user.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 30, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/user.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 30, 30));

        tPass.setBackground(new java.awt.Color(72, 209, 204));
        tPass.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tPass.setForeground(new java.awt.Color(255, 255, 255));
        tPass.setText("dd");
        tPass.setBorder(null);
        tPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPassMouseClicked(evt);
            }
        });
        jPanel2.add(tPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 260, 40));

        panel1.setBackground(new java.awt.Color(72, 209, 204));
        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnTambah.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("          Tambah");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel2.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 160, 40));

        panel2.setBackground(new java.awt.Color(72, 209, 204));
        panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("            Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel2.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        panel3.setBackground(new java.awt.Color(72, 209, 204));
        panel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("           Hapus");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHapusMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel2.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 260, 10));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 260, 10));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 260, 10));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/padlock.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 30, 30));

        tExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tExit.setForeground(new java.awt.Color(255, 255, 255));
        tExit.setText("X");
        tExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tExitMouseExited(evt);
            }
        });
        jPanel2.add(tExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 20, 30));

        panel4.setBackground(new java.awt.Color(72, 209, 204));
        panel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tKembali.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tKembali.setForeground(new java.awt.Color(255, 255, 255));
        tKembali.setText("          KEMBALI");
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

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel2.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 580, 130, 40));

        jPanel1.setBackground(new java.awt.Color(0, 51, 77));
        jPanel1.setPreferredSize(new java.awt.Dimension(468, 539));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasibengkel/MAGE-removebg-preview.png"))); // NOI18N
        jLabel5.setText("jLabel4");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -20, 230, 190));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ashiaaap Bengkel");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("v.01");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/employees.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 70, 110));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Daftar Pegawai");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(387, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 948, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaActionPerformed

    private void TdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TdataMouseClicked
        // TODO add your handling code here:
       record();
    }//GEN-LAST:event_TdataMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        // TODO add your handling code here:
        tambahData();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        // TODO add your handling code here:
        hapusData();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void tExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_tExitMouseClicked

    private void tNamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tNamaMouseClicked
        // TODO add your handling code here:
        tNama.setText("");
    }//GEN-LAST:event_tNamaMouseClicked

    private void tUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tUserFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tUserFocusLost

    private void tUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tUserMouseClicked
        // TODO add your handling code here:
        tUser.setText("");
    }//GEN-LAST:event_tUserMouseClicked

    private void tPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPassMouseClicked
        // TODO add your handling code here:
        tPass.setText("");
    }//GEN-LAST:event_tPassMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        ubahData();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnTambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseEntered
        // TODO add your handling code here:
        setColor(panel1);
    }//GEN-LAST:event_btnTambahMouseEntered

    private void btnTambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseExited
        // TODO add your handling code here:
        resetColor(panel1);
    }//GEN-LAST:event_btnTambahMouseExited

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        // TODO add your handling code here:
        setColor(panel2);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        // TODO add your handling code here:
        resetColor(panel2);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnHapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseEntered
        // TODO add your handling code here:
        exitColor(panel3);
    }//GEN-LAST:event_btnHapusMouseEntered

    private void btnHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseExited
        // TODO add your handling code here:
        resetColor(panel3);
    }//GEN-LAST:event_btnHapusMouseExited

    private void tExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tExitMouseEntered
        // TODO add your handling code here:
       tExit.setForeground(new Color(199,0,57));
    }//GEN-LAST:event_tExitMouseEntered

    private void tExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tExitMouseExited
        // TODO add your handling code here:
          tExit.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_tExitMouseExited

    private void tKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKembaliMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_tKembaliMouseClicked

    private void tKembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKembaliMouseEntered
        // TODO add your handling code here:
        exitColor(panel4);
    }//GEN-LAST:event_tKembaliMouseEntered

    private void tKembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKembaliMouseExited
        // TODO add your handling code here:
        resetColor(panel4);
    }//GEN-LAST:event_tKembaliMouseExited

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
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tdata;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JLabel tExit;
    private javax.swing.JLabel tKembali;
    private javax.swing.JTextField tNama;
    private javax.swing.JPasswordField tPass;
    private javax.swing.JTextField tUser;
    // End of variables declaration//GEN-END:variables
}
