package repository;

import entities.Brand;
import entities.Product;

import java.sql.*;

public class ProductRepository {
    private final Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public int saveProduct(Product product) throws SQLException {
        String savePrandQuery = "insert into product(name, create_date, category_id, brand_id) values (?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(savePrandQuery);
        ps.setString(1, product.getProductName());
        ps.setDate(2, product.getProductDate());
        ps.setInt(3, product.getCategoryId());
        ps.setInt(4, product.getBrandId());

        int result = ps.executeUpdate();
        return result;
    }

    public int editProduct(Product product) throws SQLException {
        String editProductQuery = "update product set name=?,create_date=?,category_id=?,brand_id=? where category_id=?;";
        PreparedStatement ps = connection.prepareStatement(editProductQuery);
        ps.setString(1, product.getProductName());
        ps.setDate(2, product.getProductDate());
        ps.setInt(3, product.getCategoryId());
        ps.setInt(4, product.getBrandId());
        ps.setInt(5,product.getProductId());

        return ps.executeUpdate();
    }

    public int deleteProduct(int productId) throws SQLException {
        String deleteProductQuery = "delete from product where product_id=?;";
        PreparedStatement ps = connection.prepareStatement(deleteProductQuery);
        ps.setInt(1, productId);

        return ps.executeUpdate();

    }

    public Product loadProduct(int productId) throws SQLException {
        String loadProduct = "select * from product where product_id=?;";
        PreparedStatement ps = connection.prepareStatement(loadProduct);
        ps.setInt(1, productId);

        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            int product_id = resultSet.getInt("product_id");
            String name = resultSet.getString("name");
            Date createDate = resultSet.getDate("create_date");
            int category_id = resultSet.getInt("category_id");
            int brand_id = resultSet.getInt("brand_id");


            return new Product(product_id, name, createDate, category_id, brand_id);

        } else {
            System.out.println("the product id is not exist " + productId);

        }
        return null;
    }

    public Product findProductById(int id) throws SQLException {
        String findPQuery="select * from product where product_id=?;";
        PreparedStatement ps= connection.prepareStatement(findPQuery);
        ps.setInt(1,id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            int productId = resultSet.getInt(1);
            String productName = resultSet.getString(2);
            Date date = resultSet.getDate(3);
            int categoryId = resultSet.getInt(4);
            int brandid1 = resultSet.getInt(5);

            return new Product(productId,productName,date,categoryId,brandid1);


        }
        return  null;
    }

    public  int deleteByBrandId(int brandId) throws SQLException {
        String deleteQuery = "delete from product where brand_id=?;";
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        ps.setInt(1, brandId);

        return ps.executeUpdate();
    }

    public  int deleteByCategoryId(int categoryId) throws SQLException {
        String deleteQuery = "delete from product where category_id=?;";
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        ps.setInt(1, categoryId);

        return ps.executeUpdate();
    }
}
