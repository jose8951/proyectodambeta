
package dao;

import java.util.List;
import models.Alumno;
import models.Evaluacion;
import models.Facturas;


public interface DAO_Facturas {
    
    public List<Alumno> listadoAlumnosFacturas();
    
    public int obtenerCantidadMatriculas(String cantidad);
    public boolean insertarFactura(Facturas facturas,String correo);
    public boolean eliminarFactura(Facturas facturas, String correo);
    public boolean modificarFactura(Facturas facturas, String correo);
    public List<Alumno> listaAlumnosBuscarFactura(String buscar);
    
  
    

}
