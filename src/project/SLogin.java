package project;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

public class SLogin extends javax.swing.JFrame {

    static Connection con; // connection to database
    static Statement st; // statement to execute query
    static ResultSet rs; // result of executed query

    public SLogin() {
        initComponents(); // initialize the components
        this.hide_eye1.setVisible(false); // hide the hide_eye1 icon in frame 
        con = ConnectionDataBase.ConnectDb(); // connect to database
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/project/icon/tuplogo2.png"))); // logo of TUP in frame
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textUserName = new javax.swing.JTextField();
        textPass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        ALoginButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        eye1 = new javax.swing.JLabel();
        hide_eye1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        userlogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Portal");

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        rPanel2.setBackground(new java.awt.Color(51, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TECHNOLOGICAL UNIVERSITY OF THE PHILIPPINES");

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mark Jason Esguerra\\Documents\\NetBeansProjects\\OPP PROJECT\\icon\\tuplogo1.png")); // NOI18N

        javax.swing.GroupLayout rPanel2Layout = new javax.swing.GroupLayout(rPanel2);
        rPanel2.setLayout(rPanel2Layout);
        rPanel2Layout.setHorizontalGroup(
            rPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rPanel2Layout.createSequentialGroup()
                .addGroup(rPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2))
                    .addGroup(rPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        rPanel2Layout.setVerticalGroup(
            rPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rPanel2Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(99, 99, 99))
        );

        jPanel1.add(rPanel2);
        rPanel2.setBounds(0, 0, 400, 500);

        lPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 0));
        jLabel3.setText("SIGN IN");

        textUserName.setBackground(new java.awt.Color(255, 255, 255));
        textUserName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 0, 0))); // NOI18N

        textPass.setBackground(new java.awt.Color(255, 255, 255));
        textPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 0, 0))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Login as Admin?");

        ALoginButton.setBackground(new java.awt.Color(255, 255, 255));
        ALoginButton.setForeground(new java.awt.Color(51, 0, 0));
        ALoginButton.setText("Login");
        ALoginButton.setBorder(null);
        ALoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALoginButtonActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(51, 0, 0));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        eye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/eye.png"))); // NOI18N
        eye1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eye1MousePressed(evt);
            }
        });

        hide_eye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/eye_hide.png"))); // NOI18N
        hide_eye1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hide_eye1MousePressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(51, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 2, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 0, 0));
        jLabel10.setText("Created by Mark Jason Esguerra.");

        userlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/user.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN AS STUDENT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/lock.png"))); // NOI18N

        javax.swing.GroupLayout lPanel2Layout = new javax.swing.GroupLayout(lPanel2);
        lPanel2.setLayout(lPanel2Layout);
        lPanel2Layout.setHorizontalGroup(
            lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lock)
                    .addComponent(userlogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton)
                    .addGroup(lPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ALoginButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lPanel2Layout.createSequentialGroup()
                        .addGroup(lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textUserName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPass, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eye1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hide_eye1)
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lPanel2Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(131, 131, 131))))
            .addGroup(lPanel2Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        lPanel2Layout.setVerticalGroup(
            lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGroup(lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(userlogo))
                    .addGroup(lPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lPanel2Layout.createSequentialGroup()
                        .addGroup(lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lPanel2Layout.createSequentialGroup()
                                .addComponent(textPass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lPanel2Layout.createSequentialGroup()
                                .addGroup(lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hide_eye1)
                                    .addComponent(eye1))
                                .addGap(32, 32, 32)))
                        .addComponent(loginButton)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lPanel2Layout.createSequentialGroup()
                        .addComponent(lock)
                        .addGap(117, 117, 117)))
                .addGroup(lPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ALoginButton))
                .addGap(56, 56, 56)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        jPanel1.add(lPanel2);
        lPanel2.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //FUNCTION FOR ADMIN LOGIN PORTAL
    private void ALoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALoginButtonActionPerformed
        ALogin loginframe = new ALogin();
        loginframe.setVisible(true);
        loginframe.pack(); //resize the frame to fit the components
        loginframe.setLocationRelativeTo(null); //center the frame in the screen
        this.dispose();
    }//GEN-LAST:event_ALoginButtonActionPerformed

    //FUNCTION TO UNHIDE PASSWORD TEXT
    private void eye1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eye1MousePressed
        hide_eye1.setVisible(true);
        eye1.setVisible(false);
        textPass.setEchoChar((char) 0);
    }//GEN-LAST:event_eye1MousePressed

    //FUNCTION TO HIDE PASSWORD TEXT
    private void hide_eye1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide_eye1MousePressed
        eye1.setVisible(true);
        hide_eye1.setVisible(false);
        textPass.setEchoChar('\u2022');
    }//GEN-LAST:event_hide_eye1MousePressed

    //FUNTION TO LOGGIN IN STUDEN'S PORTAL
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String studentName = textUserName.getText();
        String studentPass = textPass.getText();
    
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM user_table WHERE BINARY username = '" + studentName + "' and cpass= '" + studentPass + "'");
            String getUsername = "", getPassword = "";
            int getUserID = 0;
    
            if (rs.next()) {
                getUsername = rs.getString("username");
                getPassword = rs.getString("cpass");
                getUserID = rs.getInt("id");
                if (studentName.equals("") && studentPass.equals("")) {
                    JOptionPane.showMessageDialog((null), "Enter username or password", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (studentName.equalsIgnoreCase(getUsername) && studentPass.equals(getPassword)) {
                    if (studentName.equals(getUsername)) {
                        StudentFrame sframe = new StudentFrame(getUsername, getUserID);
                        sframe.setVisible(true);
                        sframe.pack();
                        sframe.setLocationRelativeTo(null);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog((null), "Wrong username or password", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog((null), "Wrong username or password", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog((null), "Wrong username or password", "ERROR", JOptionPane.ERROR_MESSAGE);
                textUserName.setText("");
                textPass.setText("");
            }
    
        } catch (HeadlessException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ALoginButton;
    private javax.swing.JLabel eye1;
    private javax.swing.JLabel hide_eye1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel lPanel2;
    private javax.swing.JLabel lock;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel rPanel2;
    private javax.swing.JPasswordField textPass;
    private javax.swing.JTextField textUserName;
    private javax.swing.JLabel userlogo;
    // End of variables declaration//GEN-END:variables
}
