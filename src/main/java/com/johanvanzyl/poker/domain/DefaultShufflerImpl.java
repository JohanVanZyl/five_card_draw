package com.johanvanzyl.poker.domain;

import java.util.List;
import java.util.Collections;

public class DefaultShufflerImpl implements Shuffler {

    @Override
    public boolean shuffle(List<Card> cards) {
        List<Card> unshuffledList = List.copyOf(cards); 
        Collections.shuffle(cards);
       
        return !unshuffledList.equals(unshuffledList);
    }
    
}
