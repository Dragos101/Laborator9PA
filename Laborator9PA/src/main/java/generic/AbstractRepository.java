package generic;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class AbstractRepository<T> {

    protected EntityManager entityManager;
    protected final Class<T> tClass;

    public AbstractRepository(EntityManager em, Class<T> tClass){
        this.tClass = tClass;
        this.entityManager = em;
    }

    public void create(T d){
        entityManager.merge(d);
        entityManager.getTransaction().commit();
    }

    public T getById(String id){
        T ceva = entityManager.find(tClass, id);
        System.out.println(ceva.toString());
        return ceva;
    }

    public void findByName(String name){
        TypedQuery<T> query = entityManager.createNamedQuery("film.Querry", tClass);
        query.setParameter(1, name);
        for(T e : query.getResultList())
            System.out.println(e);
    }

}
