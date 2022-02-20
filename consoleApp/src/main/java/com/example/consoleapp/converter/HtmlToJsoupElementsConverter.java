package com.example.consoleapp.converter;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

public class HtmlToJsoupElementsConverter extends AbstractConverter<String, List<Element>> {
    private static final String EXTERNAL_FILM_CLASS = "desktop-rating-selection-film-item";

    @Override
    public List<Element> convert(String html) {
        Document document = Jsoup.parse(html);
        return document.getElementsByClass(EXTERNAL_FILM_CLASS);
    }
}
