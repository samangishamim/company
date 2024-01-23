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
    public int editCategory (Category category) throws SQLException {
        String editCategoryQuery = "update category set name=?,description=? where category_id=?;";
        PreparedStatement ps = connection.prepareStatement(editCategoryQuery);
        ps.setString(1, category.getCategoryName());
        ps.setString(2, category.getCategoryDescription());

        return ps.executeUpdate();
    }
    public int deleteCategory(int categoryId) throws SQLException {
        String deleteCategoryQuery = "delete from category where category_id=?;";
        PreparedStatement ps = connection.prepareStatement(deleteCategoryQuery);
        ps.setInt(1,categoryId );

        return ps.executeUpdate();

    }
}
