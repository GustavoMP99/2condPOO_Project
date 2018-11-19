package Screens;

import Class.Categories;
import Class.Customer;
import Class.Dish;
import Class.Drink;
import Class.Food;
import Class.Ingredients;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static poo_project.POO_Project.listCategories;
import static poo_project.POO_Project.searchCategorie;
import static Screens.Login.cus;

/**
 *
 * @author Alvarado
 */
public class wCustomer extends javax.swing.JFrame {

    Customer customer;
    Food tempF;

    public wCustomer(Customer customer) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/iconTwo.png")).getImage());
        categoriesCB();
        jSpinner1.setValue(1);
    }
    public int x = 0;

    /**
     *
     */
    public void Exit() {
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }

    public int verCombo = 0;

    /**
     *
     */
    public void categoriesCB() {
        CBdish.removeAllItems();
        int i = 0;
        while (i < listCategories.size()) {
            CBdish.addItem(listCategories.get(i).getName());
            i++;
        }
    }

    /**
     *
     */
    public void ShowFood() {
        Categories temp = searchCategorie(CBdish.getSelectedItem().toString());

        if (CBfood.getSelectedItem().toString() == "Dishes") {
            if (temp.getListDish().isEmpty()) {
                CBfood.setSelectedIndex(verCombo);
            } else {
                Dish dish = temp.getListDish().get(x);
                verCombo = CBfood.getSelectedIndex();
                nameC.setText(dish.getName());
                codeC.setText(Integer.toString(dish.getCode()));
                ingredientsC.setText(dish.getIngredients());
                descriptionC.setText(dish.getDescription());
                presentationC.setText(dish.getPresentation());
                priceC.setText(Integer.toString(dish.getPrice()));
                tempF=dish;
                try {
                    ImageIcon ImgIcon = new ImageIcon(dish.getImage());
                    Icon icono = new ImageIcon(ImgIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
                    label.setIcon(icono);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex);
                }
            }
        } else if (CBfood.getSelectedItem().toString() == "Drinks") {
            if (temp.getListDrink().isEmpty()) {
                CBfood.setSelectedIndex(verCombo);
            } else {
                Drink drink = temp.getListDrink().get(x);
                verCombo = CBfood.getSelectedIndex();
                nameC.setText(drink.getName());
                codeC.setText(Integer.toString(drink.getCode()));
                ingredientsC.setText("Do not have comments");
                descriptionC.setText(drink.getDescription());
                presentationC.setText(drink.getPresentation());
                priceC.setText(Integer.toString(drink.getPrice()));
                tempF=drink;
                try {
                    ImageIcon ImgIcon = new ImageIcon(drink.getImage());
                    Icon icono = new ImageIcon(ImgIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
                    label.setIcon(icono);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex);
                }
            }
        } else if (CBfood.getSelectedItem().toString() == "Extra ingredients") {
            if (temp.getListIngredients().isEmpty()) {
                CBfood.setSelectedIndex(verCombo);
            } else {
                Ingredients ing = temp.getListIngredients().get(x);
                verCombo = CBfood.getSelectedIndex();
                nameC.setText(ing.getName());
                codeC.setText(Integer.toString(ing.getCode()));
                ingredientsC.setText("Do not have comments");
                descriptionC.setText(ing.getDescription());
                presentationC.setText(ing.getPresentation());
                priceC.setText(Integer.toString(ing.getPrice()));
                tempF=ing;
                try {
                    ImageIcon ImgIcon = new ImageIcon(ing.getImage());
                    Icon icono = new ImageIcon(ImgIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
                    label.setIcon(icono);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex);
                }
            }
        }

    }

    /**
     *
     */
    public void nextFood() {
        Categories temp = searchCategorie(CBdish.getSelectedItem().toString());
        if (CBfood.getSelectedItem().toString() == "Dishes") {
            if (x == temp.getListDish().size() - 1) {
                x = 0;
            } else {
                x = +1;
            }
        } else if (CBfood.getSelectedItem().toString() == "Drinks") {
            if (x == temp.getListDrink().size() - 1) {
                x = 0;
            } else {
                x = +1;
            }
        } else if (CBfood.getSelectedItem().toString() == "Extra ingredients") {
            if (x == temp.getListDrink().size() - 1) {
                x = 0;
            } else {
                x = +1;
            }
        }

        ShowFood();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CBdish = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        CBfood = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        nameC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ingredientsC = new javax.swing.JTextField();
        descriptionC = new javax.swing.JTextField();
        codeC = new javax.swing.JTextField();
        priceC = new javax.swing.JTextField();
        presentationC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        Exit = new javax.swing.JButton();
        Exit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Ink Free", 1, 21)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        CBdish.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdish.setForeground(new java.awt.Color(0, 0, 0));
        CBdish.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBdishItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Categories:");

        CBfood.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBfood.setForeground(new java.awt.Color(0, 0, 0));
        CBfood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dishes", "Drinks", "Extra ingredients" }));
        CBfood.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBfoodItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Type:");

        label.setBackground(new java.awt.Color(0, 0, 0));
        label.setForeground(new java.awt.Color(0, 0, 0));

        nameC.setEditable(false);
        nameC.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name:");

        jLabel6.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Code:");

        jLabel7.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingredients:");

        jLabel8.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Description:");

        jLabel9.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Presentation:");

        jLabel10.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Price:");

        ingredientsC.setEditable(false);
        ingredientsC.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        descriptionC.setEditable(false);
        descriptionC.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        codeC.setEditable(false);
        codeC.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        priceC.setEditable(false);
        priceC.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        presentationC.setEditable(false);
        presentationC.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        jButton1.setText("jButton1");

        jButton2.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSpinner1.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CBdish, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(270, 270, 270))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CBfood, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(codeC, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameC, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ingredientsC, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(descriptionC, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(presentationC, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(priceC, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(jButton3)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jButton2))
                        .addContainerGap(11, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBfood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(CBdish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nameC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(codeC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ingredientsC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descriptionC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(presentationC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(priceC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)))
                        .addComponent(jButton1))
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Make an order", jPanel2);

        Exit.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        Exit.setForeground(new java.awt.Color(0, 0, 0));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        Exit1.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        Exit1.setForeground(new java.awt.Color(0, 0, 0));
        Exit1.setText("Shopping cart");
        Exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        Exit();
    }//GEN-LAST:event_ExitActionPerformed

    private void CBfoodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBfoodItemStateChanged
        x = 0;
        ShowFood();
    }//GEN-LAST:event_CBfoodItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        nextFood();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CBdishItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBdishItemStateChanged
        x = 0;
        ShowFood();
    }//GEN-LAST:event_CBdishItemStateChanged

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        wShoppingCart nScreen = new wShoppingCart();
        nScreen.setVisible(true);
    }//GEN-LAST:event_Exit1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tempF!=null) {
            addFood();
            if ((int)jSpinner1.getValue()!=0) {
              JOptionPane.showMessageDialog(null, "Added correctly");  
            }
            
            jSpinner1.setValue(1);
        }
<<<<<<< Updated upstream
=======
                // TODO add your handling code here:
>>>>>>> Stashed changes
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Method to add food to the arrayList
     */
    public void addFood(){
    int acu= (int) jSpinner1.getValue();
    int in=0;
    while(in!=acu){
        cus.addFood(tempF);
        in++;
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBdish;
    private javax.swing.JComboBox<String> CBfood;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Exit1;
    private javax.swing.JTextField codeC;
    private javax.swing.JTextField descriptionC;
    private javax.swing.JTextField ingredientsC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField nameC;
    private javax.swing.JTextField presentationC;
    private javax.swing.JTextField priceC;
    // End of variables declaration//GEN-END:variables
}
