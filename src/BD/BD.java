package BD;

import functions.producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BD {

    public static BD instance = null;
    private static Connection connect = null;
    private BD(){

        String url ="jdbc:mysql://localhost/apptecno?serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "&user=root";

    }
    public static Connection getConnect(){
        if (connect == null){

            new BD();
        }
        return connect ;
    }

    public static List<producto> getListaBD(){
        List<producto> listaProducto = new ArrayList<>();
        String url ="jdbc:mysql://localhost/apptecno?serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "&user=root";
        try{


            Class.forName(driver);
            connect = DriverManager.getConnection(url + user );

            Statement stmt = connect.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM producto");

            while ( rs.next() ) {
                producto p = new producto(rs.getString("nombre"),rs.getInt("id"),rs.getFloat("precio"),rs.getString("marca"),rs.getInt("gigabytes"));
                listaProducto.add(p);
            }
            connect.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return listaProducto;
    }


}
