package com.example.servlet.controller;

import com.example.servlet.dao.FilmDao;
import com.example.servlet.model.Film;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BaseController {
    private final FilmDao filmDao;

    public BaseController(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @RequestMapping(value = "/")
    public String basePath(Model model,
                           @Nullable @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        if (date == null) {
            date = new Date();
        }
        model.addAttribute("films_rate_date", new SimpleDateFormat("dd-MM-yyyy").format(date));
        List<Film> films = filmDao.getAllByRateDate(new java.sql.Date(date.getTime()));
        model.addAttribute("films", films);
        return "index";
    }


}
