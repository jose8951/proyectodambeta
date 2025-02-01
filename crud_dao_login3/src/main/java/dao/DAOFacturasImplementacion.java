package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.Conexion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Alumno;
import models.Evaluacion;
import models.Facturas;
import models.Matricula;

public class DAOFacturasImplementacion implements DAO_Facturas {
    
    Conexion conexion = Conexion.getInstance();
    private static final Logger logger = Logger.getLogger(DAOAlumnosImplementacion.class.getName());
    
    @Override
    public int obtenerCantidadMatriculas(String idMatricula) {
        String sql = "SELECT * FROM curso_matricula WHERE id_matricula = ?";
        int cantidad = 0;
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            //convertir String a int
            int idMatriculaInt = Integer.parseInt(idMatricula);
            ps.setInt(1, idMatriculaInt);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.last()) { // Mover el cursor al final
                    cantidad = rs.getRow(); // Obtener el número de filas
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al contar las matrículas: " + ex.getMessage());
        }
        return cantidad;
    }
    
    @Override
    public List<Alumno> listadoAlumnosFacturas() {
        /* String sql = "select m.id_matricula,a.nombre,a.apellido,a.correo_electronico, a.foto_alumno "
                + "from alumnos a join matriculas m on a.id_alumno=m.id_alumno order by m.id_matricula";*/
        
        String sql = "select m.id_matricula,a.nombre,a.apellido,a.correo_electronico, a.foto_alumno, f.estado_pago, f.visto "
                + "from alumnos a join matriculas m on a.id_alumno=m.id_alumno "
                + "left join facturas f on f.id_matricula=m.id_matricula order by m.id_matricula";
        
        List<Alumno> arrayAlumFac = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement prepared = conectar.prepareStatement(sql);
                ResultSet resultado = prepared.executeQuery()) {
            
            while (resultado.next()) {
                Facturas factura = new Facturas();
                Matricula mat = new Matricula();
                
                mat.setId_matricula(resultado.getInt("id_matricula"));
                
                Alumno alu = new Alumno();
                alu.setNombre(resultado.getString("nombre"));
                alu.setApellido(resultado.getString("apellido"));
                alu.setCorreo_electronico(resultado.getString("correo_electronico"));
                alu.setFoto_alumno(resultado.getString("foto_alumno"));
                alu.setMatricula(mat);
                factura.setEstado_pago(resultado.getString("estado_pago"));
                factura.setVisto(resultado.getString("visto"));
                alu.setFacturas(factura);
                
                arrayAlumFac.add(alu);
            }
        } catch (SQLException ex) {
            logger.severe("Error al listar los alumnos: " + ex.getMessage());
        }
        return arrayAlumFac;
        
    }
    
    @Override
    public boolean insertarFactura(Facturas facturas, String correo) {
        String sql = "insert into academiavega.facturas (id_matricula,fecha_factura,precio,estado_pago, visto) values (?,?,?,?,?)";
        try (Connection conectar = conexion.conectar();
                PreparedStatement psIns = conectar.prepareStatement(sql)) {
            if (facturas.getFecha_factura() == null) {
                facturas.setFecha_factura(new Date());
            }
            psIns.setInt(1, facturas.getMatricula().getId_matricula());
            psIns.setDate(2, new java.sql.Date(facturas.getFecha_factura().getTime()));
            psIns.setDouble(3, facturas.getPrecio());
            psIns.setString(4, facturas.getEstado_pago());
            psIns.setString(5, "visto");
            int filaAfectadas = psIns.executeUpdate();
            if (filaAfectadas > 0) {
                // Log de éxito: Factura insertada correctamente
                logger.log(Level.INFO, "Factura para matrícula con ID {0} registrada exitosamente por {1}",
                        new Object[]{facturas.getMatricula().getId_matricula(), correo});
                return true;
            } else {
                // Log en caso de que no se inserte ninguna fila
                logger.log(Level.WARNING, "No se insertó ninguna factura para la matrícula con ID {0}",
                        facturas.getMatricula().getId_matricula());
                return false;
            }
        } catch (SQLException ex) {
            // Log del error y mostrar mensaje en caso de fallo en la consulta
            logger.log(Level.SEVERE, "Error al registrar la factura: {0}", ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar la factura: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    
    @Override
    public boolean eliminarFactura(Facturas factura, String correo) {
        String sql = "delete from academiavega.facturas where id_matricula=?";
        if (factura == null || correo == null) {
            throw new IllegalArgumentException("Empleado o sus campos no deben ser nulos");
        }
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql)) {
            ps.setInt(1, factura.getMatricula().getId_matricula());
            
            int filaAfectadas = ps.executeUpdate();
            if (filaAfectadas > 0) {
                // Log de éxito
                logger.log(Level.INFO, "Alumno con ID {0} fue eliminado por: {1} eliminado exitosamente",
                        new Object[]{factura.getMatricula().getId_matricula(), correo});
            } else {
                // Log en caso de que no se elimine ninguna fila (aunque el ID exista)
                logger.log(Level.WARNING, "No se eliminó ningún alumno con ID {0}", factura.getMatricula().getId_matricula());
            }
            return filaAfectadas > 0;
        } catch (SQLException ex) {
            // Registra el error con el Logger
            logger.log(Level.SEVERE, "Error al eliminar el alumno con ID: " + factura.getMatricula().getId_matricula(), ex);
            throw new RuntimeException("Ocurrió un error al eliminar el empleado: " + ex.getMessage(), ex);
        }
    }
    
    @Override
    public boolean modificarFactura(Facturas factura, String correo) {
        String sql = "update academiavega.facturas set estado_pago=? where id_matricula=?";
        
        try (Connection conectar = conexion.conectar();
                PreparedStatement modificar = conectar.prepareStatement(sql)) {
            
            modificar.setString(1, factura.getEstado_pago());
            modificar.setInt(2, factura.getMatricula().getId_matricula());
            int filaAfectada = modificar.executeUpdate();
            if (filaAfectada > 0) {
                // Log de éxito
                logger.log(Level.INFO, "Factura para el alumno con ID {0} modificada exitosamente por: {1}",
                        new Object[]{factura.getMatricula().getId_matricula(), correo});
            } else {
                // Log en caso de que no se modifique ninguna fila (aunque el ID exista)
                logger.log(Level.WARNING, "No se modificó ninguna factura para el alumno con ID {0}",
                        factura.getMatricula().getId_matricula());
            }
            return filaAfectada > 0;
            
        } catch (SQLException ex) {
            // Log de error con detalles completos
            logger.log(Level.SEVERE, "Error al modificar la factura: {0}", ex.getMessage());
            // Mostrar el detalle del error en la consola
            JOptionPane.showMessageDialog(null, "Error al modificar la factura: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    
    @Override
    public List<Alumno> listaAlumnosBuscarFactura(String buscar) {        
        String sql = "SELECT m.id_matricula, a.nombre, a.apellido, a.correo_electronico, a.foto_alumno, f.estado_pago, f.visto "
                + "FROM alumnos a JOIN matriculas m ON a.id_alumno = m.id_alumno LEFT JOIN facturas f ON f.id_matricula = m.id_matricula "
                + "WHERE (m.id_matricula = ?) OR (a.nombre LIKE ?) OR (a.apellido LIKE ?) "
                + "OR (f.estado_pago LIKE ? ) ORDER BY m.id_matricula";
        
        List<Alumno> arrayBusqueda = new ArrayList<>();
        try (Connection conectar = conexion.conectar();
                PreparedStatement ps = conectar.prepareStatement(sql)) {            
            if (esNumero(buscar)) {
                ps.setInt(1, Integer.parseInt(buscar));
            } else {
                ps.setInt(1, 0);
            }
            ps.setString(2, "%" + buscar + "%");
            ps.setString(3, "%" + buscar + "%");
            ps.setString(4, "%" + buscar + "%");            
            try (ResultSet resultado = ps.executeQuery()) {
                while (resultado.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setNombre(resultado.getString("nombre"));
                    alumno.setApellido(resultado.getString("apellido"));
                    alumno.setCorreo_electronico(resultado.getString("correo_electronico"));
                    alumno.setFoto_alumno(resultado.getString("foto_alumno"));                    
                    
                    Matricula matricula = new Matricula();
                    matricula.setId_matricula(resultado.getInt("id_matricula"));
                    alumno.setMatricula(matricula);                    
                    
                    Facturas facturas = new Facturas();
                    facturas.setEstado_pago(resultado.getString("estado_pago"));
                    facturas.setVisto(resultado.getString("visto"));
                    alumno.setFacturas(facturas);
                    
                    arrayBusqueda.add(alumno);                    
                }
            }
        } catch (SQLException ex) {
            logger.severe("Error al ejecutar la consulta SQL para listar los alumnos matriculados. "
                    + "SQL: " + sql + ", Parámetro: " + buscar + ", Error: " + ex.getMessage());
            // Puedes decidir si retornas una lista vacía o lanzas una excepción
            throw new RuntimeException("Error al acceder a los datos de los alumnos", ex);
        }
        return arrayBusqueda;
    }
    
    private boolean esNumero(String buscar) {
        try {
            Integer.parseInt(buscar);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    
}
