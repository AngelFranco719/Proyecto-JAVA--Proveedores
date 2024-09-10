package Formularios_Inserts;
import Confirmacion_Inserts.Confirmacion_Compra;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import proyecto_java_proveedores.ConexionBD; 

public class Formulario_Insert_Compra extends javax.swing.JPanel {

    ConexionBD Conexion_Actual; 
    List<List<String>> Facturas=new ArrayList(); 
     List<List<String>> Ofertas=new ArrayList(); 
     List <String> Factura_Seleccionada; 
     List<String>Oferta_Seleccionada; 
    int Oferta_Selec; 
    int Factura_Selec; 
    int ID_Actual; 
    int cantidad; 
    int numero; 
    float subtotal; 
    public Formulario_Insert_Compra(ConexionBD Conexion_Actual) {
        initComponents();
        this.Conexion_Actual=Conexion_Actual;
        Facturas=Conexion_Actual.GetSelectAllFromResult("Factura");
        Ofertas=Conexion_Actual.GetSelectAllFromResult("Oferta");
        ID_Actual=Integer.parseInt(this.Conexion_Actual.getLastID("compra"))+1;
        Lb_IDActual.setText(String.valueOf(ID_Actual)); 
        Lb_IDActual.setEditable(false);
        Cb_Factura.removeAllItems();
        Cb_Oferta.removeAllItems();
        Inicializar_Combos(Cb_Factura, Facturas);
        Inicializar_Combos(Cb_Oferta, Ofertas);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Lb_IDActual = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Cb_Factura = new javax.swing.JComboBox<>();
        Cb_Oferta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Lb_Numero = new javax.swing.JTextField();
        Lb_Cantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Lb_Subtotal = new javax.swing.JTextField();
        B_Calcular = new javax.swing.JButton();
        B_Ingresar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setMinimumSize(new java.awt.Dimension(724, 345));
        setPreferredSize(new java.awt.Dimension(724, 345));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de Compra: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID Actual:");

        Lb_IDActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Lb_IDActual.setMinimumSize(new java.awt.Dimension(100, 26));
        Lb_IDActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lb_IDActualActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Selecciona una Factura:");

        Cb_Factura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Cb_Factura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cb_FacturaItemStateChanged(evt);
            }
        });

        Cb_Oferta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Cb_Oferta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cb_OfertaItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Selecciona una Oferta:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ingresa el Número de Compra:");

        Lb_Numero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Lb_Numero.setMinimumSize(new java.awt.Dimension(100, 26));
        Lb_Numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lb_Numero(evt);
            }
        });

        Lb_Cantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Lb_Cantidad.setMinimumSize(new java.awt.Dimension(100, 26));
        Lb_Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lb_Cantidad(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ingresa la Cantidad de Productos:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Subtotal:");

        Lb_Subtotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Lb_Subtotal.setText("0.0");
        Lb_Subtotal.setMinimumSize(new java.awt.Dimension(100, 26));
        Lb_Subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lb_Subtotal(evt);
            }
        });

        B_Calcular.setText("Calcular");
        B_Calcular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B_CalcularMouseClicked(evt);
            }
        });
        B_Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_CalcularActionPerformed(evt);
            }
        });

        B_Ingresar.setText("Ingresar Datos");
        B_Ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B_IngresarMouseClicked(evt);
            }
        });
        B_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_IngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(Cb_Factura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cb_Oferta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Lb_IDActual, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(Lb_Subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(B_Calcular))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Lb_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(Lb_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(B_Ingresar)
                .addGap(315, 315, 315))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(Lb_IDActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Cb_Factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Cb_Oferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Lb_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Lb_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(Lb_Subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(B_Calcular))
                .addGap(32, 32, 32)
                .addComponent(B_Ingresar)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        Lb_IDActual.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void Lb_IDActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lb_IDActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Lb_IDActualActionPerformed

    private void Lb_Numero(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lb_Numero
        // TODO add your handling code here:
    }//GEN-LAST:event_Lb_Numero

    private void Lb_Cantidad(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lb_Cantidad
        // TODO add your handling code here:
    }//GEN-LAST:event_Lb_Cantidad

    private void Lb_Subtotal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lb_Subtotal
        // TODO add your handling code here:
    }//GEN-LAST:event_Lb_Subtotal

    private void B_CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_CalcularActionPerformed
        
    }//GEN-LAST:event_B_CalcularActionPerformed

    private void B_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_IngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B_IngresarActionPerformed

    private void B_CalcularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_CalcularMouseClicked
        int Cantidad; 
        float Precio; 
        try{
            Cantidad=Integer.parseInt(Lb_Cantidad.getText());
            Precio=Float.parseFloat(Ofertas.get(Oferta_Selec).get(3));
            subtotal=Cantidad*Precio; 
            Lb_Subtotal.setText(String.valueOf(subtotal));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debes Ingresar la Cantidad Correcta:"+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_B_CalcularMouseClicked

    private void Cb_OfertaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cb_OfertaItemStateChanged
        try{
            Oferta_Selec=Integer.parseInt(Cb_Oferta.getSelectedItem().toString())-1;  
            Oferta_Seleccionada=Ofertas.get(Oferta_Selec); 
        }catch(Exception e){
        }
        
    }//GEN-LAST:event_Cb_OfertaItemStateChanged

    private void B_IngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_IngresarMouseClicked
        // TODO add your handling code here:
        numero=Integer.parseInt(Lb_Numero.getText());
        cantidad=Integer.parseInt(Lb_Cantidad.getText());
        subtotal=Float.parseFloat(Lb_Subtotal.getText());
        Confirmacion_Compra Confirmacion=new Confirmacion_Compra(Factura_Seleccionada,Oferta_Seleccionada, Conexion_Actual, ID_Actual, cantidad,subtotal,numero); 
    }//GEN-LAST:event_B_IngresarMouseClicked

    private void Cb_FacturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cb_FacturaItemStateChanged
        try{
            Factura_Selec=Integer.parseInt(Cb_Factura.getSelectedItem().toString())-1;    
            Factura_Seleccionada=Facturas.get(Factura_Selec); 
        }catch(Exception e){
        }
    }//GEN-LAST:event_Cb_FacturaItemStateChanged

    private void Inicializar_Combos(JComboBox Combo, List<List<String>> Lista){
        for(List<String> objeto: Lista){
            Combo.addItem(objeto.get(0));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Calcular;
    private javax.swing.JButton B_Ingresar;
    private javax.swing.JComboBox<String> Cb_Factura;
    private javax.swing.JComboBox<String> Cb_Oferta;
    private javax.swing.JTextField Lb_Cantidad;
    private javax.swing.JTextField Lb_IDActual;
    private javax.swing.JTextField Lb_Numero;
    private javax.swing.JTextField Lb_Subtotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
