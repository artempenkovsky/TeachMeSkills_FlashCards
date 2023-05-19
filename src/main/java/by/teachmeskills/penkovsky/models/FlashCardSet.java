package by.teachmeskills.penkovsky.models;

import java.util.List;

public class FlashCardSet {
    private Integer id;
    private String title;
    private List<FlashCard> flashCardList;

    public FlashCardSet(Integer id, String title, List<FlashCard> flashCardList) {
        this.id = id;
        this.title = title;
        this.flashCardList = flashCardList;
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
        return "FlashCardSet{" + "id=" + id + ", title='" + title + '\'' + ", flashCardList=" + flashCardList + '}';
    }

    public FlashCardSet() {
    }

    public FlashCardSet(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
