package repository;

import MoviesEntity.MoviesEntity;
import generic.AbstractRepository;

import javax.persistence.EntityManager;

public class TestMovieRepo extends AbstractRepository<MoviesEntity> {

    public TestMovieRepo(EntityManager em, Class<MoviesEntity> moviesEntityClass) {
        super(em, moviesEntityClass);
    }
}
