package models;

import java.util.Date;

public class Evaluacion {

    private int id_evaluacion;
    private Date fecha_evaluacion;
    private float nota;
    private String comentarios;
    private Alumno alumno;
    private Profesor profesor;

    public Evaluacion() {
    }

    public Evaluacion(Alumno alumno, Profesor profesor) {
        this.alumno = alumno;
        this.profesor = profesor;
    }

    public int getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(int id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }

    public Date getFecha_evaluacion() {
        return fecha_evaluacion;
    }

    public void setFecha_evaluacion(Date fecha_evaluacion) {
        this.fecha_evaluacion = fecha_evaluacion;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

}
