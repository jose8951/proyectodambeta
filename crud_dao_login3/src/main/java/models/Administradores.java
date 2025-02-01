
package models;


public class Administradores {
    
    private int id_administradores;
    private String nombre;
    private String correo;
    private String password;
    private int roles_id_rol;
    private String foto_administrador;
    private Roles roles;
    
    

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
    

    public int getId_administradores() {
        return id_administradores;
    }

    public void setId_administradores(int id_administradores) {
        this.id_administradores = id_administradores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoles_id_rol() {
        return roles_id_rol;
    }

    public void setRoles_id_rol(int roles_id_rol) {
        this.roles_id_rol = roles_id_rol;
    }

    public String getFoto_administrador() {
        return foto_administrador;
    }

    public void setFoto_administrador(String foto_administrador) {
        this.foto_administrador = foto_administrador;
    }
    
    
}
