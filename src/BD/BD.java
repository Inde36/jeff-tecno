package BD;

import functions.Pedido;
import functions.producto;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
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

    public static void postPedido(String nombre_user){
        String url ="jdbc:mysql://localhost/apptecno?serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "&user=root";
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());

        try{

            PreparedStatement preparedStatement;
            Class.forName(driver);
            connect = DriverManager.getConnection(url + user );
            preparedStatement = connect
                    .prepareStatement("INSERT INTO pedido set nombre_user = ?, estado_id = ?, fecha = ?");

             preparedStatement.setString(1 , nombre_user);
             preparedStatement.setInt(2,1);
             preparedStatement.setString(3,timeStamp);
            preparedStatement.executeUpdate();

            connect.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    public static List<Pedido> getPedido(String nombre_user){
        List<Pedido> listaPedido = new ArrayList<>();
        String url ="jdbc:mysql://localhost/apptecno?serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "&user=root";
        try{


            Class.forName(driver);
            connect = DriverManager.getConnection(url + user );

           PreparedStatement preparedStatement ;

            preparedStatement = connect
                    .prepareStatement("SELECT * FROM pedido where nombre_user = ?");
            preparedStatement.setString(1, nombre_user);
            ResultSet rs = preparedStatement.executeQuery();
            rs.getFetchSize();


                while ( rs.next() ) {

                    Pedido pe = new Pedido(rs.getInt("id"),rs.getString("nombre_user"),rs.getInt("estado_id"),rs.getString("incidencia"), rs.getString("fecha"));

                    listaPedido.add(pe);
                }


            connect.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return listaPedido;
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
