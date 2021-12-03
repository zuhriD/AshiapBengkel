/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibengkel;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author LENOVO
 */
public class TransaksiBengkel extends javax.swing.JDialog {

    /**
     * Creates new form TransaksiBengkel
     */
    koneksi obj;
    String kd_sp = "";
    public TransaksiBengkel() {
     
        initComponents();
           setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2);
        obj = new koneksi();
        kd_sp="";
        autoNumber();
        tampilNamaSpareparts();
        inisialisasi();
    }
    private void tambahData(){
        int discount = 0;
        int jml_bayar = 0;
        
        if (rb5.isSelected()) {
            discount = 5;
        }else if(rb10.isSelected()){
            discount = 10;
        }else if(rb15.isSelected()){
            discount = 15;
        }
        
        jml_bayar = Integer.parseInt(tharga.getText())*Integer.parseInt(tJumlah.getText());
        jml_bayar = jml_bayar - (jml_bayar*discount/100);
       
        
        try {
            Connection con = obj.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "insert into isi values('"+tNoservis.getText()+"',"
                    + "'"+kd_sp+"',"
                    + "'"+tJumlah.getText()+"',"
                    + "'"+discount+"',"
                    + "'"+jml_bayar+"',"
                    + "'"+tNapel.getText()+"')";
            int sukses = st.executeUpdate(sql);
                if (sukses > 0 ) {
                   JOptionPane.showMessageDialog(rootPane, "Data Berhasil di Tambahkan!!");
                 
            } else {
                   JOptionPane.showMessageDialog(rootPane, "Data Tidak Berhasil di Tambahkan!!"); 
            }
                btnPrint.setEnabled(true);
                con.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e);
        }
        inisialisasi();
    }
    
    private void autoNumber(){
        String noServices = "SER000";
        int i = 0;
        try {
            Connection con  = obj.bukaKoneksi();
            Statement  st  = con.createStatement();
            String sql = "select no_services from isi";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                noServices = rs.getString("no_services");
            }
            noServices = noServices.substring(3);
            i = Integer.parseInt(noServices)+1;
            noServices = "00"+i;
            noServices = "SER"+noServices.substring(noServices.length()-3);
            tNoservis.setText(noServices);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(this, e);
        }
    }
    
    private void tampilNamaSpareparts(){
        try {
            Connection con = obj.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "select nm_sp from spareparts order by nm_sp";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                cmbSparepart.addItem(rs.getString("nm_sp"));
            }
            con.close();
            st.close(); 
        } catch (SQLException e) {
             JOptionPane.showConfirmDialog(this, e);
        }
    }
    
    private void detailSpareparts(){
        
        try {
            Connection con = obj.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "select * from spareparts where nm_sp='"+cmbSparepart.getSelectedItem()+"'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                tharga.setText(rs.getString("harga"));
                kd_sp = rs.getString("kd_sp");
            }
            con.close();
            st.close();
        } catch (SQLException e) {
             JOptionPane.showConfirmDialog(this, e);
        }
    }
    
    private void inisialisasi(){
        btnTambah.setEnabled(false);
        btnHapus.setEnabled(false);
        btnUbah.setEnabled(false);
        btnPrint.setEnabled(false);
    }
    private void cariData(){
        try {
            Connection con = obj.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "select * from isi where no_services='"+tNoservis.getText()+"' ";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                tJumlah.setText(rs.getString("jml_item"));
                if (rs.getString("discount").equals("5")) {
                    rb5.setSelected(true);
                }
                if (rs.getString("discount").equals("10")) {
                    rb10.setSelected(true);
                }
                if (rs.getString("discount").equals("15")) {
                    rb15.setSelected(true);
                }
                tNapel.setText(rs.getString("nm_pel"));
                inisialisasi();
                btnUbah.setEnabled(true);
                btnHapus.setEnabled(true);
            }else{
                inisialisasi();
                btnTambah.setEnabled(true);
                tJumlah.setText("");
                rb5.setSelected(true);
            }
            con.close();
            st.close();
            
        } catch (SQLException e) {
             JOptionPane.showConfirmDialog(this, e);
        }
    }
    
    private void ubahData(){
       int discount = 0;
        int jml_bayar = 0;
        
        if (rb5.isSelected()) {
            discount = 5;
        }else if(rb10.isSelected()){
            discount = 10;
        }else if(rb15.isSelected()){
            discount = 15;
        }
        
        jml_bayar = Integer.parseInt(tharga.getText())*Integer.parseInt(tJumlah.getText());
        jml_bayar = jml_bayar - (jml_bayar*discount/100);
        
        try {
            Connection con = obj.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "update isi set no_services='"+tNoservis.getText()+"',"
                    + "kd_sp='"+kd_sp+"',"
                    + "jml_item='"+tJumlah.getText()+"',"
                    + "discount='"+discount+"',"
                    + "jml_bayar='"+jml_bayar+"',"
                    +"nm_pel='"+tNapel.getText()+"'"
                    + "where no_services='"+tNoservis.getText()+"'";
            int sukses = st.executeUpdate(sql);
                if (sukses > 0 ) {
                   JOptionPane.showMessageDialog(rootPane, "Data Berhasil di Ubah!!");
            } else {
                   JOptionPane.showMessageDialog(rootPane, "Data Tidak Berhasil di Ubah!!"); 
            }
            con.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(this, e);
        }
    }
    private void bersih(){
        tJumlah.setText("");
        tNapel.setText("");
        rb5.setSelected(true);
    }
    private void unSelect(){
        btnTambah.setEnabled(true);
        btnHapus.setEnabled(true);
        btnUbah.setEnabled(true);
        btnPrint.setEnabled(true);
    }
    private void hapus(){
           try {
            Connection con = obj.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "delete from isi where no_services='"+tNoservis.getText()+"'"
                    + "and kd_sp='"+kd_sp+"'";
            int sukses = st.executeUpdate(sql);
               if (sukses >0 ) {
                   JOptionPane.showMessageDialog(rootPane, "Data Berhasil di Hapus");
               } else {
                   JOptionPane.showMessageDialog(rootPane, "Data Tidak Berhasil di Hapus");
               }
            con.close();
            st.close();
        } catch (SQLException e) {
             JOptionPane.showConfirmDialog(this, e);
        }
    }
      private void cetakKuitansi(){
          Map<String,Object> noServ = new HashMap<String, Object>();
           try {
            HashMap parameter = new HashMap();
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/bengkel";
            String user = "root";
            String pass = "";
            Connection conn = (Connection) DriverManager.getConnection(url,user,pass);
            noServ.put("no_service", tNoservis.getText());
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("kuitansi.jasper"), noServ, conn);
        JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rb10 = new javax.swing.JRadioButton();
        tNoservis = new javax.swing.JTextField();
        rb15 = new javax.swing.JRadioButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbSparepart = new javax.swing.JComboBox<>();
        tNapel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tharga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tJumlah = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rb5 = new javax.swing.JRadioButton();
        btnCari = new javax.swing.JButton();
        btnBaru = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        panel3 = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 51, 77));
        jPanel1.setMinimumSize(new java.awt.Dimension(539, 468));
        jPanel1.setPreferredSize(new java.awt.Dimension(468, 539));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasibengkel/MAGE-removebg-preview.png"))); // NOI18N
        jLabel7.setText("jLabel4");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ashiaaap Bengkel");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("v.01");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(72, 209, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(468, 539));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("No. Services");

        buttonGroup1.add(rb10);
        rb10.setText("10%");

        tNoservis.setBackground(new java.awt.Color(72, 209, 204));
        tNoservis.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tNoservis.setForeground(new java.awt.Color(255, 255, 255));
        tNoservis.setBorder(null);
        tNoservis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNoservisActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb15);
        rb15.setText("15%");
        rb15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb15ActionPerformed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(72, 209, 204));
        btnTambah.setText("Tambah");
        btnTambah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 209, 204)));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(72, 209, 204));
        btnUbah.setText("Ubah");
        btnUbah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 209, 204)));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(72, 209, 204));
        btnHapus.setText("Hapus");
        btnHapus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 209, 204)));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(72, 209, 204));
        btnPrint.setText("Print");
        btnPrint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 209, 204)));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Spare Parts");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nama Pelanggan");

        cmbSparepart.setBackground(new java.awt.Color(51, 51, 255));
        cmbSparepart.setEditable(true);
        cmbSparepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSparepartActionPerformed(evt);
            }
        });

        tNapel.setBackground(new java.awt.Color(72, 209, 204));
        tNapel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tNapel.setForeground(new java.awt.Color(255, 255, 255));
        tNapel.setBorder(null);
        tNapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNapelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Harga");

        tharga.setBackground(new java.awt.Color(72, 209, 204));
        tharga.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tharga.setForeground(new java.awt.Color(255, 255, 255));
        tharga.setBorder(null);
        tharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thargaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah");

        tJumlah.setBackground(new java.awt.Color(72, 209, 204));
        tJumlah.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tJumlah.setForeground(new java.awt.Color(255, 255, 255));
        tJumlah.setBorder(null);
        tJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tJumlahActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Discount");

        buttonGroup1.add(rb5);
        rb5.setText("5%");
        rb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb5ActionPerformed(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(72, 209, 204));
        btnCari.setText("Cari");
        btnCari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 209, 204)));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnBaru.setBackground(new java.awt.Color(72, 209, 204));
        btnBaru.setText("Buat Baru");
        btnBaru.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 209, 204)));
        btnBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaruActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Transaksi Bengkel");

        exit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        panel3.setBackground(new java.awt.Color(72, 209, 204));
        panel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("             EXIT");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbSparepart, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tNoservis)
                                                    .addComponent(tNapel, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel6))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(rb5)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(rb10)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(rb15))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBaru, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tNoservis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tNapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSparepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb5)
                    .addComponent(rb10)
                    .addComponent(rb15)
                    .addComponent(jLabel6))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rb15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb15ActionPerformed

    private void rb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb5ActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        tambahData();
        unSelect();
        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruActionPerformed
        // TODO add your handling code here:
        autoNumber();
        bersih();
        inisialisasi();
        btnTambah.setEnabled(true);
        
    }//GEN-LAST:event_btnBaruActionPerformed

    private void thargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thargaActionPerformed

    private void cmbSparepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSparepartActionPerformed
        // TODO add your handling code here:
        detailSpareparts();
    }//GEN-LAST:event_cmbSparepartActionPerformed

    private void tNoservisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNoservisActionPerformed
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_tNoservisActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        ubahData();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        hapus();
        inisialisasi();
        bersih();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cariData();
        btnPrint.setEnabled(true);
        
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        cetakKuitansi();
        
    }//GEN-LAST:event_btnPrintActionPerformed

    private void tNapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNapelActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void tJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tJumlahActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        // TODO add your handling code here:
        exitColor(panel3);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        // TODO add your handling code here:
        resetColor(panel3);
    }//GEN-LAST:event_btnExitMouseExited

    
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
            java.util.logging.Logger.getLogger(TransaksiBengkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiBengkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiBengkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiBengkel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                 new TransaksiBengkel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnCari;
    private javax.swing.JLabel btnExit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbSparepart;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel panel3;
    private javax.swing.JRadioButton rb10;
    private javax.swing.JRadioButton rb15;
    private javax.swing.JRadioButton rb5;
    private javax.swing.JTextField tJumlah;
    private javax.swing.JTextField tNapel;
    private javax.swing.JTextField tNoservis;
    private javax.swing.JTextField tharga;
    // End of variables declaration//GEN-END:variables
}
