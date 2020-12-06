package org.example.dao;

import org.example.entity.Star;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StarDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public StarDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Star> getStars() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Star> query = currentSession.createQuery("from Star");

        return query.getResultList();
    }

    public void saveOrUpdateStar(Star star) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(star);
    }
}
