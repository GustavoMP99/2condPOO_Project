package Screens;

import Class.Administrator;
import static Class.Administrator.searchCategorie;
import Class.Categories;
import Class.Dish;
import Class.Drink;
import Class.Food;
import Class.Ingredients;
import java.awt.event.ItemEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static poo_project.POO_Project.listCategories;
import static poo_project.POO_Project.searchfood;
import static poo_project.POO_Project.ApplyDiscount;

/**
 * Screen of the administrator
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class Admi extends javax.swing.JFrame {

    Administrator admi;

    public Admi(Administrator admi) {
        this.admi = admi;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/iconTwo.png")).getImage());
        categoriesCB();
        ShowFood();
    }

    /**
     * Open window Login
     */
    public void Exit() {
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }

    /**
     * Open the search window Get image direction
     */
    public void settingSearcher() {
        File archivo;
        int result;
        Searcher Sch = new Searcher();
        FileNameExtensionFilter format = new FileNameExtensionFilter("JPG, PNG y GIF", "jpg", "png");
        Sch.search.setFileFilter(format);
        result = Sch.search.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == result) {
            archivo = Sch.search.getSelectedFile();
            fileDish.setText(archivo.getAbsolutePath());
            fileDishE.setText(archivo.getAbsolutePath());
            fileDrink.setText(archivo.getAbsolutePath());
            fileEI.setText(archivo.getAbsolutePath());
            fileDrinkE.setText(archivo.getAbsolutePath());
            fileExtra.setText(archivo.getAbsolutePath());
        }
    }

    /**
     * Create new categories
     */
    public void CreateCategories() {
        String nameCat = nameCategorie.getText();
        if (admi.addCategories(nameCat)) {
            JOptionPane.showMessageDialog(null, "Created Correctly");
        } else {
            JOptionPane.showMessageDialog(null, "That is already created");
        }
        nameCategorie.setText("");
    }

    /**
     * Fill the combobox with the available categories
     */
    public void categoriesCB() {
        CBdish.removeAllItems();
        CBdrink.removeAllItems();
        CBextraIng.removeAllItems();
        CBdishE.removeAllItems();
        CBdishD.removeAllItems();
        CBdrinkE.removeAllItems();
        CBdrinkD.removeAllItems();
        CBextraInD.removeAllItems();
        CBextraInE.removeAllItems();
        CBdeleteC.removeAllItems();
        CBdiscounts.removeAllItems();
        int i = 0;
        while (i < listCategories.size()) {
            CBdish.addItem(listCategories.get(i).getName());
            CBdrink.addItem(listCategories.get(i).getName());
            CBextraIng.addItem(listCategories.get(i).getName());
            CBdishE.addItem(listCategories.get(i).getName());
            CBdishD.addItem(listCategories.get(i).getName());
            CBdrinkE.addItem(listCategories.get(i).getName());
            CBdrinkD.addItem(listCategories.get(i).getName());
            CBextraInD.addItem(listCategories.get(i).getName());
            CBextraInE.addItem(listCategories.get(i).getName());
            CBdeleteC.addItem(listCategories.get(i).getName());
            CBdiscounts.addItem(listCategories.get(i).getName());
            i++;
        }
    }

    /**
     * Create new ingredient extra
     */
    public void CreateIngredientExtra() {
        int code = (Integer) codeEI.getValue();
        String name = nameEI.getText();
        String description = descriptionEI.getText();
        String presentation = presentationEI.getText();
        String categories = CBextraIng.getSelectedItem().toString();
        int price = (Integer) priceEI.getValue();
        String file = fileEI.getText();

        if (admi.addIngredientExtra(code, name, description, price, presentation, file, categories)) {
            JOptionPane.showMessageDialog(null, "Created Correctly");
        } else {
            JOptionPane.showMessageDialog(null, "That is already created");
        }
        codeEI.setValue(0);
        nameEI.setText("");
        descriptionEI.setText("");
        priceEI.setValue(0);
        fileDish.setText("");
        fileDrink.setText("");
        fileEI.setText("");
    }

    /**
     * Create new dish
     */
    public void CreateDish() {
        int code = (Integer) codeDish.getValue();
        String name = nameDish.getText();
        String ingredients = ingredientsDish.getText();
        String description = descriptionDish.getText();
        String presentation = presentationDish.getSelectedItem().toString();
        String categories = CBdish.getSelectedItem().toString();
        int price = (Integer) priceDish.getValue();
        String file = fileDish.getText();

        if (admi.addDish(code, name, description, price, presentation, file, ingredients, categories)) {
            JOptionPane.showMessageDialog(null, "Created Correctly");
        } else {
            JOptionPane.showMessageDialog(null, "That is already created");
        }

        codeDish.setValue(0);
        nameDish.setText("");
        ingredientsDish.setText("");
        descriptionDish.setText("");
        priceDish.setValue(0);
        fileDish.setText("");
        fileDrink.setText("");
        fileEI.setText("");
    }

    /**
     * Create new drinks
     */
    public void CreateDrink() {
        int code = (Integer) codeDr.getValue();
        String name = nameDr.getText();
        String description = descriptionDr.getText();
        String presentation = presentationDr.getSelectedItem().toString();
        String categories = CBdrink.getSelectedItem().toString();
        int price = (Integer) priceDr.getValue();
        String file = fileDrink.getText();

        if (admi.addDrink(code, name, description, price, presentation, file, categories)) {
            JOptionPane.showMessageDialog(null, "Created Correctly");
        } else {
            JOptionPane.showMessageDialog(null, "That is already created");
        }
        codeDr.setValue(0);
        nameDr.setText("");
        descriptionDr.setText("");
        priceDr.setValue(0);
        fileDish.setText("");
        fileDrink.setText("");
        fileEI.setText("");

    }

    /**
     * Fill the combobox with the available dishes
     */
    public void CBdish() {
        CBdishesE.removeAllItems();
        Categories tempC = searchCategorie(CBdishE.getSelectedItem().toString());
        if (tempC != null) {
            int i = 0;
            while (i < tempC.getListDish().size()) {
                CBdishesE.addItem(Integer.toString(tempC.getListDish().get(i).getCode()));
                i++;
            }
        }

    }

    /**
     * Fill the combobox with the available dishes
     */
    public void CBdish2() {
        CBdishesD.removeAllItems();
        Categories tempC = searchCategorie(CBdishD.getSelectedItem().toString());
        int i = 0;
        while (i < tempC.getListDish().size()) {
            CBdishesD.addItem(Integer.toString(tempC.getListDish().get(i).getCode()) + "-" + tempC.getListDish().get(i).getName());
            i++;
        }
    }

    /**
     * Show the data of the dishes to be edited
     */
    public void showEditDish() {
        Categories tempC = searchCategorie(CBdishE.getSelectedItem().toString());
        if (tempC != null) {
            if (tempC.getListDish() != null) {
                if (CBdishesE.getComponentCount() >= 1) {
                    Dish dish = tempC.searchDish(Integer.parseInt((String) CBdishesE.getSelectedItem()));
                    nameDishE.setText(dish.getName());
                    codeDishE.setText(Integer.toString(dish.getCode()));
                    ingredientsDishE.setText(dish.getIngredients());
                    descriptionDishE.setText(dish.getDescription());
                    priceDishE.setValue(dish.getPrice());
                    fileDishE.setText(dish.getImage());
                }
            }

        }

    }

    /**
     * Modify the data of the dishes
     */
    public void ChangeDish() {
        Categories tempC = searchCategorie(CBdishE.getSelectedItem().toString());
        String name = nameDishE.getText();
        int code = Integer.parseInt(codeDishE.getText());
        String ingredients = ingredientsDishE.getText();
        String descrition = descriptionDishE.getText();
        int price = Integer.parseInt(priceDishE.getValue().toString());
        String image = fileDishE.getText();
        String presentation = presentationDishE.getSelectedItem().toString();
        admi.EditDish(code, name, descrition, price, presentation, image, ingredients, tempC.getName());
        JOptionPane.showMessageDialog(null, "Modified correctly");
    }

    /**
     * Removes saucers of the chosen category
     */
    public void DeleteDish() {
        Categories tempC = searchCategorie(CBdishD.getSelectedItem().toString());
        String code = CBdishesD.getSelectedItem().toString();
        String[] parts = code.split("-");
        Dish dish = tempC.searchDish(Integer.parseInt(parts[0]));
        tempC.getListDish().remove(dish);
        JOptionPane.showMessageDialog(null, "Correctly removed");
        CBdish2();
        CBdish();
    }

    /**
     * Fill the combobox with the available drinks
     */
    public void CBDrink() {
        CBdrinksE.removeAllItems();
        Categories tempC = searchCategorie(CBdrinkE.getSelectedItem().toString());
        int i = 0;
        while (i < tempC.getListDrink().size()) {
            CBdrinksE.addItem(Integer.toString(tempC.getListDrink().get(i).getCode()));
            i++;
        }
    }

    /**
     * Fill the combobox with the available drinks
     */
    public void CBDrink2() {
        CBdrinksD.removeAllItems();
        Categories tempC = searchCategorie(CBdrinkD.getSelectedItem().toString());
        int i = 0;
        while (i < tempC.getListDrink().size()) {
            CBdrinksD.addItem(Integer.toString(tempC.getListDrink().get(i).getCode()) + "-" + tempC.getListDrink().get(i).getName());
            i++;
        }
    }

    /**
     * Show the data of the drinks to be edited
     */
    public void showEditDrink() {
        Categories tempC = searchCategorie(CBdrinkE.getSelectedItem().toString());
        Drink dish = tempC.searchDrink(Integer.parseInt(CBdrinksE.getSelectedItem().toString()));
        nameDrinkE.setText(dish.getName());
        codeDrinkE.setText(Integer.toString(dish.getCode()));
        descriptionDrinkE.setText(dish.getDescription());
        priceDrinkE.setValue(dish.getPrice());
        fileDrinkE.setText(dish.getImage());
    }

    /**
     * Modify the data of the drinks
     */
    public void ChangeDrink() {
        Categories tempC = searchCategorie(CBdrinkE.getSelectedItem().toString());
        String name = nameDrinkE.getText();
        int code = Integer.parseInt(codeDrinkE.getText());
        String descrition = descriptionDrinkE.getText();
        int price = Integer.parseInt(priceDrinkE.getValue().toString());
        String image = fileDrinkE.getText();
        String presentation = presentationDrinkE.getSelectedItem().toString();
        admi.EditDrink(code, name, descrition, price, presentation, image, tempC.getName());
        JOptionPane.showMessageDialog(null, "Modified correctly");

    }

    /**
     * Removes drinks of the chosen category
     */
    public void DeleteDrink() {
        Categories tempC = searchCategorie(CBdrinkD.getSelectedItem().toString());
        String code = CBdrinksD.getSelectedItem().toString();
        String[] parts = code.split("-");
        Drink drink = tempC.searchDrink(Integer.parseInt(parts[0]));
        tempC.getListDrink().remove(drink);
        JOptionPane.showMessageDialog(null, "Correctly removed");
        CBDrink2();
        CBDrink();
    }

    /**
     * Fill the combobox with the available ingredients
     */
    public void CBIngredient() {
        CBextraIngE.removeAllItems();
        Categories tempC = searchCategorie(CBextraInE.getSelectedItem().toString());
        int i = 0;
        while (i < tempC.getListIngredients().size()) {
            CBextraIngE.addItem(Integer.toString(tempC.getListIngredients().get(i).getCode()));
            i++;
        }
    }

    /**
     * Fill the combobox with the available ingredients
     */
    public void CBIngredient2() {
        CBextraIng2.removeAllItems();
        Categories tempC = searchCategorie(CBextraInD.getSelectedItem().toString());
        int i = 0;
        while (i < tempC.getListIngredients().size()) {
            CBextraIng2.addItem((tempC.getListIngredients().get(i).getCode()) + "-" + tempC.getListIngredients().get(i).getName());
            i++;
        }
    }

    /**
     * Show the data of the ingredients to be edited
     */
    public void showEditIngredient() {
        Categories tempC = searchCategorie(CBextraInE.getSelectedItem().toString());
        Ingredients ingre = tempC.searchIngredient(Integer.parseInt(CBextraIngE.getSelectedItem().toString()));
        nameExtra.setText(ingre.getName());
        codeExtra.setText(Integer.toString(ingre.getCode()));
        descriptionExtra.setText(ingre.getDescription());
        priceExtra.setValue(ingre.getPrice());
        fileExtra.setText(ingre.getImage());
    }

    /**
     * Modify the data of the ingredients
     */
    public void ChangeIngredient() {
        Categories tempC = searchCategorie(CBextraInE.getSelectedItem().toString());
        String name = nameExtra.getText();
        int code = Integer.parseInt(codeExtra.getText());
        String descrition = descriptionExtra.getText();
        int price = Integer.parseInt(priceExtra.getValue().toString());
        String image = fileExtra.getText();
        String presentation = presentationExtra.getSelectedItem().toString();
        admi.EditIngredient(code, name, descrition, price, presentation, image, tempC.getName());
        JOptionPane.showMessageDialog(null, "Modified correctly");
    }

    /**
     * Removes saucers of the chosen category
     */
    public void DeleteIngredient() {
        Categories tempC = searchCategorie(CBextraInD.getSelectedItem().toString());
        String code = CBextraIng2.getSelectedItem().toString();
        String[] parts = code.split("-");
        Ingredients ingre = tempC.searchIngredient(Integer.parseInt(parts[0]));
        tempC.getListIngredients().remove(ingre);
        JOptionPane.showMessageDialog(null, "Correctly removed");
        CBIngredient2();
        CBIngredient();
    }

    /**
     * Remove the categories
     */
    public void DeleteCategorie() {
        Categories tempC = searchCategorie(CBdeleteC.getSelectedItem().toString());
        listCategories.remove(tempC);
        JOptionPane.showMessageDialog(null, "Correctly removed");
    }

    /**
     * The combo box returns to the first element
     */
    public int verCombo = 0;

    /**
     * Fill in the discount combobox information
     */
    public void ShowFood() {
        Categories temp = searchCategorie(CBdiscounts.getSelectedItem().toString());
        CBavailable.removeAllItems();
        if (null != CBfood.getSelectedItem().toString()) {
            switch (CBfood.getSelectedItem().toString()) {
                case "Dishes":
                    if (temp.getListDish().isEmpty()) {
                        CBfood.setSelectedIndex(verCombo);
                    } else {
                        int i = 0;
                        while (i < temp.getListDish().size()) {
                            CBavailable.addItem(Integer.toString(temp.getListDish().get(i).getCode()) + "-" + temp.getListDish().get(i).getName());
                            i++;
                        }
                    }
                    break;
                case "Drinks":
                    if (temp.getListDrink().isEmpty()) {
                        CBfood.setSelectedIndex(verCombo);
                    } else {
                        int i = 0;
                        while (i < temp.getListDrink().size()) {
                            CBavailable.addItem(Integer.toString(temp.getListDrink().get(i).getCode()) + "-" + temp.getListDrink().get(i).getName());
                            i++;
                        }
                    }
                    break;
                case "Extra ingredients":
                    if (temp.getListIngredients().isEmpty()) {
                        CBfood.setSelectedIndex(verCombo);
                    } else {
                        int i = 0;
                        while (i < temp.getListIngredients().size()) {
                            CBavailable.addItem(Integer.toString(temp.getListIngredients().get(i).getCode()) + "-" + temp.getListIngredients().get(i).getName());
                            i++;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

    }
    
    public void TimeDiscount(){
         String tempF= (String) CBavailable.getSelectedItem();
        String[] food= tempF.split("-");
        Food tempF1= searchfood(Integer.parseInt(food[0]));
        String h= hora.getText();
        tempF1.setTimer(h, tempF1);
        float disco= Integer.parseInt(discount.getValue().toString());
        ApplyDiscount(tempF1, disco);
        
        JOptionPane.showMessageDialog(null, "The discount was applied for "+ h);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nameDish = new javax.swing.JTextField();
        codeDish = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        ingredientsDish = new javax.swing.JTextField();
        fileDish = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        presentationDish = new javax.swing.JComboBox<>();
        CBdish = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        priceDish = new javax.swing.JSpinner();
        jLabel28 = new javax.swing.JLabel();
        CreateDish = new javax.swing.JButton();
        selectImage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        descriptionDish = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        CBdishE = new javax.swing.JComboBox<>();
        CBdishesE = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        codeDishE = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        ingredientsDishE = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        descriptionDishE = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        presentationDishE = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        priceDishE = new javax.swing.JSpinner();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        fileDishE = new javax.swing.JTextField();
        nameDishE = new javax.swing.JTextField();
        CreateDish3 = new javax.swing.JButton();
        selectImage1 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        CBdishD = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        CBdishesD = new javax.swing.JComboBox<>();
        deleteDish = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        nameDr = new javax.swing.JTextField();
        descriptionDr = new javax.swing.JTextField();
        codeDr = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        priceDr = new javax.swing.JSpinner();
        presentationDr = new javax.swing.JComboBox<>();
        CBdrink = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        fileDrink = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        selectImageDrink = new javax.swing.JButton();
        CreateDish1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        fileDrinkE = new javax.swing.JTextField();
        priceDrinkE = new javax.swing.JSpinner();
        jLabel58 = new javax.swing.JLabel();
        presentationDrinkE = new javax.swing.JComboBox<>();
        descriptionDrinkE = new javax.swing.JTextField();
        codeDrinkE = new javax.swing.JTextField();
        nameDrinkE = new javax.swing.JTextField();
        CBdrinksE = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        CBdrinkE = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        selectImageDE = new javax.swing.JButton();
        modifyDE = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        CBdrinkD = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        CBdrinksD = new javax.swing.JComboBox<>();
        deleteDrink = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        nameEI = new javax.swing.JTextField();
        presentationEI = new javax.swing.JTextField();
        codeEI = new javax.swing.JSpinner();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        priceEI = new javax.swing.JSpinner();
        CBextraIng = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        descriptionEI = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        fileEI = new javax.swing.JTextField();
        selectImageDrink1 = new javax.swing.JButton();
        CreateIngredient = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        fileExtra = new javax.swing.JTextField();
        priceExtra = new javax.swing.JSpinner();
        jLabel68 = new javax.swing.JLabel();
        presentationExtra = new javax.swing.JComboBox<>();
        descriptionExtra = new javax.swing.JTextField();
        codeExtra = new javax.swing.JTextField();
        nameExtra = new javax.swing.JTextField();
        CBextraIngE = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        CBextraInE = new javax.swing.JComboBox<>();
        jLabel70 = new javax.swing.JLabel();
        selectImageEE = new javax.swing.JButton();
        modifyEE = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        CBextraInD = new javax.swing.JComboBox<>();
        jLabel74 = new javax.swing.JLabel();
        CBextraIng2 = new javax.swing.JComboBox<>();
        deleteIngre = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameCategorie = new javax.swing.JTextField();
        createCategorie = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        CBdeleteC = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        deleteCategorie = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        CBavailable = new javax.swing.JComboBox<>();
        CBdiscounts = new javax.swing.JComboBox<>();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CBfood = new javax.swing.JComboBox<>();
        discount = new javax.swing.JSpinner();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        hora = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        jTabbedPane1.setBackground(new java.awt.Color(255, 153, 102));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Ink Free", 1, 21)); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 153, 102));

        jTabbedPane4.setBackground(new java.awt.Color(255, 153, 102));
        jTabbedPane4.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane4.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jPanel12.setBackground(new java.awt.Color(255, 153, 102));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        nameDish.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        codeDish.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Code:");

        jLabel21.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Name:");

        jLabel22.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Ingredients:");

        ingredientsDish.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        fileDish.setEditable(false);
        fileDish.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Description:");

        jLabel24.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Presentation:");

        presentationDish.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        presentationDish.setForeground(new java.awt.Color(0, 0, 0));
        presentationDish.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Starter", "Medium", "Big", "Family" }));

        CBdish.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdish.setForeground(new java.awt.Color(0, 0, 0));

        jLabel25.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Categories:");

        jLabel26.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Price:");

        priceDish.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("₡");

        CreateDish.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        CreateDish.setForeground(new java.awt.Color(0, 0, 0));
        CreateDish.setText("Create dish");
        CreateDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateDishActionPerformed(evt);
            }
        });

        selectImage.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        selectImage.setForeground(new java.awt.Color(0, 0, 0));
        selectImage.setText("Select image");
        selectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("File:");

        descriptionDish.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel26)
                            .addComponent(jLabel1))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fileDish)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addComponent(jLabel28)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(priceDish, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(CBdish, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 270, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(ingredientsDish, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selectImage)
                                .addGap(100, 100, 100))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codeDish, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameDish, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(presentationDish, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descriptionDish, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CreateDish, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(nameDish, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(codeDish, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(ingredientsDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(descriptionDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(presentationDish, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateDish, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(CBdish, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(priceDish, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fileDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Create", jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 153, 102));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        CBdishE.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdishE.setForeground(new java.awt.Color(0, 0, 0));
        CBdishE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBdishEItemStateChanged(evt);
            }
        });

        CBdishesE.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdishesE.setForeground(new java.awt.Color(0, 0, 0));
        CBdishesE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBdishesEItemStateChanged(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Categorie:");

        jLabel40.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Available:");

        jLabel41.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Name:");

        codeDishE.setEditable(false);
        codeDishE.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        jLabel42.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Code:");

        jLabel43.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Ingredients:");

        ingredientsDishE.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Description:");

        descriptionDishE.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Presentation:");

        presentationDishE.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        presentationDishE.setForeground(new java.awt.Color(0, 0, 0));
        presentationDishE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Starter", "Medium", "Big", "Family" }));

        jLabel46.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Price:");

        priceDishE.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jLabel47.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("₡");

        jLabel48.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("File:");

        fileDishE.setEditable(false);
        fileDishE.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        nameDishE.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        CreateDish3.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        CreateDish3.setForeground(new java.awt.Color(0, 0, 0));
        CreateDish3.setText("Modify");
        CreateDish3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateDish3ActionPerformed(evt);
            }
        });

        selectImage1.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        selectImage1.setForeground(new java.awt.Color(0, 0, 0));
        selectImage1.setText("Select new image");
        selectImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImage1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(70, 70, 70)
                        .addComponent(fileDishE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(CBdishE, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(CBdishesE, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel42)
                            .addComponent(jLabel46))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceDishE, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(presentationDishE, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nameDishE, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                        .addComponent(ingredientsDishE)
                                        .addComponent(descriptionDishE)
                                        .addComponent(codeDishE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CreateDish3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selectImage1))
                                .addGap(51, 51, 51))))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBdishE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(CBdishesE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(nameDishE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeDishE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(selectImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(ingredientsDishE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descriptionDishE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CreateDish3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presentationDishE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(priceDishE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fileDishE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addGap(21, 21, 21))))
        );

        jTabbedPane4.addTab("Edit", jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 153, 102));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        jLabel49.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Categorie:");

        CBdishD.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdishD.setForeground(new java.awt.Color(0, 0, 0));
        CBdishD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBdishDItemStateChanged(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Available:");

        CBdishesD.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdishesD.setForeground(new java.awt.Color(0, 0, 0));

        deleteDish.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        deleteDish.setForeground(new java.awt.Color(0, 0, 0));
        deleteDish.setText("Delete");
        deleteDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel49)
                .addGap(18, 18, 18)
                .addComponent(CBdishD, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addComponent(CBdishesD, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(deleteDish, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(322, 322, 322))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBdishD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(CBdishesD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addGap(127, 127, 127)
                .addComponent(deleteDish)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Delete", jPanel14);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dish", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 153, 102));

        jTabbedPane3.setBackground(new java.awt.Color(255, 153, 102));
        jTabbedPane3.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane3.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 153, 102));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Code:");

        jLabel15.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Name:");

        jLabel16.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Description:");

        jLabel17.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Price:");

        nameDr.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        descriptionDr.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        codeDr.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Presentation:");

        jLabel19.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Categories:");

        priceDr.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        presentationDr.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        presentationDr.setForeground(new java.awt.Color(0, 0, 0));
        presentationDr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Starter", "Medium", "Big", "Family" }));

        CBdrink.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdrink.setForeground(new java.awt.Color(0, 0, 0));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("₡");

        fileDrink.setEditable(false);
        fileDrink.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("File:");

        selectImageDrink.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        selectImageDrink.setForeground(new java.awt.Color(0, 0, 0));
        selectImageDrink.setText("Select image");
        selectImageDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageDrinkActionPerformed(evt);
            }
        });

        CreateDish1.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        CreateDish1.setForeground(new java.awt.Color(0, 0, 0));
        CreateDish1.setText("Create drink");
        CreateDish1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateDish1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addComponent(jLabel27)
                                        .addGap(6, 6, 6)
                                        .addComponent(priceDr, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(fileDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                        .addComponent(jLabel8))))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(127, 127, 127)
                                .addComponent(nameDr, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(78, 78, 78)
                                .addComponent(descriptionDr, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(62, 62, 62)
                                .addComponent(presentationDr, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(82, 82, 82)
                                .addComponent(CBdrink, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(137, 137, 137)
                                .addComponent(codeDr, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CreateDish1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectImageDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel15))
                    .addComponent(nameDr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(codeDr, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel16))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(descriptionDr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel18))
                            .addComponent(presentationDr, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel19))
                            .addComponent(CBdrink, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel17)
                                .addGap(43, 127, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(priceDr, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fileDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addContainerGap())))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(selectImageDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(CreateDish1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane3.addTab("Create", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 153, 102));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        jLabel51.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Name:");

        jLabel52.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Code:");

        jLabel54.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Description:");

        jLabel55.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Presentation:");

        jLabel56.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Price:");

        jLabel57.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("File:");

        fileDrinkE.setEditable(false);
        fileDrinkE.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        priceDrinkE.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jLabel58.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("₡");

        presentationDrinkE.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        presentationDrinkE.setForeground(new java.awt.Color(0, 0, 0));
        presentationDrinkE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Starter", "Medium", "Big", "Family" }));

        descriptionDrinkE.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        codeDrinkE.setEditable(false);
        codeDrinkE.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        nameDrinkE.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        CBdrinksE.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdrinksE.setForeground(new java.awt.Color(0, 0, 0));
        CBdrinksE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBdrinksEItemStateChanged(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Available:");

        CBdrinkE.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdrinkE.setForeground(new java.awt.Color(0, 0, 0));
        CBdrinkE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBdrinkEItemStateChanged(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Categorie:");

        selectImageDE.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        selectImageDE.setForeground(new java.awt.Color(0, 0, 0));
        selectImageDE.setText("Select new image");
        selectImageDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageDEActionPerformed(evt);
            }
        });

        modifyDE.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        modifyDE.setForeground(new java.awt.Color(0, 0, 0));
        modifyDE.setText("Modify");
        modifyDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyDEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addGap(73, 73, 73)
                                .addComponent(fileDrinkE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel9))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addGap(134, 134, 134)
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(priceDrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CBdrinksE, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel55)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(presentationDrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel54)
                                        .addGap(83, 83, 83)
                                        .addComponent(descriptionDrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                                .addComponent(modifyDE, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel60)
                            .addGap(18, 18, 18)
                            .addComponent(CBdrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(261, 472, Short.MAX_VALUE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel51)
                                .addComponent(jLabel52))
                            .addGap(127, 127, 127)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameDrinkE, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                .addComponent(codeDrinkE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectImageDE)))
                    .addGap(49, 49, 49)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBdrinksE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addGap(136, 136, 136)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionDrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(presentationDrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(modifyDE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceDrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel56))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel9))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fileDrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))))
                .addContainerGap())
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CBdrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel60))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel51)
                        .addComponent(nameDrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectImageDE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codeDrinkE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel52))
                    .addContainerGap(363, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("Edit", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 153, 102));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        jLabel71.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Categorie:");

        CBdrinkD.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdrinkD.setForeground(new java.awt.Color(0, 0, 0));
        CBdrinkD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBdrinkDItemStateChanged(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Available:");

        CBdrinksD.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdrinksD.setForeground(new java.awt.Color(0, 0, 0));

        deleteDrink.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        deleteDrink.setForeground(new java.awt.Color(0, 0, 0));
        deleteDrink.setText("Delete");
        deleteDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDrinkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(deleteDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addGap(18, 18, 18)
                        .addComponent(CBdrinksD, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel71)
                    .addGap(18, 18, 18)
                    .addComponent(CBdrinkD, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(538, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(CBdrinksD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138)
                .addComponent(deleteDrink)
                .addGap(48, 48, 48)
                .addComponent(jLabel10)
                .addContainerGap())
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(153, 153, 153)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CBdrinkD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel71))
                    .addContainerGap(349, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("Delete", jPanel11);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Drink", jPanel4);

        jPanel18.setBackground(new java.awt.Color(255, 153, 102));

        jTabbedPane6.setBackground(new java.awt.Color(255, 153, 102));
        jTabbedPane6.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane6.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jPanel19.setBackground(new java.awt.Color(255, 153, 102));

        jLabel29.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Code:");

        jLabel30.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Name:");

        jLabel31.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Description:");

        jLabel32.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Price:");

        nameEI.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        presentationEI.setEditable(false);
        presentationEI.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N
        presentationEI.setForeground(new java.awt.Color(0, 0, 0));
        presentationEI.setText("Additional ingredients");

        codeEI.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Presentation:");

        jLabel34.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Categories:");

        priceEI.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        CBextraIng.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBextraIng.setForeground(new java.awt.Color(0, 0, 0));

        jLabel35.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("₡");

        descriptionEI.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("File:");

        fileEI.setEditable(false);
        fileEI.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        selectImageDrink1.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        selectImageDrink1.setForeground(new java.awt.Color(0, 0, 0));
        selectImageDrink1.setText("Select image");
        selectImageDrink1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageDrink1ActionPerformed(evt);
            }
        });

        CreateIngredient.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        CreateIngredient.setForeground(new java.awt.Color(0, 0, 0));
        CreateIngredient.setText("Create");
        CreateIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateIngredientActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel32))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codeEI, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameEI, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 396, Short.MAX_VALUE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceEI, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addContainerGap())
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CBextraIng, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(presentationEI, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descriptionEI, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectImageDrink1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CreateIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(107, 107, 107))))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fileEI, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(nameEI, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(codeEI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(descriptionEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(presentationEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBextraIng, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(36, 36, 36)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceEI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(26, 26, 26))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(selectImageDrink1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(CreateIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Create", jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 153, 102));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        jLabel61.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Name:");

        jLabel62.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Code:");

        jLabel64.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Description:");

        jLabel65.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Presentation:");

        jLabel66.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Price:");

        jLabel67.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("File:");

        fileExtra.setEditable(false);
        fileExtra.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        priceExtra.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jLabel68.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("₡");

        presentationExtra.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        presentationExtra.setForeground(new java.awt.Color(0, 0, 0));
        presentationExtra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Starter", "Medium", "Big", "Family" }));

        descriptionExtra.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        codeExtra.setEditable(false);
        codeExtra.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        nameExtra.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        CBextraIngE.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBextraIngE.setForeground(new java.awt.Color(0, 0, 0));
        CBextraIngE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBextraIngEItemStateChanged(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Available:");

        CBextraInE.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBextraInE.setForeground(new java.awt.Color(0, 0, 0));
        CBextraInE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBextraInEItemStateChanged(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Categorie:");

        selectImageEE.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        selectImageEE.setForeground(new java.awt.Color(0, 0, 0));
        selectImageEE.setText("Select new image");
        selectImageEE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageEEActionPerformed(evt);
            }
        });

        modifyEE.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        modifyEE.setForeground(new java.awt.Color(0, 0, 0));
        modifyEE.setText("Modify");
        modifyEE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyEEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jLabel65)
                            .addComponent(jLabel62)
                            .addComponent(jLabel61))
                        .addGap(102, 102, 102)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(presentationExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(codeExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 335, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addGap(92, 92, 92)
                        .addComponent(fileExtra)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel36)
                        .addContainerGap())
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel69))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addGap(118, 118, 118)
                                .addComponent(descriptionExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(75, 75, 75)
                        .addComponent(modifyEE, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addComponent(jLabel70)
                            .addGap(18, 18, 18)
                            .addComponent(CBextraInE, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                            .addComponent(CBextraIngE, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10))
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(selectImageEE)))
                    .addGap(47, 47, 47)))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel69)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61))
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel64))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(codeExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel62))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(descriptionExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(presentationExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68)
                            .addComponent(jLabel66))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modifyEE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fileExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addContainerGap())))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CBextraInE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel70)
                        .addComponent(CBextraIngE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(68, 68, 68)
                    .addComponent(selectImageEE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(367, Short.MAX_VALUE)))
        );

        jTabbedPane6.addTab("Edit", jPanel20);

        jPanel21.setBackground(new java.awt.Color(255, 153, 102));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        jLabel73.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Categorie:");

        CBextraInD.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBextraInD.setForeground(new java.awt.Color(0, 0, 0));
        CBextraInD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBextraInDItemStateChanged(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Available:");

        CBextraIng2.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBextraIng2.setForeground(new java.awt.Color(0, 0, 0));

        deleteIngre.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        deleteIngre.setForeground(new java.awt.Color(0, 0, 0));
        deleteIngre.setText("Delete");
        deleteIngre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIngreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(deleteIngre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(356, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addGap(30, 30, 30)
                        .addComponent(CBextraIng2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jLabel73)
                    .addGap(18, 18, 18)
                    .addComponent(CBextraInD, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(540, Short.MAX_VALUE)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(CBextraIng2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(deleteIngre)
                .addGap(76, 76, 76)
                .addComponent(jLabel37)
                .addContainerGap())
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(153, 153, 153)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CBextraInD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel73))
                    .addContainerGap(349, Short.MAX_VALUE)))
        );

        jTabbedPane6.addTab("Delete", jPanel21);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Extra ingredients", jPanel18);

        jPanel5.setBackground(new java.awt.Color(255, 153, 102));

        jTabbedPane2.setBackground(new java.awt.Color(255, 153, 102));
        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane2.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 153, 102));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Categorie name:");

        nameCategorie.setFont(new java.awt.Font("Ink Free", 0, 19)); // NOI18N

        createCategorie.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        createCategorie.setForeground(new java.awt.Color(0, 0, 0));
        createCategorie.setText("Create categorie");
        createCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCategorieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(761, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(333, 333, 333)
                                .addComponent(createCategorie))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(jLabel3)
                                .addGap(102, 102, 102)
                                .addComponent(nameCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(77, 77, 77)
                .addComponent(createCategorie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Create", jPanel6);

        jPanel8.setBackground(new java.awt.Color(255, 153, 102));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/efoodIcon2.png"))); // NOI18N

        CBdeleteC.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdeleteC.setForeground(new java.awt.Color(0, 0, 0));

        jLabel75.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Available:");

        deleteCategorie.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        deleteCategorie.setForeground(new java.awt.Color(0, 0, 0));
        deleteCategorie.setText("Delete");
        deleteCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCategorieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(761, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel75)
                        .addGap(68, 68, 68)
                        .addComponent(CBdeleteC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(deleteCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBdeleteC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(deleteCategorie)
                .addGap(77, 77, 77)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Delete", jPanel8);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Categories", jPanel5);

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        CBavailable.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBavailable.setForeground(new java.awt.Color(0, 0, 0));
        CBavailable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBavailableItemStateChanged(evt);
            }
        });

        CBdiscounts.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBdiscounts.setForeground(new java.awt.Color(0, 0, 0));
        CBdiscounts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBdiscountsItemStateChanged(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Available:");

        jLabel77.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Categorie:");

        jLabel12.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Type:");

        CBfood.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        CBfood.setForeground(new java.awt.Color(0, 0, 0));
        CBfood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dishes", "Drinks", "Extra ingredients" }));
        CBfood.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBfoodItemStateChanged(evt);
            }
        });

        discount.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        discount.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jLabel78.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("%");

        jLabel79.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Discount rate:");

        jLabel80.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Time:");

        try {
            hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        hora.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText(" Apply discount");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel77)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(CBdiscounts, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel12)
                                .addGap(112, 112, 112)
                                .addComponent(CBfood, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel78)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(jLabel80)
                                .addGap(26, 26, 26)
                                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel76)
                        .addGap(18, 18, 18)
                        .addComponent(CBavailable, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jButton1)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(CBdiscounts, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBfood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(98, 98, 98)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(CBavailable, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80)
                    .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(jButton1)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Discounts", jPanel2);

        jPanel7.setBackground(new java.awt.Color(255, 153, 102));
        jPanel7.setForeground(new java.awt.Color(255, 153, 102));

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton2.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Day");

        jButton3.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Week");

        jButton4.setFont(new java.awt.Font("Ink Free", 1, 19)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Month");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(29, 29, 29)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Extras", jPanel7);

        Exit.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        Exit.setForeground(new java.awt.Color(0, 0, 0));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        Exit();
    }//GEN-LAST:event_ExitActionPerformed

    private void CreateDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateDishActionPerformed
        CreateDish();
        CBdish();
        CBdish2();
    }//GEN-LAST:event_CreateDishActionPerformed

    private void selectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageActionPerformed
        settingSearcher();
    }//GEN-LAST:event_selectImageActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        categoriesCB();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void selectImageDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageDrinkActionPerformed
        settingSearcher();
    }//GEN-LAST:event_selectImageDrinkActionPerformed

    private void CreateDish1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateDish1ActionPerformed
        CreateDrink();
        CBDrink();
        CBDrink2();
    }//GEN-LAST:event_CreateDish1ActionPerformed

    private void selectImageDrink1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageDrink1ActionPerformed
        settingSearcher();
    }//GEN-LAST:event_selectImageDrink1ActionPerformed

    private void CreateIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateIngredientActionPerformed
        CreateIngredientExtra();
        CBIngredient2();
        CBIngredient();
    }//GEN-LAST:event_CreateIngredientActionPerformed

    private void CreateDish3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateDish3ActionPerformed
        ChangeDish();
    }//GEN-LAST:event_CreateDish3ActionPerformed

    private void selectImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImage1ActionPerformed
        settingSearcher();
    }//GEN-LAST:event_selectImage1ActionPerformed

    private void CBdishEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBdishEItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            CBdish();
        }
    }//GEN-LAST:event_CBdishEItemStateChanged

    private void CBdishesEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBdishesEItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            showEditDish();
        }
    }//GEN-LAST:event_CBdishesEItemStateChanged

    private void CBdishDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBdishDItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            CBdish2();
        }
    }//GEN-LAST:event_CBdishDItemStateChanged

    private void deleteDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDishActionPerformed
        DeleteDish();
    }//GEN-LAST:event_deleteDishActionPerformed

    private void modifyDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyDEActionPerformed
        ChangeDrink();
    }//GEN-LAST:event_modifyDEActionPerformed

    private void selectImageEEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageEEActionPerformed
        settingSearcher();
    }//GEN-LAST:event_selectImageEEActionPerformed

    private void modifyEEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyEEActionPerformed
        ChangeIngredient();
    }//GEN-LAST:event_modifyEEActionPerformed

    private void deleteDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDrinkActionPerformed
        DeleteDrink();
    }//GEN-LAST:event_deleteDrinkActionPerformed

    private void deleteIngreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteIngreActionPerformed
        DeleteIngredient();
    }//GEN-LAST:event_deleteIngreActionPerformed

    private void createCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCategorieActionPerformed
        CreateCategories();
    }//GEN-LAST:event_createCategorieActionPerformed

    private void CBdrinkEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBdrinkEItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            CBDrink();
        }
    }//GEN-LAST:event_CBdrinkEItemStateChanged

    private void CBdrinksEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBdrinksEItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            showEditDrink();
        }
    }//GEN-LAST:event_CBdrinksEItemStateChanged

    private void selectImageDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageDEActionPerformed
        settingSearcher();
    }//GEN-LAST:event_selectImageDEActionPerformed

    private void CBdrinkDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBdrinkDItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            CBDrink2();
        }
    }//GEN-LAST:event_CBdrinkDItemStateChanged

    private void CBextraInEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBextraInEItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            CBIngredient();
        }
    }//GEN-LAST:event_CBextraInEItemStateChanged

    private void CBextraIngEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBextraIngEItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            showEditIngredient();
        }
    }//GEN-LAST:event_CBextraIngEItemStateChanged

    private void CBextraInDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBextraInDItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            CBIngredient2();
        }
    }//GEN-LAST:event_CBextraInDItemStateChanged

    private void deleteCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCategorieActionPerformed
        DeleteCategorie();
        categoriesCB();
    }//GEN-LAST:event_deleteCategorieActionPerformed

    private void CBavailableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBavailableItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CBavailableItemStateChanged

    private void CBfoodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBfoodItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            ShowFood();
        }
    }//GEN-LAST:event_CBfoodItemStateChanged

    private void CBdiscountsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBdiscountsItemStateChanged
        if (evt != null && evt.getSource().toString() != null && !evt.getSource().toString().isEmpty() && evt.getStateChange() == ItemEvent.SELECTED) {
            ShowFood();
        }
    }//GEN-LAST:event_CBdiscountsItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       TimeDiscount();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBavailable;
    private javax.swing.JComboBox<String> CBdeleteC;
    private javax.swing.JComboBox<String> CBdiscounts;
    private javax.swing.JComboBox<String> CBdish;
    private javax.swing.JComboBox<String> CBdishD;
    private javax.swing.JComboBox<String> CBdishE;
    private javax.swing.JComboBox<String> CBdishesD;
    private javax.swing.JComboBox<String> CBdishesE;
    private javax.swing.JComboBox<String> CBdrink;
    private javax.swing.JComboBox<String> CBdrinkD;
    private javax.swing.JComboBox<String> CBdrinkE;
    private javax.swing.JComboBox<String> CBdrinksD;
    private javax.swing.JComboBox<String> CBdrinksE;
    private javax.swing.JComboBox<String> CBextraInD;
    private javax.swing.JComboBox<String> CBextraInE;
    private javax.swing.JComboBox<String> CBextraIng;
    private javax.swing.JComboBox<String> CBextraIng2;
    private javax.swing.JComboBox<String> CBextraIngE;
    private javax.swing.JComboBox<String> CBfood;
    private javax.swing.JButton CreateDish;
    private javax.swing.JButton CreateDish1;
    private javax.swing.JButton CreateDish3;
    private javax.swing.JButton CreateIngredient;
    private javax.swing.JButton Exit;
    private javax.swing.JSpinner codeDish;
    private javax.swing.JTextField codeDishE;
    private javax.swing.JSpinner codeDr;
    private javax.swing.JTextField codeDrinkE;
    private javax.swing.JSpinner codeEI;
    private javax.swing.JTextField codeExtra;
    private javax.swing.JButton createCategorie;
    private javax.swing.JButton deleteCategorie;
    private javax.swing.JButton deleteDish;
    private javax.swing.JButton deleteDrink;
    private javax.swing.JButton deleteIngre;
    private javax.swing.JTextField descriptionDish;
    private javax.swing.JTextField descriptionDishE;
    private javax.swing.JTextField descriptionDr;
    private javax.swing.JTextField descriptionDrinkE;
    private javax.swing.JTextField descriptionEI;
    private javax.swing.JTextField descriptionExtra;
    private javax.swing.JSpinner discount;
    private javax.swing.JTextField fileDish;
    private javax.swing.JTextField fileDishE;
    private javax.swing.JTextField fileDrink;
    private javax.swing.JTextField fileDrinkE;
    private javax.swing.JTextField fileEI;
    private javax.swing.JTextField fileExtra;
    private javax.swing.JFormattedTextField hora;
    private javax.swing.JTextField ingredientsDish;
    private javax.swing.JTextField ingredientsDishE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
<<<<<<< HEAD
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
=======
>>>>>>> master
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton modifyDE;
    private javax.swing.JButton modifyEE;
    private javax.swing.JTextField nameCategorie;
    private javax.swing.JTextField nameDish;
    private javax.swing.JTextField nameDishE;
    private javax.swing.JTextField nameDr;
    private javax.swing.JTextField nameDrinkE;
    private javax.swing.JTextField nameEI;
    private javax.swing.JTextField nameExtra;
    private javax.swing.JComboBox<String> presentationDish;
    private javax.swing.JComboBox<String> presentationDishE;
    private javax.swing.JComboBox<String> presentationDr;
    private javax.swing.JComboBox<String> presentationDrinkE;
    private javax.swing.JTextField presentationEI;
    private javax.swing.JComboBox<String> presentationExtra;
    private javax.swing.JSpinner priceDish;
    private javax.swing.JSpinner priceDishE;
    private javax.swing.JSpinner priceDr;
    private javax.swing.JSpinner priceDrinkE;
    private javax.swing.JSpinner priceEI;
    private javax.swing.JSpinner priceExtra;
    private javax.swing.JButton selectImage;
    private javax.swing.JButton selectImage1;
    private javax.swing.JButton selectImageDE;
    private javax.swing.JButton selectImageDrink;
    private javax.swing.JButton selectImageDrink1;
    private javax.swing.JButton selectImageEE;
    // End of variables declaration//GEN-END:variables
}
