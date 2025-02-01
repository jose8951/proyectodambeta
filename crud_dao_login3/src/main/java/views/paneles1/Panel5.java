package views.paneles1;

import dao.DAOAlumnosImplementacion;
import dao.DAOMatriculasImplementacion;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.Matricula;

public class Panel5 extends javax.swing.JPanel {

    String valorCorreo = null;

    public Panel5(String correo) {

        initComponents();
        this.setPreferredSize(new java.awt.Dimension(557, 580));
        this.valorCorreo = correo;

        cargarTablaBien();  // Carga los datos de la tabla en un hilo separado

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMatricula = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JLabel();
        txtFoto = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        btnMatricula = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        cheEstado = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(557, 580));

        tablaMatricula.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMatriculaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMatricula);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFoto.setPreferredSize(new java.awt.Dimension(110, 157));

        txtId.setPreferredSize(new java.awt.Dimension(50, 50));

        btnMatricula.setText("Crear matricula");
        btnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculaActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatricula)
                    .addComponent(btnLimpiar))
                .addGap(52, 52, 52))
        );

        cheEstado.setText("Estado");

        jLabel1.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnEliminar.setText("Eliminar matricula");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cheEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(cheEstado)
                        .addGap(43, 43, 43)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(btnEliminar)))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DAOAlumnosImplementacion dao_alumno = new DAOAlumnosImplementacion();
       Alumno alumno=new Alumno();
        // Obtener el ID desde el campo correspondiente

        try {
            int id = obtenerIdDesdeCampo();
            if (id == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un profesor válido para eliminar.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
          
            alumno.setId_alumno(id);
            boolean exito = dao_alumno.eliminarMatricula(alumno, this.valorCorreo);
            if (exito) {
                JOptionPane.showMessageDialog(this, "la matricula con ID " + id + " fue eliminado exitosamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Opcional: recargar tabla o interfaz para reflejar los cambios
                cargarTablaBien();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la matricula con ID " + id + ". Verifica si existe en la base de datos.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar el registro: "
                    + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String buscar = txtBuscar.getText().trim();
        if (buscar.isEmpty()) {
            // Si el campo está vacío, puedes limpiar la tabla o mostrar todos los registros
            this.cargarTablaBien();
            return;
        }
        try {
            DAOAlumnosImplementacion dao_alumno = new DAOAlumnosImplementacion();
            List<Alumno> listaAlumno = dao_alumno.noMatriculados(buscar);
            actualizarTabla(listaAlumno);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al realizar la búsqueda: " + e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
        cargarTablaBien();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed
        DAOMatriculasImplementacion dao_matri = new DAOMatriculasImplementacion();
        Matricula matricula = new Matricula();
        // Obtener el ID desde el campo correspondiente
        int id = obtenerIdDesdeCampo();
        // Obtener la fecha actual (LocalDate)
        LocalDate fechaActual = LocalDate.now();
        String mensajeChe = this.cheEstado.isSelected() ? "Activa" : "Inactiva";
        // Convertir LocalDate a java.util.Date
        Date fechaUtil = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Asignar valores a la instancia de Matricula
        matricula.setId_alumno(id);
        matricula.setFecha_matricula(fechaUtil);
        matricula.setEstado(mensajeChe);

        try {
            boolean exito = dao_matri.insertar(matricula);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Matricula registrado exitosamente.");
                cargarTablaBien();
                limpiarCampos();
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMatriculaActionPerformed

    private void tablaMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMatriculaMouseClicked
        if (evt.getClickCount() == 1) {
            // Obtiene la referencia a la tabla
            JTable receptor = (JTable) evt.getSource();

            this.txtId.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            this.txtNombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            Object valorImagen = receptor.getModel().getValueAt(receptor.getSelectedRow(), 3);

            if (valorImagen instanceof ImageIcon) {
                ImageIcon originalIcon = (ImageIcon) valorImagen;
                // System.out.println("mi tabla " + originalIcon.getDescription());
                String rutaImagen = originalIcon.getDescription();

                if (rutaImagen != null && !rutaImagen.isEmpty()) {
                    cargarImagen(txtFoto, rutaImagen, 110, 157);
                    // System.err.println("Imagen original cargada: " + rutaImagen);
                    // System.out.println("valor de id " + this.txtId);
                } else {
                    this.txtFoto.setIcon(null);
                    System.err.println("No se encontró imagen original, se dejó vacío.");
                }
            } else {
                this.txtFoto.setIcon(null);
                System.err.println("La celda de la tabla no contenía una imagen válida.");
            }
        }
    }//GEN-LAST:event_tablaMatriculaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JCheckBox cheEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMatricula;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel txtFoto;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables

    public void cargarTablaBien() {
        final String[] COLUMNAS = {"id_alumno", "Nombre ", "Apellido", "Foto"};
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);
        try {
            DAOAlumnosImplementacion dao_alumno = new DAOAlumnosImplementacion();
            List<Alumno> alumnoList = dao_alumno.noMatriculados();

            for (Alumno dato : alumnoList) {
                List<Object> fila = new ArrayList<>();
                //fila.add(dato.getMatricula().getId_matricula());
                fila.add(dato.getId_alumno());
                fila.add(dato.getNombre());
                fila.add(dato.getApellido());
                String rutaImagen = dato.getFoto_alumno();
                ImageIcon icon = cargarImagen(rutaImagen, 35, 35);
                if (icon != null) {
                    icon.setDescription(rutaImagen);
                }
                fila.add(icon != null ? icon : null);
                modelo.addRow(fila.toArray());
            }
            tablaMatricula.setRowHeight(40);
            this.tablaMatricula.setModel(modelo);
            asignarRenderizadorDeImagen();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los administradores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asignarRenderizadorDeImagen() {
        tablaMatricula.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
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
                //System.out.println("Imagen cargada: " + rutaImagen);
            } else {
                // Si la imagen no existe, usar la imagen por defecto
                URL defaultImageUrl = getClass().getClassLoader().getResource("default.jpg");
                if (defaultImageUrl != null) {
                    icon = new ImageIcon(defaultImageUrl);
                    icon.setDescription("default.jpg");
                    //System.out.println("Imagen por defecto cargada");
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
                label.setIcon(null);  // En caso de error, limpiamos el icono
            }
        } catch (Exception e) {
            // Capturamos cualquier excepción y mostramos el mensaje
            System.err.println("Error al cargar la imagen: " + e.getMessage());
            label.setIcon(null);  // En caso de error, limpiamos el icono
        }
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

    private void actualizarTabla(List<Alumno> lista) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaMatricula.getModel();
        modelo.setRowCount(0);
        ImageIcon icono = null;
        for (Alumno alum : lista) {
            if (alum.getFoto_alumno() != null && !alum.getFoto_alumno().isEmpty()) {
                icono = cargarImagen1(alum.getFoto_alumno());
            } else {
                icono = cargarImagen1("default.jpg");
            }
            modelo.addRow(new Object[]{
                alum.getId_alumno(),
                alum.getNombre(),
                alum.getApellido(),
                icono
            });
        }
        this.tablaMatricula.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
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
        if (rutaRelativa != null && !rutaRelativa.isEmpty()) {
            URL imageUrl = getClass().getClassLoader().getResource(rutaRelativa);
            if (imageUrl != null) {
                icono = new ImageIcon(new ImageIcon(imageUrl).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
                icono.setDescription(rutaRelativa);
                //System.out.println("Imagen cargada desde el recurso: " + imageUrl);
            } else {
                //System.out.println("La imagen no existe en los recursos: " + rutaRelativa);
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

    private void limpiarCampos() {
        this.txtId.setText("");
        this.txtNombre.setText("");
        this.txtBuscar.setText("");
        try {
            cargarImagen(this.txtFoto, "fondo.jpg", 110, 157);
        } catch (NullPointerException e) {
            System.err.println("Imagen por defecto no encontrada");
            this.txtFoto.setIcon(null);
        }
        this.txtFoto.repaint();
    }
}
