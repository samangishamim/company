package repository;

import entities.Brand;
import entities.Shareholder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
public class ShareHolderRepository {
    private final Connection connection;

    public ShareHolderRepository(Connection connection) {
        this.connection = connection;
    }

    public  int addShareholder(Shareholder shareholder) throws SQLException {
        String addShareholderQuery = "insert into shareholder (name, national_code, phone_number) values (?,?,?);";
        PreparedStatement ps = connection.prepareStatement(addShareholderQuery);
        ps.setString(1, shareholder.getShareholderName());
        ps.setInt(2, shareholder.getNationalCode());
        ps.setInt(3, shareholder.getPhoneNumber());

        int result = ps.executeUpdate();
        return result;
    }

}
