
package dao;

import java.util.List;
import models.Alumno;
import models.Evaluacion;


public interface DAO_Evaluacion {
    
    
    public List<Evaluacion> listaEvaluacion();
    
    public boolean insertarNota(Evaluacion eva);//no se utliza
    
    public List<Evaluacion> buscarNombre(String nombre);
   public boolean modificarEvaluaciones(Evaluacion evaluacion);//no se utiliza
    public boolean eliminarEvaluacion(Evaluacion evaluacion, String correo);
    public boolean modificarNotas(Evaluacion evaluacion);
    
    public boolean eliminarEvaluacionModulo(Evaluacion evaluacion,String correo);
    
      public List<Alumno> listadoCortoNotas(String text);
    
}
