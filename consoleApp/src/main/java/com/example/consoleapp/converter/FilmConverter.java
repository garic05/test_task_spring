package com.example.consoleapp.converter;

import com.example.consoleapp.model.Film;
import org.jsoup.nodes.Element;

import java.sql.Date;

public class FilmConverter extends AbstractConverter<Element, Film>{
    private static final String RATING_COUNT_CLASS = "rating__count";
    private static final String FILM_NAME_CLASS = "selection-film-item-meta__name";
    private static final String RATE_CLASS = "rating__value rating__value_positive";
    private static final String YEAR_CLASS = "selection-film-item-meta__original-name";

    @Override
    public Film convert(Element element) {
        Film film = new Film();
        film.setCntVoters(Long.parseLong(element.getElementsByClass(RATING_COUNT_CLASS).get(0).text().replaceAll("\\s+","")));
        film.setName(element.getElementsByClass(FILM_NAME_CLASS).get(0).text());
        film.setRate(Float.valueOf(element.getElementsByClass(RATE_CLASS).get(0).text().replaceAll("\\s+","")));
        String year = element.getElementsByClass(YEAR_CLASS).get(0).text().replaceAll("\\s+","");
        film.setYear(Integer.valueOf(year.substring(year.length()-4)));
        film.setRateDate(new Date(new java.util.Date().getTime()));
        return film;
    }
}
