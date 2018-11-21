package Screens;

import Class.Dish;
import Class.Drink;
import Class.Ingredients;
import Class.Order;
import javax.swing.table.DefaultTableModel;
import static Screens.Login.cus;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static poo_project.POO_Project.listSalesCheck;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class wShoppingCart extends javax.swing.JFrame {

    DefaultTableModel model;

    /**
     * Creates new form wShoppingCart
     */
    public wShoppingCart() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/icon"
                + "Two.png")).getImage());
        this.setLocationRelativeTo(null);
        Object[] columnNames = {"Food/Drink/Ingredient", "Price"};
        String data[][] = {};
        model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);
        showFood();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setForeground(new java.awt.Color(255, 153, 102));

        jTable1.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Pay");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        deleteFood();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        makeSaleCheck();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(wShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(wShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(wShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(wShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wShoppingCart().setVisible(true);
            }
        });
    }

    public int price = 0;

    /**
     * Method to show the shoppingcart of the client
     */
    public void showFood() {
        cleanTable();
        price = 0;
        if (cus.getShoppingCart().size() >= 1) {
            jButton2.setEnabled(true);
        } else {
            jButton2.setEnabled(false);
        }

        for (int i = 0; i < cus.getShoppingCart().size(); i++) {
            String data[] = {cus.getShoppingCart().get(i).getName(), Integer.
                toString(cus.getShoppingCart().get(i).getPrice())};
            price += cus.getShoppingCart().get(i).getPrice();
            model.addRow(data);
        }
    }

    /**
     * Method to delete food from de shoppingcart
     */
    public void deleteFood() {
        try {
            int pos = jTable1.getSelectedRow();
            cus.getShoppingCart().remove(pos);
            showFood();
            JOptionPane.showMessageDialog(null, "Deleted Correctly");
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Select the thing that you want delete");
        }
    }

    /**
     * Method to clean the table
     */
    public void cleanTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int filas = jTable1.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }

    //Ordered, Asignned, Ready, Delivered
    public void makeSaleCheck() {
        Order tempO = new Order(listSalesCheck.size(), cus.getName(), price, date(), "Ordered");
        for (int i = 0; i < cus.getShoppingCart().size(); i++) {
            if (cus.getShoppingCart().get(i).getType() == "Dish") {
                tempO.getListDish().add((Dish) cus.getShoppingCart().get(i));
            } else if (cus.getShoppingCart().get(i).getType() == "Drink") {
                tempO.getListDrinks().add((Drink) cus.getShoppingCart().get(i));
            } else if (cus.getShoppingCart().get(i).getType() == "Ingredient") {
                tempO.getListExtra().add((Ingredients) cus.getShoppingCart().get(i));
            }
        }
        listSalesCheck.add(tempO);
        JOptionPane.showMessageDialog(null, "Order made it");
        cus.getShoppingCart().clear();
        showFood();
    }

    public String date() {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return hourdateFormat.format(date);
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
