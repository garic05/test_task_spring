package com.example.servlet;

import com.example.servlet.dao.FilmDao;
import net.sf.ehcache.CacheManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServletApplicationTests {
    @Autowired
    private FilmDao filmDao;
    @Test
    void testCache() {
        Assertions.assertEquals(0, getFilmCache());
        filmDao.findAll();
        Assertions.assertNotEquals(0, getFilmCache());
    }

    private int getFilmCache() {
        return CacheManager.ALL_CACHE_MANAGERS.get(0)
                .getCache("com.example.servlet.model.Film").getSize();
    }
}