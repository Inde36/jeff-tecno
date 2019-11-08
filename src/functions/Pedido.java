package functions;

import java.time.LocalDate;
import java.util.Date;

public class Pedido {
    int id=0;
    String nombre_user="";
    int estado_id=0;
    String incidencia="";
    String fecha = null;
    public Pedido() {
    }
    public Pedido(int id, String nombre_user, int estado_id, String incidencia, String fecha) {
        this.id = id;
        this.nombre_user = nombre_user;
        this.estado_id = estado_id;
        this.incidencia = incidencia;
        this.fecha = fecha;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre_user() {
        return nombre_user;
    }
    public void setNombre_user(String nombre_user) {
        this.nombre_user = nombre_user;
    }
    public int getEstado_id() {
        return estado_id;
    }
    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }
    public String getIncidencia() {
        return incidencia;
    }
    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
