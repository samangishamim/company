package repository;

import entities.Shareholder;
import entities.ShareholderBrand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShareHolderBrandRepository {
    private final Connection connection;

    public ShareHolderBrandRepository(Connection connection) {
        this.connection = connection;
    }

    public  int saveShareholderBrand(ShareholderBrand shareholderBrand) throws SQLException {
        String addShareholderBrandQuery = "insert into shareholder_brand ( shareholder_id, brand_id)values (?,?);";
        PreparedStatement ps = connection.prepareStatement(addShareholderBrandQuery);
        ps.setInt(1, shareholderBrand.getShareholderId());
        ps.setInt(2,shareholderBrand.getBrandId());

        int result = ps.executeUpdate();
        return result;
    }

}
