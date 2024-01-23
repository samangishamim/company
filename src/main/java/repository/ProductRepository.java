package repository;

import entities.Brand;
import entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepository {
    private final Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }
    public int saveProduct(Product product) throws SQLException {
        String savePrandQuery = "insert into product(name, create_date, category_id, brand_id) values (?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(savePrandQuery);
        ps.setString(1,product.getProductName() );
        ps.setInt(2,product.getProductDate());
        ps.setInt(3, product.getCategoryId());
        ps.setInt(4,product.getBrandId());

        int result = ps.executeUpdate();
        return result;
    }
    public int editProduct(Product product) throws SQLException {
        String editProductQuery = "update product set name=?,create_date=?,category_id=?,brand_id=? where category_id=?;";
        PreparedStatement ps = connection.prepareStatement(editProductQuery);
        ps.setString(1, product.getProductName());
        ps.setInt(2,product.getProductDate());
        ps.setInt(3, product.getCategoryId());
        ps.setInt(4,product.getBrandId());

        return ps.executeUpdate();
    }
    public int deleteProduct (int productId) throws SQLException {
        String deleteProductQuery = "delete from product where product_id=?;";
        PreparedStatement ps = connection.prepareStatement(deleteProductQuery);
        ps.setInt(1, productId);

        return ps.executeUpdate();

    }

}
