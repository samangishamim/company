package repository;

import entities.ShareholderBrand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderBrandRepository {
    private final Connection connection;
    Scanner scanner = new Scanner(System.in);


    public ShareholderBrandRepository(Connection connection) {
        this.connection = connection;
    }
    public int save(ShareholderBrand shareholderBrand) throws SQLException {
        String addShareholderBrandQuery = "insert into shareholder_brand ( shareholder_id, brand_id)values (?,?);";
        PreparedStatement ps = connection.prepareStatement(addShareholderBrandQuery);
        ps.setInt(1, shareholderBrand.getShareholderId());
        ps.setInt(2,shareholderBrand.getBrandId());

        int result = ps.executeUpdate();
        return result;

    }
    public int deleteShareholderBrandId (int shareholderBrandId) throws SQLException {
        String deleteShareholderQuery = "delete from shareholder_brand where shareholder_id=?;";
        PreparedStatement ps = connection.prepareStatement(deleteShareholderQuery);
        ps.setInt(1, shareholderBrandId);

        return ps.executeUpdate();

    }
    public int deleteByBrandId(int brandId) throws SQLException {
        String deleteShareholderBQuery="delete from shareholder_brand where brand_id=?;";
        PreparedStatement ps=connection.prepareStatement(deleteShareholderBQuery);
        ps.setInt(1,brandId);
        return  ps.executeUpdate();
    }
    public int deleteByShareholderId(int shareholderId) throws SQLException {
        String deleteShareholderBQuery="delete from shareholder_brand where shareholder_id=?;";
        PreparedStatement ps=connection.prepareStatement(deleteShareholderBQuery);
        ps.setInt(1,shareholderId);
        return  ps.executeUpdate();
    }

}
