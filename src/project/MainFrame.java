package project;

import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class MainFrame extends javax.swing.JFrame {

    static Connection con; // Connection variable
    static Statement st; // Statement variable
    static ResultSet rs; // ResultSet variable
    static PreparedStatement pstmt; // PreparedStatement variable
    private final String username; // Username of the current admin

    public MainFrame(String username) {
        this.username = username; // Get the username from the login frame
        initComponents(); // Initialize the components
        con = ConnectionDataBase.ConnectDb(); // Connect to the database  
        show_currentAdmin(); // Show the current admin in portal
        updateTable(); // to update the jtable  
        updateComboBox(); // to update the jcomboBox
        currentDateTime(); // to show the current time in portal
        showUserCount(); // to show the total user in portal
        clearFields(); // to clear all the fields
        textId.disable(); // Disable the id field 
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/project/icon/tuplogo2.png"))); // logo of TUP in frame
    }

    // Function to show the current admin in portal
    public final void show_currentAdmin() {
        showAdmin.setText(username.toUpperCase());
    }

    // Funtion to get the total users added in data base
    public int getUserCount() {
        String sql = "SELECT COUNT(*) AS count FROM user_table";
        int count = 0;
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
        }
        return count;
    }

    // Function to show the total user in portal
    private void showUserCount() {
        int count = getUserCount();
        usercount.setText("Number of users: " + count);
    }

    // Function to show the current time in portal
    private void currentDateTime() {
        javax.swing.Timer timer = new javax.swing.Timer(1000, (ActionEvent e) -> {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            jLabel12.setText(dtf.format(now));
        });
        timer.start();
    }

    // Function to update the table
    private void updateTable() {
        String sql = "select * from user_table";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            Vector<String> columnNames = new Vector<>();
            columnNames.add("ID");
            columnNames.add("First Name");
            columnNames.add("Last Name");
            columnNames.add("Address");
            columnNames.add("Mobile No.");
            columnNames.add("Username");
            columnNames.add("Password");

            // Default table model
            DefaultTableModel dtm = new DefaultTableModel(columnNames, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Make all cells non-editable
                    return false;
                }
            };

            // Add data to the model
            while (rs.next()) {
                Vector row = new Vector(); // vector to hold the data
                for (int i = 1; i <= columnNames.size(); i++) {
                    row.add(rs.getObject(i));
                }
                dtm.addRow(row);
            }
            // Set the model to the userTable
            userTable.setModel(dtm);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    // Function to update the comboBox
    private void updateComboBox() {
        String sql = "select * from user_table";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // Clear existing items in comboBox
            comboBox.removeAllItems();

            while (rs.next()) {
                comboBox.addItem(rs.getString("id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Function to clear all the fields 
    private void clearFields() {
        comboBox.setSelectedItem(null);
        textId.setText(null);
        textFName.setText(null);
        textLName.setText(null);
        textAddress.setText(null);
        textMobileNo.setText(null);
        textUserName.setText(null);
        textPass.setText(null);
        textPassCon.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adduserframe = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        clearButton = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        textSearch = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        textId = new javax.swing.JTextField();
        textUserName = new javax.swing.JTextField();
        textPass = new javax.swing.JTextField();
        textPassCon = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        un = new javax.swing.JLabel();
        pas = new javax.swing.JLabel();
        pascon = new javax.swing.JLabel();
        textFName = new javax.swing.JTextField();
        textLName = new javax.swing.JTextField();
        textAddress = new javax.swing.JTextField();
        textMobileNo = new javax.swing.JTextField();
        fn = new javax.swing.JLabel();
        ln = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        mNo = new javax.swing.JLabel();
        insertButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        usercount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labelshowAdmin = new javax.swing.JLabel();
        showAdmin = new javax.swing.JLabel();

        jLabel3.setText("adduser");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(224, 224, 224))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel3)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout adduserframeLayout = new javax.swing.GroupLayout(adduserframe.getContentPane());
        adduserframe.getContentPane().setLayout(adduserframeLayout);
        adduserframeLayout.setHorizontalGroup(
            adduserframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adduserframeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
        );
        adduserframeLayout.setVerticalGroup(
            adduserframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adduserframeLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 107, Short.MAX_VALUE))
        );

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admins Access Module");

        jPanel1.setBackground(new java.awt.Color(255, 248, 242));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1230, 680));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(168, 48, 48));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TECHNOLOGICAL UNIVERSITY OF THE PHILIPPINES");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/tuplogo2.png"))); // NOI18N

        logOutButton.setBackground(new java.awt.Color(168, 48, 48));
        logOutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/exit.png"))); // NOI18N
        logOutButton.setText("Logout");
        logOutButton.setBorder(null);
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 736, Short.MAX_VALUE)
                .addComponent(logOutButton)
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(logOutButton))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Address", "Mobile No.", "Username", "Password"
            }
        ));
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        userTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        clearButton.setBackground(new java.awt.Color(204, 204, 204));
        clearButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(0, 0, 0));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/clear.png"))); // NOI18N
        clearButton.setText("      CLEAR ALL");
        clearButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        comboBox.setBackground(new java.awt.Color(204, 204, 204));
        comboBox.setForeground(new java.awt.Color(0, 0, 0));
        comboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        searchButton.setBackground(new java.awt.Color(204, 204, 204));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchButton.setForeground(new java.awt.Color(0, 0, 0));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/search.png"))); // NOI18N
        searchButton.setText("SEARCH ID");
        searchButton.setToolTipText("");
        searchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("TIME:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/user.png"))); // NOI18N
        jLabel4.setText("USER INFORMATION");

        jPanel4.setBackground(new java.awt.Color(255, 238, 238));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("ID");

        un.setForeground(new java.awt.Color(0, 0, 0));
        un.setText("Username");

        pas.setForeground(new java.awt.Color(0, 0, 0));
        pas.setText("Password");

        pascon.setForeground(new java.awt.Color(0, 0, 0));
        pascon.setText("Confirm Password");

        textFName.setText(" ");

        textMobileNo.setToolTipText("ex. 12345678901");
        textMobileNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textMobileNoKeyTyped(evt);
            }
        });

        fn.setBackground(new java.awt.Color(0, 0, 0));
        fn.setForeground(new java.awt.Color(0, 0, 0));
        fn.setText("First Name");

        ln.setForeground(new java.awt.Color(0, 0, 0));
        ln.setText("Last Name");

        add.setForeground(new java.awt.Color(0, 0, 0));
        add.setText("Address");

        mNo.setForeground(new java.awt.Color(0, 0, 0));
        mNo.setText("Mobile No.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fn)
                    .addComponent(ln)
                    .addComponent(add)
                    .addComponent(mNo))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textMobileNo)
                            .addComponent(textAddress, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textLName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pas)
                    .addComponent(un)
                    .addComponent(jLabel11)
                    .addComponent(pascon))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addComponent(textId, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textPass, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(textPassCon, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ln)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(un)
                        .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pas)
                    .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pascon)
                        .addComponent(textPassCon))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mNo)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        insertButton.setBackground(new java.awt.Color(204, 204, 204));
        insertButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        insertButton.setForeground(new java.awt.Color(0, 0, 0));
        insertButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/adduser.png"))); // NOI18N
        insertButton.setText("     ADD USER");
        insertButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        insertButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(204, 204, 204));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/deleteuser.png"))); // NOI18N
        deleteButton.setText("DELETE USER");
        deleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(204, 204, 204));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(0, 0, 0));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/edit.png"))); // NOI18N
        updateButton.setText("UPDATE USER");
        updateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        usercount.setForeground(new java.awt.Color(0, 0, 0));
        usercount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/currentuser.png"))); // NOI18N
        usercount.setText("=");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Mark Jason Esguerra");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Created by ");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("from");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("BSIT-2A");

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        labelshowAdmin.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelshowAdmin.setForeground(new java.awt.Color(255, 255, 255));
        labelshowAdmin.setText("WELCOME ADMIN");

        showAdmin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        showAdmin.setForeground(new java.awt.Color(255, 255, 255));
        showAdmin.setText("USERNAME");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelshowAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelshowAdmin)
                    .addComponent(showAdmin)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(usercount)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                .addComponent(insertButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(238, 238, 238))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6))
                            .addGap(481, 481, 481))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usercount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // INSERT USER BUTTOM
    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        insertButton.setFocusable(false);
        boolean isEmpty = false;
        JTextField[] fields = {textFName, textLName, textAddress, textMobileNo, textUserName, textPass, textPassCon};
        JLabel[] labels = {fn, ln, add, mNo, un, pas, pascon};
        // Check if any of the fields are empty
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().isEmpty()) {
                labels[i].setForeground(Color.RED); // make the label text red
                isEmpty = true;
            } else {
                labels[i].setForeground(Color.BLACK);
            }
        }

        String checkSql = "SELECT * FROM user_table WHERE username = ?";
        try {
            pstmt = con.prepareStatement(checkSql);
            pstmt.setString(1, textUserName.getText());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username already exists", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        if (isEmpty) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty");
            return;
        }
        if (!textPass.getText().equals(textPassCon.getText())) {
            JOptionPane.showMessageDialog((null), "Password not match", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            String sql = "INSERT INTO user_table(fname, lname, address, mobileno, username, cpass) VALUES(?,?,?,?,?,?)";
            try {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, textFName.getText());
                pstmt.setString(2, textLName.getText());
                pstmt.setString(3, textAddress.getText());
                pstmt.setString(4, textMobileNo.getText());
                pstmt.setString(5, textUserName.getText());
                pstmt.setString(6, textPassCon.getText());
                pstmt.execute();
                JOptionPane.showMessageDialog(null, "Record Created", "System Message", JOptionPane.INFORMATION_MESSAGE);
                updateTable();
                clearFields();
                updateComboBox();
                textSearchKeyReleased(null);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            showUserCount();
        }
    }//GEN-LAST:event_insertButtonActionPerformed

    //UPDATE BUTTON
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        updateButton.setFocusable(false);
        if (userTable.getSelectionModel().isSelectionEmpty() || comboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Select User you want to update", "System Message", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!textPass.getText().equals(textPassCon.getText())) {
            JOptionPane.showMessageDialog((null), "Password not match", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String sql = "UPDATE user_table SET fname = ?, lname = ?, address = ?, mobileno = ?, username = ?, cpass = ? WHERE id = ?";
            int ans;
            ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this record?", "System Message", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) {
                try {
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, textFName.getText());
                    pstmt.setString(2, textLName.getText());
                    pstmt.setString(3, textAddress.getText());
                    pstmt.setString(4, textMobileNo.getText());
                    pstmt.setString(5, textUserName.getText());
                    pstmt.setString(6, textPass.getText());
                    pstmt.setInt(7, Integer.parseInt(comboBox.getSelectedItem().toString()));
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updated successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);
                    updateTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    //DELETE BUTTON
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteButton.setFocusable(false);
        if (userTable.getSelectionModel().isSelectionEmpty() || comboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Select User you want to delete", "System Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int selectedRow = userTable.getSelectedRow();
            int modelRow = userTable.convertRowIndexToModel(selectedRow); // Convert to model index
            String cell = userTable.getModel().getValueAt(modelRow, 0).toString(); // Get the value of the first column which is the id
            String sql = "delete from user_table where id = ?";
            int ans;
            ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "System Message", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) {
                try {
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, cell); // Set the id to the query
                    pstmt.execute();
                    JOptionPane.showMessageDialog(null, "Record Deleted Successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);
                    updateTable();
                    clearFields();
                    updateComboBox();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                } finally {
                    try {
                        rs.close();
                        pstmt.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
            showUserCount();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    //LOGOUT BUTTON
    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        ALogin loginframe = new ALogin();
        loginframe.setVisible(true);
        loginframe.pack();
        loginframe.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_logOutButtonActionPerformed

    //CLEAR BUTTON
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearButton.setFocusable(false);
        clearFields();
        JLabel[] labels = {fn, ln, add, mNo, un, pas, pascon};
        for (JLabel label : labels) { // Also reset the label color to black
            label.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_clearButtonActionPerformed

    //SEARCH BUTTON
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchButton.setFocusable(false);
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        userTable.setRowSorter(sorter);
        try {
            String sql = "select * from user_table where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, textSearch.getText());
            rs = pstmt.executeQuery();
            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "Sorry the ID no. " + textSearch.getText() + " Not Found");
                clearFields();
            } else {
                textId.setText(rs.getString("id"));
                textFName.setText(rs.getString("fname"));
                textLName.setText(rs.getString("lname"));
                textAddress.setText(rs.getString("address"));
                textMobileNo.setText(rs.getString("mobileno"));
                textUserName.setText(rs.getString("username"));
                textPass.setText(rs.getString("cpass"));
                textPassCon.setText(rs.getString("cpass"));
            }
        } catch (Exception e) {

        }
        try {
            String searchText = textSearch.getText();
            if (searchText.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter(searchText));
            }

            // Find the row index of the searched user
            for (int i = 0; i < userTable.getRowCount(); i++) {
                if (userTable.getValueAt(i, 0).toString().equals(searchText)) {
                    // Highlight the row
                    userTable.getSelectionModel().setSelectionInterval(i, i);
                    break;
                }
            }
        } catch (Exception e) {
            // Handle exception
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    // Function to select the user from table
    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        int viewRow = userTable.getSelectedRow();
        int modelRow = userTable.convertRowIndexToModel(viewRow); // Convert view index to model index
        String selection = userTable.getModel().getValueAt(modelRow, 0).toString();
        String sql = "select * from user_table where id = " + selection;
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                comboBox.setSelectedItem(rs.getString("id"));
                textId.setText(rs.getString("id"));
                textFName.setText(rs.getString("fname"));
                textLName.setText(rs.getString("lname"));
                textAddress.setText(rs.getString("address"));
                textMobileNo.setText(rs.getString("mobileno"));
                textUserName.setText(rs.getString("username"));
                textPass.setText(rs.getString("cpass"));
                textPassCon.setText(rs.getString("cpass"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_userTableMouseClicked

    // Function to select the user from table using keyboard keys
    private void userTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTableKeyReleased
        int viewRow = userTable.getSelectedRow();
        int modelRow = userTable.convertRowIndexToModel(viewRow); // Convert view index to model index
        String selection = userTable.getModel().getValueAt(modelRow, 0).toString();
        String sql = "select * from user_table where id = " + selection;
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                comboBox.setSelectedItem(rs.getString("id"));
                textId.setText(rs.getString("id"));
                textFName.setText(rs.getString("fname"));
                textLName.setText(rs.getString("lname"));
                textAddress.setText(rs.getString("address"));
                textMobileNo.setText(rs.getString("mobileno"));
                textUserName.setText(rs.getString("username"));
                textPass.setText(rs.getString("cpass"));
                textPassCon.setText(rs.getString("cpass"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_userTableKeyReleased

    // COMBO BOX 
    private void comboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboBoxPopupMenuWillBecomeInvisible
        String item = (String) comboBox.getSelectedItem(); // Get the selected item from the combo box
        String sql = "select * from user_table where id= ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, item);// Set the id to the query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                textId.setText(rs.getString("id"));
                textFName.setText(rs.getString("fname"));
                textLName.setText(rs.getString("lname"));
                textAddress.setText(rs.getString("address"));
                textMobileNo.setText(rs.getString("mobileno"));
                textUserName.setText(rs.getString("username"));
                textPass.setText(rs.getString("cpass"));
                textPassCon.setText(rs.getString("cpass"));
                // Highlight the selected user in the table
                for (int i = 0; i < userTable.getRowCount(); i++) {
                    Object value = userTable.getValueAt(i, 0);
                    if (value != null && value.toString().equals(item)) {
                        userTable.setRowSelectionInterval(i, i);
                        userTable.scrollRectToVisible(userTable.getCellRect(i, 0, true));
                        break;
                    }
                }
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_comboBoxPopupMenuWillBecomeInvisible

    // mobile number text field inly allow digits
    private void textMobileNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMobileNoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_textMobileNoKeyTyped

    // SEARCH TEXT FIELD
    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        userTable.setRowSorter(sorter);
        try {
            final String searchText = textSearch.getText();
            if (searchText.length() == 0) { // If the search text is empty, show all the records
                sorter.setRowFilter(null);
            } else { // Otherwise, show only the records that match the search text
                sorter.setRowFilter(new RowFilter<DefaultTableModel, Integer>() {
                    @Override
                    public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
                        String userId = entry.getStringValue(0);
                        return userId.equals(searchText);
                    }
                });
            }
        } catch (Exception e) {
            // Handle exception
        }
    }//GEN-LAST:event_textSearchKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add;
    private javax.swing.JFrame adduserframe;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel fn;
    private javax.swing.JButton insertButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelshowAdmin;
    private javax.swing.JLabel ln;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel mNo;
    private javax.swing.JLabel pas;
    private javax.swing.JLabel pascon;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel showAdmin;
    private javax.swing.JTextField textAddress;
    private javax.swing.JTextField textFName;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textLName;
    private javax.swing.JTextField textMobileNo;
    private javax.swing.JTextField textPass;
    private javax.swing.JTextField textPassCon;
    private javax.swing.JTextField textSearch;
    private javax.swing.JTextField textUserName;
    private javax.swing.JLabel un;
    private javax.swing.JButton updateButton;
    private javax.swing.JTable userTable;
    private javax.swing.JLabel usercount;
    // End of variables declaration//GEN-END:variables
}
