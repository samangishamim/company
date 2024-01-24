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
}
