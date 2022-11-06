package com.springbootmaven.hi.parser;

public interface Parser<T> {
    T parse(String str);
}

