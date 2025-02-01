
package dao;

import java.util.List;
import models.Alumno;

/**
 *
 * @author javeg
 */
public interface DAO_Alumnos {   
    public List<Alumno> listaCompleto();
    public boolean insertarAlumno(Alumno alumno);
    public boolean modificar(Alumno alumno);
    public List<Alumno> buscarPorNombre(String nombre);
    public boolean eliminar(Alumno alumno, String correo);
    
    public List<Alumno> noMatriculados();
    public List<Alumno> noMatriculados(String nombre);
    
    public List<Alumno> siMatriculados();
    public List<Alumno> noEvaluados();
    
    public List<Alumno> siMatriculados(String apellido);
    
    public List<Alumno> listaEvaluacionNota();
    public List<Alumno> listaEvaluacionNota(String buscar);
    
    public boolean eliminarMatricula(Alumno alumno, String correo);
    
    public List<Alumno> datosPdfMostrar();
    public List<Alumno> buscarAlumnoPdf(String buscar);
    

}
