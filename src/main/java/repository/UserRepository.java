package repository;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public int SignUp(User user) throws SQLException {
        String signUp = "insert into \"user\"(name, username, email, password) values (?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(signUp);
        ps.setString(1, user.getName());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getUserPasswordl());

        return ps.executeUpdate();
    }

    public boolean isUsernameExist(String username) throws SQLException {
    String existQuery="select * from \"user\" where username=?;";
        PreparedStatement ps = connection.prepareStatement(existQuery);
        ps.setString(1, username);

        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();
    }
    public boolean isEmailExist(String email) throws SQLException {
        String existQuery="select * from \"user\" where email=?;";
        PreparedStatement ps = connection.prepareStatement(existQuery);
        ps.setString(1, email);

        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();
    }

    public boolean SignIn(String username , String password)  throws SQLException {
        String signIn = "select * from \"user\" where username=? and password=?;";
        PreparedStatement ps = connection.prepareStatement(signIn);
        ps.setString(1, username);
        ps.setString(2, password);

        return ps.executeQuery().next();
    }
}
