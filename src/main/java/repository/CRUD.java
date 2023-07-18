package repository;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CRUD<T> {
    private final Class<T> type;

    public CRUD(Class<T> type) {
        this.type = type;
    }

    public void create(Session connection, T entity) {
        connection.beginTransaction();
        connection.saveOrUpdate(entity);
        connection.getTransaction().commit();
        connection.close();

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
 /*   public T getEntityByColumnName(Session connection, T entity, String column) {
        Query query = connection.createQuery("from " + entity + " where " + column + " like = :column");
        query.setString(column, entity.);
        Employee emp = (Employee) query.uniqueResult();
        connection.beginTransaction();
        T entity = connection.get(type, );
        if (entity == null) {
            return null;
        }
        connection.close();
        return entity;
    }*/

}
