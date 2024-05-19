package put.io.testing.mocks;

import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;
import java.util.List;

public class MyDatabase implements IFancyDatabase {

    @Override
    public void connect() {}

    @Override
    public <T> void persist(T entity) {}

    @Override
    public void close() {}

    @Override
    public <T> List<T> queryAll() {
        return Collections.emptyList ();
    }
}
