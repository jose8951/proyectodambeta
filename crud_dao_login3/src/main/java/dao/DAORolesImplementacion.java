package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Roles;
import database.Conexion;

/**
 *
 * @author javeg
 */
public class DAORolesImplementacion implements DAO_Roles {

    Conexion conexion = Conexion.getInstance();
    private static final Logger logger = Logger.getLogger(DAORolesImplementacion.class.getName());

    @Override
    public List<Roles> listar() {
        List<Roles> rolesList = new ArrayList<>();
        String sql = "SELECT * FROM academiavega.roles";
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql);
                ResultSet resultSet = prepared.executeQuery()) {
            while (resultSet.next()) {
                Roles role = new Roles();
                role.setId_rol(resultSet.getInt("id_rol"));
                role.setNombre_rol(resultSet.getString("nombre_rol"));
                role.setEstado(resultSet.getInt("estado"));
                rolesList.add(role);
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar administradores: " + ex.getMessage());
        }

        return rolesList;
    }

    @Override
    public boolean insertar(Roles role) {
        String sql = "insert into academiavega.roles (nombre_rol,estado) values (?,?) ";
        try (Connection conectar = conexion.conectar();
                PreparedStatement insertar = conectar.prepareStatement(sql)) {
            insertar.setString(1, role.getNombre_rol());
            insertar.setInt(2, role.getEstado());
            // Ejecutar la consulta
            int afectadas = insertar.executeUpdate();
            return afectadas > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al insertar rol: {0}", ex.getMessage());
            //ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modificar(Roles role) {
        String sql = "update academiavega.roles set nombre_rol=?, estado=? where id_rol=?";
        try (Connection conectar = conexion.conectar();
                PreparedStatement modificar = conectar.prepareStatement(sql)) {
            modificar.setString(1, role.getNombre_rol());
            modificar.setInt(2, role.getEstado());
            modificar.setInt(3, role.getId_rol());

            int filaActualizada = modificar.executeUpdate();
            logger.log(Level.INFO, "Rol insertado exitosamente: {0}", role.getNombre_rol());
            return filaActualizada > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al actualizar rol: {0}", ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean eliminar(Roles role) {
        String sql = "Delete from academiavega.roles where id_rol=?";
        if (role == null || role.getId_rol() <= 0) {
            logger.log(Level.WARNING, "Intento de eliminar un rol inválido: {0}", role);
            throw new IllegalArgumentException("El rol no puede ser nulo y debe tener un ID válido");
        }
        try (Connection conectar = conexion.conectar();
                PreparedStatement eliminar = conectar.prepareStatement(sql)) {
            eliminar.setInt(1, role.getId_rol());
            int filaAcfectadas = eliminar.executeUpdate();
            logger.log(Level.INFO, "Rol eliminado exitosamente: ID={0}", role.getId_rol());
            return filaAcfectadas > 0;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al eliminar el rol con ID={0}: {1}", new Object[]{role.getId_rol(), ex.getMessage()});
            throw new RuntimeException("Ocurrió un error al eliminar el rol: " + ex.getMessage(), ex);
        }
    }

}
