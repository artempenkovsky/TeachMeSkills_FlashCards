package by.teachmeskills.penkovsky.services;

import by.teachmeskills.penkovsky.models.FlashCard;
import by.teachmeskills.penkovsky.models.FlashCardSet;

import java.util.List;

    public interface FlashCardService {
        List<FlashCardSet> getAllCards();
        List<FlashCard> getCards();

    }
