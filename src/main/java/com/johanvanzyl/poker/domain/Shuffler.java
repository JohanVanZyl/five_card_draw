package com.johanvanzyl.poker.domain;

import java.util.List;

public interface Shuffler {
    public boolean shuffle(List<Card> cards);
}
