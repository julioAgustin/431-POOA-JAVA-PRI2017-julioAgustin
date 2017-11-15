
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alumno-204
 */
public class Productos extends javax.swing.JFrame {

    /**
     * Creates new form Productos
     */
    private Connection bd = null;
    private ConexionBaseDeDatos claseConexion = null;
    DefaultTableModel modeloTabla;
    private Integer id = null;

    /* al usar estar variable.. hay que hacer click derecho en la tabla -> contenido de la tabla -> codigo personalizado
    -> y en el campo se agrega el nombre de la variable "modeloTabla" */
    public Productos() {
        // para bd = claseConexion.conectarBD(); lanza error pidiendo que captures error con throws SQLException
        // porque en la clase padre yo pido que se capturen todos los errores de ese tipo para todas las clases
        claseConexion = new ConexionBaseDeDatos();
        try {
            bd = claseConexion.conectarBD();
            System.out.println("SE CONECTÓ...");
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarTabla();
        // el initComponents() es la fuente de todo lo que hacemos
        initComponents();
    }

    private void cargarTabla() {
        modeloTabla = new DefaultTableModel(null, getColumnas());
        getFilas();
    }

    private String[] getColumnas() {
        String columnas[] = new String[]{"Codigo", "Producto", "Fabricante", "Cantidad"}; // este es para el titulo..lo que va entre{} 
        return columnas;
    }

    private void getFilas() {
        try {
            String sql = "SELECT id_producto, descripcion, fabricante, cantidad FROM public.productos;";
            ResultSet datos = claseConexion.obtenerDatos(sql, null);
            Object valores[] = new Object[4];
            while (datos.next()) {
                // como hay que sacar los datos por fila y luego por objeto se vuelve a iterar
                for (int i = 0; i < 4; i++) {
                    // la primera posicion del resultSet empieza en 1 por eso se le suma 1 en getObject
                    // esto se hace para usar un solo contador para el vector y el resultSet
                    // porque el vector empieza en 0 y el resultSet en 1
                    valores[i] = datos.getObject(i + 1);
                }
                // como se itera en addRow es porque se agrega un fila por vez
                modeloTabla.addRow(valores);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreProducto = new javax.swing.JTextField();
        fabricante = new javax.swing.JTextField();
        cantidad = new javax.swing.JSpinner();
        buscar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        confirmarAccion = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre Producto:");

        jLabel2.setText("Fabricante:");

        jLabel4.setText("Cantidad:");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        jTable2.setModel(modeloTabla);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        confirmarAccion.setText("Confirmar");
        confirmarAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarAccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(buscar)
                        .addGap(18, 18, 18)
                        .addComponent(agregar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmarAccion)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar)
                    .addComponent(agregar)
                    .addComponent(actualizar)
                    .addComponent(eliminar)
                    .addComponent(limpiar)
                    .addComponent(confirmarAccion))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if (camposValidos()) {
            String producto = nombreProducto.getText();
            String fab = fabricante.getText();
            Integer cant = new Integer(cantidad.getValue().toString());
            // lo que hago aca por variable se puede hacer directo en el parametro
            try {
                boolean resultado = claseConexion.insertarBD(producto, fab, cant);
                if (resultado) {
                    JOptionPane.showMessageDialog(rootPane, "Los datos fueron insertados correctamente", "Resultado insercion", 1);
                    //System.out.println("Los datos fueron insertados correctamente");
                    return;
                }
                // return se usa como para no usar false
                // el uno indica informacion
                // el cero indica error
                JOptionPane.showMessageDialog(rootPane, "Los datos no se han insertado", "Resultado insercion", 0);
                //System.out.println("Los datos no se han insertado");

            } catch (SQLException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            String sentencia = "SELECT id_producto, descripcion, fabricante, cantidad FROM public.productos where 1=1";
            // el where 1=1 se pone asi para verificar que una condicion se cumpla sin tener que revisar si tiene o no where la sentencia
            String valores = "";
            // se crea este String para armar una cadena con los valores ? para pasarle, es decir, para setear
            if (!nombreProducto.getText().trim().isEmpty()) {
                sentencia = sentencia + " and descripcion like ?";
                valores = valores + nombreProducto.getText() + "-";
            }
            if (!fabricante.getText().trim().isEmpty()) {
                sentencia = sentencia + " and fabricante like ?";
                valores = valores + fabricante.getText() + "-";
            }
            if (new Integer(cantidad.getValue().toString()).intValue() > 0) {
                sentencia = sentencia + " and cantidad :: text like ?";
                valores = valores + cantidad.getValue().toString() + "-";
            }
            ResultSet datos = claseConexion.obtenerDatos(sentencia, valores);
            limpiarTabla();
            Object valor[] = new Object[4];
            while (datos.next()) {
                for (int i = 0; i < 4; i++) {
                    valor[i] = datos.getObject(i + 1);
                }
                modeloTabla.addRow(valor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        int filaSeleccionada = jTable2.getSelectedRow();

        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro? ");
            if (JOptionPane.OK_OPTION == confirmar) {
                try {
                    Integer id = (Integer) modelo.getValueAt(filaSeleccionada, 0);
                    claseConexion.eliminarDatos(id);
                    limpiarTabla();
                    getFilas();
                } catch (SQLException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }//GEN-LAST:event_eliminarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
        nombreProducto.setText("");
        fabricante.setText("");
        cantidad.setValue(0);
        getFilas();
        limpiarTabla();
    }//GEN-LAST:event_limpiarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        int filaSeleccionada = jTable2.getSelectedRow();

        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {

            id = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            String descripcionProducto = (String) modelo.getValueAt(filaSeleccionada, 1);
            String fabricanteProducto = (String) modelo.getValueAt(filaSeleccionada, 2);
            Integer cantidadProducto = (Integer) modelo.getValueAt(filaSeleccionada, 3);
            nombreProducto.setText(descripcionProducto);
            fabricante.setText(fabricanteProducto);
            cantidad.setValue(cantidadProducto);

            //limpiarTabla();
            //getFilas();
        }


    }//GEN-LAST:event_actualizarActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        int filaSeleccionada = jTable2.getSelectedRow();
        Integer id = (Integer) modelo.getValueAt(filaSeleccionada, 0);
        String descripcionProducto = (String) modelo.getValueAt(filaSeleccionada, 1);
        String fabricanteProducto = (String) modelo.getValueAt(filaSeleccionada, 2);
        Integer cantidadProducto = (Integer) modelo.getValueAt(filaSeleccionada, 3);
        nombreProducto.setText(descripcionProducto);
        fabricante.setText(fabricanteProducto);
        cantidad.setValue(cantidadProducto);

    }//GEN-LAST:event_jTable2MouseClicked

    private void confirmarAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarAccionActionPerformed

        // TODO add your handling code here:
        if (camposValidos()) {
            DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
            id = jTable2.getSelectedRow() + 1;
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea confirmar el registro? ");
            if (JOptionPane.OK_OPTION == confirmar) {
                claseConexion.actualizarRegistro(id, nombreProducto.getText(), fabricante.getText(), new Integer(cantidad.getValue().toString()));
                limpiarTabla();
                getFilas();
                limpiarCampos();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_confirmarAccionActionPerformed

    public void limpiarTabla() {
        int sizeTable = modeloTabla.getRowCount();
        for (int i = 0; i < sizeTable; i++) {
            // se pone solo cero "removeRow(0)" porque quiero que me elimine solo el contenido, no quiero que elimine
            // los titulos de la tabla
            modeloTabla.removeRow(0);
        }
    }

    private boolean camposValidos() {
        if (nombreProducto.getText().trim().isEmpty()) {
            return false;
        }
        if (fabricante.getText().trim().isEmpty()) {
            return false;
        }
        if (new Integer(cantidad.getValue().toString()).intValue() <= 0) {
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        nombreProducto.setText("");
        fabricante.setText("");
        cantidad.setValue(0);
    }

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton agregar;
    private javax.swing.JButton buscar;
    private javax.swing.JSpinner cantidad;
    private javax.swing.JButton confirmarAccion;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField fabricante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField nombreProducto;
    // End of variables declaration//GEN-END:variables
}
