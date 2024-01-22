package repository;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public int SignUp(User user) throws SQLException {
        String signUp = "insert into userr(name, username, email, password) values (?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(signUp);
        ps.setString(1, user.getName());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getUserPasswordl());

        return ps.executeUpdate();
    }
}
