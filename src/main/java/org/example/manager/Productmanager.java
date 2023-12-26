package org.example.manager;

import org.example.db.DBConnectionProvider;
import org.example.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Productmanager {
    Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void add(Product product) {
        String query = "INSERT INTO product(name,description,price,quantity,category_id) VALUES(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setInt(5, product.getCategory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProduct() {
        String sql = "SELECT * FROM product";
        List<Product> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                int categoryid = resultSet.getInt("category_id");
                Product product = new Product(id, name, description, price, quantity, categoryid);
                result.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM product WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                int categoryid = resultSet.getInt("category_id");
                Product product = new Product(id, name, description, price, quantity, categoryid);
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateProductById(Product product) {
        if (getProductById(product.getId()) == null) {
            System.out.println("Product with ID " + product.getId() + " does not exist.");
            return;
        }
        String query = "UPDATE product SET name=?,description=?,price=?,quantity=?,category_id=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setInt(5, product.getCategory_id());
            preparedStatement.setInt(6, product.getId());
            preparedStatement.executeUpdate();
            System.out.println("Product with ID " + product.getId() + " updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteProductById(int id) {
        if (getProductById(id) == null) {
            System.out.println("PRODUCT WITH" + id + " ID DOSE NOT EXISTS");
            return;
        }
        String sql = "delete from product where id=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(sql);
            System.out.println("PRODUCT WAS REMOVED!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public int getProductcount() {
        String sql = "SELECT COUNT(*) AS product_count FROM product";
        int count = 0;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                count = resultSet.getInt("product_count");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

    }

    public double getMaxPrice() {
        String sql = "SELECT MAX(price) AS product_max FROM product";
        double max = 0;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                max = resultSet.getInt("product_max");


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return max;
    }

    public double getMinPrice() {
        String sql = "SELECT MIN(price) AS product_min FROM product";
        double min = 0;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                min = resultSet.getInt("product_min");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return min;

    }

    public double getAVGPrice() {
        String sql = "SELECT AVG(price) AS product_avg FROM product";
        double avg = 0;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                avg = resultSet.getInt("product_avg");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avg;

    }

}
