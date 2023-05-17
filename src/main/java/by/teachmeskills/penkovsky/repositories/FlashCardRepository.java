package by.teachmeskills.penkovsky.repositories;

import by.teachmeskills.penkovsky.models.FlashCard;
import by.teachmeskills.penkovsky.models.FlashCardSet;

import java.util.List;

public interface FlashCardRepository {
    List<FlashCardSet> getFlashCardSet();
    List<FlashCard> getCards();
}
