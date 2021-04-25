package repository;

import MoviesEntity.MoviesEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MovieRepo {

    private EntityManager entityManager;

    public MovieRepo(EntityManager entityManager){this.entityManager = entityManager;}

    public void create(MoviesEntity d){
        entityManager.merge(d);
        entityManager.getTransaction().commit();
    }

    public MoviesEntity getById(String id){
        MoviesEntity film= entityManager.find(MoviesEntity.class, id);
        System.out.println(film.toString());
        return film;
    }

    public void findByName(String name){
        TypedQuery<MoviesEntity> query = entityManager.createNamedQuery("film.Querry", MoviesEntity.class);
        query.setParameter(1, name);
        for(MoviesEntity e : query.getResultList()){
            System.out.println(e);
        }
    }

}
