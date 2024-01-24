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

    public  int saveShareholder(Shareholder shareholder) throws SQLException {
        String addShareholderQuery = "insert into shareholder (name, national_code, phone_number) values (?,?,?);";
        PreparedStatement ps = connection.prepareStatement(addShareholderQuery);
        ps.setString(1, shareholder.getShareholderName());
        ps.setString(2, shareholder.getNationalCode());
        ps.setString(3, shareholder.getPhoneNumber());

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
            String nationalCode = resultSet.getString("national_code");
            String phoneNumber = resultSet.getString("phone-number");

            return new Shareholder(shareholder_id,shareholderName,nationalCode,phoneNumber);

        } else {
            System.out.println("the shareholder id does not exist " + shareholderId);

        }
        return null;
    }

    public int editShareholder (Shareholder shareholder) throws SQLException {
        String editShareholderQuery = "update shareholder set name=?,national_code=?,phone_number=? where shareholder_id=?;";
        PreparedStatement ps = connection.prepareStatement(editShareholderQuery);
        ps.setString(1,shareholder.getShareholderName());
        ps.setString(2, shareholder.getNationalCode());
        ps.setString(3, shareholder.getPhoneNumber());
        ps.setInt(4, shareholder.getShareholderId());

        return ps.executeUpdate();
    }
    public Shareholder[] listOfShareholder() throws SQLException {
        String shareholderQuery = "select * from shareholder;";
        PreparedStatement ps = connection.prepareStatement(shareholderQuery,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = ps.executeQuery();
        int counter = 0;
        while ((resultSet.next())) {
            counter++;
        }
        Shareholder[] shareholders = new Shareholder[counter];
        resultSet.beforeFirst();
        int k = 0;
        while (resultSet.next()) {
            int shareholderId=resultSet.getInt(1);
            String shareholderName = resultSet.getString(2);
            String nationalCode = resultSet.getString(3);
            String phoneNumber = resultSet.getString(4);


            shareholders[k++] = new Shareholder(shareholderId,shareholderName,nationalCode,phoneNumber);
        }
        return shareholders;
    }

}
