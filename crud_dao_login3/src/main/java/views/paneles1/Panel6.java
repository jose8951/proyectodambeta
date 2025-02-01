package views.paneles1;

import dao.DAOAlumnosImplementacion;
import dao.DAOCursoMatriculaImplementacion;
import dao.DAOProfesoresImplementacion;
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
import javax.swing.table.TableModel;
import models.Alumno;
import models.CursoMatricula;
import models.Matricula;
import models.Profesor;

public class Panel6 extends javax.swing.JPanel {

    String path2 = null;
    String valorCorreo = null;

    public Panel6(String correo) {
        initComponents();
        cargarTablaBien();

        cargarComboBox();

        this.valorCorreo = correo;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMatriculados = new javax.swing.JTable();
        comboProfesor = new javax.swing.JComboBox<>();
        txtIdMatricual = new javax.swing.JLabel();
        txtFoto = new javax.swing.JLabel();
        btnAgregarProfe = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEspecialidades = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnEliminarEspeci = new javax.swing.JButton();
        txtIdProfesor = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(557, 580));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(557, 580));

        tablaMatriculados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tablaMatriculados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMatriculadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMatriculados);

        comboProfesor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtIdMatricual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFoto.setPreferredSize(new java.awt.Dimension(110, 157));

        btnAgregarProfe.setText("Agregar Profesor");
        btnAgregarProfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProfeActionPerformed(evt);
            }
        });

        tablaEspecialidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id_matricula", "nombre", "especialidad"
            }
        ));
        tablaEspecialidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEspecialidadesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaEspecialidades);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnLimpiar.setText("limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminarEspeci.setText("Borrar especialidad");
        btnEliminarEspeci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEspeciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(comboProfesor, 0, 241, Short.MAX_VALUE))
                    .addComponent(btnEliminarEspeci))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarProfe)
                            .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdMatricual, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(txtIdProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(33, 33, 33)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdMatricual, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIdProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProfe)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEliminarEspeci))
                .addGap(0, 62, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMatriculadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMatriculadosMouseClicked
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            Object valorImagen = receptor.getModel().getValueAt(receptor.getSelectedRow(), 4);

           this.txtIdMatricual.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString());

            if (valorImagen instanceof ImageIcon) {
                ImageIcon originalIcon = (ImageIcon) valorImagen;
                // System.out.println("mi tabla " + originalIcon.getDescription());
                String rutaImagen = originalIcon.getDescription();
                if (rutaImagen != null && !rutaImagen.isEmpty()) {
                    cargarImagen(this.txtFoto, rutaImagen, 110, 157);
                    cargarTablaEspecialidades();
                } else {
                    this.txtFoto.setIcon(null);
                    System.err.println("No se encontró imagen original, se dejó vacío.");
                }
            } else {
                this.txtFoto.setIcon(null);
                System.err.println("La celda de la tabla no contenía una imagen válida.");
            }
        }
    }//GEN-LAST:event_tablaMatriculadosMouseClicked

    private void btnAgregarProfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProfeActionPerformed
        DAOCursoMatriculaImplementacion dao_cm = new DAOCursoMatriculaImplementacion();
        CursoMatricula cm = new CursoMatricula();
        Matricula matricula=new Matricula();
        Profesor profesor=new Profesor();

        String idMatricula = this.txtIdMatricual.getText().trim();
        int idMatriInt = 0;
        try {
            idMatriInt = Integer.parseInt(idMatricula);
        } catch (NumberFormatException e) {
            System.out.println("Error: El valor ingresado no es un número válido.");
            // Puedes mostrar un mensaje o manejar el error según tu lógica
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido en el campo de matrícula.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        int valorCombo = this.comboProfesor.getSelectedIndex();
        if (valorCombo <= 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un profesor en el combo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.txtIdProfesor.setText(String.valueOf(valorCombo));

        // Obtener la fecha actual (LocalDate)
        LocalDate fechaActual = LocalDate.now();
        // Convertir LocalDate a java.util.Date
        Date fechaUtil;
        try {
            fechaUtil = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (Exception ex) {
            throw new RuntimeException("Error al convertir LocalDate a Date: " + ex.getMessage(), ex);
        }
        if (cm == null) {
            throw new IllegalStateException("El objeto cm no ha sido inicializado.");
        }
        
       // profesor.setId_profesor(valorCombo);
       // matricula.setId_matricula(idMatriInt);
               
        cm.setId_matricual(idMatriInt);
        cm.setId_profesor(valorCombo);
        
          
        cm.setFecha(fechaUtil);

        try {
            int resultado = dao_cm.insertar(cm);
            switch (resultado) {
                case 1 -> {
                    this.cargarTablaEspecialidades();
                    JOptionPane.showMessageDialog(null, "La matrícula se registró correctamente.");
                }
                case 2 ->
                    JOptionPane.showMessageDialog(null, "No se pudo registrar la matrícula, por favor verifique.");
                case 3 ->
                    JOptionPane.showMessageDialog(null, "El registro ya existe. No se puede duplicar.");
                case 0 ->
                    JOptionPane.showMessageDialog(null, "Error desconocido. Intente nuevamente.");
                default ->
                    JOptionPane.showMessageDialog(null, "Estado inesperado.");
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarProfeActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String buscar = this.txtBuscar.getText().trim();
        if (buscar.isEmpty()) {
            this.cargarTablaBien();
            return;
        }
        try {
            DAOAlumnosImplementacion dao_alumno = new DAOAlumnosImplementacion();
            List<Alumno> arrayList = dao_alumno.siMatriculados(buscar);
            actualizarTabla(arrayList);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al realizar la búsqueda: " + e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
        cargarTablaBien();
        DefaultTableModel modeloVacio = new DefaultTableModel();
        modeloVacio.setColumnIdentifiers(new String[]{"id_matricula", "nombre", "especialidad"}); // Define tus columnas aquí
        this.tablaEspecialidades.setModel(modeloVacio);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarEspeciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEspeciActionPerformed
        DAOCursoMatriculaImplementacion dao_cm = new DAOCursoMatriculaImplementacion();
        CursoMatricula cm = new CursoMatricula();
        if (this.idVariables.size() == 2) {
            int idMatri = idVariables.get(0);
            int idProfe = idVariables.get(1);
          

            boolean exito = dao_cm.eliminarCursoMatricula(idMatri, idProfe, this.valorCorreo);
            if (exito) {
                JOptionPane.showMessageDialog(this, "la matricula con ID " + idMatri + " fue eliminado exitosamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Opcional: recargar tabla o interfaz para reflejar los cambios
                cargarTablaBien();
                cargarTablaEspecialidades();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la matricula con ID " + idMatri + ". Verifica si existe en la base de datos.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro válido antes de eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnEliminarEspeciActionPerformed

    private List<Integer> idVariables = new ArrayList<>();
    private void tablaEspecialidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEspecialidadesMouseClicked
        if (evt.getClickCount() == 1) {
            int filaSeleccionada = this.tablaEspecialidades.getSelectedRow();
            System.out.println("la fila seleccionada " + filaSeleccionada);
            if (filaSeleccionada != -1) {
                try {
                    TableModel modelo = this.tablaEspecialidades.getModel();
                    int idMatri = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 0).toString());
                    int idProfe = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 3).toString());

                    idVariables.clear();
                    idVariables.add(idMatri);
                    idVariables.add(idProfe);
                    this.txtIdProfesor.setText(String.valueOf("id pro "+idVariables.get(1)));
                    this.txtIdMatricual.setText(String.valueOf(idVariables.get(0)));
                    cargarTablaEspecialidades();
                  
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Error al convertir valores de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_tablaEspecialidadesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProfe;
    private javax.swing.JButton btnEliminarEspeci;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboProfesor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEspecialidades;
    private javax.swing.JTable tablaMatriculados;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel txtFoto;
    private javax.swing.JLabel txtIdMatricual;
    private javax.swing.JLabel txtIdProfesor;
    // End of variables declaration//GEN-END:variables

    public void cargarTablaBien() {
        final String[] COLUMNAS = {"id_alumno", "nombre", "apellido", "correo", "foto", "id_matricula", "Fecha", "estado"};
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);

        try {
            DAOAlumnosImplementacion dao_alumno = new DAOAlumnosImplementacion();
            List<Alumno> arrayList = dao_alumno.siMatriculados();

            for (Alumno dato : arrayList) {
                List<Object> fila = new ArrayList<>();
                fila.add(dato.getId_alumno());
                fila.add(dato.getNombre());
                fila.add(dato.getApellido());
                fila.add(dato.getCorreo_electronico());
                String rutaImagen = dato.getFoto_alumno();
                ImageIcon icon = cargarImagen(rutaImagen, 35, 35);
                if (icon != null) {
                    icon.setDescription(rutaImagen);
                }
                fila.add(icon != null ? icon : null);
                fila.add(dato.getMatricula().getId_matricula());
                fila.add(dato.getMatricula().getFecha_matricula());
                fila.add(dato.getMatricula().getEstado());
                //  fila.add(dato.getProfesor().getNombre());
                //  fila.add(dato.getProfesor().getEspecialidad());

                modelo.addRow(fila.toArray());
            }
            tablaMatriculados.setRowHeight(40);
            this.tablaMatriculados.setModel(modelo);
            asignarRenderizadorDeImagen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los administradores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asignarRenderizadorDeImagen() {
        tablaMatriculados.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
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

    private void cargarComboBox() {
        List<Profesor> profeList;
        // Obtener la lista de profesores desde la base de datos
        DAOProfesoresImplementacion dao_profe = new DAOProfesoresImplementacion();
        try {
            profeList = dao_profe.listaCompleto();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los roles: " + ex.getMessage());
            return;
        }
        // Verificar si la lista está vacía
        if (profeList == null || profeList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron profesores para cargar.");
            return;
        }
        // Limpiar el ComboBox antes de agregar nuevos datos 
        this.comboProfesor.removeAllItems();
        comboProfesor.addItem("Seleccione un profe");
        // Agregar los nombres de los roles al ComboBox
        for (Profesor dato : profeList) {
            int item1 = dato.getId_profesor();
            String item2 = dato.getNombre();
            String item3 = dato.getEspecialidad();
            String display = item1 + " - " + item2 + " - " + item3;
            this.comboProfesor.addItem(display);

        }

    }

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

    private void limpiarCampos() {
        this.txtIdMatricual.setText("");
        this.txtIdProfesor.setText("");
        try {
            cargarImagen(this.txtFoto, "fondo.jpg", 110, 157);
        } catch (NullPointerException e) {
            System.err.println("Imagen por defecto no encontrada");
            this.txtFoto.setIcon(null);
        }
        this.txtFoto.repaint();
        this.comboProfesor.setSelectedIndex(0);
        this.txtBuscar.setText("");

    }

    private void cargarTablaEspecialidades() {
        final String[] COLUMNAS = {"id_matricula", "nombre", "especialidad", "id_profesor"};

        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);
        String textoMatricula = this.txtIdMatricual.getText().trim();
        if (textoMatricula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID de matrícula.");
          
            return; // Salir del método si no hay un ID válido
        }
                int idMatricula = 0;
        try {
            idMatricula = Integer.parseInt(textoMatricula);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "No se encontraron profesores para cargar." + ex.getMessage());
        }
        try {
            DAOProfesoresImplementacion dao_profesores = new DAOProfesoresImplementacion();
            List<Profesor> listProfesor = dao_profesores.verListaEspecialidades(idMatricula);
            for (Profesor dato : listProfesor) {
                List<Object> fila = new ArrayList<>();
              //  fila.add(dato.getCursoMatricula().getId_matricula());
             // fila.add(dato.getCursoMatricula().getMatricula().getId_matricula());
              fila.add(dato.getCursoMatricula().getId_matricual());
                fila.add(dato.getNombre());
                fila.add(dato.getEspecialidad());
                fila.add(dato.getId_profesor());
                modelo.addRow(fila.toArray());
            }
            this.tablaEspecialidades.setModel(modelo);
            tablaEspecialidades.setRowHeight(35);
            ocultarColumnas(this.tablaEspecialidades, 3);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los administradores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla(List<Alumno> arrayList) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaMatriculados.getModel();
        modelo.setRowCount(0);
        ImageIcon icono = null;
        for (Alumno alum : arrayList) {
            if (alum.getFoto_alumno() != null && !alum.getFoto_alumno().isEmpty()) {
                icono = cargarImagen1(alum.getFoto_alumno());
            } else {
                icono = cargarImagen1("default.jpg");
            }
            modelo.addRow(new Object[]{
                alum.getId_alumno(),
                alum.getNombre(),
                alum.getApellido(),
                alum.getCorreo_electronico(),
                icono,
                alum.getMatricula().getId_matricula(),
                alum.getMatricula().getFecha_matricula(),
                alum.getMatricula().getEstado()
            });
        }
        this.tablaMatriculados.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
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

    private void ocultarColumnas(JTable tabla, int indice) {
        tabla.getColumnModel().getColumn(indice).setMinWidth(0);
        tabla.getColumnModel().getColumn(indice).setMaxWidth(0);
        tabla.getColumnModel().getColumn(indice).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(indice).setWidth(0);
    }

}
