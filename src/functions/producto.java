package functions;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class producto {
    public String nombre = "";
    public int id = 0;
    public float precio = 0;
    public String marca = "";
    public int gigabytes = 0;
    public ArrayList<producto> ListaProductos = new ArrayList<producto>();
    public producto(String nombre, int id, float precio, String marca, int gigabytes) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.marca = marca;
        this.gigabytes = gigabytes;
    }

    public producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getGigabytes() {
        return gigabytes;
    }

    public void setGigabytes(int gigabytes) {
        this.gigabytes = gigabytes;
    }
    public void rellenarLista (producto p){

        this.ListaProductos.add(p);
    }

    public String toString(){
        String visualizarProducto="";
        Iterator it=ListaProductos.iterator();
        while (it.hasNext()){
            visualizarProducto=visualizarProducto+","+it.next();
        }
        return visualizarProducto;
    }
}
