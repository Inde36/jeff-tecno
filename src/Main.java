import BD.BD;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import functions.producto;
public class Main {

    public static void main(String[] args) {
        int opcion = 0;
        producto p = new producto();
        do {
            System.out.println("Hola, Bienvienido a Jeff-Techno");
            System.out.println("¿Que quieres hacer hoy?");
            System.out.println("1.- Ver Producto");
            System.out.println("2.- Comprar Producto");
            System.out.println("3.- Consultar Estado del Pedido");
            System.out.println("4.-Salir");

            System.out.println("------------");


            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Connection conn = BD.getConnect();
                    break;
                case 2:
                    int productoComprar = 0;
                    Connection conn1 = BD.getConnect();
                    System.out.println(p.toString());
                    System.out.println("Que producto quieres comprar?");

                    productoComprar = sc.nextInt();




            }

        }while(opcion != 4);
    }
}
