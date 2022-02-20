package com.example.consoleapp.converter;

import java.util.List;

public interface Converter<IN, OUT> {
    OUT convert(IN in);

    List<OUT> convert(List<IN> in);
}
