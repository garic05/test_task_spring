package com.example.servlet.dao;

import com.example.servlet.model.Film;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

@Repository
public class FilmDaoImpl extends AbstractDaoImpl<Film, Long> implements FilmDao{
    public FilmDaoImpl() {
        super(Film.class);
    }

    @Override
    public List<Film> getAllByRateDate(Date rateDate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Film> root = cq.from(Film.class);
        CriteriaQuery<Film> select = cq.select(root).where(cb.equal(root.get("rateDate"), new Date(rateDate.getTime())));
        return entityManager.createQuery(select).getResultList();
    }
}
