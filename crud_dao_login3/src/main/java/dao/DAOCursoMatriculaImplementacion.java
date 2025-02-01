package dao;

import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.CursoMatricula;

public class DAOCursoMatriculaImplementacion implements DAO_CursoMatricula {

    Conexion conexion = Conexion.getInstance();
    private static final Logger logger = Logger.getLogger(DAOMatriculasImplementacion.class.getName());

    @Override
    public int insertar(CursoMatricula cm) {

        String sql = "insert into academiavega.curso_matricula (id_matricula, id_profesor,fecha) values(?,?,?)";
        try (Connection conectar = conexion.conectar();
                PreparedStatement insertar = conectar.prepareStatement(sql)) {

            insertar.setInt(1, cm.getId_matricual());
            insertar.setInt(2, cm.getId_profesor());
            insertar.setDate(3, new java.sql.Date(cm.getFecha().getTime()));

            int filasAfectadas = insertar.executeUpdate();

            if (filasAfectadas > 0) {
                // Retorna 1 si la inserción fue exitosa
                return 1;
            } else {
                // Retorna 2 si no se afectaron filas (caso raro, pero podría pasar si no se insertó nada)
                return 2;
            }

        } catch (SQLException ex) {
            // Manejo específico para SQLIntegrityConstraintViolationException (duplicado)
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                logger.warning("El registro ya existe: " + ex.getMessage());
                // Retorna 3 si hay un error de duplicado
                return 3;
            } else {
                // Otros errores de SQL
                logger.severe("Error al registrar la matrícula: " + ex.getMessage());
                // Retorna 0 en caso de otro error de SQL
                return 0;
            }
        }
    }

    @Override
    public boolean eliminarCursoMatricula(int idMatricula, int idProfesor, String correo) {
        //DELETE FROM `academiavega`.`curso_matricula` WHERE (`id_matricula` = '32') and (`id_profesor` = '3');
        String sql = "delete from academiavega.curso_matricula where id_matricula=? and id_profesor=?";
        try (Connection conectar = conexion.conectar();
                PreparedStatement eliminar = conectar.prepareStatement(sql)) {
            CursoMatricula cm = new CursoMatricula();
            eliminar.setInt(1, idMatricula);
            eliminar.setInt(2, idProfesor);
            int filaAfectadas = eliminar.executeUpdate();
            if (filaAfectadas > 0) {
                logger.log(Level.INFO, "la matricula con ID {0} fue eliminado por: {1} eliminado exitosamente",
                        new Object[]{cm.getId_matricual(), correo});
            } else {
                // Log en caso de que no se elimine ninguna fila (aunque el ID exista)
                logger.log(Level.WARNING, "No se eliminó ninguna matricual con ID {0}", cm.getId_matricual());
            }
            return filaAfectadas > 0;
        } catch (SQLException ex) {
            // Registra el error con el Logger
            logger.log(Level.SEVERE, "Error al eliminar la matricual con ID: " + idMatricula, ex);
            throw new RuntimeException("Ocurrió un error al eliminar el empleado: " + ex.getMessage(), ex);
        }
    }

    @Override
    public boolean eliminarModuloProfesor(CursoMatricula cursoMatricula, String correo) {
        String sql = "delete from academiavega.curso_matricula where (id_matricula=?) and (id_profesor=?)";
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql)) {

            ps.setInt(1, cursoMatricula.getId_matricual());
            ps.setInt(2, cursoMatricula.getId_profesor());
            int filaAfectadas = ps.executeUpdate();
            if (filaAfectadas > 0) {
                logger.log(Level.INFO, "la matricula con ID {0} fue eliminado por: {1} eliminado exitosamente",
                        new Object[]{cursoMatricula.getId_matricual(), correo});
            } else {
                logger.log(Level.WARNING, "No se eliminó ninguna matrícula con ID {0} y profesor {1}",
                        new Object[]{cursoMatricula.getId_profesor(), cursoMatricula.getId_profesor()});
            }
            return filaAfectadas > 0;

        } catch (SQLException ex) {
            // Registra el error con el Logger
            logger.log(Level.SEVERE, "Error al eliminar la matricual con ID: " + cursoMatricula.getId_matricual(), ex);
            throw new RuntimeException("Ocurrió un error al eliminar el empleado: " + ex.getMessage(), ex);
        }

    }
}
