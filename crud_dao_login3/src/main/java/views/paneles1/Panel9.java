package views.paneles1;

import dao.DAOAlumnosImplementacion;
import dao.DAOProfesoresImplementacion;
import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.Profesor;
import utils.ImprimirPDF;

public class Panel9 extends javax.swing.JPanel {

    public Panel9(String correo) {
        initComponents();
        camposNoEditables();
        cargarTablaBien();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatosModulos = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDatoAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMatriculaId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        txtFoto = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        bntLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtEdadAlumno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtImporteTotal = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(557, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDatosModulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tablaDatosModulos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 360, 120));

        btnImprimir.setText("Imprimir pdf");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, -1, -1));

        tablaDatoAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        tablaDatoAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatoAlumnosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDatoAlumnos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 557, 120));

        jLabel1.setText("Id matricula:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel1.add(txtMatriculaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 40, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 100, -1));

        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 110, -1));

        jLabel4.setText("Dirección:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 150, -1));

        jLabel5.setText("Estado:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 70, -1));

        txtFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFoto.setPreferredSize(new java.awt.Dimension(110, 157));
        jPanel1.add(txtFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 110, 150));

        correo.setText("Correo:");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 150, -1));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 110, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 180, -1));

        bntLimpiar.setText("limpiar");
        bntLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(bntLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jLabel6.setText("Edad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));
        jPanel1.add(txtEdadAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 40, -1));

        jLabel7.setText("Importe total:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, -1, -1));
        jPanel1.add(txtImporteTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 50, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // Obtener datos de los campos del formulario
        String idMatricula = this.txtMatriculaId.getText().trim();
        String nombre = this.txtNombre.getText().trim();
        String apellido = this.txtApellido.getText().trim();
        String mostrarFecha = utils.Utilidades.mostrarFechaHoraActual();
        String direccion = this.txtDireccion.getText().trim();
        String estado = this.txtEstado.getText().trim();
        String correoAlumno = this.txtCorreo.getText().trim();
        String fechaMatricula = this.txtFecha.getText().trim();
        String diaMatricula = utils.Utilidades.formatearFecha(fechaMatricula);
        String edadAlumno = this.txtEdadAlumno.getText().trim();
        String importeTotal = this.txtImporteTotal.getText().trim();
        
        String fechaFactura= utils.Utilidades.obtenerFechaActual();

        if (idMatricula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error al crear el pdf: ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       

        try {
            String nombreArchivo = nombre + "_" + apellido + "_" + mostrarFecha + ".pdf";
            String[] datos = {idMatricula, nombre, apellido,
                fechaFactura, direccion, estado, correoAlumno,
                diaMatricula, rutaImagenGlobal, edadAlumno, importeTotal};
            ImprimirPDF pdf = new ImprimirPDF(datos, nombreArchivo, arrayEspecialidad);
            // Llamar al método exportarPDF y pasar la ruta donde deseas guardar el archivo PDF
           
            JOptionPane.showMessageDialog(this, "PDF generado exitosamente: " + nombreArchivo, "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            // Manejar errores al generar el PDF
            JOptionPane.showMessageDialog(this, "Error al crear el PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private String rutaImagenGlobal;

    private void tablaDatoAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatoAlumnosMouseClicked
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            // Verificar si el valor no es nulo antes de llamar a toString()
            Object matriculaId = receptor.getModel().getValueAt(receptor.getSelectedRow(), 0);
            this.txtMatriculaId.setText(matriculaId != null ? matriculaId.toString() : "");
            Object nombre = receptor.getModel().getValueAt(receptor.getSelectedRow(), 1);
            this.txtNombre.setText(nombre != null ? nombre.toString() : "");
            Object apellido = receptor.getModel().getValueAt(receptor.getSelectedRow(), 2);
            this.txtApellido.setText(apellido != null ? apellido.toString() : "");
            Object direccion = receptor.getModel().getValueAt(receptor.getSelectedRow(), 3);
            this.txtDireccion.setText(direccion != null ? direccion.toString() : "");
            Object correoAlumno = receptor.getModel().getValueAt(receptor.getSelectedRow(), 4);
            this.txtCorreo.setText(correoAlumno != null ? correoAlumno.toString() : "");
            Object valorImagen = receptor.getModel().getValueAt(receptor.getSelectedRow(), 5);
            if (valorImagen instanceof ImageIcon originalIcon) {
                String rutaImagen = originalIcon.getDescription();
                //System.out.println("Ruta imagen: " + rutaImagen);
                if (rutaImagen != null && !rutaImagen.isEmpty()) {
                    // Asignar la ruta de la imagen a la variable global
                    rutaImagenGlobal = rutaImagen;
                    cargarImagen(this.txtFoto, rutaImagen, 110, 157);
                } else {
                    System.err.println("No se encontró una descripción para la imagen.");
                    this.txtFoto.setIcon(null);
                    rutaImagenGlobal = null;
                }
            } else {
                System.err.println("El valor de la celda no es un ImageIcon válido.");
                this.txtFoto.setIcon(null);
                rutaImagenGlobal = null;
            }
            this.txtFecha.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString());
            this.txtEstado.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString());
            Object importeTotal = receptor.getModel().getValueAt(receptor.getSelectedRow(), 8);
            // Manejar cuando el importe es null o igual a 0
            if (importeTotal == null || importeTotal.toString().equals("0.0")) {
                this.txtImporteTotal.setText("0.00"); // Mostrar un valor predeterminado
                this.btnImprimir.setEnabled(false);
            } else {
                this.btnImprimir.setEnabled(true);
                this.txtImporteTotal.setText(importeTotal.toString());
            }

            String fechaNacimiento = receptor.getModel().getValueAt(receptor.getSelectedRow(), 9).toString();
            int edadAlumno = utils.Utilidades.calcularEdad(fechaNacimiento);
            this.txtEdadAlumno.setText(String.valueOf(edadAlumno));

            cargarTablaModulosProfesores();
        }
    }//GEN-LAST:event_tablaDatoAlumnosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String buscar = this.txtBuscar.getText().trim();
        if (buscar.isEmpty()) {
            this.cargarTablaBien();
            return;
        }
        try {
            DAOAlumnosImplementacion dao_buscarAlumno_pdf = new DAOAlumnosImplementacion();
            List<Alumno> arrayListaPdf = dao_buscarAlumno_pdf.siMatriculados(buscar);
            actualizarTabla(arrayListaPdf);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al realizar la búsqueda: " + e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void bntLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_bntLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLimpiar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaDatoAlumnos;
    private javax.swing.JTable tablaDatosModulos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdadAlumno;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JLabel txtFoto;
    private javax.swing.JTextField txtImporteTotal;
    private javax.swing.JTextField txtMatriculaId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void cargarTablaBien() {
        final String[] COLUMNAS = {"matricula", "nombre", "apellido", "dirección", "correo", "foto", "fecha_mac", "estado", "precio", "nacimiento"};
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);
        try {
            DAOAlumnosImplementacion dao_mostrar_alu = new DAOAlumnosImplementacion();
            List<Alumno> arrayAlum = dao_mostrar_alu.datosPdfMostrar();

            for (Alumno dato : arrayAlum) {
                Object[] fila = new Object[10];
                fila[0] = dato.getMatricula().getId_matricula();
                fila[1] = dato.getNombre();
                fila[2] = dato.getApellido();
                fila[3] = dato.getDireccion();
                fila[4] = dato.getCorreo_electronico();
                String rutaImagen1 = dato.getFoto_alumno();
                ImageIcon icon = cargarImagen(rutaImagen1, 35, 35);
                fila[5] = (icon != null) ? icon : "Sin imagen";
                fila[6] = dato.getMatricula().getFecha_matricula();
                fila[7] = dato.getMatricula().getEstado();
                fila[8] = dato.getFacturas().getPrecio();

                if (dato.getFecha_nacimiento() != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaFormateada = dateFormat.format(dato.getFecha_nacimiento());
                    fila[9] = fechaFormateada;
                } else {
                    fila[9] = "Sin";
                }
                modelo.addRow(fila);
            }
            this.tablaDatoAlumnos.setRowHeight(40);
            this.tablaDatoAlumnos.setModel(modelo);
            asignarRenderizadorDeImagen();

        } catch (Exception e) {
            ImageIcon icon = null;
        }

    }

    private ImageIcon cargarImagen(String ruta, int ancho, int alto) {
        ImageIcon icon = null;

        try {
            URL imageUrl = getClass().getClassLoader().getResource(ruta);
            if (imageUrl != null) {
                icon = new ImageIcon(imageUrl);
                icon.setDescription(ruta);

                // Escalar la imagen al tamaño especificado
                Image img = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(img);
                scaledIcon.setDescription(icon.getDescription()); // Mantener la descripción
                icon = scaledIcon;
            } else {
                // Imagen por defecto
                URL defaultImageUrl = getClass().getClassLoader().getResource("default.jpg");
                if (defaultImageUrl != null) {
                    icon = new ImageIcon(defaultImageUrl);
                    icon.setDescription("default.jpg");

                    // Escalar imagen por defecto
                    Image img = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(img);
                    scaledIcon.setDescription(icon.getDescription());
                    icon = scaledIcon;
                }
            }
        } catch (Exception ex) {
            System.err.println("Error al cargar la imagen: " + ex.getMessage());
        }
        return icon;
    }

    private void asignarRenderizadorDeImagen() {
        tablaDatoAlumnos.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
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

    private void cargarImagen(JLabel foto, String ruta, int ancho, int alto) {
        try {
            // Usamos ruta relativa sin 'src/main/resources'
            URL imageUrl = getClass().getClassLoader().getResource(ruta);
            if (imageUrl != null) {
                // Si la imagen es encontrada, cargamos y escalamos la imagen
                ImageIcon icon = new ImageIcon(imageUrl);
                Image img = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(img);
                foto.setIcon(scaledIcon);
            } else {
                // Si no se encuentra la imagen, mostramos un mensaje de error
                System.err.println("No se encontró el archivo en la ruta: " + ruta);
                foto.setIcon(null);
            }
        } catch (Exception e) {
            // Capturamos cualquier excepción y mostramos el mensaje
            System.err.println("Error al cargar la imagen: " + e.getMessage());
            foto.setIcon(null);  // En caso de error, limpiamos el icono
        }
    }

    private void actualizarTabla(List<Alumno> arrayListaPdf) {
        DefaultTableModel modelo = (DefaultTableModel) this.tablaDatoAlumnos.getModel();
        modelo.setRowCount(0);
        ImageIcon icon = null;
        for (Alumno dato : arrayListaPdf) {

            System.out.println("direccion " + dato.getDireccion());
            if (dato.getFoto_alumno() != null && !dato.getFoto_alumno().isEmpty()) {
                icon = cargarImagen1(dato.getFoto_alumno());
            } else {
                icon = cargarImagen1("default.jpg");
            }
            modelo.addRow(new Object[]{
                dato.getMatricula().getId_matricula(),
                dato.getNombre(),
                dato.getApellido(),
                dato.getDireccion(),
                dato.getCorreo_electronico(),
                icon,
                dato.getMatricula().getFecha_matricula(),
                dato.getMatricula().getEstado()

            });
        }
        this.tablaDatoAlumnos.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
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

    List<Profesor> arrayEspecialidad;

    private void cargarTablaModulosProfesores() {
        final String[] COLUMNAS = {"Matricula", "nombre", "apellido", "especialidad", "foto"};
        DefaultTableModel modelo = new DefaultTableModel(COLUMNAS, 0);
        String idMatriculaStr = this.txtMatriculaId.getText().trim();

        // Verificar si el idMatricual es válido
        if (idMatriculaStr == null || idMatriculaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una matrícula válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Convertir String a int
            int id = Integer.parseInt(idMatriculaStr);
            DAOProfesoresImplementacion dao_profesor_especialidad = new DAOProfesoresImplementacion();
            arrayEspecialidad = dao_profesor_especialidad.listaProfesoresEspecialidad(id);

            if (arrayEspecialidad.isEmpty()) {
                limpiarTablaModulosEspecialida();
                JOptionPane.showMessageDialog(this, "No se encontraron profesores asociados a esta matrícula.", "Información", JOptionPane.INFORMATION_MESSAGE);
                limpiarTablaModulosEspecialida();
                return;
            }

            for (Profesor dato : arrayEspecialidad) {
                Object[] fila = new Object[5];
                fila[0] = dato.getCursoMatricula().getId_matricual();
                fila[1] = dato.getNombre();
                fila[2] = dato.getApellido();
                fila[3] = dato.getEspecialidad();
                String rutaImagen1 = dato.getFoto_profesor();
                ImageIcon icon = cargarImagen(rutaImagen1, 35, 35);
                fila[4] = (icon != null) ? icon : "Sin imagen";

                modelo.addRow(fila);
            }

            tablaDatosModulos.setRowHeight(35);
            this.tablaDatosModulos.setModel(modelo);
            asignarRenderizadorDeImagen1();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El valor de matrícula debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los profesores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asignarRenderizadorDeImagen1() {
        this.tablaDatosModulos.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
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

    private void camposNoEditables() {
        this.txtMatriculaId.setEditable(false);
        this.txtNombre.setEditable(false);
        this.txtApellido.setEditable(false);
        this.txtDireccion.setEditable(false);
        this.txtCorreo.setEditable(false);
        this.txtEstado.setEditable(false);
        this.txtFecha.setEditable(false);

    }

    private void limpiarCampos() {
        this.txtMatriculaId.setText("");
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtDireccion.setText("");
        this.txtCorreo.setText("");
        this.txtEstado.setText("");
        this.txtBuscar.setText("");
        this.txtFecha.setText("");
        this.rutaImagenGlobal = null;
        try {
            cargarImagen(this.txtFoto, "fondo.jpg", 110, 157);
        } catch (NullPointerException e) {
            System.err.println("Imagen por defecto no encontrada");
            this.txtFoto.setIcon(null);
        }
        limpiarTablaModulosEspecialida();
        this.cargarTablaBien();

    }

    private void limpiarTablaModulosEspecialida() {
        DefaultTableModel moeloVacio = new DefaultTableModel(new String[]{"Matricula", "nombre", "apellido", "especialidad", "foto"}, 0);
        // Limpiar la tabla asignando un modelo vacío
        this.tablaDatosModulos.setModel(moeloVacio);
    }
}
