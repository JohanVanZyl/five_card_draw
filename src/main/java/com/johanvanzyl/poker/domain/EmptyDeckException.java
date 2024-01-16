package com.johanvanzyl.poker.domain;

public class EmptyDeckException extends java.util.NoSuchElementException {

    public EmptyDeckException(String message) {
        super(message);
    }
}
