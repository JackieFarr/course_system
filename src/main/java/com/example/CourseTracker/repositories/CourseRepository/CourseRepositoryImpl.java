package com.example.CourseTracker.repositories.CourseRepository;

import com.example.CourseTracker.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> getAllCoursesWithRating(int rating) {
        List<Course> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Course.class);
            cr.add(Restrictions.eq("rating", rating));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }

    @Transactional
    public List<Course> getAllCoursesForCustomer(Long customerId) {
        List<Course> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.customer.id", customerId));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }

    @Transactional
    public List<Course> getAllCoursesWithTown(String town) {
        List<Course> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Course.class);
            cr.add(Restrictions.eq("town", town));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }

}
