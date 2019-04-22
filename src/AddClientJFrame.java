import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class AddClientJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddClientJFrame
     */
    public AddClientJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        forenameJTextField = new javax.swing.JTextField();
        forenameJLabel = new javax.swing.JLabel();
        surnameJLabel = new javax.swing.JLabel();
        surnameJTextField = new javax.swing.JTextField();
        numberJLabel = new javax.swing.JLabel();
        numberJTextField = new javax.swing.JTextField();
        okJButton = new javax.swing.JButton();

        forenameJLabel.setText("Forename:");

        surnameJLabel.setText("Surname:");

        numberJLabel.setText("Number:");

        okJButton.setText("Ok");
        okJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okJButtonActionListener(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(forenameJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(forenameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surnameJLabel)
                            .addComponent(numberJLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surnameJTextField)
                            .addComponent(numberJTextField))))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okJButton)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forenameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forenameJLabel))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameJLabel)
                    .addComponent(surnameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numberJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(okJButton)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okJButtonActionListener(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okJButtonActionListener
        //Code for when press OK
        
        try
        {
         //Set up the connection
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hairbyhelen", "root", "***");
         Statement stmt = (Statement) con.createStatement();
         Class.forName("com.mysql.jdbc.Driver");
         
         //Result set for clients
         ResultSet clientRS = stmt.executeQuery("SELECT * FROM clients ORDER BY client_id");
         
         int greatestClientID = 0;
         
         while (clientRS.next())
         {
             int currentClientID = Integer.parseInt(clientRS.getString(5));
             if (currentClientID > greatestClientID)
                     {
                         greatestClientID = currentClientID;
                     }//if 
            
         }//while
         
         // Get the strings from the JTextFields
         String forename  = forenameJTextField.getText();
         String surname = surnameJTextField.getText();
         int number = Integer.parseInt(numberJTextField.getText());
         
         // query for MySQL
         String insert = "INSERT INTO clients VALUES ('" + forename + "'," +
                          "' " + surname + "', " +  + number + ", " + 0 + ", "
                          + (greatestClientID + 1) + ")";
         //execute MySQL instruction
         stmt.executeUpdate(insert);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }//catch
    }//GEN-LAST:event_okJButtonActionListener

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
            java.util.logging.Logger.getLogger(AddClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddClientJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forenameJLabel;
    private javax.swing.JTextField forenameJTextField;
    private javax.swing.JLabel numberJLabel;
    private javax.swing.JTextField numberJTextField;
    private javax.swing.JButton okJButton;
    private javax.swing.JLabel surnameJLabel;
    private javax.swing.JTextField surnameJTextField;
    // End of variables declaration//GEN-END:variables
}
