package by.teachmeskills.penkovsky.repositories;

import by.teachmeskills.penkovsky.models.FlashCard;
import by.teachmeskills.penkovsky.models.FlashCardSet;

import java.util.List;
import java.util.Optional;

public interface FlashCardRepository {
    List<FlashCardSet> getFlashCardSet();
    List<FlashCard> getCards();
    List<FlashCard> getFlashCardBySetId(Integer id);
    Optional<FlashCard> getCardByIdAndOffset(int flashCardSetId, int offset);
    void addFlashCardSet(FlashCardSet flashCardSet);

    void addFlashCard(FlashCard flashCard);

    void deleteFlashCard(FlashCard flashCard1);

    void updateFlashCard(FlashCard flashCard2);

    void deleteFlashCardSet(FlashCardSet flashCardSet1);

}
