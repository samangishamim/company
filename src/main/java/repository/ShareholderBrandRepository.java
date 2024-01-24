package repository;

import java.sql.Connection;

public class ShareholderBrandRepository {
    private  final Connection connection;


    public ShareholderBrandRepository(Connection connection) {
        this.connection = connection;
    }
}
