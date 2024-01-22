package repository;

import java.sql.Connection;

public class BrandRepository {
 private final Connection connection;

    public BrandRepository(Connection connection) {
        this.connection = connection;
    }

}
