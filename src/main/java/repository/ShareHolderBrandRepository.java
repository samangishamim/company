package repository;

import java.sql.Connection;

public class ShareHolderBrandRepository {
    private final Connection connection;

    public ShareHolderBrandRepository(Connection connection) {
        this.connection = connection;
    }
}
