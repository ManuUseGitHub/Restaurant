/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.menus.views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import restaurant.menus.controllers.EditDishController;
import restaurant.menus.views.UserControls.PriceJSpinner;

/**
 *
 * @author Nicolas
 */
public class EditDishWindow extends javax.swing.JDialog implements EditDishController.EditDishWindow {

    private EditDishController controller;

    public EditDishWindow(java.awt.Frame parent) {
        super(parent, true);
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

        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        errorForName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        priceField = new restaurant.menus.views.UserControls.PriceJSpinner(0.0f,0.0f,9999.99f);
        errorForPrice = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingredients = new javax.swing.JTextArea();
        errorForIngredients = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setTitle("Edition d'un plat");
        setModal(true);

        jLabel1.setText("Nom :");

        errorForName.setForeground(new java.awt.Color(220, 0, 0));
        errorForName.setText("test");

        jLabel2.setText("Price :");

        errorForPrice.setForeground(new java.awt.Color(220, 0, 0));
        errorForPrice.setText("test");

        jLabel3.setText("Ingrédients :");

        ingredients.setColumns(20);
        ingredients.setRows(5);
        jScrollPane1.setViewportView(ingredients);

        errorForIngredients.setForeground(new java.awt.Color(220, 0, 0));
        errorForIngredients.setText("test");

        save.setText("Sauver");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        cancel.setText("Annuler");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(priceField)
                            .addGap(18, 18, 18)
                            .addComponent(errorForPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(errorForName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancel)
                                .addGap(0, 32, Short.MAX_VALUE))
                            .addComponent(errorForIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorForName)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorForPrice))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorForIngredients))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        controller.saveEvent();
    }//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        controller.cancelEvent();
    }//GEN-LAST:event_cancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel errorForIngredients;
    private javax.swing.JLabel errorForName;
    private javax.swing.JLabel errorForPrice;
    private javax.swing.JTextArea ingredients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    /*
    private javax.swing.JSpinner priceField;
    */
    private restaurant.menus.views.UserControls.PriceJSpinner priceField;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getName() {
        return this.nameField.getText();
    }

    @Override
    public void setController(EditDishController controller) {
        this.controller = controller;
    }

    @Override
    public void setErrorForName(String value) {
        this.errorForName.setText(value);
        this.errorForName.setVisible(value.trim().length() > 0);
    }

    @Override
    public void setPrice(float value) {
        this.priceField.setValue(value);
    }

    @Override
    public float getPrice() {
        return Float.parseFloat(priceField.toString());
    }

    @Override
    public void setErrorForPrice(String value) {
        this.errorForPrice.setText(value);
        this.errorForPrice.setVisible(value.trim().length() > 0);
    }

    @Override
    public List<String> getIngredients() {
        List<String> result = new ArrayList<>();
        for (String i : ingredients.getText().split(",")) {
            result.add(i);
        }
        return result;
    }

    @Override
    public void setIngredients(List<String> value) {
        ingredients.setText(String.join(",", value.<String>toArray(new String[value.size()])));
    }

    @Override
    public void setErrorForIngredients(String value) {
        this.errorForIngredients.setText(value);
        this.errorForIngredients.setVisible(value.trim().length() > 0);
    }
}