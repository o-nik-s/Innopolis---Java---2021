package ru.pcs.jpa.repositories;

import ru.pcs.jpa.models.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * 25.10.2021
 * 32. JPA
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CoursesRepositoryJpaImpl implements CoursesRepository {

    private final EntityManager entityManager;

    public CoursesRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Course course) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(course);
        transaction.commit();
    }

    @Override
    public List<Course> findAllByLesson_name(String name) {
        TypedQuery<Course> query = entityManager.createQuery("select course from Course course " +
                "left join course.lessons lesson where lesson.name = :name", Course.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
