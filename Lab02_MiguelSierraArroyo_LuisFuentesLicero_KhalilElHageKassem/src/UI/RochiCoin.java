/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Graph.Graph;
import Graph.Vertex;
import System.StringUtil;
import System.Transaction;
import System.User;
import System.Wallet;
import android.util.Base64;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import rojerusan.RSPanelsSlider;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static org.bouncycastle.asn1.x509.ObjectDigestInfo.publicKey;

/**
 *
 * @author khali
 */
public class RochiCoin extends javax.swing.JFrame {

    /**
     * Creates new form RochiCoin
     */
    CardLayout mainLayout;
    CardLayout accountLayout;
    Graph g;
    User u;
    ArrayList<Wallet> userWallets;
    boolean toogleAdmin = false, toogleAccount = false;

    public RochiCoin() {
        initComponents();
        mainLayout = (CardLayout) parent.getLayout();
        //accountLayout = (CardLayout) parent2.getLayout();
        g = new Graph();

        userTable.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 12));
        userTable.getTableHeader().setOpaque(false);
        userTable.getTableHeader().setBackground(new Color(32, 136, 203));
        userTable.getTableHeader().setForeground(new Color(0, 0, 0));
        userTable.setRowHeight(25);
        walletsTable.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 12));
        walletsTable.getTableHeader().setOpaque(false);
        walletsTable.getTableHeader().setBackground(new Color(32, 136, 203));
        walletsTable.getTableHeader().setForeground(new Color(0, 0, 0));
        walletsTable.setRowHeight(25);
        transFile.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 12));
        transFile.getTableHeader().setOpaque(false);
        transFile.getTableHeader().setBackground(new Color(32, 136, 203));
        transFile.getTableHeader().setForeground(new Color(0, 0, 0));
        transFile.setRowHeight(25);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        goToRegisterPanelBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        passwordTField = new javax.swing.JTextField();
        emailTField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        registerPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        registerEmailTField = new javax.swing.JTextField();
        registerPasswordTField = new javax.swing.JTextField();
        nameTField = new javax.swing.JTextField();
        surnameTField = new javax.swing.JTextField();
        identNumberTField = new javax.swing.JTextField();
        registerBtn = new javax.swing.JButton();
        goToLoginPanelBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        adminAccount = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        tableBtn = new javax.swing.JButton();
        graphBtn = new javax.swing.JButton();
        transactionsBtn5 = new javax.swing.JButton();
        homeBtnAdmin = new javax.swing.JButton();
        historyBtnAdmin = new javax.swing.JButton();
        transactionsBtnAdmin = new javax.swing.JButton();
        btnMenu8 = new javax.swing.JButton();
        rSPanelsSlider5 = new rojerusan.RSPanelsSlider();
        home1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        fghfh1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jlabelalgo4 = new javax.swing.JLabel();
        jid1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        tables = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        walletsTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        transFile = new javax.swing.JTable();
        graph = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        transactions1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jlabelalgo5 = new javax.swing.JLabel();
        jlabelalgo6 = new javax.swing.JLabel();
        jlabelalgo7 = new javax.swing.JLabel();
        jwallet1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        transactionsBtn4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        history1 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        searchHistory1 = new javax.swing.JButton();
        jlabelalgo9 = new javax.swing.JLabel();
        jwalletCombo3 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        histoyTable1 = new javax.swing.JTable();
        accountPane = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        homeBtn1 = new javax.swing.JButton();
        historyBtn1 = new javax.swing.JButton();
        transactionsBtn1 = new javax.swing.JButton();
        transactionsBtn2 = new javax.swing.JButton();
        btnMenu7 = new javax.swing.JButton();
        rSPanelsSlider4 = new rojerusan.RSPanelsSlider();
        home = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fullName = new javax.swing.JLabel();
        gdgf = new javax.swing.JLabel();
        fghfh = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlabelalgo = new javax.swing.JLabel();
        jid = new javax.swing.JLabel();
        jemail = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        history = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jlabelalgo8 = new javax.swing.JLabel();
        jwalletCombo2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        histoyTable = new javax.swing.JTable();
        searchHistory = new javax.swing.JButton();
        transactions = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlabelalgo1 = new javax.swing.JLabel();
        jlabelalgo2 = new javax.swing.JLabel();
        jlabelalgo3 = new javax.swing.JLabel();
        jwallet = new javax.swing.JComboBox<>();
        jmonto = new javax.swing.JTextField();
        createTransactionBtn = new javax.swing.JButton();
        jdestino = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parent.setLayout(new java.awt.CardLayout());

        loginPanel.setBackground(new java.awt.Color(17, 45, 78));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Iniciar sesión");

        jLabel2.setText("Correo electrónico");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("RochiCoin");

        goToRegisterPanelBtn.setText("Registrar una nueva cuenta");
        goToRegisterPanelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToRegisterPanelBtnActionPerformed(evt);
            }
        });

        loginBtn.setText("Iniciar sesión");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        TextPrompt passwordPrompt = new TextPrompt("Contraseña", passwordTField);
        passwordPrompt.changeAlpha(0.5f);

        TextPrompt emailPrompt = new TextPrompt("Correo electrónico", emailTField);
        emailPrompt.changeAlpha(0.5f);

        jLabel3.setText("Contraseña");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(391, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(goToRegisterPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailTField, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordTField, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addGap(62, 62, 62)))
                .addGap(382, 382, 382))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordTField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goToRegisterPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(390, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        parent.add(loginPanel, "card2");

        registerPanel.setBackground(new java.awt.Color(17, 45, 78));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RochiCoin");

        jLabel5.setText("Correo electrónico");

        jLabel6.setText("Contraseña");

        jLabel7.setText("Nombre");

        jLabel8.setText("Apellido");

        jLabel9.setText("Cédula");

        TextPrompt registerEmailPrompt = new TextPrompt("Correo electrónico", registerEmailTField);
        registerEmailPrompt.changeAlpha(0.5f);

        TextPrompt registerPasswordPrompt = new TextPrompt("Contraseña", registerPasswordTField);
        registerPasswordPrompt.changeAlpha(0.5f);

        TextPrompt namePrompt = new TextPrompt("Nombre", nameTField);
        namePrompt.changeAlpha(0.5f);

        TextPrompt surnamePrompt = new TextPrompt("Apellido", surnameTField);
        surnamePrompt.changeAlpha(0.5f);

        TextPrompt identNumberPrompt = new TextPrompt("Cédula", identNumberTField);
        identNumberPrompt.changeAlpha(0.5f);

        registerBtn.setText("Registrarse");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        goToLoginPanelBtn.setText("Regresar al inicio");
        goToLoginPanelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToLoginPanelBtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Registrarse");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(identNumberTField)
                            .addComponent(surnameTField)
                            .addComponent(nameTField)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(goToLoginPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerEmailTField)
                            .addComponent(registerPasswordTField)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(411, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameTField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(identNumberTField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerEmailTField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerPasswordTField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goToLoginPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parent.add(registerPanel, "card3");

        adminAccount.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(17, 45, 78));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ROCHICOIN");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));

        tableBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tablas button.png"))); // NOI18N
        tableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableBtnActionPerformed(evt);
            }
        });
        jPanel5.add(tableBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 260, 50));

        graphBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafo button.png"))); // NOI18N
        graphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphBtnActionPerformed(evt);
            }
        });
        jPanel5.add(graphBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 260, 50));

        transactionsBtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salir.png"))); // NOI18N
        transactionsBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsBtn5ActionPerformed(evt);
            }
        });
        jPanel5.add(transactionsBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 900, 260, 50));

        homeBtnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        homeBtnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnAdminActionPerformed(evt);
            }
        });
        jPanel5.add(homeBtnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 260, 50));

        historyBtnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/historial.png"))); // NOI18N
        historyBtnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtnAdminActionPerformed(evt);
            }
        });
        jPanel5.add(historyBtnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 260, 50));

        transactionsBtnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transacciones.png"))); // NOI18N
        transactionsBtnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsBtnAdminActionPerformed(evt);
            }
        });
        jPanel5.add(transactionsBtnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 260, 50));

        btnMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono-menu.png"))); // NOI18N
        btnMenu8.setBorder(null);
        btnMenu8.setContentAreaFilled(false);
        btnMenu8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu8ActionPerformed(evt);
            }
        });
        jPanel5.add(btnMenu8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        rSPanelsSlider5.setBackground(new java.awt.Color(255, 255, 255));

        home1.setBackground(new java.awt.Color(255, 255, 255));
        home1.setName("pnl1"); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(17, 45, 78));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Home");

        jPanel9.setBackground(new java.awt.Color(249, 247, 247));

        fghfh1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fghfh1.setForeground(new java.awt.Color(17, 45, 78));
        fghfh1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fghfh1.setText("ID:");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userPic.png"))); // NOI18N

        jlabelalgo4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlabelalgo4.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo4.setText("ADMINISTRADOR");

        jid1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jid1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelalgo4, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(fghfh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jid1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabelalgo4)
                .addGap(44, 44, 44)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fghfh1)
                    .addComponent(jid1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout home1Layout = new javax.swing.GroupLayout(home1);
        home1.setLayout(home1Layout);
        home1Layout.setHorizontalGroup(
            home1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home1Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home1Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(home1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        home1Layout.setVerticalGroup(
            home1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        rSPanelsSlider5.add(home1, "card2");

        tables.setBackground(new java.awt.Color(255, 255, 255));
        tables.setName("pnl1"); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(17, 45, 78));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Tablas");

        jPanel7.setBackground(new java.awt.Color(249, 247, 247));

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Numero ID", "Email", "Contraseña"
            }
        ));
        userTable.setFocusable(false);
        userTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        userTable.setRowHeight(25);
        userTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        userTable.setShowVerticalLines(false);
        userTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(userTable);

        jTabbedPane1.addTab("Usuarios", jScrollPane2);

        walletsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Dueño", "Public Key", "Private Key", "Monto"
            }
        ));
        walletsTable.setFocusable(false);
        walletsTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        walletsTable.setRowHeight(25);
        walletsTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        walletsTable.setShowVerticalLines(false);
        walletsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(walletsTable);

        jTabbedPane1.addTab("Billeteras", jScrollPane3);

        transFile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaccion", "ID Billetera Envio", "ID Billetera Recivio", "Monto"
            }
        ));
        transFile.setFocusable(false);
        transFile.setIntercellSpacing(new java.awt.Dimension(0, 0));
        transFile.setRowHeight(25);
        transFile.setSelectionBackground(new java.awt.Color(232, 57, 95));
        transFile.setShowVerticalLines(false);
        transFile.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(transFile);

        jTabbedPane1.addTab("Transacciones", jScrollPane4);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tablesLayout = new javax.swing.GroupLayout(tables);
        tables.setLayout(tablesLayout);
        tablesLayout.setHorizontalGroup(
            tablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablesLayout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        tablesLayout.setVerticalGroup(
            tablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );

        rSPanelsSlider5.add(tables, "card2");

        graph.setBackground(new java.awt.Color(255, 255, 255));
        graph.setName("pnl2"); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(17, 45, 78));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Grafo");

        javax.swing.GroupLayout graphLayout = new javax.swing.GroupLayout(graph);
        graph.setLayout(graphLayout);
        graphLayout.setHorizontalGroup(
            graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphLayout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
        );
        graphLayout.setVerticalGroup(
            graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(911, Short.MAX_VALUE))
        );

        rSPanelsSlider5.add(graph, "card3");

        transactions1.setBackground(new java.awt.Color(255, 255, 255));
        transactions1.setName("pnl3"); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(17, 45, 78));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Transacciones");

        jPanel11.setBackground(new java.awt.Color(249, 247, 247));

        jlabelalgo5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlabelalgo5.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo5.setText("Wallet");

        jlabelalgo6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlabelalgo6.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo6.setText("Destino");

        jlabelalgo7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlabelalgo7.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo7.setText("Monto");

        jwallet1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        transactionsBtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/realizar button.png"))); // NOI18N
        transactionsBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsBtn4ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabelalgo5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelalgo7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jlabelalgo6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jwallet1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transactionsBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(307, 307, 307))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelalgo6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelalgo5)
                    .addComponent(jwallet1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelalgo7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(transactionsBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout transactions1Layout = new javax.swing.GroupLayout(transactions1);
        transactions1.setLayout(transactions1Layout);
        transactions1Layout.setHorizontalGroup(
            transactions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactions1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(336, 336, 336))
            .addGroup(transactions1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        transactions1Layout.setVerticalGroup(
            transactions1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactions1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        rSPanelsSlider5.add(transactions1, "card4");

        history1.setBackground(new java.awt.Color(255, 255, 255));
        history1.setName("pnl2"); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(17, 45, 78));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Historial");

        searchHistory1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search button.png"))); // NOI18N
        searchHistory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchHistory1ActionPerformed(evt);
            }
        });

        jlabelalgo9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlabelalgo9.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo9.setText("Wallet");

        jwalletCombo3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        histoyTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        histoyTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", ""
            }
        ));
        histoyTable1.setFocusable(false);
        histoyTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        histoyTable1.setRowHeight(45);
        histoyTable1.setSelectionBackground(new java.awt.Color(232, 57, 95));
        histoyTable1.setShowVerticalLines(false);
        histoyTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(histoyTable1);

        javax.swing.GroupLayout history1Layout = new javax.swing.GroupLayout(history1);
        history1.setLayout(history1Layout);
        history1Layout.setHorizontalGroup(
            history1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(history1Layout.createSequentialGroup()
                .addGroup(history1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(history1Layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(history1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(history1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(history1Layout.createSequentialGroup()
                                .addComponent(jlabelalgo9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jwalletCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchHistory1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        history1Layout.setVerticalGroup(
            history1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(history1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(history1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelalgo9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, history1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jwalletCombo3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(searchHistory1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        rSPanelsSlider5.add(history1, "card3");

        javax.swing.GroupLayout adminAccountLayout = new javax.swing.GroupLayout(adminAccount);
        adminAccount.setLayout(adminAccountLayout);
        adminAccountLayout.setHorizontalGroup(
            adminAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAccountLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSPanelsSlider5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminAccountLayout.setVerticalGroup(
            adminAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rSPanelsSlider5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        parent.add(adminAccount, "card6");

        accountPane.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(17, 45, 78));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ROCHICOIN");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        homeBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        homeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtn1ActionPerformed(evt);
            }
        });
        jPanel4.add(homeBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 266, 50));

        historyBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/historial.png"))); // NOI18N
        historyBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtn1ActionPerformed(evt);
            }
        });
        jPanel4.add(historyBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 266, 50));

        transactionsBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transacciones.png"))); // NOI18N
        transactionsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsBtn1ActionPerformed(evt);
            }
        });
        jPanel4.add(transactionsBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 266, 50));

        transactionsBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salir.png"))); // NOI18N
        transactionsBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsBtn2ActionPerformed(evt);
            }
        });
        jPanel4.add(transactionsBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 266, 50));

        btnMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono-menu.png"))); // NOI18N
        btnMenu7.setBorder(null);
        btnMenu7.setContentAreaFilled(false);
        btnMenu7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMenu7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu7ActionPerformed(evt);
            }
        });
        jPanel4.add(btnMenu7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        rSPanelsSlider4.setBackground(new java.awt.Color(255, 255, 255));

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setName("pnl1"); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(17, 45, 78));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Home");

        jPanel1.setBackground(new java.awt.Color(249, 247, 247));

        fullName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fullName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        gdgf.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        gdgf.setForeground(new java.awt.Color(17, 45, 78));
        gdgf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gdgf.setText("Correo:");

        fghfh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fghfh.setForeground(new java.awt.Color(17, 45, 78));
        fghfh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fghfh.setText("ID:");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userPic.png"))); // NOI18N

        jlabelalgo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlabelalgo.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo.setText("Nombre:");

        jid.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jemail.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jemail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fghfh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlabelalgo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(gdgf, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelalgo))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gdgf)
                            .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fghfh))
                .addGap(11, 11, 11))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add wallet.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        rSPanelsSlider4.add(home, "card2");

        history.setBackground(new java.awt.Color(255, 255, 255));
        history.setName("pnl2"); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(17, 45, 78));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Historial");

        jlabelalgo8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlabelalgo8.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo8.setText("Wallet");

        jwalletCombo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        histoyTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        histoyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", ""
            }
        ));
        histoyTable.setFocusable(false);
        histoyTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        histoyTable.setRowHeight(45);
        histoyTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        histoyTable.setShowVerticalLines(false);
        histoyTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(histoyTable);

        searchHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search button.png"))); // NOI18N
        searchHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout historyLayout = new javax.swing.GroupLayout(history);
        history.setLayout(historyLayout);
        historyLayout.setHorizontalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(historyLayout.createSequentialGroup()
                        .addComponent(jlabelalgo8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jwalletCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(historyLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(383, 383, 383)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        historyLayout.setVerticalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelalgo8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jwalletCombo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addComponent(searchHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
        );

        rSPanelsSlider4.add(history, "card3");

        transactions.setBackground(new java.awt.Color(255, 255, 255));
        transactions.setName("pnl3"); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(17, 45, 78));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Transacciones");

        jPanel3.setBackground(new java.awt.Color(249, 247, 247));

        jlabelalgo1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlabelalgo1.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo1.setText("Wallet");

        jlabelalgo2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlabelalgo2.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo2.setText("Destino");

        jlabelalgo3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlabelalgo3.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo3.setText("Monto");

        jwallet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jmonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        createTransactionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/realizar button.png"))); // NOI18N
        createTransactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTransactionBtnActionPerformed(evt);
            }
        });

        jdestino.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabelalgo1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelalgo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jlabelalgo2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jwallet, 0, 504, Short.MAX_VALUE)
                    .addComponent(jdestino)
                    .addComponent(jmonto))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createTransactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(307, 307, 307))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelalgo2)
                    .addComponent(jdestino, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelalgo1)
                    .addComponent(jwallet, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelalgo3)
                    .addComponent(jmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(createTransactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout transactionsLayout = new javax.swing.GroupLayout(transactions);
        transactions.setLayout(transactionsLayout);
        transactionsLayout.setHorizontalGroup(
            transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(336, 336, 336))
            .addGroup(transactionsLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        transactionsLayout.setVerticalGroup(
            transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionsLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        rSPanelsSlider4.add(transactions, "card4");

        javax.swing.GroupLayout accountPaneLayout = new javax.swing.GroupLayout(accountPane);
        accountPane.setLayout(accountPaneLayout);
        accountPaneLayout.setHorizontalGroup(
            accountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountPaneLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSPanelsSlider4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        accountPaneLayout.setVerticalGroup(
            accountPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rSPanelsSlider4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        parent.add(accountPane, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1388, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed

        String email = emailTField.getText();
        String password = passwordTField.getText();

        try {
            u = (User) g.searchLoginUser(email, password).getO();

            if (email.equals("admin") && password.equals("admin")) {
                mainLayout.show(parent, "card6");
                fillUserInfo(u.getName(), u.getSurname(), email, u.getID(), true);
                updateWallets(jwallet1, jPanel10);
            } else {
                fillUserInfo(u.getName(), u.getSurname(), email, u.getID(), false);
                updateWallets(jwallet, jPanel2);
                mainLayout.show(parent, "card5");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese datos válidos" + e);
        }


    }//GEN-LAST:event_loginBtnActionPerformed

    private void goToRegisterPanelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToRegisterPanelBtnActionPerformed
        mainLayout.show(parent, "card3");
        emailTField.setText("");
        passwordTField.setText("");
    }//GEN-LAST:event_goToRegisterPanelBtnActionPerformed

    private void goToLoginPanelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToLoginPanelBtnActionPerformed
        mainLayout.show(parent, "card2");
        nameTField.setText("");
        surnameTField.setText("");
        identNumberTField.setText("");
        registerEmailTField.setText("");
        registerPasswordTField.setText("");
    }//GEN-LAST:event_goToLoginPanelBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed

        try {
            String name = nameTField.getText();
            String lastName = surnameTField.getText();
            int ced = Integer.parseInt(identNumberTField.getText());
            String email = registerEmailTField.getText();
            String password = registerPasswordTField.getText();

            if (!name.equals("") && !lastName.equals("") && !email.equals("") && !password.equals("")) {
                u = new User(name, lastName, ced, email, password);
                g.insertUser(u);
                updateWallets(jwallet, jPanel2);
                mainLayout.show(parent, "card5");
                fillUserInfo(name, lastName, email, u.getID(), false);
            } else {
                JOptionPane.showMessageDialog(null, "Digite datos validos en su respectivos espacios");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese datos válidos");
        }

    }//GEN-LAST:event_registerBtnActionPerformed

    private void homeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtn1ActionPerformed
        if (!this.homeBtn1.isSelected()) {
            this.homeBtn1.setSelected(true);
            this.historyBtn1.setSelected(false);
            this.transactionsBtn1.setSelected(false);

            rSPanelsSlider4.slidPanel(20, home, RSPanelsSlider.direct.up);
        }
    }//GEN-LAST:event_homeBtn1ActionPerformed

    private void historyBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtn1ActionPerformed
        if (!this.historyBtn1.isSelected()) {
            this.homeBtn1.setSelected(false);
            this.historyBtn1.setSelected(true);
            this.transactionsBtn1.setSelected(false);

            updateWallets(jwalletCombo2, jPanel2);
            rSPanelsSlider4.slidPanel(20, history, RSPanelsSlider.direct.up);
        }
    }//GEN-LAST:event_historyBtn1ActionPerformed

    private void transactionsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsBtn1ActionPerformed
        if (!this.transactionsBtn1.isSelected()) {
            this.homeBtn1.setSelected(false);
            this.historyBtn1.setSelected(false);
            this.transactionsBtn1.setSelected(true);

            rSPanelsSlider4.slidPanel(20, transactions, RSPanelsSlider.direct.up);
        }
    }//GEN-LAST:event_transactionsBtn1ActionPerformed

    private void transactionsBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsBtn2ActionPerformed
        mainLayout.show(parent, "card2");
    }//GEN-LAST:event_transactionsBtn2ActionPerformed

    private void createTransactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTransactionBtnActionPerformed

        try {
            float monto = Float.parseFloat(jmonto.getText());
            PublicKey p = stringToPublicKey((String) jwallet.getSelectedItem());
            PublicKey destino = stringToPublicKey(jdestino.getText());

            g.insertTransaction(g.searchWallet(p), g.searchWallet(destino), monto);
            updateWallets(jwallet, jPanel2);

            jmonto.setText("");
            jdestino.setText("");

        } catch (NoSuchProviderException ex) {
            Logger.getLogger(RochiCoin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_createTransactionBtnActionPerformed

    private void tableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableBtnActionPerformed
        if (!this.tableBtn.isSelected()) {
            this.tableBtn.setSelected(true);
            this.graphBtn.setSelected(false);
            this.homeBtnAdmin.setSelected(false);
            this.historyBtnAdmin.setSelected(false);
            this.transactionsBtnAdmin.setSelected(false);
            fillTables();
            rSPanelsSlider5.slidPanel(20, tables, RSPanelsSlider.direct.up);
        }
    }//GEN-LAST:event_tableBtnActionPerformed

    private void graphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphBtnActionPerformed
        if (!this.graphBtn.isSelected()) {
            this.graphBtn.setSelected(true);
            this.tableBtn.setSelected(false);
            this.homeBtnAdmin.setSelected(false);
            this.historyBtnAdmin.setSelected(false);
            this.transactionsBtnAdmin.setSelected(false);

            rSPanelsSlider5.slidPanel(20, graph, RSPanelsSlider.direct.up);
        }
    }//GEN-LAST:event_graphBtnActionPerformed

    private void transactionsBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsBtn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionsBtn5ActionPerformed

    private void homeBtnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnAdminActionPerformed
        if (!this.homeBtnAdmin.isSelected()) {
            this.tableBtn.setSelected(false);
            this.graphBtn.setSelected(false);
            this.homeBtnAdmin.setSelected(true);
            this.historyBtnAdmin.setSelected(false);
            this.transactionsBtnAdmin.setSelected(false);

            rSPanelsSlider5.slidPanel(20, home1, RSPanelsSlider.direct.up);
        }
    }//GEN-LAST:event_homeBtnAdminActionPerformed

    private void historyBtnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnAdminActionPerformed
        if (!this.historyBtnAdmin.isSelected()) {
            this.tableBtn.setSelected(false);
            this.graphBtn.setSelected(false);
            this.homeBtnAdmin.setSelected(false);
            this.historyBtnAdmin.setSelected(true);
            this.transactionsBtnAdmin.setSelected(false);

            updateWallets(jwalletCombo3, jPanel10);
            rSPanelsSlider5.slidPanel(20, history1, RSPanelsSlider.direct.up);
        }
    }//GEN-LAST:event_historyBtnAdminActionPerformed

    private void transactionsBtnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsBtnAdminActionPerformed
        if (!this.transactionsBtnAdmin.isSelected()) {
            this.tableBtn.setSelected(false);
            this.graphBtn.setSelected(false);
            this.homeBtnAdmin.setSelected(false);
            this.historyBtnAdmin.setSelected(false);
            this.transactionsBtnAdmin.setSelected(true);

            rSPanelsSlider5.slidPanel(20, transactions1, RSPanelsSlider.direct.up);
        }
    }//GEN-LAST:event_transactionsBtnAdminActionPerformed

    private void transactionsBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsBtn4ActionPerformed
        try {
            float monto = Float.parseFloat(jTextField2.getText());
            PublicKey p = stringToPublicKey((String) jwallet1.getSelectedItem());
            PublicKey destino = stringToPublicKey(jTextField3.getText());

            g.insertTransaction(g.searchWallet(p), g.searchWallet(destino), monto);
            updateWallets(jwallet1, jPanel10);

            jTextField2.setText("");
            jTextField3.setText("");
            jdestino.setText("");

        } catch (NoSuchProviderException ex) {
            System.out.println("error");
        }
    }//GEN-LAST:event_transactionsBtn4ActionPerformed

    private void btnMenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu8ActionPerformed
        if (!toogleAdmin) {
            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, jPanel5);

            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, tableBtn);
            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, graphBtn);
            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, transactionsBtn5);
            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, homeBtnAdmin);
            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, historyBtnAdmin);
            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, transactionsBtnAdmin);
            toogleAdmin = true;

        } else {
            Animacion.Animacion.mover_derecha(-215, 0, 2, 2, jPanel5);

            Animacion.Animacion.mover_derecha(-215, 5, 2, 2, tableBtn);
            Animacion.Animacion.mover_derecha(-215, 5, 2, 2, graphBtn);
            Animacion.Animacion.mover_derecha(-215, 5, 2, 2, transactionsBtn5);
            Animacion.Animacion.mover_derecha(-215, 5, 2, 2, homeBtnAdmin);
            Animacion.Animacion.mover_derecha(-215, 5, 2, 2, historyBtnAdmin);
            Animacion.Animacion.mover_derecha(-215, 5, 2, 2, transactionsBtnAdmin);
            toogleAdmin = false;
        }
    }//GEN-LAST:event_btnMenu8ActionPerformed

    private void btnMenu7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu7ActionPerformed
        if (!toogleAccount) {
            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, jPanel4);

            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, homeBtn1);
            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, historyBtn1);
            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, transactionsBtn1);
            Animacion.Animacion.mover_izquierda(0, -215, 2, 2, transactionsBtn2);
            toogleAccount = true;

        } else {
            Animacion.Animacion.mover_derecha(-215, 0, 2, 2, jPanel4);

            Animacion.Animacion.mover_derecha(-215, 5, 2, 2, homeBtn1);
            Animacion.Animacion.mover_derecha(-215, 5, 2, 2, historyBtn1);
            Animacion.Animacion.mover_derecha(-215, 5, 2, 2, transactionsBtn1);
            Animacion.Animacion.mover_derecha(-215, 5, 2, 2, transactionsBtn2);
            toogleAccount = false;
        }
    }//GEN-LAST:event_btnMenu7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        g.insertWallet(g.searchUser(u.getID()), u.getID());
        updateWallets(jwallet, jPanel2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchHistoryActionPerformed
        searchHistory(histoyTable, jwalletCombo2);
    }//GEN-LAST:event_searchHistoryActionPerformed

    private void searchHistory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchHistory1ActionPerformed
        searchHistory(histoyTable1, jwalletCombo3);
    }//GEN-LAST:event_searchHistory1ActionPerformed

    private void fillUserInfo(String name, String last, String emailF, String id, boolean isAdmin) {

        if (!isAdmin) {
            fullName.setText(name + " " + last);
            jemail.setText(emailF);
            jid.setText(id);
        } else {
            jid1.setText(id);
        }

    }

    public void searchHistory(JTable tabla, JComboBox combo) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        File file = new File("data/Transacciones.txt");
        model.setRowCount(0);

        try (Scanner sc = new Scanner(file)) {
            PublicKey p = stringToPublicKey((String) combo.getSelectedItem());
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split(",");

                if (stringToPublicKey(data[1]).equals(p)) {
                    Wallet w = (Wallet) g.searchWallet(stringToPublicKey(data[2])).getO();
                    User a = (User) g.searchUser(w.getOwnerID()).getO();
                    model.addRow(new Object[]{"Envio", data[3]+"$", "a", a.getName(), "ID Transaccion", data[0]});
                } else if (stringToPublicKey(data[2]).equals(p)) {
                    Wallet w = (Wallet) g.searchWallet(stringToPublicKey(data[1])).getO();
                    User a = (User) g.searchUser(w.getOwnerID()).getO();
                    model.addRow(new Object[]{"Recibio", data[3]+"$", "De", a.getName(), "ID Transaccion", data[0]});
                }

            }

        } catch (Exception ex) {
            System.out.println("error " + ex);
        }
    }

    public void fillTables() {
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        model.setRowCount(0);
        File file = new File("data/Usuarios.txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split(",");
                model.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4]});
            }

        } catch (Exception ex) {
            System.out.println("error " + ex);
        }

        model = (DefaultTableModel) walletsTable.getModel();
        model.setRowCount(0);
        file = new File("data/Billeteras.txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split(",");
                model.addRow(new Object[]{data[0], data[1], data[2], data[3]});
            }

        } catch (Exception ex) {
            System.out.println("error " + ex);
        }

        model = (DefaultTableModel) transFile.getModel();
        model.setRowCount(0);
        file = new File("data/Transacciones.txt");

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split(",");
                model.addRow(new Object[]{data[0], data[1], data[2], data[3]});
            }

        } catch (Exception ex) {
            System.out.println("error " + ex);
        }

    }

    public void updateWallets(JComboBox combo, JPanel panel) {
        panel.removeAll();
        userWallets = g.searchUserWallets(u);
        for (Wallet w : userWallets) {
            combo.addItem(StringUtil.getStringFromKey(w.getPublicKey()));
            drawWallets(StringUtil.getStringFromKey(w.getPublicKey()).substring(0, Math.min(50, 20)), String.valueOf(w.getBalance()), panel);
        }
    }

    public PublicKey stringToPublicKey(String destino) throws NoSuchProviderException {

        KeyFactory factory = null;
        try {
            factory = KeyFactory.getInstance("ECDSA", "BC");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] senderKeyByte = Base64.decode(destino, Base64.NO_WRAP);
        try {
            PublicKey sender = (PublicKey) factory.generatePublic(new X509EncodedKeySpec(senderKeyByte));
            return sender;
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void drawWallets(String walletID, String balance, JPanel pane) {

        pane.setLayout(new GridLayout(5, 1));

        JPanel wallet = new javax.swing.JPanel();
        JLabel jlabelalgo8 = new javax.swing.JLabel();
        JLabel jlabelalgo9 = new javax.swing.JLabel();
        JLabel wid = new javax.swing.JLabel();
        JLabel bac = new javax.swing.JLabel();
        Border blackline = BorderFactory.createLineBorder(Color.black);
        wallet.setBorder(blackline);

        wallet.setBackground(new java.awt.Color(249, 247, 247));

        jlabelalgo8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabelalgo8.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo8.setText("Wallet ID");

        jlabelalgo9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabelalgo9.setForeground(new java.awt.Color(17, 45, 78));
        jlabelalgo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelalgo9.setText("Balance");

        wid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wid.setForeground(new java.awt.Color(0, 0, 0));
        wid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        wid.setText(walletID);

        bac.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bac.setForeground(new java.awt.Color(0, 0, 0));
        bac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bac.setText(balance);

        javax.swing.GroupLayout walletLayout = new javax.swing.GroupLayout(wallet);
        wallet.setLayout(walletLayout);
        walletLayout.setHorizontalGroup(
                walletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(walletLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(walletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(walletLayout.createSequentialGroup()
                                                .addComponent(jlabelalgo8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wid))
                                        .addGroup(walletLayout.createSequentialGroup()
                                                .addComponent(jlabelalgo9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bac)
                                                .addGap(8, 8, 8)))
                                .addContainerGap())
        );
        walletLayout.setVerticalGroup(
                walletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, walletLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(walletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlabelalgo8)
                                        .addComponent(wid, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(walletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlabelalgo9)
                                        .addComponent(bac, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
        );

        pane.add(wallet);

//        Insets insets = pane.getInsets();
//        Dimension size = wallet.getPreferredSize();
//        wallet.setBounds(60 + insets.left, 5 + insets.top,
//                size.width, size.height);
    }

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
            java.util.logging.Logger.getLogger(RochiCoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RochiCoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RochiCoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RochiCoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RochiCoin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountPane;
    private javax.swing.JPanel adminAccount;
    private javax.swing.JButton btnMenu7;
    private javax.swing.JButton btnMenu8;
    private javax.swing.JButton createTransactionBtn;
    private javax.swing.JTextField emailTField;
    private javax.swing.JLabel fghfh;
    private javax.swing.JLabel fghfh1;
    private javax.swing.JLabel fullName;
    private javax.swing.JLabel gdgf;
    private javax.swing.JButton goToLoginPanelBtn;
    private javax.swing.JButton goToRegisterPanelBtn;
    private javax.swing.JPanel graph;
    private javax.swing.JButton graphBtn;
    private javax.swing.JPanel history;
    private javax.swing.JPanel history1;
    private javax.swing.JButton historyBtn1;
    private javax.swing.JButton historyBtnAdmin;
    private javax.swing.JTable histoyTable;
    private javax.swing.JTable histoyTable1;
    private javax.swing.JPanel home;
    private javax.swing.JPanel home1;
    private javax.swing.JButton homeBtn1;
    private javax.swing.JButton homeBtnAdmin;
    private javax.swing.JTextField identNumberTField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jdestino;
    private javax.swing.JLabel jemail;
    private javax.swing.JLabel jid;
    private javax.swing.JLabel jid1;
    private javax.swing.JLabel jlabelalgo;
    private javax.swing.JLabel jlabelalgo1;
    private javax.swing.JLabel jlabelalgo2;
    private javax.swing.JLabel jlabelalgo3;
    private javax.swing.JLabel jlabelalgo4;
    private javax.swing.JLabel jlabelalgo5;
    private javax.swing.JLabel jlabelalgo6;
    private javax.swing.JLabel jlabelalgo7;
    private javax.swing.JLabel jlabelalgo8;
    private javax.swing.JLabel jlabelalgo9;
    private javax.swing.JTextField jmonto;
    private javax.swing.JComboBox<String> jwallet;
    private javax.swing.JComboBox<String> jwallet1;
    private javax.swing.JComboBox<String> jwalletCombo2;
    private javax.swing.JComboBox<String> jwalletCombo3;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTextField nameTField;
    private javax.swing.JPanel parent;
    private javax.swing.JTextField passwordTField;
    private rojerusan.RSPanelsSlider rSPanelsSlider4;
    private rojerusan.RSPanelsSlider rSPanelsSlider5;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField registerEmailTField;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JTextField registerPasswordTField;
    private javax.swing.JButton searchHistory;
    private javax.swing.JButton searchHistory1;
    private javax.swing.JTextField surnameTField;
    private javax.swing.JButton tableBtn;
    private javax.swing.JPanel tables;
    private javax.swing.JTable transFile;
    private javax.swing.JPanel transactions;
    private javax.swing.JPanel transactions1;
    private javax.swing.JButton transactionsBtn1;
    private javax.swing.JButton transactionsBtn2;
    private javax.swing.JButton transactionsBtn4;
    private javax.swing.JButton transactionsBtn5;
    private javax.swing.JButton transactionsBtnAdmin;
    private javax.swing.JTable userTable;
    private javax.swing.JTable walletsTable;
    // End of variables declaration//GEN-END:variables
}
