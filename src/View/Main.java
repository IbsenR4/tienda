/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Logic.Store;
import Model.Product;
import java.util.Scanner;

/**
 *
 * @author Ibsen
 */
public class Main {

    static void showProducts(Store store) {
        if (store.getProducts().isEmpty()) {
            System.out.println("\nNo hay productos en la lista\n");
        } else {
            for (int i = 0; i < store.getProducts().size(); i++) {
                Product product = store.getProducts().get(i);
                System.out.println(i + ") NOMBRE: " + product.getName() + " CANTIDAD: " + product.getQuantity());
            }
        }
    }

    static void menu() {
        Store store = new Store();
        boolean isRuning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRuning) {
            System.out.println("-----ALEX PONME LA RIATA EN EL HOCICO by menma-----");
            System.out.println("Ingresa una opcion:");
            System.out.println("1) Ver productos");
            System.out.println("2) Agregar producto");
            System.out.println("3) Modificar producto");
            System.out.println("4) Vender producto");
            System.out.println("5) Comprar producto");
            System.out.println("0) Salir de la aplicacion");
            int menuSelection = scanner.nextInt();
            switch (menuSelection) {
                case 0:
                    isRuning = false;
                    break;
                case 1:
                    showProducts(store);
                    break;
                case 2:
                    Scanner scanner2 = new Scanner(System.in);
                    Product product;
                    String productName;
                    int productQuantity;
                    System.out.println("Ingrese el nombre del producto");
                    productName = scanner2.nextLine();
                    System.out.println("Ingrese la cantidad de " + productName);
                    productQuantity = scanner2.nextInt();
                    product = new Product(productName, productQuantity);
                    store.addToProducts(product);
                    System.out.println("Producto añadido con exito");
                    break;
                case 3:
                    showProducts(store);
                    if (!store.getProducts().isEmpty()) {
                        System.out.println("Ingresa el numero del producto que quieres modificar");
                        int productToChange = scanner.nextInt();
                        System.out.println("Ingresa la nueva cantidad del producto");
                        int productNewQuantity = scanner.nextInt();
                        if (store.changeProductQuantity(productToChange, productNewQuantity)) {
                            System.out.println("Cantidad del producto cambiada con exito");
                        } else {
                            System.out.println("No ingresaste un numero valido");
                        }
                    }
                    break;
                case 4:
                    showProducts(store);
                    if (!store.getProducts().isEmpty()) {
                        System.out.println("Ingresa el numero del producto que quieres vender");
                        int productToChange = scanner.nextInt();
                        try {
                            if (store.getProducts().get(productToChange).getQuantity() == 0) {
                                System.out.println("El producto tiene 0 existencias");
                            } else {
                                System.out.println("Ingresa la cantidad del producto a vender");
                                int quantityToSell = scanner.nextInt();
                                if (quantityToSell > store.getProducts().get(productToChange).getQuantity()) {
                                    System.out.println("La cantidad a vender es mayor a las existentes");
                                } else {
                                    if (store.sellProductQuantity(productToChange, quantityToSell)) {
                                        System.out.println("Cantidad del producto vendida con exito");
                                    } else {
                                        System.out.println("No ingresaste un numero valido");
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("No ingresaste un numero valido");
                        }

                    }
                    break;
                case 5:
                    showProducts(store);
                    if (!store.getProducts().isEmpty()) {
                        System.out.println("Ingresa el numero del producto que quieres comprar");
                        int productToChange = scanner.nextInt();
                        System.out.println("Ingresa la cantidad del producto que quieres comprar");
                        int productQuantityToBuy = scanner.nextInt();
                        if (store.addProductQuantity(productToChange, productQuantityToBuy)){
                            System.out.println("Cantidad comprada con exito");
                        } else {
                            System.out.println("No ingresaste un numero de producto valido");
                        }
                    }
                    break;
                default:
                    System.out.println("Esta opcion no es valida");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
