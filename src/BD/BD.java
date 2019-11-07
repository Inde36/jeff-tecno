package BD;

import java.sql.*;

public class BD {

    public static BD instance = null;
    private static Connection connect = null;

    private BD(){
        String url ="jdbc:mysql://localhost/apptecno?serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "&user=root";

        try{


            Class.forName(driver);
            connect = DriverManager.getConnection(url + user );

            Statement stmt = connect.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM producto");

            while ( rs.next() ) {
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                int id = rs.getInt("id");
                System.out.println("-----------------");
                System.out.println(id+ ": " +nombre+" con un precio de: " +precio+"€");
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
        return connect;
    }
}
