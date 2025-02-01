package views.paneles1;


import dao.DAORolesImplementacion;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import models.Roles;

public class Panel2 extends javax.swing.JPanel {

    public Panel2(String correo) {
        initComponents();
        this.txtIdRol.setEditable(false);
        cargarTablaRol();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRol = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreRol = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        bntBorrar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtIdRol = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(557, 580));

        tablaRol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tablaRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRol);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrada de datos de los Roles");

        jLabel2.setText("Nombre del estado:");

        jLabel3.setText("Estado:");

        bntBorrar.setText("Borrar");
        bntBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBorrarActionPerformed(evt);
            }
        });

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnModificar.setText("Moficiar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel4.setText("Id");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnInsertar)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnModificar)
                                .addGap(38, 38, 38)
                                .addComponent(bntBorrar)
                                .addGap(31, 31, 31)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntBorrar)
                    .addComponent(btnModificar)
                    .addComponent(btnInsertar)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRolMouseClicked
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            this.txtIdRol.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            this.txtNombreRol.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            this.txtEstado.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            // Deshabilitar el campo txtIdRol para que no sea editable
            this.txtIdRol.setEditable(false);
            this.txtIdRol.setBackground(new java.awt.Color(200, 200, 200));
            this.btnInsertar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaRolMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.tablaRol.clearSelection();
        this.txtIdRol.setText("");
        this.txtNombreRol.setText("");
        this.txtEstado.setText("");
        // Opcional: Cambia el enfoque a otro componente (por ejemplo, un botón o campo de texto)
        this.txtNombreRol.requestFocus();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        DAORolesImplementacion dao_roles = new DAORolesImplementacion();
        Roles role = new Roles();
        if (this.txtNombreRol.getText().trim().isEmpty() || this.txtEstado.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }
        role.setNombre_rol(this.txtNombreRol.getText().trim());
        role.setEstado(Integer.parseInt(this.txtEstado.getText().trim()));
        try {
            boolean exito = dao_roles.insertar(role);
            if (exito) {
                cargarTablaRol();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Administrador registrado exitosamente.");
            } else {
                // Mensaje en caso de que no se inserten los datos
                JOptionPane.showMessageDialog(this, "No se pudo registrar el role. Verifique los datos e intente nuevamente.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
            // Capturar cualquier excepción y mostrar un mensaje detallado
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            // Para depuración, mostrar la pila de errores
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        DAORolesImplementacion dao_roles = new DAORolesImplementacion();
        Roles role = new Roles();
        if (this.txtNombreRol.getText().trim().isEmpty() || this.txtEstado.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }
        role.setId_rol(Integer.parseInt(this.txtIdRol.getText().trim()));
        role.setNombre_rol(this.txtNombreRol.getText().trim());
        role.setEstado(Integer.parseInt(this.txtEstado.getText().trim()));
        try {
            boolean exito = dao_roles.modificar(role);
            if (exito) {
                cargarTablaRol();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Administrador registrado exitosamente.");
            } else {
                // Mensaje en caso de que no se inserten los datos
                JOptionPane.showMessageDialog(this, "No se pudo registrar el role. Verifique los datos e intente nuevamente.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
            // Capturar cualquier excepción y mostrar un mensaje detallado
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            // Para depuración, mostrar la pila de errores
        }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void bntBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBorrarActionPerformed
        try {
            String id = this.txtIdRol.getText().trim();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            DAORolesImplementacion dao_role = new DAORolesImplementacion();
            Roles rol = new Roles();
            rol.setId_rol(Integer.parseInt(id));
            boolean eliminado = dao_role.eliminar(rol);
            if (eliminado) {
                cargarTablaRol();
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "El registro no fue encontrado o no se pudo eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            // Manejo de error al convertir a entero
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            // Manejo de cualquier otro error inesperado
            JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar eliminar el registro: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bntBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBorrar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRol;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdRol;
    private javax.swing.JTextField txtNombreRol;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaRol() {
        final String[] COLUMNAS = {"id", "Nombre del rol", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);

        try {
            DAORolesImplementacion dao_rol = new DAORolesImplementacion();
            List<Roles> rolList = dao_rol.listar();
            for (Roles dato : rolList) {
                List<Object> fila = new ArrayList<>();
                fila.add(dato.getId_rol());
                fila.add(dato.getNombre_rol());
                fila.add(dato.getEstado());
                modelo.addRow(fila.toArray());
            }
            this.tablaRol.setRowHeight(30);
            this.tablaRol.setModel(modelo);
            TableColumnModel columnModel = this.tablaRol.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(40);
            columnModel.getColumn(1).setPreferredWidth(200);
            columnModel.getColumn(2).setPreferredWidth(40);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los roles: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void limpiarCampos() {
        this.txtIdRol.setText("");
        this.txtNombreRol.setText("");
        this.txtEstado.setText("");

    }
}
