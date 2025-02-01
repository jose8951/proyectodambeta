package models;

public class Profesor {

    private int id_profesor;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String correo_electronico;
    private String telefono;
    private String foto_profesor;
    private CursoMatricula cursoMatricula;

    public CursoMatricula getCursoMatricula() {
        return cursoMatricula;
    }

    public void setCursoMatricula(CursoMatricula cursoMatricula) {
        this.cursoMatricula = cursoMatricula;
    }

 
   

 

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFoto_profesor() {
        return foto_profesor;
    }

    public void setFoto_profesor(String foto_profesor) {
        this.foto_profesor = foto_profesor;
    }

}
