package views.paneles1;

import dao.DAOAlumnosImplementacion;
import dao.DAOEvaluacionImplementacion;
import dao.DAOProfesoresImplementacion;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.Evaluacion;
import models.Profesor;

public class Panel7 extends javax.swing.JPanel {

    String valorCorro = null;

    public Panel7(String correo) {
        initComponents();
        cargarTablaBien();
        cargarComboAlumno();
        cargarComboProfesor();
        this.valorCorro = correo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEvaluacion = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        comboAlumno = new javax.swing.JComboBox<>();
        comboProfesor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        btnInsertarNota = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        tablaEvaluacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tablaEvaluacion.setPreferredSize(new java.awt.Dimension(200, 200));
        tablaEvaluacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEvaluacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEvaluacion);

        comboAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboProfesor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Nota:");

        jLabel2.setText("Comentario");

        btnInsertarNota.setText("Insertar nota");
        btnInsertarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarNotaActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
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
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnInsertarNota)
                                        .addGap(42, 42, 42)
                                        .addComponent(txtBuscar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertarNota)
                    .addComponent(btnModificar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarNotaActionPerformed
        DAOEvaluacionImplementacion dao_eva = new DAOEvaluacionImplementacion();
        Evaluacion eva = new Evaluacion();

        int idAlumno = utils.Utilidades.obtenerIdDesdeCombo(comboAlumno, "alumno");
        int idProfesor = utils.Utilidades.obtenerIdDesdeCombo(comboProfesor, "profesor");

        if (idAlumno == -1) {
            return;
        }
        if (idProfesor == -1) {
            return;
        }

        String laNota = this.txtNota.getText().trim();
        if (laNota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de nota no puede estar vacío.", "Nota inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        float nota = 0;
        try {
            nota = Float.parseFloat(laNota);
            if (nota < 0 || nota > 10) {
                JOptionPane.showMessageDialog(this, "La nota debe estar entre 0 y 10.", "Nota inválida", JOptionPane.WARNING_MESSAGE);
                return; // Salir si la nota no es válida 
            }
        } catch (NumberFormatException e) {
            // Puedes mostrar un mensaje o manejar el error según tu lógica
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido en el campo de matrícula.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String comentario = this.txtComentario.getText().trim();
        Date fechaUtil = utils.Utilidades.obtenerFechaAcutal();

        Alumno alumno = new Alumno();
        alumno.setId_alumno(idAlumno);
        Profesor profesor = new Profesor();
        profesor.setId_profesor(idProfesor);

        eva.setAlumno(alumno);
        eva.setProfesor(profesor);
        eva.setFecha_evaluacion(fechaUtil);
        eva.setNota(nota);
        eva.setComentarios(comentario);

        try {
            boolean exito = dao_eva.insertarNota(eva);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Datos agregados exitosamente.");
                cargarTablaBien();

                limpiarCampos();
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnInsertarNotaActionPerformed
    int idEvaluaciones;
    private void tablaEvaluacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEvaluacionMouseClicked
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            idEvaluaciones = Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            this.txtNota.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString());
            this.txtComentario.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 8).toString());
        }
    }//GEN-LAST:event_tablaEvaluacionMouseClicked


    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        DAOEvaluacionImplementacion dao_eva = new DAOEvaluacionImplementacion();
        Evaluacion eva = new Evaluacion();

        String notaStr = this.txtNota.getText().trim();
        String comentario = this.txtComentario.getText().trim();

        if (notaStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta el campo nota");
            return;
        }

        float nota;
        try {
            nota = Float.parseFloat(notaStr);
            if (nota < 0 || nota > 10) {
                JOptionPane.showMessageDialog(this, "La nota debe estar entre 0 y 10.", "Nota inválida", JOptionPane.WARNING_MESSAGE);
                return; // Salir si la nota no es válida 
            }
        } catch (NumberFormatException es) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.");
            return;
        }
        eva.setId_evaluacion(idEvaluaciones);
        eva.setNota(nota);
        eva.setComentarios(comentario);

        try {
            boolean exito = dao_eva.modificarEvaluaciones(eva);
            if (exito) {
                cargarTablaBien();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Evaluación modificado exitosamente.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el registro: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String buscar = this.txtBuscar.getText().trim();
        if (buscar.isEmpty()) {
            this.cargarTablaBien();
            limpiarCampos();
            return;
        }

        try {
            DAOEvaluacionImplementacion dao_evaluaciones = new DAOEvaluacionImplementacion();
            List<Evaluacion> listaEva = dao_evaluaciones.buscarNombre(buscar);
            actualizarTabla(listaEva);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al realizar la búsqueda: " + e.getMessage());
        }


    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DAOEvaluacionImplementacion dao_evaluaciones = new DAOEvaluacionImplementacion();
        Evaluacion evaluacion = new Evaluacion();
        try {
            // Verificar que el ID sea válido
            if (idEvaluaciones <= 0) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un ID válido para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            evaluacion.setId_evaluacion(idEvaluaciones);
            boolean exito = dao_evaluaciones.eliminarEvaluacion(evaluacion, this.valorCorro);
            if (exito) {
                JOptionPane.showMessageDialog(this, "El profesor con ID " + idEvaluaciones + " fue eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Opcional: recargar tabla o interfaz para reflejar los cambios
                cargarTablaBien();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el profesor con ID " + idEvaluaciones + ". Verifica si existe en la base de datos.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar eliminar la evaluación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertarNota;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboAlumno;
    private javax.swing.JComboBox<String> comboProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEvaluacion;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtComentario;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables

    public void cargarTablaBien() {
        final String[] COLUMNAS = {"Id_alumno", "Alumno", "Apellido", "correo", "foto ", "id", "fecha", "Especialidad"};
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);

        try {
            DAOEvaluacionImplementacion dao_eva = new DAOEvaluacionImplementacion();
            List<Evaluacion> evaList = dao_eva.listaEvaluacion();

            for (Evaluacion dato : evaList) {
                Object[] fila = new Object[8]; // Número de columnas en el modelo
                fila[0] = dato.getAlumno().getId_alumno();
                fila[1] = dato.getAlumno().getNombre();
                fila[2] = dato.getAlumno().getApellido();
                fila[3] = dato.getAlumno().getCorreo_electronico();

                // Manejo de la imagen
                String rutaImagen1 = dato.getAlumno().getFoto_alumno();
                ImageIcon icon = cargarImagen(rutaImagen1, 35, 35);
                fila[4] = (icon != null) ? icon : "Sin imagen";

                fila[5] = dato.getId_evaluacion();
                fila[6] = dato.getFecha_evaluacion();
                fila[7] = dato.getProfesor().getEspecialidad();

                modelo.addRow(fila);
            }

            tablaEvaluacion.setRowHeight(40);
            this.tablaEvaluacion.setModel(modelo);
            asignarRenderizadorDeImagen();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los administradores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asignarRenderizadorDeImagen() {
        tablaEvaluacion.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
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

    private void cargarComboAlumno() {
        List<Alumno> alumList;
        DAOAlumnosImplementacion dao_alum = new DAOAlumnosImplementacion();
        try {
            alumList = dao_alum.noEvaluados();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los alumnos: " + ex.getMessage());
            return;
        }
        if (alumList == null || alumList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron alumnos para cargar.");
            return;
        }
        this.comboAlumno.removeAllItems();
        this.comboAlumno.addItem("Seleccione un alumno");
        for (Alumno dato : alumList) {
            int item1 = dato.getId_alumno();
            String item2 = dato.getNombre();
            String item3 = dato.getApellido();
            String display = item1 + " - " + item2 + " - " + item3;
            this.comboAlumno.addItem(display);
        }

    }

    private void cargarComboProfesor() {
        List<Profesor> profeList;
        DAOProfesoresImplementacion dao_profe = new DAOProfesoresImplementacion();
        try {
            profeList = dao_profe.listaCompleto();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los alumnos: " + ex.getMessage());
            return;
        }
        if (profeList == null || profeList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron alumnos para cargar.");
            return;
        }
        this.comboProfesor.removeAllItems();
        this.comboProfesor.addItem("Seleccione un profesor");
        for (Profesor dato : profeList) {
            int item1 = dato.getId_profesor();
            String item2 = dato.getNombre();
            String item3 = dato.getEspecialidad();
            String display = item1 + " - " + item2 + " - " + item3;
            this.comboProfesor.addItem(display);
        }
    }

    private void limpiarCampos() {
        this.txtNota.setText("");
        this.txtComentario.setText("");
        this.comboAlumno.setSelectedIndex(0);
        this.comboProfesor.setSelectedIndex(0);
    }

    private void actualizarTabla(List<Evaluacion> lista) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaEvaluacion.getModel();
        modelo.setRowCount(0);
        ImageIcon icono = null;
        for (Evaluacion dato : lista) {
            if (dato.getAlumno().getFoto_alumno() != null && !dato.getAlumno().getFoto_alumno().isEmpty()) {
                icono = cargarImagen1(dato.getAlumno().getFoto_alumno());
            } else {
                icono = cargarImagen1("default.jpg");
            }
            modelo.addRow(new Object[]{
                dato.getId_evaluacion(),
                dato.getAlumno().getNombre(),
                icono,
                dato.getProfesor().getNombre(),
                dato.getProfesor().getApellido(),
                dato.getProfesor().getEspecialidad(),
                dato.getFecha_evaluacion(),
                dato.getNota(),
                dato.getComentarios()
            });
        }
        this.tablaEvaluacion.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
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
                // System.out.println("Imagen cargada desde el recurso: " + imageUrl);
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

}
