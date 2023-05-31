package by.teachmeskills.penkovsky.repositories.impl;

import by.teachmeskills.penkovsky.dataSource.MyHikariDataSource;
import by.teachmeskills.penkovsky.models.FlashCard;
import by.teachmeskills.penkovsky.models.FlashCardSet;
import by.teachmeskills.penkovsky.repositories.FlashCardRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlashCardRepositoryImpl implements FlashCardRepository {
    private final MyHikariDataSource myHikariDataSource;

    public FlashCardRepositoryImpl(MyHikariDataSource myHikariDataSource) {
        this.myHikariDataSource = myHikariDataSource;
    }

    @Override
    public List<FlashCardSet> getFlashCardSet() {
        List<FlashCardSet> flashCardSetList = new ArrayList<>();
        try (Connection connection = myHikariDataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT flashcard_set.id                                          AS id,
                           flashcard_set.title                                       AS title,
                           count(flashcard.id)    FILTER ( WHERE flashcard.learned ) AS learned_flashcard_count,
                            count(flashcard.id)                                      AS total_flashcards_count
                    FROM flashcard_set
                             LEFT JOIN flashcard ON flashcard_set.id = flashcard.set_id
                    GROUP BY flashcard_set.id;
                    """);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titlePoolCard = resultSet.getString("title");
                int countOfCard = resultSet.getInt("total_flashcards_count");
                int countOfLearnedCard = resultSet.getInt("learned_flashcard_count");
                FlashCardSet flashCardSet = new FlashCardSet(id, titlePoolCard, countOfCard, countOfLearnedCard);
                flashCardSetList.add(flashCardSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flashCardSetList;
    }

    @Override
    public List<FlashCard> getCards() {
        List<FlashCard> flashCardList = new ArrayList<>();
        try {
            Connection connection = myHikariDataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.flashcard");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titleCard = resultSet.getString("title_cards");
                String question = resultSet.getString("question");
                String answer = resultSet.getString("answer");
                Boolean active = resultSet.getBoolean("learned");
                Integer poolCardId = resultSet.getInt("set_id");
                FlashCard flashcard = new FlashCard(id, titleCard, question, answer, active, poolCardId);
                flashCardList.add(flashcard);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flashCardList;
    }

    @Override
    public List<FlashCard> getFlashCardBySetId(Integer idSet) {
        List<FlashCard> flashCardList = new ArrayList<>();
        try (Connection connection = myHikariDataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.flashcard WHERE set_id=?;");
            statement.setInt(1, idSet);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titleCard = resultSet.getString("title_cards");
                String question = resultSet.getString("question");
                String answer = resultSet.getString("answer");
                Boolean active = resultSet.getBoolean("learned");
                Integer poolCardId = resultSet.getInt("set_id");
                FlashCard flashcard = new FlashCard(id, titleCard, question, answer, active, poolCardId);
                flashCardList.add(flashcard);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flashCardList;
    }

    @Override
    public Optional<FlashCard> getCardByIdAndOffset(int flashCardSetId, int offset) {
        FlashCard flashCard = new FlashCard();
        try (Connection connection = myHikariDataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT flashcard.id       AS id,
                           flashcard.question AS question,
                           flashcard.answer   AS answer,
                           flashcard.learned  AS learned
                    FROM flashcard
                    WHERE flashcard.set_id = ?
                      AND NOT flashcard.learned
                      AND flashcard.id > ?
                    ORDER BY flashcard.id 
                    LIMIT 1;
                    """);
            statement.setInt(1, flashCardSetId);
            statement.setInt(2, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                //String titleCard = resultSet.getString("title_cards");
                String question = resultSet.getString("question");
                String answer = resultSet.getString("answer");
                Boolean active = resultSet.getBoolean("learned");
                //Integer poolCardId = resultSet.getInt("set_id");
                flashCard = new FlashCard(id, question, answer, active);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(flashCard);
    }


        @Override
        public void addFlashCardSet (FlashCardSet flashCardSet){
            try (Connection connection = myHikariDataSource.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO flashcard_set (title)
                    VALUES (?);
                    """);
            statement.setString(1, flashCardSet.getTitle());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addFlashCard(FlashCard flashCard) {
        try (Connection connection = myHikariDataSource.getConnection()) {

            PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO flashcard (set_id, question, answer, learned, title_cards)
                    VALUES (?, ?, ?, ?, ?);
                    """);
            statement.setInt(1, flashCard.getSetID());
            statement.setString(2, flashCard.getQuestion());
            statement.setString(3, flashCard.getAnswer());
            statement.setBoolean(4, flashCard.isLearned());
            statement.setString(5, flashCard.getTittleFlashCard());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteFlashCard(FlashCard flashCard1) {
        try (Connection connection = myHikariDataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    DELETE
                    FROM flashcard
                    WHERE flashcard.id = ?;
                    """);
            statement.setInt(1, flashCard1.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateFlashCard(FlashCard flashCard2) {
        try (Connection connection = myHikariDataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    UPDATE public.flashcard
                    SET learned = true
                    WHERE id =?;
                    """);
            statement.setInt(1, flashCard2.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteFlashCardSet(FlashCardSet flashCardSet1) {
        try (Connection connection = myHikariDataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("""
                    DELETE
                    FROM flashcard_set
                    WHERE flashcard_set.id = ?;
                    """);
            statement.setInt(1, flashCardSet1.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



