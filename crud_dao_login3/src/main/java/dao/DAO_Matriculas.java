
package dao;

import models.Matricula;


public interface DAO_Matriculas {
    
    
    public boolean insertar(Matricula matricula);
    public boolean eliminarMatricula(Matricula matricula, String correo);
    public boolean modificarEstado(Matricula matricula);
   
}
