package by.teachmeskills.penkovsky.models;

import java.util.List;

public class FlashCardSet {
    private Integer id;
    private String title;
    private int countOfCard;
    private int countOfLearnedCard;
    private List<FlashCard> flashCardList;


    public FlashCardSet(Integer id, String title, int countOfCard, int countOfLearnedCard) {
        this.id = id;
        this.title = title;
        this.countOfCard = countOfCard;
        this.countOfLearnedCard = countOfLearnedCard;
    }

    public FlashCardSet(Integer id) {
        this.id = id;
    }

    public int getCountOfCard() {
        return countOfCard;
    }

    public void setCountOfCard(int countOfCard) {
        this.countOfCard = countOfCard;
    }

    public int getCountOfLearnedCard() {
        return countOfLearnedCard;
    }

    public void setCountOfLearnedCard(int countOfLearnedCard) {
        this.countOfLearnedCard = countOfLearnedCard;
    }

    public FlashCardSet() {
    }

    public FlashCardSet(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public FlashCardSet(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FlashCard> getFlashCardList() {
        return flashCardList;
    }

    public void setFlashCardList(List<FlashCard> flashCardList) {
        this.flashCardList = flashCardList;
    }

    @Override
    public String toString() {
        return "FlashCardSet{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", countOfCard=" + countOfCard +
                ", countOfLearnedCard=" + countOfLearnedCard +
                ", flashCardList=" + flashCardList +
                '}';
    }
}
