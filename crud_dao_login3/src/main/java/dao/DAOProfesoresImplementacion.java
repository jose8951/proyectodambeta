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
import models.CursoMatricula;
import models.Matricula;
import models.Profesor;

public class DAOProfesoresImplementacion implements DAO_Profesores {

    Conexion conexion = Conexion.getInstance();
    private static final Logger logger = Logger.getLogger(DAOProfesoresImplementacion.class.getName());

    @Override
    public List<Profesor> listaCompleto() {
        List<Profesor> profeList = new ArrayList<>();
        String sql = "select * from academiavega.profesores";
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql);
                ResultSet resul = prepared.executeQuery()) {
            while (resul.next()) {
                Profesor pro = new Profesor();
                pro.setId_profesor(resul.getInt("id_profesor"));
                pro.setNombre(resul.getString("nombre"));
                pro.setApellido(resul.getString("apellido"));
                pro.setEspecialidad(resul.getString("especialidad"));
                pro.setCorreo_electronico(resul.getString("correo_electronico"));
                pro.setTelefono(resul.getString("telefono"));
                pro.setFoto_profesor(resul.getString("foto_profesor"));
                profeList.add(pro);
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar los profesores: " + ex.getMessage());
        }
        return profeList;
    }

    @Override
    public boolean insertar(Profesor profesor) {
        String sql = "insert into academiavega.profesores (nombre, especialidad,correo_electronico,telefono,foto_profesor) values (?,?,?,?,?)";
        try (Connection conectar = conexion.conectar();
                PreparedStatement insertar = conectar.prepareStatement(sql)) {

            insertar.setString(1, profesor.getNombre());
            insertar.setString(2, profesor.getEspecialidad());
            insertar.setString(3, profesor.getCorreo_electronico());
            insertar.setString(4, profesor.getTelefono());
            insertar.setString(5, profesor.getFoto_profesor());
            // Ejecutar la consulta
            int filaAfectadas = insertar.executeUpdate();
            if (filaAfectadas > 0) {
                logger.log(Level.INFO, "Alumno con ID  y nombre  registrado exitosamente");
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error al registrar el empleado");
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean modificar(Profesor profesor) {

        String sql = "update academiavega.profesores SET nombre=?,especialidad=?,correo_electronico=?,telefono=?,foto_profesor=? where id_profesor=?";
        try (Connection conectar = conexion.conectar();
                PreparedStatement modificar = conectar.prepareStatement(sql)) {
            modificar.setString(1, profesor.getNombre());
            modificar.setString(2, profesor.getEspecialidad());
            modificar.setString(3, profesor.getCorreo_electronico());
            modificar.setString(4, profesor.getTelefono());
            modificar.setString(5, profesor.getFoto_profesor());
            modificar.setInt(6, profesor.getId_profesor());
            int filaActualizada = modificar.executeUpdate();
            if (filaActualizada > 0) {
                logger.log(Level.INFO, "Se actualizo el profesor con ID {0}", profesor.getId_profesor());
                return true;
            } else {
                logger.log(Level.WARNING, "No se actualizó ningún profesor con ID {0}", profesor.getId_profesor());
                return false; // No se encontró el profesor
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al modificar el profeosor con ID: "
                    + profesor.getId_profesor(), ex);
            return false;
        }

    }

    @Override
    public boolean eliminar(Profesor profesor, String correo) {
        String sql = "delete from academiavega.profesores where id_profesor=?";

        if (profesor == null || profesor.getId_profesor() <= 0 || correo == null) {
            throw new IllegalArgumentException("datos o sus campos no deben ser nulos");
        }

        try (Connection conectar = conexion.conectar();
                PreparedStatement eliminar = conectar.prepareStatement(sql)) {
            eliminar.setInt(1, profesor.getId_profesor());
            int filaAfectadas = eliminar.executeUpdate();
            if (filaAfectadas > 0) {
                logger.log(Level.INFO, "Alumno con ID {0} fue eliminado por: {1} eliminado exitosamente",
                        new Object[]{profesor.getId_profesor(), correo});
                return true;
            } else {
                // Log en caso de que no se elimine ninguna fila (aunque el ID exista)
                logger.log(Level.WARNING, "No se eliminó ningún alumno con ID {0}", profesor.getId_profesor());
                return false;
            }

        } catch (SQLException ex) {
            // Registra el error con el Logger
            logger.log(Level.SEVERE, "Error al eliminar el alumno con ID: " + profesor.getId_profesor(), ex);
            throw new RuntimeException("Ocurrió un error al eliminar el empleado: " + ex.getMessage(), ex);

        }
    }

    @Override
    public List<Profesor> buscarNombre(String nombre) {
        String sql = "Select * from academiavega.profesores where nombre LIKE ?";
        List<Profesor> listaArray = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement buscar = conectar.prepareStatement(sql)) {
            buscar.setString(1, "%" + nombre + "%");
            ResultSet resultado = buscar.executeQuery();
            while (resultado.next()) {
                Profesor pro = new Profesor();
                pro.setId_profesor(resultado.getInt("id_profesor"));
                pro.setNombre(resultado.getString("nombre"));
                pro.setEspecialidad(resultado.getString("especialidad"));
                pro.setCorreo_electronico(resultado.getString("correo_electronico"));
                pro.setTelefono(resultado.getString("telefono"));
                pro.setFoto_profesor(resultado.getString("foto_profesor"));
                listaArray.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar administradores por nombre: " + e.getMessage(), e);
        }
        return listaArray;
    }

    @Override
    public List<Profesor> verListaEspecialidades(int idMatri) {
        String sql = "select cm.id_matricula,p.nombre,p.especialidad, p.id_profesor "
                + "from profesores p join curso_matricula cm on p.id_profesor=cm.id_profesor where cm.id_matricula=?";
        List<Profesor> arrayEspe = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql)) {
            prepared.setInt(1, idMatri);
            try (ResultSet resultado = prepared.executeQuery()) {
                while (resultado.next()) {
                    Profesor pro = new Profesor();
                    pro.setId_profesor(resultado.getInt("id_profesor"));
                    pro.setNombre(resultado.getString("nombre"));
                    pro.setEspecialidad(resultado.getString("especialidad"));

                    CursoMatricula cm = new CursoMatricula();
                    //  cm.setId_matricula(resultado.getInt("id_matricula"));
                    cm.setId_matricual(resultado.getInt("id_matricula"));
                    cm.setId_profesor(pro.getId_profesor());

                    pro.setCursoMatricula(cm);
                    arrayEspe.add(pro);
                }
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar las especialidades de los profesores: " + ex.getMessage());

        }
        return arrayEspe;
    }

    @Override
    public List<Profesor> listaProfesoresEspecialidad(int idMatricula) {
        String sql = "select cm.id_matricula, p.nombre,p.apellido, p.especialidad, p.foto_profesor "
                + "from profesores p join curso_matricula cm on p.id_profesor=cm.id_profesor where cm.id_matricula=?";

        List<Profesor> arrayProfe = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql)) {

            ps.setInt(1, idMatricula);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Profesor profesor = new Profesor();
                    profesor.setNombre(rs.getString("nombre"));
                    profesor.setApellido(rs.getString("apellido"));
                    profesor.setEspecialidad(rs.getString("especialidad"));
                    profesor.setFoto_profesor(rs.getString("foto_profesor"));
                    CursoMatricula cm = new CursoMatricula();
                    cm.setId_matricual(rs.getInt("id_matricula"));
                    profesor.setCursoMatricula(cm);
                    
                    arrayProfe.add(profesor);
                }
            }
        } catch (SQLException ex) {
            logger.severe("Error al ejecutar la consulta SQL para listar los profesores matriculados. "
                    + "SQL: " + sql + ", Parámetro: " + idMatricula + ", Error: " + ex.getMessage());
            // Puedes decidir si retornas una lista vacía o lanzas una excepción
            throw new RuntimeException("Error al acceder a los datos de los alumnos", ex);
        }
        return arrayProfe;
    }

    private boolean esNumero(String idMatricula) {
        try {
            Integer.parseInt(idMatricula);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
