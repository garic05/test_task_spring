package com.example.consoleapp.service;


import com.example.consoleapp.model.Film;

import java.sql.Date;
import java.util.List;

public interface FilmService extends AbstractService<Film, Long> {
    List<Film> getAllByRateDate(Date rateDate);
}
