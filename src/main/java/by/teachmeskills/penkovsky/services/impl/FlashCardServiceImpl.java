package by.teachmeskills.penkovsky.services.impl;

import by.teachmeskills.penkovsky.models.FlashCard;
import by.teachmeskills.penkovsky.models.FlashCardSet;
import by.teachmeskills.penkovsky.repositories.FlashCardRepository;
import by.teachmeskills.penkovsky.repositories.impl.FlashCardRepositoryImpl;
import by.teachmeskills.penkovsky.services.FlashCardService;

import java.util.List;
import java.util.Optional;

public class FlashCardServiceImpl implements FlashCardService {
    private by.teachmeskills.penkovsky.dataSource.MyHikariDataSource MyHikariDataSource;
    FlashCardRepository flashCardRepository = new FlashCardRepositoryImpl(MyHikariDataSource);

    @Override
    public List<FlashCardSet> getAllCards() {
        List<FlashCardSet> flashCardSets = flashCardRepository.getFlashCardSet();
        for (FlashCardSet set : flashCardSets) {
            Integer idSet = set.getId();
            List<FlashCard> flashCardBySetId = flashCardRepository.getFlashCardBySetId(idSet);
            set.setFlashCardList(flashCardBySetId);
        }
        return flashCardSets;
    }

    @Override
    public List<FlashCard> getCards() {
        List<FlashCard> flashCardList = flashCardRepository.getCards();
        return flashCardList;
    }

    @Override
    public void addFlashCardSet(FlashCardSet flashCardSet) {
        flashCardRepository.addFlashCardSet(flashCardSet);
    }

    @Override
    public void addFlashCard(FlashCard flashCard) {
        flashCardRepository.addFlashCard(flashCard);
    }

    @Override
    public void deleteFlashCard(FlashCard flashCard1) {
        flashCardRepository.deleteFlashCard(flashCard1);
    }

    @Override
    public void updateFlashCard(FlashCard flashCard2) {
        flashCardRepository.updateFlashCard(flashCard2);
    }
    @Override
    public void deleteFlashCardSet(FlashCardSet flashCardSet1) {
        flashCardRepository.deleteFlashCardSet(flashCardSet1);
    }

    @Override
    public FlashCard getCardByIdAndOffset(int flashCardSetId, int offset) {
        Optional<FlashCard> cardByIdAndOffset = flashCardRepository.getCardByIdAndOffset(flashCardSetId, offset);
        return cardByIdAndOffset.orElse(new FlashCard());
    }

}

