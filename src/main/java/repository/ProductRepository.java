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
}
