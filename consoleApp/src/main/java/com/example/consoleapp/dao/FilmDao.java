package com.example.consoleapp.dao;

import com.example.consoleapp.model.Film;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FilmDao extends AbstractDao<Film, Long> {
    List<Film> getAllByRateDate(Date rateDate);
}
