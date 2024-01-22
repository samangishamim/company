package repository;

import entities.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BrandRepository {
    private final Connection connection;

    public BrandRepository(Connection connection) {
        this.connection = connection;
    }

    public int saveBrand(Brand brand) throws SQLException {
        String saveBrandQuery="insert into brand(name, website, description) values (?,?,?);";
        PreparedStatement ps=connection.prepareStatement(saveBrandQuery);
        ps.setString(1,brand.getBrandName());
        ps.setString(2,brand.getWebsite());
        ps.setString(3,brand.getBrandDescription());

        int result= ps.executeUpdate();
        return result;
    }
}
