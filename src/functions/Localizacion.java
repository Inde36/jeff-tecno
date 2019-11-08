package functions;

public class Localizacion {
    String nombre="";
    int tiempo_envio=0;
    public Localizacion() {
    }
    public Localizacion(String nombre, int tiempo_envio) {
        this.nombre = nombre;
        this.tiempo_envio = tiempo_envio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTiempo_envio() {
        return tiempo_envio;
    }
    public void setTiempo_envio(int tiempo_envio) {
        this.tiempo_envio = tiempo_envio;
    }
}
