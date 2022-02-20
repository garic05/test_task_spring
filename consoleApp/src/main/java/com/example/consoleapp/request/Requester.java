package com.example.consoleapp.request;

public interface Requester<T> {
    T request(String URL);
}
