
package Confirmacion_Inserts;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import proyecto_java_proveedores.ConexionBD;



public class JFConfirmaProveedor extends javax.swing.JFrame {

   
    ConexionBD ConexionActual;
    
    String SelectEmpresa;
    String SelectCiudad;
    String SelectEstado;
    String SelectUbicacion;
    String SelectTelefono;
    String SelectContacto;
    String SelectCorreo;
    
    public JFConfirmaProveedor(String Empresa, String Ciudad, String Estado, String Ubicacion, String Telefono, String Contacto, String Correo, ConexionBD ConexionActual) {
        this.ConexionActual = ConexionActual;
        this.SelectEmpresa = Empresa;
        this.SelectCiudad = Ciudad;
        this.SelectEstado = Estado;
        this.SelectUbicacion = Ubicacion;
        this.SelectTelefono = Telefono;
        this.SelectContacto = Contacto;
        this.SelectCorreo = Correo;
        initComponents();
        configurarCampos();
    }
    public void configurarCampos(){
        txtEmpresa.setText(SelectEmpresa);
        txtCiudad1.setText(SelectCiudad);
        txtEstado.setText(SelectEstado);
        txtUbi.setText(SelectUbicacion);
        txttel.setText(SelectTelefono);
        txtContact.setText(SelectContacto);
        txtCorreo.setText(SelectCorreo);
    }
    
    private void GenerarSentencia(){
        try{
            String Query="INSERT INTO proveedor"
                + "(Pro_Empresa, Pro_Ciudad, Pro_Estado, Pro_Ubicacion, Pro_Telefono, Pro_Contacto, Pro_Correo) "
                + "VALUES(?,?,?,?,?,?,?);";
            PreparedStatement stm=ConexionActual.getConnection().prepareStatement(Query);
            stm.setString(1, SelectEmpresa);
            stm.setString(2, SelectCiudad);
            stm.setString(3, SelectEstado);
            stm.setString(4, SelectUbicacion);
            stm.setString(5, SelectTelefono);  
            stm.setString(6, SelectContacto);
            stm.setString(7, SelectCorreo); 
            this.ConexionActual.EjecutarSentencia(stm);
            stm.close(); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Generar la Consulta: "+e.toString());
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();
        txtCiudad1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUbi = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Confirmacion de datos"));

        jLabel1.setText("Empresa: ");

        jLabel2.setText("Ciudad: ");

        jLabel3.setText("Estado: ");

        txtEstado.setEditable(false);
        txtEstado.setBorder(null);

        txtEmpresa.setEditable(false);
        txtEmpresa.setBorder(null);

        txtCiudad1.setEditable(false);
        txtCiudad1.setBorder(null);

        jLabel4.setText("Ubicación:");

        jLabel5.setText("Teléfono: ");

        jLabel6.setText("Contacto: ");

        txtUbi.setEditable(false);
        txtUbi.setBorder(null);

        txttel.setEditable(false);
        txttel.setBorder(null);

        txtContact.setEditable(false);
        txtContact.setBorder(null);

        jLabel7.setText("Correo: ");

        txtCorreo.setEditable(false);
        txtCorreo.setBorder(null);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
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
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUbi)
                    .addComponent(txttel)
                    .addComponent(txtContact)
                    .addComponent(txtCorreo)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiudad1)
                    .addComponent(txtEstado))
                .addGap(116, 116, 116))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(86, 86, 86)
                .addComponent(btnAceptar)
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCiudad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtUbi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(jButton2))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int Opcion=JOptionPane.showConfirmDialog(null,"¿Quiere Cancelar los Cambios?","Cancelar Insert", JOptionPane.YES_NO_OPTION);
                if(Opcion==JOptionPane.YES_OPTION){
                    JFConfirmaProveedor.this.dispose();
                    
                }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
            // TODO add your handling code here:
            int Opcion=JOptionPane.showConfirmDialog(null,"¿Quiere Aplicar los Cambios?","Aplicar Insert", JOptionPane.YES_NO_OPTION);
                if(Opcion==JOptionPane.YES_OPTION){
                    GenerarSentencia();
                    JFConfirmaProveedor.this.dispose();
                    
                }
    }//GEN-LAST:event_btnAceptarActionPerformed

    
    private void ConfigurarTextField(JTextField Texto,String Contenido){
         Texto.setText(Contenido);
         Texto.setEditable(false);
         Texto.setFont(new Font("Arial", Font.ITALIC, 15)); 
         Texto.setBackground(Color.white);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCiudad1;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtUbi;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
/*
        
        
        
        this.ConfigurarTextField(txtEmpresa, SelectEmpresa);
        this.ConfigurarTextField(txtCiudad1, SelectCiudad);
        this.txtEstado.setText(SelectEstado);
        this.ConfigurarTextField(txtUbi, SelectUbicacion);
        this.ConfigurarTextField(txttel, SelectTelefono);
        this.ConfigurarTextField(txtContact, SelectContacto);
        this.ConfigurarTextField(txtCorreo, SelectCorreo);*/
