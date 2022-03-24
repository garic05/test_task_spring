package com.example.consoleapp.dao;

import com.example.consoleapp.model.Film;

import java.sql.Date;
import java.util.List;

public interface FilmDao extends AbstractDao<Film, Long> {
    List<Film> getAllByRateDate(Date rateDate);
}
