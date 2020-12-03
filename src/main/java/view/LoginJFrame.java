package view;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Table;
import persistence.DBLoader;

public class LoginJFrame extends javax.swing.JFrame {

    private DBLoader db;
    private MainFrame mainFrame;
    private ArrayList<Table> tables;
    private boolean logged;

    public ArrayList<Table> getTables() {
        return tables;
    }

    public boolean isLogged() {
        return logged;
    }

    public LoginJFrame(MainFrame mainFrame) {
        db = new DBLoader();
        this.mainFrame = mainFrame;
        initComponents();
        imageJLabel.setIcon(new ImageIcon("images/mysqlLogo.png"));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordJPasswordField = new javax.swing.JPasswordField();
        userNameJTextField = new javax.swing.JTextField();
        userNameJLabel = new javax.swing.JLabel();
        passwordJLabel = new javax.swing.JLabel();
        connectJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        serverHostjLabel = new javax.swing.JLabel();
        dataBasejLabel = new javax.swing.JLabel();
        valueServerHostjLabel = new javax.swing.JLabel();
        valueDataBasejLabel = new javax.swing.JLabel();
        imageJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(461, 300));

        userNameJLabel.setText("Name");

        passwordJLabel.setText("Password");

        connectJButton.setText("Connect");
        connectJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectJButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        serverHostjLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        serverHostjLabel.setText("Server Host");

        dataBasejLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        dataBasejLabel.setText("Database");

        valueServerHostjLabel.setText("mozart.dis.ulpgc.es");

        valueDataBasejLabel.setText("DIU_BD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serverHostjLabel)
                    .addComponent(dataBasejLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(valueServerHostjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valueDataBasejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageJLabel))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverHostjLabel)
                    .addComponent(valueServerHostjLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataBasejLabel)
                    .addComponent(valueDataBasejLabel))
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(imageJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordJLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(connectJButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(passwordJPasswordField)
                        .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameJLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordJLabel))
                .addGap(18, 18, 18)
                .addComponent(connectJButton)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectJButtonActionPerformed
        String user = userNameJTextField.getText();
        char[] password = passwordJPasswordField.getPassword();
        //.equals("DIU-aed56-noi")
        if (!user.equals("estudiante-DIU") || !String.valueOf(password).equals("DIU-aed56-noi")) {
            JOptionPane.showMessageDialog(rootPane, "Incorrect user name or password");
        } else {
            try {
                tables = db.read(db.connect(user, password));
                logged = true;
                db.disconnect();
                JOptionPane.showMessageDialog(rootPane, "Login successful");
                dispose();
                mainFrame.dispose();
                new MainFrame(this).setVisible(true);
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(rootPane, "Could not stablish connection to the Data Base");
            }
        }
    }//GEN-LAST:event_connectJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectJButton;
    private javax.swing.JLabel dataBasejLabel;
    private javax.swing.JLabel imageJLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JLabel serverHostjLabel;
    private javax.swing.JLabel userNameJLabel;
    private javax.swing.JTextField userNameJTextField;
    private javax.swing.JLabel valueDataBasejLabel;
    private javax.swing.JLabel valueServerHostjLabel;
    // End of variables declaration//GEN-END:variables
}
