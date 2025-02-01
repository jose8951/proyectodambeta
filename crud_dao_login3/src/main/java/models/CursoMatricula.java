package models;

import java.util.Date;

public class CursoMatricula {

    private Date fecha;
    private int id_profesor;
    private int id_matricual;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getId_matricual() {
        return id_matricual;
    }

    public void setId_matricual(int id_matricual) {
        this.id_matricual = id_matricual;
    }

}
