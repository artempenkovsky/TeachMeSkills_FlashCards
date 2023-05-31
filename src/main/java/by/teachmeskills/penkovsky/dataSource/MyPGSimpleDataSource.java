package by.teachmeskills.penkovsky.dataSource;

import org.postgresql.ds.PGSimpleDataSource;

public class MyPGSimpleDataSource extends PGSimpleDataSource {
    private static volatile MyPGSimpleDataSource instance;

    private MyPGSimpleDataSource() {
    }

    public static MyPGSimpleDataSource getInstance() {
        if (instance == null)
            synchronized (MyPGSimpleDataSource.class) {
                if (instance == null) {
                    instance = new MyPGSimpleDataSource();
                    instance.setURL(System.getenv("URL"));
                    instance.setUser(System.getenv("user"));
                    instance.setPassword(System.getenv("password"));
                }
            }
        return instance;
    }
}
