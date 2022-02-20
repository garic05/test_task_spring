package com.example.consoleapp.request;

import org.springframework.web.client.RestTemplate;

public class RequesterImpl implements Requester<String> {

    @Override
    public String request(String URL) {
        return new RestTemplate().getForEntity(URL, String.class).getBody();
    }
}
