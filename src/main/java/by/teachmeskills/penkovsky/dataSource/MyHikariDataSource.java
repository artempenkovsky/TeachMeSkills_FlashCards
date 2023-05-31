package by.teachmeskills.penkovsky.dataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MyHikariDataSource {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl(System.getenv("URL"));
        config.setUsername(System.getenv("user"));
        config.setPassword(System.getenv("password"));
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    private MyHikariDataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
