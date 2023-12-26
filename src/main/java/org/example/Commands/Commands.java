package org.example.Commands;

public interface Commands {
    String EXIT = "0";
    String ADD_CATEGORY = "1";
    String EDIT_CATEGORY_BY_ID = "2";
    String DELETE_CATEGORY_BY_ID = "3";
    String ADD_PRODUCT = "4";
    String EDIT_PRODUCT_BY_ID = "5";
    String DELETE_PRODUCT_BY_ID = "6";
    String PRINT_SUM_OF_PRODUCTS = "7";
    String PRINT_MAX_OF_PRICE_PRODUCT = "8";
    String PRINT_MIN_OF_PRICE_PRODUCT = "9";
    String PRINT_AVG_OF_PRICE_PRODUCT = "10";


    static void printCommands() {
        System.out.println("PLEASE INPUT " + EXIT + " FOR EXIT");
        System.out.println("PLEASE INPUT " + ADD_CATEGORY + " FOR ADD_CATEGORY");
        System.out.println("PLEASE INPUT " + EDIT_CATEGORY_BY_ID + " FOR EDIT_CATEGORY_BY_ID");
        System.out.println("PLEASE INPUT " + DELETE_CATEGORY_BY_ID + " FOR DELETE_CATEGORY_BY_ID");
        System.out.println("PLEASE INPUT " + ADD_PRODUCT + " FOR ADD_PRODUCT");
        System.out.println("PLEASE INPUT " + EDIT_PRODUCT_BY_ID + " FOR EDIT_PRODUCT");
        System.out.println("PLEASE INPUT " + DELETE_PRODUCT_BY_ID + " FOR DELETE_PRODUCT_BY_ID");
        System.out.println("PLEASE INPUT " + PRINT_SUM_OF_PRODUCTS + " FOR PRINT_SUM_OF_PRODUCTS");
        System.out.println("PLEASE INPUT " + PRINT_MAX_OF_PRICE_PRODUCT + " FOR PRINT_MAX_OF_PRICE_PRODUCT");
        System.out.println("PLEASE INPUT " + PRINT_MIN_OF_PRICE_PRODUCT + " FOR PRINT_MIN_OF_PRICE_PRODUCT");
        System.out.println("PLEASE INPUT " + PRINT_AVG_OF_PRICE_PRODUCT + " FOR PRINT_AVG_OF_PRICE_PRODUCT");
    }
}

