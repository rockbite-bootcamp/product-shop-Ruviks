package com.company;
import java.util.ArrayList;
import java.util.stream.Collectors;

//ideally should use Singleton pattern
public class Shop implements  IShop{
    private int index=0;
    //could have stored products in a hashmap <Category,Product>,but different products can correspons to the same
    //category,so i used arraylist
    private  ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Product> boughtproducts = new ArrayList<>();
    private static volatile Shop instance = new Shop();
    //private constructor.
    private Shop(){

    }


    public static Shop getInstance() {
        return instance;
    }

    @Override
    public void addProduct(Product product) {
        if(this.products.contains(product)) return;
        product.setID(index);index++;
        this.products.add(product);

    }

    @Override
    public void removeProduct(Product product) {
        if(this.products.contains(product)) this.products.remove(product);
    }

    @Override
    public Product getProductbyID(long ID) {
        return products.get((int) ID);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public ArrayList<Product> getBoughtproducts() {
        return boughtproducts;
    }

    @Override
    public ArrayList<Product> getProductsbyCategory(Category category) {
        ArrayList<Product> result = new ArrayList<>();

        return (ArrayList<Product>) products.stream().
                filter(x -> x.getCategory().equals(category)).
                collect(Collectors.toList());
    }
}
