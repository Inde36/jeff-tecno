package BD;

import functions.producto;

import java.sql.*;
import java.util.ArrayList;

public class BD {

    public static BD instance = null;
    private static Connection connect = null;

    private BD(){
        String url ="jdbc:mysql://localhost/apptecno?serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "&user=root";
        //ArrayList<producto> productos = new ArrayList<producto>();
        producto p1 = new producto();
        try{


            Class.forName(driver);
            connect = DriverManager.getConnection(url + user );

            Statement stmt = connect.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM producto");

            while ( rs.next() ) {

                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                int gigabytes = rs.getInt("gigabytes");
                System.out.println("-----------------");

                producto p2 = new producto(nombre, id, precio, marca, gigabytes);
                p1.rellenarLista(p2);



            }
            connect.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnect(){
        if (connect == null){

            new BD();
        }
        return connect ;
    }


}
