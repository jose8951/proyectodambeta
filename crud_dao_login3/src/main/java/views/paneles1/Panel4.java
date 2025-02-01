package views.paneles1;

import dao.DAOProfesoresImplementacion;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
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
import models.Profesor;

public class Panel4 extends javax.swing.JPanel {

    String path2 = null;
    String valorCorreo = null;

    public Panel4(String correo) {
        initComponents();
        this.setPreferredSize(new java.awt.Dimension(557, 580));

        cargarTablaBien();
        System.out.println("este es el panel4");

        this.comboEspecia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Seleccione un modulo", "Sistemas informáticos", "Bases de Datos", "Programación",
            "Lenguajes de marcas", "Entornos de desarrollo",
            "orientación laboral", "Acceso a datos",
            "Desarrollo de interfaces", "dispositivos móviles"
        }));
        this.add(comboEspecia);
        if (correo == null || correo.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }
        valorCorreo = correo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProfesores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboEspecia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImagen = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFoto = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(557, 580));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(557, 580));

        tablaProfesores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tablaProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProfesoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProfesores);

        jLabel1.setText("Id:");

        txtId.setEditable(false);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Especialidad: ");

        comboEspecia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Correo:");

        jLabel5.setText("Telefono:");

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

        btnImagen.setText("Imagen");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImagen)
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnInsertar)
                .addGap(28, 28, 28)
                .addComponent(btnModificar)
                .addGap(34, 34, 34)
                .addComponent(btnEliminar)
                .addGap(26, 26, 26)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnImagen)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnInsertar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFoto.setPreferredSize(new java.awt.Dimension(110, 157));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa1.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboEspecia, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboEspecia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProfesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProfesoresMouseClicked
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            this.txtId.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            this.txtNombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            String valorComboBox = receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString();
            this.comboEspecia.setSelectedItem(valorComboBox);
            this.txtCorreo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            this.txtTelefono.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());

            Object valorImagen = receptor.getModel().getValueAt(receptor.getSelectedRow(), 5);
            if (valorImagen instanceof ImageIcon) {
                ImageIcon originalIcon = (ImageIcon) valorImagen;
                System.out.println("mi tabla " + originalIcon.getDescription());
                String rutaImagen = originalIcon.getDescription();

                if (rutaImagen != null && !rutaImagen.isEmpty()) {
                    cargarImagen(this.txtFoto, rutaImagen, 110, 157);
                    System.err.println("Imagen original cargada: " + rutaImagen);
                    path2 = rutaImagen;
                } else {
                    this.txtFoto.setIcon(null);
                    System.err.println("No se encontró imagen original, se dejó vacío.");
                }
            } else {
                this.txtFoto.setIcon(null);
                System.err.println("La celda de la tabla no contenía una imagen válida.");
            }
        }
    }//GEN-LAST:event_tablaProfesoresMouseClicked

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        DAOProfesoresImplementacion dao_pro = new DAOProfesoresImplementacion();
        Profesor pro = new Profesor();

        String nombre = this.txtNombre.getText().trim();
        String correo = this.txtCorreo.getText().trim();
        String telefono = this.txtTelefono.getText().trim();
        int posicionSeleccionada = comboEspecia.getSelectedIndex();

        if (nombre.isEmpty() || correo.trim().isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "complete todos los campos requeridos");
            return;
        }

        if (posicionSeleccionada == 0) {
            JOptionPane.showMessageDialog(null, "Hay que seleccionar un dato del combo");
            return;
        }

        if (!utils.Utilidades.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un correo válido.", "Correo inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un teléfono válido.", "Correo inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        pro.setNombre(nombre);
        pro.setCorreo_electronico(correo);
        pro.setTelefono(telefono);
        pro.setEspecialidad(comboEspecia.getSelectedItem().toString());
        pro.setFoto_profesor(path2);

        try {
            boolean exito = dao_pro.insertar(pro);
            if (exito) {
                cargarTablaBien();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Alumno registrado exitosamente.");
            }

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        JFileChooser chooser = new JFileChooser();
        // Obtiene el directorio del proyecto
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
        chooser.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png", "jpeg"));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
            try {
                // Verificar archivo seleccionado
                if (!selectedFile.canRead()) {
                    JOptionPane.showMessageDialog(this, "El archivo no es legible.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Extraer solo el nombre del archivo
                String fileName = selectedFile.getName();
                //System.out.println("nombre del archivo " + fileName);
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
    }//GEN-LAST:event_btnImagenActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        DAOProfesoresImplementacion dao_pro = new DAOProfesoresImplementacion();
        Profesor pro = new Profesor();

        int id;
        String nombre = this.txtNombre.getText().trim();
        String correo = this.txtCorreo.getText().trim();
        String telefono = this.txtTelefono.getText().trim();
        int posicionSeleccionada = comboEspecia.getSelectedIndex();

        if (nombre.isEmpty() || correo.trim().isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "complete todos los campos requeridos");
            return;
        }

        if (posicionSeleccionada == 0) {
            JOptionPane.showMessageDialog(null, "Hay que seleccionar un dato del combo");
            return;
        }

        if (!utils.Utilidades.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un correo válido.", "Correo inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un teléfono válido.", "Correo inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            id = Integer.parseInt(txtId.getText().trim());
        } catch (NumberFormatException es) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
            return;
        }
        System.out.println("valor de path2 " + path2);

        // Validar la imagen seleccionada
        if (path2 == null || path2.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna imagen.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        pro.setId_profesor(id);
        pro.setNombre(nombre);
        pro.setEspecialidad(comboEspecia.getSelectedItem().toString());
        pro.setCorreo_electronico(correo);
        pro.setTelefono(telefono);
        pro.setFoto_profesor(path2);

        try {
            boolean exito = dao_pro.modificar(pro);
            if (exito) {
                cargarTablaBien();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "profesor modificado exitosamente.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el registro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DAOProfesoresImplementacion dao_profesor = new DAOProfesoresImplementacion();
        Profesor profesor = new Profesor();

        try {
            int id = obtenerIdDesdeCampo();
            if (id == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un profesor válido para eliminar.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            profesor.setId_profesor(id);
            boolean exito = dao_profesor.eliminar(profesor, this.valorCorreo);
            if (exito) {
                JOptionPane.showMessageDialog(this, "El profesor con ID " + id + " fue eliminado exitosamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Opcional: recargar tabla o interfaz para reflejar los cambios
                cargarTablaBien();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el profesor con ID " + id + ". Verifica si existe en la base de datos.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar el registro: "
                    + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String nombre = txtBuscar.getText().trim();
        if (nombre.isEmpty()) {
            // Si el campo está vacío, puedes limpiar la tabla o mostrar todos los registros
            this.cargarTablaBien();
            return;
        }
        try {
            DAOProfesoresImplementacion dao_profesor = new DAOProfesoresImplementacion();
            List<Profesor> listaProfesor = dao_profesor.buscarNombre(nombre);
            actualizarTabla(listaProfesor);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al realizar la búsqueda: " + ex.getMessage());
        }

    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboEspecia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProfesores;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JLabel txtFoto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void cargarTablaBien() {
        final String[] COLUMNAS = {"ID", "nombre", "Especialidad", "Correo", "Télefono", "foto"};
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);

        try {
            DAOProfesoresImplementacion dao_profesor = new DAOProfesoresImplementacion();
            List<Profesor> profeList = dao_profesor.listaCompleto();

            for (Profesor dato : profeList) {
                List<Object> fila = new ArrayList<>();
                fila.add(dato.getId_profesor());
                fila.add(dato.getNombre());
                fila.add(dato.getEspecialidad());
                fila.add(dato.getCorreo_electronico());
                fila.add(dato.getTelefono());

                String rutaImagen = dato.getFoto_profesor();
                ImageIcon icon = cargarImagen(rutaImagen, 35, 35);
                if (icon != null) {
                    // Almacenamos la ruta en el ImageIcon
                    icon.setDescription(rutaImagen);
                }
                fila.add(icon != null ? icon : null);
                modelo.addRow(fila.toArray());
            }

            this.tablaProfesores.setRowHeight(40);
            this.tablaProfesores.setModel(modelo);
            asignarRenderizadorDeImagen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los profesores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void asignarRenderizadorDeImagen() {
        tablaProfesores.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
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
                //System.out.println("Imagen cargada: " + rutaImagen);
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

    /**
     * Método para cargar una imagen en un JLabel
     *
     * @param label
     * @param ruta
     * @param ancho
     * @param alto
     */
    private void cargarImagen(JLabel label, String ruta, int ancho, int alto) {
        try {
            // Usamos ruta relativa sin 'src/main/resources'
            URL imageUrl = getClass().getClassLoader().getResource(ruta);
            if (imageUrl != null) {
                // Si la imagen es encontrada, cargamos y escalamos la imagen
                ImageIcon icon = new ImageIcon(imageUrl);
                Image img = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(img);
                label.setIcon(scaledIcon);
            } else {
                // Si no se encuentra la imagen, mostramos un mensaje de error
                System.err.println("No se encontró el archivo en la ruta: " + ruta);
                label.setIcon(null);
            }
        } catch (Exception e) {
            // Capturamos cualquier excepción y mostramos el mensaje
            System.err.println("Error al cargar la imagen: " + e.getMessage());
            label.setIcon(null);  // En caso de error, limpiamos el icono
        }
    }

    private boolean validarTelefono(String telefono) {
        String regex = "^\\d{9}$";
        return telefono.trim().matches(regex);
    }

    private void limpiarCampos() {
        this.txtId.setText("");
        this.txtNombre.setText("");
        this.comboEspecia.setSelectedIndex(0);
        this.txtCorreo.setText("");
        this.txtTelefono.setText("");
        this.txtBuscar.setText("");
        // Cargar una imagen por defecto en el campo de la foto
        cargarImagen(this.txtFoto, "fondo.jpg", 110, 157);
        // Restablecer variables auxiliares
        this.path2 = null;
        // Actualizar el componente gráfico
        this.txtFoto.repaint();
        cargarTablaBien();
    }

    private int obtenerIdDesdeCampo() {
        String idTxt = this.txtId.getText().trim();
        if (idTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        try {
            return Integer.parseInt(idTxt);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Manejo de error en caso de formato incorrecto
        }
    }

    private void actualizarTabla(List<Profesor> lista) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaProfesores.getModel();
        modelo.setRowCount(0); // Limpiar la tabla
        ImageIcon icono = null;
        for (Profesor dato : lista) {
            if (dato.getFoto_profesor() != null && !dato.getFoto_profesor().isEmpty()) {
                icono = cargarImagen1(dato.getFoto_profesor());
            } else {
                icono = cargarImagen1("default.jpg");
            }
            modelo.addRow(new Object[]{
                dato.getId_profesor(),
                dato.getNombre(),
                dato.getEspecialidad(),
                dato.getCorreo_electronico(),
                dato.getTelefono(),
                icono
            });
        }
        this.tablaProfesores.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
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

}
