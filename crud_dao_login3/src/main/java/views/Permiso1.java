package views;

import dao.DAOAdministradoImplementacion;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import views.paneles1.Panel1;
import views.paneles1.Panel2;
import views.paneles1.Panel3;
import views.paneles1.Panel4;
import views.paneles1.Panel5;
import views.paneles1.Panel6;
import views.paneles1.Panel7;
import views.paneles1.Panel8;
import views.paneles1.Panel9;
import views.paneles1.Panel10;

public class Permiso1 extends javax.swing.JFrame {

    private Panel1 p1;
    private Panel2 p2;
    private Panel3 p3;
    private Panel4 p4;
    private Panel5 p5;
    private Panel6 p6;
    private Panel7 p7;
    private Panel8 p8;
    private Panel9 p9;
    private Panel10 p10;

    private final Color colorNoSeleccionado = new Color(200, 200, 200); // Gris claro o cualquier color que desees
    private final Color colorResaltado = new Color(152, 226, 222, 204); // Color de resaltado

    String correo = null;
    // String valorCorreo = null;

    public Permiso1(String correo, String rol) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setTitle("Permisos de: " + rol + "   " + utils.Utilidades.mostrarFechaActual());
        this.txtRegistrado.setText(correo);
        //this.valorCorreo = correo;
        this.btnEvaluacion.setVisible(false);

        ShowPanel(getPanel9());
        btnImprimirPdf.setBackground(colorResaltado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAdmini = new javax.swing.JButton();
        txtRegistrado = new javax.swing.JLabel();
        txtRol = new javax.swing.JLabel();
        btnRoles = new javax.swing.JButton();
        btnAlumno = new javax.swing.JButton();
        btnProfesor = new javax.swing.JButton();
        btnMatricula = new javax.swing.JButton();
        btnAlumMatricula = new javax.swing.JButton();
        btnEvaluacion = new javax.swing.JButton();
        btnNotas = new javax.swing.JButton();
        btnTruncate = new javax.swing.JButton();
        btnImprimirPdf = new javax.swing.JButton();
        bntFacturas = new javax.swing.JButton();
        content1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(757, 580));
        setPreferredSize(new java.awt.Dimension(557, 580));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 580));

        btnAdmini.setText("Crear adnmistrador");
        btnAdmini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminiActionPerformed(evt);
            }
        });

        txtRegistrado.setBackground(new java.awt.Color(204, 204, 255));
        txtRegistrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnRoles.setText("Crear Roles");
        btnRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolesActionPerformed(evt);
            }
        });

        btnAlumno.setText("Crear alumnos");
        btnAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnoActionPerformed(evt);
            }
        });

        btnProfesor.setText("Crear profesores");
        btnProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesorActionPerformed(evt);
            }
        });

        btnMatricula.setText("no Matriculados");
        btnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculaActionPerformed(evt);
            }
        });

        btnAlumMatricula.setText("Alumno matriculado");
        btnAlumMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumMatriculaActionPerformed(evt);
            }
        });

        btnEvaluacion.setText("Evaluaciones");
        btnEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluacionActionPerformed(evt);
            }
        });

        btnNotas.setText("notas");
        btnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasActionPerformed(evt);
            }
        });

        btnTruncate.setText("TRUNCATE");
        btnTruncate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruncateActionPerformed(evt);
            }
        });

        btnImprimirPdf.setText("Imprimir pdf");
        btnImprimirPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirPdfActionPerformed(evt);
            }
        });

        bntFacturas.setText("Facturas");
        bntFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFacturasActionPerformed(evt);
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
                        .addComponent(txtRegistrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAdmini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAlumMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEvaluacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTruncate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnImprimirPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bntFacturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdmini)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRoles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProfesor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlumMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEvaluacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNotas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimirPdf)
                .addGap(21, 21, 21)
                .addComponent(bntFacturas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTruncate)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        content1.setBackground(new java.awt.Color(204, 255, 204));
        content1.setPreferredSize(new java.awt.Dimension(557, 580));

        javax.swing.GroupLayout content1Layout = new javax.swing.GroupLayout(content1);
        content1.setLayout(content1Layout);
        content1Layout.setHorizontalGroup(
            content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );
        content1Layout.setVerticalGroup(
            content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(content1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminiActionPerformed
        resetearBotones(); // Restablecer todos los botones
        btnAdmini.setBackground(colorResaltado);
        ShowPanel(getPanel1());
    }//GEN-LAST:event_btnAdminiActionPerformed

    private void btnRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolesActionPerformed
        resetearBotones();
        btnRoles.setBackground(colorResaltado);
        ShowPanel(getPanel2());
    }//GEN-LAST:event_btnRolesActionPerformed

    private void btnAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnoActionPerformed

        resetearBotones();
        btnAlumno.setBackground(colorResaltado);
        ShowPanel(getPanel3());
    }//GEN-LAST:event_btnAlumnoActionPerformed

    private void btnProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfesorActionPerformed
        resetearBotones();
        btnProfesor.setBackground(colorResaltado);
        ShowPanel(getPanel4());
    }//GEN-LAST:event_btnProfesorActionPerformed

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed
        resetearBotones();
        btnMatricula.setBackground(colorResaltado);
        if (p5 != null) {
            p5.cargarTablaBien();
        }
        ShowPanel(getPanel5());
    }//GEN-LAST:event_btnMatriculaActionPerformed

    private void btnAlumMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumMatriculaActionPerformed
        resetearBotones();
        btnAlumMatricula.setBackground(colorResaltado);
        if (p6 != null) {
            p6.cargarTablaBien();
        }
        ShowPanel(getPanel6());
    }//GEN-LAST:event_btnAlumMatriculaActionPerformed

    private void btnEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluacionActionPerformed
        resetearBotones();
        btnEvaluacion.setBackground(colorResaltado);
        if (p7 != null) {
            p7.cargarTablaBien();
        }
        ShowPanel(getPanel7());
    }//GEN-LAST:event_btnEvaluacionActionPerformed

    private void btnTruncateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruncateActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea borrar todos los datos de las tablas?",
                "Confirmación de Borrado",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            DAOAdministradoImplementacion dao_Borrado_total = new DAOAdministradoImplementacion();
            boolean exitoBorrado = dao_Borrado_total.borradoTotal(this.txtRegistrado.getText());

            if (exitoBorrado) {
                // Aquí puedes agregar lo que deseas hacer si el borrado es exitoso, como mostrar un mensaje
                JOptionPane.showMessageDialog(this, "Los datos han sido eliminados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // En caso de que algo salga mal
                JOptionPane.showMessageDialog(this, "Hubo un problema al borrar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Si el usuario cancela el borrado
            JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnTruncateActionPerformed

    private void btnNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotasActionPerformed
        resetearBotones();
        btnNotas.setBackground(colorResaltado);
        if (p8 != null) {
            p8.cargarTablaBien();
        }
        ShowPanel(getPanel8());
    }//GEN-LAST:event_btnNotasActionPerformed

    private void btnImprimirPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirPdfActionPerformed
        resetearBotones();
        btnImprimirPdf.setBackground(colorResaltado);
        if (p9 != null) {
           p9.cargarTablaBien();
        }
        ShowPanel(getPanel9());
    }//GEN-LAST:event_btnImprimirPdfActionPerformed

    private void bntFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFacturasActionPerformed
       resetearBotones(); // Restablecer todos los botones
        bntFacturas.setBackground(colorResaltado);
        ShowPanel(getPanel10());
    }//GEN-LAST:event_bntFacturasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntFacturas;
    private javax.swing.JButton btnAdmini;
    private javax.swing.JButton btnAlumMatricula;
    private javax.swing.JButton btnAlumno;
    private javax.swing.JButton btnEvaluacion;
    private javax.swing.JButton btnImprimirPdf;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnProfesor;
    private javax.swing.JButton btnRoles;
    private javax.swing.JButton btnTruncate;
    private javax.swing.JPanel content1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtRegistrado;
    private javax.swing.JLabel txtRol;
    // End of variables declaration//GEN-END:variables

    private void ShowPanel(JPanel panel) {
        if (panel != null) {
            content1.removeAll();
            // Agrega solo el panel que deseas mostrar
            content1.setLayout(new BorderLayout());
            content1.add(panel, BorderLayout.CENTER);
            // Asegúrate de que content1 es visible
            content1.setVisible(true);
            // Actualiza el layout y redibuja el contenido
            content1.revalidate();
            content1.repaint();
        }

    }

    private void resetearBotones() {
        btnAdmini.setBackground(colorNoSeleccionado);
        btnRoles.setBackground(colorNoSeleccionado);
        btnAlumno.setBackground(colorNoSeleccionado);
        btnProfesor.setBackground(colorNoSeleccionado);
        btnMatricula.setBackground(colorNoSeleccionado);
        btnAlumMatricula.setBackground(colorNoSeleccionado);
        btnEvaluacion.setBackground(colorNoSeleccionado);
        btnNotas.setBackground(colorNoSeleccionado);
    }

    private JPanel getPanel1() {
        if (p1 == null) {
            p1 = new Panel1(txtRegistrado.getText());
        }
        return p1;
    }

    private JPanel getPanel2() {
        if (p2 == null) {
            p2 = new Panel2(txtRegistrado.getText());
        }
        return p2;
    }

    private JPanel getPanel3() {
        if (p3 == null) {
            p3 = new Panel3(txtRegistrado.getText());
        }
        return p3;
    }

    private JPanel getPanel4() {
        if (p4 == null) {
            p4 = new Panel4(txtRegistrado.getText());
        }
        return p4;
    }

    private JPanel getPanel5() {
        if (p5 == null) {
            p5 = new Panel5(txtRegistrado.getText());
        }
        return p5;
    }

    private JPanel getPanel6() {
        if (p6 == null) {
            p6 = new Panel6(txtRegistrado.getText());
        }
        return p6;
    }

    private JPanel getPanel7() {
        if (p7 == null) {
            p7 = new Panel7(txtRegistrado.getText());
        }
        return p7;
    }

    private JPanel getPanel8() {
        if (p8 == null) {
            p8 = new Panel8(txtRegistrado.getText());
        }
        return p8;
    }

    private JPanel getPanel9() {
        if (p9 == null) {
            p9 = new Panel9(txtRegistrado.getText());
        }
        return p9;
    }
    
      private JPanel getPanel10() {
        if (p10 == null) {
            p10 = new Panel10(txtRegistrado.getText());
        }
        return p10;
    }

}
