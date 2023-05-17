package by.teachmeskills.penkovsky.services.impl;

import by.teachmeskills.penkovsky.models.FlashCard;
import by.teachmeskills.penkovsky.models.FlashCardSet;
import by.teachmeskills.penkovsky.repositories.FlashCardRepository;
import by.teachmeskills.penkovsky.repositories.impl.FlashCardRepositoryImpl;
import by.teachmeskills.penkovsky.services.FlashCardService;

import java.util.List;

public class FlashCardServiceImpl implements FlashCardService {
    @Override
    public List<FlashCardSet> getAllCards() {
        FlashCardRepository flashCardRepository = new FlashCardRepositoryImpl();
        List<FlashCardSet> flashCardSets = flashCardRepository.getFlashCardSet();
        return flashCardSets;
    }

    @Override
    public List<FlashCard> getCards() {
        FlashCardRepository cardRepository = new FlashCardRepositoryImpl();
        List <FlashCard> flashCardList = cardRepository.getCards();
        return flashCardList;
    }

}

