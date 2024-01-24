package repository;

import entities.Brand;
import entities.Shareholder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Shareholder loadShareholder (int shareholderId) throws SQLException {
        String loadBrand = "select * from shareholder where shareholder_id=?;";
        PreparedStatement ps = connection.prepareStatement(loadBrand);
        ps.setInt(1, shareholderId);

        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            int shareholder_id = resultSet.getInt("shareholder_id");
            String shareholderName = resultSet.getString("name");
            int nationalCode = resultSet.getInt("national_code");
            int phoneNumber = resultSet.getInt("phone-number");

            return new Shareholder(shareholder_id,shareholderName,nationalCode,phoneNumber);

        } else {
            System.out.println("the shareholder id does not exist " + shareholderId);

        }
        return null;
    }

}
