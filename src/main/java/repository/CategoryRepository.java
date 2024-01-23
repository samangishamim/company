package repository;

import entities.Brand;
import entities.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryRepository {
    private final Connection connection;

    public CategoryRepository(Connection connection) {
        this.connection = connection;
    }
    public int saveCategory (Category category) throws SQLException {
        String saveCategoryQuery = "insert into category(name,description)values (?,?);";
        PreparedStatement ps = connection.prepareStatement(saveCategoryQuery);
        ps.setString(1, category.getCategoryName());
        ps.setString(2, category.getCategoryDescription());

        int result = ps.executeUpdate();
        return result;
    }
}
