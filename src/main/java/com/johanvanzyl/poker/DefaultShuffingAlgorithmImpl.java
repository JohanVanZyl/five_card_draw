package com.johanvanzyl.poker;

import java.util.List;
import java.util.Collections;

public class DefaultShuffingAlgorithmImpl implements ShufflingAlgorithm {

    @Override
    public void shuffle(List<Card> cards) {
        Collections.shuffle(cards);
    }
    
}
