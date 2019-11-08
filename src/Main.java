import BD.BD;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import functions.Pedido;
import functions.compraProducto;
import functions.producto;
public class Main {

    public static void main(String[] args) {
        int opcion = 0;
            compraProducto cp = new compraProducto();
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
                    String nombre = "";
                    List<producto> listap = BD.getListaBD();
                    for (int i = 0; i < listap.size() ; i++) {
                        System.out.println(listap.get(i).getId() + " - "+listap.get(i).getNombre() + listap.get(i).getPrecio()+"€");
                    }
                    System.out.println("Que producto quieres comprar?");

                    productoComprar = sc.nextInt();
                    sc.nextLine();
                    System.out.println("A que nombre va a ir el paquete?");
                    nombre = sc.nextLine();
                    BD.postPedido(nombre);

                    System.out.println("Gracias por su compra");
                    break;

                case 3:
                        sc.nextLine();
                    String nombre_user = "";
                    System.out.println("Cual es tu nombre?");
                    nombre_user = sc.nextLine();
                    List<Pedido> listpe =  BD.getPedido(nombre_user);
                        if (listpe.size()!=0){
                            for (int i = 0; i < listpe.size(); i++) {

                                System.out.println("-------------");
                                switch (listpe.get(i).getEstado_id()) {
                                    case 1:
                                        System.out.println("  El pedido esta en espera ");
                                        System.out.println("-----------------");

                                        break;
                                    case 2:
                                        System.out.println("El pedido esta en camino");
                                        System.out.println("-----------------");
                                        break;
                                    case 3:
                                        System.out.println("El pedido ha sido recibido");
                                        System.out.println("-----------------");
                                        break;
                                    case 4:
                                        System.out.println("El pedido ha sido enviado a Correos por ausencia");
                                        System.out.println("-----------------");
                                        break;
                                    case 5:
                                        System.out.println("El pedido esta en error desconocido");
                                        System.out.println("-----------------");
                                        break;

                                }



                            }

                        }else {
                            System.out.println("No es un ususario valido");
                        }



                    break;



            }

        }while(opcion != 4);
    }
}
