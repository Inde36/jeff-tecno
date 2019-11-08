import BD.BD;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import functions.compraProducto;
import functions.producto;
public class Main {

    public static void main(String[] args) {
        int opcion = 0;

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
                    List<producto> listap = BD.getListaBD();
                    for (int i = 0; i < listap.size() ; i++) {
                        System.out.println(listap.get(i).getId() + " - "+listap.get(i).getNombre() + listap.get(i).getPrecio()+"€");
                    }
                    System.out.println("Que producto quieres comprar?");

                    productoComprar = sc.nextInt();
                    break;



            }

        }while(opcion != 4);
    }
}
