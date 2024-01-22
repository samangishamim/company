package repository;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
@Getter
@Setter
public class ShareHolderRepository {
    private final Connection connection;

    public ShareHolderRepository(Connection connection) {
        this.connection = connection;
    }
}
