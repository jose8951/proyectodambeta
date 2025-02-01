package views.paneles1;

import dao.DAOAlumnosImplementacion;
import dao.DAOCursoMatriculaImplementacion;
import dao.DAOEvaluacionImplementacion;
import dao.DAOMatriculasImplementacion;
import java.awt.Color;

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
import models.CursoMatricula;
import models.Evaluacion;
import models.Matricula;
import models.Profesor;

public class Panel8 extends javax.swing.JPanel {

    String valorCorro = null;

    public Panel8(String correo) {
        initComponents();
        cargarTablaBien();
        btnModificar.setEnabled(false);
        btnInsertar.setEnabled(false);
        jCheckEstado.setEnabled(false);

        this.valorCorro = correo;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNotas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        buscartexto = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        txtNota = new javax.swing.JTextField();
        txtComentario = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        jCheckEstado = new javax.swing.JCheckBox();
        btnElinarModulo = new javax.swing.JButton();
        txtMatriculaId = new javax.swing.JLabel();
        txtProfesorId = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(557, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaNotas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaNotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaNotas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 369));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscartexto.setText("Buscar nombre o matricula:");
        jPanel2.add(buscartexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel2.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 22, 90, 30));
        jPanel2.add(txtNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 50, -1));
        jPanel2.add(txtComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 220, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 120, -1));

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        jPanel2.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 120, -1));

        jCheckEstado.setText("Estado");
        jPanel2.add(jCheckEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, -1));

        btnElinarModulo.setText("Eliminar modulo");
        btnElinarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElinarModuloActionPerformed(evt);
            }
        });
        jPanel2.add(btnElinarModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 120, -1));
        jPanel2.add(txtMatriculaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 50, 20));
        jPanel2.add(txtProfesorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 50, 20));

        btnLimpiar.setText("B");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 50, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 375, 510, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String buscar = this.txtBuscar.getText().trim();

        if (buscar.isEmpty()) {
            this.cargarTablaBien();
            return;
        }
        try {
            DAOAlumnosImplementacion dao_buscar_nota = new DAOAlumnosImplementacion();
            List<Alumno> listaNota = dao_buscar_nota.listaEvaluacionNota(buscar);
            actualizarTabla(listaNota);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al realizar la búsqueda: " + e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    int[] ids = new int[3];

    private void tablaNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaNotasMouseClicked
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            int idAlumno = -1, idProfesor = -1;
            float nota = 0.0f;
            String comentario = "";

            Object valorAlumnoId = receptor.getModel().getValueAt(receptor.getSelectedRow(), 0);
            if (valorAlumnoId != null) {
                try {
                    ids[0] = Integer.parseInt(valorAlumnoId.toString().trim());
                } catch (NumberFormatException ex) {
                    System.out.println("El valor de ProfesorID no es un número válido: " + ex.getMessage());
                    ids[0] = -1;
                }
            } else {
                System.out.println("El campo ProfesorID está vacío o es null.");
                ids[0] = -1;
            }

            Object valorNota = receptor.getModel().getValueAt(receptor.getSelectedRow(), 4);
            if (valorNota != null) {
                try {
                    nota = Float.parseFloat(valorNota.toString().trim());
                    this.txtNota.setText(String.valueOf(nota));
                } catch (NumberFormatException ex) {
                    // Mostrar mensaje si el valor no es numérico
                    JOptionPane.showMessageDialog(this,
                            "Error al convertir el valor de la nota: " + valorNota + " no es un número válido.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    this.txtNota.setText(""); // Limpiar el campo de texto
                }
            } else {
                // Si el valor es null, manejarlo adecuadamente
                System.out.println("La columna 'nota' contiene un valor null o vacío.");
                this.txtNota.setText("0.00"); // Valor predeterminado para notas nulas
            }

            Object valorComentario = receptor.getModel().getValueAt(receptor.getSelectedRow(), 5);
            if (valorComentario != null) {
                comentario = valorComentario.toString().trim();
                this.txtComentario.setText(comentario);
                this.btnModificar.setEnabled(true);
                this.btnInsertar.setEnabled(false);
                this.jCheckEstado.setEnabled(true);
            } else {
                // Si el comentario es null, limpiar el campo
                this.btnInsertar.setEnabled(true);
                this.btnModificar.setEnabled(false);
                this.jCheckEstado.setEnabled(false);
                this.txtComentario.setText("");
            }

            Object valorProfesorId = receptor.getModel().getValueAt(receptor.getSelectedRow(), 6);
            if (valorProfesorId != null) {
                try {
                    ids[1] = Integer.parseInt(valorProfesorId.toString().trim());
                    this.txtProfesorId.setText(String.valueOf(ids[1]));
                } catch (NumberFormatException ex) {
                    System.out.println("El valor de ProfesorID no es un número válido: " + ex.getMessage());
                    ids[1] = -1;
                }
            } else {
                System.out.println("El campo ProfesorID está vacío o es null.");
                ids[1] = -1;
            }

            Object valorMatricualId = receptor.getModel().getValueAt(receptor.getSelectedRow(), 8);
            if (valorMatricualId != null) {
                try {
                    ids[2] = Integer.parseInt(valorMatricualId.toString().trim());
                    this.txtMatriculaId.setText(String.valueOf(ids[2]));
                } catch (NumberFormatException ex) {
                    System.out.println("El valor de matricualId no es un número válido: " + ex.getMessage());
                    ids[2] = -1;
                }
            } else {
                System.out.println("El campo ProfesorID está vacío o es null.");
                ids[1] = -1;
            }

            Object valorCheckEstado = receptor.getModel().getValueAt(receptor.getSelectedRow(), 9);
            if (valorCheckEstado != null) {
                if (valorCheckEstado.equals("Inactiva")) {
                    this.jCheckEstado.setSelected(false);
                } else if (valorCheckEstado.equals("Activa")) {
                    this.jCheckEstado.setSelected(true);
                }
            }

        }
    }//GEN-LAST:event_tablaNotasMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        DAOEvaluacionImplementacion dao_evaluacion = new DAOEvaluacionImplementacion();
        DAOMatriculasImplementacion dao_matricula = new DAOMatriculasImplementacion();

        Alumno alumno = new Alumno();
        Profesor profesor = new Profesor();
        Evaluacion evaluacion = new Evaluacion();
        Matricula matricula = new Matricula();

        if (ids[0] == -1 || ids[1] == -1 || ids[2] == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila válida antes de modificar la evaluación.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Asignar IDs al alumno y profesor
        alumno.setId_alumno(ids[0]);
        profesor.setId_profesor(ids[1]);
        evaluacion.setAlumno(alumno);
        evaluacion.setProfesor(profesor);

        // Asignar IDs al alumno y matricual
        matricula.setId_alumno(ids[0]);
        matricula.setId_matricula(ids[2]);
        boolean estadoActivo = this.jCheckEstado.isSelected();
        matricula.setEstado(estadoActivo ? "Activa" : "Inactiva");

        // Validar y asignar la nota
        try {
            float laNota = Float.parseFloat(this.txtNota.getText().trim());
            evaluacion.setNota(laNota);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La nota debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si hay un error
        }

        evaluacion.setComentarios(this.txtComentario.getText());
        evaluacion.setFecha_evaluacion(new java.util.Date());

        try {
            boolean exitoNotas = dao_evaluacion.modificarNotas(evaluacion);
            boolean exitoEstado = dao_matricula.modificarEstado(matricula);
            if (exitoNotas && exitoEstado) {
               // this.cargarTablaBien();   
                 List<Alumno> arrayCorta = dao_evaluacion.listadoCortoNotas(this.txtMatriculaId.getText());
                actualizarTabla(arrayCorta);
                JOptionPane.showMessageDialog(this, "Evaluación modificado exitosamente.");
            }
        } catch (Exception ex) { // Cualquier otro error inesperado
            JOptionPane.showMessageDialog(this, "Error al modificar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        // Específico para errores SQL

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        DAOEvaluacionImplementacion dao_eva = new DAOEvaluacionImplementacion();
        Evaluacion eva = new Evaluacion();
        Alumno alumno = new Alumno();
        Profesor profesor = new Profesor();

        if (ids[0] == -1 || ids[1] == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila válida antes de modificar la evaluación.",
                    "Error", JOptionPane.ERROR_MESSAGE);
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

        alumno.setId_alumno(ids[0]);
        profesor.setId_profesor(ids[1]);

        eva.setAlumno(alumno);
        eva.setProfesor(profesor);
        eva.setFecha_evaluacion(fechaUtil);
        eva.setNota(nota);
        eva.setComentarios(comentario);

        try {
            boolean exito = dao_eva.insertarNota(eva);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Datos agregados exitosamente.");
               // cargarTablaBien();
                List<Alumno> arrayCorta = dao_eva.listadoCortoNotas(this.txtMatriculaId.getText());
                actualizarTabla(arrayCorta);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnElinarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElinarModuloActionPerformed
        DAOCursoMatriculaImplementacion dao_curso_matricula = new DAOCursoMatriculaImplementacion();
        Matricula matricula = new Matricula();
        Profesor profesor = new Profesor();
        CursoMatricula cursoMatricula = new CursoMatricula();

        if (ids[0] == -1 || ids[1] == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila válida antes de borrar la evaluación.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cursoMatricula.setId_profesor(ids[1]);
        cursoMatricula.setId_matricual(ids[2]);

        boolean exito = dao_curso_matricula.eliminarModuloProfesor(cursoMatricula, this.valorCorro);
        System.out.println("exito " + exito);

        if (exito) {
            JOptionPane.showMessageDialog(this, "el modulo con la matricula " + ids[2] + " fue eliminado exitosamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Opcional: recargar tabla o interfaz para reflejar los cambios
            cargarTablaBien();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el modulo con ID " + ids[2] + ". Verifica si existe en la base de datos.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnElinarModuloActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
        cargarTablaBien();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElinarModulo;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel buscartexto;
    private javax.swing.JCheckBox jCheckEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaNotas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtComentario;
    private javax.swing.JLabel txtMatriculaId;
    private javax.swing.JTextField txtNota;
    private javax.swing.JLabel txtProfesorId;
    // End of variables declaration//GEN-END:variables

    public void cargarTablaBien() {
        final String[] COLUMNAS = {"id_alu", "nombre", "foto", "especialidad", "nota", "comentarios", "id_pro", "profesor", "id_matricula", "estado"};//9
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);

        try {
            DAOAlumnosImplementacion dao_alu = new DAOAlumnosImplementacion();
            List<Alumno> evaList = dao_alu.listaEvaluacionNota();

            for (Alumno dato : evaList) {
                Object[] fila = new Object[10];
                fila[0] = dato.getId_alumno();
                fila[1] = dato.getNombre();
                String rutaImagen1 = dato.getFoto_alumno();
                ImageIcon icon = cargarImagen(rutaImagen1, 35, 35);
                fila[2] = (icon != null) ? icon : "Sin imagen";
                fila[3] = dato.getProfesor().getEspecialidad();
                fila[4] = dato.getEvaluacion() != null ? dato.getEvaluacion().getNota() : null;
                fila[5] = dato.getEvaluacion().getComentarios();
                fila[6] = dato.getProfesor().getId_profesor();
                fila[7] = dato.getProfesor().getNombre();
                fila[8] = dato.getMatricula().getId_matricula();
                fila[9] = dato.getMatricula().getEstado();

                modelo.addRow(fila);
            }
            this.tablaNotas.setRowHeight(40);
            this.tablaNotas.setModel(modelo);
            asignarRenderizadorDeImagen();

            this.tablaNotas.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus,
                        int row, int column) {
                    // Llama al renderizador base
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    // Verifica si el valor es un número
                    if (value instanceof Number) {
                        float nota = ((Number) value).floatValue();

                        // Cambia el color del texto según la nota
                        if (nota >= 5) {
                            setForeground(new Color(0, 128, 0)); // Verde para notas >= 5
                        } else {
                            setForeground(Color.RED); // Rojo para notas < 5
                        }
                    } else {
                        // Si el valor no es un número, usa el color de texto predeterminado
                        setForeground(table.getForeground());
                    }

                    // Mantiene los colores de selección
                    if (isSelected) {
                        setBackground(table.getSelectionBackground());
                        setForeground(table.getSelectionForeground());
                    } else {
                        setBackground(table.getBackground()); // Fondo por defecto
                    }
                    return c;
                }
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las notas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void asignarRenderizadorDeImagen() {
        tablaNotas.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
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

    private void actualizarTabla(List<Alumno> listaNota) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaNotas.getModel();
        modelo.setRowCount(0);
        ImageIcon icono = null;
        for (Alumno dato : listaNota) {
            if (dato.getFoto_alumno() != null && !dato.getFoto_alumno().isEmpty()) {
                icono = cargarImagen1(dato.getFoto_alumno());
            } else {
                icono = cargarImagen1("default.jpg");
            }
            modelo.addRow(new Object[]{
                dato.getId_alumno(),
                dato.getNombre(),
                icono,
                dato.getProfesor().getEspecialidad(),
                dato.getEvaluacion().getNota(),
                dato.getEvaluacion().getComentarios(),
                dato.getProfesor().getId_profesor(),
                dato.getProfesor().getNombre(),
                dato.getMatricula().getId_matricula(),
                dato.getMatricula().getEstado()
            //dato.getEvaluacion().getComentarios()
            });
        }
        this.tablaNotas.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
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

    private void limpiarCampos() {
        this.txtBuscar.setText("");
        this.txtNota.setText("");
        this.txtComentario.setText("");
        this.txtProfesorId.setText("");
        this.txtMatriculaId.setText("");
        this.jCheckEstado.setSelected(false);
        
    }

}
