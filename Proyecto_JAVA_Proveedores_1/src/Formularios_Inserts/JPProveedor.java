
package Formularios_Inserts;
import Confirmacion_Inserts.JFConfirmaProveedor;
import javax.swing.JOptionPane;
import java.sql.*;
import proyecto_java_proveedores.ConexionBD;


public class JPProveedor extends javax.swing.JPanel {

    ConexionBD Conexion_Actual; 
    int lastid;
    String selectId;
    String SelectEmpresa;
    String SelectCiudad;
    String SelectEstado;
    String SelectUbicacion;
    String SelectTelefono;
    String SelectContacto;
    String SelectCorreo;
    
    private boolean esActualizacion; // Indicador para modo de actualización

    // Constructor modificado
    public JPProveedor(ConexionBD conexion, boolean esActualizacion) {
        initComponents();
        this.esActualizacion = esActualizacion;
        this.Conexion_Actual = conexion;
        if (ultimoid()!= null) {
            selectId = String.valueOf(ultimoid()+ 1);
        }
        txtID.setText(selectId);

        // Lógica para mostrar/ocultar botones
        configurarModo();
    }

    private void configurarModo() {
        // Mostrar btnActualizar y ocultar clickInsertar si está en modo actualización
        btnActualizar.setVisible(esActualizacion);
        clickInsertar.setVisible(!esActualizacion);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEmpresa = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clickInsertar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUbi1 = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        ComboEstados = new javax.swing.JComboBox<>();
        txtCorreo1 = new javax.swing.JTextField();
        txtTel1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCorreo2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUbi2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtUbi3 = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Proveedor"));

        jLabel1.setText("Empresa:");

        jLabel2.setText("Ciudad: ");

        jLabel3.setText("Correo: ");

        clickInsertar.setText("Insertar Datos");
        clickInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickInsertarActionPerformed(evt);
            }
        });

        jLabel4.setText("Estado: ");

        jLabel5.setText("Colonia:");

        jLabel6.setText("Teléfono");

        jLabel7.setText("Contacto: ");

        ComboEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aguascalientes ", "Baja California ", "Baja California Sur ", "Campeche ", "Chiapas ", "Chihuahua ", "Ciudad de México ", "Coahuila ", "Colima ", "Durango ", "Estado de México ", "Guanajuato ", "Guerrero ", "Hidalgo ", "Jalisco ", "Michoacán ", "Morelos ", "Nayarit ", "Nuevo León ", "Oaxaca ", "Puebla ", "Querétaro ", "Quintana Roo ", "San Luis Potosí ", "Sinaloa ", "Sonora ", "Tabasco ", "Tamaulipas ", "Tlaxcala ", "Veracruz ", "Yucatán ", "Zacatecas" }));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Lada");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("@");

        jLabel10.setText("Calle:");

        jLabel11.setText("Numero Exterior: ");

        btnActualizar.setText("Actualizar Datos");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel12.setText("ID: ");

        txtID.setEditable(false);
        txtID.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                            .addComponent(txtCiudad))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtUbi1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtUbi3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(42, 42, 42)
                                                .addComponent(txtUbi2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(109, 109, 109))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ComboEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel6)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(176, 176, 176)
                                                        .addComponent(btnActualizar)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(clickInsertar)
                                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txtUbi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(txtUbi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(ComboEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtUbi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(txtTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clickInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        getAccessibleContext().setAccessibleName("Datos Proveedor");
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void clickInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickInsertarActionPerformed
        if(txtCiudad.getText().equals("") || txtContact.getText().equals("") || txtEmpresa.getText().equals("")|| txtTel1.getText().equals("") ||
                txtTel.getText().equals("") || txtUbi1.getText().equals("") || txtUbi2.getText().equals("") || txtUbi3.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Datos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
            
        }else if (!esNumeroEntero(txtTel1.getText()) || !esNumeroEntero(txtTel.getText()) || !esNumeroEntero(txtUbi3.getText())) {
        // Validación de campos numéricos
        JOptionPane.showMessageDialog(this, "Campos numericos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else{
            SelectEmpresa = txtEmpresa.getText();
        SelectEstado = ComboEstados.getSelectedItem().toString();
        SelectCiudad = txtCiudad.getText();
        SelectContacto = txtContact.getText();
        SelectCorreo = txtCorreo1.getText()+"@"+txtCorreo2.getText();
        SelectUbicacion = txtUbi1.getText()+" "+txtUbi2.getText()+" #"+txtUbi3.getText();
        SelectTelefono ="("+txtTel1.getText() +") "+ txtTel.getText();
        
        JFConfirmaProveedor confirmo = new JFConfirmaProveedor(SelectEmpresa, SelectCiudad, SelectEstado, SelectUbicacion, SelectTelefono, SelectContacto, SelectCorreo, Conexion_Actual);
        confirmo.setVisible(true);
        }       
        
    }//GEN-LAST:event_clickInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
        // Captura los valores de los campos de texto
        String id = txtID.getText();
        String empresa = txtEmpresa.getText();
        String estado = ComboEstados.getSelectedItem().toString();
        String ciudad = txtCiudad.getText();
        String contacto = txtContact.getText();
        String correo = txtCorreo1.getText() + "@" + txtCorreo2.getText();
        String ubicacion = txtUbi1.getText() + " " + txtUbi2.getText() + " #" + txtUbi3.getText();
        String telefono = "(" + txtTel1.getText() + ") " + txtTel.getText();
        
        // Llama al método GenerarActualizar con los valores capturados
        boolean resultado = GenerarActualizar(id, empresa, ciudad, estado, ubicacion, telefono, contacto, correo);
        
        // Muestra un mensaje en función del resultado
        if (resultado) {
            JOptionPane.showMessageDialog(this, "Actualización exitosa");
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnActualizarActionPerformed
    
    public void cargarDatos(String id, String empresa, String ciudad, String estado, String ubicacion, String telefono, String contacto, String correo) {
        txtID.setText(String.valueOf(id));
        txtEmpresa.setText(empresa);
        txtCiudad.setText(ciudad);
        ComboEstados.setSelectedItem(estado);
        // Asume que txtUbi1, txtUbi2, y txtUbi3 se llenan correctamente según la estructura de 'ubicacion'
        txtUbi1.setText(ubicacion.split(" ")[0]);  // Ajusta esto según tu formato de ubicación
        txtUbi2.setText(ubicacion.split(" ")[1]);
        txtUbi3.setText(ubicacion.split(" ")[2].replace("#", ""));
        txtTel1.setText(telefono.split(" ")[0].replace("(", "").replace(")", ""));
        txtTel.setText(telefono.split(" ")[1]);
        txtContact.setText(contacto);
        txtCorreo1.setText(correo.split("@")[0]);
        txtCorreo2.setText(correo.split("@")[1]);
    }
    
    private boolean GenerarActualizar(String id, String empresa, String ciudad, String estado, String ubicacion, String telefono, String contacto, String correo) {
    String query = "UPDATE proveedor SET Pro_empresa = ?, Pro_ciudad = ?, Pro_estado = ?, Pro_ubicacion = ?, Pro_telefono = ?, Pro_contacto = ?, Pro_correo = ? WHERE ID_Proveedor = ?";
    
    try {
        // Prepara la sentencia SQL
        PreparedStatement stmt = Conexion_Actual.getConnection().prepareStatement(query);
        
        // Asigna los valores a los parámetros
        stmt.setString(1, empresa);
        stmt.setString(2, ciudad);
        stmt.setString(3, estado);
        stmt.setString(4, ubicacion);
        stmt.setString(5, telefono);
        stmt.setString(6, contacto);
        stmt.setString(7, correo);
        stmt.setString(8, id); 

        // Ejecuta la actualización y captura las filas afectadas
        int rowsUpdated = stmt.executeUpdate();

        // Cierra el PreparedStatement
        stmt.close(); 
        
        // Retorna true si se actualizó al menos una fila
        return rowsUpdated > 0; 

    } catch (SQLException e) {
        // Muestra mensaje de error y traza la pila del error
        JOptionPane.showMessageDialog(null, "Error al Generar la Consulta: " + e.toString());
        e.printStackTrace(); // Muestra el error en consola para depuración
        return false;
    }
    }

    
    public Integer ultimoid() {
        lastid= this.Conexion_Actual.GetLastID("Proveedor");
        return lastid;
    }
    
    // Método auxiliar para validar si el texto es un número entero
    private boolean esNumeroEntero(String texto) {
        try {
            Integer.parseInt(texto); // Intenta convertir el texto a entero
            return true; // Retorna true si la conversión es exitosa
        } catch (NumberFormatException e) {
            return false; // Retorna false si ocurre una excepción (no es un número entero)
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboEstados;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton clickInsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtCorreo1;
    private javax.swing.JTextField txtCorreo2;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTel1;
    private javax.swing.JTextField txtUbi1;
    private javax.swing.JTextField txtUbi2;
    private javax.swing.JTextField txtUbi3;
    // End of variables declaration//GEN-END:variables
}
