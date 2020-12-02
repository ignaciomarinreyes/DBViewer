package view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import model.Table;
import persistence.DBLoader;
import javax.swing.ListSelectionModel;

public class MainFrame extends javax.swing.JFrame {

    private ArrayList<Table> tables;
    private boolean logged;

    public MainFrame() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        simpleSelectionjToggleButton.setSelected(true);
        tablesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

        selectionButtonGroup = new javax.swing.ButtonGroup();
        jScrollPaneTableJList = new javax.swing.JScrollPane();
        tablesJList = new javax.swing.JList<>();
        jScrollPaneFieldsList = new javax.swing.JScrollPane();
        fieldsjList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        simpleSelectionjToggleButton = new javax.swing.JToggleButton();
        intervalSelectionjToggleButton = new javax.swing.JToggleButton();
        multipleSelectionjToggleButton = new javax.swing.JToggleButton();
        cleanSelectionjButton = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        connectJMenuItem = new javax.swing.JMenuItem();
        exitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablesJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tablesJListValueChanged(evt);
            }
        });
        jScrollPaneTableJList.setViewportView(tablesJList);

        jScrollPaneFieldsList.setViewportView(fieldsjList);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14))); // NOI18N

        selectionButtonGroup.add(simpleSelectionjToggleButton);
        simpleSelectionjToggleButton.setText("Simple");
        simpleSelectionjToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleSelectionjToggleButtonActionPerformed(evt);
            }
        });

        selectionButtonGroup.add(intervalSelectionjToggleButton);
        intervalSelectionjToggleButton.setText("Interval");
        intervalSelectionjToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intervalSelectionjToggleButtonActionPerformed(evt);
            }
        });

        selectionButtonGroup.add(multipleSelectionjToggleButton);
        multipleSelectionjToggleButton.setText("Multiple Interval");
        multipleSelectionjToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multipleSelectionjToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(multipleSelectionjToggleButton)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(simpleSelectionjToggleButton)
                    .addComponent(intervalSelectionjToggleButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(simpleSelectionjToggleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intervalSelectionjToggleButton)
                .addGap(12, 12, 12)
                .addComponent(multipleSelectionjToggleButton)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        cleanSelectionjButton.setText("Clean");
        cleanSelectionjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanSelectionjButtonActionPerformed(evt);
            }
        });

        fileJMenu.setMnemonic('f');
        fileJMenu.setText("File");

        connectJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        connectJMenuItem.setText("Connect");
        connectJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(connectJMenuItem);

        exitJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exitJMenuItem.setText("Exit");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        jMenuBar.add(fileJMenu);

        helpJMenu.setMnemonic('h');
        helpJMenu.setText("Help");

        aboutJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        jMenuBar.add(helpJMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneTableJList, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cleanSelectionjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneFieldsList, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTableJList, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cleanSelectionjButton))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPaneFieldsList, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectJMenuItemActionPerformed
        new LoginJFrame(this).setVisible(true);
    }//GEN-LAST:event_connectJMenuItemActionPerformed

    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJMenuItemActionPerformed
        int res = JOptionPane.showConfirmDialog(rootPane, "Are you sure you wanna exit?", "Exit", JOptionPane.YES_OPTION);
        if (res == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitJMenuItemActionPerformed

    private void tablesJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tablesJListValueChanged
        loadFieldsSelectedTables(tablesJList.getSelectedIndices());    
    }//GEN-LAST:event_tablesJListValueChanged

    private void simpleSelectionjToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleSelectionjToggleButtonActionPerformed
        tablesJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }//GEN-LAST:event_simpleSelectionjToggleButtonActionPerformed

    private void intervalSelectionjToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intervalSelectionjToggleButtonActionPerformed
        tablesJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }//GEN-LAST:event_intervalSelectionjToggleButtonActionPerformed

    private void multipleSelectionjToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multipleSelectionjToggleButtonActionPerformed
        tablesJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }//GEN-LAST:event_multipleSelectionjToggleButtonActionPerformed

    private void cleanSelectionjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanSelectionjButtonActionPerformed
        tablesJList.clearSelection();
    }//GEN-LAST:event_cleanSelectionjButtonActionPerformed

    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        JOptionPane.showMessageDialog(rootPane, "DBViewer is based on Swing from the Java Library."
                + "\nThe program shows all fields of selected database tables. "
                + "\nVersion 1.0 - GitHub information: https://github.com/jesuslarez/DBViewer");
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    private void setLookAndFeel() {
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
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JButton cleanSelectionjButton;
    private javax.swing.JMenuItem connectJMenuItem;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JList<String> fieldsjList;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JToggleButton intervalSelectionjToggleButton;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneFieldsList;
    private javax.swing.JScrollPane jScrollPaneTableJList;
    private javax.swing.JToggleButton multipleSelectionjToggleButton;
    private javax.swing.ButtonGroup selectionButtonGroup;
    private javax.swing.JToggleButton simpleSelectionjToggleButton;
    private javax.swing.JList<String> tablesJList;
    // End of variables declaration//GEN-END:variables

    public void loadTables() {
        DefaultListModel model = new DefaultListModel(); 
        for (Table table : tables) {
            model.addElement(table.getName());
        }
        tablesJList.setModel(model);
    }
    
    public void loadFieldsSelectedTables(int[] indexSelectedTables) {
        DefaultListModel model = new DefaultListModel();
        Table selectedTable = null;
        for (int index : indexSelectedTables) {
            selectedTable = tables.get(index);
            for(String fieldSelectedTable : selectedTable.getFields()){
                model.addElement(selectedTable.getName() + "." + fieldSelectedTable);
            }
        }
        fieldsjList.setModel(model);
    }
}
