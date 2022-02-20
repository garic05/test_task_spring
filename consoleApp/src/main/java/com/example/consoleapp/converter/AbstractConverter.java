package com.example.consoleapp.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<IN, OUT> implements Converter<IN, OUT> {
    @Override
    public List<OUT> convert(List<IN> in) {
        return in.stream().map(this::convert).collect(Collectors.toList());
    }
}
