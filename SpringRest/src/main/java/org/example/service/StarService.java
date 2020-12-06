package org.example.service;

import org.example.dao.StarDao;
import org.example.entity.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StarService {

    @Autowired
    private StarDao starDao;

    @Transactional
    public List<Star> getStars() {
        return starDao.getStars();
    }

    @Transactional
    public void saveOrUpdate(Star star) {
        starDao.saveOrUpdateStar(star);
    }
}
