package by.teachmeskills.penkovsky.services;

import by.teachmeskills.penkovsky.models.FlashCard;
import by.teachmeskills.penkovsky.models.FlashCardSet;

import java.util.List;

    public interface FlashCardService {
        List<FlashCardSet> getAllCards();
        List<FlashCard> getCards();
        void addFlashCardSet(FlashCardSet flashCardSet);
        void addFlashCard(FlashCard flashCard);

        void deleteFlashCard(FlashCard flashCard1);

        void updateFlashCard(FlashCard flashCard2);

        void deleteFlashCardSet(FlashCardSet flashCardSet1);
        FlashCard getCardByIdAndOffset(int flashCardSetId, int offset);
    }
