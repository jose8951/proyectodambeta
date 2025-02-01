package dao;

import java.util.List;
import java.util.Map;
import models.Administradores;

public interface DAO_Administradores {

    public List<Administradores> listar();
    public List<Administradores> listarCompleto();

    public int login(Administradores admin);
    
    public boolean insertar(Administradores admin);
    public void modificar(Administradores admin);
    
    public boolean eliminar(Administradores admin);
    
    
    public List<Administradores> buscarPorNombre(String nombre);
    
    public boolean borradoTotal(String correo);
    
    
  
}
