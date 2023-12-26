package org.example;

import org.example.Commands.Commands;
import org.example.manager.Categorymanager;
import org.example.manager.Productmanager;
import org.example.model.Category;
import org.example.model.Product;

import java.util.Scanner;

public class Main implements Commands {
    private static Productmanager productmanager=new Productmanager();
    private static Categorymanager categorymanager=new Categorymanager();
    private  static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
    boolean isrun =true;
    while (isrun){
        Commands.printCommands();
        String command = scanner.nextLine();
        switch (command){
            case EXIT:
                isrun=false;
                break;
            case ADD_CATEGORY:
                addCategory();
                break;
            case EDIT_CATEGORY_BY_ID:
                editCategory();
                break;
            case DELETE_CATEGORY_BY_ID:
                deleteCategory();
                break;
            case ADD_PRODUCT:
                addProduct();
                break;
            case EDIT_PRODUCT_BY_ID:
                editProduct();
                break;
            case DELETE_PRODUCT_BY_ID:
                deleteProduct();
                break;
            case PRINT_SUM_OF_PRODUCTS:
                printSum();
                break;

            case PRINT_MAX_OF_PRICE_PRODUCT:
                printMax();
                break;
            case PRINT_MIN_OF_PRICE_PRODUCT:
                printMin();
                break;
            case PRINT_AVG_OF_PRICE_PRODUCT:
                printAvg();
                break;
            default:
                System.err.println("WRONG COMMAND TRY AGAIN!!!");

        }
    }

    }

    private static void printAvg() {
        double avg = productmanager.getAVGPrice();
        System.out.println(avg);
    }

    private static void printMin() {
        double min = productmanager.getMinPrice();
        System.out.println(min);
    }

    private static void printMax() {
        double max= productmanager.getMaxPrice();
        System.out.println(max);
    }

    private static void printSum() {
        int sum = productmanager.getProductcount();
        System.out.println(sum);
    }

    private static void deleteProduct() {
        System.out.println("please input product id");
        int id=Integer.parseInt(scanner.nextLine());
        productmanager.deleteProductById(id);
    }

    private static void editProduct() {
        System.out.println("please input product new id");
        int id =Integer.parseInt(scanner.nextLine());
        System.out.println("please input product new name");
        String name = scanner.nextLine();
        System.out.println("please input product new description");
        String description= scanner.nextLine();
        System.out.println("please input product new price");
        double price=Double.parseDouble(scanner.nextLine());
        System.out.println("please input product new quantity");
        int quantity=Integer.parseInt(scanner.nextLine());
        System.out.println("please input product new categoryid");
        int categoryid = Integer.parseInt(scanner.nextLine());
    }

    private static void addProduct() {
        System.out.println("please input product name");
        String name = scanner.nextLine();
        System.out.println("please input product description");
        String description= scanner.nextLine();
        System.out.println("please input product price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("please input product quantity");
        int quantity =Integer.parseInt(scanner.nextLine());
        System.out.println("please input categoryid");
        int categoryid =Integer.parseInt(scanner.nextLine());
        Product product=new Product(name,description,price,quantity,categoryid);
        productmanager.add(product);




    }

    private static void deleteCategory() {
        System.out.println("please input category id");
        int id = Integer.parseInt(scanner.nextLine());
        categorymanager.deleteCategoryById(id);
    }

    private static void editCategory() {
        System.out.println("please input category id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("please input category name");
        String name =scanner.nextLine();
        Category category =new Category(name);
        categorymanager.add(category);

    }

    private static void addCategory() {
        System.out.println("please input category name");
        String name = scanner.nextLine();
        Category category =new Category(name);
        categorymanager.add(category);
    }
}