package com.kdelectronics.main;

import com.kdelectronics.dao.ProductoDAO;
import com.kdelectronics.modelo.Producto;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ProductoDAO dao = new ProductoDAO();
        int opcion;

        do {
            System.out.println("\n==== CRUD PRODUCTOS ====");
            System.out.println("1. Insertar");
            System.out.println("2. Listar");
            System.out.println("3. Eliminar");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    Producto p = new Producto();

                    System.out.print("Código: ");
                    p.setCodigoProducto(entrada.nextLine());

                    System.out.print("Nombre: ");
                    p.setNombreProducto(entrada.nextLine());

                    System.out.print("Descripción: ");
                    p.setDescripcion(entrada.nextLine());

                    System.out.print("Precio Base: ");
                    p.setPrecioBase(entrada.nextDouble());

                    System.out.print("Precio Venta: ");
                    p.setPrecioVenta(entrada.nextDouble());
                    entrada.nextLine();

                    System.out.print("Categoría: ");
                    p.setCategoria(entrada.nextLine());

                    System.out.print("Cantidad Disponible: ");
                    p.setCantidadDisponible(entrada.nextInt());

                    dao.insertar(p);
                    break;

                case 2:
                    List<Producto> lista = dao.listar();
                    for (Producto prod : lista) {
                        System.out.println(prod);
                    }
                    break;

                case 3:
                    System.out.print("Código producto a eliminar: ");
                    String cod = entrada.nextLine();
                    dao.eliminar(cod);
                    break;

                case 0:
                    System.out.println("Bye bye");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }
}