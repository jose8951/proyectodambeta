package dao;

import com.password4j.Password;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Administradores;
import models.Roles;
import database.Conexion;
import java.sql.Statement;
import java.util.logging.Level;

/**
 *
 * @author javeg
 */
public class DAOAdministradoImplementacion implements DAO_Administradores {

    Conexion conexion = Conexion.getInstance();
    private static final Logger logger = Logger.getLogger(DAOAdministradoImplementacion.class.getName());

    @Override
    public int login(Administradores admin) {
        String sql = "select a.email, a.password, r.estado from administradores a "
                + "inner join roles r on a.roles_id_rol= r.id_rol "
                + "where a.email=?";
        int permiso = 0;
        if (admin == null) {
            throw new IllegalArgumentException("Empleado o sus campos no deben ser nulos");
        }
        String correo = admin.getCorreo().trim();
        String plainPassword = admin.getPassword();
        // Verificar que correo y contraseña no estén vacíos
        if (correo.isEmpty() || plainPassword.isEmpty()) {
            throw new IllegalArgumentException("Correo y contraseña no pueden estar vacíos");
        }

        try (Connection conectar = conexion.conectar();
                PreparedStatement statement = conectar.prepareStatement(sql)) {
            // Establecer los valores en el PreparedStatement
            statement.setString(1, correo);

            // Ejecutar la consulta y obtener los resultados
            try (ResultSet resultSet = statement.executeQuery()) {
                // Si se encuentra el resultado
                if (resultSet.next()) {
                    // Obtener la contraseña hasheada desde la base de datos
                    String hashedPassword = resultSet.getString("password");

                    // Verificar la contraseña hasheada
                    if (verifyPassword(plainPassword, hashedPassword)) {
                        // Obtener el valor de 'estado' de la tabla 'roles'
                        String estado = resultSet.getString("estado");
                        // Asignar el permiso según el estado
                        if ("1".equals(estado)) {
                            permiso = 1;
                        } else if ("2".equals(estado)) {
                            permiso = 2;
                        } else if ("3".equals(estado)) {
                            permiso = 3;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "admin no encontrado");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Ocurrió un error al eliminar el empleado: " + ex.getMessage(), ex);
        }
        return permiso;
    }

    @Override
    public List<Administradores> listar() {
        List<Administradores> adminList = new ArrayList<>();
        String sql = "SELECT * FROM academiavega.administradores";
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql);
                ResultSet resultSet = prepared.executeQuery()) {
            while (resultSet.next()) {
                Administradores admin = new Administradores();
                admin.setId_administradores(resultSet.getInt("id_administradores"));
                admin.setNombre(resultSet.getString("nombre"));
                admin.setCorreo(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                admin.setRoles_id_rol(resultSet.getInt("roles_id_rol"));
                admin.setFoto_administrador(resultSet.getString("foto_administrador"));
                adminList.add(admin);
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar administradores: " + ex.getMessage());
        }
        return adminList;
    }

    @Override
    public List<Administradores> listarCompleto() {
        List<Administradores> adminList = new ArrayList<>();
        String sql = "select a.id_administradores, a.nombre, a.email,a.password, "
                + "r.nombre_rol, a.foto_administrador "
                + "from administradores a "
                + "inner join roles r on a.roles_id_rol=r.id_rol";

        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql);
                ResultSet resultSet = prepared.executeQuery()) {
            while (resultSet.next()) {
                Administradores admin = new Administradores();
                admin.setId_administradores(resultSet.getInt("id_administradores"));
                admin.setNombre(resultSet.getString("nombre"));
                admin.setCorreo(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                admin.setFoto_administrador(resultSet.getString("foto_administrador"));

                // Crear un objeto Roles y asignar los datos
                Roles rol = new Roles();
                rol.setNombre_rol(resultSet.getString("nombre_rol"));
                admin.setRoles(rol);
                adminList.add(admin);
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar administradores: " + ex.getMessage());
        }
        return adminList;
    }

    @Override
    public boolean insertar(Administradores admin) {
        String sql = "INSERT INTO academiavega.administradores (nombre,email,password,roles_id_rol,foto_administrador) values (?,?,?,?,?)";
        try (Connection conectar = conexion.conectar();
                PreparedStatement insertar = conectar.prepareStatement(sql)) {
            insertar.setString(1, admin.getNombre());
            insertar.setString(2, admin.getCorreo());
            insertar.setString(3, admin.getPassword());
            insertar.setInt(4, admin.getRoles_id_rol());
            insertar.setString(5, admin.getFoto_administrador());
            // Ejecutar la consulta
            int filaAfectadas = insertar.executeUpdate();
            System.out.println("fila afectadas " + filaAfectadas);
            return filaAfectadas > 0;

        } catch (SQLException ex) {
            System.out.println("Error al registrar el empleado");
            ex.printStackTrace();
            return false;
        }
    }

    private boolean verifyPassword(String plainPassword, String hashedPassword) {
        return Password.check(plainPassword, hashedPassword).withArgon2();
    }

    @Override
    public void modificar(Administradores admin) {
        String sql = "update academiavega.administradores SET nombre=?,email=?,password=?,roles_id_rol=?,foto_administrador=? where id_administradores=?";
        try (Connection conectar = conexion.conectar();
                PreparedStatement modificar = conectar.prepareStatement(sql)) {
            System.out.println("estoy " + admin.getFoto_administrador());
            modificar.setString(1, admin.getNombre());
            modificar.setString(2, admin.getCorreo());
            modificar.setString(3, admin.getPassword());
            modificar.setInt(4, admin.getRoles_id_rol());
            modificar.setString(5, admin.getFoto_administrador());
            modificar.setInt(6, admin.getId_administradores());
            int filaActualizada = modificar.executeUpdate();
            if (filaActualizada == 0) {
                JOptionPane.showMessageDialog(null, "No se encontró un empleado con el ID:");
            } else {
                JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente. ID: ");
            }
        } catch (SQLException ex) {
            System.err.println("Error al actualizar empleado: " + ex.getMessage());
        }
    }

    @Override
    public boolean eliminar(Administradores admin) {
        String sql = "DELETE from academiavega.administradores where id_administradores=?";
        if (admin == null || admin.getId_administradores() <= 0) {
            throw new IllegalArgumentException("Empleado o sus campos no deben ser nulos");
        }
        try (Connection conectar = conexion.conectar();
                PreparedStatement eliminar = conectar.prepareStatement(sql)) {
            eliminar.setInt(1, admin.getId_administradores());
            int filasAfectadas = eliminar.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            throw new RuntimeException("Ocurrió un error al eliminar el empleado: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<Administradores> buscarPorNombre(String nombre) {
        // String sql = "SELECT * FROM academiavega.administradores WHERE nombre LIKE ?";
        String sql = "SELECT a.id_administradores, a.nombre, a.email, a.password, a.foto_administrador, a.roles_id_rol, r.nombre_rol "
                + "FROM academiavega.administradores a "
                + "INNER JOIN academiavega.roles r ON a.roles_id_rol = r.id_rol "
                + "WHERE nombre LIKE ?";
        List<Administradores> listaAdministradores = new ArrayList<>();

        try (Connection conectar = conexion.conectar();
                PreparedStatement buscar = conectar.prepareStatement(sql)) {

            buscar.setString(1, "%" + nombre + "%"); // Usamos comodines para buscar coincidencias parciales
            ResultSet resultado = buscar.executeQuery();

            while (resultado.next()) {
                Administradores admin = new Administradores();
                admin.setId_administradores(resultado.getInt("id_administradores"));
                admin.setNombre(resultado.getString("nombre"));
                admin.setCorreo(resultado.getString("email"));
                admin.setPassword(resultado.getString("password"));
                admin.setFoto_administrador(resultado.getString("foto_administrador"));
                admin.setRoles_id_rol(resultado.getInt("roles_id_rol"));

                Roles rol = new Roles();
                rol.setNombre_rol(resultado.getString("nombre_rol"));
                admin.setRoles(rol);

                listaAdministradores.add(admin);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar administradores por nombre: " + e.getMessage(), e);
        }

        return listaAdministradores;
    }

    @Override
    public boolean borradoTotal(String correo) {

        String sql1 = "SET FOREIGN_KEY_CHECKS = 0;";
        String sql2 = "TRUNCATE TABLE alumnos;";
        String sql3 = "TRUNCATE TABLE profesores;";
        String sql4 = "TRUNCATE TABLE evaluaciones;";
        String sql5 = "TRUNCATE TABLE curso_matricula;";
        String sql6 = "TRUNCATE TABLE matriculas;";
        String sql7 = "TRUNCATE TABLE facturas;";
        String sql8 = "SET FOREIGN_KEY_CHECKS = 1;";

        try (Connection conectar = conexion.conectar();
                Statement stmt = conectar.createStatement()) {

            // Desactivar las restricciones de claves foráneas
            stmt.executeUpdate(sql1);

            // Truncar cada tabla por separado
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
            stmt.executeUpdate(sql5);
            stmt.executeUpdate(sql6);
            stmt.executeUpdate(sql7);

            // Reactivar las restricciones de claves foráneas
            stmt.executeUpdate(sql8);

            logger.log(Level.WARNING, "Borrado de todas las tablas por {0}", correo);
            return true;

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar administradores por nombre: " + e.getMessage(), e);
        }
    }

}
