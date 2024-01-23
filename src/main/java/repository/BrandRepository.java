package repository;

import entities.Brand;
import entities.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRepository {
    private  final  Connection connection ;

    public BrandRepository(Connection connection) {
        this.connection = connection;
    }

    public  int saveBrand(Brand brand) throws SQLException {
        String saveBrandQuery = "insert into brand(name, website, description) values (?,?,?);";
        PreparedStatement ps = connection.prepareStatement(saveBrandQuery);
        ps.setString(1, brand.getBrandName());
        ps.setString(2, brand.getWebsite());
        ps.setString(3, brand.getBrandDescription());

        int result = ps.executeUpdate();
        return result;
    }

    public Brand load(int brandId) throws SQLException {
        String loadBrand = "select * from brand where brand_id=?;";
        PreparedStatement ps = connection.prepareStatement(loadBrand);
        ps.setInt(1, brandId);

        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            int brand_id = resultSet.getInt("brand_id");
            String name = resultSet.getString("name");
            String website = resultSet.getString("website");
            String description = resultSet.getString("description");

            return new Brand(brand_id, name, website, description);

        } else {
            System.out.println("the brand id is not exist " + brandId);

        }
        return null;
    }

    public int edit(Brand brand) throws SQLException {
        String editBrand = "update brand set name=?,website=?,description=? where brand_id=?;";
        PreparedStatement ps = connection.prepareStatement(editBrand);
        ps.setString(1, brand.getBrandName());
        ps.setString(2, brand.getWebsite());
        ps.setString(3, brand.getBrandDescription());
        ps.setInt(4, brand.getBrandId());

        return ps.executeUpdate();
    }


    public int delete(int brandId) throws SQLException {
        String deleteQuery = "delete from brand where brand_id=?;";
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        ps.setInt(1, brandId);

        return ps.executeUpdate();

    }

    public boolean isBrandNameExist(String brandName) throws SQLException {
        String brandNameQuery = "select * from brand where name=?;";
        PreparedStatement ps = connection.prepareStatement(brandNameQuery);
        ps.setString(1, brandName);

        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();

    }

    public boolean isBrandIdExist(int brandId) throws SQLException {
        String brandNameQuery = "select * from brand where brand_id=?;";
        PreparedStatement ps = connection.prepareStatement(brandNameQuery);
        ps.setInt(1, brandId);

        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();

    }

    public Brand[] listOfBrand() throws SQLException {
        String brandQuery = "select * from brand;";
        PreparedStatement ps = connection.prepareStatement(brandQuery,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = ps.executeQuery();
        int counter = 0;
        while ((resultSet.next())) {
            counter++;
        }
        Brand[] brands = new Brand[counter];
        resultSet.beforeFirst();
        int k = 0;
        while (resultSet.next()) {
            int brandId = resultSet.getInt(1);
            String brandName = resultSet.getString(2);
            String website = resultSet.getString(3);
            String description = resultSet.getString(4);

            brands[k++] = new Brand(brandId, brandName, website, description);
        }
        return brands;
    }

    public Brand[] listOfBrandShareholder(int id) throws SQLException {
        String brandQuery = "select * from brand;";
        PreparedStatement ps = connection.prepareStatement(brandQuery,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = ps.executeQuery();

        int counter = getCounter(resultSet);
        Brand[] brands = new Brand[counter];

        resultSet.beforeFirst();
        int k = 0;
        while (resultSet.next()) {
            int brandId = resultSet.getInt(1);
            String brandName = resultSet.getString(2);
            String website = resultSet.getString(3);
            String description = resultSet.getString(4);


            ResultSet resultSet1 = getResualtSet(id);
            counter = getCounter(resultSet1);
            Shareholder[] shareholders = new Shareholder[counter];

            counter = 0;
            resultSet1.beforeFirst();
            while (resultSet1.next()) {
                int shareholderId = resultSet1.getInt(1);
                shareholders[counter++] = getShareholder(shareholderId);
            }
            brands[k++] = new Brand(brandId,brandName,website,description);
        }
        return brands;
    }

    private Shareholder getShareholder(int shareholderId) throws SQLException {
        String shareholderQuery="select * from shareholder where shareholder_id=?;";
        PreparedStatement ps2= connection.prepareStatement(shareholderQuery);
        ps2.setInt(1,shareholderId);

        ResultSet resultSet3 = ps2.executeQuery();
        if (resultSet3.next()){
            int shareholder_Id=resultSet3.getInt(1);
            String shareholderName = resultSet3.getString(2);
            int phoneNumber = resultSet3.getInt(3);
            int nationalCode = resultSet3.getInt(4);
            return  new Shareholder(shareholderId,shareholderName,nationalCode,phoneNumber);
        }
        return null;
    }


    private ResultSet getResualtSet(int id) throws SQLException {
        String shareholderQuery = "select shareholder_id from shareholder_brand where  brand_id=?;";
        PreparedStatement ps = connection.prepareStatement(shareholderQuery,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ps.setInt(1, id);

        ResultSet resultSet2 = ps.executeQuery();
        return resultSet2;
    }

    private int getCounter(ResultSet resultSet) throws SQLException {
        int counter = 0;
        while ((resultSet.next())) {
            counter++;
        }
        return counter;
    }
    public boolean isBrandWebsiteExist(String brandName) throws SQLException {
        String brandNameQuery = "select * from brand where website=?;";
        PreparedStatement ps = connection.prepareStatement(brandNameQuery);
        ps.setString(1, brandName);

        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();

    }
}
