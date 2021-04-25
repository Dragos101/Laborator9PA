import MoviesEntity.MoviesEntity;
import repository.MovieRepo;
import singleton.ManageEntityManagerObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = ManageEntityManagerObject.getFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        MovieRepo movieRepo = new MovieRepo(entityManager);

        MoviesEntity film = new MoviesEntity();
        MoviesEntity film2 = new MoviesEntity();
        film.setDurata("10h");
        film.setId("10");
        film.setNume("TEST");
        film2.setDurata("10h");
        film2.setId("11");
        film2.setNume("TEST");

        try{
            transaction.begin();
            movieRepo.create(film2);
            movieRepo.getById("10");
            movieRepo.findByName("TEST");
        } finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
