package dao;

import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Alumno;
import models.Evaluacion;
import models.Matricula;
import models.Profesor;

public class DAOEvaluacionImplementacion implements DAO_Evaluacion {

    Conexion conexion = Conexion.getInstance();
    private static final Logger logger = Logger.getLogger(DAOAlumnosImplementacion.class.getName());

    @Override
    public List<Evaluacion> listaEvaluacion() {
        List<Evaluacion> evaList = new ArrayList<>();
        String sql = "select a.id_alumno,a.nombre,a.apellido,a.correo_electronico,a.foto_alumno,m.id_matricula, "
                + "m.fecha_matricula,m.estado, p.id_profesor "
                + "from alumnos a join matriculas m on a.id_alumno=m.id_alumno "
                + "join curso_matricula cm on cm.id_matricula=m.id_matricula "
                + "join profesores p on p.id_profesor=cm.id_profesor";
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepare = conectar.prepareStatement(sql);
                ResultSet resultado = prepare.executeQuery()) {
            while (resultado.next()) {
                Evaluacion eva = new Evaluacion();
                eva.setId_evaluacion(resultado.getInt("id_evaluacion"));

                Alumno alu = new Alumno();
                alu.setNombre(resultado.getString("nombre_alumno"));
                alu.setFoto_alumno(resultado.getString("foto_alumno"));
                eva.setAlumno(alu);

                Profesor pro = new Profesor();
                pro.setNombre(resultado.getString("nombre_profesor"));
                pro.setApellido(resultado.getString("apellido"));
                pro.setEspecialidad(resultado.getString("especialidad"));
                eva.setProfesor(pro);

                eva.setFecha_evaluacion(resultado.getDate("fecha_evaluacion"));
                eva.setNota(resultado.getFloat("nota"));
                eva.setComentarios(resultado.getString("comentarios"));

                evaList.add(eva);
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar los alumnos: " + ex.getMessage());
        }
        return evaList;
    }

    @Override
    public boolean insertarNota(Evaluacion evaluacion) {
        String sql = "insert into evaluaciones (id_alumno,id_profesor,fecha_evaluacion,nota,comentarios) values (?,?,?,?,?)";
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql)) {

            ps.setInt(1, evaluacion.getAlumno().getId_alumno());
            ps.setInt(2, evaluacion.getProfesor().getId_profesor());
            ps.setDate(3, new java.sql.Date(evaluacion.getFecha_evaluacion().getTime()));
            ps.setFloat(4, evaluacion.getNota());
            ps.setString(5, evaluacion.getComentarios());

            int filaAfectadas = ps.executeUpdate();
            return filaAfectadas > 0;

        } catch (SQLException ex) {
            // Usamos el logger para registrar el error con un mensaje detallado
            logger.log(Level.SEVERE, "Error al ingresar las notas: {0}", ex.getMessage());
            logger.severe(ex.toString());  // Esto imprime el stack trace completo
            return false;  // Devolver false si hubo un error
        }
    }

    @Override
    public List<Evaluacion> buscarNombre(String nombre) {
        String sql = "SELECT e.id_evaluacion, "
                + "       a.nombre AS nombre_alumno, "
                + "       a.foto_alumno, "
                + "       p.nombre AS nombre_profesor, "
                + "       p.apellido AS apellido_profesor, "
                + "       p.especialidad, "
                + "       e.fecha_evaluacion, "
                + "       e.nota, "
                + "       e.comentarios "
                + "FROM academiavega.evaluaciones e "
                + "JOIN academiavega.alumnos a ON e.id_alumno = a.id_alumno "
                + "JOIN academiavega.profesores p ON e.id_profesor = p.id_profesor "
                + "WHERE a.nombre LIKE ?";

        List<Evaluacion> buscarNombre = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement buscar = conectar.prepareStatement(sql)) {

            buscar.setString(1, "%" + nombre + "%");
            ResultSet resultado = buscar.executeQuery();
            while (resultado.next()) {
                Evaluacion eva = new Evaluacion();
                eva.setId_evaluacion(resultado.getInt("id_evaluacion"));
                eva.setFecha_evaluacion(resultado.getDate("fecha_evaluacion"));
                eva.setNota(resultado.getFloat("nota"));
                eva.setComentarios(resultado.getString("comentarios"));

                Alumno alu = new Alumno();
                alu.setNombre(resultado.getString("nombre_alumno"));
                alu.setFoto_alumno(resultado.getString("foto_alumno"));
                eva.setAlumno(alu);

                Profesor pro = new Profesor();
                pro.setNombre(resultado.getString("nombre_profesor"));
                pro.setApellido(resultado.getString("apellido_profesor"));
                pro.setEspecialidad(resultado.getString("especialidad"));
                eva.setProfesor(pro);

                buscarNombre.add(eva);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar administradores por nombre: " + e.getMessage(), e);
        }
        return buscarNombre;

    }

    @Override
    public boolean modificarEvaluaciones(Evaluacion eva) {//no se utiliza

        String sql = "update academiavega.evaluaciones SET nota=?,Comentarios=? where id_evaluacion=?";
        try (Connection conectar = conexion.conectar();
                PreparedStatement modificar = conectar.prepareStatement(sql)) {

            modificar.setFloat(1, eva.getNota());
            modificar.setString(2, eva.getComentarios());
            modificar.setInt(3, eva.getId_evaluacion());

            int filaActualizada = modificar.executeUpdate();
            if (filaActualizada > 0) {
                logger.log(Level.INFO, "Se actualizo la evaluacion con ID {0}", eva.getId_evaluacion());
                return true;
            } else {
                logger.log(Level.WARNING, "No se actualizó ningún nota con ID {0}", eva.getId_evaluacion());
                return false; // No se encontró el profesor
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al modificar el profeosor con ID: "
                    + eva.getId_evaluacion(), ex);
            return false;
        }
    }

    @Override
    public boolean eliminarEvaluacion(Evaluacion evaluacion, String correo) {
        String sql = "delete from academiavega.evaluaciones where id_evaluacion=?";

        if (evaluacion == null || evaluacion.getId_evaluacion() <= 0 || correo == null) {
            throw new IllegalArgumentException("datos o sus campos no deben ser nulos");
        }

        try (Connection conectar = conexion.conectar();
                PreparedStatement eliminar = conectar.prepareStatement(sql)) {
            eliminar.setInt(1, evaluacion.getId_evaluacion());
            int filaAfectadas = eliminar.executeUpdate();
            if (filaAfectadas > 0) {
                logger.log(Level.INFO, "Alumno con ID {0} fue eliminado por: {1} eliminado exitosamente",
                        new Object[]{evaluacion.getId_evaluacion(), correo});
                return true;
            } else {
                // Log en caso de que no se elimine ninguna fila (aunque el ID exista)
                logger.log(Level.WARNING, "No se eliminó ningún alumno con ID {0}", evaluacion.getId_evaluacion());
                return false;
            }

        } catch (SQLException ex) {
            // Registra el error con el Logger
            logger.log(Level.SEVERE, "Error al eliminar el alumno con ID: " + evaluacion.getId_evaluacion(), ex);
            throw new RuntimeException("Ocurrió un error al eliminar el empleado: " + ex.getMessage(), ex);

        }

    }

    @Override
    public boolean modificarNotas(Evaluacion evaluacion) {
        String sql = "UPDATE academiavega.evaluaciones SET fecha_evaluacion=?, nota=?, comentarios=? where id_alumno=? and id_profesor=?";
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(evaluacion.getFecha_evaluacion().getTime()));
            ps.setFloat(2, evaluacion.getNota());
            ps.setString(3, evaluacion.getComentarios());

            ps.setInt(4, evaluacion.getAlumno().getId_alumno());
            ps.setInt(5, evaluacion.getProfesor().getId_profesor());

            int filaActualizada = ps.executeUpdate();
            if (filaActualizada > 0) {
                logger.log(Level.INFO, "Se actualizo la evaluacion con ID {0}", evaluacion.getId_evaluacion());
                return true;
            } else {
                logger.log(Level.WARNING, "No se actualizó ningún nota con ID {0}", evaluacion.getId_evaluacion());
                return false;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al modificar la evaluacion con ID: "
                    + evaluacion.getId_evaluacion(), ex);
            return false;
        }
    }

    @Override
    public boolean eliminarEvaluacionModulo(Evaluacion evaluacion, String correo) {
        String sql = "delete from academiavega.evaluaciones where id_alumno=?";

        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql)) {
            // Establecer parámetros de la consulta
            ps.setInt(1, evaluacion.getAlumno().getId_alumno());
            // Ejecutar la actualización
            int filaAfectadas = ps.executeUpdate();
            if (filaAfectadas > 0) {
                logger.log(Level.INFO, "Alumno con ID {0} fue eliminado por: {1} eliminado exitosamente",
                        new Object[]{evaluacion.getId_evaluacion(), correo});
                return true;
            } else {
                logger.log(Level.WARNING, "No se eliminó ningún alumno con ID {0}", evaluacion.getId_evaluacion());
                return false;
            }
        } catch (SQLException ex) {
            // Registra el error con el Logger
            logger.log(Level.SEVERE, "Error al eliminar la evaluacion con ID: " + evaluacion.getId_evaluacion(), ex);
            throw new RuntimeException("Ocurrió un error al eliminar el empleado: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<Alumno> listadoCortoNotas(String id) {

        String sql = "SELECT a.id_alumno, a.nombre AS alumno_nombre, a.apellido, p.especialidad, a.foto_alumno, m.id_matricula, "
                + "m.fecha_matricula, m.estado, e.comentarios, p.id_profesor, p.nombre AS profesor_nombre, "
                + "e.id_evaluacion, e.nota FROM alumnos a "
                + "INNER JOIN matriculas m ON a.id_alumno = m.id_alumno INNER JOIN curso_matricula cm "
                + "ON cm.id_matricula = m.id_matricula "
                + "INNER JOIN profesores p ON p.id_profesor = cm.id_profesor LEFT JOIN "
                + "evaluaciones e ON e.id_alumno = a.id_alumno AND e.id_profesor = p.id_profesor "
                + "where m.id_matricula=?";

        List<Alumno> arrayCorto = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql)) {
            if (esNumero(id)) {
                prepared.setInt(1, Integer.parseInt(id));
            } else {
                prepared.setInt(1, 0);
            }
            try (ResultSet resultado = prepared.executeQuery()) {
                while (resultado.next()) {

                    Alumno alumno = new Alumno();
                    alumno.setId_alumno(resultado.getInt("id_alumno"));
                    alumno.setNombre(resultado.getString("alumno_nombre"));
                    alumno.setApellido(resultado.getString("apellido"));
                    alumno.setFoto_alumno(resultado.getString("foto_alumno"));

                    Evaluacion evaluaciones = new Evaluacion();
                    evaluaciones.setNota(resultado.getFloat("nota"));
                    evaluaciones.setComentarios(resultado.getString("comentarios"));
                    alumno.setEvaluacion(evaluaciones);

                    Matricula matricula = new Matricula();
                    matricula.setId_matricula(resultado.getInt("id_matricula"));
                    matricula.setFecha_matricula(resultado.getDate("fecha_matricula"));
                    matricula.setEstado(resultado.getString("estado"));
                    alumno.setMatricula(matricula);

                    Profesor profesor = new Profesor();
                    profesor.setId_profesor(resultado.getInt("id_profesor"));
                    profesor.setNombre(resultado.getString("profesor_nombre"));
                    profesor.setEspecialidad(resultado.getString("especialidad"));
                    alumno.setProfesor(profesor);

                    arrayCorto.add(alumno);
                }
            }

        } catch (SQLException ex) {
            logger.severe("Error al ejecutar la consulta SQL para listar los alumnos matriculados. "
                    + "SQL: " + sql + ", Parámetro: " + id + ", Error: " + ex.getMessage());
            // Puedes decidir si retornas una lista vacía o lanzas una excepción
            throw new RuntimeException("Error al acceder a los datos de los alumnos", ex);
        }

        return arrayCorto;
    }

    private boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
