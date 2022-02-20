package com.example.consoleapp;


import com.example.consoleapp.converter.FilmConverter;
import com.example.consoleapp.converter.HtmlToJsoupElementsConverter;
import com.example.consoleapp.model.Film;
import com.example.consoleapp.request.Requester;
import com.example.consoleapp.service.FilmService;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.sql.Date;
import java.util.List;


@SpringBootApplication
public class ConsoleApplication {
    private final FilmService filmService;
    private final Requester<String> requester;
    private final FilmConverter filmConverter;
    private final HtmlToJsoupElementsConverter htmlConverter;

    private final String URL;

    public ConsoleApplication(@Qualifier("FilmService") FilmService filmService,
                                           @Qualifier("RequesterImpl") Requester<String> requester,
                                           @Qualifier("FilmConverter") FilmConverter filmConverter,
                                           @Qualifier("HtmlConverter") HtmlToJsoupElementsConverter htmlConverter,
                                           @Value("${kinopoisk.url}") String URL) {
        this.filmService = filmService;
        this.requester = requester;
        this.filmConverter = filmConverter;
        this.htmlConverter = htmlConverter;
        this.URL = URL;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        List<Film> filmsToday = filmService.getAllByRateDate(new Date(new java.util.Date().getTime()));
        if (filmsToday == null || filmsToday.isEmpty()) {
            String s = requester.request(URL);
            List<Element> elements = htmlConverter.convert(s);
            List<Film> films = filmConverter.convert(elements);
            filmService.saveAllAndFlush(films.subList(0, 10));
        }
    }

}
