package UI;

import Graph.Graph2;
import Graph.Vertex;
import System.StringUtil;
import System.Transaction;
import System.User;
import System.Wallet;
import android.util.Base64;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Group#9
 */
public class RochiCoin extends javax.swing.JFrame {

    CardLayout mainLayout, secondLayout, secondLayout1;
    Graph2 g;
    Vertex userVertex;
    User u;
    ArrayList<Wallet> wallets;

    public RochiCoin() {
        initComponents();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();

            }

        });

        mainLayout = (CardLayout) parent.getLayout();
        secondLayout = (CardLayout) parent2.getLayout();
        secondLayout1 = (CardLayout) parent5.getLayout();
        g = new Graph2();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        subtitleLabel = new javax.swing.JLabel();
        emailTField = new javax.swing.JTextField();
        passwordTField = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        goToRegistrationBtn = new javax.swing.JButton();
        registerPanel = new javax.swing.JPanel();
        titleLabel1 = new javax.swing.JLabel();
        subtitleLabel1 = new javax.swing.JLabel();
        nameTField = new javax.swing.JTextField();
        surnameTField = new javax.swing.JTextField();
        cedTField = new javax.swing.JTextField();
        emailTField1 = new javax.swing.JTextField();
        passwordTField1 = new javax.swing.JTextField();
        registerBtn = new javax.swing.JButton();
        goToLoginBtn = new javax.swing.JButton();
        adminPanel = new javax.swing.JPanel();
        sideBarPanel1 = new javax.swing.JPanel();
        titleLabel7 = new javax.swing.JLabel();
        homeBtn1 = new javax.swing.JButton();
        historyBtn1 = new javax.swing.JButton();
        transactionBtn1 = new javax.swing.JButton();
        exitBtn1 = new javax.swing.JButton();
        graphBtn = new javax.swing.JButton();
        parent5 = new javax.swing.JPanel();
        homePanel3 = new javax.swing.JPanel();
        titlePanel5 = new javax.swing.JPanel();
        titleLabel10 = new javax.swing.JLabel();
        userInfoPanel1 = new javax.swing.JPanel();
        idLabel1 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        surnameLabel1 = new javax.swing.JLabel();
        cedLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        walletInfoPanel1 = new javax.swing.JPanel();
        newWalletBtn1 = new javax.swing.JButton();
        historyPanel1 = new javax.swing.JPanel();
        titlePanel6 = new javax.swing.JPanel();
        titleLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        walletsHistoryPanel1 = new javax.swing.JPanel();
        transactionPanel1 = new javax.swing.JPanel();
        titlePanel7 = new javax.swing.JPanel();
        titleLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        walletsCB1 = new javax.swing.JComboBox<>();
        recipientTField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sendTransactionBtn1 = new javax.swing.JButton();
        moneyTField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        graphPanel = new javax.swing.JPanel();
        titlePanel9 = new javax.swing.JPanel();
        titleLabel14 = new javax.swing.JLabel();
        placeHolderPanel1 = new javax.swing.JPanel();
        userPanel = new javax.swing.JPanel();
        sideBarPanel = new javax.swing.JPanel();
        titleLabel3 = new javax.swing.JLabel();
        homeBtn = new javax.swing.JButton();
        historyBtn = new javax.swing.JButton();
        transactionBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        parent2 = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        titleLabel4 = new javax.swing.JLabel();
        userInfoPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        cedLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        walletInfoPanel = new javax.swing.JPanel();
        newWalletBtn = new javax.swing.JButton();
        historyPanel = new javax.swing.JPanel();
        titlePanel1 = new javax.swing.JPanel();
        titleLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        walletsHistoryPanel = new javax.swing.JPanel();
        transactionPanel = new javax.swing.JPanel();
        titlePanel2 = new javax.swing.JPanel();
        titleLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        walletsCB = new javax.swing.JComboBox<>();
        recipientTField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sendTransactionBtn = new javax.swing.JButton();
        moneyTField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        parent.setLayout(new java.awt.CardLayout());

        titleLabel.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("RochiCoin");

        subtitleLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        subtitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtitleLabel.setText("Login a cuenta");

        emailTField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        passwordTField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        goToRegistrationBtn.setText("Registrarse");
        goToRegistrationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToRegistrationBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(goToRegistrationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(emailTField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordTField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 460, Short.MAX_VALUE)))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(titleLabel)
                .addGap(50, 50, 50)
                .addComponent(subtitleLabel)
                .addGap(25, 25, 25)
                .addComponent(emailTField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(passwordTField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goToRegistrationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(314, Short.MAX_VALUE))
        );

        parent.add(loginPanel, "card2");

        titleLabel1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel1.setText("RochiCoin");

        subtitleLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        subtitleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtitleLabel1.setText("Registrar una nueva cuenta");

        nameTField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        surnameTField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cedTField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        emailTField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        passwordTField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        registerBtn.setText("Registrarse");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        goToLoginBtn.setText("Registrarse");
        goToLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToLoginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
                    .addComponent(subtitleLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(surnameTField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cedTField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(registerPanelLayout.createSequentialGroup()
                                    .addComponent(goToLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(passwordTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(titleLabel1)
                .addGap(50, 50, 50)
                .addComponent(subtitleLabel1)
                .addGap(25, 25, 25)
                .addComponent(nameTField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(surnameTField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(cedTField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(emailTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(passwordTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goToLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        parent.add(registerPanel, "card4");

        sideBarPanel1.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel7.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        titleLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel7.setText("RochiCoin");

        homeBtn1.setText("Hogar");
        homeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtn1ActionPerformed(evt);
            }
        });

        historyBtn1.setText("Historial");
        historyBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtn1ActionPerformed(evt);
            }
        });

        transactionBtn1.setText("Transaccion");
        transactionBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionBtn1ActionPerformed(evt);
            }
        });

        exitBtn1.setText("Salir");
        exitBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtn1ActionPerformed(evt);
            }
        });

        graphBtn.setText("Grafo");
        graphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBarPanel1Layout = new javax.swing.GroupLayout(sideBarPanel1);
        sideBarPanel1.setLayout(sideBarPanel1Layout);
        sideBarPanel1Layout.setHorizontalGroup(
            sideBarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideBarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(homeBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historyBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transactionBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(graphBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sideBarPanel1Layout.setVerticalGroup(
            sideBarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel7)
                .addGap(50, 50, 50)
                .addComponent(homeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(historyBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(transactionBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(graphBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                .addComponent(exitBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        parent5.setLayout(new java.awt.CardLayout());

        titlePanel5.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel10.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titleLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel10.setText("Informacion del usuario");

        javax.swing.GroupLayout titlePanel5Layout = new javax.swing.GroupLayout(titlePanel5);
        titlePanel5.setLayout(titlePanel5Layout);
        titlePanel5Layout.setHorizontalGroup(
            titlePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanel5Layout.setVerticalGroup(
            titlePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userInfoPanel1.setBackground(new java.awt.Color(204, 204, 204));

        idLabel1.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        idLabel1.setText("ID del usuario: ");

        nameLabel1.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        nameLabel1.setText("Nombre: ");

        surnameLabel1.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        surnameLabel1.setText("Apellido:");

        cedLabel1.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        cedLabel1.setText("Cedula:");

        javax.swing.GroupLayout userInfoPanel1Layout = new javax.swing.GroupLayout(userInfoPanel1);
        userInfoPanel1.setLayout(userInfoPanel1Layout);
        userInfoPanel1Layout.setHorizontalGroup(
            userInfoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInfoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel1)
                    .addComponent(nameLabel1)
                    .addComponent(surnameLabel1)
                    .addComponent(cedLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userInfoPanel1Layout.setVerticalGroup(
            userInfoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(surnameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cedLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        walletInfoPanel1.setLayout(new java.awt.GridLayout(0, 1, 25, 25));
        jScrollPane3.setViewportView(walletInfoPanel1);

        newWalletBtn1.setText("Crear nueva billetera");
        newWalletBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newWalletBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homePanel3Layout = new javax.swing.GroupLayout(homePanel3);
        homePanel3.setLayout(homePanel3Layout);
        homePanel3Layout.setHorizontalGroup(
            homePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(homePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newWalletBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(homePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titlePanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userInfoPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homePanel3Layout.setVerticalGroup(
            homePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userInfoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(newWalletBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        parent5.add(homePanel3, "card2");

        titlePanel6.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel11.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titleLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel11.setText("Historial de billeteras");

        javax.swing.GroupLayout titlePanel6Layout = new javax.swing.GroupLayout(titlePanel6);
        titlePanel6.setLayout(titlePanel6Layout);
        titlePanel6Layout.setHorizontalGroup(
            titlePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanel6Layout.setVerticalGroup(
            titlePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        walletsHistoryPanel1.setLayout(new java.awt.GridLayout(1, 0, 25, 25));
        jScrollPane4.setViewportView(walletsHistoryPanel1);

        javax.swing.GroupLayout historyPanel1Layout = new javax.swing.GroupLayout(historyPanel1);
        historyPanel1.setLayout(historyPanel1Layout);
        historyPanel1Layout.setHorizontalGroup(
            historyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(historyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        historyPanel1Layout.setVerticalGroup(
            historyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );

        parent5.add(historyPanel1, "card3");

        titlePanel7.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel12.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titleLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel12.setText("Realizar transaccion");

        javax.swing.GroupLayout titlePanel7Layout = new javax.swing.GroupLayout(titlePanel7);
        titlePanel7.setLayout(titlePanel7Layout);
        titlePanel7Layout.setHorizontalGroup(
            titlePanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanel7Layout.setVerticalGroup(
            titlePanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        walletsCB1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        walletsCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        recipientTField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        jLabel4.setText("Recipiente:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        jLabel5.setText("Remitente:");

        sendTransactionBtn1.setText("Enviar");
        sendTransactionBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendTransactionBtn1ActionPerformed(evt);
            }
        });

        moneyTField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        jLabel6.setText("Monto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(recipientTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(20, 20, 20)
                        .addComponent(walletsCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sendTransactionBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(moneyTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(walletsCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipientTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moneyTField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(sendTransactionBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout transactionPanel1Layout = new javax.swing.GroupLayout(transactionPanel1);
        transactionPanel1.setLayout(transactionPanel1Layout);
        transactionPanel1Layout.setHorizontalGroup(
            transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        transactionPanel1Layout.setVerticalGroup(
            transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        parent5.add(transactionPanel1, "card4");

        titlePanel9.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel14.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titleLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel14.setText("Grafo");

        javax.swing.GroupLayout titlePanel9Layout = new javax.swing.GroupLayout(titlePanel9);
        titlePanel9.setLayout(titlePanel9Layout);
        titlePanel9Layout.setHorizontalGroup(
            titlePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanel9Layout.setVerticalGroup(
            titlePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        placeHolderPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout placeHolderPanel1Layout = new javax.swing.GroupLayout(placeHolderPanel1);
        placeHolderPanel1.setLayout(placeHolderPanel1Layout);
        placeHolderPanel1Layout.setHorizontalGroup(
            placeHolderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        placeHolderPanel1Layout.setVerticalGroup(
            placeHolderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graphPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(placeHolderPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(placeHolderPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        parent5.add(graphPanel, "card6");

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addComponent(sideBarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1087, Short.MAX_VALUE))
            .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                    .addContainerGap(203, Short.MAX_VALUE)
                    .addComponent(parent5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBarPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(parent5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parent.add(adminPanel, "card5");

        sideBarPanel.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel3.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        titleLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel3.setText("RochiCoin");

        homeBtn.setText("Hogar");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        historyBtn.setText("Historial");
        historyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtnActionPerformed(evt);
            }
        });

        transactionBtn.setText("Transaccion");
        transactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Salir");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBarPanelLayout = new javax.swing.GroupLayout(sideBarPanel);
        sideBarPanel.setLayout(sideBarPanelLayout);
        sideBarPanelLayout.setHorizontalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(homeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transactionBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sideBarPanelLayout.setVerticalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel3)
                .addGap(50, 50, 50)
                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(historyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(transactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        parent2.setLayout(new java.awt.CardLayout());

        titlePanel.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel4.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titleLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel4.setText("Informacion del usuario");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userInfoPanel.setBackground(new java.awt.Color(204, 204, 204));

        idLabel.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        idLabel.setText("ID del usuario: ");

        nameLabel.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        nameLabel.setText("Nombre: ");

        surnameLabel.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        surnameLabel.setText("Apellido:");

        cedLabel.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        cedLabel.setText("Cedula:");

        javax.swing.GroupLayout userInfoPanelLayout = new javax.swing.GroupLayout(userInfoPanel);
        userInfoPanel.setLayout(userInfoPanelLayout);
        userInfoPanelLayout.setHorizontalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel)
                    .addComponent(nameLabel)
                    .addComponent(surnameLabel)
                    .addComponent(cedLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userInfoPanelLayout.setVerticalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(surnameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cedLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        walletInfoPanel.setLayout(new java.awt.GridLayout(0, 1, 25, 25));
        jScrollPane1.setViewportView(walletInfoPanel);

        newWalletBtn.setText("Crear nueva billetera");
        newWalletBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newWalletBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newWalletBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(newWalletBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        parent2.add(homePanel, "card2");

        titlePanel1.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel5.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titleLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel5.setText("Historial de billeteras");

        javax.swing.GroupLayout titlePanel1Layout = new javax.swing.GroupLayout(titlePanel1);
        titlePanel1.setLayout(titlePanel1Layout);
        titlePanel1Layout.setHorizontalGroup(
            titlePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanel1Layout.setVerticalGroup(
            titlePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        walletsHistoryPanel.setLayout(new java.awt.GridLayout(1, 0, 25, 25));
        jScrollPane2.setViewportView(walletsHistoryPanel);

        javax.swing.GroupLayout historyPanelLayout = new javax.swing.GroupLayout(historyPanel);
        historyPanel.setLayout(historyPanelLayout);
        historyPanelLayout.setHorizontalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        historyPanelLayout.setVerticalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );

        parent2.add(historyPanel, "card3");

        titlePanel2.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel6.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        titleLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel6.setText("Realizar transaccion");

        javax.swing.GroupLayout titlePanel2Layout = new javax.swing.GroupLayout(titlePanel2);
        titlePanel2.setLayout(titlePanel2Layout);
        titlePanel2Layout.setHorizontalGroup(
            titlePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanel2Layout.setVerticalGroup(
            titlePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        walletsCB.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        walletsCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        recipientTField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        jLabel1.setText("Recipiente:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        jLabel2.setText("Remitente:");

        sendTransactionBtn.setText("Enviar");
        sendTransactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendTransactionBtnActionPerformed(evt);
            }
        });

        moneyTField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        jLabel3.setText("Monto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(recipientTField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addComponent(walletsCB, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sendTransactionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(moneyTField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(walletsCB, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipientTField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moneyTField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(sendTransactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout transactionPanelLayout = new javax.swing.GroupLayout(transactionPanel);
        transactionPanel.setLayout(transactionPanelLayout);
        transactionPanelLayout.setHorizontalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        transactionPanelLayout.setVerticalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        parent2.add(transactionPanel, "card4");

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addComponent(sideBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(parent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        parent.add(userPanel, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        u = g.searchLoginUser(emailTField.getText(), passwordTField.getText());
        if (u != null) {
            wallets = g.searchUserWallets(u.getID());
            if (u.getID().equals(g.getMasterID())) {
                initiateAdminPanel();
            } else {
                initiateUserPanel();
            }
        } else {
            //AQUI FALTA ALGO YOOOOOOOOO
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void goToRegistrationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToRegistrationBtnActionPerformed
        mainLayout.show(parent, "card4");
    }//GEN-LAST:event_goToRegistrationBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        if (g.checkEmail(emailTField1.getText())) {
            u = new User(nameTField.getText(),
                    surnameTField.getText(),
                    Integer.parseInt(cedTField.getText()),
                    emailTField1.getText(),
                    passwordTField1.getText());
            
            Wallet w = new Wallet(u.getID());
            wallets = new ArrayList();
            wallets.add(w);
            g.insertUserVertex(u);
            userVertex = g.searchUserVertex(u.getID());
            g.insertWalletVertex(userVertex, w);
            
            Wallet genWallet = g.searchUserWallets(g.getMasterID()).get(0);
            
            if(genWallet.getBalance()>100){
                g.insertTransactionVertex(genWallet, w.getPublicKey(), 100);
            }
            
            initiateUserPanel();
        } else {
            //AQUI FALTA ALGO YOOOOOOOOO
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void goToLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToLoginBtnActionPerformed
        mainLayout.show(parent, "card2");
    }//GEN-LAST:event_goToLoginBtnActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        secondLayout.show(parent2, "card2");
    }//GEN-LAST:event_homeBtnActionPerformed

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
        secondLayout.show(parent2, "card3");
    }//GEN-LAST:event_historyBtnActionPerformed

    private void transactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionBtnActionPerformed
        secondLayout.show(parent2, "card4");
    }//GEN-LAST:event_transactionBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        secondLayout.show(parent2, "card2");
        mainLayout.show(parent, "card2");
    }//GEN-LAST:event_exitBtnActionPerformed

    private void newWalletBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newWalletBtnActionPerformed
        Wallet w = new Wallet(u.getID());
        g.insertWalletVertex(userVertex, w);
        wallets.add(w);
        updateWalletUI();
    }//GEN-LAST:event_newWalletBtnActionPerformed

    private void sendTransactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendTransactionBtnActionPerformed
        int n = walletsCB.getSelectedIndex();
        Wallet a = wallets.get(n);

        PublicKey b = null;
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        KeyFactory factory = null;
        try {
            factory = KeyFactory.getInstance("ECDSA", "BC");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] recipientKeyByte = Base64.decode(recipientTField.getText(), Base64.NO_WRAP);
        try {
            b = (PublicKey) factory.generatePublic(new X509EncodedKeySpec(recipientKeyByte));
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }

        Float value = Float.parseFloat(moneyTField.getText());

        g.insertTransactionVertex(a, b, value);
        updateWalletUI();
    }//GEN-LAST:event_sendTransactionBtnActionPerformed

    private void homeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtn1ActionPerformed
        secondLayout1.show(parent5, "card2");
    }//GEN-LAST:event_homeBtn1ActionPerformed

    private void historyBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtn1ActionPerformed
        secondLayout1.show(parent5, "card3");
    }//GEN-LAST:event_historyBtn1ActionPerformed

    private void transactionBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionBtn1ActionPerformed
        secondLayout1.show(parent5, "card4");
    }//GEN-LAST:event_transactionBtn1ActionPerformed

    private void exitBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtn1ActionPerformed
        secondLayout1.show(parent5, "card2");
        mainLayout.show(parent, "card2");
    }//GEN-LAST:event_exitBtn1ActionPerformed

    private void newWalletBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newWalletBtn1ActionPerformed
        Wallet w = new Wallet(u.getID());
        g.insertWalletVertex(userVertex, w);
        wallets.add(w);
        updateAdminWalletUI();
    }//GEN-LAST:event_newWalletBtn1ActionPerformed

    private void sendTransactionBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendTransactionBtn1ActionPerformed
        int n = walletsCB1.getSelectedIndex();
        Wallet a = wallets.get(n);

        PublicKey b = null;
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        KeyFactory factory = null;
        try {
            factory = KeyFactory.getInstance("ECDSA", "BC");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] recipientKeyByte = Base64.decode(recipientTField1.getText(), Base64.NO_WRAP);
        try {
            b = (PublicKey) factory.generatePublic(new X509EncodedKeySpec(recipientKeyByte));
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }

        Float value = Float.parseFloat(moneyTField1.getText());

        
        g.insertTransactionVertex(a, b, value);
        updateAdminWalletUI();
    }//GEN-LAST:event_sendTransactionBtn1ActionPerformed

    private void graphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_graphBtnActionPerformed

    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RochiCoin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminPanel;
    private javax.swing.JLabel cedLabel;
    private javax.swing.JLabel cedLabel1;
    private javax.swing.JTextField cedTField;
    private javax.swing.JTextField emailTField;
    private javax.swing.JTextField emailTField1;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton exitBtn1;
    private javax.swing.JButton goToLoginBtn;
    private javax.swing.JButton goToRegistrationBtn;
    private javax.swing.JButton graphBtn;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JButton historyBtn;
    private javax.swing.JButton historyBtn1;
    private javax.swing.JPanel historyPanel;
    private javax.swing.JPanel historyPanel1;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton homeBtn1;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel homePanel1;
    private javax.swing.JPanel homePanel2;
    private javax.swing.JPanel homePanel3;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTextField moneyTField;
    private javax.swing.JTextField moneyTField1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JTextField nameTField;
    private javax.swing.JButton newWalletBtn;
    private javax.swing.JButton newWalletBtn1;
    private javax.swing.JPanel parent;
    private javax.swing.JPanel parent2;
    private javax.swing.JPanel parent3;
    private javax.swing.JPanel parent4;
    private javax.swing.JPanel parent5;
    private javax.swing.JTextField passwordTField;
    private javax.swing.JTextField passwordTField1;
    private javax.swing.JPanel placeHolderPanel1;
    private javax.swing.JTextField recipientTField;
    private javax.swing.JTextField recipientTField1;
    private javax.swing.JButton registerBtn;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JButton sendTransactionBtn;
    private javax.swing.JButton sendTransactionBtn1;
    private javax.swing.JPanel sideBarPanel;
    private javax.swing.JPanel sideBarPanel1;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JLabel subtitleLabel1;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel surnameLabel1;
    private javax.swing.JTextField surnameTField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JLabel titleLabel10;
    private javax.swing.JLabel titleLabel11;
    private javax.swing.JLabel titleLabel12;
    private javax.swing.JLabel titleLabel14;
    private javax.swing.JLabel titleLabel3;
    private javax.swing.JLabel titleLabel4;
    private javax.swing.JLabel titleLabel5;
    private javax.swing.JLabel titleLabel6;
    private javax.swing.JLabel titleLabel7;
    private javax.swing.JLabel titleLabel8;
    private javax.swing.JLabel titleLabel9;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel titlePanel1;
    private javax.swing.JPanel titlePanel2;
    private javax.swing.JPanel titlePanel3;
    private javax.swing.JPanel titlePanel4;
    private javax.swing.JPanel titlePanel5;
    private javax.swing.JPanel titlePanel6;
    private javax.swing.JPanel titlePanel7;
    private javax.swing.JPanel titlePanel9;
    private javax.swing.JButton transactionBtn;
    private javax.swing.JButton transactionBtn1;
    private javax.swing.JPanel transactionPanel;
    private javax.swing.JPanel transactionPanel1;
    private javax.swing.JPanel userInfoPanel;
    private javax.swing.JPanel userInfoPanel1;
    private javax.swing.JPanel userPanel;
    private javax.swing.JPanel walletInfoPanel;
    private javax.swing.JPanel walletInfoPanel1;
    private javax.swing.JComboBox<String> walletsCB;
    private javax.swing.JComboBox<String> walletsCB1;
    private javax.swing.JPanel walletsHistoryPanel;
    private javax.swing.JPanel walletsHistoryPanel1;
    // End of variables declaration//GEN-END:variables

    private void initiateUserPanel() {
        idLabel.setText("ID: " + u.getID());
        nameLabel.setText("Nombre: " + u.getName());
        surnameLabel.setText("Apellido: " + u.getSurname());
        cedLabel.setText("Cedula: " + u.getIdentificationNumber());
        updateWalletUI();
        mainLayout.show(parent, "card6");
    }

    private void initiateAdminPanel() {
        idLabel1.setText("ID: " + u.getID());
        nameLabel1.setText("Nombre: " + u.getName());
        surnameLabel1.setText("Apellido: " + u.getSurname());
        cedLabel1.setText("Cedula: " + u.getIdentificationNumber());
        updateAdminWalletUI();
        mainLayout.show(parent, "card5");
    }

    private void updateWalletUI() {
        int i = 1;
        walletInfoPanel.removeAll();
        walletsHistoryPanel.removeAll();
        walletsCB.removeAllItems();
        for (Wallet w : wallets) {
            walletInfoPanel.add(new WalletPanel(i,
                    StringUtil.getStringFromKey(w.getPublicKey()),
                    StringUtil.getStringFromKey(w.getPrivateKey()),
                    w.getBalance()));

            ArrayList<Transaction> transactions = g.searchWalletTransactions(w.getPublicKey());
            walletsHistoryPanel.add(new WalletHistoryPanel(i, w.getBalance(), w.getPublicKey(), transactions));
            walletsCB.addItem("Billetera #" + i);
            i++;
        }
        walletInfoPanel.revalidate();
        walletsHistoryPanel.revalidate();
        walletsCB.revalidate();
        walletInfoPanel.repaint();
        walletsHistoryPanel.repaint();
        walletsCB.repaint();
    }

    private void updateAdminWalletUI() {
        int i = 1;
        walletInfoPanel1.removeAll();
        walletsHistoryPanel1.removeAll();
        walletsCB1.removeAllItems();
        for (Wallet w : wallets) {
            walletInfoPanel1.add(new WalletPanel(i,
                    StringUtil.getStringFromKey(w.getPublicKey()),
                    StringUtil.getStringFromKey(w.getPrivateKey()),
                    w.getBalance()));

            ArrayList<Transaction> transactions = g.searchWalletTransactions(w.getPublicKey());
            walletsHistoryPanel1.add(new WalletHistoryPanel(i, w.getBalance(), w.getPublicKey(), transactions));
            walletsCB1.addItem("Billetera #" + i);
            i++;
        }
        walletInfoPanel1.revalidate();
        walletsHistoryPanel1.revalidate();
        walletsCB1.revalidate();
        walletInfoPanel1.repaint();
        walletsHistoryPanel1.repaint();
        walletsCB1.repaint();
        
    }

    public void exitProcedure() {
        g.saveFiles();
        this.dispose();
        System.exit(0);
    }

}
