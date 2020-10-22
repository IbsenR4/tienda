/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Model.Product;
import java.util.ArrayList;

/**
 *
 * @author Ibsen
 */
public class Store {

    private ArrayList<Product> products;

    public Store() {
        products = new ArrayList<Product>();
    }

    public void addToProducts(Product product) {
        products.add(product);
    }

    public boolean changeProductQuantity(int position, int newQuantity) {
        try {
            products.get(position).setQuantity(newQuantity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addProductQuantity(int position, int quantityToAdd) {
        try {
            Product product = products.get(position);
            products.get(position).setQuantity(product.getQuantity() + quantityToAdd);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean sellProductQuantity(int position, int quantityToSell) {
        try {
            Product product = products.get(position);
            products.get(position).setQuantity(product.getQuantity() - quantityToSell);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean changeProductName(int position, String newName) {
        try {
            products.get(position).setName(newName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}
