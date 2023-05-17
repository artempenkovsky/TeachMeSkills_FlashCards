package by.teachmeskills.penkovsky.models;

public class FlashCard {
    private Integer id;
    private String tittleFlashCard;
    private String question;
    private String answer;
    private boolean learned;
    private Integer setID;

    public FlashCard(Integer id, String tittleFlashCard, String question, String answer, boolean learned, Integer setID) {
        this.id = id;
        this.tittleFlashCard = tittleFlashCard;
        this.question = question;
        this.answer = answer;
        this.learned = learned;
        this.setID = setID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittleFlashCard() {
        return tittleFlashCard;
    }

    public void setTittleFlashCard(String tittleFlashCard) {
        this.tittleFlashCard = tittleFlashCard;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isLearned() {
        return learned;
    }

    public void setLearned(boolean learned) {
        this.learned = learned;
    }

    public Integer getSetID() {
        return setID;
    }

    public void setSetID(Integer setID) {
        this.setID = setID;
    }

    @Override
    public String toString() {
        return "FlashCard{" +
                "id=" + id +
                ", tittleFlashCard='" + tittleFlashCard + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", learned=" + learned +
                ", setID=" + setID +
                '}';
    }
    public FlashCard() {

    }
}
