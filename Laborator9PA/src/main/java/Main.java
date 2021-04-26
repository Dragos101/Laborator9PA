import MoviesEntity.MoviesEntity;
import repository.MovieRepo;
import repository.TestMovieRepo;
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
        TestMovieRepo test = new TestMovieRepo(entityManager, MoviesEntity.class );

        MoviesEntity film = new MoviesEntity();
        MoviesEntity film2 = new MoviesEntity();
        MoviesEntity film3 = new MoviesEntity();
        film.setDurata("10h");
        film.setId("10");
        film.setNume("TEST");
        film2.setDurata("10h");
        film2.setId("11");
        film2.setNume("TEST");
        film3.setDurata("1.5h");
        film3.setId("100");
        film3.setNume("TEST-abstract");



        try{
            transaction.begin();
            test.create(film3);
            //movieRepo.create(film2);
            movieRepo.getById("100");
            movieRepo.findByName("TEST-abstract");
        } finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
