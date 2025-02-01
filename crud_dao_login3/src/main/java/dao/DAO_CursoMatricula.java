
package dao;

import models.CursoMatricula;


public interface DAO_CursoMatricula {
    
    
    public int insertar(CursoMatricula cm);
    
    public boolean eliminarCursoMatricula(int idMatricula, int idProfesor,String correo);
    
    public boolean eliminarModuloProfesor(CursoMatricula cursoMatricula, String correo);
}
