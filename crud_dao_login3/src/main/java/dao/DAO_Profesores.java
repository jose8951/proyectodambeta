
package dao;

import java.util.List;
import models.Profesor;


public interface DAO_Profesores {
    
    
    public List<Profesor> listaCompleto();
    public boolean insertar(Profesor profesor);
    public boolean modificar(Profesor profesor);
    public boolean eliminar(Profesor profesor,String correo);
    public List<Profesor> buscarNombre(String nombre);
    
    public List<Profesor> verListaEspecialidades(int idMatricula);
    
    public List<Profesor> listaProfesoresEspecialidad(int idMatricula);
}
