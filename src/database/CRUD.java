package database;

import java.util.ArrayList;

public interface CRUD {
    public Object create(Object object);
    public ArrayList<Object> list();
    public boolean update(Object object);
    public boolean delete(Object object);
}
