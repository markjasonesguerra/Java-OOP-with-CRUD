package project;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;

public class ALogin extends javax.swing.JFrame {

    static Connection con; // connection to database
    static Statement st; // statement to execute query
    static ResultSet rs; // result of query

    public ALogin() {
        initComponents(); // initialize the components
        con = ConnectionDataBase.ConnectDb(); // connect to database
        this.hide_eye.setVisible(false); // hide the eye icon for password
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/project/icon/tuplogo2.png"))); // logo of TUP in frame
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        rPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textUsername = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textPass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        SLoginButton = new javax.swing.JButton();
        eye = new javax.swing.JLabel();
        hide_eye = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Portal");
        setPreferredSize(new java.awt.Dimension(800, 500));

        mainPanel.setBackground(new java.awt.Color(204, 204, 204));
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 500));
        mainPanel.setLayout(null);

        rPanel.setBackground(new java.awt.Color(51, 0, 0));
        rPanel.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/tuplogo1.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TECHNOLOGICAL UNIVERSITY OF THE PHILIPPINES");

        javax.swing.GroupLayout rPanelLayout = new javax.swing.GroupLayout(rPanel);
        rPanel.setLayout(rPanelLayout);
        rPanelLayout.setHorizontalGroup(
            rPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        rPanelLayout.setVerticalGroup(
            rPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        mainPanel.add(rPanel);
        rPanel.setBounds(0, 0, 400, 500);

        fPanel.setBackground(new java.awt.Color(255, 255, 255));
        fPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 0));
        jLabel1.setText("SIGN IN");

        textUsername.setBackground(new java.awt.Color(255, 255, 255));
        textUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 0, 0))); // NOI18N

        loginButton.setBackground(new java.awt.Color(51, 0, 0));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(51, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 2, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 0));
        jLabel6.setText("Created by Mark Jason Esguerra.");

        textPass.setBackground(new java.awt.Color(255, 255, 255));
        textPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 0, 0))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Login as Student?");

        SLoginButton.setBackground(new java.awt.Color(255, 255, 255));
        SLoginButton.setForeground(new java.awt.Color(102, 0, 0));
        SLoginButton.setText("Login");
        SLoginButton.setBorder(null);
        SLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SLoginButtonActionPerformed(evt);
            }
        });

        eye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/eye.png"))); // NOI18N
        eye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eyeMousePressed(evt);
            }
        });

        hide_eye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/eye_hide.png"))); // NOI18N
        hide_eye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hide_eyeMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("LOGIN AS ADMIN ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/lockAdmin.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/admin.png"))); // NOI18N

        javax.swing.GroupLayout fPanelLayout = new javax.swing.GroupLayout(fPanel);
        fPanel.setLayout(fPanelLayout);
        fPanelLayout.setHorizontalGroup(
            fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fPanelLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(fPanelLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fPanelLayout.createSequentialGroup()
                        .addGroup(fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loginButton)
                            .addGroup(fPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SLoginButton))
                            .addComponent(textPass, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(textUsername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hide_eye)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eye)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        fPanelLayout.setVerticalGroup(
            fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGroup(fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel10)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                    .addGroup(fPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(textPass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eye)
                                    .addComponent(hide_eye))
                                .addGap(45, 45, 45)))))
                .addComponent(loginButton)
                .addGap(45, 45, 45)
                .addGroup(fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(SLoginButton))
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addGap(47, 47, 47))
        );

        mainPanel.add(fPanel);
        fPanel.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("LOGIN");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //FUNCTION TO LOGGIN IN ADMIN'S PORTAL
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String adminName = textUsername.getText();
        String adminPass = textPass.getText();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM login_table WHERE username = '" + adminName + "' and password = '" + adminPass + "'");
            String getUsername = "", getPassword = "";

            if (rs.next()) {
                getUsername = rs.getString("username");
                getPassword = rs.getString("password");
            }
            if (adminName.equals("") && adminPass.equals("")) {
                JOptionPane.showMessageDialog((null), "Enter username or password", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (adminName.equals(getUsername) && adminPass.equals(getPassword)) {
                MainFrame mainframe = new MainFrame(getUsername);
                mainframe.setVisible(true);
                mainframe.pack(); //resize the frame to fit the components
                mainframe.setLocationRelativeTo(null); //center the frame in the screen
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog((null), "Wrong username or password", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            textUsername.setText("");
            textPass.setText("");
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    //FUNCTION FOR STUDENT LOGIN PORTAL
    private void SLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SLoginButtonActionPerformed
        SLogin signupframe = new SLogin();
        signupframe.setVisible(true);
        signupframe.pack();
        signupframe.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_SLoginButtonActionPerformed

    //FUNCTION TO HIDE PASSWORD TEXT
    private void hide_eyeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide_eyeMousePressed
        eye.setVisible(true);
        hide_eye.setVisible(false);
        textPass.setEchoChar('\u2022');
    }//GEN-LAST:event_hide_eyeMousePressed

    //FUNCTION TO UNHIDE PASSWORD TEXT
    private void eyeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeMousePressed
        hide_eye.setVisible(true);
        eye.setVisible(false);
        textPass.setEchoChar((char) 0);
    }//GEN-LAST:event_eyeMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SLoginButton;
    private javax.swing.JLabel eye;
    private javax.swing.JPanel fPanel;
    private javax.swing.JLabel hide_eye;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel rPanel;
    private javax.swing.JPasswordField textPass;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}
