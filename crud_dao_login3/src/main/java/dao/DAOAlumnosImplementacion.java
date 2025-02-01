package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Alumno;
import database.Conexion;
import javax.swing.SwingUtilities;
import models.Evaluacion;
import models.Facturas;
import models.Matricula;
import models.Profesor;

public class DAOAlumnosImplementacion implements DAO_Alumnos {

    Conexion conexion = Conexion.getInstance();
    private static final Logger logger = Logger.getLogger(DAOAlumnosImplementacion.class.getName());

    @Override
    public List<Alumno> listaCompleto() {
        // logger.log(Level.INFO, "Este es un mensaje de prueba.");
        List<Alumno> alumnoList = new ArrayList<>();
        String sql = "SELECT * FROM academiavega.alumnos";
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql);
                ResultSet result = prepared.executeQuery()) {
            while (result.next()) {
                Alumno alu = new Alumno();
                alu.setId_alumno(result.getInt("id_alumno"));
                alu.setNombre(result.getString("nombre"));
                alu.setApellido(result.getString("apellido"));
                alu.setFecha_nacimiento(result.getDate("fecha_nacimiento"));
                alu.setDireccion(result.getString("direccion"));
                alu.setCorreo_electronico(result.getString("correo_electronico"));
                alu.setFoto_alumno(result.getString("foto_alumno"));
                alumnoList.add(alu);
            }

        } catch (SQLException ex) {
            logger.severe("Error al listar los alumnos: " + ex.getMessage());
        }
        return alumnoList;
    }

    @Override
    public boolean insertarAlumno(Alumno alumno) {
        String sql = "insert into academiavega.alumnos (nombre,apellido,fecha_nacimiento,direccion,correo_electronico,foto_alumno) values (?,?,?,?,?,?)";
        try (Connection conectar = conexion.conectar();
                PreparedStatement insertar = conectar.prepareStatement(sql)) {
            insertar.setString(1, alumno.getNombre());
            insertar.setString(2, alumno.getApellido());
            insertar.setDate(3, new java.sql.Date(alumno.getFecha_nacimiento().getTime()));
            insertar.setString(4, alumno.getDireccion());
            insertar.setString(5, alumno.getCorreo_electronico());
            insertar.setString(6, alumno.getFoto_alumno());
            int filaAfectatadas = insertar.executeUpdate();
            return filaAfectatadas > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al registrar el empleado{0}", ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar el empleado " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean modificar(Alumno alumno) {
        String sql = "update academiavega.alumnos set nombre=?,fecha_nacimiento=?,direccion=?,correo_electronico=?,foto_alumno=? where id_alumno=?";
        try (Connection conectar = conexion.conectar();
                PreparedStatement modificar = conectar.prepareStatement(sql)) {
            modificar.setString(1, alumno.getNombre());
            //modificar.setDate(2, (Date) alumno.getFecha_nacimiento());
            modificar.setDate(2, alumno.getFecha_nacimiento() != null
                    ? new java.sql.Date(alumno.getFecha_nacimiento().getTime())
                    : null);
            modificar.setString(3, alumno.getDireccion());
            modificar.setString(4, alumno.getCorreo_electronico());
            modificar.setString(5, alumno.getFoto_alumno());
            modificar.setInt(6, alumno.getId_alumno());
            int filaActualizada = modificar.executeUpdate();
            return filaActualizada > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al modificar el alumno: {0}", ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar el alumno: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public List<Alumno> buscarPorNombre(String nombre) {
        String slq = "select * from alumnos where nombre like ?";
        List<Alumno> alumnoArray = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement buscar = conectar.prepareStatement(slq)) {
            // Usamos comodines para buscar coincidencias parciales
            buscar.setString(1, "%" + nombre + "%");
            ResultSet resultado = buscar.executeQuery();

            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setId_alumno(resultado.getInt("id_alumno"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setApellido(resultado.getString("apellido"));
                alumno.setFecha_nacimiento(resultado.getDate("fecha_nacimiento"));
                alumno.setDireccion(resultado.getString("direccion"));
                alumno.setCorreo_electronico(resultado.getString("correo_electronico"));
                alumno.setFoto_alumno(resultado.getString("foto_alumno"));
                alumnoArray.add(alumno);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar administradores por nombre: " + e.getMessage(), e);
        }
        return alumnoArray;
    }

    @Override
    public boolean eliminar(Alumno alumno, String correo) {
        String sql = "DELETE FROM academiavega.alumnos where id_alumno=?";
        // logger.log(Level.INFO, "Este es un mensaje de prueba.");
        if (alumno == null || alumno.getId_alumno() <= 0) {
            throw new IllegalArgumentException("Empleado o sus campos no deben ser nulos");
        }
        System.out.println("el valor del correo " + correo);
        try (Connection conectar = conexion.conectar();
                PreparedStatement eliminar = conectar.prepareStatement(sql)) {
            eliminar.setInt(1, alumno.getId_alumno());
            int filaAfectadas = eliminar.executeUpdate();
            if (filaAfectadas >= 0) {
                // Log de éxito
                logger.log(Level.INFO, "Alumno con ID {0} fue eliminado por: {1} eliminado exitosamente",
                        new Object[]{alumno.getId_alumno(), correo});
            } else {
                // Log en caso de que no se elimine ninguna fila (aunque el ID exista)
                logger.log(Level.WARNING, "No se eliminó ningún alumno con ID {0}", alumno.getId_alumno());
            }

            return filaAfectadas > 0;
        } catch (SQLException ex) {
            // Registra el error con el Logger
            logger.log(Level.SEVERE, "Error al eliminar el alumno con ID: " + alumno.getId_alumno(), ex);
            throw new RuntimeException("Ocurrió un error al eliminar el empleado: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<Alumno> noMatriculados() {
        /* String sql = "SELECT m.id_matricula, a.nombre, a.apellido,m.estado, a.foto_alumno, a.id_alumno "
                + "FROM academiavega.alumnos a "
                + "LEFT JOIN academiavega.matriculas m ON a.id_alumno = m.id_alumno";*/

        String sql = "SELECT a.id_alumno,m.id_matricula, a.nombre, a.apellido,m.estado, a.foto_alumno "
                + "FROM alumnos a LEFT JOIN matriculas m ON a.id_alumno = m.id_alumno WHERE m.id_matricula IS NULL";

        List<Alumno> arrayAlum = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql);
                ResultSet resultado = prepared.executeQuery()) {

            while (resultado.next()) {
                Matricula mat = new Matricula();
                mat.setId_matricula(resultado.getInt("id_matricula"));
                mat.setEstado(resultado.getString("estado"));

                Alumno alu = new Alumno();
                alu.setId_alumno(resultado.getInt("id_alumno"));
                alu.setNombre(resultado.getString("nombre"));
                alu.setApellido(resultado.getString("apellido"));
                alu.setFoto_alumno(resultado.getString("foto_alumno"));

                alu.setMatricula(mat);

                arrayAlum.add(alu);
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar los alumnos: " + ex.getMessage());
        }
        return arrayAlum;

    }

    @Override
    public List<Alumno> noMatriculados(String buscar) {
        String sql = "SELECT a.*"
                + "FROM academiavega.alumnos a "
                + "LEFT JOIN academiavega.matriculas m ON a.id_alumno = m.id_alumno "
                + "WHERE m.id_alumno IS NULL and (a.nombre LIKE ? or a.apellido like ?)";
        List<Alumno> arrayAlum = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql)) {
            // Pasar el parámetro a la consulta con comodín para buscar coincidencias parciales
            prepared.setString(1, "%" + buscar + "%");
            prepared.setString(2, "%" + buscar + "%");
            try (ResultSet resultado = prepared.executeQuery()) {
                while (resultado.next()) {
                    Alumno alu = new Alumno();
                    alu.setId_alumno(resultado.getInt("id_alumno"));
                    alu.setNombre(resultado.getString("nombre"));
                    alu.setApellido(resultado.getString("apellido"));
                    alu.setFoto_alumno(resultado.getString("foto_alumno"));
                    arrayAlum.add(alu);
                }
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar los alumnos no matriculados: " + ex.getMessage());
        }
        return arrayAlum;
    }

    @Override
    public List<Alumno> siMatriculados() {

        String sql = "SELECT a.id_alumno, a.nombre AS alumno_nombre, a.apellido, a.correo_electronico, a.foto_alumno, "
                + "m.id_matricula, m.fecha_matricula, m.estado "
                + "FROM alumnos a "
                + "INNER JOIN matriculas m ON a.id_alumno = m.id_alumno "
                + "ORDER BY a.id_alumno";

        List<Alumno> arrayAlum = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql);
                ResultSet resultado = prepared.executeQuery()) {
            while (resultado.next()) {
                Alumno alu = new Alumno();
                alu.setId_alumno(resultado.getInt("id_alumno"));
                alu.setNombre(resultado.getString("alumno_nombre"));
                alu.setApellido(resultado.getString("apellido"));
                alu.setCorreo_electronico(resultado.getString("correo_electronico"));
                alu.setFoto_alumno(resultado.getString("foto_alumno"));

                Matricula matricula = new Matricula();
                matricula.setId_matricula(resultado.getInt("id_matricula"));
                matricula.setFecha_matricula(resultado.getDate("fecha_matricula"));
                matricula.setEstado(resultado.getString("estado"));
                alu.setMatricula(matricula);

                arrayAlum.add(alu);
            }

        } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
            // Asegurarse de que el cuadro de diálogo se ejecute en el hilo de la interfaz de usuario principal
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // Mensaje de error con detalles
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),
                            "Error de Integridad de Datos", JOptionPane.ERROR_MESSAGE);
                }
            });
            // También lo registramos en los logs por si el JOptionPane no se muestra
            logger.severe("Error de Integridad de Datos: " + ex.getMessage());
        } catch (SQLException ex) {
            // Asegurarse de que el cuadro de diálogo se ejecute en el hilo de la interfaz de usuario principal
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // Mensaje de error con detalles
                    JOptionPane.showMessageDialog(null, "Error al listar los alumnos: " + ex.getMessage(),
                            "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
                }
            });
            // También lo registramos en los logs por si el JOptionPane no se muestra
            logger.severe("Error en la consulta SQL: " + ex.getMessage());
        }

        return arrayAlum;
    }

    @Override
    public List<Alumno> noEvaluados() {
        String sql = "SELECT a.id_alumno, a.nombre, a.apellido, e.nota "
                + "FROM alumnos a LEFT JOIN evaluaciones e ON a.id_alumno = e.id_alumno "
                + "WHERE e.id_alumno IS NULL";

        List<Alumno> arrayAlum = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepa = conectar.prepareStatement(sql);
                ResultSet resultado = prepa.executeQuery()) {
            while (resultado.next()) {
                Alumno alu = new Alumno();
                alu.setId_alumno(resultado.getInt("id_alumno"));
                alu.setNombre(resultado.getString("nombre"));
                alu.setApellido(resultado.getString("apellido"));

                arrayAlum.add(alu);
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar los alumnos: " + ex.getMessage());
        }
        return arrayAlum;
    }

    @Override
    public List<Alumno> siMatriculados(String buscar) {
        String sql = "SELECT a.id_alumno, a.nombre AS alumno_nombre, a.apellido,a.direccion, a.correo_electronico, a.foto_alumno, "
                + "m.id_matricula, m.fecha_matricula, m.estado "
                + "FROM alumnos a "
                + "INNER JOIN matriculas m ON a.id_alumno = m.id_alumno "
                + "where m.id_matricula like ? or a.apellido like ? or a.nombre like ? ORDER BY a.id_alumno";

        List<Alumno> arrayApe = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql)) {
            if (esNumero(buscar)) {
                prepared.setInt(1, Integer.parseInt(buscar));
            } else {
                prepared.setInt(1, 0);
            }
            prepared.setString(2, "%" + buscar + "%");
            prepared.setString(3, "%" + buscar + "%");
            try (ResultSet resultado = prepared.executeQuery()) {
                while (resultado.next()) {
                    Alumno alu = new Alumno();
                    alu.setId_alumno(resultado.getInt("id_alumno"));
                    alu.setNombre(resultado.getString("alumno_nombre"));
                    alu.setApellido(resultado.getString("apellido"));
                    alu.setDireccion(resultado.getString("direccion"));
                    alu.setCorreo_electronico(resultado.getString("correo_electronico"));
                    alu.setFoto_alumno(resultado.getString("foto_alumno"));

                    Matricula matricula = new Matricula();
                    matricula.setId_matricula(resultado.getInt("id_matricula"));
                    matricula.setFecha_matricula(resultado.getDate("fecha_matricula"));
                    matricula.setEstado(resultado.getString("estado"));
                    alu.setMatricula(matricula);

                    arrayApe.add(alu);
                }
            }
        } catch (SQLException ex) {
            logger.severe("Error al ejecutar la consulta SQL para listar los alumnos matriculados. "
                    + "SQL: " + sql + ", Parámetro: " + buscar + ", Error: " + ex.getMessage());
            // Puedes decidir si retornas una lista vacía o lanzas una excepción
            throw new RuntimeException("Error al acceder a los datos de los alumnos", ex);
        }
        return arrayApe;
    }

    @Override
    public List<Alumno> listaEvaluacionNota() {
        String sql = "SELECT a.id_alumno, a.nombre AS alumno_nombre, a.apellido, p.especialidad, a.foto_alumno, m.id_matricula, "
                + "m.fecha_matricula, m.estado, e.comentarios, p.id_profesor, p.nombre AS profesor_nombre, e.id_evaluacion, e.nota FROM alumnos a "
                + "INNER JOIN matriculas m ON a.id_alumno = m.id_alumno INNER JOIN curso_matricula cm ON cm.id_matricula = m.id_matricula "
                + "INNER JOIN profesores p ON p.id_profesor = cm.id_profesor LEFT JOIN "
                + "evaluaciones e ON e.id_alumno = a.id_alumno AND e.id_profesor = p.id_profesor where m.id_matricula order by m.id_matricula";

        List<Alumno> arrayLista = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql);
                ResultSet resultado = ps.executeQuery()) {

            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setId_alumno(resultado.getInt("id_alumno"));
                alumno.setNombre(resultado.getString("alumno_nombre"));
                alumno.setApellido(resultado.getString("apellido"));
                alumno.setFoto_alumno(resultado.getString("foto_alumno"));

                Evaluacion evaluaciones = new Evaluacion();
                evaluaciones.setId_evaluacion(resultado.getInt("id_evaluacion"));
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

                arrayLista.add(alumno);
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar los alumnos: " + ex.getMessage());
        }
        return arrayLista;
    }

    @Override
    public List<Alumno> listaEvaluacionNota(String buscar) {
        String sql = "SELECT a.id_alumno, a.nombre AS alumno_nombre, a.apellido, p.especialidad, a.foto_alumno, "
                + "m.id_matricula, m.fecha_matricula, m.estado, p.id_profesor, p.nombre AS profesor_nombre, e.nota, e.comentarios "
                + "FROM alumnos a "
                + "INNER JOIN matriculas m ON a.id_alumno = m.id_alumno "
                + "INNER JOIN curso_matricula cm ON cm.id_matricula = m.id_matricula "
                + "INNER JOIN profesores p ON p.id_profesor = cm.id_profesor "
                + "LEFT JOIN evaluaciones e ON e.id_alumno = a.id_alumno AND e.id_profesor = p.id_profesor "
                + "WHERE m.id_matricula LIKE ? OR a.nombre LIKE ? OR a.apellido LIKE ? "
                + "ORDER BY m.id_matricula";

        List<Alumno> arrayListaNota = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql)) {
            if (esNumero(buscar)) {
                ps.setInt(1, Integer.parseInt(buscar));
            } else {
                ps.setInt(1, 0);
            }
            ps.setString(2, "%" + buscar + "%");
            ps.setString(3, "%" + buscar + "%");
            try (ResultSet resultado = ps.executeQuery()) {
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

                    arrayListaNota.add(alumno);
                }
            }

        } catch (SQLException ex) {
            logger.severe("Error al listar los alumnos: " + ex.getMessage());
        }
        return arrayListaNota;

    }

    private boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    @Override
    public boolean eliminarMatricula(Alumno alumno, String correo) {

        String sql = "DELETE FROM academiavega.alumnos where id_alumno=?";
        // logger.log(Level.INFO, "Este es un mensaje de prueba.");
        if (alumno == null || alumno.getId_alumno() <= 0) {
            throw new IllegalArgumentException("Empleado o sus campos no deben ser nulos");
        }
        System.out.println("el valor del correo " + correo);
        try (Connection conectar = conexion.conectar();
                PreparedStatement eliminar = conectar.prepareStatement(sql)) {
            eliminar.setInt(1, alumno.getId_alumno());
            int filaAfectadas = eliminar.executeUpdate();
            if (filaAfectadas >= 0) {
                // Log de éxito
                logger.log(Level.INFO, "Alumno con ID {0} fue eliminado por: {1} eliminado exitosamente",
                        new Object[]{alumno.getId_alumno(), correo});
            } else {
                // Log en caso de que no se elimine ninguna fila (aunque el ID exista)
                logger.log(Level.WARNING, "No se eliminó ningún alumno con ID {0}", alumno.getId_alumno());
            }

            return filaAfectadas > 0;
        } catch (SQLException ex) {
            // Registra el error con el Logger
            logger.log(Level.SEVERE, "Error al eliminar el alumno con ID: " + alumno.getId_alumno(), ex);
            throw new RuntimeException("Ocurrió un error al eliminar el empleado: " + ex.getMessage(), ex);
        }

    }

    @Override
    public List<Alumno> datosPdfMostrar() {
        /*   String sql = "select m.id_matricula,a.nombre,a.apellido,a.direccion, a.correo_electronico,a.foto_alumno,m.fecha_matricula,m.estado "
                + "from alumnos a join matriculas m on a.id_alumno=m.id_alumno";*/

        String sql = "select m.id_matricula,a.nombre,a.apellido,a.direccion, a.correo_electronico,a.foto_alumno, a.fecha_nacimiento, "
                + "m.fecha_matricula,m.estado, f.precio from alumnos a join matriculas m on a.id_alumno=m.id_alumno "
                + "left join facturas f on f.id_matricula=m.id_matricula";

        List<Alumno> arrayLista = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql);
                ResultSet resultado = ps.executeQuery()) {
            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setApellido(resultado.getString("apellido"));
                alumno.setDireccion(resultado.getString("direccion"));
                alumno.setCorreo_electronico(resultado.getString("correo_electronico"));
                alumno.setFoto_alumno(resultado.getString("foto_alumno"));
                alumno.setFecha_nacimiento(resultado.getDate("fecha_nacimiento"));

                Matricula matricula = new Matricula();
                matricula.setId_matricula(resultado.getInt("id_matricula"));
                matricula.setFecha_matricula(resultado.getDate("fecha_matricula"));
                matricula.setEstado(resultado.getString("estado"));
                alumno.setMatricula(matricula);
                
                Facturas facturas=new Facturas();
                facturas.setPrecio(resultado.getFloat("precio"));
                alumno.setFacturas(facturas);

                arrayLista.add(alumno);
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar los alumnos: " + ex.getMessage());
        }
        return arrayLista;
    }

    @Override
    public List<Alumno> buscarAlumnoPdf(String buscar) {
        String sql = "select m.id_matricula,a.nombre,a.apellido,a.direccion, a.correo_electronico,a.foto_alumno,m.fecha_matricula,m.estado "
                + "from alumnos a join matriculas m on a.id_alumno=m.id_alumno where m.id_matricula LIKE ? or a.nombre LIKE ? or a.apellido LIKE ?";

        List<Alumno> arrayAlum = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql)) {

            if (esNumero(buscar)) {
                ps.setInt(1, Integer.parseInt(buscar));
            } else {
                ps.setInt(1, 0);
            }
            ps.setString(2, "%" + buscar + "%");
            ps.setString(3, "%" + buscar + "%");

            try (ResultSet resultado = ps.executeQuery()) {
                while (resultado.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setNombre(sql);

                    Matricula matricula = new Matricula();
                }
            }

        } catch (SQLException ex) {
            logger.severe("Error al ejecutar la consulta SQL para listar los alumnos matriculados. "
                    + "SQL: " + sql + ", Parámetro: " + buscar + ", Error: " + ex.getMessage());
            // Puedes decidir si retornas una lista vacía o lanzas una excepción
            throw new RuntimeException("Error al acceder a los datos de los alumnos", ex);
        }

        return arrayAlum;
    }

}
