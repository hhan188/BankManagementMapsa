package repository;

import org.hibernate.Session;

public class CRUD<T> {
    private final Class<T> type;

    public CRUD(Class<T> type) {
        this.type = type;
    }

    public int create(Session connection, T entity) {
        connection.beginTransaction();
        int userId = (Integer) connection.save(entity);
        connection.getTransaction().commit();
        connection.close();
        return userId;
    }

    public void update(Session connection, T entity) {
        connection.beginTransaction();
        connection.update(entity);
        connection.getTransaction().commit();
        connection.close();
    }

    public void delete(Session connection, T entity) {
        //todo: safe Delete
        connection.beginTransaction();
        connection.update(entity);
        connection.getTransaction().commit();
        connection.close();
    }
    //todo:criteria
  /*  public T getById(Integer id,Session connection){
        T entity = connection.get(type , id);
        connection.close();
        return entity;
    }*/

}
