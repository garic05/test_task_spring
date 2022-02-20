package com.example.consoleapp.config;


import com.example.consoleapp.converter.FilmConverter;
import com.example.consoleapp.converter.HtmlToJsoupElementsConverter;
import com.example.consoleapp.dao.FilmDao;
import com.example.consoleapp.request.Requester;
import com.example.consoleapp.request.RequesterImpl;
import com.example.consoleapp.service.FilmService;
import com.example.consoleapp.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {

    @Bean
    @Qualifier("RequesterImpl")
    public Requester<String> filmRequester() {
        return new RequesterImpl();
    }

    @Bean
    @Qualifier("FilmConverter")
    public FilmConverter filmConverter() {
        return new FilmConverter();
    }

    @Bean
    @Qualifier("HtmlConverter")
    public HtmlToJsoupElementsConverter htmlConverter() {
        return new HtmlToJsoupElementsConverter();
    }

    @Bean
    @Qualifier("FilmService")
    public FilmService filmService(FilmDao filmDao) {
        return new FilmServiceImpl(filmDao);
    }
}
