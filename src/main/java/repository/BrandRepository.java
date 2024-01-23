package repository;

import entities.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Brand load(int brandId) throws SQLException {
        String loadBrand ="select * from brand where brand_id=?;";
        PreparedStatement ps=connection.prepareStatement(loadBrand);
        ps.setInt(1,brandId);

        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()){
            int brand_id = resultSet.getInt("brand_id");
            String name = resultSet.getString("name");
            String website = resultSet.getString("website");
            String description = resultSet.getString("description");

            return new Brand(brand_id,name,website,description);

        }else{
            System.out.println("the brand id is not exist "+brandId);

        }
        return null;
    }
}
