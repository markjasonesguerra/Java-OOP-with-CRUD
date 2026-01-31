package project;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.swing.filechooser.FileNameExtensionFilter;

public class StudentFrame extends javax.swing.JFrame {

    static Connection con; // connection to the database
    static Statement st; // statement to execute the query
    static ResultSet rs; // result set of the query
    static PreparedStatement pstmt; // prepared statement to execute the query
    private final String username; // username of the user that logged in 
    private final int id; // id of the user that logged in
    byte[] image = null; // byte array for the image of the user
    private String selectedImagePath; // path of the image of the user that will be uploaded

    public StudentFrame(String username, int id) { 
        this.id = id; // id of the user that logged in 
        this.username = username; // username of the user that logged in
        initComponents(); // initialize all the components
        showUsername(); // show username of the user in every tab
        getCurrentDate(); // show the current date
        con = ConnectionDataBase.ConnectDb(); // establish a connection with the database
        ButtonGroup genderGroup = new ButtonGroup(); // for male and female radio buttons
        genderGroup.add(rMale); // radio button 
        genderGroup.add(rFemale); // radio button 
        showInfo(); // show all the information of the user
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/project/icon/tuplogo2.png"))); // logo of TUP in frame
    }

    //Function to show the current date
    private void getCurrentDate() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
        String strDate = formatter.format(date);
        datelabel.setText(strDate);
    }

    //Function to show username of the user in every tab
    private void showUsername() {
        current_username.setText(" " + username.toUpperCase() + " (" + id + ")");
        current_username1.setText(" " + username.toUpperCase() + " (" + id + ")");
        current_username2.setText(" " + username.toUpperCase() + " (" + id + ")");
        current_username3.setText(" " + username.toUpperCase() + " (" + id + ")");
    }

    //Function to show all the information of the user once logged in 
    private void showInfo() {
        String sql = "select * from personalinfo_table where id = " + id;
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                tFname.setText(rs.getString("fname"));
                tLname.setText(rs.getString("lname"));
                tMI.setText(rs.getString("mname"));
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("birthdate"));
                tBday.setDate(date);
                tReligion.setText(rs.getString("religion"));
                citizenshipBox.setSelectedItem(rs.getString("nationality"));
                String gender = rs.getString("gender");
                if ("Male".equals(gender)) {
                    rMale.setSelected(true);
                } else if ("Female".equals(gender)) {
                    rFemale.setSelected(true);
                }
                tAge.setText(rs.getString("age"));
                tHeight.setText(rs.getString("height"));
                tWeight.setText(rs.getString("weight"));
                tCellp.setText(rs.getString("cp"));
                tFb.setText(rs.getString("fb"));
                tEmail.setText(rs.getString("email"));
                // Convert the byte array back to an image and set it to a JLabel
                byte[] imgBytes = rs.getBytes("photo");
                image = imgBytes; // Add this line
                ImageIcon imageIcon = new ImageIcon(imgBytes);
                Image im = imageIcon.getImage();
                Image myImg = im.getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                picture.setIcon(newImage);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        profilePanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        tFname = new javax.swing.JTextField();
        bd = new javax.swing.JLabel();
        rg = new javax.swing.JLabel();
        gen = new javax.swing.JLabel();
        cs = new javax.swing.JLabel();
        tReligion = new javax.swing.JTextField();
        fn = new javax.swing.JLabel();
        tLname = new javax.swing.JTextField();
        ln = new javax.swing.JLabel();
        tMI = new javax.swing.JTextField();
        mi = new javax.swing.JLabel();
        cm = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        tAge = new javax.swing.JTextField();
        tHeight = new javax.swing.JTextField();
        cn = new javax.swing.JLabel();
        tCellp = new javax.swing.JTextField();
        tWeight = new javax.swing.JTextField();
        lbs = new javax.swing.JLabel();
        rMale = new javax.swing.JRadioButton();
        rFemale = new javax.swing.JRadioButton();
        em = new javax.swing.JLabel();
        tEmail = new javax.swing.JTextField();
        fb = new javax.swing.JLabel();
        tFb = new javax.swing.JTextField();
        citizenshipBox = new javax.swing.JComboBox<>();
        saveButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tBday = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();
        labelPhoto = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        picture = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        current_username = new javax.swing.JLabel();
        passPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        tOldPass = new javax.swing.JTextField();
        tConPass = new javax.swing.JTextField();
        tNewPass = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        current_username1 = new javax.swing.JLabel();
        calendarPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        current_username2 = new javax.swing.JLabel();
        message = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageText = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        receiverUNameText = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        subjectText = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        sendMessButton = new javax.swing.JButton();
        imageButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        view = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        current_username3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        profileButton = new javax.swing.JButton();
        passButton = new javax.swing.JButton();
        calendarButton = new javax.swing.JButton();
        messButton = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Students Access Module");
        setSize(new java.awt.Dimension(1230, 680));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1230, 680));

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));
        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/user.png"))); // NOI18N
        jLabel8.setText("PERSONAL INFORMATION");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));

        name.setForeground(new java.awt.Color(0, 0, 0));
        name.setText("Name ");

        bd.setForeground(new java.awt.Color(0, 0, 0));
        bd.setText("Birth Date     ");

        rg.setForeground(new java.awt.Color(0, 0, 0));
        rg.setText("Religion");

        gen.setForeground(new java.awt.Color(0, 0, 0));
        gen.setText("Gender ");

        cs.setForeground(new java.awt.Color(0, 0, 0));
        cs.setText("Citizenship");

        fn.setForeground(new java.awt.Color(0, 0, 0));
        fn.setText("Last Name");

        ln.setForeground(new java.awt.Color(0, 0, 0));
        ln.setText("First Name");

        mi.setForeground(new java.awt.Color(0, 0, 0));
        mi.setText("Middle Initial");

        cm.setForeground(new java.awt.Color(0, 0, 0));
        cm.setText("Height: (cm) ");

        age.setForeground(new java.awt.Color(0, 0, 0));
        age.setText("Age");

        tAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tAgeKeyTyped(evt);
            }
        });

        tHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tHeightKeyTyped(evt);
            }
        });

        cn.setForeground(new java.awt.Color(0, 0, 0));
        cn.setText("Cellphone Number");

        tCellp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCellpKeyTyped(evt);
            }
        });

        tWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tWeightKeyTyped(evt);
            }
        });

        lbs.setForeground(new java.awt.Color(0, 0, 0));
        lbs.setText("Weight: (lbs) ");

        rMale.setBackground(new java.awt.Color(255, 255, 255));
        rMale.setForeground(new java.awt.Color(51, 51, 51));
        rMale.setText("Male");

        rFemale.setBackground(new java.awt.Color(255, 255, 255));
        rFemale.setForeground(new java.awt.Color(51, 51, 51));
        rFemale.setText("Female");

        em.setForeground(new java.awt.Color(0, 0, 0));
        em.setText("Email");

        fb.setForeground(new java.awt.Color(0, 0, 0));
        fb.setText("Facebook");

        citizenshipBox.setBackground(new java.awt.Color(255, 255, 255));
        citizenshipBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-nationality-", "Afghan", "Albanian", "Algerian", "American", "Andorran", "Angolan", "Antiguan or Barbudan", "Argentine", "Armenian", "Australian", "Austrian", "Azerbaijani, Azeri", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Basotho", "Belarusian", "Belgian", "Belizean", "Beninois", "Bhutanese", "Bolivian", "Bosnian or Herzegovinian", "Botswanan", "Brazilian", "British", "Bruneian", "Bulgarian", "Burkinabé", "Burmese", "Burundian", "Cabo Verdean", "Cambodian", "Cameroonian", "Canadian", "Central African", "Chadian", "Chilean", "Chinese", "Colombian", "Comorian", "Congolese", "Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish", "Djiboutian", "Dominican", "Dutch", "Ecuadorian", "Egyptian", "Emirian", "Equatoguinean", "Eritrean", "Estonian", "Ethiopian", "Fijian", "Filipino", "Finnish", "French", "Gabonese", "Gambian", "Georgian", "German", "Ghanaian", "Gibraltar", "Grenadian", "Greek", "Guatemalan", "Guinean", "Guyanese", "Haitian", "Honduran", "Hungarian", "Icelandic", "Indian", "Indonesian", "Iranian", "Iraqi", "Irish", "Israeli", "Italian", "Ivorian", "Jamaican", "Japanese", "Jordanian", "Kazakh", "Kenyan", "Kirghiz", "Kiribati", "Kuwaiti", "Laotian", "Latvian", "Lebanese", "Liberian", "Libyan", "Liechtensteiner", "Lithuanian", "Luxembourgish", "Macedonian", "Malagasy", "Malawian", "Malaysian", "Maldivian", "Malian", "Maltese", "Marshallese", "Martinican", "Mauritanian", "Mauritian", "Mexican", "Micronesian", "Moldovan", "Monacan", "Mongolian", "Montenegrin", "Moroccan", "Mozambican", "Namibian", "Nauruan", "Nepali", "New Zealander", "Nicaraguan", "Nigerien", "Nigerian", "North Korean", "Northern Marianan", "Norwegian", "Omani", "Pakistani", "Palauan", "Palestinian", "Panamanian", "Papuan", "Paraguayan", "Peruvian", "Polish", "Portuguese", "Puerto Rican", "Qatari", "Romanian", "Russian", "Rwandan", "Saint Lucian", "Sammarinese", "Samoan", "São Toméan", "Saudi Arabian", "Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Singaporean", "Slovak", "Slovenian, Slovene", "Solomon Island", "Somali", "South African", "South Korean", "South Sudanese", "Spanish", "Sri Lankan", "Sudanese", "Surinamese", "Swazi", "Swedish", "Swiss", "Syrian", "Tajikistani", "Tanzanian", "Thai", "Timorese", "Togolese", "Tokelauan", "Tongan", "Trinidadian", "Tunisian", "Turkish", "Turkmen", "Tuvaluan", "Ugandan", "Ukrainian", "Uruguayan", "Uzbek", "Vanuatuan", "Vatican", "Venezuelan", "Vietnamese", "Vincentian", "Yemeni", "Zambian", "Zimbabwean" }));
        citizenshipBox.setBorder(null);

        saveButton.setBackground(new java.awt.Color(102, 0, 0));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/save.png"))); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText(":");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText(":");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText(":");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText(":");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText(":");

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText(":");

        tBday.setBackground(new java.awt.Color(255, 255, 255));
        tBday.setMaxSelectableDate(new java.util.Date(253370739716000L));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText(":");

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText(":");

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText(":");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText(":");

        uploadButton.setBackground(new java.awt.Color(102, 0, 0));
        uploadButton.setForeground(new java.awt.Color(255, 255, 255));
        uploadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/photo.png"))); // NOI18N
        uploadButton.setText("Upload Photo");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        labelPhoto.setBackground(new java.awt.Color(0, 0, 102));
        labelPhoto.setForeground(new java.awt.Color(0, 0, 51));
        labelPhoto.setText("Upload Photo");

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText(":");

        picture.setForeground(new java.awt.Color(102, 0, 0));
        picture.setText("                  Picture");
        picture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText(":");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(rg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tFname)
                                    .addComponent(tReligion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(citizenshipBox, 0, 278, Short.MAX_VALUE)
                                    .addComponent(tBday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(em, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tCellp)
                                    .addComponent(tEmail)
                                    .addComponent(tFb))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(tLname, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tMI, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tAge)
                                        .addComponent(tHeight)
                                        .addComponent(tWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(rMale)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rFemale))))
                                .addGap(48, 48, 48)
                                .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(uploadButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(age)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(204, 204, 204)
                                .addComponent(ln))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(gen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelPhoto)
                                    .addComponent(lbs))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(154, 154, 154)
                        .addComponent(mi, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(picture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name)
                            .addComponent(tFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fn)
                            .addComponent(ln)
                            .addComponent(mi))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gen)
                                    .addComponent(rMale)
                                    .addComponent(rFemale)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(bd))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tBday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rg)
                            .addComponent(age)
                            .addComponent(tAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cs)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cm)
                                .addComponent(tHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(citizenshipBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbs)
                                .addComponent(jLabel18))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tCellp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cn)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(em)
                                .addComponent(jLabel13))
                            .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tFb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fb)
                            .addComponent(jLabel14)
                            .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPhoto)
                            .addComponent(jLabel23))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel7.setBackground(new java.awt.Color(0, 0, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/info-circle-solid-48.png"))); // NOI18N

        jLabel21.setForeground(new java.awt.Color(153, 255, 255));
        jLabel21.setText("1. Kindly type 'NA' in boxes where there are no possible answers to the information being requested. ");

        jLabel22.setForeground(new java.awt.Color(153, 255, 255));
        jLabel22.setText("2. To make use of the letter 'Ñ', please press ALT while typing \"165\", while for 'ñ', please press ALT while typing \"164\".");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22))
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        profilePanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1240, 440));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("WELCOME");
        profilePanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        current_username.setForeground(new java.awt.Color(0, 0, 0));
        current_username.setText(" username");
        profilePanel.add(current_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 250, -1));

        jTabbedPane1.addTab("tab1", profilePanel);

        passPanel.setBackground(new java.awt.Color(255, 255, 255));
        passPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel24.setBackground(new java.awt.Color(255, 51, 51));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 51));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/lock.png"))); // NOI18N
        jLabel24.setText("CHANGE PASSWORD");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));

        tOldPass.setBackground(new java.awt.Color(255, 255, 255));
        tOldPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Old Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        tOldPass.setSelectionColor(new java.awt.Color(0, 0, 0));

        tConPass.setBackground(new java.awt.Color(255, 255, 255));
        tConPass.setForeground(new java.awt.Color(0, 0, 0));
        tConPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirm Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        tConPass.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tConPass.setSelectionColor(new java.awt.Color(0, 0, 0));

        tNewPass.setBackground(new java.awt.Color(255, 255, 255));
        tNewPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        tNewPass.setSelectionColor(new java.awt.Color(0, 0, 0));

        clearButton.setBackground(new java.awt.Color(168, 48, 48));
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear Entries");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        changeButton.setBackground(new java.awt.Color(168, 48, 48));
        changeButton.setForeground(new java.awt.Color(255, 255, 255));
        changeButton.setText("Change Password");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(clearButton)
                        .addGap(18, 18, 18)
                        .addComponent(changeButton))
                    .addComponent(tNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tConPass, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(861, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(tOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tConPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel10.setBackground(new java.awt.Color(0, 0, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/info-circle-solid-48.png"))); // NOI18N

        jLabel27.setForeground(new java.awt.Color(153, 255, 255));
        jLabel27.setText("1. At least 8 characters long but 16 is better.");

        jLabel28.setForeground(new java.awt.Color(153, 255, 255));
        jLabel28.setText("2. A combination of (2)uppercase letters, (2)lowercase letters, numbers, and symbols.");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28))
                    .addComponent(jLabel26))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        passPanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1240, 440));

        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("WELCOME");
        passPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        current_username1.setForeground(new java.awt.Color(0, 0, 0));
        current_username1.setText(" username");
        passPanel.add(current_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 250, -1));

        jTabbedPane1.addTab("tab2", passPanel);

        calendarPanel.setBackground(new java.awt.Color(255, 255, 255));
        calendarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 204, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));

        jCalendar1.setBackground(new java.awt.Color(255, 255, 255));
        jCalendar1.setDecorationBackgroundColor(new java.awt.Color(0, 51, 102));
        jCalendar1.setSundayForeground(new java.awt.Color(255, 255, 255));
        jCalendar1.setWeekdayForeground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));

        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setText("No Event Data.");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        datelabel.setForeground(new java.awt.Color(0, 0, 0));
        datelabel.setText("Current Date");

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Current Date:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(datelabel))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        calendarPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1240, 440));

        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("WELCOME");
        calendarPanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        current_username2.setForeground(new java.awt.Color(0, 0, 0));
        current_username2.setText(" username");
        calendarPanel.add(current_username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 250, -1));

        jTabbedPane1.addTab("tab3", calendarPanel);

        message.setBackground(new java.awt.Color(255, 255, 255));
        message.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(255, 204, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));

        messageText.setColumns(20);
        messageText.setRows(5);
        jScrollPane1.setViewportView(messageText);

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("To");

        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Subject");

        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Content");

        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText(":");

        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText(":");

        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText(":");

        sendMessButton.setBackground(new java.awt.Color(0, 0, 51));
        sendMessButton.setForeground(new java.awt.Color(255, 255, 255));
        sendMessButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/send.png"))); // NOI18N
        sendMessButton.setText("Send");
        sendMessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessButtonActionPerformed(evt);
            }
        });

        imageButton.setBackground(new java.awt.Color(255, 255, 255));
        imageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/file_image.png"))); // NOI18N
        imageButton.setBorder(null);
        imageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageButtonActionPerformed(evt);
            }
        });

        view.setBackground(new java.awt.Color(255, 255, 255));
        view.setForeground(new java.awt.Color(0, 0, 0));
        view.setText("view image");
        view.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(0, 0, 51));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/info-circle-solid-48.png"))); // NOI18N

        jLabel42.setForeground(new java.awt.Color(153, 255, 255));
        jLabel42.setText("1. The Email that your using is \"tuptest123@gmail.com\".");

        jLabel43.setForeground(new java.awt.Color(153, 255, 255));
        jLabel43.setText("2. Please indicate your name before sending email. ");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel43))
                    .addComponent(jLabel41))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel36))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel37)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(sendMessButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(view))
                            .addComponent(receiverUNameText, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                            .addComponent(subjectText))))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(461, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(receiverUNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subjectText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel37)))
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38)
                                .addComponent(jLabel34))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sendMessButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(view))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        message.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1240, 440));

        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("WELCOME");
        message.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        current_username3.setForeground(new java.awt.Color(0, 0, 0));
        current_username3.setText(" username");
        message.add(current_username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 250, -1));

        jTabbedPane1.addTab("tab4", message);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Mark Jason Esguerra");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("BSIT-2A");

        profileButton.setBackground(new java.awt.Color(168, 48, 48));
        profileButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        profileButton.setForeground(new java.awt.Color(255, 255, 255));
        profileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/user.png"))); // NOI18N
        profileButton.setText("Profile");
        profileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileButtonMouseExited(evt);
            }
        });
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        passButton.setBackground(new java.awt.Color(168, 48, 48));
        passButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passButton.setForeground(new java.awt.Color(255, 255, 255));
        passButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/edit.png"))); // NOI18N
        passButton.setText("Password");
        passButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passButtonMouseExited(evt);
            }
        });
        passButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passButtonActionPerformed(evt);
            }
        });

        calendarButton.setBackground(new java.awt.Color(168, 48, 48));
        calendarButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        calendarButton.setForeground(new java.awt.Color(255, 255, 255));
        calendarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/calendar.png"))); // NOI18N
        calendarButton.setText("Calendar");
        calendarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calendarButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calendarButtonMouseExited(evt);
            }
        });
        calendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarButtonActionPerformed(evt);
            }
        });

        messButton.setBackground(new java.awt.Color(168, 48, 48));
        messButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        messButton.setForeground(new java.awt.Color(255, 255, 255));
        messButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/message.png"))); // NOI18N
        messButton.setText("Message");
        messButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                messButtonMouseMoved(evt);
            }
        });
        messButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                messButtonMouseExited(evt);
            }
        });
        messButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messButtonActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("Created by ");

        jLabel40.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 51));
        jLabel40.setText("from");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(579, 579, 579))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profileButton)
                    .addComponent(passButton)
                    .addComponent(calendarButton)
                    .addComponent(messButton))
                .addGap(3, 3, 3)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel40))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutButton)
                .addGap(94, 94, 94))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(logOutButton)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //LOGOUT BUTTON
    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        SLogin loginframe = new SLogin(); // back to login frame
        loginframe.setVisible(true); // set login frame visible
        loginframe.pack(); // sizes the frame
        loginframe.setLocationRelativeTo(null); // centers the frame
        this.dispose(); // close the current frame
    }//GEN-LAST:event_logOutButtonActionPerformed

    // This function is to change color of the button when mouse is hovered
    private void profileButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseEntered
        profileButton.setBackground(new Color(97, 11, 11));
    }//GEN-LAST:event_profileButtonMouseEntered

    private void profileButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseExited
        profileButton.setBackground(new Color(168, 48, 48));
    }//GEN-LAST:event_profileButtonMouseExited

    private void passButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passButtonMouseEntered
        passButton.setBackground(new Color(97, 11, 11));
    }//GEN-LAST:event_passButtonMouseEntered

    private void passButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passButtonMouseExited
        passButton.setBackground(new Color(168, 48, 48));
    }//GEN-LAST:event_passButtonMouseExited

    private void calendarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarButtonMouseEntered
        calendarButton.setBackground(new Color(97, 11, 11));
    }//GEN-LAST:event_calendarButtonMouseEntered

    private void calendarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarButtonMouseExited
        calendarButton.setBackground(new Color(168, 48, 48));
    }//GEN-LAST:event_calendarButtonMouseExited

    private void messButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messButtonMouseExited
        messButton.setBackground(new Color(168, 48, 48));
    }//GEN-LAST:event_messButtonMouseExited

    private void messButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messButtonMouseMoved
        messButton.setBackground(new Color(97, 11, 11));
    }//GEN-LAST:event_messButtonMouseMoved

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_profileButtonActionPerformed

    private void passButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passButtonActionPerformed
        jTabbedPane1.setSelectedIndex(1);

    }//GEN-LAST:event_passButtonActionPerformed

    private void calendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarButtonActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_calendarButtonActionPerformed

    private void messButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messButtonActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_messButtonActionPerformed

    //FUNCTION TO SAVE OR UPDATE THE PERSONAL INFO OF THE USER
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveButton.setFocusable(false);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = "";
        String gender = "";

        boolean isEmpty = false;
        JTextField[] fields = {tFname, tLname, tMI, tAge, tHeight, tWeight, tCellp, tEmail, tFb, tReligion};
        JLabel[] labels = {fn, ln, mi, age, cm, lbs, cn, em, fb, rg};

        // Check if any of the fields are empty
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().isEmpty()) {
                labels[i].setForeground(Color.red);
                isEmpty = true;
            } else {
                labels[i].setForeground(Color.black);
            }
        }
        if (citizenshipBox.getSelectedIndex() == 0) {
            cs.setForeground(Color.red);
            isEmpty = true;
        } else {
            cs.setForeground(Color.black);
        }

        if (!rMale.isSelected() && !rFemale.isSelected()) {
            gen.setForeground(Color.red);
            isEmpty = true;
        } else {
            gen.setForeground(Color.black);
        }

        if (tBday.getDate() == null) {
            bd.setForeground(Color.red);
            isEmpty = true;
        } else {
            bd.setForeground(Color.black);
            date = dateFormat.format(tBday.getDate()); // Moved this line here
        }
        if (image == null) {
            labelPhoto.setForeground(Color.red);
            isEmpty = true;
        } else {
            labelPhoto.setForeground(Color.black);
        }
        if (isEmpty) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty");
        } else {
            try {
                String sql;
                // Check if record already exists
                sql = "SELECT * FROM personalinfo_table WHERE id = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(id));
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    // If record exists, update it
                    sql = "UPDATE personalinfo_table SET fname = ?, lname = ?, mname = ?, birthdate = ?, religion = ?, nationality = ?, gender = ?, age = ?, height = ?, weight = ?, cp = ?, fb = ?, email = ?, photo = ? WHERE id = ?";
                } else {
                    // If record doesn't exist, insert a new one
                    sql = "INSERT INTO personalinfo_table(fname, lname, mname, birthdate, religion, nationality, gender, age, height, weight, cp, fb, email, photo, id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                }
                try {
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, tFname.getText());
                    pstmt.setString(2, tLname.getText());
                    pstmt.setString(3, tMI.getText());
                    pstmt.setString(4, date);
                    pstmt.setString(5, tReligion.getText());
                    pstmt.setString(6, (String) citizenshipBox.getSelectedItem());
                    if (rMale.isSelected()) {
                        gender = "Male";
                    }
                    if (rFemale.isSelected()) {
                        gender = "Female";
                    }
                    pstmt.setString(7, gender);
                    pstmt.setString(8, tAge.getText());
                    pstmt.setString(9, tHeight.getText());
                    pstmt.setString(10, tWeight.getText());
                    pstmt.setString(11, tCellp.getText());
                    pstmt.setString(12, tFb.getText());
                    pstmt.setString(13, tEmail.getText());
                    pstmt.setBytes(14, image);
                    pstmt.setString(15, String.valueOf(id));
                    pstmt.execute();
                    JOptionPane.showMessageDialog(null, "Data saved successfully");
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    //FUNTION TO UPLOAD PHOTO
    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        String filename = null;
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File fp = chooser.getSelectedFile();
        filename = fp.getAbsolutePath();

        // Get the file size in KB
        long fileSizeInBytes = fp.length();
        long fileSizeInKB = fileSizeInBytes / 1024;

        // Check the file size
        if (fileSizeInKB > 43) {
            JOptionPane.showMessageDialog(null, "File size should not exceed 42 KB");
            return; // Stop further processing
        }

        ImageIcon imageicon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH));
        picture.setIcon(imageicon);

        try {
            File imageFile = new File(filename);
            FileInputStream fis = new FileInputStream(imageFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            image = bos.toByteArray();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_uploadButtonActionPerformed

    //FUNTION TO CLEAR TEXT FIELDS IN CHANGING PASSWORD
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        tOldPass.setText(null);
        tNewPass.setText(null);
        tConPass.setText(null);
    }//GEN-LAST:event_clearButtonActionPerformed

    //BUTTON IN CHANGING PASSWORD
    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        String oldpass = tOldPass.getText();
        String newpass = tNewPass.getText();
        String conpass = tConPass.getText();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM user_table WHERE username = '" + this.username + "' AND cpass = '" + oldpass + "'");
            String getOldPass = "";

            if (rs.next()) {
                getOldPass = rs.getString("cpass");
            }
            if (newpass.equals("") || conpass.equals("") || oldpass.equals("")) { // if password is null 
                JOptionPane.showMessageDialog((null), "Please fill out the blank fields. ", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (!newpass.equals(conpass)) { // if password not equals to confirm pass
                JOptionPane.showMessageDialog((null), "New password and confirm password do not match. ", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (!getOldPass.equals(oldpass)) {// if old password not equals to old password in database
                JOptionPane.showMessageDialog((null), "Old password is incorrect. ", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (newpass.length() < 8 || newpass.length() > 16) {
                JOptionPane.showMessageDialog(null, "Password must be 8 to 16 characters.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (!Pattern.compile("[!@#\\$%\\^&*()\\-_\\+=?]").matcher(newpass).find()) {
                JOptionPane.showMessageDialog(null, "Password must contain at least one special character", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (!Pattern.compile("[0-9]").matcher(newpass).find()) {
                JOptionPane.showMessageDialog(null, "Password must contain at least one digit", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (!Pattern.compile("[a-z].*[a-z]").matcher(newpass).find()) {
                JOptionPane.showMessageDialog(null, "Password must contain at least two lowercase letters", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (!Pattern.compile("[A-Z].*[A-Z]").matcher(newpass).find()) {
                JOptionPane.showMessageDialog(null, "Password must contain at least two uppercase letters", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                // Update the password in the database
                int result = st.executeUpdate("UPDATE user_table SET cpass = '" + newpass + "' WHERE username = '" + username + "'");
                if (result > 0) {
                    JOptionPane.showMessageDialog((null), "Password changed successfully. ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog((null), e);
        }
    }//GEN-LAST:event_changeButtonActionPerformed

    //ONLY ALLOW NUMBERS IN HEIGHT 
    private void tHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tHeightKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tHeightKeyTyped

    //ONLY ALLOW NUMBERS IN AGE 
    private void tAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tAgeKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tAgeKeyTyped

    //ONLY ALLOW NUMBERS IN WEIGHT 
    private void tWeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tWeightKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tWeightKeyTyped

    //ONLY ALLOW NUMBERS IN PHONE NUMBER 
    private void tCellpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCellpKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tCellpKeyTyped

    //FUNCTION TO SEND EMAIL 
    private void sendMessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessButtonActionPerformed
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("tuptest123@gmail.com", "zuje qjuf rdpz ekxt");
                }
            });

            Message mess = new MimeMessage(session);
            mess.setSubject(subjectText.getText());
            mess.setContent(messageText.getText(), "text/plain");
            mess.setFrom(new InternetAddress("tuptest123@gmail.com"));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(receiverUNameText.getText()));

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Part one is the text message
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(messageText.getText());
            multipart.addBodyPart(messageBodyPart);

            // Part two is the attachment
            messageBodyPart = new MimeBodyPart();
            if (selectedImagePath != null) {
                DataSource source = new FileDataSource(selectedImagePath);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(new File(selectedImagePath).getName());
                multipart.addBodyPart(messageBodyPart);
            }

            // Add the multipart message to the email
            mess.setContent(multipart);

            Transport.send(mess);
            JOptionPane.showMessageDialog(null, "Sent");

        } catch (HeadlessException | MessagingException e) {
            JOptionPane.showMessageDialog((null), e);
        }
    }//GEN-LAST:event_sendMessButtonActionPerformed

    //FUNCTION TO UPLOAD IMAGE
    private void imageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // Store the selected file path in the class-level variable
            selectedImagePath = selectedFile.getAbsolutePath();

            // Create an ImageIcon from the selected file
            ImageIcon imageIcon = new ImageIcon(selectedImagePath);

            // Create a new JFrame for image confirmation
            JFrame confirmFrame = new JFrame("Confirm Image");
            confirmFrame.setSize(300, 300);
            confirmFrame.setLocationRelativeTo(null);

            imageLabel.setIcon(imageIcon);
            confirmFrame.add(imageLabel, BorderLayout.CENTER);

            // Create a JPanel for the buttons
            JPanel buttonPanel = new JPanel();

            // Create the "Send" button
            JButton sendButton = new JButton("Send");
            sendButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code to send the image goes here
                    confirmFrame.dispose();
                }
            });
            buttonPanel.add(sendButton);

            // Create the "Cancel" button
            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code to cancel the send operation goes here
                    selectedImagePath = null;
                    confirmFrame.dispose();
                }
            });
            buttonPanel.add(cancelButton);

            confirmFrame.add(buttonPanel, BorderLayout.SOUTH);

            // Show the confirmation frame
            confirmFrame.setVisible(true);
        }
    }//GEN-LAST:event_imageButtonActionPerformed

    //FUNCTION TO VIEW IMAGE THAT HAS BEEN UPLOADED
    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        view.setFocusable(false);
        // Check if an image has been selected
        if (selectedImagePath != null) {
            // Create an ImageIcon from the selected file
            ImageIcon imageIcon = new ImageIcon(selectedImagePath);

            // Create a new JFrame for image viewing
            JFrame viewFrame = new JFrame("View Image");
            viewFrame.setSize(300, 300);
            viewFrame.setLocationRelativeTo(null);

            // Create a JLabel for displaying the image
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);
            viewFrame.add(imageLabel, BorderLayout.CENTER);

            // Show the view frame
            viewFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No image selected", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_viewActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JLabel bd;
    private javax.swing.JButton calendarButton;
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JButton changeButton;
    private javax.swing.JComboBox<String> citizenshipBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel cm;
    private javax.swing.JLabel cn;
    private javax.swing.JLabel cs;
    private javax.swing.JLabel current_username;
    private javax.swing.JLabel current_username1;
    private javax.swing.JLabel current_username2;
    private javax.swing.JLabel current_username3;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel em;
    private javax.swing.JLabel fb;
    private javax.swing.JLabel fn;
    private javax.swing.JLabel gen;
    private javax.swing.JButton imageButton;
    private javax.swing.JLabel imageLabel;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelPhoto;
    private javax.swing.JLabel lbs;
    private javax.swing.JLabel ln;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton messButton;
    private javax.swing.JPanel message;
    private javax.swing.JTextArea messageText;
    private javax.swing.JLabel mi;
    private javax.swing.JLabel name;
    private javax.swing.JButton passButton;
    private javax.swing.JPanel passPanel;
    private javax.swing.JLabel picture;
    private javax.swing.JButton profileButton;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JRadioButton rFemale;
    private javax.swing.JRadioButton rMale;
    private javax.swing.JTextField receiverUNameText;
    private javax.swing.JLabel rg;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton sendMessButton;
    private javax.swing.JTextField subjectText;
    private javax.swing.JTextField tAge;
    private com.toedter.calendar.JDateChooser tBday;
    private javax.swing.JTextField tCellp;
    private javax.swing.JTextField tConPass;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tFb;
    private javax.swing.JTextField tFname;
    private javax.swing.JTextField tHeight;
    private javax.swing.JTextField tLname;
    private javax.swing.JTextField tMI;
    private javax.swing.JTextField tNewPass;
    private javax.swing.JTextField tOldPass;
    private javax.swing.JTextField tReligion;
    private javax.swing.JTextField tWeight;
    private javax.swing.JButton uploadButton;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
