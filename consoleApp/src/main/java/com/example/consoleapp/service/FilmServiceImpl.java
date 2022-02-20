package com.example.consoleapp.service;

import com.example.consoleapp.dao.FilmDao;
import com.example.consoleapp.model.Film;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class FilmServiceImpl extends AbstractServiceImpl<Film, Long> implements FilmService {

    public FilmServiceImpl(FilmDao abstractDao) {
        super(abstractDao);
    }

    @Override
    public List<Film> getAllByRateDate(Date rateDate) {
        return ((FilmDao)abstractDao).getAllByRateDate(rateDate);
    }
}
