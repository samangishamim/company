package repository;

import entities.Brand;
import entities.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepository {
    private final Connection connection;

    public CategoryRepository(Connection connection) {
        this.connection = connection;
    }

    public int saveCategory(Category category) throws SQLException {
        String saveCategoryQuery = "insert into category(name,description)values (?,?);";
        PreparedStatement ps = connection.prepareStatement(saveCategoryQuery);
        ps.setString(1, category.getCategoryName());
        ps.setString(2, category.getCategoryDescription());

        int result = ps.executeUpdate();
        return result;
    }

    public int editCategory(Category category) throws SQLException {
        String editCategoryQuery = "update category set name=?,description=? where category_id=?;";
        PreparedStatement ps = connection.prepareStatement(editCategoryQuery);
        ps.setString(1, category.getCategoryName());
        ps.setString(2, category.getCategoryDescription());
        ps.setInt(3,category.getCategoryId());

        return ps.executeUpdate();
    }

    public int deleteCategory(int categoryId) throws SQLException {
        String deleteCategoryQuery = "delete from category where category_id=?;";
        PreparedStatement ps = connection.prepareStatement(deleteCategoryQuery);
        ps.setInt(1, categoryId);

        return ps.executeUpdate();

    }

    public boolean isCategoryNameExist(String categoryName) throws SQLException {
        String categoryNameQuery = "select * from category where name=?;";
        PreparedStatement ps = connection.prepareStatement(categoryNameQuery);
        ps.setString(1, categoryName);

        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();

    }

    public Category[] listOfCategory() throws SQLException {
        String listCategory = "select * from category ;";
        PreparedStatement ps= connection.prepareStatement(listCategory,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = ps.executeQuery();
        int counter=0;
        while (resultSet.next()) counter++;
        Category[] categories=new Category[counter];
        counter=0;
        resultSet.beforeFirst();
        while (resultSet.next()){
            int categoryId = resultSet.getInt(1);
            String categoryName = resultSet.getString(2);
            String categoryDescription = resultSet.getString(3);


            categories[counter++]=new Category(categoryId,categoryName,categoryDescription);

        }
        return categories;
    }

    public Category findByCategoryId(int categoryId) throws SQLException {
        String findQuery="select * from category where category_id=?;";
        PreparedStatement ps=connection.prepareStatement(findQuery);
        ps.setInt(1,categoryId);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()){
            int categoryId1 = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);

            return new Category(categoryId1,name,description);
        }
        return  null;
    }
}
