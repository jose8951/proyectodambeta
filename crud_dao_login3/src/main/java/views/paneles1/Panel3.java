package views.paneles1;

import dao.DAOAlumnosImplementacion;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import utils.Utilidades;

public class Panel3 extends javax.swing.JPanel {

    String path2 = null;
    String valorCorreo = null;

    public Panel3(String correo) {
        initComponents();
        this.setPreferredSize(new java.awt.Dimension(557, 580));
        cargarTablaBien();
        System.out.println("carga el panel 3");
        this.btnBorrar.setEnabled(false);
        this.btnModificar.setEnabled(false);

        this.ComboCalle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Selecciona", "Calle", "Avenida", "Plaza", "Callejón"
        }));

        this.add(ComboCalle);

        valorCorreo = correo;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtFoto = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        txtEdad = new javax.swing.JLabel();
        ComboCalle = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(557, 580));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(557, 580));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrada de datos de alumnos");

        tablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tablaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAlumno);

        jLabel2.setText("id Alumno:");

        txtId.setEditable(false);

        jLabel3.setText("Nombre:");

        jLabel4.setText("Fecha Nac:");

        jLabel6.setText("Correo: ");

        txtFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnUpload.setText("Imagen");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        ComboCalle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Apellido");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComboCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnInsertar)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnModificar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBorrar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelar))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnUpload))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertar)
                            .addComponent(btnModificar)
                            .addComponent(btnBorrar)
                            .addComponent(btnCancelar))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpload)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        JFileChooser chooser = new JFileChooser();
        String projectDir = System.getProperty("user.dir");
        File srcDir = new File(projectDir, "src/main/resources");
        if (srcDir.exists()) {
            chooser.setCurrentDirectory(srcDir);
        } else {
            JOptionPane.showMessageDialog(this, "El directorio src/main/resources no existe.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Filtrar para mostrar solo imágenes
        chooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg"));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
            try {
                if (!selectedFile.exists() || !selectedFile.canRead()) {
                    JOptionPane.showMessageDialog(this, "El archivo no existe o no es legible.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Extraer solo el nombre del archivo
                String fileName = selectedFile.getName();
                System.out.println("nombre del archivo " + fileName);

                BufferedImage bufferedImage = ImageIO.read(selectedFile);
                if (bufferedImage == null) {
                    JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen. Verifique el archivo.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Image scaledImage = bufferedImage.getScaledInstance(110, 157, Image.SCALE_SMOOTH);
                txtFoto.setIcon(new ImageIcon(scaledImage));
                path2 = fileName;
                System.out.println("valor fe path2 " + path2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();
        this.btnInsertar.setEnabled(true);
        this.btnModificar.setEnabled(false);
        this.btnBorrar.setEnabled(false);
        this.tablaAlumno.clearSelection();
        this.txtEdad.setVisible(false);
        cargarTablaBien();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String nombre = txtBuscar.getText().trim();
        if (nombre.isEmpty()) {
            // Si el campo está vacío, puedes limpiar la tabla o mostrar todos los registros
            this.cargarTablaBien();
            return;
        }
        try {
            DAOAlumnosImplementacion dao_alumno = new DAOAlumnosImplementacion();
            List<Alumno> listaAlumno = dao_alumno.buscarPorNombre(nombre);
            actualizarTabla(listaAlumno);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al realizar la búsqueda: " + e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // Crear instancias de DAO y entidad Administradores
        DAOAlumnosImplementacion dao_alumno = new DAOAlumnosImplementacion();
        Alumno alumno = new Alumno();

        String nombre = this.txtNombre1.getText().trim();
        String apellido = this.txtApellido.getText().trim();
        Date fecha = Utilidades.formatearFechaDate(this.txtFecha.getDate());
        System.out.println("formato fecha " + fecha);
        String direccion = this.txtDireccion.getText().trim();
        String correo = this.txtCorreo.getText().trim();

        if (nombre.isEmpty() || fecha == null || direccion.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
            return;
        }

        // Validar el correo
        if (!Utilidades.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "El correo ingresado no es válido.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(txtId.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
            return;
        }

        // Validar la imagen seleccionada
        if (path2 == null || path2.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna imagen.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        alumno.setId_alumno(id);
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setFecha_nacimiento(fecha);
        alumno.setDireccion(direccion);
        alumno.setCorreo_electronico(correo);
        alumno.setFoto_alumno(path2);

        try {
            boolean exito = dao_alumno.modificar(alumno);
            if (exito) {
                cargarTablaBien();
                limpiarCampos();
                this.btnInsertar.setEnabled(true);
                this.btnModificar.setEnabled(false);
                this.btnBorrar.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Alumno registrado exitosamente.");

            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el registro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        DAOAlumnosImplementacion dao_alumno = new DAOAlumnosImplementacion();
        Alumno alumno = new Alumno();

        String nombre = this.txtNombre1.getText().trim();
        String apellido=this.txtApellido.getText().trim();
        Date fecha = Utilidades.formatearFechaDate(this.txtFecha.getDate());
        String direccion = this.txtDireccion.getText().trim();
        String correo = this.txtCorreo.getText().trim();

        if (nombre.isEmpty() || fecha == null || direccion.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
            return;
        }

        if (!Utilidades.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un correo válido.", "Correo inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.path2 == null || this.path2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una foto.", "Foto requerida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int indeSeleccionado = this.ComboCalle.getSelectedIndex();
        Object seleccionado = this.ComboCalle.getSelectedItem();
        String valorCombo = (seleccionado != null) ? seleccionado.toString() : "";

        if (indeSeleccionado == 0 || valorCombo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: No hay un valor válido seleccionado en el combo. Vuelve a intentarlo", "No ha seleccionado la calle.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Asignar valores al objeto alumno
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setFecha_nacimiento(fecha);
        alumno.setDireccion(valorCombo + " " + direccion);
        alumno.setCorreo_electronico(correo);
        alumno.setFoto_alumno(path2);

        try {
            boolean exito = dao_alumno.insertarAlumno(alumno);
            if (exito) {
                cargarTablaBien();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Alumno registrado exitosamente.");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void tablaAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnoMouseClicked
        if (evt.getClickCount() == 1) {
            this.btnInsertar.setEnabled(false);
            this.btnModificar.setEnabled(true);
            this.btnBorrar.setEnabled(true);
            ComboCalle.setSelectedIndex(0);
            JTable receptor = (JTable) evt.getSource();
            this.txtId.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            this.txtNombre1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            this.txtApellido.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            try {
                String fechaStr = receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString();
                Date mostrar = Utilidades.cambiarFecha(fechaStr);
                this.txtFecha.setDate(mostrar);

                int edad = utils.Utilidades.calcularEdad(mostrar);
                this.txtEdad.setVisible(true);
                this.txtEdad.setText(edad != -1 ? String.valueOf("Edad " + edad) : "Error");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al convertir la fecha: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.txtDireccion.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());
            this.txtCorreo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString());

            Object valorImagen = receptor.getModel().getValueAt(receptor.getSelectedRow(), 6);  // La celda que contiene el ImageIcon
            if (valorImagen instanceof ImageIcon) {
                ImageIcon originalIcon = (ImageIcon) valorImagen;
                // Recuperamos la ruta de la imagen desde la descripción
                String rutaImagen = originalIcon.getDescription();
                System.out.println("Ruta de la imagen recuperada: " + rutaImagen);
                if (rutaImagen != null && !rutaImagen.isEmpty()) {
                    cargarImagen(txtFoto, rutaImagen, 110, 157); // Cargar la imagen en el JTextField o JLabel
                    path2 = rutaImagen;
                } else {
                    this.txtFoto.setIcon(null); // Si la ruta es nula, no se muestra ninguna imagen
                    System.err.println("No se encontró una ruta válida para la imagen.");
                }
            } else {
                // Si no es un ImageIcon, dejamos la imagen vacía
                this.txtFoto.setIcon(null);
                System.err.println("La celda seleccionada no contiene una imagen válida.");
            }
        }
    }//GEN-LAST:event_tablaAlumnoMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        DAOAlumnosImplementacion dao_alumno = new DAOAlumnosImplementacion();
        Alumno alumno = new Alumno();
        try {
            int id = obtenerIdDesdeCampo();
            if (id == -1) {
                return;
            }
            alumno.setId_alumno(id);
            boolean eliminado = dao_alumno.eliminar(alumno, this.valorCorreo);
            if (eliminado) {
                cargarTablaBien();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Alumno registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "El registro no fue encontrado o no se pudo eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException e) {
            // Capturar cualquier otro error inesperado
            JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar el registro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboCalle;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAlumno;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JLabel txtEdad;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JLabel txtFoto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre1;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaBien() {
        final String[] COLUMNAS = {"ID", "nombre","Apellido", "Fecha Nac", "Dirección", "Correo", "foto"};
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);

        try {
            DAOAlumnosImplementacion dao_alumno = new DAOAlumnosImplementacion();
            List<Alumno> alumnoList = dao_alumno.listaCompleto();

            for (Alumno dato : alumnoList) {
                List<Object> fila = new ArrayList<>();
                fila.add(dato.getId_alumno());
                fila.add(dato.getNombre());
                fila.add(dato.getApellido());

                String fechaMostrar = Utilidades.formatearFecha(dato.getFecha_nacimiento());
                fila.add(fechaMostrar);
                fila.add(dato.getDireccion());
                fila.add(dato.getCorreo_electronico());

                String rutaImagen = dato.getFoto_alumno();
                ImageIcon icon = cargarImagen(rutaImagen, 35, 35);
                if (icon != null) {
                    icon.setDescription(rutaImagen); // Almacenamos la ruta en el ImageIcon
                }
                fila.add(icon != null ? icon : null);

                modelo.addRow(fila.toArray());
            }//end for
            tablaAlumno.setRowHeight(40);
            this.tablaAlumno.setModel(modelo);
            asignarRenderizadorDeImagen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los administradores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asignarRenderizadorDeImagen() {
        tablaAlumno.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
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

    private ImageIcon cargarImagen(String nombreImagen, int ancho, int alto) {
        ImageIcon icon = null;
        try {
            String rutaImagen = nombreImagen;
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
                    System.out.println("Imagen por defecto cargada");
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

    private void cargarImagen(JLabel label, String ruta, int ancho, int alto) {
        try {
            // Acceder a los recursos con ClassLoader y obtener la URL de la imagen
            URL imageUrl = getClass().getClassLoader().getResource(ruta);  // Usamos ruta relativa sin 'src/main/resources'

            if (imageUrl != null) {
                // Si la imagen es encontrada, cargamos y escalamos la imagen
                ImageIcon icon = new ImageIcon(imageUrl);
                Image img = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(img);
                label.setIcon(scaledIcon);
            } else {
                // Si no se encuentra la imagen, mostramos un mensaje de error
                System.err.println("No se encontró el archivo en la ruta: " + ruta);
                label.setIcon(null);  // En caso de error, limpiamos el icono
            }
        } catch (Exception e) {
            // Capturamos cualquier excepción y mostramos el mensaje
            System.err.println("Error al cargar la imagen: " + e.getMessage());
            label.setIcon(null);  // En caso de error, limpiamos el icono
        }
    }

    private void limpiarCampos() {
        this.txtId.setText("");
        this.txtNombre1.setText("");
        this.txtApellido.setText("");
        this.txtFecha.setDate(null);
        ComboCalle.setSelectedIndex(0);
        this.txtDireccion.setText("");
        this.txtCorreo.setText("");
        this.txtBuscar.setText("");
        this.txtEdad.setVisible(false);
        try {
            cargarImagen(this.txtFoto, "fondo.jpg", 110, 157);
        } catch (NullPointerException e) {
            System.err.println("Imagen por defecto no encontrada");
            this.txtFoto.setIcon(null);
        }
        this.path2 = null;
        this.txtFoto.repaint();
    }

    private void actualizarTabla(List<Alumno> lista) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaAlumno.getModel();
        modelo.setRowCount(0);// Limpiar la tabla
        ImageIcon icono = null;
        for (Alumno alum : lista) {
            if (alum.getFoto_alumno() != null && !alum.getFoto_alumno().isEmpty()) {
                icono = cargarImagen1(alum.getFoto_alumno());
            } else {
                icono = cargarImagen1("default.jpg");
            }
            String fechaFormateada = Utilidades.formatearFecha(alum.getFecha_nacimiento());
            modelo.addRow(new Object[]{
                alum.getId_alumno(),
                alum.getNombre(),
                alum.getApellido(),
                fechaFormateada,
                alum.getDireccion(),
                alum.getCorreo_electronico(),
                icono
            });
        }
        this.tablaAlumno.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
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

    private ImageIcon cargarImagen1(String rutaRelativa) {
        ImageIcon icono = null;
        // Si la ruta de la imagen no es nula ni vacía
        if (rutaRelativa != null && !rutaRelativa.isEmpty()) {
            URL imageUrl = getClass().getClassLoader().getResource(rutaRelativa);
            if (imageUrl != null) {
                icono = new ImageIcon(new ImageIcon(imageUrl).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
                icono.setDescription(rutaRelativa);
               // System.out.println("Imagen cargada desde el recurso: " + imageUrl);
            } else {
                System.out.println("La imagen no existe en los recursos: " + rutaRelativa);
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

    private int obtenerIdDesdeCampo() {
        String idTxt = this.txtId.getText().trim();
        if (idTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        try {
            return Integer.parseInt(idTxt);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Manejo de error en caso de formato incorrecto
        }

    }

}
