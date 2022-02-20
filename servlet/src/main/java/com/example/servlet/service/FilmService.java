package com.example.servlet.service;


import com.example.servlet.model.Film;

import java.sql.Date;
import java.util.List;

public interface FilmService extends AbstractService<Film, Long> {
    List<Film> getAllByRateDate(Date rateDate);
}
