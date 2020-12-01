package view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import model.Table;
import persistence.DBLoader;

public class MainFrame extends javax.swing.JFrame {

    private ArrayList<Table> tables;
    private boolean logged; //Revisar

    
    // Hacer una clase Table que contenga el nombre de la tabla (String), y los campos (Array de Strings de Tamaño variable)
    // De esta forma cada objeto Table al ser seleccionado podemos acceder a sus campos facilmente
    
    // Hacer el modelo de la lista con una Matriz de Strings, es plan:
    /*  TABLA CAMPO CAMPO CAMPO
        TABLA CAMPO CAMPO
        TABLA CAMPO CAMPO CAMPO CAMPO CAMPO
        TABLA CAMPO CAMPO
     */
    // Hacer una clase para cada tabla seria algo muy exagerado
    public MainFrame() {
        initComponents();
        setLookAndFeel();       
    }

    public MainFrame(LoginJFrame loginFrame) {
        this();
        logged = loginFrame.isLogged();
        tables = loginFrame.getTables();
        
        if (logged) {
            loadTables();
        }
    }
    
    public void setLogged(boolean logged) {
        this.logged = logged;
    }
        
    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        tablesJList = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileJMenu = new javax.swing.JMenu();
        ConnectJMenuItem = new javax.swing.JMenuItem();
        ExitJMenuItem = new javax.swing.JMenuItem();
        HelpJMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane.setViewportView(tablesJList);

        jScrollPane1.setViewportView(jList1);

        FileJMenu.setMnemonic('f');
        FileJMenu.setText("File");

        ConnectJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        ConnectJMenuItem.setText("Connect");
        ConnectJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectJMenuItemActionPerformed(evt);
            }
        });
        FileJMenu.add(ConnectJMenuItem);

        ExitJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK));
        ExitJMenuItem.setText("Exit");
        FileJMenu.add(ExitJMenuItem);

        jMenuBar1.add(FileJMenu);

        HelpJMenu.setMnemonic('h');
        HelpJMenu.setText("Help");
        jMenuBar1.add(HelpJMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConnectJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectJMenuItemActionPerformed
        new LoginJFrame(this).setVisible(true);
    }//GEN-LAST:event_ConnectJMenuItemActionPerformed

    private void setLookAndFeel() {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ConnectJMenuItem;
    private javax.swing.JMenuItem ExitJMenuItem;
    private javax.swing.JMenu FileJMenu;
    private javax.swing.JMenu HelpJMenu;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> tablesJList;
    // End of variables declaration//GEN-END:variables

    public void loadTables() {
        DefaultListModel model = new DefaultListModel(); //todo
        for (Table table : tables) {
            model.addElement(table.getName());
        }
        tablesJList.setModel(model);
    }
}
