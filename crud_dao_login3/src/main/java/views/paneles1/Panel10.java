package views.paneles1;

import dao.DAOFacturasImplementacion;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.Facturas;
import models.Matricula;

public class Panel10 extends javax.swing.JPanel {

    String valorCorreo = null;
    double costeModulo=30;

    public Panel10(String correo) {
        initComponents();
        cargarTablaBien();

        cargarComboBoxPago();

        this.valorCorreo = correo;
        bloquearTexto();
    }

    public Panel10() {
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidadModulos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtResultado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ComboBoxPago = new javax.swing.JComboBox<>();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tablaFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFacturas);

        jLabel2.setText("ID de la matricula:");

        jLabel3.setText("Nº de modulos:");

        jLabel1.setText("Importe:");

        jLabel4.setText("Pagado:");

        ComboBoxPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtIdMatricula, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidadModulos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtResultado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(ComboBoxPago, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnInsertar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ComboBoxPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidadModulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public double getCosteModulo() {
        return costeModulo;
    }

    private void tablaFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFacturasMouseClicked
        double resultadoNumerico = 0.0;
        if (evt.getClickCount() == 1) {
            try {
                JTable receptor = (JTable) evt.getSource();
                String idMatricula = receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString();
                txtIdMatricula.setText(idMatricula);

                DAOFacturasImplementacion dao_cantidad_modulo = new DAOFacturasImplementacion();
                int cantidadModulo = dao_cantidad_modulo.obtenerCantidadMatriculas(idMatricula);
                this.txtCantidadModulos.setText(String.valueOf(cantidadModulo));

                double precioPorModulo = getCosteModulo();

                resultadoNumerico = cantidadModulo * precioPorModulo;
                txtResultado.setText(String.valueOf(resultadoNumerico));
                DecimalFormat formatoMoneda = new DecimalFormat("#.00");
                String resultadoFormateado = formatoMoneda.format(resultadoNumerico) + " €";
                String valorCombo = receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString();
                this.ComboBoxPago.setSelectedItem(valorCombo);
            } catch (Exception ex) {
                // Capturar cualquier error inesperado y mostrar un mensaje en consola o un cuadro de diálogo
                System.err.println("Error al procesar el clic en la tabla: " + ex.getMessage());
                // Para depuración, puedes quitar esto en producción
            }

        }
    }//GEN-LAST:event_tablaFacturasMouseClicked

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        try {
            DAOFacturasImplementacion dao_facturas = new DAOFacturasImplementacion();
            Facturas factura = new Facturas();
            Matricula matricula = new Matricula();
            String idMatriculaStr = this.txtIdMatricula.getText().trim();
            System.out.println("valor importe " + this.txtResultado.getText());
            if (idMatriculaStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El ID de matrícula no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int idMatricula = Integer.parseInt(idMatriculaStr);
            String comboOpcion = (String) this.ComboBoxPago.getSelectedItem();
            if ("Opciones".equals(comboOpcion) || this.ComboBoxPago == null) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una opción válida de pago.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            matricula.setId_matricula(idMatricula);
            factura.setMatricula(matricula);
            float precio = Float.parseFloat(this.txtResultado.getText().trim());
            factura.setPrecio(precio);
            factura.setEstado_pago(comboOpcion);
            boolean exito = dao_facturas.insertarFactura(factura, this.valorCorreo);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Datos agregados exitosamente.");
                cargarTablaBien();

                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            // Manejar errores en la conversión del String a int
            JOptionPane.showMessageDialog(this, "El ID de matrícula debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            // Manejar cualquier otro error
            JOptionPane.showMessageDialog(this, "Ocurrió un error al insertar la factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            // Para depuración
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        DAOFacturasImplementacion dao_factura_modificada = new DAOFacturasImplementacion();
        Facturas facturas = new Facturas();
        Matricula matricula = new Matricula();

        String idMatriculaStr = this.txtIdMatricula.getText().trim();
        if (idMatriculaStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta el campo id matricula ");
            return;
        }
        int idMatriFactura;
        try {
            idMatriFactura = Integer.parseInt(idMatriculaStr);
        } catch (NumberFormatException es) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
            return;
        }
        String comboOpciones = (String) this.ComboBoxPago.getSelectedItem();
        if (comboOpciones.equals("Opciones")) {
            JOptionPane.showMessageDialog(this, "La opción seleccionada no puede ser Opciones.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        matricula.setId_matricula(idMatriFactura);
        facturas.setMatricula(matricula);
        facturas.setEstado_pago(comboOpciones);
        try {
            boolean exito = dao_factura_modificada.modificarFactura(facturas, this.valorCorreo);
            if (exito) {
                cargarTablaBien();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Factura modificado exitosamente.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el registro: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DAOFacturasImplementacion dao_eliminar_factura = new DAOFacturasImplementacion();
        Facturas factura = new Facturas();
        Matricula matricula = new Matricula();

        if (this.txtIdMatricula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo ID de matrícula está vacío.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idMatricula = Integer.parseInt(this.txtIdMatricula.getText().trim());
            matricula.setId_matricula(idMatricula);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para el ID de matrícula.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        factura.setMatricula(matricula);
        boolean exito = dao_eliminar_factura.eliminarFactura(factura, this.valorCorreo);

        if (exito) {
            JOptionPane.showMessageDialog(this, "el modulo con la matricula " + matricula + " fue eliminado exitosamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTablaBien();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el modulo con ID de la matricula " + matricula + ". Verifica si existe en la base de datos.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        limpiarCampos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
        cargarTablaBien();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String buscar = this.txtBuscar.getText().trim();
        if (buscar.isEmpty()) {
            this.cargarTablaBien();
            return;
        }
        try {
            DAOFacturasImplementacion dao_buscar_factura = new DAOFacturasImplementacion();
            List<Alumno> arrayAlumnoFactura = dao_buscar_factura.listaAlumnosBuscarFactura(buscar);
            actualizarTabla(arrayAlumnoFactura);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al realizar la búsqueda: " + e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxPago;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidadModulos;
    private javax.swing.JTextField txtIdMatricula;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaBien() {
        final String[] COLUMNAS = {"matricula", "nombre", "apellido", "correo", "foto", "Estado pagado", "visto"};
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);
        try {
            DAOFacturasImplementacion dao_facturas = new DAOFacturasImplementacion();
            List<Alumno> arrayList = dao_facturas.listadoAlumnosFacturas();
            for (Alumno dato : arrayList) {
                Object[] fila = new Object[7]; // Número de columnas en el modelo
                fila[0] = dato.getMatricula().getId_matricula();
                fila[1] = dato.getNombre();
                fila[2] = dato.getApellido();
                fila[3] = dato.getCorreo_electronico();

                // Manejo de la imagen
                String rutaImagen1 = dato.getFoto_alumno();
                ImageIcon icon = cargarImagen(rutaImagen1, 35, 35);
                fila[4] = (icon != null) ? icon : "Sin imagen";
                fila[5] = dato.getFacturas().getEstado_pago();
                fila[6] = dato.getFacturas().getVisto();
                modelo.addRow(fila);
            }
            this.tablaFacturas.setRowHeight(35);
            this.tablaFacturas.setModel(modelo);
            asignarRenderizadorDeImagen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los alumnos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asignarRenderizadorDeImagen() {
        this.tablaFacturas.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof ImageIcon imageIcon) {
                    return new JLabel(imageIcon);
                } else {
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }
        });
    }

    private ImageIcon cargarImagen(String ruta, int ancho, int alto) {
        ImageIcon icon = null;

        try {
            String rutaImagen = ruta;
            URL imageUrl = getClass().getClassLoader().getResource(rutaImagen);
            if (imageUrl != null) {
                icon = new ImageIcon(imageUrl);
                icon.setDescription(rutaImagen);
                // System.out.println("Imagen cargada: " + rutaImagen);
            } else {
                // Si la imagen no existe, usar la imagen por defecto
                URL defaultImageUrl = getClass().getClassLoader().getResource("default.jpg");
                if (defaultImageUrl != null) {
                    icon = new ImageIcon(defaultImageUrl);
                    icon.setDescription("default.jpg");
                    // System.out.println("Imagen por defecto cargada");
                }
            }
            if (icon != null) {
                // Escalar la imagen al tamaño especificado
                Image img = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                icon = new ImageIcon(img);
            }
        } catch (Exception ex) {
            System.err.println("Error al cargar la imagen: " + ex.getMessage());
        }
        return icon;
    }

    private void cargarComboBoxPago() {
        //creamos un arreglo con los valores del combo
        String[] opcionesPago = {"Opciones", "Pagado", "Pendiente", "En proceso", "Rechazado"};
        //limpiar el combobox
        ComboBoxPago.removeAllItems();;
        for (String opcion : opcionesPago) {
            this.ComboBoxPago.addItem(opcion);
        }
    }

    private void limpiarCampos() {
        this.txtIdMatricula.setText("");
        this.txtCantidadModulos.setText("");
        this.txtResultado.setText("");
        this.ComboBoxPago.setSelectedIndex(0);
        this.txtBuscar.setText("");
    }

    private void actualizarEstadoTabla(int idMatricula, String estado) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaFacturas.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            int idMatriculaEnFila = Integer.parseInt(modelo.getValueAt(i, 0).toString());  // Obtener ID de matrícula de la fila
            if (idMatriculaEnFila == idMatricula) {
                // Actualizar el valor de la columna "Estado" en la fila correspondiente
                modelo.setValueAt(estado, i, 5);  // Columna "Estado" es la columna 5 (de acuerdo con tu modelo)
                break;
            }
        }
    }

    private void bloquearTexto() {
        this.txtIdMatricula.setEditable(false);
        this.txtCantidadModulos.setEditable(false);
        this.txtCantidadModulos.setEditable(false);
        this.txtResultado.setEditable(false);
    }

    private void actualizarTabla(List<Alumno> arrayAlumnoFactura) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaFacturas.getModel();
        modelo.setRowCount(0);// Limpiar la tabla
        ImageIcon icon = null;
        for (Alumno dato : arrayAlumnoFactura) {
            if (dato.getFoto_alumno() != null && !dato.getFoto_alumno().isEmpty()) {
                icon = cargarImagen1(dato.getFoto_alumno());
            } else {
                icon = cargarImagen1("default.jpg");
            }
            modelo.addRow(new Object[]{
                dato.getMatricula().getId_matricula(),
                dato.getNombre(),
                dato.getApellido(),
                dato.getCorreo_electronico(),
                icon,
                dato.getFacturas().getEstado_pago(),
                dato.getFacturas().getVisto()
            });
        }
        this.tablaFacturas.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof ImageIcon) {
                    return new JLabel((ImageIcon) value);
                } else {
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }
        });

    }

    private ImageIcon cargarImagen1(String ruta) {//rutarelativa
        ImageIcon icono = null;
        // Si la ruta de la imagen no es nula ni vacía
        if (ruta != null && !ruta.isEmpty()) {
            URL imageUrl = getClass().getClassLoader().getResource(ruta);
            if (imageUrl != null) {
                icono = new ImageIcon(new ImageIcon(imageUrl).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
                icono.setDescription(ruta);
                // System.out.println("Imagen cargada desde el recurso: " + imageUrl);
            } else {
                System.out.println("La imagen no existe en los recursos: " + ruta);
                icono = new ImageIcon(getClass().getClassLoader().getResource("default.jpg"));
                icono.setDescription("default.jpg");
            }
        } else {
            // Si no hay imagen almacenada, usar imagen por defecto
            System.out.println("No hay imagen almacenada para este administrador.");
            icono = new ImageIcon(getClass().getClassLoader().getResource("default.jpg"));
            icono.setDescription("default.jpg");
        }
        return icono;

    }

}
