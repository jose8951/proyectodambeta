
package dao;

import java.util.List;
import models.Roles;


public interface DAO_Roles {
    
    public List<Roles> listar();
    
    public boolean insertar(Roles role);
    public boolean modificar(Roles role);
    public boolean eliminar(Roles role);
    
    
}
