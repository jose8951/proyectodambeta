package dao;

import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Matricula;

public class DAOMatriculasImplementacion implements DAO_Matriculas {

    Conexion conexion = Conexion.getInstance();
    private static final Logger logger = Logger.getLogger(DAOMatriculasImplementacion.class.getName());

    @Override
    public boolean insertar(Matricula matricula) {
        String sql = "insert into academiavega.matriculas (id_alumno,fecha_matricula,estado) values (?,?,?)";
        try (Connection conectar = conexion.conectar();
                PreparedStatement insertar = conectar.prepareStatement(sql)) {

            insertar.setInt(1, matricula.getId_alumno());
            insertar.setDate(2, new java.sql.Date(matricula.getFecha_matricula().getTime()));
            insertar.setString(3, matricula.getEstado());

            int filaAfectadas = insertar.executeUpdate();
            return filaAfectadas > 0;

        } catch (SQLIntegrityConstraintViolationException ex) {
            // Capturamos el error específico de clave duplicada
            logger.severe("Error de clave duplicada: " + ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    "El alumno ya está matriculado. No se puede insertar un registro duplicado.",
                    "Error de Duplicado",
                    JOptionPane.ERROR_MESSAGE);
            return false;

        } catch (SQLException ex) {
            // Usamos el logger para registrar el error con un mensaje detallado
            logger.severe("Error al registrar la matrícula: " + ex.getMessage());
            logger.severe(ex.toString());  // Esto imprime el stack trace completo
            return false;  // Devolver false si hubo un error
        }
    }

 

    @Override
    public boolean modificarEstado(Matricula matricula) {
        String sql = "Update academiavega.matriculas SET estado=? where (id_matricula=? and id_alumno=?)";
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql)) {

            ps.setString(1, matricula.getEstado());
            ps.setInt(2, matricula.getId_matricula());
            ps.setInt(3, matricula.getId_alumno());
            int filaActualizada = ps.executeUpdate();
            if (filaActualizada > 0) {
                logger.log(Level.INFO, "Se actualizo la matricula con ID {0}", matricula.getId_matricula());
                return true;
            } else {
                logger.log(Level.WARNING, "No se actualizó ningún matricula con ID {0}", matricula.getId_matricula());
                return false; // No se encontró la matricula
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al modificar el profeosor con ID: "
                    + matricula.getId_matricula(), ex);
            return false;
        }

    }

    @Override
    public boolean eliminarMatricula(Matricula matricula, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
