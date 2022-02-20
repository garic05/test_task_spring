package com.example.servlet.dao;

import com.example.servlet.model.Film;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FilmDao extends AbstractDao<Film, Long> {
    List<Film> getAllByRateDate(Date rateDate);
}
